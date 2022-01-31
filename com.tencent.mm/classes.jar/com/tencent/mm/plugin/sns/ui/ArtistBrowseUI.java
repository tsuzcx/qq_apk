package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.az.n;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private String lCN = "";
  private String oMP = "";
  
  public final void cw(String paramString, int paramInt)
  {
    if (this.oVy != null) {
      this.oVy.aPg();
    }
  }
  
  public final void cx(String paramString, int paramInt) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.oVv.oPw);
      setResult(-1, paramKeyEvent);
      finish();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_gallery_img;
  }
  
  protected final void initView()
  {
    this.lCN = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    com.tencent.mm.az.r.PK();
    this.oMP = n.PH();
    w(false, 2);
    this.oVy = new SnsInfoFlip(this);
    List localList = aj.eI(this.lCN, this.oMP);
    this.oVy.setShowTitle(true);
    this.oVy.a(localList, "", i, this.oVt, this);
    addView(this.oVy);
    setBackBtn(new ArtistBrowseUI.1(this));
    setMMTitle(i.j.sns_ui_setback);
    showOptionMenu(false);
    this.oVt.setCallBack(new ArtistBrowseUI.2(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {
      return;
    }
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.oVv.yw(paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    if (this.oVy != null)
    {
      this.oVy.bIQ();
      this.oVy.onDestroy();
    }
    af.bDC().M(this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.oVy != null) {
      this.oVy.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.oVy != null) {
      this.oVy.aPg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI
 * JD-Core Version:    0.7.0.1
 */