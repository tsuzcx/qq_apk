package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class i
{
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, f paramf)
  {
    AppMethodBeat.i(79949);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramf.field_packageName;
    paramBaseResp.bundle = paramBundle;
    p.aC(paramBundle);
    p.aD(paramBundle);
    MMessageActV2.send(ah.getContext(), paramBaseResp);
    AppMethodBeat.o(79949);
  }
  
  public static boolean c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(79948);
    paramString3 = g.ca(paramString3, true);
    if (paramString3 == null)
    {
      ab.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
      AppMethodBeat.o(79948);
      return false;
    }
    Bundle localBundle = new Bundle();
    WXOpenBusinessView.Resp localResp = new WXOpenBusinessView.Resp(localBundle);
    localResp.extMsg = paramString2;
    localResp.errStr = paramString4;
    localResp.openId = paramString3.field_openId;
    localResp.errCode = paramInt;
    localResp.businessType = paramString1;
    a(localBundle, localResp, paramString3);
    AppMethodBeat.o(79948);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */