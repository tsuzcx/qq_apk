package com.tencent.mm.plugin.sns;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.y;

public class PluginSns
  extends f
  implements com.tencent.mm.plugin.sns.b.b
{
  l ojj = new l();
  a ojk = new a();
  o ojl = new o();
  com.tencent.mm.plugin.sns.a.a ojm = new com.tencent.mm.plugin.sns.a.a();
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.a(i.class, this.ojj);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.c.class, this.ojm);
    com.tencent.mm.plugin.sns.a.a locala = this.ojm;
    locala.a(new com.tencent.mm.plugin.sns.a.a.e());
    locala.a(new com.tencent.mm.plugin.sns.a.a.d());
    locala.a(new com.tencent.mm.plugin.sns.a.a.b());
    locala.a(new com.tencent.mm.plugin.sns.a.a.c());
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginSns", "PluginSns configure");
      pin(new p(af.class));
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.a.class, this.ojk);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.a(m.class, this.ojl);
    }
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.emoji.b.d.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.br.c.Xg("sns");
  }
  
  public String getAccSnsPath()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "sns/";
  }
  
  public String getAccSnsTmpPath()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "sns/temp/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */