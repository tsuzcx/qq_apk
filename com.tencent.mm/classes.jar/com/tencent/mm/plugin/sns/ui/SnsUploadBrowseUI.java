package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private int oVA = 0;
  private ArrayList<String> piH = new ArrayList();
  private HashMap<Integer, Boolean> piI = new HashMap();
  
  public final void bJR()
  {
    Intent localIntent = new Intent();
    Object localObject = this.oVy.getFlipList();
    if (localObject == null) {
      return;
    }
    this.piH.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = af.getAccSnsTmpPath() + localb.bZK.lsK;
      if (!localb.bZK.lsK.startsWith("pre_temp_extend_pic")) {
        break label168;
      }
      localObject = localb.bZK.lsK.substring(19);
    }
    label168:
    for (;;)
    {
      this.piH.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.piH);
      localIntent.putExtra("sns_update_preview_image_count", this.piI.size());
      this.piI.clear();
      setResult(-1, localIntent);
      finish();
      return;
    }
  }
  
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
      y.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      bJR();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getForceOrientation()
  {
    return 4;
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_browse_img;
  }
  
  protected final void initView()
  {
    String str = bk.aM(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.piH = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.piH == null) {
      return;
    }
    this.oVA = getIntent().getIntExtra("sns_gallery_position", 0);
    this.oVy = new SnsInfoFlip(this);
    this.oVy.setEnableHorLongBmpMode(false);
    this.oVy.setShowTitle(true);
    af.getAccSnsTmpPath();
    List localList = aj.cw(this.piH);
    this.oVy.a(localList, str, this.oVA, this.oVt, this);
    this.oVy.setOnPageSelectListener(new SnsUploadBrowseUI.1(this));
    addView(this.oVy);
    setBackBtn(new SnsUploadBrowseUI.2(this));
    addIconOptionMenu(0, i.j.app_delete, i.e.mm_title_btn_delete_normal, new SnsUploadBrowseUI.3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {}
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI
 * JD-Core Version:    0.7.0.1
 */