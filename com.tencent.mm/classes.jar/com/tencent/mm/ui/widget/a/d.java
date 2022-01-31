package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ViewTreeObserver US;
  private RecyclerView acI;
  private int bottomSheetStyle;
  private BottomSheetBehavior fK;
  private View hX;
  public View jdj;
  public Context mContext;
  public boolean nrO = false;
  public n.c phH;
  public n.d phI;
  private l phJ;
  private boolean rwZ = false;
  private boolean rxa;
  public boolean rxb;
  public boolean rxc = false;
  private int vAC;
  public n.a wdr;
  public n.b wds;
  public d.a wmU;
  private Dialog wmV;
  private n.d wmW;
  private l wmX;
  public Boolean wmY = Boolean.valueOf(false);
  private LinearLayout wmZ;
  private LinearLayout wna;
  private d.b wnb;
  private boolean wnc = false;
  private boolean wnd = false;
  private boolean wne = false;
  private int wnf;
  public ImageView wng;
  private int wnh = 4;
  private int wni = this.wnh * 3;
  private int wnj = 6;
  private boolean wnk;
  private boolean wnl = false;
  public boolean wnm = false;
  private boolean wnn = false;
  public int wno = 0;
  private boolean wnp = false;
  
  public d(Context paramContext)
  {
    this.bottomSheetStyle = 1;
    this.mContext = paramContext;
    this.wnp = true;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label155;
      }
    }
    label155:
    for (this.hX = paramContext.getChildAt(0);; this.hX = paramContext)
    {
      ca(this.mContext);
      return;
    }
  }
  
  public d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.bottomSheetStyle = paramInt;
    this.mContext = paramContext;
    this.wnk = paramBoolean;
    this.wnn = false;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label160;
      }
    }
    label160:
    for (this.hX = paramContext.getChildAt(0);; this.hX = paramContext)
    {
      ca(this.mContext);
      return;
    }
  }
  
  private boolean biH()
  {
    return this.mContext.getResources().getConfiguration().orientation == 2;
  }
  
  private void ca(Context paramContext)
  {
    this.phJ = new l(paramContext);
    this.wmX = new l(paramContext);
    label194:
    label220:
    int i;
    if (this.wnp)
    {
      this.wmV = new b(paramContext);
      this.jdj = View.inflate(paramContext, a.g.mm_bottom_sheet, null);
      this.wmZ = ((LinearLayout)this.jdj.findViewById(a.f.bottom_sheet_title));
      this.wna = ((LinearLayout)this.jdj.findViewById(a.f.bottom_sheet_footer));
      this.wng = ((ImageView)this.jdj.findViewById(a.f.deviderline));
      this.acI = ((RecyclerView)this.jdj.findViewById(a.f.bottom_sheet_menu_reccycleview));
      this.acI.setHasFixedSize(true);
      this.rwZ = biH();
      if (this.bottomSheetStyle != 0) {
        break label489;
      }
      if (!this.rwZ) {
        break label461;
      }
      this.wnh = 7;
      this.wni = (this.wnh * 2);
      this.vAC = (ap.ab(this.mContext, a.d.BottomSheetGridMaxHeight_Landscape) + ap.ab(this.mContext, a.d.grid_item_top_bottom_padding));
      if (this.wnk) {
        this.vAC += ap.ab(this.mContext, a.d.grid_item_top_bottom_padding);
      }
      if ((this.wnk) && (this.wng != null) && (this.wnn)) {
        this.wng.setVisibility(0);
      }
      if (this.bottomSheetStyle != 0) {
        break label743;
      }
      this.acI.setLayoutManager(new GridLayoutManager(this.wnh));
      int j = ap.ab(this.mContext, a.d.grid_item_left_right_padding);
      i = ap.ab(this.mContext, a.d.grid_item_top_bottom_padding);
      if (this.wnk) {
        i = ap.fromDPToPix(this.mContext, 0);
      }
      this.acI.setPadding(j, i, j, 0);
    }
    for (;;)
    {
      this.wnb = new d.b(this);
      this.wnb.aeW = new d.1(this);
      this.acI.setAdapter(this.wnb);
      this.acI.setOverScrollMode(1);
      this.wmV.setContentView(this.jdj);
      if (!this.wnp)
      {
        this.fK = BottomSheetBehavior.i((View)this.jdj.getParent());
        this.fK.u(this.vAC);
        this.fK.fA = new d.2(this);
      }
      this.wmV.setOnDismissListener(new d.3(this));
      return;
      this.wmV = new c(paramContext);
      break;
      label461:
      this.vAC = (ap.ab(this.mContext, a.d.BottomSheetGridMaxHeight) + ap.ab(this.mContext, a.d.grid_item_top_bottom_padding));
      break label194;
      label489:
      if (this.bottomSheetStyle == 2)
      {
        this.wnd = true;
        i = ap.ab(this.mContext, a.d.bottomsheet_list_checkbox_item_height);
        if (this.rwZ) {
          this.wnj = 2;
        }
        for (this.vAC = ((int)(i * 2.5D) + ap.ab(this.mContext, a.d.bottomsheet_dividing_line_height));; this.vAC = ((int)(i * 3.5D) + ap.ab(this.mContext, a.d.bottomsheet_dividing_line_height)))
        {
          if (!this.wnk) {
            break label603;
          }
          this.vAC += ap.fromDPToPix(this.mContext, 88);
          break;
          this.wnj = 3;
        }
        break label220;
      }
      label603:
      this.wne = true;
      i = ap.ab(this.mContext, a.d.bottomsheet_list_item_height);
      if (this.rwZ) {
        this.wnj = 4;
      }
      for (this.vAC = ((int)(i * 4.5D) + ap.ab(this.mContext, a.d.bottomsheet_dividing_line_height));; this.vAC = ((int)(i * 6.5D) + ap.ab(this.mContext, a.d.bottomsheet_dividing_line_height)))
      {
        if (this.wnk) {
          this.vAC += ap.ab(this.mContext, a.d.grid_item_top_bottom_padding);
        }
        if (!this.wnp) {
          break;
        }
        i = ap.fromDPToPix(this.mContext, 24);
        this.wng.setPadding(i, 0, i, 0);
        break;
        this.wnj = 6;
      }
      label743:
      this.acI.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    return i;
  }
  
  public final void bFp()
  {
    if (this.US != null)
    {
      if (!this.US.isAlive()) {
        this.US = this.hX.getViewTreeObserver();
      }
      this.US.removeGlobalOnLayoutListener(this);
      this.US = null;
    }
    if (this.wmV != null)
    {
      if (this.fK != null) {
        this.fK.fq = true;
      }
      this.wmV.dismiss();
    }
  }
  
  public final void cKf()
  {
    if (this.wmV != null)
    {
      if ((this.wmX != null) && (this.wnb != null)) {
        this.wnb.agL.notifyChanged();
      }
      this.wmV.show();
    }
  }
  
  public final void cfU()
  {
    this.rwZ = biH();
    this.wnf = getRotation();
    if (this.phH != null) {
      this.phH.a(this.phJ);
    }
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    if (this.wmV != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdj.getLayoutParams();
      i = this.phJ.size();
      if (!this.wnc) {
        break label611;
      }
      i += 1;
    }
    label134:
    label281:
    label668:
    label673:
    label803:
    for (;;)
    {
      int j;
      int k;
      label164:
      Rect localRect;
      if (this.wnp)
      {
        j = ap.ab(this.mContext, a.d.bottomsheet_list_item_height);
        if (this.wnk)
        {
          k = ap.fromDPToPix(this.mContext, 132);
          this.vAC = ((int)(j * 4.5D) + k + ap.ab(this.mContext, a.d.bottomsheet_dividing_line_height));
        }
      }
      else
      {
        if (this.bottomSheetStyle != 0) {
          break label648;
        }
        if (this.wnb.getItemCount() > this.wni) {
          localLayoutParams.height = this.vAC;
        }
        if ((this.rwZ) && (this.hX != null))
        {
          localRect = new Rect();
          this.hX.getWindowVisibleDisplayFrame(localRect);
          if (!this.wnp) {
            break label730;
          }
          localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
          Context localContext = this.mContext;
          if ((!(localContext instanceof Activity)) || ((((Activity)localContext).getWindow().getAttributes().flags & 0x400) != 1024)) {
            break label668;
          }
          j = 0;
          if (j == 0) {
            break label673;
          }
          localLayoutParams.height = (localRect.bottom - aq.gA(this.mContext));
          if (this.wnk)
          {
            k = ap.ab(this.mContext, a.d.bottomsheet_list_item_height);
            if (i > this.wnj) {
              break label686;
            }
            i = localLayoutParams.height - i * k;
            label317:
            if (this.wmZ != null) {
              this.wmZ.setMinimumHeight(i);
            }
          }
        }
        label332:
        this.jdj.setLayoutParams(localLayoutParams);
        if ((this.wmX != null) && (this.wnb != null)) {
          this.wnb.agL.notifyChanged();
        }
        if (Build.VERSION.SDK_INT >= 21) {
          this.wmV.getWindow().addFlags(-2147483648);
        }
        if ((this.rxa) && (Build.VERSION.SDK_INT >= 23) && (this.wmV != null))
        {
          this.wmV.getWindow().getDecorView().setSystemUiVisibility(9216);
          this.wmV.getWindow().setStatusBarColor(0);
        }
        if (this.rxb) {
          this.wmV.getWindow().addFlags(1024);
        }
        if (!this.rxc) {
          break label743;
        }
        this.wmV.getWindow().setFlags(8, 8);
        this.wmV.getWindow().addFlags(131200);
        this.wmV.getWindow().getDecorView().setSystemUiVisibility(6);
        label504:
        if (this.fK != null) {
          this.fK.fq = false;
        }
        if (this.wmU != null) {
          this.wmV.setOnDismissListener(new d.4(this));
        }
        if (this.hX != null) {
          if (this.US != null) {
            break label798;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        this.US = this.hX.getViewTreeObserver();
        if (i != 0) {
          this.US.addOnGlobalLayoutListener(this);
        }
        if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
          this.wmV.show();
        }
        return;
        label611:
        if (this.wmX.size() <= 0) {
          break label803;
        }
        i += this.wmX.size();
        break;
        this.vAC = ((int)(j * 6.5D));
        break label134;
        if (i <= this.wnj) {
          break label164;
        }
        localLayoutParams.height = this.vAC;
        break label164;
        j = 1;
        break label259;
        localLayoutParams.height = localRect.bottom;
        break label281;
        label686:
        j = localLayoutParams.height - (int)(k * (this.wnj + 0.5D));
        i = j;
        if (j <= ap.fromDPToPix(this.mContext, 150)) {
          break label317;
        }
        i = j - k;
        break label317;
        label730:
        localLayoutParams.width = localRect.right;
        break label332;
        label743:
        this.wmV.getWindow().clearFlags(8);
        this.wmV.getWindow().clearFlags(131072);
        this.wmV.getWindow().clearFlags(128);
        this.wmV.getWindow().getDecorView().setSystemUiVisibility(0);
        break label504;
      }
    }
  }
  
  public final void ej(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.wnk = true;
      if (this.wng != null) {
        this.wng.setVisibility(0);
      }
    } while (this.wmZ == null);
    this.wmZ.setVisibility(0);
    this.wmZ.removeAllViews();
    this.wmZ.setGravity(17);
    this.wmZ.addView(paramView, -1, -2);
  }
  
  public final void h(CharSequence paramCharSequence, int paramInt)
  {
    if ((this.wmZ != null) && (this.wnk))
    {
      this.wmZ.setVisibility(0);
      this.wmZ.removeAllViews();
      this.wmZ.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(a.g.mm_bottom_sheet_title_text, null);
      TextView localTextView = (TextView)localView.findViewById(a.f.title_text);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      this.wmZ.addView(localView, -1, -2);
    }
  }
  
  public final boolean isShowing()
  {
    return (this.wmV != null) && (this.wmV.isShowing());
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.hX;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      bFp();
    }
    label28:
    while ((!isShowing()) || ((this.rwZ == biH()) && (this.wnf == getRotation()))) {
      return;
    }
    bFp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */