package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class ShareImageRedirectUI
  extends MMBaseActivity
{
  private String imagePath;
  
  private void cNE()
  {
    AppMethodBeat.i(39128);
    q.d(this, com.tencent.mm.loader.j.b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg", 0);
    getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(39124);
        Toast.makeText(ShareImageRedirectUI.this, 2131763660, 1).show();
        ShareImageRedirectUI.this.finish();
        AppMethodBeat.o(39124);
        return false;
      }
    });
    AppMethodBeat.o(39128);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(39130);
    getWindow().getDecorView().setOnTouchListener(null);
    if (paramInt2 != -1)
    {
      finish();
      AppMethodBeat.o(39130);
      return;
    }
    switch (paramInt1)
    {
    case 1: 
    default: 
      AppMethodBeat.o(39130);
      return;
    case 0: 
      localObject = getApplicationContext();
      az.ayM();
      this.imagePath = q.h((Context)localObject, paramIntent, c.awL());
      if (this.imagePath == null)
      {
        AppMethodBeat.o(39130);
        return;
      }
      paramIntent = new Intent(this, ShareImageSelectorUI.class);
      paramIntent.putExtra("intent_extra_image_path", this.imagePath);
      startActivityForResult(paramIntent, 2);
      AppMethodBeat.o(39130);
      return;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getStringArrayListExtra("Select_Contact");
    }
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      paramIntent = new Intent(this, ChattingUI.class);
      paramIntent.putExtra("Chat_User", (String)((ArrayList)localObject).get(0));
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/ui/tools/ShareImageRedirectUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareImageRedirectUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(39130);
      return;
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 1))
    {
      finish();
      AppMethodBeat.o(39130);
      return;
    }
    paramIntent = new Intent();
    paramIntent.putExtra("Ksnsupload_type", 0);
    paramIntent.putExtra("sns_kemdia_path", this.imagePath);
    d.b(this, "sns", ".ui.SnsUploadUI", paramIntent);
    finish();
    AppMethodBeat.o(39130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39127);
    super.onCreate(paramBundle);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, "", "");
    ac.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(39127);
      return;
    }
    cNE();
    AppMethodBeat.o(39127);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39129);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(39129);
      return;
    }
    ac.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39129);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cNE();
        AppMethodBeat.o(39129);
        return;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39125);
          paramAnonymousDialogInterface = ShareImageRedirectUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/tools/ShareImageRedirectUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/tools/ShareImageRedirectUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ShareImageRedirectUI.this.finish();
          AppMethodBeat.o(39125);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39126);
          ShareImageRedirectUI.this.finish();
          AppMethodBeat.o(39126);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImageRedirectUI
 * JD-Core Version:    0.7.0.1
 */