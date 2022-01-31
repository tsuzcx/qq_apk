package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class ab$a
  extends k<String, String, Boolean>
{
  private SharedPreferences dnD = null;
  private String key = "";
  private String ore = "";
  PInt orf = new PInt();
  PInt org = new PInt();
  private String orh;
  private String username;
  
  public ab$a(ab paramab)
  {
    g.DQ();
    if (!g.DN().Dc()) {}
    do
    {
      return;
      this.username = q.Gj();
      this.ore = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      g.DQ();
    } while ((!g.DN().Dc()) || (af.bDo()) || (af.Dv() == null) || (af.bDJ() == null));
    l locall = af.bDJ().OF(this.username);
    if (locall != null) {
      this.orh = locall.field_bgId;
    }
    y.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.orh });
    ab.a(paramab, true);
  }
  
  private Boolean bCZ()
  {
    y.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
    if (!ab.lER) {
      return Boolean.valueOf(false);
    }
    if (!ab.c(this.ord)) {
      return Boolean.valueOf(false);
    }
    if (af.bDo())
    {
      ab.lER = false;
      return Boolean.valueOf(false);
    }
    this.orf.value = this.dnD.getInt(this.ore, 0);
    this.org.value = this.dnD.getInt(this.key, 0);
    String str = af.getAccSnsPath();
    try
    {
      long l = System.currentTimeMillis();
      if (!ab.W(str + ab.orc[(this.orf.value % 36)] + "/" + ab.orc[(this.org.value % 36)], this.orh, this.username)) {
        return Boolean.valueOf(false);
      }
      y.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.orf.value + " " + this.org.value);
    }
    catch (Exception localException)
    {
      label225:
      break label225;
    }
    return Boolean.valueOf(true);
  }
  
  public final ah byB()
  {
    return af.bDr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab.a
 * JD-Core Version:    0.7.0.1
 */