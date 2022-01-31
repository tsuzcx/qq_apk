package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI
  extends MMBaseActivity
{
  private String imagePath;
  
  private void bEq()
  {
    AppMethodBeat.i(34932);
    n.c(this, e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 0);
    getWindow().getDecorView().setOnTouchListener(new ShareImageRedirectUI.1(this));
    AppMethodBeat.o(34932);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(34934);
    getWindow().getDecorView().setOnTouchListener(null);
    if (paramInt2 != -1)
    {
      finish();
      AppMethodBeat.o(34934);
      return;
    }
    switch (paramInt1)
    {
    case 1: 
    default: 
      AppMethodBeat.o(34934);
      return;
    case 0: 
      localObject = getApplicationContext();
      aw.aaz();
      this.imagePath = n.h((Context)localObject, paramIntent, c.YK());
      if (this.imagePath == null)
      {
        AppMethodBeat.o(34934);
        return;
      }
      paramIntent = new Intent(this, ShareImageSelectorUI.class);
      paramIntent.putExtra("intent_extra_image_path", this.imagePath);
      startActivityForResult(paramIntent, 2);
      AppMethodBeat.o(34934);
      return;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getStringArrayListExtra("Select_Contact");
    }
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      paramIntent = new Intent(this, ChattingUI.class);
      paramIntent.putExtra("Chat_User", (String)((ArrayList)localObject).get(0));
      startActivity(paramIntent);
      finish();
      AppMethodBeat.o(34934);
      return;
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 1))
    {
      finish();
      AppMethodBeat.o(34934);
      return;
    }
    paramIntent = new Intent();
    paramIntent.putExtra("Ksnsupload_type", 0);
    paramIntent.putExtra("sns_kemdia_path", this.imagePath);
    d.b(this, "sns", ".ui.SnsUploadUI", paramIntent);
    finish();
    AppMethodBeat.o(34934);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34931);
    super.onCreate(paramBundle);
    boolean bool = b.a(this, "android.permission.CAMERA", 16, "", "");
    ab.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(34931);
      return;
    }
    bEq();
    AppMethodBeat.o(34931);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34933);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(34933);
      return;
    }
    ab.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34933);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bEq();
        AppMethodBeat.o(34933);
        return;
      }
      h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131297837), false, new ShareImageRedirectUI.2(this), new ShareImageRedirectUI.3(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImageRedirectUI
 * JD-Core Version:    0.7.0.1
 */