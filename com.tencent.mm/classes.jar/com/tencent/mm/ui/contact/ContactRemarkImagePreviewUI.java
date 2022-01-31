package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class ContactRemarkImagePreviewUI
  extends MMActivity
{
  private View AbK;
  private String AbL;
  private boolean AbM;
  private boolean AbN;
  private ContactRemarkImagePreviewUI.a AbO;
  private MMGestureGallery kuC;
  private String username;
  
  private void rg(boolean paramBoolean)
  {
    AppMethodBeat.i(33623);
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("response_delete", true);
      setResult(-1, localIntent);
    }
    finish();
    AppMethodBeat.o(33623);
  }
  
  public int getLayoutId()
  {
    return 2130969266;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33622);
    this.AbK = findViewById(2131822806);
    this.kuC = ((MMGestureGallery)findViewById(2131822137));
    setMMTitle(2131301613);
    this.kuC.setVerticalFadingEdgeEnabled(false);
    this.kuC.setHorizontalFadingEdgeEnabled(false);
    n.cn(this.kuC);
    this.AbO = new ContactRemarkImagePreviewUI.a(this);
    this.AbO.imagePath = this.AbL;
    this.kuC.setAdapter(this.AbO);
    this.kuC.setOnItemClickListener(new ContactRemarkImagePreviewUI.3(this));
    addIconOptionMenu(0, 2131230740, new ContactRemarkImagePreviewUI.1(this));
    setBackBtn(new ContactRemarkImagePreviewUI.2(this));
    AppMethodBeat.o(33622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33619);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("Contact_User");
    this.AbL = getIntent().getStringExtra("remark_image_path");
    this.AbM = getIntent().getBooleanExtra("view_temp_remark_image", false);
    this.AbN = getIntent().getBooleanExtra("view_only", false);
    if (bo.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(33619);
      return;
    }
    initView();
    AppMethodBeat.o(33619);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33621);
    super.onDestroy();
    AppMethodBeat.o(33621);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33625);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      rg(false);
      AppMethodBeat.o(33625);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(33625);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33620);
    super.onPause();
    AppMethodBeat.o(33620);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */