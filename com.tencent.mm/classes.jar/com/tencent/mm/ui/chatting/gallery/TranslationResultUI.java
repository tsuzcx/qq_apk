package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.b;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.scanner.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.MMGestureGallery;

@com.tencent.mm.ui.base.a(35)
public class TranslationResultUI
  extends MMActivity
{
  private long cpO;
  private String cqq;
  private int fgQ;
  private int fgR;
  private View kgr;
  private ImageView mBi;
  private MultiTouchImageView nhO;
  private Bitmap qAJ;
  private MMGestureGallery qAN;
  private boolean qMo;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  private String zOf;
  private eg zOg;
  private TranslationResultUI.a zOh;
  private View zOi;
  private int zOj;
  private int zOk;
  private ValueAnimator zOl;
  
  private void dLa()
  {
    AppMethodBeat.i(138658);
    if (this.qMo)
    {
      AppMethodBeat.o(138658);
      return;
    }
    this.qMo = true;
    ab.i("MicroMsg.TranslationResultUI", "runExitAnimation");
    this.fgR = 0;
    this.fgQ = 0;
    this.zOj = (this.qAN.getWidth() / 2);
    this.zOk = (this.qAN.getHeight() / 2);
    bi localbi = ((j)g.E(j.class)).bPQ().kB(this.cpO);
    av localav = new av();
    localav.coh.cmQ = localbi;
    com.tencent.mm.sdk.b.a.ymk.l(localav);
    this.fgR = localav.coi.col;
    this.fgQ = localav.coi.com;
    this.zOj = localav.coi.coj;
    this.zOk = localav.coi.cok;
    if ((this.zOj == 0) && (this.zOk == 0))
    {
      this.zOj = (this.qAN.getWidth() / 2);
      this.zOk = (this.qAN.getHeight() / 2);
    }
    ab.i("MicroMsg.TranslationResultUI", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.zOj), Integer.valueOf(this.zOk), Integer.valueOf(this.fgR), Integer.valueOf(this.fgQ) });
    this.zOl.start();
    AppMethodBeat.o(138658);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130969903;
  }
  
  public void initView()
  {
    AppMethodBeat.i(138654);
    this.kgr = findViewById(2131823717);
    this.zOi = ((ViewStub)findViewById(2131825142)).inflate();
    this.mBi = ((ImageView)findViewById(2131822135));
    this.zOf = getIntent().getStringExtra("original_file_path");
    this.cpO = getIntent().getLongExtra("msg_id", -1L);
    ab.i("MicroMsg.TranslationResultUI", "file path %s", new Object[] { this.zOf });
    if (com.tencent.mm.vfs.e.cN(this.zOf))
    {
      this.cqq = ag.cE(this.zOf + com.tencent.mm.vfs.e.avJ(this.zOf));
      ab.i("MicroMsg.TranslationResultUI", "md5 %s", new Object[] { this.cqq });
      View localView = findViewById(2131825141);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin += af.fx(this);
      localView.setLayoutParams(localLayoutParams);
      getSupportActionBar().hide();
      getController().n(this, getResources().getColor(2131690605));
      getController().setNavigationbarColor(getResources().getColor(2131690605));
      this.qAN = ((MMGestureGallery)findViewById(2131825140));
      this.zOh = new TranslationResultUI.a(this, (byte)0);
      this.qAN.setAdapter(this.zOh);
      this.qAN.setSingleClickOverListener(new TranslationResultUI.1(this));
      this.zOg = com.tencent.mm.plugin.scanner.e.chX().cic().Yz(this.cqq);
      if (this.zOg == null) {
        break label486;
      }
      if (this.qAJ != null) {
        break label465;
      }
      d.g(new TranslationResultUI.2(this), "decode_translate_result_img");
    }
    for (;;)
    {
      this.zOi.findViewById(2131825097).setOnClickListener(new TranslationResultUI.3(this));
      this.zOi.setVisibility(0);
      this.qAN.setGalleryScaleListener(new TranslationResultUI.4(this));
      this.zOl = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zOl.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
      this.zOl.addUpdateListener(new TranslationResultUI.5(this));
      this.zOl.addListener(new TranslationResultUI.6(this));
      AppMethodBeat.o(138654);
      return;
      ab.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
      break;
      label465:
      this.zOh.bitmap = this.qAJ;
      this.zOh.notifyDataSetChanged();
    }
    label486:
    ab.e("MicroMsg.TranslationResultUI", "translation result not found!");
    dLa();
    AppMethodBeat.o(138654);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(138653);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(138653);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(138660);
    super.onDestroy();
    this.qAJ = null;
    AppMethodBeat.o(138660);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138659);
    if (paramInt == 4)
    {
      dLa();
      AppMethodBeat.o(138659);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(138659);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(138655);
    super.onResume();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    View localView = getWindow().getDecorView();
    int i = 1796;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5892;
    }
    localView.setSystemUiVisibility(i);
    AppMethodBeat.o(138655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI
 * JD-Core Version:    0.7.0.1
 */