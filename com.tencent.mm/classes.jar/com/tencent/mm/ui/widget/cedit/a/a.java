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
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
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
  CustomTextView Yhe;
  a Ykq;
  List<a.c> Ykr;
  ImageView Yks;
  public boolean Ykt;
  private Menu Yku;
  Map<Integer, CharSequence> Ykv;
  private int[] Ykw;
  private b.p Ykx;
  Runnable Yky;
  View mContentView;
  Context mContext;
  private int mHeight;
  RecyclerView mRecyclerView;
  private int mWidth;
  public PopupWindow usB;
  
  public a(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(195427);
    this.Ykt = false;
    this.Ykv = new HashMap();
    this.Ykw = new int[2];
    this.Ykx = new b.p()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(191418);
        a.this.usB.dismiss();
        a locala = a.this;
        locala.Yhe.removeCallbacks(locala.Yky);
        locala.Yhe.postDelayed(locala.Yky, 100L);
        AppMethodBeat.o(191418);
      }
    };
    this.Yky = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204046);
        a.this.Hz(false);
        AppMethodBeat.o(204046);
      }
    };
    this.Yhe = paramCustomTextView;
    this.mContext = paramCustomTextView.getContext();
    this.mContentView = LayoutInflater.from(this.mContext).inflate(a.h.layout_operate_windows, null);
    this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.mWidth = this.mContentView.getMeasuredWidth();
    this.mHeight = this.mContentView.getMeasuredHeight();
    this.usB = new PopupWindow(this.mContentView, -2, -2, false);
    this.usB.setClippingEnabled(false);
    this.mRecyclerView = ((RecyclerView)this.mContentView.findViewById(a.g.rv_list));
    paramCustomTextView = new LinearLayoutManager(0, false);
    this.mRecyclerView.setLayoutManager(paramCustomTextView);
    paramCustomTextView = new LinkedList();
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039373), 16908319, 12));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039363), 16908320, 9));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039361), 16908321, 9));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039371), 16908322));
    this.Ykr = paramCustomTextView;
    this.Ykq = new a(this.Ykr, new a.e()
    {
      public final void B(List<a.c> paramAnonymousList, int paramAnonymousInt) {}
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(195603);
        a locala = a.this;
        switch (paramAnonymousc.id)
        {
        }
        for (;;)
        {
          if ((locala.Ykv.containsKey(Integer.valueOf(paramAnonymousc.id))) && (locala.Yhe.getAdaptText() != null)) {}
          try
          {
            locala.Yhe.getAdaptText().onTextContextMenuItem(paramAnonymousc.id);
            locala.Yhe.iaB();
            if (locala.Yhe.getMenuCallback() != null) {
              locala.Yhe.getMenuCallback().a(paramAnonymousView, paramAnonymousc, paramAnonymousString);
            }
            AppMethodBeat.o(195603);
            return;
            locala.Yhe.iaG();
            continue;
            locala.Yhe.onTextContextMenuItem(16908320);
            continue;
            locala.Yhe.onTextContextMenuItem(16908321);
            continue;
            locala.Yhe.onTextContextMenuItem(16908322);
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.printErrStackTrace("cmEdit.OperateWindow", localThrowable, "adaptText item err %s %s", new Object[] { paramAnonymousc.name, Integer.valueOf(paramAnonymousc.id) });
              com.tencent.mm.ui.widget.cedit.api.b.axG(11);
            }
          }
        }
      }
    });
    this.mRecyclerView.setAdapter(this.Ykq);
    paramCustomTextView = new i(this.mContext, 0);
    paramCustomTextView.t(new ColorDrawable(this.mContext.getResources().getColor(a.d.input_menu_divider)));
    this.mRecyclerView.a(paramCustomTextView);
    this.Yks = ((ImageView)this.mContentView.findViewById(a.g.cursor_iv));
    this.usB.setAnimationStyle(a.l.OperateItemAnim);
    Log.i("cmEdit.OperateWindow", "new OpWindow @%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(195427);
  }
  
  private static boolean a(TextView paramTextView, Menu paramMenu)
  {
    AppMethodBeat.i(195454);
    if (paramTextView == null)
    {
      Log.i("cmEdit.OperateWindow", "populateMenuItems fail null");
      AppMethodBeat.o(195454);
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
        AppMethodBeat.o(195454);
        return true;
        label195:
        localObject1 = localClass1.getDeclaredConstructor(new Class[] { localClass2, Boolean.TYPE });
        ((Constructor)localObject1).setAccessible(true);
      }
      return false;
    }
    catch (Throwable paramTextView)
    {
      Log.e("cmEdit.OperateWindow", "populateMenuItems err:%s", new Object[] { Util.stackTraceToString(paramTextView) });
      com.tencent.mm.ui.widget.cedit.api.b.axG(5);
      AppMethodBeat.o(195454);
    }
  }
  
  private void h(Menu paramMenu)
  {
    AppMethodBeat.i(195446);
    if ((paramMenu != null) && (this.Yhe.getReuseItems().size() > 0))
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        Log.d("cmEdit.OperateWindow", String.format("filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() }));
        if (this.Yhe.getReuseItems().contains(localMenuItem.getTitle()))
        {
          Log.d("cmEdit.OperateWindow", String.format("reuse bingo:%s", new Object[] { localMenuItem.getTitle() }));
          this.Ykv.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(195446);
  }
  
  private void ibV()
  {
    AppMethodBeat.i(195440);
    int i = this.Yhe.getText().length();
    int j = this.Yhe.getSelectionStart();
    int k = this.Yhe.getSelectionEnd();
    if ((i > 0) && (j == 0) && (k == i)) {
      i = 1;
    }
    LinkedList localLinkedList;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.Ykr.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.c)((Iterator)localObject1).next();
        if ((((a.c)localObject2).Yoq & i) != 0) {
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
    this.Ykv.clear();
    if (this.Yhe.iaK())
    {
      Log.i("cmEdit.OperateWindow", "tryGetMenus");
      long l1 = System.currentTimeMillis();
      localObject1 = this.Yhe;
      if (this.Yku == null) {
        this.Yku = new o(this.mContext);
      }
      this.Yku.clear();
      boolean bool = a(((CustomTextView)localObject1).getAdaptText(), this.Yku);
      h(this.Yku);
      long l2 = System.currentTimeMillis();
      Log.i("cmEdit.OperateWindow", String.format("startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Boolean.TRUE, Boolean.valueOf(bool), Long.valueOf(l2 - l1) }));
    }
    if (this.Ykv.size() > 0)
    {
      localObject1 = this.Ykv.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localLinkedList.add(new a.c(((CharSequence)((Map.Entry)localObject2).getValue()).toString(), ((Integer)((Map.Entry)localObject2).getKey()).intValue()));
      }
    }
    if (this.Yhe.getMenuCallback() != null) {
      this.Yhe.getMenuCallback().B(localLinkedList, i);
    }
    a.a(this.Ykq, localLinkedList);
    this.Ykq.alc.notifyChanged();
    AppMethodBeat.o(195440);
  }
  
  final void Hz(boolean paramBoolean)
  {
    AppMethodBeat.i(195467);
    if (paramBoolean)
    {
      localObject = this.usB.getContentView();
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = ((View)localObject).getMeasuredWidth();
      this.mHeight = ((View)localObject).getMeasuredHeight();
    }
    this.Yhe.getLocationInWindow(this.Ykw);
    Object localObject = this.Yhe.getLayout();
    int i1 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(this.mContext);
    int m = aw.fromDPToPix(this.mContext, 10);
    int i = i1 - m * 2;
    if (this.mWidth >= i) {
      this.mWidth = i;
    }
    int j = this.Yhe.getSelectionStart();
    i = this.Yhe.getSelectionEnd();
    int k = ((int)((Layout)localObject).getPrimaryHorizontal(j) + (int)((Layout)localObject).getPrimaryHorizontal(i)) / 2;
    int n = this.Ykw[0];
    int i2 = this.mWidth / 2;
    int i3 = this.Yhe.getPaddingLeft();
    if ((j != i) && (((Layout)localObject).getLineForOffset(j) != ((Layout)localObject).getLineForOffset(i))) {}
    for (i = this.Ykw[0] + this.Yhe.getWidth() / 2 - this.mWidth / 2;; i = k + n - i2 + i3)
    {
      k = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(j)) + this.Ykw[1] - this.mHeight + this.Yhe.getPaddingTop() - this.Yhe.getScrollY() - aw.fromDPToPix(this.mContext, 5);
      n = this.Ykw[1] - this.mHeight - aw.fromDPToPix(this.mContext, 5);
      i2 = this.Ykw[1];
      i3 = this.Yhe.getHeight();
      int i4 = this.mHeight;
      int i5 = aw.fromDPToPix(this.mContext, 5);
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
            AppMethodBeat.o(195467);
            return;
          }
          if (this.mWidth + j > i1) {
            j = i1 - this.mWidth - m;
          }
          for (;;)
          {
            ((LinearLayout.LayoutParams)this.Yks.getLayoutParams()).leftMargin = (i - j);
            if (Build.VERSION.SDK_INT >= 21) {
              this.usB.setElevation(8.0F);
            }
            localObject = this.mRecyclerView.getLayoutManager();
            if ((localObject instanceof LinearLayoutManager))
            {
              localObject = (LinearLayoutManager)localObject;
              com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
              ((LinearLayoutManager)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            }
            this.usB.setWidth(this.mWidth);
            try
            {
              if (this.usB.isShowing())
              {
                this.usB.update(j, k, this.usB.getWidth(), this.usB.getHeight());
                AppMethodBeat.o(195467);
                return;
              }
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(195467);
              return;
            }
            this.usB.showAtLocation(this.Yhe, 0, j, k);
            AppMethodBeat.o(195467);
            return;
          }
        }
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(195469);
    try
    {
      this.Yhe.getEditor().b(this.Ykx);
      this.usB.dismiss();
      AppMethodBeat.o(195469);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(195469);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(195457);
    if (this.Ykt)
    {
      Log.i("cmEdit.OperateWindow", "show after destroy @", new Object[] { Integer.valueOf(hashCode()) });
      this.usB.setContentView(this.mContentView);
      this.Ykt = false;
    }
    ibV();
    Hz(true);
    this.Yhe.getEditor().a(this.Ykx);
    AppMethodBeat.o(195457);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    private a.e YkA;
    private List<a.c> uAd;
    
    a(a.e parame)
    {
      this.uAd = parame;
      Object localObject;
      this.YkA = localObject;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(216264);
      int i = this.uAd.size();
      AppMethodBeat.o(216264);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView bFR;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(195518);
        this.bFR = ((TextView)paramView.findViewById(a.g.menu_item_tv));
        this.bFR.setTextSize(1, 14.0F);
        AppMethodBeat.o(195518);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.a.a
 * JD-Core Version:    0.7.0.1
 */