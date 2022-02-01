package com.tencent.mm.plugin.surface.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.aa;
import kotlin.z;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/AppContext;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "frameSetRoots", "", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "getFrameSetRoots", "()Ljava/util/List;", "id", "getId", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final List<f> SLh;
  public final String appId;
  public final String id;
  
  public a(String paramString)
  {
    AppMethodBeat.i(265032);
    this.appId = paramString;
    this.id = aa.aMB(z.aKc(hashCode()));
    this.SLh = ((List)new LinkedList());
    AppMethodBeat.o(265032);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(265056);
    if (this == paramObject)
    {
      AppMethodBeat.o(265056);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(265056);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(265056);
      return false;
    }
    AppMethodBeat.o(265056);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(265045);
    int i = this.appId.hashCode();
    AppMethodBeat.o(265045);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(265038);
    String str = "AppContext(appId=" + this.appId + ')';
    AppMethodBeat.o(265038);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.a
 * JD-Core Version:    0.7.0.1
 */