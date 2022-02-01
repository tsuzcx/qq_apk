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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bf.b;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

@com.tencent.mm.ui.base.a(35)
public class TranslationResultUI
  extends MMActivity
{
  private Bitmap CMJ;
  private MMGestureGallery CMM;
  private String COH;
  private fx COI;
  private a COJ;
  private View COK;
  private TextView COL;
  private Rect COM;
  private String aesKey;
  private String fileId;
  private View gvQ;
  private AnimationLayout jUD;
  private boolean jUE;
  private ImageView jUG;
  private MultiTouchImageView lTJ;
  private long msgId;
  private float scaleX;
  private float scaleY;
  private int source;
  private float translationX;
  private float translationY;
  
  private void bms()
  {
    AppMethodBeat.i(120942);
    if (this.jUE)
    {
      AppMethodBeat.o(120942);
      return;
    }
    this.jUE = true;
    Log.i("MicroMsg.TranslationResultUI", "runExitAnimation, thumbRect %s", new Object[] { this.COM });
    this.jUD.a(this.jUG, this.gvQ, new ViewAnimHelper.ViewInfo(this.COM), new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
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
        if (TranslationResultUI.i(TranslationResultUI.this) != null)
        {
          if (TranslationResultUI.i(TranslationResultUI.this).getScale() > 1.0F) {
            TranslationResultUI.i(TranslationResultUI.this).gKy();
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
    if (this.COM != null)
    {
      bms();
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
    return 2131495070;
  }
  
  public void initView()
  {
    AppMethodBeat.i(120939);
    this.gvQ = findViewById(2131307160);
    this.COK = findViewById(2131307216);
    this.jUG = ((ImageView)findViewById(2131301854));
    this.jUD = ((AnimationLayout)findViewById(2131296763));
    this.COL = ((TextView)findViewById(2131309406));
    this.COH = getIntent().getStringExtra("original_file_path");
    this.msgId = getIntent().getLongExtra("msg_id", -1L);
    this.source = getIntent().getIntExtra("translate_source", 0);
    this.COM = ((Rect)getIntent().getParcelableExtra("thumb_location"));
    this.fileId = getIntent().getStringExtra("fileid");
    this.aesKey = getIntent().getStringExtra("aeskey");
    Log.i("MicroMsg.TranslationResultUI", "file path %s", new Object[] { this.COH });
    if (!s.YS(this.COH)) {
      Log.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
    }
    Object localObject1 = findViewById(2131307210);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).bottomMargin += ao.aD(this);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    getSupportActionBar().hide();
    getController().p(this, getResources().getColor(2131101287));
    getController().setNavigationbarColor(getResources().getColor(2131101287));
    this.CMM = ((MMGestureGallery)findViewById(2131309410));
    this.COJ = new a((byte)0);
    this.CMM.setAdapter(this.COJ);
    this.CMM.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void bmt()
      {
        AppMethodBeat.i(120929);
        TranslationResultUI.a(TranslationResultUI.this);
        AppMethodBeat.o(120929);
      }
    });
    this.COI = ((e)g.ah(e.class)).getTranslationResult(this.COH);
    if (this.COI != null)
    {
      if (this.CMJ == null) {
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
        if (!Util.isNullOrNil(this.COI.field_brand))
        {
          this.COL.setText(this.COI.field_brand);
          this.COL.setVisibility(0);
        }
        this.COK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(120932);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/TranslationResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = new ep();
            paramAnonymousView.ejA = 7L;
            paramAnonymousView.eDV = TranslationResultUI.e(TranslationResultUI.this);
            paramAnonymousView.rK(TranslationResultUI.f(TranslationResultUI.this));
            paramAnonymousView.rL(TranslationResultUI.g(TranslationResultUI.this));
            paramAnonymousView.bfK();
            TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.b(TranslationResultUI.this).field_resultFile);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/TranslationResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120932);
          }
        });
        this.COK.setVisibility(0);
        this.CMM.setGalleryScaleListener(new MMGestureGallery.b()
        {
          public final void S(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
          
          public final void T(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
        });
        localObject1 = ((l)g.af(l.class)).eiy().Hb(this.msgId);
        if (this.msgId != -1L)
        {
          localObject2 = new bf();
          ((bf)localObject2).dEo.dCM = ((ca)localObject1);
          EventCenter.instance.publish((IEvent)localObject2);
          this.COM = new Rect();
          this.COM.left = ((bf)localObject2).dEp.dEq;
          this.COM.top = ((bf)localObject2).dEp.dEr;
          this.COM.right = (((bf)localObject2).dEp.dEs + this.COM.left);
          this.COM.bottom = (((bf)localObject2).dEp.dEt + this.COM.top);
        }
        AppMethodBeat.o(120939);
        return;
        this.COJ.bitmap = this.CMJ;
        this.COJ.notifyDataSetChanged();
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
    this.CMJ = null;
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
        TranslationResultUI.i(TranslationResultUI.this).gKy();
      }
      if (this.bitmap != null)
      {
        TranslationResultUI.i(TranslationResultUI.this).setImageBitmap(this.bitmap);
        TranslationResultUI.i(TranslationResultUI.this).cN(this.bitmap.getWidth(), this.bitmap.getHeight());
      }
      paramView = TranslationResultUI.i(TranslationResultUI.this);
      AppMethodBeat.o(120937);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.TranslationResultUI
 * JD-Core Version:    0.7.0.1
 */