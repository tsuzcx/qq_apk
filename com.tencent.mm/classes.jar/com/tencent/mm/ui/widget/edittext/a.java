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
import androidx.recyclerview.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.i;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bg;
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
  boolean NhM;
  private View.OnLayoutChangeListener adAI;
  private Spannable afXs;
  private Menu agct;
  Map<Integer, CharSequence> agcu;
  int[] agcv;
  public e agcz;
  b agfY;
  b agfZ;
  private f agga;
  g aggb;
  private ViewTreeObserver.OnScrollChangedListener aggc;
  private View.OnAttachStateChangeListener aggd;
  public View.OnLongClickListener agge;
  public View.OnTouchListener aggf;
  public View.OnFocusChangeListener aggg;
  public View.OnClickListener aggh;
  private int aggi;
  int aggj;
  int aggk;
  boolean aggl;
  int aggm;
  boolean aggn;
  boolean aggo;
  int aggp;
  int aggq;
  private a aggr;
  boolean aggs;
  private ActionMode.Callback aggt;
  int aggu;
  private final Runnable aggv;
  private ViewTreeObserver.OnPreDrawListener cfn;
  boolean iep;
  Context mContext;
  private boolean mIsPause;
  TextView sQ;
  int uIW;
  private TextWatcher vU;
  
  protected a(a parama)
  {
    AppMethodBeat.i(252039);
    this.aggb = new g();
    this.iep = true;
    this.aggn = false;
    this.aggo = false;
    this.agcu = new HashMap();
    this.agcv = new int[2];
    this.aggt = new ActionMode.Callback()
    {
      public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
      
      public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        AppMethodBeat.i(251985);
        bc.d("SelectableEditTextHelper", "mDisableCallback", new Object[0]);
        a.this.h(paramAnonymousMenu);
        AppMethodBeat.o(251985);
        return false;
      }
      
      public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
      
      public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    };
    this.aggu = -1;
    this.aggv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(251991);
        if (a.this.iep)
        {
          AppMethodBeat.o(251991);
          return;
        }
        a.this.a(a.this.jHU());
        a.this.a(a.this.agfY);
        a.this.a(a.this.agfZ);
        AppMethodBeat.o(251991);
      }
    };
    this.mIsPause = false;
    this.aggr = parama;
    this.sQ = parama.sQ;
    this.mContext = this.sQ.getContext();
    this.aggi = this.mContext.getResources().getColor(parama.aggi);
    this.aggj = this.mContext.getResources().getColor(parama.aggj);
    this.aggk = bd.fromDPToPix(this.mContext, (int)parama.aggx);
    this.aggm = com.tencent.mm.ui.widget.textview.b.mw(this.sQ);
    this.NhM = parama.NhM;
    if ((Build.VERSION.SDK_INT >= 29) && ((bg.isMIUI()) || (bg.jlr()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aggs = bool;
      bc.i("SelectableEditTextHelper", "init %s,%s,%s", new Object[] { Boolean.valueOf(this.NhM), this.aggr.KCR, Build.BRAND });
      this.sQ.setText(this.sQ.getText(), TextView.BufferType.SPANNABLE);
      this.afXs = ((Spannable)this.sQ.getText());
      this.sQ.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251999);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          if (a.this.agge != null) {}
          for (boolean bool = a.this.agge.onLongClick(paramAnonymousView);; bool = false)
          {
            if (a.this.NhM)
            {
              bc.i("SelectableEditTextHelper", "onLongClick:" + a.this.aggn, new Object[0]);
              paramAnonymousView = a.this;
              if ((!TextUtils.isEmpty(Build.BRAND)) && ("vivo".equals(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT < 23)) {
                paramAnonymousView.sQ.post(new a.2(paramAnonymousView));
              }
              if (a.this.aggn)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(251999);
                return false;
              }
              a.this.aggo = true;
              a.a(a.this, a.this.aggp, a.this.aggq);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(251999);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(251999);
            return bool;
          }
        }
      });
      this.sQ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(251996);
          if (a.this.aggf != null) {}
          for (boolean bool = a.this.aggf.onTouch(paramAnonymousView, paramAnonymousMotionEvent);; bool = false)
          {
            if (a.this.NhM)
            {
              a.this.aggp = ((int)paramAnonymousMotionEvent.getX());
              a.this.aggq = ((int)paramAnonymousMotionEvent.getY());
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
              do
              {
                for (;;)
                {
                  a.this.uIW = a.this.sQ.getScrollY();
                  AppMethodBeat.o(251996);
                  return false;
                  a.this.aggo = false;
                  if (a.this.aggs)
                  {
                    a.O(a.this.sQ);
                    a.this.aggs = false;
                  }
                  paramAnonymousView = a.this;
                  try
                  {
                    bc.d("SelectableEditTextHelper", "setInsertionDisabled", new Object[0]);
                    paramAnonymousMotionEvent = TextView.class.getDeclaredField("mEditor");
                    paramAnonymousMotionEvent.setAccessible(true);
                    paramAnonymousView = paramAnonymousMotionEvent.get(paramAnonymousView.sQ);
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
                    bc.e("SelectableEditTextHelper", "setInsertionDisabled error msg:%s", new Object[] { paramAnonymousView.getMessage() });
                  }
                  continue;
                  if ((bg.isMIUI()) && (a.this.aggo))
                  {
                    AppMethodBeat.o(251996);
                    return true;
                  }
                  if (a.this.uIW != a.this.sQ.getScrollY())
                  {
                    a.this.aggn = true;
                    if ((!a.this.aggl) && (!a.this.iep))
                    {
                      a.this.aggl = true;
                      a.this.b(a.this.jHU());
                      a.this.b(a.this.agfY);
                      a.this.b(a.this.agfZ);
                    }
                  }
                }
              } while (!a.this.aggn);
              a.this.aggn = false;
              if (a.this.aggl)
              {
                a.this.aggl = false;
                a.this.cRS().run();
              }
              AppMethodBeat.o(251996);
              return true;
            }
            AppMethodBeat.o(251996);
            return bool;
          }
        }
      });
      this.sQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252003);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (a.this.NhM)
          {
            bc.i("SelectableEditTextHelper", "onClick", new Object[0]);
            a.this.NH(true);
          }
          if (a.this.aggh != null) {
            a.this.aggh.onClick(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252003);
        }
      });
      this.sQ.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(251998);
          if (a.this.NhM)
          {
            bc.d("SelectableEditTextHelper", "onFocusChange:".concat(String.valueOf(paramAnonymousBoolean)), new Object[0]);
            if (!paramAnonymousBoolean) {
              a.this.NH(false);
            }
          }
          if (a.this.aggg != null) {
            a.this.aggg.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
          }
          AppMethodBeat.o(251998);
        }
      });
      if (this.NhM)
      {
        this.sQ.setCustomSelectionActionModeCallback(this.aggt);
        if (Build.VERSION.SDK_INT >= 23) {
          this.sQ.setCustomInsertionActionModeCallback(this.aggt);
        }
        this.vU = new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(252011);
            if (!a.this.iep)
            {
              a.this.cRQ();
              a.this.cRT();
            }
            a.this.sQ.setCursorVisible(true);
            a.this.aggu = a.this.sQ.getSelectionStart();
            AppMethodBeat.o(252011);
          }
        };
        this.aggd = new View.OnAttachStateChangeListener()
        {
          public final void onViewAttachedToWindow(View paramAnonymousView) {}
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(252006);
            bc.d("SelectableEditTextHelper", "onViewDetachedFromWindow:", new Object[0]);
            a.this.destroy();
            AppMethodBeat.o(252006);
          }
        };
        this.adAI = new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(252013);
            if (a.this.iep)
            {
              AppMethodBeat.o(252013);
              return;
            }
            paramAnonymousView = new int[2];
            paramAnonymousView[0] = a.this.agcv[0];
            paramAnonymousView[1] = a.this.agcv[1];
            a.this.sQ.getLocationInWindow(a.this.agcv);
            bc.d("SelectableEditTextHelper", "LayoutChangeFromWindow l:%d,t:%d,r:%d,b:%d,oldl:%d,oldt:%d,oldr:%d,oldb:%d,oldx:%d, newx:%d, oldy:%d, newy:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), Integer.valueOf(paramAnonymousInt5), Integer.valueOf(paramAnonymousInt6), Integer.valueOf(paramAnonymousInt7), Integer.valueOf(paramAnonymousInt8), Integer.valueOf(paramAnonymousView[0]), Integer.valueOf(a.this.agcv[0]), Integer.valueOf(paramAnonymousView[1]), Integer.valueOf(a.this.agcv[1]) });
            if ((paramAnonymousInt2 != paramAnonymousInt6) || (paramAnonymousInt4 != paramAnonymousInt8) || (paramAnonymousView[1] != a.this.agcv[1])) {
              a.this.cRR();
            }
            AppMethodBeat.o(252013);
          }
        };
        this.cfn = new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            return true;
          }
        };
        this.aggc = new ViewTreeObserver.OnScrollChangedListener()
        {
          public final void onScrollChanged() {}
        };
        this.sQ.addTextChangedListener(this.vU);
        this.sQ.addOnAttachStateChangeListener(this.aggd);
        this.sQ.addOnLayoutChangeListener(this.adAI);
        this.sQ.getViewTreeObserver().addOnPreDrawListener(this.cfn);
        this.sQ.getViewTreeObserver().addOnScrollChangedListener(this.aggc);
      }
      AppMethodBeat.o(252039);
      return;
    }
  }
  
  public static boolean O(TextView paramTextView)
  {
    AppMethodBeat.i(252065);
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      paramTextView = ((Field)localObject).get(paramTextView);
      localObject = Class.forName("android.widget.Editor");
      localObject = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(localObject, new Object[] { "getEmailPopupWindow", null });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramTextView, new Object[0]);
      bc.i("SelectableEditTextHelper", "getEmailPopupWindow succ", new Object[0]);
      AppMethodBeat.o(252065);
      return true;
    }
    finally
    {
      bc.e("SelectableEditTextHelper", "getEmailPopupWindow err:%s", new Object[] { paramTextView.getMessage() });
      AppMethodBeat.o(252065);
    }
    return false;
  }
  
  private static boolean a(TextView paramTextView, Menu paramMenu)
  {
    AppMethodBeat.i(252056);
    try
    {
      Object localObject1 = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject1).setAccessible(true);
      Object localObject3 = ((Field)localObject1).get(paramTextView);
      Class localClass2 = Class.forName("android.widget.Editor");
      Class localClass1 = Class.forName("android.widget.Editor$TextActionModeCallback");
      Object localObject2 = paramTextView.getTag(com.tencent.mm.ck.a.f.text_view_callback);
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
        paramTextView.setTag(com.tencent.mm.ck.a.f.text_view_callback, localObject1);
        return true;
        label178:
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Boolean.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      return false;
    }
    finally
    {
      bc.e("SelectableEditTextHelper", "populateMenuItems err", new Object[0]);
      AppMethodBeat.o(252056);
    }
  }
  
  private void jHT()
  {
    AppMethodBeat.i(252048);
    long l1 = System.currentTimeMillis();
    try
    {
      Object localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(this.sQ, Integer.valueOf(com.tencent.mm.ck.a.e.trans_drawable));
      boolean bool1 = jHm();
      localObject = this.sQ;
      if (this.agct == null) {
        this.agct = new s(this.mContext);
      }
      this.agct.clear();
      jHm();
      boolean bool2 = a((TextView)localObject, this.agct);
      h(this.agct);
      long l2 = System.currentTimeMillis();
      bc.i("SelectableEditTextHelper", "startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(252048);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bc.e("SelectableEditTextHelper", "disableSysHandle fail:", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static boolean jHm()
  {
    AppMethodBeat.i(252060);
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        Object localObject3 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
        Class localClass = (Class)((Method)localObject3).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        localObject3 = (Method)localMethod.invoke(localClass, new Object[] { "getRuntime", null });
        localMethod = (Method)localMethod.invoke(localClass, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject3 = ((Method)localObject3).invoke(null, new Object[0]);
        if ((localObject3 == null) || (localMethod == null))
        {
          AppMethodBeat.o(252060);
          return false;
        }
        try
        {
          localMethod.invoke(localObject3, new Object[] { { "L" } });
        }
        finally {}
        AppMethodBeat.o(252060);
      }
      finally
      {
        AppMethodBeat.o(252060);
        return false;
      }
    }
    return true;
  }
  
  final void NH(boolean paramBoolean)
  {
    AppMethodBeat.i(252088);
    if (this.mIsPause)
    {
      AppMethodBeat.o(252088);
      return;
    }
    if (!paramBoolean)
    {
      cRR();
      AppMethodBeat.o(252088);
      return;
    }
    int i = this.sQ.getSelectionStart();
    if ((this.iep) && (this.aggu == i))
    {
      s(this.aggp, this.aggq, false);
      this.aggu = i;
    }
    for (;;)
    {
      this.sQ.setCursorVisible(true);
      this.aggu = i;
      AppMethodBeat.o(252088);
      return;
      cRR();
    }
  }
  
  protected void a(b paramb)
  {
    AppMethodBeat.i(252139);
    if (paramb == null)
    {
      AppMethodBeat.o(252139);
      return;
    }
    try
    {
      Layout localLayout = this.sQ.getLayout();
      int j;
      int k;
      if (b.c(paramb))
      {
        i = this.aggb.uG;
        j = (int)localLayout.getPrimaryHorizontal(i);
        k = localLayout.getLineBottom(localLayout.getLineForOffset(i));
        paramb.aggw.sQ.getLocationInWindow(paramb.agcv);
        if (!paramb.aggA) {
          break label189;
        }
      }
      label189:
      for (int i = paramb.mWidth;; i = 0)
      {
        int m = paramb.getExtraX();
        k += paramb.getExtraY();
        if ((k >= paramb.agcv[1]) && (k <= paramb.agcv[1] + paramb.aggw.sQ.getHeight() - paramb.aggw.sQ.getPaddingBottom() + bd.fromDPToPix(paramb.aggw.mContext, 5))) {
          paramb.oP(j - i + m, k);
        }
        AppMethodBeat.o(252139);
        return;
        i = this.aggb.uH;
        break;
      }
      return;
    }
    finally
    {
      bc.e("SelectableEditTextHelper", "show cursor err：%s", new Object[] { Log.getStackTraceString(paramb) });
      AppMethodBeat.o(252139);
    }
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(252198);
    if (paramf != null) {}
    int i;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      try
      {
        i = paramf.aggw.sQ.getText().length();
        if ((i <= 0) || (paramf.aggw.aggb.uG != 0) || (paramf.aggw.aggb.uH != i)) {
          break label151;
        }
        i = 1;
        localObject1 = new LinkedList();
        localObject2 = paramf.agcq.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (c)((Iterator)localObject2).next();
        if ((((c)localObject3).aggD & i) == 0) {
          continue;
        }
        ((List)localObject1).add(localObject3);
        continue;
        AppMethodBeat.o(252198);
      }
      finally
      {
        bc.e("SelectableEditTextHelper", "show oper err：%s", new Object[] { Log.getStackTraceString(paramf) });
      }
      return;
      label151:
      if (paramf.aggw.aggb.uG != paramf.aggw.aggb.uH) {
        break label1113;
      }
      if (i <= 0) {
        break label1108;
      }
      i = 4;
    }
    paramf.aggw.agcu.clear();
    Object localObject2 = paramf.aggw;
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
    if ((((a)localObject2).aggr.afYq.size() > 0) && (Build.BRAND != null) && (((a)localObject2).aggr.aggy.contains(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT >= 23) && (((a)localObject2).NhM))
    {
      j = 1;
      if (j != 0)
      {
        bc.i("SelectableEditTextHelper", "tryGetMenus", new Object[0]);
        paramf.aggw.jHT();
      }
      if (paramf.aggw.agcu.size() > 0)
      {
        localObject2 = paramf.aggw.agcu.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          ((List)localObject1).add(new c(((CharSequence)((Map.Entry)localObject3).getValue()).toString(), ((Integer)((Map.Entry)localObject3).getKey()).intValue()));
        }
      }
      if (paramf.aggw.agcz != null) {
        paramf.aggw.agcz.I((List)localObject1, i);
      }
      paramf.aggF.xGG = ((List)localObject1);
      paramf.aggF.bZE.notifyChanged();
      localObject1 = paramf.xyX.getContentView();
      ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramf.mWidth = ((View)localObject1).getMeasuredWidth();
      paramf.mHeight = ((View)localObject1).getMeasuredHeight();
      paramf.aggw.sQ.getLocationInWindow(paramf.aggw.agcv);
      localObject1 = paramf.aggw.sQ.getLayout();
      i1 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(paramf.aggw.mContext);
      m = bd.fromDPToPix(paramf.aggw.mContext, 10);
      i = i1 - m * 2;
      if (paramf.mWidth >= i) {
        paramf.mWidth = i;
      }
      j = ((int)((Layout)localObject1).getPrimaryHorizontal(paramf.aggw.aggb.uG) + (int)((Layout)localObject1).getPrimaryHorizontal(paramf.aggw.aggb.uH)) / 2 + paramf.aggw.agcv[0] - paramf.mWidth / 2 + paramf.aggw.sQ.getPaddingLeft();
      i = j;
      if (paramf.aggw.aggb.uG != paramf.aggw.aggb.uH)
      {
        i = j;
        if (((Layout)localObject1).getLineForOffset(paramf.aggw.aggb.uG) != ((Layout)localObject1).getLineForOffset(paramf.aggw.aggb.uH)) {
          i = paramf.aggw.agcv[0] + paramf.aggw.sQ.getWidth() / 2 - paramf.mWidth / 2;
        }
      }
      k = ((Layout)localObject1).getLineTop(((Layout)localObject1).getLineForOffset(paramf.aggw.aggb.uG)) + paramf.aggw.agcv[1] - paramf.mHeight + paramf.aggw.sQ.getPaddingTop() - paramf.aggw.sQ.getScrollY() - bd.fromDPToPix(paramf.aggw.mContext, 5);
      n = paramf.aggw.agcv[1] - paramf.mHeight - bd.fromDPToPix(paramf.aggw.mContext, 5);
      i2 = paramf.aggw.agcv[1];
      i3 = paramf.aggw.sQ.getHeight();
      i4 = paramf.mHeight;
      i5 = bd.fromDPToPix(paramf.aggw.mContext, 5);
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
        ((LinearLayout.LayoutParams)paramf.agcr.getLayoutParams()).leftMargin = (i - j);
        if (Build.VERSION.SDK_INT >= 21) {
          paramf.xyX.setElevation(8.0F);
        }
        localObject1 = paramf.mRecyclerView.getLayoutManager();
        if ((localObject1 instanceof LinearLayoutManager))
        {
          localObject1 = (LinearLayoutManager)localObject1;
          localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((LinearLayoutManager)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        paramf.xyX.setWidth(paramf.mWidth);
        try
        {
          paramf.xyX.showAtLocation(paramf.aggw.sQ, 0, j, k);
          AppMethodBeat.o(252198);
          return;
        }
        catch (Exception paramf)
        {
          bc.e("SelectableEditTextHelper", "oper error!:%s", new Object[] { paramf.getMessage() });
        }
        AppMethodBeat.o(252198);
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
    AppMethodBeat.i(252209);
    if (paramb != null) {
      paramb.aggz.dismiss();
    }
    AppMethodBeat.o(252209);
  }
  
  protected void b(f paramf)
  {
    AppMethodBeat.i(252203);
    if (paramf != null) {
      paramf.xyX.dismiss();
    }
    AppMethodBeat.o(252203);
  }
  
  protected void cRQ()
  {
    this.aggb.aggI = null;
  }
  
  public void cRR()
  {
    AppMethodBeat.i(252086);
    cRQ();
    cRT();
    Selection.setSelection(this.sQ.getEditableText(), this.sQ.getSelectionEnd());
    this.sQ.setCursorVisible(true);
    AppMethodBeat.o(252086);
  }
  
  protected Runnable cRS()
  {
    return this.aggv;
  }
  
  protected void cRT()
  {
    AppMethodBeat.i(252094);
    this.iep = true;
    b(this.agfY);
    b(this.agfZ);
    b(this.agga);
    AppMethodBeat.o(252094);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(252160);
    this.sQ.removeTextChangedListener(this.vU);
    this.sQ.removeOnAttachStateChangeListener(this.aggd);
    this.sQ.removeOnLayoutChangeListener(this.adAI);
    this.sQ.getViewTreeObserver().removeOnScrollChangedListener(this.aggc);
    this.sQ.getViewTreeObserver().removeOnPreDrawListener(this.cfn);
    cRQ();
    cRT();
    this.agfY = null;
    this.agfZ = null;
    this.agga = null;
    AppMethodBeat.o(252160);
  }
  
  protected void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252152);
    if (paramInt1 != -1) {
      this.aggb.uG = paramInt1;
    }
    if (paramInt2 != -1) {
      this.aggb.uH = paramInt2;
    }
    if (this.aggb.uG > this.aggb.uH)
    {
      paramInt2 = this.aggb.uG;
      this.aggb.uG = this.aggb.uH;
      this.aggb.uH = paramInt2;
    }
    if (this.afXs != null)
    {
      if (paramInt1 >= this.sQ.getText().length())
      {
        AppMethodBeat.o(252152);
        return;
      }
      this.aggb.aggI = this.afXs.subSequence(this.aggb.uG, this.aggb.uH).toString();
      this.sQ.setHighlightColor(this.aggi);
      Selection.setSelection(this.afXs, this.aggb.uG, this.aggb.uH);
    }
    AppMethodBeat.o(252152);
  }
  
  final void h(Menu paramMenu)
  {
    AppMethodBeat.i(252078);
    if ((paramMenu != null) && (this.aggr.afYq.size() > 0))
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        bc.d("SelectableEditTextHelper", "filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() });
        if (this.aggr.afYq.contains(localMenuItem.getTitle()))
        {
          bc.d("SelectableEditTextHelper", "reuse bingo:%s", new Object[] { localMenuItem.getTitle() });
          this.agcu.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(252078);
  }
  
  final f jHU()
  {
    AppMethodBeat.i(252083);
    if (this.agga == null) {
      this.agga = new f(this.mContext);
    }
    f localf = this.agga;
    AppMethodBeat.o(252083);
    return localf;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(252107);
    this.mIsPause = true;
    cRR();
    AppMethodBeat.o(252107);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(252116);
    cRR();
    this.mIsPause = false;
    AppMethodBeat.o(252116);
  }
  
  protected void s(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(252127);
    if ((this.sQ.getLayout() == null) || (this.sQ.getWidth() == 0))
    {
      AppMethodBeat.o(252127);
      return;
    }
    if (this.agfY == null) {
      this.agfY = new b(true);
    }
    if (this.agfZ == null) {
      this.agfZ = new b(false);
    }
    paramInt1 = this.sQ.getOffsetForPosition(paramInt1, paramInt2);
    if (!paramBoolean) {
      paramInt1 = this.sQ.getSelectionStart();
    }
    for (;;)
    {
      if ((this.sQ.getText() instanceof Spannable)) {
        this.afXs = ((Spannable)this.sQ.getText());
      }
      if (this.afXs != null) {
        break;
      }
      AppMethodBeat.o(252127);
      return;
    }
    if ((paramInt1 < this.sQ.getText().length()) && (paramBoolean))
    {
      paramInt2 = i;
      if (paramInt2 == 0) {
        break label226;
      }
      this.sQ.setCursorVisible(false);
    }
    label226:
    for (i = paramInt1 + 1;; i = paramInt1)
    {
      if ((this.iep) || (this.aggb.uG != paramInt1) || (this.aggb.uH != i)) {
        break label232;
      }
      AppMethodBeat.o(252127);
      return;
      paramInt2 = 0;
      break;
    }
    label232:
    cRT();
    cRQ();
    this.iep = false;
    gc(paramInt1, i);
    if (paramInt2 != 0)
    {
      a(this.agfY);
      a(this.agfZ);
    }
    a(jHU());
    AppMethodBeat.o(252127);
  }
  
  public static final class a
  {
    public String KCR;
    boolean NhM;
    Set<String> afYq;
    int aggi;
    int aggj;
    float aggx;
    Set<String> aggy;
    TextView sQ;
    
    public a(TextView paramTextView)
    {
      AppMethodBeat.i(252022);
      this.aggj = com.tencent.mm.ck.a.c.cursor_handle_color;
      this.aggi = com.tencent.mm.ck.a.c.selected_blue;
      this.aggx = 18.0F;
      this.NhM = true;
      this.afYq = new HashSet();
      this.aggy = new HashSet();
      this.sQ = paramTextView;
      AppMethodBeat.o(252022);
    }
    
    public final a jHV()
    {
      AppMethodBeat.i(252038);
      a locala = new a(this);
      AppMethodBeat.o(252038);
      return locala;
    }
    
    public final a oq(List<String> paramList)
    {
      AppMethodBeat.i(252030);
      if (paramList != null) {
        this.aggy.addAll(paramList);
      }
      AppMethodBeat.o(252030);
      return this;
    }
    
    public final a or(List<String> paramList)
    {
      AppMethodBeat.i(252034);
      if (paramList != null) {
        this.afYq.addAll(paramList);
      }
      AppMethodBeat.o(252034);
      return this;
    }
  }
  
  public final class b
    extends View
  {
    private int JoA;
    private int JoB;
    private int[] JoC;
    int[] agcv;
    boolean aggA;
    private int aggB;
    private int aggC;
    PopupWindow aggz;
    private int ebX;
    private int mHeight;
    private Paint mPaint;
    int mWidth;
    private int xAB;
    
    public b(boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(252025);
      this.xAB = (a.this.aggk / 2);
      this.mWidth = (this.xAB * 2);
      this.mHeight = (this.xAB * 2);
      this.ebX = 25;
      this.JoC = new int[2];
      this.agcv = new int[2];
      this.aggA = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.aggj);
      this.aggz = new PopupWindow(this);
      this.aggz.setClippingEnabled(false);
      this.aggz.setWidth(this.mWidth + this.ebX * 2);
      this.aggz.setHeight(this.mHeight + this.ebX / 2);
      invalidate();
      AppMethodBeat.o(252025);
    }
    
    private int a(int paramInt, Layout paramLayout)
    {
      AppMethodBeat.i(252043);
      paramInt = paramLayout.getLineBottom(paramLayout.getLineForOffset(paramInt));
      paramInt = getExtraY() + paramInt;
      int i = this.agcv[1] + a.this.sQ.getHeight() - a.this.sQ.getPaddingBottom();
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        i = paramInt;
        if (paramInt < this.agcv[1]) {
          i = this.agcv[1];
        }
        AppMethodBeat.o(252043);
        return i;
      }
    }
    
    private void jHW()
    {
      AppMethodBeat.i(252031);
      if (!this.aggA) {}
      for (boolean bool = true;; bool = false)
      {
        this.aggA = bool;
        invalidate();
        AppMethodBeat.o(252031);
        return;
      }
    }
    
    private void jHX()
    {
      AppMethodBeat.i(252037);
      a.this.sQ.getLocationInWindow(this.agcv);
      Layout localLayout = a.this.sQ.getLayout();
      if (this.aggA)
      {
        i = a(a.this.aggb.uG, localLayout);
        oP((int)localLayout.getPrimaryHorizontal(a.this.aggb.uG) - this.mWidth + getExtraX(), i);
        AppMethodBeat.o(252037);
        return;
      }
      int i = a(a.this.aggb.uH, localLayout);
      oP((int)localLayout.getPrimaryHorizontal(a.this.aggb.uH) + getExtraX(), i);
      AppMethodBeat.o(252037);
    }
    
    public final int getExtraX()
    {
      AppMethodBeat.i(252067);
      int i = this.agcv[0];
      int j = this.ebX;
      int k = a.this.sQ.getPaddingLeft();
      AppMethodBeat.o(252067);
      return i - j + k;
    }
    
    public final int getExtraY()
    {
      AppMethodBeat.i(252072);
      int i = this.agcv[1];
      int j = a.this.sQ.getPaddingTop();
      int k = a.this.sQ.getScrollY();
      AppMethodBeat.o(252072);
      return i + j - k;
    }
    
    final void oP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252062);
      try
      {
        if (this.aggz.isShowing())
        {
          this.aggz.update(paramInt1, paramInt2, -1, -1);
          AppMethodBeat.o(252062);
          return;
        }
        this.aggz.showAtLocation(a.this.sQ, 0, paramInt1, paramInt2);
        AppMethodBeat.o(252062);
        return;
      }
      catch (Exception localException)
      {
        bc.e("SelectableEditTextHelper", "cursor error!: %s.", new Object[] { localException.getMessage() });
        AppMethodBeat.o(252062);
      }
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(252052);
      paramCanvas.drawCircle(this.xAB + this.ebX, this.xAB, this.xAB, this.mPaint);
      if (this.aggA)
      {
        paramCanvas.drawRect(this.xAB + this.ebX, 0.0F, this.xAB * 2 + this.ebX, this.xAB, this.mPaint);
        AppMethodBeat.o(252052);
        return;
      }
      paramCanvas.drawRect(this.ebX, 0.0F, this.xAB + this.ebX, this.xAB, this.mPaint);
      AppMethodBeat.o(252052);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252058);
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 1: 
      case 3: 
        for (;;)
        {
          AppMethodBeat.o(252058);
          return true;
          this.aggB = a.this.aggb.uG;
          this.aggC = a.this.aggb.uH;
          this.JoA = ((int)paramMotionEvent.getX());
          this.JoB = ((int)paramMotionEvent.getY());
          a.this.sQ.getLocationInWindow(this.JoC);
          continue;
          a.this.a(a.this.jHU());
        }
      }
      a.this.b(a.this.jHU());
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      int m = this.JoC[0];
      int n = this.JoB;
      int i1 = this.mHeight;
      int i2 = a.this.aggm;
      int i3 = a.this.sQ.getScrollY();
      a.this.sQ.getLocationInWindow(this.agcv);
      int i;
      if (this.aggA)
      {
        i = a.this.aggb.uG;
        label227:
        int i4 = this.agcv[1];
        j = com.tencent.mm.ui.widget.textview.b.h(a.this.sQ, j - m, i3 + (n + k - i1 - i2) - i4, i);
        if (j != i)
        {
          a.this.cRQ();
          if (!this.aggA) {
            break label393;
          }
          if (j <= this.aggC) {
            break label381;
          }
          paramMotionEvent = a.a(a.this, false);
          jHW();
          paramMotionEvent.jHW();
          this.aggB = this.aggC;
          a.this.gc(this.aggC, j);
          paramMotionEvent.jHX();
          label336:
          jHX();
        }
        paramMotionEvent = a.this;
        if (this.aggA) {
          break label464;
        }
      }
      label393:
      label464:
      for (boolean bool = true;; bool = false)
      {
        a.a(paramMotionEvent, bool).jHX();
        break;
        i = a.this.aggb.uH;
        break label227;
        label381:
        a.this.gc(j, -1);
        break label336;
        if (j < this.aggB)
        {
          paramMotionEvent = a.a(a.this, true);
          paramMotionEvent.jHW();
          jHW();
          this.aggC = this.aggB;
          a.this.gc(j, this.aggB);
          paramMotionEvent.jHX();
        }
        for (;;)
        {
          jHX();
          break;
          a.this.gc(this.aggB, j);
        }
      }
    }
  }
  
  public static final class c
  {
    public int aggD;
    public int id;
    public String name;
    
    public c(String paramString, int paramInt)
    {
      this.name = paramString;
      this.id = paramInt;
      this.aggD = 15;
    }
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.id = paramInt1;
      this.aggD = paramInt2;
    }
  }
  
  public static final class d
    extends RecyclerView.a<a>
  {
    private a.e agcz;
    private a.g aggb;
    public List<a.c> xGG;
    
    public d(List<a.c> paramList, a.e parame, a.g paramg)
    {
      this.xGG = paramList;
      this.agcz = parame;
      this.aggb = paramg;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(252044);
      int i = this.xGG.size();
      AppMethodBeat.o(252044);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView dyR;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(252010);
        this.dyR = ((TextView)paramView.findViewById(com.tencent.mm.ck.a.f.menu_item_tv));
        this.dyR.setTextSize(1, 14.0F);
        AppMethodBeat.o(252010);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void I(List<a.c> paramList, int paramInt);
    
    public abstract void a(View paramView, a.c paramc, String paramString);
  }
  
  public final class f
  {
    List<a.c> agcq;
    ImageView agcr;
    a.d aggF;
    int mHeight;
    RecyclerView mRecyclerView;
    int mWidth;
    PopupWindow xyX;
    
    public f(Context paramContext)
    {
      AppMethodBeat.i(252026);
      paramContext = LayoutInflater.from(paramContext).inflate(com.tencent.mm.ck.a.g.layout_operate_windows, null);
      paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = paramContext.getMeasuredWidth();
      this.mHeight = paramContext.getMeasuredHeight();
      this.xyX = new PopupWindow(paramContext, -2, -2, false);
      this.xyX.setClippingEnabled(false);
      this.mRecyclerView = ((RecyclerView)paramContext.findViewById(com.tencent.mm.ck.a.f.rv_list));
      Object localObject = new LinearLayoutManager(0, false);
      this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      localObject = new LinkedList();
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(a.i.menu_select), 1, 4));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039373), 16908319, 12));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039363), 16908320, 9));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039361), 16908321, 9));
      ((List)localObject).add(new a.c(a.this.mContext.getResources().getString(17039371), 16908322));
      this.agcq = ((List)localObject);
      this.aggF = new a.d(this.agcq, new a.e()
      {
        public final void I(List<a.c> paramAnonymousList, int paramAnonymousInt) {}
        
        public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
        {
          AppMethodBeat.i(252046);
          a.f.a(a.f.this, paramAnonymousView, paramAnonymousc, paramAnonymousString);
          AppMethodBeat.o(252046);
        }
      }, a.this.aggb);
      this.mRecyclerView.setAdapter(this.aggF);
      localObject = new h(a.this.mContext, 0);
      ((h)localObject).w(new ColorDrawable(a.this.mContext.getResources().getColor(com.tencent.mm.ck.a.c.input_menu_divider)));
      this.mRecyclerView.a((RecyclerView.h)localObject);
      this.agcr = ((ImageView)paramContext.findViewById(com.tencent.mm.ck.a.f.cursor_iv));
      AppMethodBeat.o(252026);
    }
  }
  
  public static final class g
  {
    public String aggI;
    public int uG;
    public int uH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.a
 * JD-Core Version:    0.7.0.1
 */