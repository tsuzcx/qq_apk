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
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.plugin.sns.ui.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  implements y
{
  private boolean ARa;
  c ARb;
  DynamicGridView ARc;
  y.a ARd;
  float ARe;
  View ARf;
  ImageView ARg;
  private View ARh;
  private int ARi;
  private Rect ARj;
  TextView Ais;
  private ImageView AxQ;
  private Context context;
  private View wVN;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, final DynamicGridView paramDynamicGridView, y.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(100293);
    this.ARa = paramBoolean;
    this.context = paramContext;
    this.ARd = parama;
    this.ARf = paramView2;
    this.wVN = paramView3;
    this.ARc = paramDynamicGridView;
    this.ARg = ((ImageView)paramView2.findViewById(2131298957));
    this.Ais = ((TextView)paramView2.findViewById(2131298961));
    this.ARh = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    ah.dXt();
    this.ARi = ((u.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(2131166845) * 4 - paramContext.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.ARi + paramContext.getResources().getDimensionPixelSize(2131166845) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.ARb = new c(paramContext, paramList, paramBoolean, parama1);
    ehW();
    paramDynamicGridView.setAdapter(this.ARb);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void Sm(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        ae.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.ARe = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).ARf.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).ARf, "translationY", new float[] { ((e)localObject).ARf.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void Sn(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        ae.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.ARb;
        Object localObject = localc.getItem(paramAnonymousInt);
        localc.mItems.remove(localObject);
        localc.AQS.remove(localObject);
        localc.notifyDataSetChanged();
        if (localc.AQX != null)
        {
          int i = localc.AQT;
          localc.AQX.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void ehX()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.ARf, "translationY", new float[] { 0.0F, locale.ARf.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.ARb.ehU();
        AppMethodBeat.o(100283);
      }
      
      public final void l(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (m(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.ARf.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.ARg.setImageResource(2131691194);
          paramAnonymousRect.Ais.setText("松手即可删除");
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
      public final void ehY()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.qrh = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.eie()) && (localDynamicGridView.ARF)) {
          localDynamicGridView.si(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.ARe);
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
        e.this.Sl(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    ah.dXt();
    if (u.getScreenWidth() == 0) {
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.Sl(paramList.size());
          e.this.ARb.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(100293);
  }
  
  private void ehW()
  {
    AppMethodBeat.i(100295);
    if ((ak.fox().getBoolean("key_show_tips", true)) && (this.ARb.ehV() > 1))
    {
      this.wVN.setVisibility(0);
      this.AxQ = ((ImageView)this.wVN.findViewById(2131304984));
      this.AxQ.setOnClickListener(new e.7(this));
      AppMethodBeat.o(100295);
      return;
    }
    this.wVN.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void Sl(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    ah.dXt();
    this.ARi = ((u.getScreenWidth() - this.context.getResources().getDimensionPixelSize(2131166845) * 4 - this.context.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    this.ARc.setColumnWidth(this.ARi + this.context.getResources().getDimensionPixelSize(2131166845) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ARc.getLayoutParams();
    ah.dXt();
    ae.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(u.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.ARh.getHeight();
      int k = this.ARi;
      int m = this.context.getResources().getDimensionPixelSize(2131166845);
      int n = localMarginLayoutParams.rightMargin;
      float f = h.aRe().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.ARc.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.ARc != null) && (this.ARc.getAdapter() == null)) {
      ((c)this.ARc.getAdapter()).Amo = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.ARc;
  }
  
  public final void setImageClick(y.a parama)
  {
    this.ARd = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.ARa = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(100296);
    if (this.ARb != null)
    {
      this.ARb.go(paramList);
      ehW();
    }
    AppMethodBeat.o(100296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */