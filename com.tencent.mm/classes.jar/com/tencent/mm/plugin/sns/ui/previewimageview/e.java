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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  implements x
{
  private Context context;
  private ImageView xCu;
  private boolean xUG;
  c xUH;
  DynamicGridView xUI;
  x.a xUJ;
  float xUK;
  View xUL;
  ImageView xUM;
  private View xUN;
  private View xUO;
  private int xUP;
  private Rect xUQ;
  TextView xnd;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, final DynamicGridView paramDynamicGridView, x.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(100293);
    this.xUG = paramBoolean;
    this.context = paramContext;
    this.xUJ = parama;
    this.xUL = paramView2;
    this.xUN = paramView3;
    this.xUI = paramDynamicGridView;
    this.xUM = ((ImageView)paramView2.findViewById(2131298957));
    this.xnd = ((TextView)paramView2.findViewById(2131298961));
    this.xUO = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    af.dtj();
    this.xUP = ((u.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(2131166845) * 4 - paramContext.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.xUP + paramContext.getResources().getDimensionPixelSize(2131166845) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.xUH = new c(paramContext, paramList, paramBoolean, parama1);
    dDw();
    paramDynamicGridView.setAdapter(this.xUH);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void NS(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        ad.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.xUK = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).xUL.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).xUL, "translationY", new float[] { ((e)localObject).xUL.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void NT(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        ad.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.xUH;
        Object localObject = localc.getItem(paramAnonymousInt);
        localc.mItems.remove(localObject);
        localc.xUy.remove(localObject);
        localc.notifyDataSetChanged();
        if (localc.xUD != null)
        {
          int i = localc.xUz;
          localc.xUD.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void dDx()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.xUL, "translationY", new float[] { 0.0F, locale.xUL.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.xUH.dDu();
        AppMethodBeat.o(100283);
      }
      
      public final void p(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (q(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.xUL.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.xUM.setImageResource(2131691194);
          paramAnonymousRect.xnd.setText("松手即可删除");
          AppMethodBeat.o(100282);
          return;
        }
        e.b(e.this);
        AppMethodBeat.o(100282);
      }
      
      public final boolean q(Rect paramAnonymousRect)
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
        if (e.this.xUJ != null)
        {
          if (paramAnonymousView.getTag() == null)
          {
            AppMethodBeat.o(100285);
            return;
          }
          paramAnonymousInt = ((Integer)paramAnonymousView.getTag()).intValue();
          ad.i("DynamicGrid", "click ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 2147483647)
          {
            AppMethodBeat.o(100285);
            return;
          }
          e.this.xUJ.Je(paramAnonymousInt);
        }
        AppMethodBeat.o(100285);
      }
    });
    paramDynamicGridView.setOnDropListener(new DynamicGridView.f()
    {
      public final void dDy()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.pdM = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.dDE()) && (localDynamicGridView.xVo)) {
          localDynamicGridView.qx(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.xUK);
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
        e.this.NR(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    af.dtj();
    if (u.getScreenWidth() == 0) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.NR(paramList.size());
          e.this.xUH.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(100293);
  }
  
  private void dDw()
  {
    AppMethodBeat.i(100295);
    if ((aj.eFE().getBoolean("key_show_tips", true)) && (this.xUH.dDv() > 1))
    {
      this.xUN.setVisibility(0);
      this.xCu = ((ImageView)this.xUN.findViewById(2131304984));
      this.xCu.setOnClickListener(new View.OnClickListener()
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
    this.xUN.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void NR(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    af.dtj();
    this.xUP = ((u.getScreenWidth() - this.context.getResources().getDimensionPixelSize(2131166845) * 4 - this.context.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
    this.xUI.setColumnWidth(this.xUP + this.context.getResources().getDimensionPixelSize(2131166845) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.xUI.getLayoutParams();
    af.dtj();
    ad.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(u.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.xUO.getHeight();
      int k = this.xUP;
      int m = this.context.getResources().getDimensionPixelSize(2131166845);
      int n = localMarginLayoutParams.rightMargin;
      float f = f.aGH().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.xUI.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.xUI != null) && (this.xUI.getAdapter() == null)) {
      ((c)this.xUI.getAdapter()).xqV = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.xUI;
  }
  
  public final void setImageClick(x.a parama)
  {
    this.xUJ = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.xUG = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(100296);
    if (this.xUH != null)
    {
      this.xUH.fM(paramList);
      dDw();
    }
    AppMethodBeat.o(100296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */