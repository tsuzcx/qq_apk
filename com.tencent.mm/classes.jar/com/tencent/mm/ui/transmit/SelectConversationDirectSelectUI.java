package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.a;

@i
@a(7)
public class SelectConversationDirectSelectUI
  extends SelectConversationUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(169902);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_Conv_User");
    if (!bu.isNullOrNil(paramBundle))
    {
      ae.d("MicroMsg.SelectConversationDirectSelectUI", "hy: request direct select username");
      setContentViewVisibility(8);
      overridePendingTransition(0, 0);
      t.b(getWindow());
      t.c(getWindow(), false);
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      setBackGroundColorResource(2131100464);
      axN(paramBundle);
      AppMethodBeat.o(169902);
      return;
    }
    paramBundle = new IllegalArgumentException("not provide username for share. please use pure SelectConversationUI");
    AppMethodBeat.o(169902);
    throw paramBundle;
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(169901);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
    AppMethodBeat.o(169901);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationDirectSelectUI
 * JD-Core Version:    0.7.0.1
 */