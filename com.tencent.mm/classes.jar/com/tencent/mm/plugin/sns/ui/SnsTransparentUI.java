package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class SnsTransparentUI
  extends MMActivity
{
  private Map<String, Bitmap> rwi;
  
  public SnsTransparentUI()
  {
    AppMethodBeat.i(39635);
    this.rwi = new HashMap();
    AppMethodBeat.o(39635);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39636);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    Object localObject = getIntent();
    if (localObject != null) {
      switch (((Intent)localObject).getIntExtra("op", -1))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39636);
      return;
      paramBundle = ((Intent)localObject).getStringExtra("adlandingXml");
      String str1 = ((Intent)localObject).getStringExtra("shareTitle");
      String str2 = ((Intent)localObject).getStringExtra("shareThumbUrl");
      String str3 = ((Intent)localObject).getStringExtra("shareDesc");
      String str4 = ((Intent)localObject).getStringExtra("shareUrl");
      localObject = ((Intent)localObject).getStringExtra("statExtStr");
      ab.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_Type", 259);
      localIntent.putExtra("select_is_ret", true);
      d.a(this, ".ui.transmit.SelectConversationUI", localIntent, 0, new SnsTransparentUI.1(this, paramBundle, str1, str2, str3, str4, (String)localObject));
      AppMethodBeat.o(39636);
      return;
      paramBundle = ((Intent)localObject).getStringExtra("phoneNum");
      c.a.wbU.a(this, paramBundle, new SnsTransparentUI.2(this), new Bundle());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI
 * JD-Core Version:    0.7.0.1
 */