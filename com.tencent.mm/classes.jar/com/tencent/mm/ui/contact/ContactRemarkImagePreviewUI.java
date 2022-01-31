package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class ContactRemarkImagePreviewUI
  extends MMActivity
{
  private MMGestureGallery itv;
  private String username;
  private View vKk;
  private String vKl;
  private boolean vKm;
  private boolean vKn;
  private ContactRemarkImagePreviewUI.a vKo;
  
  private void nx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("response_delete", true);
      setResult(-1, localIntent);
    }
    finish();
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_remark_image_preview;
  }
  
  protected final void initView()
  {
    this.vKk = findViewById(R.h.container_ll);
    this.itv = ((MMGestureGallery)findViewById(R.h.gallery));
    setMMTitle(R.l.mod_remark_preview_image_title);
    this.itv.setVerticalFadingEdgeEnabled(false);
    this.itv.setHorizontalFadingEdgeEnabled(false);
    k.bO(this.itv);
    this.vKo = new ContactRemarkImagePreviewUI.a(this);
    this.vKo.imagePath = this.vKl;
    this.itv.setAdapter(this.vKo);
    this.itv.setOnItemClickListener(new ContactRemarkImagePreviewUI.3(this));
    addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new ContactRemarkImagePreviewUI.1(this));
    setBackBtn(new ContactRemarkImagePreviewUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("Contact_User");
    this.vKl = getIntent().getStringExtra("remark_image_path");
    this.vKm = getIntent().getBooleanExtra("view_temp_remark_image", false);
    this.vKn = getIntent().getBooleanExtra("view_only", false);
    if (bk.bl(this.username))
    {
      finish();
      return;
    }
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      nx(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */