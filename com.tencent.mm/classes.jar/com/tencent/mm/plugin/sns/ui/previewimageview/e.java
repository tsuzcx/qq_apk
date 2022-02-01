package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.plugin.sns.ui.y.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  implements y
{
  private ImageView AgE;
  private boolean AzE;
  c AzF;
  DynamicGridView AzG;
  y.a AzH;
  float AzI;
  View AzJ;
  ImageView AzK;
  private View AzL;
  private int AzM;
  private Rect AzN;
  private Context context;
  private View wGb;
  TextView zRl;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, final DynamicGridView paramDynamicGridView, y.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(100293);
    this.AzE = paramBoolean;
    this.context = paramContext;
    this.AzH = parama;
    this.AzJ = paramView2;
    this.wGb = paramView3;
    this.AzG = paramDynamicGridView;
    this.AzK = ((ImageView)paramView2.findViewById(2131298957));
    this.zRl = ((TextView)paramView2.findViewById(2131298961));
    this.AzL = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    ag.dTT();
    this.AzM = ((u.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(2131166845) * 4 - paramContext.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.AzM + paramContext.getResources().getDimensionPixelSize(2131166845) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.AzF = new c(paramContext, paramList, paramBoolean, parama1);
    eeo();
    paramDynamicGridView.setAdapter(this.AzF);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void RF(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        ad.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.AzI = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).AzJ.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).AzJ, "translationY", new float[] { ((e)localObject).AzJ.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void RG(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        ad.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.AzF;
        Object localObject = localc.getItem(paramAnonymousInt);
        localc.mItems.remove(localObject);
        localc.Azw.remove(localObject);
        localc.notifyDataSetChanged();
        if (localc.AzB != null)
        {
          int i = localc.Azx;
          localc.AzB.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void eep()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.AzJ, "translationY", new float[] { 0.0F, locale.AzJ.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.AzF.eem();
        AppMethodBeat.o(100283);
      }
      
      public final void l(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (m(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.AzJ.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.AzK.setImageResource(2131691194);
          paramAnonymousRect.zRl.setText("松手即可删除");
          AppMethodBeat.o(100282);
          return;
        }
        e.b(e.this);
        AppMethodBeat.o(100282);
      }
      
      public final boolean m(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100284);
        boolean bool = e.a(e.this, paramAnonymousRect);
        AppMethodBeat.o(100284);
        return bool;
      }
    });
    paramDynamicGridView.setOnItemLongClickListener(new e.2(this));
    paramDynamicGridView.setOnItemClickListener(new e.3(this));
    paramDynamicGridView.setOnDropListener(new DynamicGridView.f()
    {
      public final void eeq()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.qkC = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.eew()) && (localDynamicGridView.AAj)) {
          localDynamicGridView.sb(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.AzI);
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
        e.this.RE(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    ag.dTT();
    if (u.getScreenWidth() == 0) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.RE(paramList.size());
          e.this.AzF.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(100293);
  }
  
  private void eeo()
  {
    AppMethodBeat.i(100295);
    if ((aj.fkD().getBoolean("key_show_tips", true)) && (this.AzF.een() > 1))
    {
      this.wGb.setVisibility(0);
      this.AgE = ((ImageView)this.wGb.findViewById(2131304984));
      this.AgE.setOnClickListener(new e.7(this));
      AppMethodBeat.o(100295);
      return;
    }
    this.wGb.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void RE(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    ag.dTT();
    this.AzM = ((u.getScreenWidth() - this.context.getResources().getDimensionPixelSize(2131166845) * 4 - this.context.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    this.AzG.setColumnWidth(this.AzM + this.context.getResources().getDimensionPixelSize(2131166845) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.AzG.getLayoutParams();
    ag.dTT();
    ad.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(u.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.AzL.getHeight();
      int k = this.AzM;
      int m = this.context.getResources().getDimensionPixelSize(2131166845);
      int n = localMarginLayoutParams.rightMargin;
      float f = g.aQF().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.AzG.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.AzG != null) && (this.AzG.getAdapter() == null)) {
      ((c)this.AzG.getAdapter()).zVg = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.AzG;
  }
  
  public final void setImageClick(y.a parama)
  {
    this.AzH = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.AzE = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(100296);
    if (this.AzF != null)
    {
      this.AzF.gf(paramList);
      eeo();
    }
    AppMethodBeat.o(100296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */