package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;

public class PluginSns
  extends f
  implements com.tencent.mm.plugin.sns.b.c
{
  l DqT;
  a DqU;
  o DqV;
  com.tencent.mm.plugin.sns.ad.a DqW;
  
  public PluginSns()
  {
    AppMethodBeat.i(94896);
    this.DqT = new l();
    this.DqU = new a();
    this.DqV = new o();
    this.DqW = new com.tencent.mm.plugin.sns.ad.a();
    AppMethodBeat.o(94896);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(94898);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.b(j.class, this.DqT);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.d.class, this.DqW);
    com.tencent.mm.plugin.sns.ad.a locala = this.DqW;
    locala.a(new com.tencent.mm.plugin.sns.ad.f.e());
    locala.a(new com.tencent.mm.plugin.sns.ad.f.d());
    locala.a(new com.tencent.mm.plugin.sns.ad.f.b());
    locala.a(new com.tencent.mm.plugin.sns.ad.f.c());
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginSns", "PluginSns configure");
      com.tencent.mm.vfs.y.nA("sns", "sns");
      com.tencent.mm.vfs.y.b("sns_ad_landingpages", "sns_ad_landingpages", 2592000000L, 103);
      pin(new com.tencent.mm.model.y(aj.class));
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.a.class, this.DqU);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.b(n.class, this.DqV);
    }
    AppMethodBeat.o(94898);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(94897);
    dependsOn(com.tencent.mm.plugin.emoji.b.d.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
    AppMethodBeat.o(94897);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(94899);
    com.tencent.mm.br.b.bfQ("sns");
    AppMethodBeat.o(94899);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(179063);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "sns/";
    AppMethodBeat.o(179063);
    return str;
  }
  
  public String getAccSnsTmpPath()
  {
    AppMethodBeat.i(179064);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "sns/temp/";
    AppMethodBeat.o(179064);
    return str;
  }
  
  public String getSnsAdPath()
  {
    AppMethodBeat.i(179065);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "sns/sns_ad//";
    AppMethodBeat.o(179065);
    return str;
  }
  
  public com.tencent.mm.plugin.sns.b.p getUIManager()
  {
    AppMethodBeat.i(94901);
    p localp = p.eWt();
    AppMethodBeat.o(94901);
    return localp;
  }
  
  public MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(94900);
    paramContext = (MMFragment)Fragment.instantiate(paramContext, SnsAlbumUI.class.getName(), paramBundle);
    AppMethodBeat.o(94900);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */