package com.tencent.mm.ui.widget.cedit.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.w;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
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
  CustomTextView QIo;
  ImageView QLA;
  public boolean QLB;
  private Menu QLC;
  Map<Integer, CharSequence> QLD;
  private int[] QLE;
  private b.p QLF;
  Runnable QLG;
  a QLy;
  List<a.c> QLz;
  View mContentView;
  Context mContext;
  private int mHeight;
  RecyclerView mRecyclerView;
  private int mWidth;
  public PopupWindow qQv;
  
  public a(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206046);
    this.QLB = false;
    this.QLD = new HashMap();
    this.QLE = new int[2];
    this.QLF = new b.p()
    {
      public final void i(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(206039);
        a.this.qQv.dismiss();
        a locala = a.this;
        locala.QIo.removeCallbacks(locala.QLG);
        locala.QIo.postDelayed(locala.QLG, 100L);
        AppMethodBeat.o(206039);
      }
    };
    this.QLG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206040);
        a.this.Dd(false);
        AppMethodBeat.o(206040);
      }
    };
    this.QIo = paramCustomTextView;
    this.mContext = paramCustomTextView.getContext();
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131495181, null);
    this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.mWidth = this.mContentView.getMeasuredWidth();
    this.mHeight = this.mContentView.getMeasuredHeight();
    this.qQv = new PopupWindow(this.mContentView, -2, -2, false);
    this.qQv.setClippingEnabled(false);
    this.mRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131307200));
    paramCustomTextView = new LinearLayoutManager(0, false);
    this.mRecyclerView.setLayoutManager(paramCustomTextView);
    paramCustomTextView = new LinkedList();
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039373), 16908319, 12));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039363), 16908320, 9));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039361), 16908321, 9));
    paramCustomTextView.add(new a.c(this.mContext.getResources().getString(17039371), 16908322));
    this.QLz = paramCustomTextView;
    this.QLy = new a(this.QLz, new a.e()
    {
      public final void A(List<a.c> paramAnonymousList, int paramAnonymousInt) {}
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(206038);
        a locala = a.this;
        switch (paramAnonymousc.id)
        {
        }
        for (;;)
        {
          if ((locala.QLD.containsKey(Integer.valueOf(paramAnonymousc.id))) && (locala.QIo.getAdaptText() != null)) {}
          try
          {
            locala.QIo.getAdaptText().onTextContextMenuItem(paramAnonymousc.id);
            locala.QIo.gZE();
            if (locala.QIo.getMenuCallback() != null) {
              locala.QIo.getMenuCallback().a(paramAnonymousView, paramAnonymousc, paramAnonymousString);
            }
            AppMethodBeat.o(206038);
            return;
            locala.QIo.gZJ();
            continue;
            locala.QIo.onTextContextMenuItem(16908320);
            continue;
            locala.QIo.onTextContextMenuItem(16908321);
            continue;
            locala.QIo.onTextContextMenuItem(16908322);
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.printErrStackTrace("cmEdit.OperateWindow", localThrowable, "adaptText item err %s %s", new Object[] { paramAnonymousc.name, Integer.valueOf(paramAnonymousc.id) });
              com.tencent.mm.ui.widget.cedit.api.b.aow(11);
            }
          }
        }
      }
    });
    this.mRecyclerView.setAdapter(this.QLy);
    paramCustomTextView = new w(this.mContext, 0);
    paramCustomTextView.setDrawable(new ColorDrawable(this.mContext.getResources().getColor(2131100649)));
    this.mRecyclerView.a(paramCustomTextView);
    this.QLA = ((ImageView)this.mContentView.findViewById(2131299376));
    this.qQv.setAnimationStyle(2131821236);
    Log.i("cmEdit.OperateWindow", "new OpWindow @%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(206046);
  }
  
  private static boolean a(TextView paramTextView, Menu paramMenu)
  {
    AppMethodBeat.i(206049);
    if (paramTextView == null)
    {
      Log.i("cmEdit.OperateWindow", "populateMenuItems fail null");
      AppMethodBeat.o(206049);
      return false;
    }
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
        paramTextView.setTag(2131309018, localObject1);
        Log.i("cmEdit.OperateWindow", "populateMenuItems succ");
        AppMethodBeat.o(206049);
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
      com.tencent.mm.ui.widget.cedit.api.b.aow(5);
      AppMethodBeat.o(206049);
    }
  }
  
  private void g(Menu paramMenu)
  {
    AppMethodBeat.i(206048);
    if ((paramMenu != null) && (this.QIo.getReuseItems().size() > 0))
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        Log.d("cmEdit.OperateWindow", String.format("filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() }));
        if (this.QIo.getReuseItems().contains(localMenuItem.getTitle()))
        {
          Log.d("cmEdit.OperateWindow", String.format("reuse bingo:%s", new Object[] { localMenuItem.getTitle() }));
          this.QLD.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(206048);
  }
  
  private void haW()
  {
    AppMethodBeat.i(206047);
    int i = this.QIo.getText().length();
    int j = this.QIo.getSelectionStart();
    int k = this.QIo.getSelectionEnd();
    if ((i > 0) && (j == 0) && (k == i)) {
      i = 1;
    }
    LinkedList localLinkedList;
    Object localObject1;
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
    this.QLD.clear();
    if (this.QIo.gZN())
    {
      Log.i("cmEdit.OperateWindow", "tryGetMenus");
      long l1 = System.currentTimeMillis();
      localObject1 = this.QIo;
      if (this.QLC == null) {
        this.QLC = new m(this.mContext);
      }
      this.QLC.clear();
      boolean bool = a(((CustomTextView)localObject1).getAdaptText(), this.QLC);
      g(this.QLC);
      long l2 = System.currentTimeMillis();
      Log.i("cmEdit.OperateWindow", String.format("startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Boolean.TRUE, Boolean.valueOf(bool), Long.valueOf(l2 - l1) }));
    }
    if (this.QLD.size() > 0)
    {
      localObject1 = this.QLD.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localLinkedList.add(new a.c(((CharSequence)((Map.Entry)localObject2).getValue()).toString(), ((Integer)((Map.Entry)localObject2).getKey()).intValue()));
      }
    }
    if (this.QIo.getMenuCallback() != null) {
      this.QIo.getMenuCallback().A(localLinkedList, i);
    }
    a.a(this.QLy, localLinkedList);
    this.QLy.atj.notifyChanged();
    AppMethodBeat.o(206047);
  }
  
  final void Dd(boolean paramBoolean)
  {
    AppMethodBeat.i(206051);
    if (paramBoolean)
    {
      localObject = this.qQv.getContentView();
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mWidth = ((View)localObject).getMeasuredWidth();
      this.mHeight = ((View)localObject).getMeasuredHeight();
    }
    this.QIo.getLocationInWindow(this.QLE);
    Object localObject = this.QIo.getLayout();
    int i1 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(this.mContext);
    int m = at.fromDPToPix(this.mContext, 10);
    int i = i1 - m * 2;
    if (this.mWidth >= i) {
      this.mWidth = i;
    }
    int j = this.QIo.getSelectionStart();
    i = this.QIo.getSelectionEnd();
    int k = ((int)((Layout)localObject).getPrimaryHorizontal(j) + (int)((Layout)localObject).getPrimaryHorizontal(i)) / 2;
    int n = this.QLE[0];
    int i2 = this.mWidth / 2;
    int i3 = this.QIo.getPaddingLeft();
    if ((j != i) && (((Layout)localObject).getLineForOffset(j) != ((Layout)localObject).getLineForOffset(i))) {}
    for (i = this.QLE[0] + this.QIo.getWidth() / 2 - this.mWidth / 2;; i = k + n - i2 + i3)
    {
      k = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(j)) + this.QLE[1] - this.mHeight + this.QIo.getPaddingTop() - this.QIo.getScrollY() - at.fromDPToPix(this.mContext, 5);
      n = this.QLE[1] - this.mHeight - at.fromDPToPix(this.mContext, 5);
      i2 = this.QLE[1];
      i3 = this.QIo.getHeight();
      int i4 = this.mHeight;
      int i5 = at.fromDPToPix(this.mContext, 5);
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
            AppMethodBeat.o(206051);
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
              com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
              ((LinearLayoutManager)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            }
            this.qQv.setWidth(this.mWidth);
            try
            {
              if (this.qQv.isShowing())
              {
                this.qQv.update(j, k, this.qQv.getWidth(), this.qQv.getHeight());
                AppMethodBeat.o(206051);
                return;
              }
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(206051);
              return;
            }
            this.qQv.showAtLocation(this.QIo, 0, j, k);
            AppMethodBeat.o(206051);
            return;
          }
        }
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(206052);
    try
    {
      this.QIo.getEditor().b(this.QLF);
      this.qQv.dismiss();
      AppMethodBeat.o(206052);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(206052);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(206050);
    if (this.QLB)
    {
      Log.i("cmEdit.OperateWindow", "show after destroy @", new Object[] { Integer.valueOf(hashCode()) });
      this.qQv.setContentView(this.mContentView);
      this.QLB = false;
    }
    haW();
    Dd(true);
    this.QIo.getEditor().a(this.QLF);
    AppMethodBeat.o(206050);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    private a.e QLI;
    private List<a.c> qXp;
    
    a(a.e parame)
    {
      this.qXp = parame;
      Object localObject;
      this.QLI = localObject;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(206043);
      int i = this.qXp.size();
      AppMethodBeat.o(206043);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView vr;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(206042);
        this.vr = ((TextView)paramView.findViewById(2131304617));
        this.vr.setTextSize(1, 14.0F);
        AppMethodBeat.o(206042);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.a.a
 * JD-Core Version:    0.7.0.1
 */