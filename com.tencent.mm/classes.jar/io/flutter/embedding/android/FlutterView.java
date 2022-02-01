package io.flutter.embedding.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.a.a;
import io.flutter.embedding.engine.b.a.c;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.h;
import io.flutter.embedding.engine.c.h.a;
import io.flutter.view.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FlutterView
  extends FrameLayout
{
  private final Set<io.flutter.embedding.engine.b.b> IXH;
  private b IXM;
  private FlutterView.c IXN;
  boolean IXO;
  final Set<a> IXP;
  private a IXQ;
  private b IXR;
  private io.flutter.view.a IXS;
  private final a.c IXT;
  private final a.e IXU;
  private io.flutter.a.b.b IXb;
  private final io.flutter.embedding.engine.b.b rdC;
  private io.flutter.embedding.engine.a rdu;
  private a.a renderSurface;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null, null);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, b paramb, FlutterView.c paramc)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9986);
    this.IXH = new HashSet();
    this.IXP = new HashSet();
    this.IXT = new a.c();
    this.IXU = new a.e()
    {
      public final void aR(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.rdC = new io.flutter.embedding.engine.b.b()
    {
      public final void onFirstFrameRendered()
      {
        AppMethodBeat.i(10059);
        FlutterView.a(FlutterView.this);
        Iterator localIterator = FlutterView.b(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).onFirstFrameRendered();
        }
        AppMethodBeat.o(10059);
      }
    };
    paramContext = paramb;
    if (paramb == null) {
      paramContext = b.IXX;
    }
    this.IXM = paramContext;
    if (paramc != null)
    {
      this.IXN = paramc;
      io.flutter.a.ftS();
      switch (3.IXW[this.IXM.ordinal()])
      {
      }
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      AppMethodBeat.o(9986);
      return;
      paramc = FlutterView.c.IYa;
      break;
      io.flutter.a.ftS();
      paramContext = getContext();
      if (this.IXN == FlutterView.c.IYb) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext = new FlutterSurfaceView(paramContext, bool);
        this.renderSurface = paramContext;
        addView(paramContext);
        break;
      }
      io.flutter.a.ftS();
      paramContext = new FlutterTextureView(getContext());
      this.renderSurface = paramContext;
      addView(paramContext);
    }
  }
  
  public FlutterView(Context paramContext, b paramb)
  {
    this(paramContext, null, paramb, null);
  }
  
  public FlutterView(Context paramContext, b paramb, FlutterView.c paramc)
  {
    this(paramContext, null, paramb, paramc);
  }
  
  private void aQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!FlutterJNI.nativeGetIsSoftwareRenderingEnabled())
    {
      boolean bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (!paramBoolean2) {
          bool1 = true;
        }
      }
      setWillNotDraw(bool1);
      AppMethodBeat.o(10000);
      return;
    }
    setWillNotDraw(false);
    AppMethodBeat.o(10000);
  }
  
  private void fuy()
  {
    AppMethodBeat.i(10006);
    if (!fux())
    {
      io.flutter.a.ftU();
      AppMethodBeat.o(10006);
      return;
    }
    this.rdu.IYn.fva().bT(getResources().getConfiguration().fontScale).xQ(DateFormat.is24HourFormat(getContext())).send();
    AppMethodBeat.o(10006);
  }
  
  private void fuz()
  {
    AppMethodBeat.i(10007);
    if (!fux())
    {
      io.flutter.a.ftU();
      AppMethodBeat.o(10007);
      return;
    }
    this.IXT.IZi = getResources().getDisplayMetrics().density;
    this.rdu.IXd.a(this.IXT);
    AppMethodBeat.o(10007);
  }
  
  private void i(Configuration paramConfiguration)
  {
    AppMethodBeat.i(10005);
    if (!fux())
    {
      io.flutter.a.ftU();
      AppMethodBeat.o(10005);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramConfiguration = paramConfiguration.getLocales();
      int j = paramConfiguration.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramConfiguration.get(i));
        i += 1;
      }
    }
    localArrayList.add(paramConfiguration.locale);
    this.rdu.IYj.it(localArrayList);
    AppMethodBeat.o(10005);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10004);
    this.IXP.add(parama);
    AppMethodBeat.o(10004);
  }
  
  public final void addOnFirstFrameRenderedListener(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(9987);
    this.IXH.add(paramb);
    AppMethodBeat.o(9987);
  }
  
  public final void b(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10001);
    new StringBuilder("Attaching to a FlutterEngine: ").append(parama);
    io.flutter.a.ftT();
    if (fux())
    {
      if (parama == this.rdu)
      {
        io.flutter.a.ftT();
        AppMethodBeat.o(10001);
        return;
      }
      io.flutter.a.ftT();
      fuw();
    }
    this.rdu = parama;
    io.flutter.embedding.engine.b.a locala = this.rdu.IXd;
    this.IXO = locala.IZe;
    locala.b(this.renderSurface);
    locala.addOnFirstFrameRenderedListener(this.rdC);
    this.IXb = new io.flutter.a.b.b(this, this.rdu.IYe, this.rdu.IYq);
    this.IXQ = new a(this.rdu.IXa, this.IXb);
    this.IXR = new b(this.rdu.IXd);
    this.IXS = new io.flutter.view.a(this, parama.IYh, (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.rdu.IYq);
    this.IXS.IXU = this.IXU;
    aQ(this.IXS.kI.isEnabled(), this.IXS.kI.isTouchExplorationEnabled());
    this.rdu.IYq.a(this.IXS);
    this.IXb.JbG.restartInput(this);
    fuy();
    i(getResources().getConfiguration());
    fuz();
    parama = this.IXP.iterator();
    while (parama.hasNext()) {
      ((a)parama.next()).fus();
    }
    if (this.IXO) {
      this.rdC.onFirstFrameRendered();
    }
    AppMethodBeat.o(10001);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.rdu != null)
    {
      bool = this.rdu.IYq.checkInputConnectionProxy(paramView);
      AppMethodBeat.o(9993);
      return bool;
    }
    boolean bool = super.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9993);
    return bool;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9991);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.IXT.paddingTop = paramRect.top;
      this.IXT.paddingRight = paramRect.right;
      this.IXT.paddingBottom = 0;
      this.IXT.paddingLeft = paramRect.left;
      this.IXT.IZj = 0;
      this.IXT.IZk = 0;
      this.IXT.IZl = paramRect.bottom;
      this.IXT.IZm = 0;
      new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.IXT.paddingTop).append(", Left: ").append(this.IXT.paddingLeft).append(", Right: ").append(this.IXT.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.IXT.IZl).append(", Left: ").append(this.IXT.IZm).append(", Right: ").append(this.IXT.IZk);
      io.flutter.a.ftS();
      fuz();
      AppMethodBeat.o(9991);
      return true;
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(9991);
    return bool;
  }
  
  public final void fuw()
  {
    AppMethodBeat.i(10002);
    new StringBuilder("Detaching from a FlutterEngine: ").append(this.rdu);
    io.flutter.a.ftT();
    if (!fux())
    {
      io.flutter.a.ftT();
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.IXP.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.rdu.IYq.fvg();
    this.IXS.release();
    this.IXS = null;
    this.IXb.JbG.restartInput(this);
    this.IXb.IYq.IXb = null;
    localObject = this.rdu.IXd;
    this.IXO = false;
    ((io.flutter.embedding.engine.b.a)localObject).removeOnFirstFrameRenderedListener(this.rdC);
    ((io.flutter.embedding.engine.b.a)localObject).fuR();
    this.rdu = null;
    AppMethodBeat.o(10002);
  }
  
  public final boolean fux()
  {
    AppMethodBeat.i(10003);
    if ((this.rdu != null) && (this.rdu.IXd.a(this.renderSurface)))
    {
      AppMethodBeat.o(10003);
      return true;
    }
    AppMethodBeat.o(10003);
    return false;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(9999);
    if ((this.IXS != null) && (this.IXS.kI.isEnabled()))
    {
      io.flutter.view.a locala = this.IXS;
      AppMethodBeat.o(9999);
      return locala;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public io.flutter.embedding.engine.a getAttachedFlutterEngine()
  {
    return this.rdu;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    io.flutter.a.ftS();
    i(paramConfiguration);
    fuy();
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!fux())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.IXb.a(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((fux()) && (this.IXR.onGenericMotionEvent(paramMotionEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(9997);
      return true;
    }
    boolean bool = super.onGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(9997);
    return bool;
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9998);
    if (!fux())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.IXS.an(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9995);
    if (!fux())
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(9995);
      return bool;
    }
    this.IXQ.j(paramKeyEvent);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(9995);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9994);
    if (!fux())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(9994);
      return bool;
    }
    this.IXQ.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9994);
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(paramInt3).append(" x ").append(paramInt4).append(", it is now ").append(paramInt1).append(" x ").append(paramInt2);
    io.flutter.a.ftS();
    this.IXT.width = paramInt1;
    this.IXT.height = paramInt2;
    fuz();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!fux())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.IXR.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public final void removeOnFirstFrameRenderedListener(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(9988);
    this.IXH.remove(paramb);
    AppMethodBeat.o(9988);
  }
  
  public static abstract interface a
  {
    public abstract void fus();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(10024);
      IXX = new b("surface", 0);
      IXY = new b("texture", 1);
      IXZ = new b[] { IXX, IXY };
      AppMethodBeat.o(10024);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */