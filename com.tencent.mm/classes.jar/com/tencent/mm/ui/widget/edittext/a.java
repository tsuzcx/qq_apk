package com.tencent.mm.ui.widget.edittext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.av;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private ViewTreeObserver.OnPreDrawListener Bl;
  boolean BpG;
  private View.OnLayoutChangeListener OCV;
  private Spannable QGC;
  private Menu QLC;
  Map<Integer, CharSequence> QLD;
  int[] QLE;
  public e QLI;
  b QOY;
  b QOZ;
  private f QPa;
  g QPb;
  private ViewTreeObserver.OnScrollChangedListener QPc;
  private View.OnAttachStateChangeListener QPd;
  public View.OnLongClickListener QPe;
  public View.OnTouchListener QPf;
  public View.OnFocusChangeListener QPg;
  public View.OnClickListener QPh;
  private int QPi;
  int QPj;
  int QPk;
  boolean QPl;
  int QPm;
  boolean QPn;
  boolean QPo;
  int QPp;
  int QPq;
  a QPr;
  boolean QPs;
  private ActionMode.Callback QPt;
  int QPu;
  final Runnable QPv;
  TextView Ws;
  private TextWatcher aws;
  boolean eea;
  Context mContext;
  public boolean mIsPause;
  int ovq;
  
  private a(a parama)
  {
    AppMethodBeat.i(198331);
    this.QPb = new g();
    this.eea = true;
    this.QPn = false;
    this.QPo = false;
    this.QLD = new HashMap();
    this.QLE = new int[2];
    this.QPt = new ActionMode.Callback()
    {
      public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
      
      public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        AppMethodBeat.i(198302);
        as.d("SelectableEditTextHelper", "mDisableCallback", new Object[0]);
        a.this.g(paramAnonymousMenu);
        AppMethodBeat.o(198302);
        return false;
      }
      
      public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
      
      public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    };
    this.QPu = -1;
    this.QPv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198303);
        if (a.this.eea)
        {
          AppMethodBeat.o(198303);
          return;
        }
        a.a(a.this.hbx());
        a.this.a(a.this.QOY);
        a.this.a(a.this.QOZ);
        AppMethodBeat.o(198303);
      }
    };
    this.mIsPause = false;
    this.QPr = parama;
    this.Ws = parama.Ws;
    this.mContext = this.Ws.getContext();
    this.QPi = this.mContext.getResources().getColor(parama.QPi);
    this.QPj = this.mContext.getResources().getColor(parama.QPj);
    this.QPk = at.fromDPToPix(this.mContext, (int)parama.QPx);
    this.QPm = com.tencent.mm.ui.widget.textview.b.hD(this.Ws);
    this.BpG = parama.BpG;
    if ((Build.VERSION.SDK_INT >= 29) && ((av.isMIUI()) || (av.gKb()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.QPs = bool;
      as.i("SelectableEditTextHelper", "init %s,%s,%s", new Object[] { Boolean.valueOf(this.BpG), this.QPr.QPz, Build.BRAND });
      this.Ws.setText(this.Ws.getText(), TextView.BufferType.SPANNABLE);
      this.QGC = ((Spannable)this.Ws.getText());
      this.Ws.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198300);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          if (a.this.QPe != null) {}
          for (boolean bool = a.this.QPe.onLongClick(paramAnonymousView);; bool = false)
          {
            if (a.this.BpG)
            {
              as.i("SelectableEditTextHelper", "onLongClick:" + a.this.QPn, new Object[0]);
              paramAnonymousView = a.this;
              if ((!TextUtils.isEmpty(Build.BRAND)) && ("vivo".equals(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT < 23)) {
                paramAnonymousView.Ws.post(new a.2(paramAnonymousView));
              }
              if (a.this.QPn)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(198300);
                return false;
              }
              a.this.QPo = true;
              a.this.O(a.this.QPp, a.this.QPq, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(198300);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(198300);
            return bool;
          }
        }
      });
      this.Ws.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198304);
          if (a.this.QPf != null) {}
          for (boolean bool = a.this.QPf.onTouch(paramAnonymousView, paramAnonymousMotionEvent);; bool = false)
          {
            if (a.this.BpG)
            {
              a.this.QPp = ((int)paramAnonymousMotionEvent.getX());
              a.this.QPq = ((int)paramAnonymousMotionEvent.getY());
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
              do
              {
                for (;;)
                {
                  a.this.ovq = a.this.Ws.getScrollY();
                  AppMethodBeat.o(198304);
                  return false;
                  a.this.QPo = false;
                  if (a.this.QPs)
                  {
                    a.E(a.this.Ws);
                    a.this.QPs = false;
                  }
                  paramAnonymousView = a.this;
                  try
                  {
                    as.d("SelectableEditTextHelper", "setInsertionDisabled", new Object[0]);
                    paramAnonymousMotionEvent = TextView.class.getDeclaredField("mEditor");
                    paramAnonymousMotionEvent.setAccessible(true);
                    paramAnonymousView = paramAnonymousMotionEvent.get(paramAnonymousView.Ws);
                    paramAnonymousMotionEvent = Class.forName("android.widget.Editor");
                    Field localField = paramAnonymousMotionEvent.getDeclaredField("mInsertionControllerEnabled");
                    localField.setAccessible(true);
                    localField.set(paramAnonymousView, Boolean.FALSE);
                    paramAnonymousMotionEvent = paramAnonymousMotionEvent.getDeclaredField("mSelectionControllerEnabled");
                    paramAnonymousMotionEvent.setAccessible(true);
                    paramAnonymousMotionEvent.set(paramAnonymousView, Boolean.FALSE);
                  }
                  catch (Exception paramAnonymousView)
                  {
                    as.e("SelectableEditTextHelper", "setInsertionDisabled error msg:%s", new Object[] { paramAnonymousView.getMessage() });
                  }
                  continue;
                  if ((av.isMIUI()) && (a.this.QPo))
                  {
                    AppMethodBeat.o(198304);
                    return true;
                  }
                  if (a.this.ovq != a.this.Ws.getScrollY())
                  {
                    a.this.QPn = true;
                    if ((!a.this.QPl) && (!a.this.eea))
                    {
                      a.this.QPl = true;
                      a.b(a.this.hbx());
                      a.b(a.this.QOY);
                      a.b(a.this.QOZ);
                    }
                  }
                }
              } while (!a.this.QPn);
              a.this.QPn = false;
              if (a.this.QPl)
              {
                a.this.QPl = false;
                a.this.QPv.run();
              }
              AppMethodBeat.o(198304);
              return true;
            }
            AppMethodBeat.o(198304);
            return bool;
          }
        }
      });
      this.Ws.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198305);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.this.BpG)
          {
            as.i("SelectableEditTextHelper", "onClick", new Object[0]);
            a.this.Dr(true);
          }
          if (a.this.QPh != null) {
            a.this.QPh.onClick(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198305);
        }
      });
      this.Ws.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198306);
          if (a.this.BpG)
          {
            as.d("SelectableEditTextHelper", "onFocusChange:".concat(String.valueOf(paramAnonymousBoolean)), new Object[0]);
            if (!paramAnonymousBoolean) {
              a.this.Dr(false);
            }
          }
          if (a.this.QPg != null) {
            a.this.QPg.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
          }
          AppMethodBeat.o(198306);
        }
      });
      if (this.BpG)
      {
        this.Ws.setCustomSelectionActionModeCallback(this.QPt);
        if (Build.VERSION.SDK_INT >= 23) {
          this.Ws.setCustomInsertionActionModeCallback(this.QPt);
        }
        this.aws = new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(198307);
            if (!a.this.eea)
            {
              a.this.hbA();
              a.this.hbz();
            }
            a.this.Ws.setCursorVisible(true);
            a.this.QPu = a.this.Ws.getSelectionStart();
            AppMethodBeat.o(198307);
          }
        };
        this.QPd = new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(198308);
            as.d("SelectableEditTextHelper", "onViewDetachedFromWindow:", new Object[0]);
            a.this.destroy();
            AppMethodBeat.o(198308);
          }
        };
        this.OCV = new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(198309);
            if (a.this.eea)
            {
              AppMethodBeat.o(198309);
              return;
            }
            paramAnonymousView = new int[2];
            paramAnonymousView[0] = a.this.QLE[0];
            paramAnonymousView[1] = a.this.QLE[1];
            a.this.Ws.getLocationInWindow(a.this.QLE);
            as.d("SelectableEditTextHelper", "LayoutChangeFromWindow l:%d,t:%d,r:%d,b:%d,oldl:%d,oldt:%d,oldr:%d,oldb:%d,oldx:%d, newx:%d, oldy:%d, newy:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), Integer.valueOf(paramAnonymousInt5), Integer.valueOf(paramAnonymousInt6), Integer.valueOf(paramAnonymousInt7), Integer.valueOf(paramAnonymousInt8), Integer.valueOf(paramAnonymousView[0]), Integer.valueOf(a.this.QLE[0]), Integer.valueOf(paramAnonymousView[1]), Integer.valueOf(a.this.QLE[1]) });
            if ((paramAnonymousInt2 != paramAnonymousInt6) || (paramAnonymousInt4 != paramAnonymousInt8) || (paramAnonymousView[1] != a.this.QLE[1])) {
              a.this.hby();
            }
            AppMethodBeat.o(198309);
          }
        };
        this.Bl = new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            return true;
          }
        };
        this.QPc = new ViewTreeObserver.OnScrollChangedListener()
        {
          public final void onScrollChanged() {}
        };
        this.Ws.addTextChangedListener(this.aws);
        this.Ws.addOnAttachStateChangeListener(this.QPd);
        this.Ws.addOnLayoutChangeListener(this.OCV);
        this.Ws.getViewTreeObserver().addOnPreDrawListener(this.Bl);
        this.Ws.getViewTreeObserver().addOnScrollChangedListener(this.QPc);
      }
      AppMethodBeat.o(198331);
      return;
    }
  }
  
  static boolean E(TextView paramTextView)
  {
    AppMethodBeat.i(198346);
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      paramTextView = ((Field)localObject).get(paramTextView);
      localObject = Class.forName("android.widget.Editor");
      localObject = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(localObject, new Object[] { "getEmailPopupWindow", null });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramTextView, new Object[0]);
      as.i("SelectableEditTextHelper", "getEmailPopupWindow succ", new Object[0]);
      AppMethodBeat.o(198346);
      return true;
    }
    catch (Throwable paramTextView)
    {
      as.e("SelectableEditTextHelper", "getEmailPopupWindow err:%s", new Object[] { paramTextView.getMessage() });
      AppMethodBeat.o(198346);
    }
    return false;
  }
  
  static void a(f paramf)
  {
    AppMethodBeat.i(198343);
    if (paramf != null) {
      try
      {
        paramf.show();
        AppMethodBeat.o(198343);
        return;
      }
      catch (Throwable paramf)
      {
        as.e("SelectableEditTextHelper", "show oper err：%s", new Object[] { Log.getStackTraceString(paramf) });
      }
    }
    AppMethodBeat.o(198343);
  }
  
  private static boolean a(TextView paramTextView, Menu paramMenu)
  {
    AppMethodBeat.i(198333);
    try
    {
      Object localObject1 = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject1).setAccessible(true);
      Object localObject3 = ((Field)localObject1).get(paramTextView);
      Class localClass2 = Class.forName("android.widget.Editor");
      Class localClass1 = Class.forName("android.widget.Editor$TextActionModeCallback");
      Object localObject2 = paramTextView.getTag(2131309018);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (Build.VERSION.SDK_INT < 28) {
          break label178;
        }
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Integer.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      for (localObject1 = ((Constructor)localObject1).newInstance(new Object[] { localObject3, Integer.valueOf(1) });; localObject1 = ((Constructor)localObject1).newInstance(new Object[] { localObject3, Boolean.FALSE }))
      {
        localObject2 = localClass1.getDeclaredMethod("populateMenuWithItems", new Class[] { Menu.class });
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject2).invoke(localObject1, new Object[] { paramMenu });
        paramTextView.setTag(2131309018, localObject1);
        as.i("SelectableEditTextHelper", "populateMenuItems succ", new Object[0]);
        AppMethodBeat.o(198333);
        return true;
        label178:
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Boolean.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      return false;
    }
    catch (Throwable paramTextView)
    {
      as.e("SelectableEditTextHelper", "populateMenuItems err", new Object[0]);
      AppMethodBeat.o(198333);
    }
  }
  
  static void b(b paramb)
  {
    AppMethodBeat.i(198345);
    if (paramb != null) {
      paramb.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(198345);
  }
  
  static void b(f paramf)
  {
    AppMethodBeat.i(198344);
    if (paramf != null) {
      paramf.qQv.dismiss();
    }
    AppMethodBeat.o(198344);
  }
  
  private static boolean haY()
  {
    AppMethodBeat.i(198334);
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        Object localObject = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
        Class localClass = (Class)((Method)localObject).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        localObject = (Method)localMethod.invoke(localClass, new Object[] { "getRuntime", null });
        localMethod = (Method)localMethod.invoke(localClass, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject = ((Method)localObject).invoke(null, new Object[0]);
        if ((localObject == null) || (localMethod == null))
        {
          AppMethodBeat.o(198334);
          return false;
        }
        try
        {
          localMethod.invoke(localObject, new Object[] { { "L" } });
          AppMethodBeat.o(198334);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          AppMethodBeat.o(198334);
          return false;
        }
        AppMethodBeat.o(198334);
      }
      catch (Throwable localThrowable2)
      {
        AppMethodBeat.o(198334);
        return false;
      }
    }
    return true;
  }
  
  final void Dr(boolean paramBoolean)
  {
    AppMethodBeat.i(198337);
    if (this.mIsPause)
    {
      AppMethodBeat.o(198337);
      return;
    }
    if (!paramBoolean)
    {
      hby();
      AppMethodBeat.o(198337);
      return;
    }
    int i = this.Ws.getSelectionStart();
    if ((this.eea) && (this.QPu == i))
    {
      O(this.QPp, this.QPq, false);
      this.QPu = i;
    }
    for (;;)
    {
      this.Ws.setCursorVisible(true);
      this.QPu = i;
      AppMethodBeat.o(198337);
      return;
      hby();
    }
  }
  
  final void O(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(198339);
    if ((this.Ws.getLayout() == null) || (this.Ws.getWidth() == 0))
    {
      AppMethodBeat.o(198339);
      return;
    }
    if (this.QOY == null) {
      this.QOY = new b(true);
    }
    if (this.QOZ == null) {
      this.QOZ = new b(false);
    }
    paramInt1 = this.Ws.getOffsetForPosition(paramInt1, paramInt2);
    if (!paramBoolean) {
      paramInt1 = this.Ws.getSelectionStart();
    }
    for (;;)
    {
      if ((this.Ws.getText() instanceof Spannable)) {
        this.QGC = ((Spannable)this.Ws.getText());
      }
      if (this.QGC != null) {
        break;
      }
      AppMethodBeat.o(198339);
      return;
    }
    if ((paramInt1 < this.Ws.getText().length()) && (paramBoolean))
    {
      paramInt2 = i;
      if (paramInt2 == 0) {
        break label226;
      }
      this.Ws.setCursorVisible(false);
    }
    label226:
    for (i = paramInt1 + 1;; i = paramInt1)
    {
      if ((this.eea) || (this.QPb.avh != paramInt1) || (this.QPb.Pc != i)) {
        break label232;
      }
      AppMethodBeat.o(198339);
      return;
      paramInt2 = 0;
      break;
    }
    label232:
    hbz();
    hbA();
    this.eea = false;
    lE(paramInt1, i);
    if (paramInt2 != 0)
    {
      a(this.QOY);
      a(this.QOZ);
    }
    a(hbx());
    AppMethodBeat.o(198339);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(198340);
    if (paramb == null)
    {
      AppMethodBeat.o(198340);
      return;
    }
    try
    {
      Layout localLayout = this.Ws.getLayout();
      if (b.c(paramb)) {}
      for (int i = this.QPb.avh;; i = this.QPb.Pc)
      {
        paramb.lF((int)localLayout.getPrimaryHorizontal(i), localLayout.getLineBottom(localLayout.getLineForOffset(i)));
        AppMethodBeat.o(198340);
        return;
      }
      return;
    }
    catch (Throwable paramb)
    {
      as.e("SelectableEditTextHelper", "show cursor err：%s", new Object[] { Log.getStackTraceString(paramb) });
      AppMethodBeat.o(198340);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(198342);
    this.Ws.removeTextChangedListener(this.aws);
    this.Ws.removeOnAttachStateChangeListener(this.QPd);
    this.Ws.removeOnLayoutChangeListener(this.OCV);
    this.Ws.getViewTreeObserver().removeOnScrollChangedListener(this.QPc);
    this.Ws.getViewTreeObserver().removeOnPreDrawListener(this.Bl);
    hbA();
    hbz();
    this.QOY = null;
    this.QOZ = null;
    this.QPa = null;
    AppMethodBeat.o(198342);
  }
  
  final void g(Menu paramMenu)
  {
    AppMethodBeat.i(198332);
    if ((paramMenu != null) && (this.QPr.QHA.size() > 0))
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        as.d("SelectableEditTextHelper", "filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() });
        if (this.QPr.QHA.contains(localMenuItem.getTitle()))
        {
          as.d("SelectableEditTextHelper", "reuse bingo:%s", new Object[] { localMenuItem.getTitle() });
          this.QLD.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(198332);
  }
  
  final void hbA()
  {
    this.QPb.QPK = null;
  }
  
  final f hbx()
  {
    AppMethodBeat.i(198335);
    if (this.QPa == null) {
      this.QPa = new f(this.mContext);
    }
    f localf = this.QPa;
    AppMethodBeat.o(198335);
    return localf;
  }
  
  public final void hby()
  {
    AppMethodBeat.i(198336);
    hbA();
    hbz();
    Selection.setSelection(this.Ws.getEditableText(), this.Ws.getSelectionEnd());
    this.Ws.setCursorVisible(true);
    AppMethodBeat.o(198336);
  }
  
  final void hbz()
  {
    AppMethodBeat.i(198338);
    this.eea = true;
    b(this.QOY);
    b(this.QOZ);
    b(hbx());
    AppMethodBeat.o(198338);
  }
  
  final void lE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198341);
    if (paramInt1 != -1) {
      this.QPb.avh = paramInt1;
    }
    if (paramInt2 != -1) {
      this.QPb.Pc = paramInt2;
    }
    if (this.QPb.avh > this.QPb.Pc)
    {
      paramInt2 = this.QPb.avh;
      this.QPb.avh = this.QPb.Pc;
      this.QPb.Pc = paramInt2;
    }
    if (this.QGC != null)
    {
      if (paramInt1 >= this.Ws.getText().length())
      {
        AppMethodBeat.o(198341);
        return;
      }
      this.QPb.QPK = this.QGC.subSequence(this.QPb.avh, this.QPb.Pc).toString();
      this.Ws.setHighlightColor(this.QPi);
      Selection.setSelection(this.QGC, this.QPb.avh, this.QPb.Pc);
    }
    AppMethodBeat.o(198341);
  }
  
  public static final class a
  {
    boolean BpG;
    public Set<String> QHA;
    int QPi;
    int QPj;
    float QPx;
    public Set<String> QPy;
    public String QPz;
    TextView Ws;
    
    public a(TextView paramTextView)
    {
      AppMethodBeat.i(198310);
      this.QPj = 2131100228;
      this.QPi = 2131101045;
      this.QPx = 18.0F;
      this.BpG = true;
      this.QHA = new HashSet();
      this.QPy = new HashSet();
      this.Ws = paramTextView;
      AppMethodBeat.o(198310);
    }
  }
  
  final class b
    extends View
  {
    private int[] PhV;
    private int[] QLE;
    private boolean QPA;
    private int QPB;
    private int QPC;
    private int QPD;
    private int QPE;
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    private int mWidth;
    private int qRY;
    
    public b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(198311);
      this.qRY = (a.this.QPk / 2);
      this.mWidth = (this.qRY * 2);
      this.mHeight = (this.qRY * 2);
      this.mPadding = 25;
      this.PhV = new int[2];
      this.QLE = new int[2];
      this.QPA = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.QPj);
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
      invalidate();
      AppMethodBeat.o(198311);
    }
    
    private int a(int paramInt, Layout paramLayout)
    {
      AppMethodBeat.i(198316);
      paramInt = paramLayout.getLineBottom(paramLayout.getLineForOffset(paramInt));
      paramInt = hbE() + paramInt;
      int i = this.QLE[1] + a.this.Ws.getHeight() - a.this.Ws.getPaddingBottom();
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        i = paramInt;
        if (paramInt < this.QLE[1]) {
          i = this.QLE[1];
        }
        AppMethodBeat.o(198316);
        return i;
      }
    }
    
    private void hbB()
    {
      AppMethodBeat.i(198314);
      if (!this.QPA) {}
      for (boolean bool = true;; bool = false)
      {
        this.QPA = bool;
        invalidate();
        AppMethodBeat.o(198314);
        return;
      }
    }
    
    private void hbC()
    {
      AppMethodBeat.i(198315);
      a.this.Ws.getLocationInWindow(this.QLE);
      Layout localLayout = a.this.Ws.getLayout();
      if (this.QPA)
      {
        i = a(a.this.QPb.avh, localLayout);
        lG((int)localLayout.getPrimaryHorizontal(a.this.QPb.avh) - this.mWidth + hbD(), i);
        AppMethodBeat.o(198315);
        return;
      }
      int i = a(a.this.QPb.Pc, localLayout);
      lG((int)localLayout.getPrimaryHorizontal(a.this.QPb.Pc) + hbD(), i);
      AppMethodBeat.o(198315);
    }
    
    private int hbD()
    {
      AppMethodBeat.i(198319);
      int i = this.QLE[0];
      int j = this.mPadding;
      int k = a.this.Ws.getPaddingLeft();
      AppMethodBeat.o(198319);
      return i - j + k;
    }
    
    private int hbE()
    {
      AppMethodBeat.i(198320);
      int i = this.QLE[1];
      int j = a.this.Ws.getPaddingTop();
      int k = a.this.Ws.getScrollY();
      AppMethodBeat.o(198320);
      return i + j - k;
    }
    
    private void lG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198318);
      try
      {
        if (this.mPopupWindow.isShowing())
        {
          this.mPopupWindow.update(paramInt1, paramInt2, -1, -1);
          AppMethodBeat.o(198318);
          return;
        }
        this.mPopupWindow.showAtLocation(a.this.Ws, 0, paramInt1, paramInt2);
        AppMethodBeat.o(198318);
        return;
      }
      catch (Exception localException)
      {
        as.e("SelectableEditTextHelper", "cursor error!: %s.", new Object[] { localException.getMessage() });
        AppMethodBeat.o(198318);
      }
    }
    
    public final void lF(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198317);
      a.this.Ws.getLocationInWindow(this.QLE);
      if (this.QPA) {}
      int j;
      for (int i = this.mWidth;; i = 0)
      {
        j = hbD();
        paramInt2 = hbE() + paramInt2;
        if (paramInt2 >= this.QLE[1]) {
          break;
        }
        AppMethodBeat.o(198317);
        return;
      }
      if (paramInt2 > this.QLE[1] + a.this.Ws.getHeight() - a.this.Ws.getPaddingBottom() + at.fromDPToPix(a.this.mContext, 5))
      {
        AppMethodBeat.o(198317);
        return;
      }
      lG(paramInt1 - i + j, paramInt2);
      AppMethodBeat.o(198317);
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(198312);
      paramCanvas.drawCircle(this.qRY + this.mPadding, this.qRY, this.qRY, this.mPaint);
      if (this.QPA)
      {
        paramCanvas.drawRect(this.qRY + this.mPadding, 0.0F, this.qRY * 2 + this.mPadding, this.qRY, this.mPaint);
        AppMethodBeat.o(198312);
        return;
      }
      paramCanvas.drawRect(this.mPadding, 0.0F, this.qRY + this.mPadding, this.qRY, this.mPaint);
      AppMethodBeat.o(198312);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(198313);
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 1: 
      case 3: 
        for (;;)
        {
          AppMethodBeat.o(198313);
          return true;
          this.QPD = a.this.QPb.avh;
          this.QPE = a.this.QPb.Pc;
          this.QPB = ((int)paramMotionEvent.getX());
          this.QPC = ((int)paramMotionEvent.getY());
          a.this.Ws.getLocationInWindow(this.PhV);
          continue;
          a.a(a.this.hbx());
        }
      }
      a.b(a.this.hbx());
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      int m = this.PhV[0];
      int n = this.QPC;
      int i1 = this.mHeight;
      int i2 = a.this.QPm;
      int i3 = a.this.Ws.getScrollY();
      a.this.Ws.getLocationInWindow(this.QLE);
      int i;
      if (this.QPA)
      {
        i = a.this.QPb.avh;
        label219:
        int i4 = this.QLE[1];
        j = com.tencent.mm.ui.widget.textview.b.f(a.this.Ws, j - m, i3 + (n + k - i1 - i2) - i4, i);
        if (j != i)
        {
          a.this.hbA();
          if (!this.QPA) {
            break label385;
          }
          if (j <= this.QPE) {
            break label373;
          }
          paramMotionEvent = a.a(a.this, false);
          hbB();
          paramMotionEvent.hbB();
          this.QPD = this.QPE;
          a.this.lE(this.QPE, j);
          paramMotionEvent.hbC();
          label328:
          hbC();
        }
        paramMotionEvent = a.this;
        if (this.QPA) {
          break label456;
        }
      }
      label385:
      label456:
      for (boolean bool = true;; bool = false)
      {
        a.a(paramMotionEvent, bool).hbC();
        break;
        i = a.this.QPb.Pc;
        break label219;
        label373:
        a.this.lE(j, -1);
        break label328;
        if (j < this.QPD)
        {
          paramMotionEvent = a.a(a.this, true);
          paramMotionEvent.hbB();
          hbB();
          this.QPE = this.QPD;
          a.this.lE(j, this.QPD);
          paramMotionEvent.hbC();
        }
        for (;;)
        {
          hbC();
          break;
          a.this.lE(this.QPD, j);
        }
      }
    }
  }
  
  public static final class c
  {
    public int QPF;
    public int id;
    public String name;
    
    public c(String paramString, int paramInt)
    {
      this.name = paramString;
      this.id = paramInt;
      this.QPF = 15;
    }
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.id = paramInt1;
      this.QPF = paramInt2;
    }
  }
  
  public static final class d
    extends RecyclerView.a<a>
  {
    private a.e QLI;
    private a.g QPb;
    private List<a.c> qXp;
    
    d(List<a.c> paramList, a.e parame, a.g paramg)
    {
      this.qXp = paramList;
      this.QLI = parame;
      this.QPb = paramg;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(198323);
      int i = this.qXp.size();
      AppMethodBeat.o(198323);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView vr;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(198322);
        this.vr = ((TextView)paramView.findViewById(2131304617));
        this.vr.setTextSize(1, 14.0F);
        AppMethodBeat.o(198322);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void A(List<a.c> paramList, int paramInt);
    
    public abstract void a(View paramView, a.c paramc, String paramString);
  }
  
  final class f
  {
    ImageView QLA;
    List<a.c> QLz;
    a.d QPH;
    private int mHeight;
    RecyclerView mRecyclerView;
    private int mWidth;
    PopupWindow qQv;
    
    public f(Context paramContext)
    {
      AppMethodBeat.i(198328);
      paramContext = LayoutInflater.from(paramContext).inflate(2131495181, null);
      paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = paramContext.getMeasuredWidth();
      this.mHeight = paramContext.getMeasuredHeight();
      this.qQv = new PopupWindow(paramContext, -2, -2, false);
      this.qQv.setClippingEnabled(false);
      this.mRecyclerView = ((RecyclerView)paramContext.findViewById(2131307200));
      Object localObject = new LinearLayoutManager(0, false);
      this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      localObject = new LinkedList();
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(2131763037), 1, 4));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039373), 16908319, 12));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039363), 16908320, 9));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039361), 16908321, 9));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039371), 16908322));
      this.QLz = ((List)localObject);
      this.QPH = new a.d(this.QLz, new a.e()
      {
        public final void A(List<a.c> paramAnonymousList, int paramAnonymousInt) {}
        
        public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
        {
          AppMethodBeat.i(198326);
          a.f localf = a.f.this;
          switch (paramAnonymousc.id)
          {
          default: 
            localf.QPw.Ws.setCursorVisible(true);
          }
          for (;;)
          {
            if (localf.QPw.QLD.containsKey(Integer.valueOf(paramAnonymousc.id)))
            {
              localf.QPw.Ws.onTextContextMenuItem(paramAnonymousc.id);
              localf.QPw.hbA();
              localf.QPw.hbz();
              localf.QPw.Ws.setCursorVisible(true);
            }
            if (localf.QPw.QLI != null) {
              localf.QPw.QLI.a(paramAnonymousView, paramAnonymousc, paramAnonymousString);
            }
            AppMethodBeat.o(198326);
            return;
            localf.QPw.hbz();
            int i = localf.QPw.Ws.getSelectionStart();
            if (i > 0) {
              localf.QPw.lE(i - 1, i);
            }
            for (;;)
            {
              localf.QPw.eea = false;
              localf.QPw.a(localf.QPw.QOY);
              localf.QPw.a(localf.QPw.QOZ);
              a.a(localf.QPw.hbx());
              localf.QPw.Ws.setCursorVisible(false);
              break;
              localf.QPw.lE(i, i + 1);
            }
            localf.QPw.hbz();
            localf.QPw.lE(0, localf.QPw.Ws.getText().length());
            localf.QPw.eea = false;
            localf.QPw.Ws.post(new a.f.2(localf));
            localf.QPw.Ws.setCursorVisible(false);
            continue;
            ((ClipboardManager)localf.QPw.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(localf.QPw.QPb.QPK, localf.QPw.QPb.QPK));
            localf.QPw.hbA();
            localf.QPw.hbz();
            ((Editable)localf.QPw.Ws.getText()).delete(localf.QPw.QPb.avh, localf.QPw.QPb.Pc);
            Toast.makeText(localf.QPw.mContext, localf.QPw.mContext.getResources().getString(2131763023), 0).show();
            break;
            ((ClipboardManager)localf.QPw.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(localf.QPw.QPb.QPK, localf.QPw.QPb.QPK));
            localf.QPw.hbA();
            localf.QPw.hbz();
            Toast.makeText(localf.QPw.mContext, localf.QPw.mContext.getResources().getString(2131763022), 0).show();
            localf.QPw.Ws.setCursorVisible(true);
            Selection.setSelection(localf.QPw.Ws.getEditableText(), localf.QPw.Ws.getSelectionEnd());
            continue;
            localf.QPw.Ws.onTextContextMenuItem(16908322);
            localf.QPw.Ws.setCursorVisible(true);
            localf.QPw.QPu = localf.QPw.Ws.getSelectionStart();
          }
        }
      }, a.this.QPb);
      this.mRecyclerView.setAdapter(this.QPH);
      localObject = new w(a.this.mContext, 0);
      ((w)localObject).setDrawable(new ColorDrawable(a.this.mContext.getResources().getColor(2131100649)));
      this.mRecyclerView.a((RecyclerView.h)localObject);
      this.QLA = ((ImageView)paramContext.findViewById(2131299376));
      AppMethodBeat.o(198328);
    }
    
    private void haW()
    {
      int j = 1;
      AppMethodBeat.i(198329);
      int i = a.this.Ws.getText().length();
      if ((i > 0) && (a.this.QPb.avh == 0) && (a.this.QPb.Pc == i)) {
        i = 1;
      }
      LinkedList localLinkedList;
      Object localObject2;
      for (;;)
      {
        localLinkedList = new LinkedList();
        localObject1 = this.QLz.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a.c)((Iterator)localObject1).next();
          if ((((a.c)localObject2).QPF & i) != 0) {
            localLinkedList.add(localObject2);
          }
        }
        if (a.this.QPb.avh == a.this.QPb.Pc)
        {
          if (i > 0) {
            i = 4;
          } else {
            i = 2;
          }
        }
        else {
          i = 8;
        }
      }
      a.this.QLD.clear();
      Object localObject1 = a.this;
      if ((((a)localObject1).QPr.QHA.size() > 0) && (Build.BRAND != null) && (((a)localObject1).QPr.QPy.contains(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT >= 23) && (((a)localObject1).BpG)) {}
      for (;;)
      {
        if (j != 0)
        {
          as.i("SelectableEditTextHelper", "tryGetMenus", new Object[0]);
          a.a(a.this);
        }
        if (a.this.QLD.size() <= 0) {
          break;
        }
        localObject1 = a.this.QLD.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localLinkedList.add(new a.c(((CharSequence)((Map.Entry)localObject2).getValue()).toString(), ((Integer)((Map.Entry)localObject2).getKey()).intValue()));
        }
        j = 0;
      }
      if (a.this.QLI != null) {
        a.this.QLI.A(localLinkedList, i);
      }
      a.d.a(this.QPH, localLinkedList);
      this.QPH.atj.notifyChanged();
      AppMethodBeat.o(198329);
    }
    
    public final void show()
    {
      AppMethodBeat.i(198330);
      haW();
      Object localObject = this.qQv.getContentView();
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = ((View)localObject).getMeasuredWidth();
      this.mHeight = ((View)localObject).getMeasuredHeight();
      a.this.Ws.getLocationInWindow(a.this.QLE);
      localObject = a.this.Ws.getLayout();
      int i1 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(a.this.mContext);
      int m = at.fromDPToPix(a.this.mContext, 10);
      int i = i1 - m * 2;
      if (this.mWidth >= i) {
        this.mWidth = i;
      }
      i = ((int)((Layout)localObject).getPrimaryHorizontal(a.this.QPb.avh) + (int)((Layout)localObject).getPrimaryHorizontal(a.this.QPb.Pc)) / 2;
      int j = a.this.QLE[0];
      int k = this.mWidth / 2;
      int n = a.this.Ws.getPaddingLeft();
      if ((a.this.QPb.avh != a.this.QPb.Pc) && (((Layout)localObject).getLineForOffset(a.this.QPb.avh) != ((Layout)localObject).getLineForOffset(a.this.QPb.Pc))) {}
      for (i = a.this.QLE[0] + a.this.Ws.getWidth() / 2 - this.mWidth / 2;; i = i + j - k + n)
      {
        k = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(a.this.QPb.avh)) + a.this.QLE[1] - this.mHeight + a.this.Ws.getPaddingTop() - a.this.Ws.getScrollY() - at.fromDPToPix(a.this.mContext, 5);
        n = a.this.QLE[1] - this.mHeight - at.fromDPToPix(a.this.mContext, 5);
        int i2 = a.this.QLE[1];
        int i3 = a.this.Ws.getHeight();
        int i4 = this.mHeight;
        int i5 = at.fromDPToPix(a.this.mContext, 5);
        if (i <= m) {}
        for (j = m;; j = i)
        {
          if (k < n) {
            k = n;
          }
          for (;;)
          {
            if (k > i2 + i3 - i4 - i5)
            {
              AppMethodBeat.o(198330);
              return;
            }
            if (this.mWidth + j > i1) {
              j = i1 - this.mWidth - m;
            }
            for (;;)
            {
              ((LinearLayout.LayoutParams)this.QLA.getLayoutParams()).leftMargin = (i - j);
              if (Build.VERSION.SDK_INT >= 21) {
                this.qQv.setElevation(8.0F);
              }
              localObject = this.mRecyclerView.getLayoutManager();
              if ((localObject instanceof LinearLayoutManager))
              {
                localObject = (LinearLayoutManager)localObject;
                com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
                ((LinearLayoutManager)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
              }
              this.qQv.setWidth(this.mWidth);
              try
              {
                this.qQv.showAtLocation(a.this.Ws, 0, j, k);
                AppMethodBeat.o(198330);
                return;
              }
              catch (Exception localException)
              {
                as.e("SelectableEditTextHelper", "oper error!:%s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(198330);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static final class g
  {
    public int Pc;
    public String QPK;
    public int avh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.a
 * JD-Core Version:    0.7.0.1
 */