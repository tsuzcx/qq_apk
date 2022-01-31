package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;

public final class ab$a
  extends k<String, String, Boolean>
{
  private String key;
  private String rfQ;
  PInt rfR;
  PInt rfS;
  private String rfT;
  private SharedPreferences sp;
  private String username;
  
  public ab$a(ab paramab)
  {
    AppMethodBeat.i(36364);
    this.sp = null;
    this.rfQ = "";
    this.key = "";
    this.rfR = new PInt();
    this.rfS = new PInt();
    this.sp = ah.getContext().getSharedPreferences("preferences_remove_task", 0);
    g.RM();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(36364);
      return;
    }
    this.username = r.Zn();
    this.rfQ = ("remove_key_base" + this.username);
    this.key = ("remove_key" + this.username);
    g.RM();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(36364);
      return;
    }
    if (ag.coN())
    {
      AppMethodBeat.o(36364);
      return;
    }
    if (ag.Rq() == null)
    {
      AppMethodBeat.o(36364);
      return;
    }
    if (ag.cpj() == null)
    {
      AppMethodBeat.o(36364);
      return;
    }
    l locall = ag.cpj().abz(this.username);
    if (locall != null) {
      this.rfT = locall.field_bgId;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.rfT });
    ab.a(paramab, true);
    AppMethodBeat.o(36364);
  }
  
  private Boolean coz()
  {
    AppMethodBeat.i(36365);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
    if (!ab.ocf)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(36365);
      return localObject;
    }
    if (!ab.c(this.rfP))
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(36365);
      return localObject;
    }
    if (ag.coN())
    {
      ab.ocf = false;
      localObject = Boolean.FALSE;
      AppMethodBeat.o(36365);
      return localObject;
    }
    this.rfR.value = this.sp.getInt(this.rfQ, 0);
    this.rfS.value = this.sp.getInt(this.key, 0);
    Object localObject = ag.getAccSnsPath();
    try
    {
      long l = System.currentTimeMillis();
      if (!ab.ah((String)localObject + ab.rfO[(this.rfR.value % 36)] + "/" + ab.rfO[(this.rfS.value % 36)], this.rfT, this.username))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(36365);
        return localObject;
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.rfR.value + " " + this.rfS.value);
    }
    catch (Exception localException)
    {
      label254:
      break label254;
    }
    localObject = Boolean.TRUE;
    AppMethodBeat.o(36365);
    return localObject;
  }
  
  public final com.tencent.mm.sdk.g.b.a cjN()
  {
    AppMethodBeat.i(36366);
    com.tencent.mm.sdk.g.b.a locala = ag.coR();
    AppMethodBeat.o(36366);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab.a
 * JD-Core Version:    0.7.0.1
 */