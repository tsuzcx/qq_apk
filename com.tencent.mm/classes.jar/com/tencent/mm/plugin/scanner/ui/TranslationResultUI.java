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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.ba.b;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.scanner.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.s;
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
  private int dbL;
  private View fvu;
  private AnimationLayout iBC;
  private boolean iBD;
  private ImageView iBF;
  private MultiTouchImageView kqu;
  private long msgId;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  private Bitmap xeU;
  private MMGestureGallery xeX;
  private String xgT;
  private ff xgU;
  private a xgV;
  private View xgW;
  private TextView xgX;
  private Rect xgY;
  
  private void aOc()
  {
    AppMethodBeat.i(120942);
    if (this.iBD)
    {
      AppMethodBeat.o(120942);
      return;
    }
    this.iBD = true;
    ac.i("MicroMsg.TranslationResultUI", "runExitAnimation, thumbRect %s", new Object[] { this.xgY });
    this.iBC.a(this.iBF, this.fvu, new ViewAnimHelper.ViewInfo(this.xgY), new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
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
        if (TranslationResultUI.g(TranslationResultUI.this) != null)
        {
          if (TranslationResultUI.g(TranslationResultUI.this).getScale() > 1.0F) {
            TranslationResultUI.g(TranslationResultUI.this).fij();
          }
          TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.g(TranslationResultUI.this).getTranslationX());
          TranslationResultUI.b(TranslationResultUI.this, TranslationResultUI.g(TranslationResultUI.this).getTranslationY());
          TranslationResultUI.c(TranslationResultUI.this, TranslationResultUI.g(TranslationResultUI.this).getScaleX());
          TranslationResultUI.d(TranslationResultUI.this, TranslationResultUI.g(TranslationResultUI.this).getScaleY());
        }
        AppMethodBeat.o(120934);
      }
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(120936);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (TranslationResultUI.g(TranslationResultUI.this) != null)
        {
          TranslationResultUI.g(TranslationResultUI.this).setTranslationX(TranslationResultUI.j(TranslationResultUI.this) * (1.0F - f));
          TranslationResultUI.g(TranslationResultUI.this).setTranslationY(TranslationResultUI.k(TranslationResultUI.this) * (1.0F - f));
          TranslationResultUI.g(TranslationResultUI.this).setScaleX((1.0F - f) * TranslationResultUI.l(TranslationResultUI.this) + f);
          TranslationResultUI.g(TranslationResultUI.this).setScaleY(f + (1.0F - f) * TranslationResultUI.m(TranslationResultUI.this));
        }
        AppMethodBeat.o(120936);
      }
    });
    AppMethodBeat.o(120942);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120941);
    if (this.xgY != null)
    {
      aOc();
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
    this.fvu = findViewById(2131304241);
    this.xgW = findViewById(2131304288);
    this.iBF = ((ImageView)findViewById(2131300336));
    this.iBC = ((AnimationLayout)findViewById(2131296674));
    this.xgX = ((TextView)findViewById(2131308044));
    this.xgT = getIntent().getStringExtra("original_file_path");
    this.msgId = getIntent().getLongExtra("msg_id", -1L);
    this.dbL = getIntent().getIntExtra("translate_source", 0);
    this.xgY = ((Rect)getIntent().getParcelableExtra("thumb_location"));
    ac.i("MicroMsg.TranslationResultUI", "file path %s", new Object[] { this.xgT });
    if (!i.eA(this.xgT)) {
      ac.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
    }
    Object localObject1 = findViewById(2131304282);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).bottomMargin += aj.ej(this);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    getSupportActionBar().hide();
    getController().q(this, getResources().getColor(2131101053));
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    this.xeX = ((MMGestureGallery)findViewById(2131306079));
    this.xgV = new a((byte)0);
    this.xeX.setAdapter(this.xgV);
    this.xeX.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aOd()
      {
        AppMethodBeat.i(120929);
        TranslationResultUI.a(TranslationResultUI.this);
        AppMethodBeat.o(120929);
      }
    });
    this.xgU = ((d)g.ad(d.class)).getTranslationResult(this.xgT);
    if (this.xgU != null)
    {
      if (this.xeU == null) {
        com.tencent.mm.sdk.g.b.e(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120931);
            TranslationResultUI.a(TranslationResultUI.this, f.decodeFile(TranslationResultUI.b(TranslationResultUI.this).field_resultFile, null));
            if (TranslationResultUI.c(TranslationResultUI.this) != null) {
              ap.f(new Runnable()
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
        if (!bs.isNullOrNil(this.xgU.field_brand))
        {
          this.xgX.setText(this.xgU.field_brand);
          this.xgX.setVisibility(0);
        }
        this.xgW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(120932);
            paramAnonymousView = new com.tencent.mm.g.b.a.bo();
            paramAnonymousView.dCQ = 7L;
            paramAnonymousView.dNc = TranslationResultUI.e(TranslationResultUI.this);
            paramAnonymousView.aHZ();
            TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.b(TranslationResultUI.this).field_resultFile);
            AppMethodBeat.o(120932);
          }
        });
        this.xgW.setVisibility(0);
        this.xeX.setGalleryScaleListener(new MMGestureGallery.b()
        {
          public final void M(float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            float f1 = 1.0F;
            AppMethodBeat.i(120933);
            float f2 = 1.0F - paramAnonymousFloat2 / TranslationResultUI.f(TranslationResultUI.this).getHeight();
            if (f2 > 1.0F)
            {
              ac.d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
              if (TranslationResultUI.g(TranslationResultUI.this) == null) {
                break label224;
              }
              if ((paramAnonymousFloat1 != 0.0F) || (paramAnonymousFloat2 != 0.0F)) {
                break label209;
              }
              TranslationResultUI.h(TranslationResultUI.this).setVisibility(0);
            }
            for (;;)
            {
              TranslationResultUI.g(TranslationResultUI.this).setPivotX(TranslationResultUI.f(TranslationResultUI.this).getWidth() / 2);
              TranslationResultUI.g(TranslationResultUI.this).setPivotY(TranslationResultUI.f(TranslationResultUI.this).getHeight() / 2);
              TranslationResultUI.g(TranslationResultUI.this).setScaleX(f1);
              TranslationResultUI.g(TranslationResultUI.this).setScaleY(f1);
              TranslationResultUI.g(TranslationResultUI.this).setTranslationX(paramAnonymousFloat1);
              TranslationResultUI.g(TranslationResultUI.this).setTranslationY(paramAnonymousFloat2);
              TranslationResultUI.i(TranslationResultUI.this).setAlpha(f1);
              AppMethodBeat.o(120933);
              return;
              f1 = f2;
              break;
              label209:
              TranslationResultUI.h(TranslationResultUI.this).setVisibility(8);
            }
            label224:
            ac.d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
            AppMethodBeat.o(120933);
          }
          
          public final void N(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
        });
        localObject1 = ((k)g.ab(k.class)).dcr().vP(this.msgId);
        if (this.msgId != -1L)
        {
          localObject2 = new ba();
          ((ba)localObject2).daD.cZc = ((com.tencent.mm.storage.bo)localObject1);
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          this.xgY = new Rect();
          this.xgY.left = ((ba)localObject2).daE.daF;
          this.xgY.top = ((ba)localObject2).daE.daG;
          this.xgY.right = (((ba)localObject2).daE.daH + this.xgY.left);
          this.xgY.bottom = (((ba)localObject2).daE.daI + this.xgY.top);
        }
        AppMethodBeat.o(120939);
        return;
        this.xgV.bitmap = this.xeU;
        this.xgV.notifyDataSetChanged();
      }
    }
    ac.e("MicroMsg.TranslationResultUI", "translation result not found!");
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
    this.xeU = null;
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
      if (TranslationResultUI.g(TranslationResultUI.this) == null)
      {
        TranslationResultUI.a(TranslationResultUI.this, new MultiTouchImageView(TranslationResultUI.this, 0, 0, (byte)0));
        TranslationResultUI.g(TranslationResultUI.this).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        TranslationResultUI.g(TranslationResultUI.this).fij();
      }
      if (this.bitmap != null)
      {
        TranslationResultUI.g(TranslationResultUI.this).setImageBitmap(this.bitmap);
        TranslationResultUI.g(TranslationResultUI.this).cF(this.bitmap.getWidth(), this.bitmap.getHeight());
      }
      paramView = TranslationResultUI.g(TranslationResultUI.this);
      AppMethodBeat.o(120937);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.TranslationResultUI
 * JD-Core Version:    0.7.0.1
 */