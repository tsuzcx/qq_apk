package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;

public final class d
{
  private Context mContext;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(ResendMsgInfo paramResendMsgInfo, e.c paramc)
  {
    AppMethodBeat.i(142139);
    if (paramResendMsgInfo == null)
    {
      ab.i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
      AppMethodBeat.o(142139);
      return;
    }
    Object localObject1 = View.inflate(this.mContext, 2130970563, null);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131827177);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)((View)localObject1).findViewById(2131820946);
    a locala = a.ahM();
    String str = paramResendMsgInfo.vIO;
    c.a locala1 = new c.a();
    locala1.eNY = 2130840145;
    locala.a(str, (ImageView)localObject2, locala1.ahY());
    localMMNeat7extView.af(paramResendMsgInfo.description);
    localObject2 = new e.a(this.mContext);
    localObject1 = ((e.a)localObject2).aj(paramResendMsgInfo.title).fv((View)localObject1);
    ((e.a)localObject1).AHt = paramResendMsgInfo.opC;
    ((e.a)localObject1).AHs = paramResendMsgInfo.opD;
    ((e.a)localObject2).c(new d.1(this, paramc)).show();
    AppMethodBeat.o(142139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.d
 * JD-Core Version:    0.7.0.1
 */