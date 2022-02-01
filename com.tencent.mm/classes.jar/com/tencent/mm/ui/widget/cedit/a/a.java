package com.tencent.mm.ui.widget.cedit.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import com.tencent.mm.ui.widget.cedit.edit.b.p;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  CustomTextView afZe;
  a agcp;
  List<a.c> agcq;
  ImageView agcr;
  public boolean agcs;
  private Menu agct;
  Map<Integer, CharSequence> agcu;
  private int[] agcv;
  private b.p agcw;
  Runnable agcx;
  View mContentView;
  Context mContext;
  private int mHeight;
  RecyclerView mRecyclerView;
  private int mWidth;
  public PopupWindow xyX;
  
  public a(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252451);
    this.agcs = false;
    this.agcu = new HashMap();
    this.agcv = new int[2];
    this.agcw = new b.p()
    {
      public final void j(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(252419);
        a.this.xyX.dismiss();
        a locala = a.this;
        locala.afZe.removeCallbacks(locala.agcx);
        locala.afZe.postDelayed(locala.agcx, 100L);
        AppMethodBeat.o(252419);
      }
    };
    this.agcx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252454);
        a.this.Nv(false);
        AppMethodBeat.o(252454);
      }
    };
    this.afZe = paramCustomTextView;
    this.mContext = paramCustomTextView.getContext();
    this.mContentView = LayoutInflater.from(this.mContext).inflate(a.h.layout_operate_windows, null);
    this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.mWidth = this.mContentView.getMeasuredWidth();
    this.mHeight = this.mContentView.getMeasuredHeight();
    this.xyX = new PopupWindow(this.mContentView, -2, -2, false);
    this.xyX.setClippingEnabled(false);
    this.mRecyclerView = ((RecyclerView)this.mContentView.findViewById(a.g.rv_list));
    paramCustomTextView = new LinearLayoutManager(0, false);
    this.mRecyclerView.setLayoutManager(paramCustomTextView);
    paramCustomTextView = new LinkedList();
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039373), 16908319, 12));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039363), 16908320, 9));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039361), 16908321, 9));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039371), 16908322));
    this.agcq = paramCustomTextView;
    this.agcp = new a(this.agcq, new a.e()
    {
      public final void I(List<a.c> paramAnonymousList, int paramAnonymousInt) {}
      
      /* Error */
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        // Byte code:
        //   0: ldc 27
        //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 16	com/tencent/mm/ui/widget/cedit/a/a$1:agcy	Lcom/tencent/mm/ui/widget/cedit/a/a;
        //   9: astore 4
        //   11: aload_2
        //   12: getfield 38	com/tencent/mm/ui/widget/edittext/a$c:id	I
        //   15: tableswitch	default:+29 -> 44, 16908319:+117->132, 16908320:+129->144, 16908321:+143->158, 16908322:+157->172
        //   45: iconst_1
        //   46: getfield 42	com/tencent/mm/ui/widget/cedit/a/a:agcu	Ljava/util/Map;
        //   49: aload_2
        //   50: getfield 38	com/tencent/mm/ui/widget/edittext/a$c:id	I
        //   53: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   56: invokeinterface 54 2 0
        //   61: ifeq +38 -> 99
        //   64: aload 4
        //   66: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   69: invokevirtual 64	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:getAdaptText	()Landroid/widget/TextView;
        //   72: ifnull +27 -> 99
        //   75: aload 4
        //   77: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   80: invokevirtual 64	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:getAdaptText	()Landroid/widget/TextView;
        //   83: aload_2
        //   84: getfield 38	com/tencent/mm/ui/widget/edittext/a$c:id	I
        //   87: invokevirtual 70	android/widget/TextView:onTextContextMenuItem	(I)Z
        //   90: pop
        //   91: aload 4
        //   93: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   96: invokevirtual 73	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFJ	()V
        //   99: aload 4
        //   101: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   104: invokevirtual 77	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:getMenuCallback	()Lcom/tencent/mm/ui/widget/edittext/a$e;
        //   107: ifnull +19 -> 126
        //   110: aload 4
        //   112: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   115: invokevirtual 77	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:getMenuCallback	()Lcom/tencent/mm/ui/widget/edittext/a$e;
        //   118: aload_1
        //   119: aload_2
        //   120: aload_3
        //   121: invokeinterface 79 4 0
        //   126: ldc 27
        //   128: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   131: return
        //   132: aload 4
        //   134: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   137: invokevirtual 86	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFO	()Z
        //   140: pop
        //   141: goto -97 -> 44
        //   144: aload 4
        //   146: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   149: ldc 87
        //   151: invokevirtual 88	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
        //   154: pop
        //   155: goto -111 -> 44
        //   158: aload 4
        //   160: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   163: ldc 89
        //   165: invokevirtual 88	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
        //   168: pop
        //   169: goto -125 -> 44
        //   172: aload 4
        //   174: getfield 58	com/tencent/mm/ui/widget/cedit/a/a:afZe	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView;
        //   177: ldc 90
        //   179: invokevirtual 88	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
        //   182: pop
        //   183: goto -139 -> 44
        //   186: astore 5
        //   188: ldc 92
        //   190: aload 5
        //   192: ldc 94
        //   194: iconst_2
        //   195: anewarray 4	java/lang/Object
        //   198: dup
        //   199: iconst_0
        //   200: aload_2
        //   201: getfield 98	com/tencent/mm/ui/widget/edittext/a$c:name	Ljava/lang/String;
        //   204: aastore
        //   205: dup
        //   206: iconst_1
        //   207: aload_2
        //   208: getfield 38	com/tencent/mm/ui/widget/edittext/a$c:id	I
        //   211: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   214: aastore
        //   215: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   218: bipush 11
        //   220: invokestatic 109	com/tencent/mm/ui/widget/cedit/api/b:aEp	(I)V
        //   223: goto -132 -> 91
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	226	0	this	1
        //   0	226	1	paramAnonymousView	View
        //   0	226	2	paramAnonymousc	a.c
        //   0	226	3	paramAnonymousString	String
        //   9	164	4	locala	a
        //   186	5	5	localThrowable	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   75	91	186	finally
      }
    });
    this.mRecyclerView.setAdapter(this.agcp);
    paramCustomTextView = new h(this.mContext, 0);
    paramCustomTextView.w(new ColorDrawable(this.mContext.getResources().getColor(a.d.input_menu_divider)));
    this.mRecyclerView.a(paramCustomTextView);
    this.agcr = ((ImageView)this.mContentView.findViewById(a.g.cursor_iv));
    this.xyX.setAnimationStyle(a.l.OperateItemAnim);
    Log.i("cmEdit.OperateWindow", "new OpWindow @%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(252451);
  }
  
  private static boolean a(TextView paramTextView, Menu paramMenu)
  {
    AppMethodBeat.i(252481);
    if (paramTextView == null)
    {
      Log.i("cmEdit.OperateWindow", "populateMenuItems fail null");
      AppMethodBeat.o(252481);
      return false;
    }
    try
    {
      Object localObject1 = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject1).setAccessible(true);
      Object localObject3 = ((Field)localObject1).get(paramTextView);
      Class localClass2 = Class.forName("android.widget.Editor");
      Class localClass1 = Class.forName("android.widget.Editor$TextActionModeCallback");
      Object localObject2 = paramTextView.getTag(a.g.text_view_callback);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (Build.VERSION.SDK_INT < 28) {
          break label195;
        }
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Integer.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      for (localObject1 = ((Constructor)localObject1).newInstance(new Object[] { localObject3, Integer.valueOf(1) });; localObject1 = ((Constructor)localObject1).newInstance(new Object[] { localObject3, Boolean.FALSE }))
      {
        localObject2 = localClass1.getDeclaredMethod("populateMenuWithItems", new Class[] { Menu.class });
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject2).invoke(localObject1, new Object[] { paramMenu });
        paramTextView.setTag(a.g.text_view_callback, localObject1);
        Log.i("cmEdit.OperateWindow", "populateMenuItems succ");
        AppMethodBeat.o(252481);
        return true;
        label195:
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Boolean.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      return false;
    }
    finally
    {
      Log.e("cmEdit.OperateWindow", "populateMenuItems err:%s", new Object[] { Util.stackTraceToString(paramTextView) });
      com.tencent.mm.ui.widget.cedit.api.b.aEp(5);
      AppMethodBeat.o(252481);
    }
  }
  
  private void h(Menu paramMenu)
  {
    AppMethodBeat.i(252470);
    if ((paramMenu != null) && (this.afZe.getReuseItems().size() > 0))
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        Log.d("cmEdit.OperateWindow", String.format("filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() }));
        if (this.afZe.getReuseItems().contains(localMenuItem.getTitle()))
        {
          Log.d("cmEdit.OperateWindow", String.format("reuse bingo:%s", new Object[] { localMenuItem.getTitle() }));
          this.agcu.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(252470);
  }
  
  private void jHf()
  {
    AppMethodBeat.i(252463);
    int i = this.afZe.getText().length();
    int j = this.afZe.getSelectionStart();
    int k = this.afZe.getSelectionEnd();
    if ((i > 0) && (j == 0) && (k == i)) {
      i = 1;
    }
    LinkedList localLinkedList;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.agcq.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.c)((Iterator)localObject1).next();
        if ((((a.c)localObject2).aggD & i) != 0) {
          localLinkedList.add(localObject2);
        }
      }
      if (j == k)
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
    this.agcu.clear();
    if (this.afZe.jFS())
    {
      Log.i("cmEdit.OperateWindow", "tryGetMenus");
      long l1 = System.currentTimeMillis();
      localObject1 = this.afZe;
      if (this.agct == null) {
        this.agct = new s(this.mContext);
      }
      this.agct.clear();
      boolean bool = a(((CustomTextView)localObject1).getAdaptText(), this.agct);
      h(this.agct);
      long l2 = System.currentTimeMillis();
      Log.i("cmEdit.OperateWindow", String.format("startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Boolean.TRUE, Boolean.valueOf(bool), Long.valueOf(l2 - l1) }));
    }
    if (this.agcu.size() > 0)
    {
      localObject1 = this.agcu.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localLinkedList.add(new a.c(((CharSequence)((Map.Entry)localObject2).getValue()).toString(), ((Integer)((Map.Entry)localObject2).getKey()).intValue()));
      }
    }
    if (this.afZe.getMenuCallback() != null) {
      this.afZe.getMenuCallback().I(localLinkedList, i);
    }
    a.a(this.agcp, localLinkedList);
    this.agcp.bZE.notifyChanged();
    AppMethodBeat.o(252463);
  }
  
  final void Nv(boolean paramBoolean)
  {
    AppMethodBeat.i(252492);
    if (paramBoolean)
    {
      localObject = this.xyX.getContentView();
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = ((View)localObject).getMeasuredWidth();
      this.mHeight = ((View)localObject).getMeasuredHeight();
    }
    this.afZe.getLocationInWindow(this.agcv);
    Object localObject = this.afZe.getLayout();
    int i1 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(this.mContext);
    int m = bd.fromDPToPix(this.mContext, 10);
    int i = i1 - m * 2;
    if (this.mWidth >= i) {
      this.mWidth = i;
    }
    int j = this.afZe.getSelectionStart();
    i = this.afZe.getSelectionEnd();
    int k = ((int)((Layout)localObject).getPrimaryHorizontal(j) + (int)((Layout)localObject).getPrimaryHorizontal(i)) / 2;
    int n = this.agcv[0];
    int i2 = this.mWidth / 2;
    int i3 = this.afZe.getPaddingLeft();
    if ((j != i) && (((Layout)localObject).getLineForOffset(j) != ((Layout)localObject).getLineForOffset(i))) {}
    for (i = this.agcv[0] + this.afZe.getWidth() / 2 - this.mWidth / 2;; i = k + n - i2 + i3)
    {
      k = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(j)) + this.agcv[1] - this.mHeight + this.afZe.getPaddingTop() - this.afZe.getScrollY() - bd.fromDPToPix(this.mContext, 5);
      n = this.agcv[1] - this.mHeight - bd.fromDPToPix(this.mContext, 5);
      i2 = this.agcv[1];
      i3 = this.afZe.getHeight();
      int i4 = this.mHeight;
      int i5 = bd.fromDPToPix(this.mContext, 5);
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
            AppMethodBeat.o(252492);
            return;
          }
          if (this.mWidth + j > i1) {
            j = i1 - this.mWidth - m;
          }
          for (;;)
          {
            ((LinearLayout.LayoutParams)this.agcr.getLayoutParams()).leftMargin = (i - j);
            if (Build.VERSION.SDK_INT >= 21) {
              this.xyX.setElevation(8.0F);
            }
            localObject = this.mRecyclerView.getLayoutManager();
            if ((localObject instanceof LinearLayoutManager))
            {
              localObject = (LinearLayoutManager)localObject;
              com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
              ((LinearLayoutManager)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            }
            this.xyX.setWidth(this.mWidth);
            try
            {
              if (this.xyX.isShowing())
              {
                this.xyX.update(j, k, this.xyX.getWidth(), this.xyX.getHeight());
                AppMethodBeat.o(252492);
                return;
              }
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(252492);
              return;
            }
            this.xyX.showAtLocation(this.afZe, 0, j, k);
            AppMethodBeat.o(252492);
            return;
          }
        }
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(252496);
    try
    {
      this.afZe.getEditor().b(this.agcw);
      this.xyX.dismiss();
      return;
    }
    finally
    {
      AppMethodBeat.o(252496);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(252485);
    if (this.agcs)
    {
      Log.i("cmEdit.OperateWindow", "show after destroy @", new Object[] { Integer.valueOf(hashCode()) });
      this.xyX.setContentView(this.mContentView);
      this.agcs = false;
    }
    jHf();
    Nv(true);
    this.afZe.getEditor().a(this.agcw);
    AppMethodBeat.o(252485);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    private a.e agcz;
    private List<a.c> xGG;
    
    a(a.e parame)
    {
      this.xGG = parame;
      Object localObject;
      this.agcz = localObject;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(252450);
      int i = this.xGG.size();
      AppMethodBeat.o(252450);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView dyR;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(252425);
        this.dyR = ((TextView)paramView.findViewById(a.g.menu_item_tv));
        this.dyR.setTextSize(1, 14.0F);
        AppMethodBeat.o(252425);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.a.a
 * JD-Core Version:    0.7.0.1
 */