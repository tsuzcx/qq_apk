package com.tencent.mm.ui.widget.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static int wnY;
  private static int wnZ;
  private static boolean woa = false;
  private LayoutInflater Lu;
  private DisplayMetrics btj;
  private View lPi;
  private Context mContext = null;
  public n.d phI;
  private l phJ;
  private View vBf = null;
  private MMListPopupWindow vix;
  public PopupWindow.OnDismissListener wfc;
  private a.a wob = null;
  private o woc;
  private int wod;
  private boolean woe = false;
  public View wof;
  public View.OnCreateContextMenuListener wog;
  public boolean woh = false;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
  }
  
  public a(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.vBf = paramView;
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    cKh();
  }
  
  private boolean cKg()
  {
    return (this.woc != null) && (this.woc.isShowing());
  }
  
  private void cKh()
  {
    this.vBf.setOnTouchListener(new a.5(this));
  }
  
  private boolean fL(int paramInt1, int paramInt2)
  {
    if ((isShowing()) || (cKg())) {
      return false;
    }
    if (this.wog != null) {
      this.wog.onCreateContextMenu(this.phJ, this.vBf, null);
    }
    int n = this.wob.getCount();
    int i1 = this.mContext.getResources().getDimensionPixelSize(a.d.SmallListHeight);
    int i2 = this.mContext.getResources().getDimensionPixelSize(a.d.edgePadding);
    a.a locala = this.wob;
    int i = 0;
    Object localObject = null;
    int j = 0;
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i5 = locala.getCount();
    int k = 0;
    int m;
    if (k < i5)
    {
      m = locala.getItemViewType(k);
      if (m == j) {
        break label627;
      }
      localObject = null;
      j = m;
    }
    label276:
    label294:
    label305:
    label627:
    for (;;)
    {
      localObject = locala.getView(k, (View)localObject, new FrameLayout(this.mContext));
      m = i;
      if (localObject != null)
      {
        ((View)localObject).measure(i3, i4);
        m = Math.max(i, ((View)localObject).getMeasuredWidth());
      }
      k += 1;
      i = m;
      break;
      j = ap.ab(this.mContext, a.d.minMenuWidth);
      boolean bool;
      if (i < j)
      {
        i = j;
        bool = true;
        if (this.phJ.size() >= 3) {
          bool = false;
        }
        if (!this.woe)
        {
          if (this.wof == null) {
            break label294;
          }
          this.wof.setSelected(true);
        }
        if (!this.woh) {
          break label305;
        }
        fM(paramInt1, paramInt2);
      }
      for (;;)
      {
        return true;
        break;
        this.vBf.setSelected(true);
        break label276;
        localObject = b.a(this.mContext, i, paramInt1, paramInt2, n * i1, i2, bool);
        this.wod = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(a.d.edgePadding));
        ao.s("showPointY=" + paramInt2 + "verticalOffset=" + this.wod, new Object[0]);
        this.vix = new MMListPopupWindow(this.mContext, null, 0);
        this.vix.setOnDismissListener(this);
        this.vix.aeW = new a.3(this);
        this.vix.setAdapter(this.wob);
        this.vix.cAM();
        this.vix.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sub_menu_bg));
        this.vix.setAnimationStyle(((b.a)localObject).wok);
        this.vix.aeJ = ((b.a)localObject).hye;
        this.vix.setVerticalOffset(((b.a)localObject).pko);
        this.vix.aeU = this.vBf;
        this.vix.setContentWidth(i);
        this.vix.hf();
        this.vix.show();
        this.vix.uWw.setOnKeyListener(this);
        this.vix.uWw.setDivider(new ColorDrawable(this.mContext.getResources().getColor(a.c.small_line_color)));
        this.vix.uWw.setSelector(this.mContext.getResources().getDrawable(a.e.popup_menu_selector));
        this.vix.uWw.setDividerHeight(0);
        this.vix.uWw.setVerticalScrollBarEnabled(false);
        this.vix.uWw.setHorizontalScrollBarEnabled(false);
      }
    }
  }
  
  private void fM(int paramInt1, int paramInt2)
  {
    int j = this.mContext.getResources().getDimensionPixelOffset(a.d.NormalPadding);
    int k = this.mContext.getResources().getDimensionPixelOffset(a.d.LargePadding);
    this.woc = new o(this.mContext);
    this.woc.setWidth(-2);
    this.woc.setHeight(-2);
    this.woc.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sub_menu_bg));
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(a.c.white));
    int i = 0;
    if (i < this.phJ.size())
    {
      TextView localTextView = (TextView)this.Lu.inflate(a.g.horizontal_popup_item, null, false);
      localTextView.setBackground(this.mContext.getResources().getDrawable(a.e.popup_menu_selector));
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.phJ.uWD.get(i)).getTitle());
        localTextView.setOnClickListener(new a.4(this, i));
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.phJ.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.woc.setContentView(localLinearLayout);
    this.woc.showAtLocation(this.vBf, 0, paramInt1, paramInt2 - i);
  }
  
  private void initView()
  {
    cCw();
    this.phJ = new l(this.mContext);
    this.wob = new a.a(this, (byte)0);
    this.btj = this.mContext.getResources().getDisplayMetrics();
  }
  
  private boolean isShowing()
  {
    return (this.vix != null) && (this.vix.fvf.isShowing());
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt2, int paramInt3)
  {
    this.phI = paramd;
    this.vBf = paramView;
    cKh();
    this.phJ.clear();
    paramd = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.phJ, paramView, paramd);
    paramView = this.phJ.uWD.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).uWG = paramd;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ch(0, 0);
      return;
    }
    ch(paramInt2, paramInt3);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt1, int paramInt2)
  {
    this.phI = paramd;
    this.vBf = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      cKh();
    }
    this.phJ.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.phJ, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ch(0, 0);
      return;
    }
    ch(paramInt1, paramInt2);
  }
  
  public final void c(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    this.vBf = paramView;
    cKh();
    this.phI = paramd;
    if ((paramView instanceof AbsListView))
    {
      ao.r("registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new a.1(this, paramOnCreateContextMenuListener));
      return;
    }
    ao.r("registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new a.2(this, paramOnCreateContextMenuListener));
  }
  
  public final boolean cCw()
  {
    if (isShowing()) {
      if (this.vix != null) {
        this.vix.dismiss();
      }
    }
    do
    {
      return true;
      if (!cKg()) {
        break;
      }
    } while (this.woc == null);
    this.woc.dismiss();
    return true;
    return false;
  }
  
  public boolean ch(int paramInt1, int paramInt2)
  {
    if (((!this.vBf.equals(this.lPi)) || (!woa)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      wnY = paramInt1;
      wnZ = paramInt2;
    }
    this.lPi = null;
    int k = wnY;
    int n = wnZ;
    woa = false;
    if (this.btj == null) {
      this.btj = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.vBf != null)
    {
      int[] arrayOfInt = new int[2];
      this.vBf.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.vBf.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.vBf.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.btj.heightPixels) {
        m = this.btj.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      ao.t("show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!cKg())) {
        return fL(i, j);
      }
      boolean bool = cCw();
      return fL(i, j) & bool;
      k = n;
      i = j;
    }
  }
  
  public void onDismiss()
  {
    if (!this.woe)
    {
      if (this.wof == null) {
        break label39;
      }
      this.wof.setSelected(false);
    }
    for (;;)
    {
      if (this.wfc != null) {
        this.wfc.onDismiss();
      }
      return;
      label39:
      this.vBf.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a
 * JD-Core Version:    0.7.0.1
 */