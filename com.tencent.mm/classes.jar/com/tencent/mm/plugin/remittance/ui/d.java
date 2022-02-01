package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class d
{
  private Context mContext;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(ResendMsgInfo paramResendMsgInfo, final f.c paramc)
  {
    AppMethodBeat.i(67942);
    if (paramResendMsgInfo == null)
    {
      Log.i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
      AppMethodBeat.o(67942);
      return;
    }
    View localView = View.inflate(this.mContext, 2131496092, null);
    Object localObject = (ImageView)localView.findViewById(2131306840);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)localView.findViewById(2131299180);
    a locala = a.bdb();
    String str = paramResendMsgInfo.JQW;
    c.a locala1 = new c.a();
    locala1.jbq = 2131234657;
    locala.a(str, (ImageView)localObject, locala1.bdv());
    localMMNeat7extView.aw(paramResendMsgInfo.description);
    localObject = new f.a(this.mContext);
    ((f.a)localObject).aC(paramResendMsgInfo.title).hu(localView).boB(paramResendMsgInfo.lHA).boA(paramResendMsgInfo.lHB);
    ((f.a)localObject).c(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(67941);
        Log.i("MicroMsg.RemindCollectionDialog", "onDialogClick() bOk:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramc != null) {
          paramc.e(paramAnonymousBoolean, paramAnonymousString);
        }
        AppMethodBeat.o(67941);
      }
    }).show();
    AppMethodBeat.o(67942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.d
 * JD-Core Version:    0.7.0.1
 */