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
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.plugin.sns.ui.z.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  implements z
{
  private View ARQ;
  private ImageView EHg;
  TextView EqV;
  private boolean FbH;
  c FbI;
  DynamicGridView FbJ;
  z.a FbK;
  float FbL;
  View FbM;
  ImageView FbN;
  private View FbO;
  private int FbP;
  private Rect FbQ;
  private Context context;
  
  public e(final View paramView1, View paramView2, View paramView3, Context paramContext, final List<String> paramList, final DynamicGridView paramDynamicGridView, z.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(100293);
    this.FbH = paramBoolean;
    this.context = paramContext;
    this.FbK = parama;
    this.FbM = paramView2;
    this.ARQ = paramView3;
    this.FbJ = paramDynamicGridView;
    this.FbN = ((ImageView)paramView2.findViewById(2131299451));
    this.EqV = ((TextView)paramView2.findViewById(2131299455));
    this.FbO = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    aj.faD();
    this.FbP = ((r.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(2131166972) * 4 - paramContext.getResources().getDimensionPixelSize(2131165501) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.FbP + paramContext.getResources().getDimensionPixelSize(2131166972) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.FbI = new c(paramContext, paramList, paramBoolean, parama1);
    fkx();
    paramDynamicGridView.setAdapter(this.FbI);
    paramDynamicGridView.setOnDragListener(new DynamicGridView.e()
    {
      public final void aai(int paramAnonymousInt)
      {
        AppMethodBeat.i(100280);
        Log.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramAnonymousInt)));
        if (Build.VERSION.SDK_INT >= 21)
        {
          e.this.FbL = paramDynamicGridView.getElevation();
          paramDynamicGridView.setElevation(100.0F);
        }
        for (;;)
        {
          Object localObject = e.this;
          ((e)localObject).FbM.setVisibility(0);
          localObject = ObjectAnimator.ofFloat(((e)localObject).FbM, "translationY", new float[] { ((e)localObject).FbM.getHeight(), 0.0F });
          ((ObjectAnimator)localObject).setDuration(200L);
          ((ObjectAnimator)localObject).start();
          e.a(e.this);
          AppMethodBeat.o(100280);
          return;
          paramDynamicGridView.bringToFront();
        }
      }
      
      public final void aaj(int paramAnonymousInt)
      {
        AppMethodBeat.i(100281);
        Log.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramAnonymousInt)));
        c localc = e.this.FbI;
        Object localObject = localc.getItem(paramAnonymousInt);
        localc.mItems.remove(localObject);
        localc.Fbz.remove(localObject);
        localc.notifyDataSetChanged();
        if (localc.FbE != null)
        {
          int i = localc.FbA;
          localc.FbE.removeItem(paramAnonymousInt - i);
        }
        AppMethodBeat.o(100281);
      }
      
      public final void fky()
      {
        AppMethodBeat.i(100283);
        e locale = e.this;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.FbM, "translationY", new float[] { 0.0F, locale.FbM.getHeight() });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.addListener(new e.8(locale));
        localObjectAnimator.start();
        e.this.FbI.fkv();
        AppMethodBeat.o(100283);
      }
      
      public final void n(Rect paramAnonymousRect)
      {
        AppMethodBeat.i(100282);
        if (o(paramAnonymousRect))
        {
          paramAnonymousRect = e.this;
          paramAnonymousRect.FbM.setBackgroundColor(Color.parseColor("#ce3c39"));
          paramAnonymousRect.FbN.setImageResource(2131691516);
          paramAnonymousRect.EqV.setText("松手即可删除");
          AppMethodBeat.o(100282);
          return;
        }
        e.b(e.this);
        AppMethodBeat.o(100282);
      }
      
      public final boolean o(Rect paramAnonymousRect)
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
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (e.this.FbK != null)
        {
          if (paramAnonymousView.getTag() == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100285);
            return;
          }
          paramAnonymousInt = ((Integer)paramAnonymousView.getTag()).intValue();
          Log.i("DynamicGrid", "click ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 2147483647)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100285);
            return;
          }
          e.this.FbK.Lc(paramAnonymousInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100285);
      }
    });
    paramDynamicGridView.setOnDropListener(new DynamicGridView.f()
    {
      public final void fkz()
      {
        AppMethodBeat.i(100286);
        DynamicGridView localDynamicGridView = paramDynamicGridView;
        localDynamicGridView.rIC = false;
        localDynamicGridView.requestDisallowInterceptTouchEvent(false);
        if ((DynamicGridView.fkF()) && (localDynamicGridView.Fcm)) {
          localDynamicGridView.vE(true);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramDynamicGridView.setElevation(e.this.FbL);
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
        e.this.aah(paramList.size());
        AppMethodBeat.o(100287);
        return true;
      }
    });
    aj.faD();
    if (r.getScreenWidth() == 0) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100288);
          e.this.aah(paramList.size());
          e.this.FbI.notifyDataSetChanged();
          AppMethodBeat.o(100288);
        }
      }, 50L);
    }
    AppMethodBeat.o(100293);
  }
  
  private void fkx()
  {
    AppMethodBeat.i(100295);
    if ((MMApplicationContext.getDefaultPreference().getBoolean("key_show_tips", true)) && (this.FbI.fkw() > 1))
    {
      this.ARQ.setVisibility(0);
      this.EHg = ((ImageView)this.ARQ.findViewById(2131308134));
      this.EHg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100289);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          e.a(e.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100289);
        }
      });
      AppMethodBeat.o(100295);
      return;
    }
    this.ARQ.setVisibility(8);
    AppMethodBeat.o(100295);
  }
  
  public final void aah(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(100294);
    aj.faD();
    this.FbP = ((r.getScreenWidth() - this.context.getResources().getDimensionPixelSize(2131166972) * 4 - this.context.getResources().getDimensionPixelSize(2131165501) * 2) / 3);
    this.FbJ.setColumnWidth(this.FbP + this.context.getResources().getDimensionPixelSize(2131166972) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.FbJ.getLayoutParams();
    aj.faD();
    Log.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(r.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.FbO.getHeight();
      int k = this.FbP;
      int m = this.context.getResources().getDimensionPixelSize(2131166972);
      int n = localMarginLayoutParams.rightMargin;
      float f = BitmapUtil.getDefaultDisplayMetrics().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.FbJ.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(100294);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(100297);
    if ((this.FbJ != null) && (this.FbJ.getAdapter() == null)) {
      ((c)this.FbJ.getAdapter()).Eva = true;
    }
    AppMethodBeat.o(100297);
  }
  
  public final View getView()
  {
    return this.FbJ;
  }
  
  public final void setImageClick(z.a parama)
  {
    this.FbK = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.FbH = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(100296);
    if (this.FbI != null)
    {
      this.FbI.hl(paramList);
      fkx();
    }
    AppMethodBeat.o(100296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */