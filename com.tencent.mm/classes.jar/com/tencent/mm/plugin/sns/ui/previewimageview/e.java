package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.ui.ac;
import com.tencent.mm.plugin.sns.ui.ac.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class e
  implements ac
{
  private View MHV;
  private boolean RSZ;
  c RTa;
  DynamicGridView RTb;
  ac.a RTc;
  float RTd;
  View RTe;
  ImageView RTf;
  private View RTg;
  private int RTh;
  private Rect RTi;
  TextView RdP;
  private ImageView RuZ;
  private Context context;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, int paramInt, final DynamicGridView paramDynamicGridView, ac.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(369956);
    this.RSZ = paramBoolean;
    this.context = paramContext;
    this.RTc = parama;
    this.RTe = paramView2;
    this.MHV = paramView3;
    this.RTb = paramDynamicGridView;
    this.RTf = ((ImageView)paramView2.findViewById(b.f.del_img));
    this.RdP = ((TextView)paramView2.findViewById(b.f.del_tv));
    this.RTg = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    al.hgq();
    this.RTh = ((aa.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin) * 4 - paramContext.getResources().getDimensionPixelSize(b.d.LargerPadding) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.RTh + paramContext.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.RTa = new c(paramContext, paramList, paramInt, paramBoolean, parama1);
    hrR();
    paramDynamicGridView.setAdapter(this.RTa);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void C(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (D(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.RTe.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.RTf.setImageResource(b.i.sns_img_highlight_delete);
          paramAnonymousRect.RdP.setText(b.j.sns_loose_to_del);
          AppMethodBeat.o(100282);
          return;
        }
        e.b(e.this);
        AppMethodBeat.o(100282);
      }
      
      public final boolean D(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100284);
        boolean bool = e.a(e.this, paramAnonymousRect);
        AppMethodBeat.o(100284);
        return bool;
      }
      
      public final void adZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        Log.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.RTd = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).RTe.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).RTe, "translationY", new float[] { ((e)localObject).RTe.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void amF(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        Log.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.RTa;
        localc.remove(localc.getItem(paramAnonymousInt));
        if (localc.RSV != null)
        {
          int i = localc.RSR;
          localc.RSV.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void hrS()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.RTe, "translationY", new float[] { 0.0F, locale.RTe.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.RTa.hrP();
        AppMethodBeat.o(100283);
      }
    });
    paramDynamicGridView.setOnItemLongClickListener(new e.2(this));
    paramDynamicGridView.setOnItemClickListener(new e.3(this));
    paramDynamicGridView.setOnDropListener(new DynamicGridView.f()
    {
      public final void hrT()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.yAG = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.hrZ()) && (localDynamicGridView.RTE)) {
          localDynamicGridView.Ey(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.RTd);
          AppMethodBeat.o(100286);
          return;
        }
        paramView1.bringToFront();
        AppMethodBeat.o(100286);
      }
    });
    paramDynamicGridView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100287);
        paramDynamicGridView.getViewTreeObserver().removeOnPreDrawListener(this);
        e.this.amE(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    al.hgq();
    if (aa.getScreenWidth() == 0) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.amE(paramList.size());
          e.this.RTa.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(369956);
  }
  
  private void hrR()
  {
    AppMethodBeat.i(100295);
    if ((MMApplicationContext.getDefaultPreference().getBoolean("key_show_tips", true)) && (this.RTa.hrQ() > 1))
    {
      this.MHV.setVisibility(0);
      this.RuZ = ((ImageView)this.MHV.findViewById(b.f.sns_img_close_iv));
      this.RuZ.setOnClickListener(new e.7(this));
      AppMethodBeat.o(100295);
      return;
    }
    this.MHV.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void ah(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(369957);
    if (this.RTa != null)
    {
      this.RTa.kY(paramList);
      hrR();
    }
    AppMethodBeat.o(369957);
  }
  
  public final void amE(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    al.hgq();
    this.RTh = ((aa.getScreenWidth() - this.context.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin) * 4 - this.context.getResources().getDimensionPixelSize(b.d.LargerPadding) * 2) / 3);
    this.RTb.setColumnWidth(this.RTh + this.context.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.RTb.getLayoutParams();
    al.hgq();
    Log.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(aa.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.RTg.getHeight();
      int k = this.RTh;
      int m = this.context.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin);
      int n = localMarginLayoutParams.rightMargin;
      float f = BitmapUtil.getDefaultDisplayMetrics().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.RTb.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.RTb != null) && (this.RTb.getAdapter() == null)) {
      ((c)this.RTb.getAdapter()).Ris = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.RTb;
  }
  
  public final void setImageClick(ac.a parama)
  {
    this.RTc = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.RSZ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */