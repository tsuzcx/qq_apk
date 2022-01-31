package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.e.d;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.a.b;
import com.tencent.mm.ui.chatting.d.a.c;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private RecyclerView acI;
  private long dFe = 0L;
  private int dmY;
  private String drJ;
  private TextView drL;
  private long ekk = 0L;
  private TextView khi;
  private ProgressDialog khj;
  private boolean khk = false;
  private int khl = -1;
  private boolean khm = true;
  private com.tencent.matrix.trace.c.a kho = new MediaHistoryGalleryUI.1(this);
  private int khp;
  private long voj;
  private View vuN;
  private View vuP;
  private View vuQ;
  private View vuR;
  private View vuS;
  private a.a vxG;
  private boolean vxH;
  private boolean vxI;
  private boolean vxJ;
  
  private void HG(int paramInt)
  {
    if ((this.vxG.aRY()) && (paramInt > 0))
    {
      this.vuP.setEnabled(true);
      this.vuQ.setEnabled(true);
      this.vuR.setEnabled(true);
      this.vuS.setEnabled(true);
      return;
    }
    this.vuP.setEnabled(false);
    this.vuQ.setEnabled(false);
    this.vuR.setEnabled(false);
    this.vuS.setEnabled(false);
  }
  
  private void s(boolean paramBoolean, String paramString)
  {
    y.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      str = paramString;
      if (paramString == null) {
        str = getString(R.l.loading_tips);
      }
      this.khj = p.b(this, str, true, 0, null);
    }
    while ((this.khj == null) || (!this.khj.isShowing()))
    {
      String str;
      return;
    }
    this.khj.dismiss();
    this.khj = null;
  }
  
  public final void Hh(int paramInt)
  {
    aRP();
    s(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = R.l.gallery_selected_save_err;
    }
    if (this.vxJ) {
      h.a(this, i, R.l.app_tip, true, null);
    }
    this.vxJ = false;
  }
  
  public final void aRO()
  {
    this.vxG.aRO();
    setMMTitle(getString(R.l.gallery_selected_title, new Object[] { Integer.valueOf(this.vxG.cFH()) }));
    this.vuN.setVisibility(0);
    this.vuN.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_up_in));
    HG(this.vxG.cFH());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gallery_grid_cancel_selected_option), new MediaHistoryGalleryUI.5(this));
  }
  
  public final void aRP()
  {
    this.vxG.aRP();
    setMMTitle(this.vxG.VE());
    this.vuN.setVisibility(8);
    this.vuN.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_down_out));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gallery_grid_selected_option), new MediaHistoryGalleryUI.6(this));
  }
  
  public final void cFI()
  {
    aRP();
    this.vxJ = false;
    s(false, "");
  }
  
  public final void cFJ()
  {
    this.vxJ = true;
    s(true, getString(R.l.image_saving_tip));
  }
  
  public final void cFK()
  {
    aRP();
    this.vxJ = false;
    s(false, "");
    String str = e.dzD.substring(e.dzD.indexOf("tencent/MicroMsg"));
    Toast.makeText(this, getString(R.l.chatting_record_saved, new Object[] { str }), 1).show();
  }
  
  public final boolean cFL()
  {
    return this.vxJ;
  }
  
  public final void ga(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s(true, null);
      return;
    }
    this.khp = ((GridLayoutManager)this.acI.getLayoutManager()).ha();
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.acI.getChildAt(paramInt);
  }
  
  protected final int getLayoutId()
  {
    return R.i.media_history_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    this.vuN = findViewById(R.h.more_bottom_root);
    this.vuQ = findViewById(R.h.trans_btn);
    this.vuS = findViewById(R.h.del_btn);
    this.vuR = findViewById(R.h.save_btn);
    this.vuP = findViewById(R.h.fav_btn);
    this.vuP.setTag(Integer.valueOf(1));
    this.vuQ.setTag(Integer.valueOf(0));
    this.vuR.setTag(Integer.valueOf(3));
    this.vuS.setTag(Integer.valueOf(2));
    this.vuP.setOnClickListener(this);
    this.vuQ.setOnClickListener(this);
    this.vuR.setOnClickListener(this);
    this.vuS.setOnClickListener(this);
    this.khi = ((TextView)findViewById(R.h.album_tips_bar));
    this.drL = ((TextView)findViewById(R.h.search_nothing_hint));
    this.acI = ((RecyclerView)findViewById(R.h.history_recycler_view));
    this.acI.setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
    findViewById(R.h.content_history).setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
    this.acI.setLayoutManager(this.vxG.aRV());
    this.acI.a(this.vxG.df(this));
    this.acI.setAdapter(this.vxG.aA(this.drJ, this.voj));
    this.acI.setHasFixedSize(true);
    this.acI.setOnScrollListener(new MediaHistoryGalleryUI.2(this));
    this.acI.a(new MediaHistoryGalleryUI.3(this));
    setMMTitle(this.vxG.VE());
    setBackBtn(new MediaHistoryGalleryUI.4(this));
  }
  
  public final void k(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.khl) });
    if (paramBoolean)
    {
      s(false, null);
      this.acI.getAdapter().agL.notifyChanged();
      int i;
      if (this.khl > 0)
      {
        if (this.khl % 4 == 0) {
          this.khl += 1;
        }
        i = this.acI.getAdapter().getItemCount();
        this.acI.bE(Math.min(i - 1, this.khl));
      }
      while (paramInt <= 0)
      {
        this.drL.setVisibility(0);
        this.acI.setVisibility(8);
        this.drL.setText(getString(R.l.chatting_record_noting_hint));
        return;
        i = this.acI.getAdapter().getItemCount();
        this.acI.bE(i - 1);
      }
      this.drL.setVisibility(8);
      this.acI.setVisibility(0);
      return;
    }
    if (paramInt > 0)
    {
      this.acI.getAdapter().aj(0, paramInt);
      this.acI.getAdapter().ah(paramInt, this.khp + paramInt);
      return;
    }
    this.acI.getAdapter().bL(0);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    y.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.vxJ)
    {
      this.vxG.cFI();
      return;
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    this.vxG.rg(((Integer)paramView.getTag()).intValue());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.khk = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.vxH = bool;
      this.drJ = paramBundle.getStringExtra("kintent_talker");
      this.khl = paramBundle.getIntExtra("kintent_image_index", -1);
      this.vxI = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.voj = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.vtD);; paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.vtD))
    {
      paramBundle.a(this);
      initView();
      this.vxG.l(true, this.khl);
      return;
      bool = false;
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.vxG.onDetach();
  }
  
  protected void onPause()
  {
    super.onPause();
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.dmY);
    this.dmY = 0;
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.b(this.kho);
    if (bk.UX() > this.ekk) {}
    for (long l = bk.UX() - this.ekk;; l = 1L)
    {
      this.ekk = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.dFe, this.ekk);
      this.dFe = 0L;
      this.ekk = 0L;
      return;
    }
  }
  
  protected void onResume()
  {
    this.ekk = bk.UX();
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.a(this.kho);
    super.onResume();
    this.vxG.onResume();
    if (this.khk)
    {
      if (!this.vxG.aRY()) {
        break label71;
      }
      aRO();
    }
    for (;;)
    {
      this.khk = false;
      return;
      label71:
      aRP();
    }
  }
  
  public final void re(int paramInt)
  {
    setMMTitle(getString(R.l.gallery_selected_title, new Object[] { Integer.valueOf(paramInt) }));
    HG(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */