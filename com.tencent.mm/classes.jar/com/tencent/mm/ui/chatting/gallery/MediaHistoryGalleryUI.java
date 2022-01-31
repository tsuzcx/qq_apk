package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.a.a;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.e.a.c;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private RecyclerView adt;
  private long eCX;
  private int eez;
  private String ejr;
  private TextView ejt;
  private long fAA;
  private ProgressDialog kFY;
  private boolean kGk;
  private int kGl;
  private TextView mBX;
  private boolean mBY;
  private int mBZ;
  private com.tencent.matrix.trace.e.b mCa;
  private long zDF;
  private View zKO;
  private View zKQ;
  private View zKR;
  private View zKS;
  private View zKT;
  private a.a zNS;
  private boolean zNT;
  private boolean zNU;
  private boolean zNV;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(32417);
    this.mBY = false;
    this.mBZ = -1;
    this.kGk = true;
    this.eCX = 0L;
    this.fAA = 0L;
    this.mCa = new MediaHistoryGalleryUI.1(this);
    AppMethodBeat.o(32417);
  }
  
  private void A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(32437);
    ab.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(2131301086);
      }
      this.kFY = p.b(this, str, true, null);
      AppMethodBeat.o(32437);
      return;
    }
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      this.kFY.dismiss();
      this.kFY = null;
    }
    AppMethodBeat.o(32437);
  }
  
  private void Qn(int paramInt)
  {
    AppMethodBeat.i(32436);
    if ((this.zNS.byp()) && (paramInt > 0))
    {
      this.zKQ.setEnabled(true);
      this.zKR.setEnabled(true);
      this.zKS.setEnabled(true);
      this.zKT.setEnabled(true);
      AppMethodBeat.o(32436);
      return;
    }
    this.zKQ.setEnabled(false);
    this.zKR.setEnabled(false);
    this.zKS.setEnabled(false);
    this.zKT.setEnabled(false);
    AppMethodBeat.o(32436);
  }
  
  public final void PO(int paramInt)
  {
    AppMethodBeat.i(32435);
    byi();
    A(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131300314;
    }
    if (this.zNV) {
      h.a(this, i, 2131297087, true, null);
    }
    this.zNV = false;
    AppMethodBeat.o(32435);
  }
  
  public final void byh()
  {
    AppMethodBeat.i(32430);
    this.zNS.byh();
    setMMTitle(getString(2131300316, new Object[] { Integer.valueOf(this.zNS.dJK()) }));
    this.zKO.setVisibility(0);
    this.zKO.startAnimation(AnimationUtils.loadAnimation(this, 2131034230));
    Qn(this.zNS.dJK());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131300277), new MediaHistoryGalleryUI.5(this));
    AppMethodBeat.o(32430);
  }
  
  public final void byi()
  {
    AppMethodBeat.i(32431);
    this.zNS.byi();
    setMMTitle(this.zNS.apc());
    this.zKO.setVisibility(8);
    this.zKO.startAnimation(AnimationUtils.loadAnimation(this, 2131034228));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131300278), new MediaHistoryGalleryUI.6(this));
    AppMethodBeat.o(32431);
  }
  
  public final void dJL()
  {
    AppMethodBeat.i(32433);
    byi();
    this.zNV = false;
    A(false, "");
    AppMethodBeat.o(32433);
  }
  
  public final void dJM()
  {
    AppMethodBeat.i(32432);
    this.zNV = true;
    A(true, getString(2131300723));
    AppMethodBeat.o(32432);
  }
  
  public final void dJN()
  {
    AppMethodBeat.i(32434);
    byi();
    this.zNV = false;
    A(false, "");
    String str = e.esr;
    Toast.makeText(this, getString(2131298289, new Object[] { str.substring(str.indexOf("tencent/MicroMsg")) }), 1).show();
    AppMethodBeat.o(32434);
  }
  
  public final boolean dJO()
  {
    return this.zNV;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(32425);
    View localView = this.adt.getChildAt(paramInt);
    AppMethodBeat.o(32425);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2130970131;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(32423);
    if (paramBoolean)
    {
      A(true, null);
      AppMethodBeat.o(32423);
      return;
    }
    this.kGl = ((GridLayoutManager)this.adt.getLayoutManager()).iv();
    AppMethodBeat.o(32423);
  }
  
  public void initView()
  {
    AppMethodBeat.i(32428);
    super.initView();
    this.zKO = findViewById(2131825105);
    this.zKR = findViewById(2131824060);
    this.zKT = findViewById(2131822840);
    this.zKS = findViewById(2131825107);
    this.zKQ = findViewById(2131825106);
    this.zKQ.setTag(Integer.valueOf(1));
    this.zKR.setTag(Integer.valueOf(0));
    this.zKS.setTag(Integer.valueOf(3));
    this.zKT.setTag(Integer.valueOf(2));
    this.zKQ.setOnClickListener(this);
    this.zKR.setOnClickListener(this);
    this.zKS.setOnClickListener(this);
    this.zKT.setOnClickListener(this);
    this.mBX = ((TextView)findViewById(2131824062));
    this.ejt = ((TextView)findViewById(2131821515));
    this.adt = ((RecyclerView)findViewById(2131821516));
    this.adt.setBackgroundColor(getResources().getColor(2131689665));
    findViewById(2131821514).setBackgroundColor(getResources().getColor(2131689665));
    this.adt.setLayoutManager(this.zNS.bgA());
    this.adt.a(this.zNS.dR(this));
    this.adt.setAdapter(this.zNS.bi(this.ejr, this.zDF));
    this.adt.setHasFixedSize(true);
    this.adt.setOnScrollListener(new MediaHistoryGalleryUI.2(this));
    this.adt.a(new MediaHistoryGalleryUI.3(this));
    setMMTitle(this.zNS.apc());
    setBackBtn(new MediaHistoryGalleryUI.4(this));
    AppMethodBeat.o(32428);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(32429);
    super.onBackPressed();
    ab.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.zNV)
    {
      this.zNS.dJL();
      AppMethodBeat.o(32429);
      return;
    }
    finish();
    AppMethodBeat.o(32429);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(32427);
    this.zNS.wc(((Integer)paramView.getTag()).intValue());
    AppMethodBeat.o(32427);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32418);
    f.m(this);
    super.onCreate(paramBundle);
    this.mBY = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.zNT = bool;
      this.ejr = paramBundle.getStringExtra("kintent_talker");
      this.mBZ = paramBundle.getIntExtra("kintent_image_index", -1);
      this.zNU = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.zDF = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.zJE);; paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.zJE))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(2131689915));
      setNavigationbarColor(getContext().getResources().getColor(2131689915));
      initView();
      this.zNS.v(true, this.mBZ);
      f.n(this);
      AppMethodBeat.o(32418);
      return;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32421);
    super.onDestroy();
    this.zNS.onDetach();
    AppMethodBeat.o(32421);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(32420);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.eez);
    this.eez = 0;
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localc != null) {
        localc.b(this.mCa);
      }
    }
    if (bo.aox() > this.fAA) {}
    for (long l = bo.aox() - this.fAA;; l = 1L)
    {
      this.fAA = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.eCX, this.fAA);
      this.eCX = 0L;
      this.fAA = 0L;
      AppMethodBeat.o(32420);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(32419);
    this.fAA = bo.aox();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localc != null) {
        localc.a(this.mCa);
      }
    }
    super.onResume();
    this.zNS.onResume();
    if (this.mBY)
    {
      if (!this.zNS.byp()) {
        break label107;
      }
      byh();
    }
    for (;;)
    {
      this.mBY = false;
      AppMethodBeat.o(32419);
      return;
      label107:
      byi();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(32424);
    ab.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.mBZ) });
    if (paramBoolean)
    {
      A(false, null);
      this.adt.getAdapter().ajb.notifyChanged();
      int i;
      if (this.mBZ > 0)
      {
        if (this.mBZ % 4 == 0) {
          this.mBZ += 1;
        }
        i = this.adt.getAdapter().getItemCount();
        this.adt.bJ(Math.min(i - 1, this.mBZ));
      }
      while (paramInt <= 0)
      {
        this.ejt.setVisibility(0);
        this.adt.setVisibility(8);
        this.ejt.setText(getString(2131298288));
        AppMethodBeat.o(32424);
        return;
        i = this.adt.getAdapter().getItemCount();
        this.adt.bJ(i - 1);
      }
      this.ejt.setVisibility(8);
      this.adt.setVisibility(0);
      AppMethodBeat.o(32424);
      return;
    }
    if (this.adt.jd())
    {
      ab.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(32424);
      return;
    }
    if (paramInt > 0)
    {
      this.adt.getAdapter().ap(0, paramInt);
      this.adt.getAdapter().an(paramInt, this.kGl + paramInt);
      AppMethodBeat.o(32424);
      return;
    }
    this.adt.getAdapter().bR(0);
    AppMethodBeat.o(32424);
  }
  
  public final void wa(int paramInt)
  {
    AppMethodBeat.i(32426);
    setMMTitle(getString(2131300316, new Object[] { Integer.valueOf(paramInt) }));
    Qn(paramInt);
    AppMethodBeat.o(32426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */