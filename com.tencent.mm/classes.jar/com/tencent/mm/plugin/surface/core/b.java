package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/MultiContextFileSystem;", "Lcom/tencent/mm/plugin/appbrand/appstorage/DefaultFileSystem;", "selector", "Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector;", "(Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector;)V", "access", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "url", "", "readFile", "pByteBuffer", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "Ljava/nio/ByteBuffer;", "position", "", "length", "readStream", "Ljava/io/InputStream;", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends o
{
  private final d SJS;
  
  public b(d paramd)
  {
    AppMethodBeat.i(265157);
    this.SJS = paramd;
    AppMethodBeat.o(265157);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.r Vr(String paramString)
  {
    AppMethodBeat.i(265165);
    s.u(paramString, "url");
    Object localObject = this.SJS.bcP(paramString);
    if (localObject == null) {}
    String str;
    for (localObject = null; localObject == null; localObject = h.c(((d.b)localObject).SKf, str))
    {
      paramString = super.Vr(paramString);
      s.s(paramString, "super.access(url)");
      AppMethodBeat.o(265165);
      return paramString;
      str = ((d.b)localObject).path;
    }
    AppMethodBeat.o(265165);
    return localObject;
  }
  
  public final InputStream Wr(String paramString)
  {
    AppMethodBeat.i(265191);
    s.u(paramString, "url");
    Object localObject = this.SJS.bcP(paramString);
    if (localObject == null) {}
    String str;
    for (localObject = null; localObject == null; localObject = ((d.b)localObject).SKf.Va(str))
    {
      paramString = super.Wr(paramString);
      AppMethodBeat.o(265191);
      return paramString;
      str = ((d.b)localObject).path;
    }
    AppMethodBeat.o(265191);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(265185);
    s.u(paramString, "url");
    s.u(paramk, "pByteBuffer");
    Object localObject = this.SJS.bcP(paramString);
    if (localObject == null) {}
    String str;
    for (localObject = null; localObject == null; localObject = com.tencent.mm.plugin.appbrand.appcache.r.a(((d.b)localObject).SKf, str, paramLong1, paramLong2, paramk))
    {
      paramString = super.a(paramString, paramLong1, paramLong2, paramk);
      s.s(paramString, "super.readFile(url, position, length, pByteBuffer)");
      AppMethodBeat.o(265185);
      return paramString;
      str = ((d.b)localObject).path;
    }
    AppMethodBeat.o(265185);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(265176);
    s.u(paramString, "url");
    s.u(paramk, "pByteBuffer");
    Object localObject = this.SJS.bcP(paramString);
    if (localObject == null) {}
    String str;
    for (localObject = null; localObject == null; localObject = com.tencent.mm.plugin.appbrand.appcache.r.a(((d.b)localObject).SKf, str, paramk))
    {
      paramString = super.b(paramString, paramk);
      s.s(paramString, "super.readFile(url, pByteBuffer)");
      AppMethodBeat.o(265176);
      return paramString;
      str = ((d.b)localObject).path;
    }
    AppMethodBeat.o(265176);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.b
 * JD-Core Version:    0.7.0.1
 */