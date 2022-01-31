package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.ai.j;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;
import java.util.Iterator;
import java.util.List;

public final class h
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private LayoutInflater Lu;
  private int height;
  private Context mContext = null;
  private int mCount;
  j viA = null;
  private boolean viB = true;
  AdapterView.OnItemClickListener viu = null;
  private ViewGroup viv = null;
  private h.b viw = null;
  private MMListPopupWindow vix;
  private int viy = R.m.UpMenuAnimation;
  private int viz;
  
  public h(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.viv = paramViewGroup;
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    cCw();
    this.viw = new h.b(this, (byte)0);
  }
  
  private int b(ListAdapter paramListAdapter)
  {
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = paramListAdapter.getCount();
    int j = 0;
    int i = 0;
    View localView = null;
    int k = 0;
    if (j < i2)
    {
      int m = paramListAdapter.getItemViewType(j);
      if (m == i) {
        break label127;
      }
      localView = null;
      i = m;
    }
    label127:
    for (;;)
    {
      if (this.viv == null) {
        this.viv = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.viv);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final boolean a(j paramj, int paramInt1, int paramInt2)
  {
    if ((!isShowing()) && (paramj != null) && (paramj.egp != null) && (paramj.egp.size() > 0))
    {
      this.viB = false;
      this.viA = paramj;
      this.mCount = paramj.egp.size();
      this.viw.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.i.popup_submenu_item, null);
      paramj = a.a(this.mContext, localTextView.getPaint(), paramj.egp, paramInt1);
      this.viz = (paramInt2 - this.viw.getCount() * this.mContext.getResources().getDimensionPixelSize(R.f.SmallListHeight) - this.mContext.getResources().getDimensionPixelSize(R.f.FooterPadding));
      y.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.viz);
      this.vix = new MMListPopupWindow(this.mContext, null, 0);
      this.vix.setOnDismissListener(this);
      this.vix.aeW = this.viu;
      this.vix.setAdapter(this.viw);
      this.vix.cAM();
      this.vix.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.sub_menu_bg));
      this.vix.setAnimationStyle(this.viy);
      this.vix.aeJ = paramj.hye;
      this.vix.setVerticalOffset(this.viz);
      this.vix.aeU = this.viv;
      this.vix.setContentWidth(b(this.viw));
      this.vix.hf();
      this.vix.show();
      this.vix.uWw.setOnKeyListener(this);
      this.vix.uWw.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.e.small_line_color)));
      this.vix.uWw.setSelector(this.mContext.getResources().getDrawable(R.g.popup_menu_selector));
      this.vix.uWw.setDividerHeight(1);
      this.vix.uWw.setVerticalScrollBarEnabled(false);
      this.vix.uWw.setHorizontalScrollBarEnabled(false);
      return true;
    }
    return false;
  }
  
  public final boolean cCw()
  {
    if (isShowing())
    {
      this.vix.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean isShowing()
  {
    return (this.vix != null) && (this.vix.fvf.isShowing());
  }
  
  public final void onDismiss() {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public static final class a
  {
    private static DisplayMetrics viC = null;
    
    public static h.a.a a(Context paramContext, TextPaint paramTextPaint, List<j> paramList, int paramInt)
    {
      h.a.a locala = new h.a.a();
      if (viC == null) {
        viC = paramContext.getResources().getDisplayMetrics();
      }
      DisplayMetrics localDisplayMetrics = viC;
      Point localPoint = ar.gx(paramContext);
      int k = localPoint.x;
      if ((k != localDisplayMetrics.widthPixels) || (localPoint.y != localDisplayMetrics.heightPixels)) {
        y.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.heightPixels) });
      }
      paramList = paramList.iterator();
      float f1 = 0.0F;
      if (paramList.hasNext())
      {
        float f2 = paramTextPaint.measureText(((j)paramList.next()).name);
        if (f1 >= f2) {
          break label301;
        }
        f1 = f2;
      }
      label301:
      for (;;)
      {
        break;
        int i = (int)f1;
        i = a.fromDPToPix(paramContext, 30) * 2 + i;
        int j = a.fromDPToPix(paramContext, 95);
        if (i < j) {
          i = j;
        }
        for (;;)
        {
          if (paramInt - i / 2 < 0)
          {
            locala.hyd = 0;
            locala.hye = (k - (i + 0));
            return locala;
          }
          if (k - (i / 2 + paramInt) < 0)
          {
            locala.hyd = (k - (i + 0));
            locala.hye = 0;
            return locala;
          }
          locala.hyd = (paramInt - i / 2);
          locala.hye = (k - (i / 2 + paramInt));
          return locala;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */