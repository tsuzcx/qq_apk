package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class ShowImageUI
  extends MMActivity
{
  private boolean AxK;
  private ShowImageUI.a AxL;
  private boolean AxM;
  private MMGestureGallery kuC;
  
  public int getLayoutId()
  {
    return 2130970736;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34996);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!bo.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.AxK = getIntent().getBooleanExtra("key_favorite", false);
    this.AxM = getIntent().getBooleanExtra("show_menu", true);
    this.kuC = ((MMGestureGallery)findViewById(2131822137));
    this.kuC.setVerticalFadingEdgeEnabled(false);
    this.kuC.setHorizontalFadingEdgeEnabled(false);
    this.AxL = new ShowImageUI.a(this, (byte)0);
    this.AxL.imagePath = getIntent().getStringExtra("key_image_path");
    this.kuC.setAdapter(this.AxL);
    setBackBtn(new ShowImageUI.1(this));
    if (this.AxM) {
      addIconOptionMenu(0, 2131231823, new ShowImageUI.2(this));
    }
    AppMethodBeat.o(34996);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI
 * JD-Core Version:    0.7.0.1
 */