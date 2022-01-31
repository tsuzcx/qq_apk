package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.mm.ui.s;

public class FTSSOSMoreWebViewUI
  extends BaseSOSWebViewUI
{
  private View ruT;
  private int ruk;
  
  protected final void aoX()
  {
    super.aoX();
    this.ruT = findViewById(R.h.webview_keyboard_ll);
    cfr().cIy();
    cfr().aWC();
    this.mBP.setVisibility(0);
    cfr().aWA();
    this.ruk = com.tencent.mm.cb.a.fromDPToPix(this, 48);
    cfr().setIconRes(com.tencent.mm.bc.a.b(getType(), this));
    if (aZY() == 24) {
      this.ruT.setVisibility(4);
    }
    findViewById(R.h.root).setOnTouchListener(new FTSSOSMoreWebViewUI.1(this));
    if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsneedkeyboard", false))) {
      this.mController.contentView.postDelayed(new FTSSOSMoreWebViewUI.2(this), 128L);
    }
    af(getResources().getColor(R.e.white), true);
    ImageButton localImageButton = cfr().getClearBtn();
    if (localImageButton != null) {
      localImageButton.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  protected final int aoY()
  {
    if ((d.gF(23)) && (!b.zL())) {
      return getResources().getColor(R.e.white);
    }
    return super.aoY();
  }
  
  public boolean apb()
  {
    cfr().aWC();
    this.ruT.setVisibility(0);
    return super.apb();
  }
  
  protected final void cfn()
  {
    finish();
  }
  
  protected final void cfo()
  {
    super.cfo();
    this.ruT.setVisibility(0);
  }
  
  public String getHint()
  {
    int i = -1;
    if ((getType() == 8) && (this.rtM)) {
      i = R.l.fts_header_timeline_publisher;
    }
    while (i < 0)
    {
      return ae.getContext().getResources().getString(R.l.app_search) + CO(getType());
      switch (getType())
      {
      default: 
        break;
      case 1: 
        i = R.l.search_education_biz_contact;
        break;
      case 8: 
        i = R.l.fts_header_timeline;
        break;
      case 2: 
        i = R.l.search_education_article;
        break;
      case 16: 
        i = R.l.fts_header_poi;
        break;
      case 64: 
        i = R.l.app_brand_entrance;
        break;
      case 256: 
      case 384: 
        i = R.l.fts_header_emoji;
        break;
      case 128: 
        i = R.l.fts_header_emoji_product;
        break;
      case 512: 
        i = R.l.fts_header_music;
        break;
      case 1024: 
        i = R.l.fts_header_novel;
      }
    }
    return ae.getContext().getResources().getString(R.l.search_detail_page_hint, new Object[] { ae.getContext().getResources().getString(i) });
  }
  
  protected final int getLayoutId()
  {
    return R.i.sos_more_webview_ui;
  }
  
  public final void gn(boolean paramBoolean)
  {
    super.gn(paramBoolean);
    if (!paramBoolean)
    {
      this.rts.setPadding(this.ruk, 0, this.rts.getPaddingRight(), 0);
      this.mBP.setVisibility(0);
      cfr().aWA();
    }
    cfr().aWC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI
 * JD-Core Version:    0.7.0.1
 */