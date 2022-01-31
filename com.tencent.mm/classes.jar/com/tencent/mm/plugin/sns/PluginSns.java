package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;

public class PluginSns
  extends f
  implements com.tencent.mm.plugin.sns.b.b
{
  l qXu;
  a qXv;
  o qXw;
  com.tencent.mm.plugin.sns.a.a qXx;
  
  public PluginSns()
  {
    AppMethodBeat.i(35613);
    this.qXu = new l();
    this.qXv = new a();
    this.qXw = new o();
    this.qXx = new com.tencent.mm.plugin.sns.a.a();
    AppMethodBeat.o(35613);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(35615);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.b(i.class, this.qXu);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.c.class, this.qXx);
    com.tencent.mm.plugin.sns.a.a locala = this.qXx;
    locala.a(new com.tencent.mm.plugin.sns.a.a.e());
    locala.a(new com.tencent.mm.plugin.sns.a.a.d());
    locala.a(new com.tencent.mm.plugin.sns.a.a.b());
    locala.a(new com.tencent.mm.plugin.sns.a.a.c());
    if (paramg.SD())
    {
      ab.i("MicroMsg.PluginSns", "PluginSns configure");
      pin(new q(ag.class));
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.a.class, this.qXv);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.b(m.class, this.qXw);
    }
    AppMethodBeat.o(35615);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(35614);
    dependsOn(com.tencent.mm.plugin.emoji.b.d.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
    AppMethodBeat.o(35614);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(35616);
    com.tencent.mm.bq.c.anb("sns");
    AppMethodBeat.o(35616);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(35617);
    String str = com.tencent.mm.kernel.g.RL().eHR + "sns/";
    AppMethodBeat.o(35617);
    return str;
  }
  
  public String getAccSnsTmpPath()
  {
    AppMethodBeat.i(35618);
    String str = com.tencent.mm.kernel.g.RL().eHR + "sns/temp/";
    AppMethodBeat.o(35618);
    return str;
  }
  
  public String getSnsAdPath()
  {
    AppMethodBeat.i(145237);
    String str = com.tencent.mm.loader.j.b.eQz + "sns_ad/";
    AppMethodBeat.o(145237);
    return str;
  }
  
  public MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(35619);
    paramContext = (MMFragment)Fragment.instantiate(paramContext, SnsAlbumUI.class.getName(), paramBundle);
    AppMethodBeat.o(35619);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */