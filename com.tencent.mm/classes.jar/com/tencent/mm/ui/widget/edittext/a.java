package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Build.VERSION;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.base.o;
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

public class a
{
  boolean HjZ;
  private View.OnLayoutChangeListener VWm;
  private Spannable Yfs;
  public e YkA;
  private Menu Yku;
  Map<Integer, CharSequence> Ykv;
  int[] Ykw;
  b YnM;
  b YnN;
  private f YnO;
  g YnP;
  private ViewTreeObserver.OnScrollChangedListener YnQ;
  private View.OnAttachStateChangeListener YnR;
  public View.OnLongClickListener YnS;
  public View.OnTouchListener YnT;
  public View.OnFocusChangeListener YnU;
  public View.OnClickListener YnV;
  private int YnW;
  int YnX;
  int YnY;
  boolean YnZ;
  int Yoa;
  boolean Yob;
  boolean Yoc;
  int Yod;
  int Yoe;
  private a Yof;
  boolean Yog;
  private ActionMode.Callback Yoh;
  int Yoi;
  private final Runnable Yoj;
  private ViewTreeObserver.OnPreDrawListener aqE;
  boolean fYp;
  Context mContext;
  private boolean mIsPause;
  TextView rR;
  int rxS;
  private TextWatcher uY;
  
  protected a(a parama)
  {
    AppMethodBeat.i(251108);
    this.YnP = new g();
    this.fYp = true;
    this.Yob = false;
    this.Yoc = false;
    this.Ykv = new HashMap();
    this.Ykw = new int[2];
    this.Yoh = new ActionMode.Callback()
    {
      public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
      
      public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        AppMethodBeat.i(250371);
        av.d("SelectableEditTextHelper", "mDisableCallback", new Object[0]);
        a.this.h(paramAnonymousMenu);
        AppMethodBeat.o(250371);
        return false;
      }
      
      public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
      
      public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    };
    this.Yoi = -1;
    this.Yoj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250083);
        if (a.this.fYp)
        {
          AppMethodBeat.o(250083);
          return;
        }
        a.this.a(a.this.icI());
        a.this.a(a.this.YnM);
        a.this.a(a.this.YnN);
        AppMethodBeat.o(250083);
      }
    };
    this.mIsPause = false;
    this.Yof = parama;
    this.rR = parama.rR;
    this.mContext = this.rR.getContext();
    this.YnW = this.mContext.getResources().getColor(parama.YnW);
    this.YnX = this.mContext.getResources().getColor(parama.YnX);
    this.YnY = aw.fromDPToPix(this.mContext, (int)parama.Yol);
    this.Yoa = com.tencent.mm.ui.widget.textview.b.iZ(this.rR);
    this.HjZ = parama.HjZ;
    if ((Build.VERSION.SDK_INT >= 29) && ((ay.isMIUI()) || (ay.hJb()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.Yog = bool;
      av.i("SelectableEditTextHelper", "init %s,%s,%s", new Object[] { Boolean.valueOf(this.HjZ), this.Yof.EJk, Build.BRAND });
      this.rR.setText(this.rR.getText(), TextView.BufferType.SPANNABLE);
      this.Yfs = ((Spannable)this.rR.getText());
      this.rR.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(250563);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          if (a.this.YnS != null) {}
          for (boolean bool = a.this.YnS.onLongClick(paramAnonymousView);; bool = false)
          {
            if (a.this.HjZ)
            {
              av.i("SelectableEditTextHelper", "onLongClick:" + a.this.Yob, new Object[0]);
              paramAnonymousView = a.this;
              if ((!TextUtils.isEmpty(Build.BRAND)) && ("vivo".equals(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT < 23)) {
                paramAnonymousView.rR.post(new a.2(paramAnonymousView));
              }
              if (a.this.Yob)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(250563);
                return false;
              }
              a.this.Yoc = true;
              a.a(a.this, a.this.Yod, a.this.Yoe);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(250563);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(250563);
            return bool;
          }
        }
      });
      this.rR.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(249533);
          if (a.this.YnT != null) {}
          for (boolean bool = a.this.YnT.onTouch(paramAnonymousView, paramAnonymousMotionEvent);; bool = false)
          {
            if (a.this.HjZ)
            {
              a.this.Yod = ((int)paramAnonymousMotionEvent.getX());
              a.this.Yoe = ((int)paramAnonymousMotionEvent.getY());
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
              do
              {
                for (;;)
                {
                  a.this.rxS = a.this.rR.getScrollY();
                  AppMethodBeat.o(249533);
                  return false;
                  a.this.Yoc = false;
                  if (a.this.Yog)
                  {
                    a.L(a.this.rR);
                    a.this.Yog = false;
                  }
                  paramAnonymousView = a.this;
                  try
                  {
                    av.d("SelectableEditTextHelper", "setInsertionDisabled", new Object[0]);
                    paramAnonymousMotionEvent = TextView.class.getDeclaredField("mEditor");
                    paramAnonymousMotionEvent.setAccessible(true);
                    paramAnonymousView = paramAnonymousMotionEvent.get(paramAnonymousView.rR);
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
                    av.e("SelectableEditTextHelper", "setInsertionDisabled error msg:%s", new Object[] { paramAnonymousView.getMessage() });
                  }
                  continue;
                  if ((ay.isMIUI()) && (a.this.Yoc))
                  {
                    AppMethodBeat.o(249533);
                    return true;
                  }
                  if (a.this.rxS != a.this.rR.getScrollY())
                  {
                    a.this.Yob = true;
                    if ((!a.this.YnZ) && (!a.this.fYp))
                    {
                      a.this.YnZ = true;
                      a.this.b(a.this.icI());
                      a.this.b(a.this.YnM);
                      a.this.b(a.this.YnN);
                    }
                  }
                }
              } while (!a.this.Yob);
              a.this.Yob = false;
              if (a.this.YnZ)
              {
                a.this.YnZ = false;
                a.this.cpp().run();
              }
              AppMethodBeat.o(249533);
              return true;
            }
            AppMethodBeat.o(249533);
            return bool;
          }
        }
      });
      this.rR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251048);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (a.this.HjZ)
          {
            av.i("SelectableEditTextHelper", "onClick", new Object[0]);
            a.this.HN(true);
          }
          if (a.this.YnV != null) {
            a.this.YnV.onClick(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251048);
        }
      });
      this.rR.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(251385);
          if (a.this.HjZ)
          {
            av.d("SelectableEditTextHelper", "onFocusChange:".concat(String.valueOf(paramAnonymousBoolean)), new Object[0]);
            if (!paramAnonymousBoolean) {
              a.this.HN(false);
            }
          }
          if (a.this.YnU != null) {
            a.this.YnU.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
          }
          AppMethodBeat.o(251385);
        }
      });
      if (this.HjZ)
      {
        this.rR.setCustomSelectionActionModeCallback(this.Yoh);
        if (Build.VERSION.SDK_INT >= 23) {
          this.rR.setCustomInsertionActionModeCallback(this.Yoh);
        }
        this.uY = new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(249750);
            if (!a.this.fYp)
            {
              a.this.cpn();
              a.this.cpq();
            }
            a.this.rR.setCursorVisible(true);
            a.this.Yoi = a.this.rR.getSelectionStart();
            AppMethodBeat.o(249750);
          }
        };
        this.YnR = new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(251153);
            av.d("SelectableEditTextHelper", "onViewDetachedFromWindow:", new Object[0]);
            a.this.destroy();
            AppMethodBeat.o(251153);
          }
        };
        this.VWm = new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(249459);
            if (a.this.fYp)
            {
              AppMethodBeat.o(249459);
              return;
            }
            paramAnonymousView = new int[2];
            paramAnonymousView[0] = a.this.Ykw[0];
            paramAnonymousView[1] = a.this.Ykw[1];
            a.this.rR.getLocationInWindow(a.this.Ykw);
            av.d("SelectableEditTextHelper", "LayoutChangeFromWindow l:%d,t:%d,r:%d,b:%d,oldl:%d,oldt:%d,oldr:%d,oldb:%d,oldx:%d, newx:%d, oldy:%d, newy:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), Integer.valueOf(paramAnonymousInt5), Integer.valueOf(paramAnonymousInt6), Integer.valueOf(paramAnonymousInt7), Integer.valueOf(paramAnonymousInt8), Integer.valueOf(paramAnonymousView[0]), Integer.valueOf(a.this.Ykw[0]), Integer.valueOf(paramAnonymousView[1]), Integer.valueOf(a.this.Ykw[1]) });
            if ((paramAnonymousInt2 != paramAnonymousInt6) || (paramAnonymousInt4 != paramAnonymousInt8) || (paramAnonymousView[1] != a.this.Ykw[1])) {
              a.this.cpo();
            }
            AppMethodBeat.o(249459);
          }
        };
        this.aqE = new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            return true;
          }
        };
        this.YnQ = new ViewTreeObserver.OnScrollChangedListener()
        {
          public final void onScrollChanged() {}
        };
        this.rR.addTextChangedListener(this.uY);
        this.rR.addOnAttachStateChangeListener(this.YnR);
        this.rR.addOnLayoutChangeListener(this.VWm);
        this.rR.getViewTreeObserver().addOnPreDrawListener(this.aqE);
        this.rR.getViewTreeObserver().addOnScrollChangedListener(this.YnQ);
      }
      AppMethodBeat.o(251108);
      return;
    }
  }
  
  public static boolean L(TextView paramTextView)
  {
    AppMethodBeat.i(251135);
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      paramTextView = ((Field)localObject).get(paramTextView);
      localObject = Class.forName("android.widget.Editor");
      localObject = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(localObject, new Object[] { "getEmailPopupWindow", null });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramTextView, new Object[0]);
      av.i("SelectableEditTextHelper", "getEmailPopupWindow succ", new Object[0]);
      AppMethodBeat.o(251135);
      return true;
    }
    catch (Throwable paramTextView)
    {
      av.e("SelectableEditTextHelper", "getEmailPopupWindow err:%s", new Object[] { paramTextView.getMessage() });
      AppMethodBeat.o(251135);
    }
    return false;
  }
  
  private static boolean a(TextView paramTextView, Menu paramMenu)
  {
    AppMethodBeat.i(251115);
    try
    {
      Object localObject1 = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject1).setAccessible(true);
      Object localObject3 = ((Field)localObject1).get(paramTextView);
      Class localClass2 = Class.forName("android.widget.Editor");
      Class localClass1 = Class.forName("android.widget.Editor$TextActionModeCallback");
      Object localObject2 = paramTextView.getTag(com.tencent.mm.cr.a.f.text_view_callback);
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
        paramTextView.setTag(com.tencent.mm.cr.a.f.text_view_callback, localObject1);
        av.i("SelectableEditTextHelper", "populateMenuItems succ", new Object[0]);
        AppMethodBeat.o(251115);
        return true;
        label178:
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Boolean.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      return false;
    }
    catch (Throwable paramTextView)
    {
      av.e("SelectableEditTextHelper", "populateMenuItems err", new Object[0]);
      AppMethodBeat.o(251115);
    }
  }
  
  private static boolean ibY()
  {
    AppMethodBeat.i(251116);
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
          AppMethodBeat.o(251116);
          return false;
        }
        try
        {
          localMethod.invoke(localObject, new Object[] { { "L" } });
          AppMethodBeat.o(251116);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          AppMethodBeat.o(251116);
          return false;
        }
        AppMethodBeat.o(251116);
      }
      catch (Throwable localThrowable2)
      {
        AppMethodBeat.o(251116);
        return false;
      }
    }
    return true;
  }
  
  private void icH()
  {
    AppMethodBeat.i(251110);
    long l1 = System.currentTimeMillis();
    try
    {
      Object localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(this.rR, Integer.valueOf(com.tencent.mm.cr.a.e.trans_drawable));
      boolean bool1 = ibY();
      localObject = this.rR;
      if (this.Yku == null) {
        this.Yku = new o(this.mContext);
      }
      this.Yku.clear();
      ibY();
      boolean bool2 = a((TextView)localObject, this.Yku);
      h(this.Yku);
      long l2 = System.currentTimeMillis();
      av.i("SelectableEditTextHelper", "startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(251110);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        av.e("SelectableEditTextHelper", "disableSysHandle fail:", new Object[] { localException.getMessage() });
      }
    }
  }
  
  final void HN(boolean paramBoolean)
  {
    AppMethodBeat.i(251119);
    if (this.mIsPause)
    {
      AppMethodBeat.o(251119);
      return;
    }
    if (!paramBoolean)
    {
      cpo();
      AppMethodBeat.o(251119);
      return;
    }
    int i = this.rR.getSelectionStart();
    if ((this.fYp) && (this.Yoi == i))
    {
      s(this.Yod, this.Yoe, false);
      this.Yoi = i;
    }
    for (;;)
    {
      this.rR.setCursorVisible(true);
      this.Yoi = i;
      AppMethodBeat.o(251119);
      return;
      cpo();
    }
  }
  
  protected void a(b paramb)
  {
    AppMethodBeat.i(251128);
    if (paramb == null)
    {
      AppMethodBeat.o(251128);
      return;
    }
    try
    {
      Layout localLayout = this.rR.getLayout();
      int j;
      int k;
      if (b.c(paramb))
      {
        i = this.YnP.tH;
        j = (int)localLayout.getPrimaryHorizontal(i);
        k = localLayout.getLineBottom(localLayout.getLineForOffset(i));
        paramb.Yok.rR.getLocationInWindow(paramb.Ykw);
        if (!paramb.Yon) {
          break label189;
        }
      }
      label189:
      for (int i = paramb.mWidth;; i = 0)
      {
        int m = paramb.getExtraX();
        k += paramb.getExtraY();
        if ((k >= paramb.Ykw[1]) && (k <= paramb.Ykw[1] + paramb.Yok.rR.getHeight() - paramb.Yok.rR.getPaddingBottom() + aw.fromDPToPix(paramb.Yok.mContext, 5))) {
          paramb.mW(j - i + m, k);
        }
        AppMethodBeat.o(251128);
        return;
        i = this.YnP.tI;
        break;
      }
      return;
    }
    catch (Throwable paramb)
    {
      av.e("SelectableEditTextHelper", "show cursor err：%s", new Object[] { Log.getStackTraceString(paramb) });
      AppMethodBeat.o(251128);
    }
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(251131);
    if (paramf != null) {}
    int i;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      try
      {
        i = paramf.Yok.rR.getText().length();
        if ((i <= 0) || (paramf.Yok.YnP.tH != 0) || (paramf.Yok.YnP.tI != i)) {
          break label151;
        }
        i = 1;
        localObject1 = new LinkedList();
        localObject2 = paramf.Ykr.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (c)((Iterator)localObject2).next();
        if ((((c)localObject3).Yoq & i) == 0) {
          continue;
        }
        ((List)localObject1).add(localObject3);
        continue;
        AppMethodBeat.o(251131);
      }
      catch (Throwable paramf)
      {
        av.e("SelectableEditTextHelper", "show oper err：%s", new Object[] { Log.getStackTraceString(paramf) });
      }
      return;
      label151:
      if (paramf.Yok.YnP.tH != paramf.Yok.YnP.tI) {
        break label1113;
      }
      if (i <= 0) {
        break label1108;
      }
      i = 4;
    }
    paramf.Yok.Ykv.clear();
    Object localObject2 = paramf.Yok;
    int j;
    label263:
    int i1;
    int m;
    int k;
    int n;
    int i2;
    int i3;
    int i4;
    int i5;
    if ((((a)localObject2).Yof.Ygq.size() > 0) && (Build.BRAND != null) && (((a)localObject2).Yof.Yom.contains(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT >= 23) && (((a)localObject2).HjZ))
    {
      j = 1;
      if (j != 0)
      {
        av.i("SelectableEditTextHelper", "tryGetMenus", new Object[0]);
        paramf.Yok.icH();
      }
      if (paramf.Yok.Ykv.size() > 0)
      {
        localObject2 = paramf.Yok.Ykv.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          ((List)localObject1).add(new c(((CharSequence)((Map.Entry)localObject3).getValue()).toString(), ((Integer)((Map.Entry)localObject3).getKey()).intValue()));
        }
      }
      if (paramf.Yok.YkA != null) {
        paramf.Yok.YkA.B((List)localObject1, i);
      }
      paramf.Yos.uAd = ((List)localObject1);
      paramf.Yos.alc.notifyChanged();
      localObject1 = paramf.usB.getContentView();
      ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramf.mWidth = ((View)localObject1).getMeasuredWidth();
      paramf.mHeight = ((View)localObject1).getMeasuredHeight();
      paramf.Yok.rR.getLocationInWindow(paramf.Yok.Ykw);
      localObject1 = paramf.Yok.rR.getLayout();
      i1 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(paramf.Yok.mContext);
      m = aw.fromDPToPix(paramf.Yok.mContext, 10);
      i = i1 - m * 2;
      if (paramf.mWidth >= i) {
        paramf.mWidth = i;
      }
      j = ((int)((Layout)localObject1).getPrimaryHorizontal(paramf.Yok.YnP.tH) + (int)((Layout)localObject1).getPrimaryHorizontal(paramf.Yok.YnP.tI)) / 2 + paramf.Yok.Ykw[0] - paramf.mWidth / 2 + paramf.Yok.rR.getPaddingLeft();
      i = j;
      if (paramf.Yok.YnP.tH != paramf.Yok.YnP.tI)
      {
        i = j;
        if (((Layout)localObject1).getLineForOffset(paramf.Yok.YnP.tH) != ((Layout)localObject1).getLineForOffset(paramf.Yok.YnP.tI)) {
          i = paramf.Yok.Ykw[0] + paramf.Yok.rR.getWidth() / 2 - paramf.mWidth / 2;
        }
      }
      k = ((Layout)localObject1).getLineTop(((Layout)localObject1).getLineForOffset(paramf.Yok.YnP.tH)) + paramf.Yok.Ykw[1] - paramf.mHeight + paramf.Yok.rR.getPaddingTop() - paramf.Yok.rR.getScrollY() - aw.fromDPToPix(paramf.Yok.mContext, 5);
      n = paramf.Yok.Ykw[1] - paramf.mHeight - aw.fromDPToPix(paramf.Yok.mContext, 5);
      i2 = paramf.Yok.Ykw[1];
      i3 = paramf.Yok.rR.getHeight();
      i4 = paramf.mHeight;
      i5 = aw.fromDPToPix(paramf.Yok.mContext, 5);
      if (i <= m)
      {
        j = m;
        break label1124;
      }
    }
    for (;;)
    {
      label857:
      if (k <= i2 + i3 - i4 - i5)
      {
        if (paramf.mWidth + j <= i1) {
          break label1097;
        }
        j = i1 - paramf.mWidth - m;
      }
      label1097:
      for (;;)
      {
        ((LinearLayout.LayoutParams)paramf.Yks.getLayoutParams()).leftMargin = (i - j);
        if (Build.VERSION.SDK_INT >= 21) {
          paramf.usB.setElevation(8.0F);
        }
        localObject1 = paramf.mRecyclerView.getLayoutManager();
        if ((localObject1 instanceof LinearLayoutManager))
        {
          localObject1 = (LinearLayoutManager)localObject1;
          localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((LinearLayoutManager)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        paramf.usB.setWidth(paramf.mWidth);
        try
        {
          paramf.usB.showAtLocation(paramf.Yok.rR, 0, j, k);
          AppMethodBeat.o(251131);
          return;
        }
        catch (Exception paramf)
        {
          av.e("SelectableEditTextHelper", "oper error!:%s", new Object[] { paramf.getMessage() });
        }
        AppMethodBeat.o(251131);
        return;
      }
      label1108:
      label1113:
      label1124:
      do
      {
        break label857;
        j = i;
        continue;
        i = 2;
        break;
        i = 8;
        break;
        j = 0;
        break label263;
      } while (k >= n);
      k = n;
    }
  }
  
  protected void b(b paramb)
  {
    AppMethodBeat.i(251133);
    if (paramb != null) {
      paramb.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(251133);
  }
  
  protected void b(f paramf)
  {
    AppMethodBeat.i(251132);
    if (paramf != null) {
      paramf.usB.dismiss();
    }
    AppMethodBeat.o(251132);
  }
  
  protected void cpn()
  {
    this.YnP.Yov = null;
  }
  
  public void cpo()
  {
    AppMethodBeat.i(251118);
    cpn();
    cpq();
    Selection.setSelection(this.rR.getEditableText(), this.rR.getSelectionEnd());
    this.rR.setCursorVisible(true);
    AppMethodBeat.o(251118);
  }
  
  protected Runnable cpp()
  {
    return this.Yoj;
  }
  
  protected void cpq()
  {
    AppMethodBeat.i(251122);
    this.fYp = true;
    b(this.YnM);
    b(this.YnN);
    b(this.YnO);
    AppMethodBeat.o(251122);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(251130);
    this.rR.removeTextChangedListener(this.uY);
    this.rR.removeOnAttachStateChangeListener(this.YnR);
    this.rR.removeOnLayoutChangeListener(this.VWm);
    this.rR.getViewTreeObserver().removeOnScrollChangedListener(this.YnQ);
    this.rR.getViewTreeObserver().removeOnPreDrawListener(this.aqE);
    cpn();
    cpq();
    this.YnM = null;
    this.YnN = null;
    this.YnO = null;
    AppMethodBeat.o(251130);
  }
  
  protected void fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251129);
    if (paramInt1 != -1) {
      this.YnP.tH = paramInt1;
    }
    if (paramInt2 != -1) {
      this.YnP.tI = paramInt2;
    }
    if (this.YnP.tH > this.YnP.tI)
    {
      paramInt2 = this.YnP.tH;
      this.YnP.tH = this.YnP.tI;
      this.YnP.tI = paramInt2;
    }
    if (this.Yfs != null)
    {
      if (paramInt1 >= this.rR.getText().length())
      {
        AppMethodBeat.o(251129);
        return;
      }
      this.YnP.Yov = this.Yfs.subSequence(this.YnP.tH, this.YnP.tI).toString();
      this.rR.setHighlightColor(this.YnW);
      Selection.setSelection(this.Yfs, this.YnP.tH, this.YnP.tI);
    }
    AppMethodBeat.o(251129);
  }
  
  final void h(Menu paramMenu)
  {
    AppMethodBeat.i(251112);
    if ((paramMenu != null) && (this.Yof.Ygq.size() > 0))
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        av.d("SelectableEditTextHelper", "filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() });
        if (this.Yof.Ygq.contains(localMenuItem.getTitle()))
        {
          av.d("SelectableEditTextHelper", "reuse bingo:%s", new Object[] { localMenuItem.getTitle() });
          this.Ykv.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(251112);
  }
  
  final f icI()
  {
    AppMethodBeat.i(251117);
    if (this.YnO == null) {
      this.YnO = new f(this.mContext);
    }
    f localf = this.YnO;
    AppMethodBeat.o(251117);
    return localf;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(251123);
    this.mIsPause = true;
    cpo();
    AppMethodBeat.o(251123);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(251124);
    cpo();
    this.mIsPause = false;
    AppMethodBeat.o(251124);
  }
  
  protected void s(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(251126);
    if ((this.rR.getLayout() == null) || (this.rR.getWidth() == 0))
    {
      AppMethodBeat.o(251126);
      return;
    }
    if (this.YnM == null) {
      this.YnM = new b(true);
    }
    if (this.YnN == null) {
      this.YnN = new b(false);
    }
    paramInt1 = this.rR.getOffsetForPosition(paramInt1, paramInt2);
    if (!paramBoolean) {
      paramInt1 = this.rR.getSelectionStart();
    }
    for (;;)
    {
      if ((this.rR.getText() instanceof Spannable)) {
        this.Yfs = ((Spannable)this.rR.getText());
      }
      if (this.Yfs != null) {
        break;
      }
      AppMethodBeat.o(251126);
      return;
    }
    if ((paramInt1 < this.rR.getText().length()) && (paramBoolean))
    {
      paramInt2 = i;
      if (paramInt2 == 0) {
        break label226;
      }
      this.rR.setCursorVisible(false);
    }
    label226:
    for (i = paramInt1 + 1;; i = paramInt1)
    {
      if ((this.fYp) || (this.YnP.tH != paramInt1) || (this.YnP.tI != i)) {
        break label232;
      }
      AppMethodBeat.o(251126);
      return;
      paramInt2 = 0;
      break;
    }
    label232:
    cpq();
    cpn();
    this.fYp = false;
    fj(paramInt1, i);
    if (paramInt2 != 0)
    {
      a(this.YnM);
      a(this.YnN);
    }
    a(icI());
    AppMethodBeat.o(251126);
  }
  
  public static final class a
  {
    public String EJk;
    boolean HjZ;
    public Set<String> Ygq;
    int YnW;
    int YnX;
    float Yol;
    public Set<String> Yom;
    TextView rR;
    
    public a(TextView paramTextView)
    {
      AppMethodBeat.i(250257);
      this.YnX = com.tencent.mm.cr.a.c.cursor_handle_color;
      this.YnW = com.tencent.mm.cr.a.c.selected_blue;
      this.Yol = 18.0F;
      this.HjZ = true;
      this.Ygq = new HashSet();
      this.Yom = new HashSet();
      this.rR = paramTextView;
      AppMethodBeat.o(250257);
    }
    
    public final a icJ()
    {
      AppMethodBeat.i(250259);
      a locala = new a(this);
      AppMethodBeat.o(250259);
      return locala;
    }
  }
  
  public final class b
    extends View
  {
    private int Dvd;
    private int Dve;
    private int[] Dvf;
    int[] Ykw;
    boolean Yon;
    private int Yoo;
    private int Yop;
    private int clC;
    private int mHeight;
    private Paint mPaint;
    PopupWindow mPopupWindow;
    int mWidth;
    private int uue;
    
    public b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(251608);
      this.uue = (a.this.YnY / 2);
      this.mWidth = (this.uue * 2);
      this.mHeight = (this.uue * 2);
      this.clC = 25;
      this.Dvf = new int[2];
      this.Ykw = new int[2];
      this.Yon = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.YnX);
      this.mPopupWindow = new PopupWindow(this);
      this.mPopupWindow.setClippingEnabled(false);
      this.mPopupWindow.setWidth(this.mWidth + this.clC * 2);
      this.mPopupWindow.setHeight(this.mHeight + this.clC / 2);
      invalidate();
      AppMethodBeat.o(251608);
    }
    
    private int a(int paramInt, Layout paramLayout)
    {
      AppMethodBeat.i(251615);
      paramInt = paramLayout.getLineBottom(paramLayout.getLineForOffset(paramInt));
      paramInt = getExtraY() + paramInt;
      int i = this.Ykw[1] + a.this.rR.getHeight() - a.this.rR.getPaddingBottom();
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        i = paramInt;
        if (paramInt < this.Ykw[1]) {
          i = this.Ykw[1];
        }
        AppMethodBeat.o(251615);
        return i;
      }
    }
    
    private void icK()
    {
      AppMethodBeat.i(251613);
      if (!this.Yon) {}
      for (boolean bool = true;; bool = false)
      {
        this.Yon = bool;
        invalidate();
        AppMethodBeat.o(251613);
        return;
      }
    }
    
    private void icL()
    {
      AppMethodBeat.i(251614);
      a.this.rR.getLocationInWindow(this.Ykw);
      Layout localLayout = a.this.rR.getLayout();
      if (this.Yon)
      {
        i = a(a.this.YnP.tH, localLayout);
        mW((int)localLayout.getPrimaryHorizontal(a.this.YnP.tH) - this.mWidth + getExtraX(), i);
        AppMethodBeat.o(251614);
        return;
      }
      int i = a(a.this.YnP.tI, localLayout);
      mW((int)localLayout.getPrimaryHorizontal(a.this.YnP.tI) + getExtraX(), i);
      AppMethodBeat.o(251614);
    }
    
    public final int getExtraX()
    {
      AppMethodBeat.i(251617);
      int i = this.Ykw[0];
      int j = this.clC;
      int k = a.this.rR.getPaddingLeft();
      AppMethodBeat.o(251617);
      return i - j + k;
    }
    
    public final int getExtraY()
    {
      AppMethodBeat.i(251618);
      int i = this.Ykw[1];
      int j = a.this.rR.getPaddingTop();
      int k = a.this.rR.getScrollY();
      AppMethodBeat.o(251618);
      return i + j - k;
    }
    
    final void mW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251616);
      try
      {
        if (this.mPopupWindow.isShowing())
        {
          this.mPopupWindow.update(paramInt1, paramInt2, -1, -1);
          AppMethodBeat.o(251616);
          return;
        }
        this.mPopupWindow.showAtLocation(a.this.rR, 0, paramInt1, paramInt2);
        AppMethodBeat.o(251616);
        return;
      }
      catch (Exception localException)
      {
        av.e("SelectableEditTextHelper", "cursor error!: %s.", new Object[] { localException.getMessage() });
        AppMethodBeat.o(251616);
      }
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(251610);
      paramCanvas.drawCircle(this.uue + this.clC, this.uue, this.uue, this.mPaint);
      if (this.Yon)
      {
        paramCanvas.drawRect(this.uue + this.clC, 0.0F, this.uue * 2 + this.clC, this.uue, this.mPaint);
        AppMethodBeat.o(251610);
        return;
      }
      paramCanvas.drawRect(this.clC, 0.0F, this.uue + this.clC, this.uue, this.mPaint);
      AppMethodBeat.o(251610);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251612);
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 1: 
      case 3: 
        for (;;)
        {
          AppMethodBeat.o(251612);
          return true;
          this.Yoo = a.this.YnP.tH;
          this.Yop = a.this.YnP.tI;
          this.Dvd = ((int)paramMotionEvent.getX());
          this.Dve = ((int)paramMotionEvent.getY());
          a.this.rR.getLocationInWindow(this.Dvf);
          continue;
          a.this.a(a.this.icI());
        }
      }
      a.this.b(a.this.icI());
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      int m = this.Dvf[0];
      int n = this.Dve;
      int i1 = this.mHeight;
      int i2 = a.this.Yoa;
      int i3 = a.this.rR.getScrollY();
      a.this.rR.getLocationInWindow(this.Ykw);
      int i;
      if (this.Yon)
      {
        i = a.this.YnP.tH;
        label227:
        int i4 = this.Ykw[1];
        j = com.tencent.mm.ui.widget.textview.b.i(a.this.rR, j - m, i3 + (n + k - i1 - i2) - i4, i);
        if (j != i)
        {
          a.this.cpn();
          if (!this.Yon) {
            break label393;
          }
          if (j <= this.Yop) {
            break label381;
          }
          paramMotionEvent = a.a(a.this, false);
          icK();
          paramMotionEvent.icK();
          this.Yoo = this.Yop;
          a.this.fj(this.Yop, j);
          paramMotionEvent.icL();
          label336:
          icL();
        }
        paramMotionEvent = a.this;
        if (this.Yon) {
          break label464;
        }
      }
      label393:
      label464:
      for (boolean bool = true;; bool = false)
      {
        a.a(paramMotionEvent, bool).icL();
        break;
        i = a.this.YnP.tI;
        break label227;
        label381:
        a.this.fj(j, -1);
        break label336;
        if (j < this.Yoo)
        {
          paramMotionEvent = a.a(a.this, true);
          paramMotionEvent.icK();
          icK();
          this.Yop = this.Yoo;
          a.this.fj(j, this.Yoo);
          paramMotionEvent.icL();
        }
        for (;;)
        {
          icL();
          break;
          a.this.fj(this.Yoo, j);
        }
      }
    }
  }
  
  public static final class c
  {
    public int Yoq;
    public int id;
    public String name;
    
    public c(String paramString, int paramInt)
    {
      this.name = paramString;
      this.id = paramInt;
      this.Yoq = 15;
    }
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.id = paramInt1;
      this.Yoq = paramInt2;
    }
  }
  
  public static final class d
    extends RecyclerView.a<a>
  {
    private a.e YkA;
    private a.g YnP;
    public List<a.c> uAd;
    
    public d(List<a.c> paramList, a.e parame, a.g paramg)
    {
      this.uAd = paramList;
      this.YkA = parame;
      this.YnP = paramg;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(251061);
      int i = this.uAd.size();
      AppMethodBeat.o(251061);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView bFR;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(252013);
        this.bFR = ((TextView)paramView.findViewById(com.tencent.mm.cr.a.f.menu_item_tv));
        this.bFR.setTextSize(1, 14.0F);
        AppMethodBeat.o(252013);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void B(List<a.c> paramList, int paramInt);
    
    public abstract void a(View paramView, a.c paramc, String paramString);
  }
  
  public final class f
  {
    List<a.c> Ykr;
    ImageView Yks;
    a.d Yos;
    int mHeight;
    RecyclerView mRecyclerView;
    int mWidth;
    PopupWindow usB;
    
    public f(Context paramContext)
    {
      AppMethodBeat.i(250693);
      paramContext = LayoutInflater.from(paramContext).inflate(com.tencent.mm.cr.a.g.layout_operate_windows, null);
      paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = paramContext.getMeasuredWidth();
      this.mHeight = paramContext.getMeasuredHeight();
      this.usB = new PopupWindow(paramContext, -2, -2, false);
      this.usB.setClippingEnabled(false);
      this.mRecyclerView = ((RecyclerView)paramContext.findViewById(com.tencent.mm.cr.a.f.rv_list));
      Object localObject = new LinearLayoutManager(0, false);
      this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      localObject = new LinkedList();
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(a.i.menu_select), 1, 4));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039373), 16908319, 12));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039363), 16908320, 9));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039361), 16908321, 9));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039371), 16908322));
      this.Ykr = ((List)localObject);
      this.Yos = new a.d(this.Ykr, new a.e()
      {
        public final void B(List<a.c> paramAnonymousList, int paramAnonymousInt) {}
        
        public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
        {
          AppMethodBeat.i(249518);
          a.f.a(a.f.this, paramAnonymousView, paramAnonymousc, paramAnonymousString);
          AppMethodBeat.o(249518);
        }
      }, a.this.YnP);
      this.mRecyclerView.setAdapter(this.Yos);
      localObject = new i(a.this.mContext, 0);
      ((i)localObject).t(new ColorDrawable(a.this.mContext.getResources().getColor(com.tencent.mm.cr.a.c.input_menu_divider)));
      this.mRecyclerView.a((RecyclerView.h)localObject);
      this.Yks = ((ImageView)paramContext.findViewById(com.tencent.mm.cr.a.f.cursor_iv));
      AppMethodBeat.o(250693);
    }
  }
  
  public static final class g
  {
    public String Yov;
    public int tH;
    public int tI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.a
 * JD-Core Version:    0.7.0.1
 */