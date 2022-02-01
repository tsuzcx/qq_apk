package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.az.b;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.vfs.i;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

@com.tencent.mm.ui.base.a(35)
public class TranslationResultUI
  extends MMActivity
{
  private View frN;
  private MultiTouchImageView jPH;
  private long msgId;
  private AnimationLayout qMx;
  private boolean qMy;
  private ImageView qdk;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  private Bitmap vUj;
  private MMGestureGallery vUm;
  private String vWh;
  private fb vWi;
  private a vWj;
  private View vWk;
  private Rect vWl;
  
  private void dmI()
  {
    AppMethodBeat.i(120942);
    if (this.qMy)
    {
      AppMethodBeat.o(120942);
      return;
    }
    this.qMy = true;
    ad.i("MicroMsg.TranslationResultUI", "runExitAnimation, thumbRect %s", new Object[] { this.vWl });
    this.qMx.a(this.qdk, this.frN, new ViewAnimHelper.ViewInfo(this.vWl), new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120935);
        TranslationResultUI.this.finish();
        TranslationResultUI.this.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(120935);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120934);
        if (TranslationResultUI.f(TranslationResultUI.this) != null)
        {
          if (TranslationResultUI.f(TranslationResultUI.this).getScale() > 1.0F) {
            TranslationResultUI.f(TranslationResultUI.this).eSz();
          }
          TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.f(TranslationResultUI.this).getTranslationX());
          TranslationResultUI.b(TranslationResultUI.this, TranslationResultUI.f(TranslationResultUI.this).getTranslationY());
          TranslationResultUI.c(TranslationResultUI.this, TranslationResultUI.f(TranslationResultUI.this).getScaleX());
          TranslationResultUI.d(TranslationResultUI.this, TranslationResultUI.f(TranslationResultUI.this).getScaleY());
        }
        AppMethodBeat.o(120934);
      }
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(120936);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (TranslationResultUI.f(TranslationResultUI.this) != null)
        {
          TranslationResultUI.f(TranslationResultUI.this).setTranslationX(TranslationResultUI.i(TranslationResultUI.this) * (1.0F - f));
          TranslationResultUI.f(TranslationResultUI.this).setTranslationY(TranslationResultUI.j(TranslationResultUI.this) * (1.0F - f));
          TranslationResultUI.f(TranslationResultUI.this).setScaleX((1.0F - f) * TranslationResultUI.k(TranslationResultUI.this) + f);
          TranslationResultUI.f(TranslationResultUI.this).setScaleY(f + (1.0F - f) * TranslationResultUI.l(TranslationResultUI.this));
        }
        AppMethodBeat.o(120936);
      }
    });
    AppMethodBeat.o(120942);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120941);
    if (this.vWl != null)
    {
      dmI();
      AppMethodBeat.o(120941);
      return;
    }
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(120941);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131494480;
  }
  
  public void initView()
  {
    AppMethodBeat.i(120939);
    this.frN = findViewById(2131304241);
    this.vWk = findViewById(2131304288);
    this.qdk = ((ImageView)findViewById(2131300336));
    this.qMx = ((AnimationLayout)findViewById(2131296674));
    this.vWh = getIntent().getStringExtra("original_file_path");
    this.msgId = getIntent().getLongExtra("msg_id", -1L);
    this.vWl = ((Rect)getIntent().getParcelableExtra("thumb_location"));
    ad.i("MicroMsg.TranslationResultUI", "file path %s", new Object[] { this.vWh });
    if (!i.eK(this.vWh)) {
      ad.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
    }
    Object localObject1 = findViewById(2131304282);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).bottomMargin += ai.eb(this);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    getSupportActionBar().hide();
    getController().q(this, getResources().getColor(2131101053));
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    this.vUm = ((MMGestureGallery)findViewById(2131306079));
    this.vWj = new a((byte)0);
    this.vUm.setAdapter(this.vWj);
    this.vUm.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aHo()
      {
        AppMethodBeat.i(120929);
        TranslationResultUI.a(TranslationResultUI.this);
        AppMethodBeat.o(120929);
      }
    });
    this.vWi = ((c)g.ad(c.class)).getTranslationResult(this.vWh);
    if (this.vWi != null)
    {
      if (this.vUj == null) {
        com.tencent.mm.sdk.g.b.e(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120931);
            TranslationResultUI.a(TranslationResultUI.this, f.decodeFile(TranslationResultUI.b(TranslationResultUI.this).field_resultFile, null));
            if (TranslationResultUI.c(TranslationResultUI.this) != null) {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(120930);
                  TranslationResultUI.d(TranslationResultUI.this).bitmap = TranslationResultUI.c(TranslationResultUI.this);
                  TranslationResultUI.d(TranslationResultUI.this).notifyDataSetChanged();
                  AppMethodBeat.o(120930);
                }
              });
            }
            AppMethodBeat.o(120931);
          }
        }, "decode_translate_result_img");
      }
      for (;;)
      {
        this.vWk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(120932);
            paramAnonymousView = new ao();
            paramAnonymousView.dFd = 7L;
            paramAnonymousView.aBj();
            TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.b(TranslationResultUI.this).field_resultFile);
            AppMethodBeat.o(120932);
          }
        });
        this.vWk.setVisibility(0);
        this.vUm.setGalleryScaleListener(new MMGestureGallery.b()
        {
          public final void J(float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            float f1 = 1.0F;
            AppMethodBeat.i(120933);
            float f2 = 1.0F - paramAnonymousFloat2 / TranslationResultUI.e(TranslationResultUI.this).getHeight();
            if (f2 > 1.0F)
            {
              ad.d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
              if (TranslationResultUI.f(TranslationResultUI.this) == null) {
                break label224;
              }
              if ((paramAnonymousFloat1 != 0.0F) || (paramAnonymousFloat2 != 0.0F)) {
                break label209;
              }
              TranslationResultUI.g(TranslationResultUI.this).setVisibility(0);
            }
            for (;;)
            {
              TranslationResultUI.f(TranslationResultUI.this).setPivotX(TranslationResultUI.e(TranslationResultUI.this).getWidth() / 2);
              TranslationResultUI.f(TranslationResultUI.this).setPivotY(TranslationResultUI.e(TranslationResultUI.this).getHeight() / 2);
              TranslationResultUI.f(TranslationResultUI.this).setScaleX(f1);
              TranslationResultUI.f(TranslationResultUI.this).setScaleY(f1);
              TranslationResultUI.f(TranslationResultUI.this).setTranslationX(paramAnonymousFloat1);
              TranslationResultUI.f(TranslationResultUI.this).setTranslationY(paramAnonymousFloat2);
              TranslationResultUI.h(TranslationResultUI.this).setAlpha(f1);
              AppMethodBeat.o(120933);
              return;
              f1 = f2;
              break;
              label209:
              TranslationResultUI.g(TranslationResultUI.this).setVisibility(8);
            }
            label224:
            ad.d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
            AppMethodBeat.o(120933);
          }
          
          public final void K(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
        });
        localObject1 = ((k)g.ab(k.class)).cOI().rm(this.msgId);
        if (this.msgId != -1L)
        {
          localObject2 = new az();
          ((az)localObject2).ddf.dbD = ((bl)localObject1);
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          this.vWl = new Rect();
          this.vWl.left = ((az)localObject2).ddg.ddh;
          this.vWl.top = ((az)localObject2).ddg.ddi;
          this.vWl.right = (((az)localObject2).ddg.ddj + this.vWl.left);
          this.vWl.bottom = (((az)localObject2).ddg.ddk + this.vWl.top);
        }
        AppMethodBeat.o(120939);
        return;
        this.vWj.bitmap = this.vUj;
        this.vWj.notifyDataSetChanged();
      }
    }
    ad.e("MicroMsg.TranslationResultUI", "translation result not found!");
    goBack();
    AppMethodBeat.o(120939);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120938);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(120938);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120944);
    super.onDestroy();
    this.vUj = null;
    AppMethodBeat.o(120944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120943);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(120943);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(120943);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(120940);
    super.onResume();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    View localView = getWindow().getDecorView();
    int i = 1796;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5892;
    }
    localView.setSystemUiVisibility(i);
    AppMethodBeat.o(120940);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    Bitmap bitmap;
    
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(120937);
      if (TranslationResultUI.f(TranslationResultUI.this) == null)
      {
        TranslationResultUI.a(TranslationResultUI.this, new MultiTouchImageView(TranslationResultUI.this, 0, 0, (byte)0));
        TranslationResultUI.f(TranslationResultUI.this).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        TranslationResultUI.f(TranslationResultUI.this).eSz();
      }
      if (this.bitmap != null)
      {
        TranslationResultUI.f(TranslationResultUI.this).setImageBitmap(this.bitmap);
        TranslationResultUI.f(TranslationResultUI.this).cH(this.bitmap.getWidth(), this.bitmap.getHeight());
      }
      paramView = TranslationResultUI.f(TranslationResultUI.this);
      AppMethodBeat.o(120937);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.TranslationResultUI
 * JD-Core Version:    0.7.0.1
 */