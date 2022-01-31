package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class ad
  implements com.tencent.mm.modelvideo.b
{
  b.a ibL;
  String qAL;
  private h.a rga;
  
  public ad()
  {
    AppMethodBeat.i(145257);
    this.qAL = "";
    this.rga = new ad.1(this);
    AppMethodBeat.o(145257);
  }
  
  public final void a(b.a parama)
  {
    this.ibL = parama;
  }
  
  public final void er(String paramString)
  {
    AppMethodBeat.i(145259);
    ab.i("MicroMsg.SnsAdStreamVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.qAL.equals(paramString)) {
      ag.cpa().aaa(paramString);
    }
    AppMethodBeat.o(145259);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(145261);
    ab.d("MicroMsg.SnsAdStreamVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.qAL.equals(paramString)) {
      bool = o.alF().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(145261);
    return bool;
  }
  
  public final void r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(145258);
    this.qAL = paramString1;
    ab.i("MicroMsg.SnsAdStreamVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (com.tencent.mm.vfs.e.cN(paramString2))
    {
      ab.i("MicroMsg.SnsAdStreamVideoProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.rga.a(paramString1, 0, null);
        AppMethodBeat.o(145258);
      }
    }
    else if (bool)
    {
      ab.i("MicroMsg.SnsAdStreamVideoProxy", "last download file was deleted");
      localSharedPreferences.edit().putBoolean(paramString1, false).commit();
    }
    if (ag.cpa().aad(paramString1))
    {
      ab.i("%s is already in downloading", paramString3);
      AppMethodBeat.o(145258);
      return;
    }
    ag.cpa().a(paramString1, paramString3, paramString2, this.rga);
    AppMethodBeat.o(145258);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145260);
    ab.d("MicroMsg.SnsAdStreamVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.qAL.equals(paramString))
    {
      o.alF();
      com.tencent.mm.al.e.r(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(145260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad
 * JD-Core Version:    0.7.0.1
 */