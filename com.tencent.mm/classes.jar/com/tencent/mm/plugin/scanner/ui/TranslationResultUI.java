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
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bk;
import com.tencent.mm.f.a.bk.b;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.al.a.a;
import com.tencent.mm.plugin.al.a.b;
import com.tencent.mm.plugin.al.a.d;
import com.tencent.mm.plugin.al.a.e;
import com.tencent.mm.plugin.al.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

@com.tencent.mm.ui.base.a(35)
public class TranslationResultUI
  extends MMActivity
{
  private float GB;
  private float GC;
  private Bitmap ISj;
  private MMGestureGallery ISm;
  private String IUj;
  private ge IUk;
  private a IUl;
  private View IUm;
  private TextView IUn;
  private Rect IUo;
  private String aesKey;
  private String fileId;
  private View jac;
  private AnimationLayout mLQ;
  private boolean mLR;
  private ImageView mLT;
  private long msgId;
  private MultiTouchImageView oQr;
  private float scaleX;
  private float scaleY;
  private int source;
  
  private void bwA()
  {
    AppMethodBeat.i(120942);
    if (this.mLR)
    {
      AppMethodBeat.o(120942);
      return;
    }
    this.mLR = true;
    Log.i("MicroMsg.TranslationResultUI", "runExitAnimation, thumbRect %s", new Object[] { this.IUo });
    this.mLQ.a(this.mLT, this.jac, new ViewAnimHelper.ViewInfo(this.IUo), new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120935);
        TranslationResultUI.this.finish();
        paramAnonymousAnimator = TranslationResultUI.this;
        int i = a.a.anim_not_change;
        paramAnonymousAnimator.overridePendingTransition(i, i);
        AppMethodBeat.o(120935);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120934);
        if (TranslationResultUI.i(TranslationResultUI.this) != null)
        {
          if (TranslationResultUI.i(TranslationResultUI.this).getScale() > 1.0F) {
            TranslationResultUI.i(TranslationResultUI.this).hJx();
          }
          TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.i(TranslationResultUI.this).getTranslationX());
          TranslationResultUI.b(TranslationResultUI.this, TranslationResultUI.i(TranslationResultUI.this).getTranslationY());
          TranslationResultUI.c(TranslationResultUI.this, TranslationResultUI.i(TranslationResultUI.this).getScaleX());
          TranslationResultUI.d(TranslationResultUI.this, TranslationResultUI.i(TranslationResultUI.this).getScaleY());
        }
        AppMethodBeat.o(120934);
      }
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(120936);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (TranslationResultUI.i(TranslationResultUI.this) != null)
        {
          TranslationResultUI.i(TranslationResultUI.this).setTranslationX(TranslationResultUI.l(TranslationResultUI.this) * (1.0F - f));
          TranslationResultUI.i(TranslationResultUI.this).setTranslationY(TranslationResultUI.m(TranslationResultUI.this) * (1.0F - f));
          TranslationResultUI.i(TranslationResultUI.this).setScaleX((1.0F - f) * TranslationResultUI.n(TranslationResultUI.this) + f);
          TranslationResultUI.i(TranslationResultUI.this).setScaleY(f + (1.0F - f) * TranslationResultUI.o(TranslationResultUI.this));
        }
        AppMethodBeat.o(120936);
      }
    });
    AppMethodBeat.o(120942);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120941);
    if (this.IUo != null)
    {
      bwA();
      AppMethodBeat.o(120941);
      return;
    }
    finish();
    int i = a.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(120941);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return a.e.image_translation_result;
  }
  
  public void initView()
  {
    AppMethodBeat.i(120939);
    this.jac = findViewById(a.d.root_container);
    this.IUm = findViewById(a.d.save_translate_btn);
    this.mLT = ((ImageView)findViewById(a.d.gallery_bg));
    this.mLQ = ((AnimationLayout)findViewById(a.d.animation_layout));
    this.IUn = ((TextView)findViewById(a.d.translate_manufacture));
    this.IUj = getIntent().getStringExtra("original_file_path");
    this.msgId = getIntent().getLongExtra("msg_id", -1L);
    this.source = getIntent().getIntExtra("translate_source", 0);
    this.IUo = ((Rect)getIntent().getParcelableExtra("thumb_location"));
    this.fileId = getIntent().getStringExtra("fileid");
    this.aesKey = getIntent().getStringExtra("aeskey");
    Log.i("MicroMsg.TranslationResultUI", "file path %s", new Object[] { this.IUj });
    if (!u.agG(this.IUj)) {
      Log.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
    }
    Object localObject1 = findViewById(a.d.save_container);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).bottomMargin += ar.aB(this);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    getSupportActionBar().hide();
    getController().q(this, getResources().getColor(a.b.transparent));
    getController().setNavigationbarColor(getResources().getColor(a.b.transparent));
    this.ISm = ((MMGestureGallery)findViewById(a.d.translation_gallery));
    this.IUl = new a((byte)0);
    this.ISm.setAdapter(this.IUl);
    this.ISm.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void bwB()
      {
        AppMethodBeat.i(120929);
        TranslationResultUI.a(TranslationResultUI.this);
        AppMethodBeat.o(120929);
      }
    });
    this.IUk = ((f)h.ag(f.class)).getTranslationResult(this.IUj);
    if (this.IUk != null)
    {
      if (this.ISj == null) {
        ThreadPool.postAtFront(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120931);
            TranslationResultUI.a(TranslationResultUI.this, BitmapUtil.decodeFile(TranslationResultUI.b(TranslationResultUI.this).field_resultFile, null));
            if (TranslationResultUI.c(TranslationResultUI.this) != null) {
              MMHandlerThread.postToMainThread(new Runnable()
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
        if (!Util.isNullOrNil(this.IUk.field_brand))
        {
          this.IUn.setText(this.IUk.field_brand);
          this.IUn.setVisibility(0);
        }
        this.IUm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(120932);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/TranslationResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new fo();
            paramAnonymousView.gef = 7L;
            paramAnonymousView.gBe = TranslationResultUI.e(TranslationResultUI.this);
            paramAnonymousView.uU(TranslationResultUI.f(TranslationResultUI.this));
            paramAnonymousView.uV(TranslationResultUI.g(TranslationResultUI.this));
            paramAnonymousView.bpa();
            TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.b(TranslationResultUI.this).field_resultFile);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/TranslationResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120932);
          }
        });
        this.IUm.setVisibility(0);
        this.ISm.setGalleryScaleListener(new MMGestureGallery.b()
        {
          public final void U(float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            float f1 = 1.0F;
            AppMethodBeat.i(120933);
            float f2 = 1.0F - paramAnonymousFloat2 / TranslationResultUI.h(TranslationResultUI.this).getHeight();
            if (f2 > 1.0F)
            {
              Log.d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
              if (TranslationResultUI.i(TranslationResultUI.this) == null) {
                break label224;
              }
              if ((paramAnonymousFloat1 != 0.0F) || (paramAnonymousFloat2 != 0.0F)) {
                break label209;
              }
              TranslationResultUI.j(TranslationResultUI.this).setVisibility(0);
            }
            for (;;)
            {
              TranslationResultUI.i(TranslationResultUI.this).setPivotX(TranslationResultUI.h(TranslationResultUI.this).getWidth() / 2);
              TranslationResultUI.i(TranslationResultUI.this).setPivotY(TranslationResultUI.h(TranslationResultUI.this).getHeight() / 2);
              TranslationResultUI.i(TranslationResultUI.this).setScaleX(f1);
              TranslationResultUI.i(TranslationResultUI.this).setScaleY(f1);
              TranslationResultUI.i(TranslationResultUI.this).setTranslationX(paramAnonymousFloat1);
              TranslationResultUI.i(TranslationResultUI.this).setTranslationY(paramAnonymousFloat2);
              TranslationResultUI.k(TranslationResultUI.this).setAlpha(f1);
              AppMethodBeat.o(120933);
              return;
              f1 = f2;
              break;
              label209:
              TranslationResultUI.j(TranslationResultUI.this).setVisibility(8);
            }
            label224:
            Log.d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
            AppMethodBeat.o(120933);
          }
          
          public final void V(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
        });
        localObject1 = ((n)h.ae(n.class)).eSe().Oq(this.msgId);
        if (this.msgId != -1L)
        {
          localObject2 = new bk();
          ((bk)localObject2).fxc.fvt = ((ca)localObject1);
          EventCenter.instance.publish((IEvent)localObject2);
          this.IUo = new Rect();
          this.IUo.left = ((bk)localObject2).fxd.fxe;
          this.IUo.top = ((bk)localObject2).fxd.fxf;
          this.IUo.right = (((bk)localObject2).fxd.fxg + this.IUo.left);
          this.IUo.bottom = (((bk)localObject2).fxd.fxh + this.IUo.top);
        }
        AppMethodBeat.o(120939);
        return;
        this.IUl.bitmap = this.ISj;
        this.IUl.notifyDataSetChanged();
      }
    }
    Log.e("MicroMsg.TranslationResultUI", "translation result not found!");
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
    this.ISj = null;
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
      if (TranslationResultUI.i(TranslationResultUI.this) == null)
      {
        TranslationResultUI.a(TranslationResultUI.this, new MultiTouchImageView(TranslationResultUI.this, 0, 0, (byte)0));
        TranslationResultUI.i(TranslationResultUI.this).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        TranslationResultUI.i(TranslationResultUI.this).hJx();
      }
      if (this.bitmap != null)
      {
        TranslationResultUI.i(TranslationResultUI.this).setImageBitmap(this.bitmap);
        TranslationResultUI.i(TranslationResultUI.this).di(this.bitmap.getWidth(), this.bitmap.getHeight());
      }
      paramView = TranslationResultUI.i(TranslationResultUI.this);
      AppMethodBeat.o(120937);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.TranslationResultUI
 * JD-Core Version:    0.7.0.1
 */