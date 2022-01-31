package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class k$6
  implements b.a
{
  k$6(k paramk, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k paramk1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(145299);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.fsW.fta });
      al.d(new k.6.1(this));
      AppMethodBeat.o(145299);
      return;
    }
    paramString = (aqg)paramb.fsW.fta;
    ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramString.xfE });
    al.d(new k.6.2(this, paramString));
    AppMethodBeat.o(145299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k.6
 * JD-Core Version:    0.7.0.1
 */