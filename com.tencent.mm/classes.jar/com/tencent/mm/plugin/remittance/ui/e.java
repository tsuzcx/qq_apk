package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

public final class e
{
  private Context mContext;
  
  public e(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(ResendMsgInfo paramResendMsgInfo, final g.c paramc)
  {
    AppMethodBeat.i(67942);
    if (paramResendMsgInfo == null)
    {
      Log.i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
      AppMethodBeat.o(67942);
      return;
    }
    View localView = View.inflate(this.mContext, a.g.remind_collection_dialog, null);
    Object localObject = (ImageView)localView.findViewById(a.f.remind_img);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)localView.findViewById(a.f.content);
    a locala = a.bKl();
    String str = paramResendMsgInfo.XJO;
    c.a locala1 = new c.a();
    locala1.oKB = a.e.remittance_remind_collection_default;
    locala.a(str, (ImageView)localObject, locala1.bKx());
    localMMNeat7extView.aZ(paramResendMsgInfo.description);
    localObject = new g.a(this.mContext);
    ((g.a)localObject).bf(paramResendMsgInfo.title).mg(localView).bDJ(paramResendMsgInfo.rGU).bDI(paramResendMsgInfo.right_button_wording);
    ((g.a)localObject).c(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(67941);
        Log.i("MicroMsg.RemindCollectionDialog", "onDialogClick() bOk:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramc != null) {
          paramc.onDialogClick(paramAnonymousBoolean, paramAnonymousString);
        }
        AppMethodBeat.o(67941);
      }
    }).show();
    AppMethodBeat.o(67942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.e
 * JD-Core Version:    0.7.0.1
 */