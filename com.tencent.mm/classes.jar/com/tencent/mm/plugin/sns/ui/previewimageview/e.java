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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.ab.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class e
  implements ab
{
  private View GLc;
  TextView KEn;
  private ImageView KVb;
  private boolean Lqf;
  c Lqg;
  DynamicGridView Lqh;
  ab.a Lqi;
  float Lqj;
  View Lqk;
  ImageView Lql;
  private View Lqm;
  private int Lqn;
  private Rect Lqo;
  private Context context;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, final DynamicGridView paramDynamicGridView, ab.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(100293);
    this.Lqf = paramBoolean;
    this.context = paramContext;
    this.Lqi = parama;
    this.Lqk = paramView2;
    this.GLc = paramView3;
    this.Lqh = paramDynamicGridView;
    this.Lql = ((ImageView)paramView2.findViewById(i.f.del_img));
    this.KEn = ((TextView)paramView2.findViewById(i.f.del_tv));
    this.Lqm = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    aj.fOx();
    this.Lqn = ((r.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - paramContext.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.Lqn + paramContext.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.Lqg = new c(paramContext, paramList, paramBoolean, parama1);
    fYI();
    paramDynamicGridView.setAdapter(this.Lqg);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void ZM(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        Log.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.Lqj = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).Lqk.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).Lqk, "translationY", new float[] { ((e)localObject).Lqk.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void ahD(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        Log.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.Lqg;
        localc.remove(localc.getItem(paramAnonymousInt));
        if (localc.Lqc != null)
        {
          int i = localc.LpY;
          localc.Lqc.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void fYJ()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.Lqk, "translationY", new float[] { 0.0F, locale.Lqk.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.Lqg.fYG();
        AppMethodBeat.o(100283);
      }
      
      public final void u(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (v(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.Lqk.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.Lql.setImageResource(i.i.sns_img_highlight_delete);
          paramAnonymousRect.KEn.setText("松手即可删除");
          AppMethodBeat.o(100282);
          return;
        }
        e.b(e.this);
        AppMethodBeat.o(100282);
      }
      
      public final boolean v(Rect paramAnonymousRect)
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (e.this.Lqi != null)
        {
          if (paramAnonymousView.getTag() == null)
          {
            a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100285);
            return;
          }
          paramAnonymousInt = ((Integer)paramAnonymousView.getTag()).intValue();
          Log.i("DynamicGrid", "click ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 2147483647)
          {
            a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100285);
            return;
          }
          e.this.Lqi.Si(paramAnonymousInt);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100285);
      }
    });
    paramDynamicGridView.setOnDropListener(new DynamicGridView.f()
    {
      public final void fYK()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.vok = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.fYQ()) && (localDynamicGridView.LqK)) {
          localDynamicGridView.zi(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.Lqj);
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
        e.this.ahC(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    aj.fOx();
    if (r.getScreenWidth() == 0) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.ahC(paramList.size());
          e.this.Lqg.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(100293);
  }
  
  private void fYI()
  {
    AppMethodBeat.i(100295);
    if ((MMApplicationContext.getDefaultPreference().getBoolean("key_show_tips", true)) && (this.Lqg.fYH() > 1))
    {
      this.GLc.setVisibility(0);
      this.KVb = ((ImageView)this.GLc.findViewById(i.f.sns_img_close_iv));
      this.KVb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100289);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          e.a(e.this);
          a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100289);
        }
      });
      AppMethodBeat.o(100295);
      return;
    }
    this.GLc.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void ahC(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    aj.fOx();
    this.Lqn = ((r.getScreenWidth() - this.context.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - this.context.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
    this.Lqh.setColumnWidth(this.Lqn + this.context.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Lqh.getLayoutParams();
    aj.fOx();
    Log.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(r.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.Lqm.getHeight();
      int k = this.Lqn;
      int m = this.context.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin);
      int n = localMarginLayoutParams.rightMargin;
      float f = BitmapUtil.getDefaultDisplayMetrics().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.Lqh.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.Lqh != null) && (this.Lqh.getAdapter() == null)) {
      ((c)this.Lqh.getAdapter()).KIR = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.Lqh;
  }
  
  public final void hJ(List<String> paramList)
  {
    AppMethodBeat.i(100296);
    if (this.Lqg != null)
    {
      this.Lqg.hU(paramList);
      fYI();
    }
    AppMethodBeat.o(100296);
  }
  
  public final void setImageClick(ab.a parama)
  {
    this.Lqi = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.Lqf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */