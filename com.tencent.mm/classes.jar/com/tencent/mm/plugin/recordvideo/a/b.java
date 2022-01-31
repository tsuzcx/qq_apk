package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.PhotoEditProxy;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

public final class b
  implements CaptureDataManager.b
{
  PhotoEditProxy qaM;
  private com.tencent.mm.remoteservice.d qaN;
  String qaO;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(150534);
    this.qaN = new com.tencent.mm.remoteservice.d(paramContext);
    this.qaM = new PhotoEditProxy(this.qaN);
    this.qaN.connect(new b.1(this));
    AppMethodBeat.o(150534);
  }
  
  final void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(150537);
    String str = paramIntent.getStringExtra("Select_Conv_User");
    ab.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", new Object[] { str, this.qaO });
    p localp = h.b(paramContext, paramContext.getResources().getString(2131306205), false, null);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    this.qaM.sendImage(paramIntent, this.qaO, this.qaM.getSelfUsername(), str);
    localp.dismiss();
    ((Activity)paramContext).finish();
    AppMethodBeat.o(150537);
  }
  
  public final void a(final Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(150535);
    paramBundle = new com.tencent.mm.ui.tools.l(paramContext);
    paramBundle.sao = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(150531);
        paramAnonymousl.e(0, paramContext.getResources().getString(2131302657));
        paramAnonymousl.e(1, paramContext.getResources().getString(2131302102));
        paramAnonymousl.e(2, paramContext.getResources().getString(2131302869));
        AppMethodBeat.o(150531);
      }
    };
    paramBundle.sap = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(150532);
        String str;
        if (paramAnonymousInt == 0)
        {
          Object localObject = b.this;
          paramAnonymousMenuItem = paramContext;
          str = paramCaptureVideoNormalModel.thumbPath;
          ((b)localObject).qaO = str;
          localObject = new Intent();
          ((Intent)localObject).putExtra("scene", 8);
          ((Intent)localObject).putExtra("select_is_ret", true);
          ((Intent)localObject).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject).putExtra("image_path", str);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
          com.tencent.mm.bq.d.b(paramAnonymousMenuItem, ".ui.transmit.SelectConversationUI", (Intent)localObject, 1);
          AppMethodBeat.o(150532);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          paramAnonymousMenuItem = b.this;
          str = paramCaptureVideoNormalModel.thumbPath;
          paramAnonymousMenuItem.qaM.doFav(str);
          Toast.makeText(ah.getContext(), paramContext.getResources().getString(2131306165), 1).show();
          ((Activity)paramContext).finish();
          AppMethodBeat.o(150532);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          Toast.makeText(ah.getContext(), paramContext.getResources().getString(2131306161, new Object[] { e.esr }), 1).show();
          ((Activity)paramContext).finish();
        }
        AppMethodBeat.o(150532);
      }
    };
    h.a(paramContext, paramBundle.cwt());
    AppMethodBeat.o(150535);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(150536);
    if (this.qaN.isConnected())
    {
      A(paramContext, paramIntent);
      AppMethodBeat.o(150536);
      return;
    }
    this.qaN.connect(new b.4(this, paramContext, paramIntent));
    AppMethodBeat.o(150536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b
 * JD-Core Version:    0.7.0.1
 */