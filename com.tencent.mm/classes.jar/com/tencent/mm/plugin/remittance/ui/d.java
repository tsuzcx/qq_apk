package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ae;
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
      ae.i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
      AppMethodBeat.o(67942);
      return;
    }
    View localView = View.inflate(this.mContext, 2131495246, null);
    Object localObject = (ImageView)localView.findViewById(2131303986);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)localView.findViewById(2131298739);
    a locala = a.aJh();
    String str = paramResendMsgInfo.Fae;
    c.a locala1 = new c.a();
    locala1.igv = 2131233833;
    locala.a(str, (ImageView)localObject, locala1.aJu());
    localMMNeat7extView.aq(paramResendMsgInfo.description);
    localObject = new f.a(this.mContext);
    ((f.a)localObject).au(paramResendMsgInfo.title).hg(localView).aZv(paramResendMsgInfo.kCZ).aZu(paramResendMsgInfo.kDa);
    ((f.a)localObject).c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(67941);
        ae.i("MicroMsg.RemindCollectionDialog", "onDialogClick() bOk:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramc != null) {
          paramc.d(paramAnonymousBoolean, paramAnonymousString);
        }
        AppMethodBeat.o(67941);
      }
    }).show();
    AppMethodBeat.o(67942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.d
 * JD-Core Version:    0.7.0.1
 */