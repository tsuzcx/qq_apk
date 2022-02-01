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
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.x;
import com.tencent.mm.plugin.sns.ui.x.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  implements x
{
  private Context context;
  private ImageView yPi;
  TextView yzU;
  private boolean zhC;
  c zhD;
  DynamicGridView zhE;
  x.a zhF;
  float zhG;
  View zhH;
  ImageView zhI;
  private View zhJ;
  private View zhK;
  private int zhL;
  private Rect zhM;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, final DynamicGridView paramDynamicGridView, x.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(100293);
    this.zhC = paramBoolean;
    this.context = paramContext;
    this.zhF = parama;
    this.zhH = paramView2;
    this.zhJ = paramView3;
    this.zhE = paramDynamicGridView;
    this.zhI = ((ImageView)paramView2.findViewById(2131298957));
    this.yzU = ((TextView)paramView2.findViewById(2131298961));
    this.zhK = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    af.dHG();
    this.zhL = ((u.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(2131166845) * 4 - paramContext.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.zhL + paramContext.getResources().getDimensionPixelSize(2131166845) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.zhD = new c(paramContext, paramList, paramBoolean, parama1);
    dRU();
    paramDynamicGridView.setAdapter(this.zhD);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void PW(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        ac.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.zhG = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).zhH.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).zhH, "translationY", new float[] { ((e)localObject).zhH.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void PX(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        ac.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.zhD;
        Object localObject = localc.getItem(paramAnonymousInt);
        localc.mItems.remove(localObject);
        localc.zhu.remove(localObject);
        localc.notifyDataSetChanged();
        if (localc.zhz != null)
        {
          int i = localc.zhv;
          localc.zhz.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void dRV()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.zhH, "translationY", new float[] { 0.0F, locale.zhH.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.zhD.dRS();
        AppMethodBeat.o(100283);
      }
      
      public final void o(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (p(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.zhH.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.zhI.setImageResource(2131691194);
          paramAnonymousRect.yzU.setText("松手即可删除");
          AppMethodBeat.o(100282);
          return;
        }
        e.b(e.this);
        AppMethodBeat.o(100282);
      }
      
      public final boolean p(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100284);
        boolean bool = e.a(e.this, paramAnonymousRect);
        AppMethodBeat.o(100284);
        return bool;
      }
    });
    paramDynamicGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        return true;
      }
    });
    paramDynamicGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100285);
        if (e.this.zhF != null)
        {
          if (paramAnonymousView.getTag() == null)
          {
            AppMethodBeat.o(100285);
            return;
          }
          paramAnonymousInt = ((Integer)paramAnonymousView.getTag()).intValue();
          ac.i("DynamicGrid", "click ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 2147483647)
          {
            AppMethodBeat.o(100285);
            return;
          }
          e.this.zhF.Ld(paramAnonymousInt);
        }
        AppMethodBeat.o(100285);
      }
    });
    paramDynamicGridView.setOnDropListener(new DynamicGridView.f()
    {
      public final void dRW()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.pGX = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.dSc()) && (localDynamicGridView.zik)) {
          localDynamicGridView.rv(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.zhG);
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
        e.this.PV(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    af.dHG();
    if (u.getScreenWidth() == 0) {
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.PV(paramList.size());
          e.this.zhD.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(100293);
  }
  
  private void dRU()
  {
    AppMethodBeat.i(100295);
    if ((ai.eUY().getBoolean("key_show_tips", true)) && (this.zhD.dRT() > 1))
    {
      this.zhJ.setVisibility(0);
      this.yPi = ((ImageView)this.zhJ.findViewById(2131304984));
      this.yPi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100289);
          e.a(e.this);
          AppMethodBeat.o(100289);
        }
      });
      AppMethodBeat.o(100295);
      return;
    }
    this.zhJ.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void PV(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    af.dHG();
    this.zhL = ((u.getScreenWidth() - this.context.getResources().getDimensionPixelSize(2131166845) * 4 - this.context.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    this.zhE.setColumnWidth(this.zhL + this.context.getResources().getDimensionPixelSize(2131166845) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.zhE.getLayoutParams();
    af.dHG();
    ac.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(u.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.zhK.getHeight();
      int k = this.zhL;
      int m = this.context.getResources().getDimensionPixelSize(2131166845);
      int n = localMarginLayoutParams.rightMargin;
      float f = f.aNu().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.zhE.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.zhE != null) && (this.zhE.getAdapter() == null)) {
      ((c)this.zhE.getAdapter()).yDL = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.zhE;
  }
  
  public final void setImageClick(x.a parama)
  {
    this.zhF = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.zhC = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(100296);
    if (this.zhD != null)
    {
      this.zhD.fU(paramList);
      dRU();
    }
    AppMethodBeat.o(100296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */