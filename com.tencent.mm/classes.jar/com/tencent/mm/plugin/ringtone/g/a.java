package com.tencent.mm.plugin.ringtone.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/params/ExclusiveInfo;", "", "info", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "name", "", "order", "", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;Ljava/lang/String;J)V", "getInfo", "()Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "setInfo", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOrder", "()J", "setOrder", "(J)V", "compareTo", "", "other", "fromJson", "json", "toJson", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Comparable<a>
{
  public d OCX = null;
  public long OCY = 0L;
  public String name = null;
  
  public static a aUw(String paramString)
  {
    AppMethodBeat.i(272840);
    s.u(paramString, "json");
    a locala = new a((byte)0);
    paramString = new i(paramString);
    try
    {
      Object localObject = d.ODu;
      localObject = paramString.getString("info");
      s.s(localObject, "jsonObject.getString(\"info\")");
      locala.OCX = d.a.aUz((String)localObject);
      locala.name = paramString.getString("name");
      locala.OCY = paramString.getLong("order");
      label74:
      AppMethodBeat.o(272840);
      return locala;
    }
    catch (Exception paramString)
    {
      break label74;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.g.a
 * JD-Core Version:    0.7.0.1
 */