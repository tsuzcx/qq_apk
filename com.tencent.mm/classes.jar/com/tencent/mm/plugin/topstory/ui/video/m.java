package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m
{
  private int ASI;
  b BLm;
  String BMT;
  Map<String, dpb> BMU;
  Set<String> BMV;
  
  public m()
  {
    AppMethodBeat.i(126116);
    this.ASI = 0;
    this.BMU = Collections.synchronizedMap(new HashMap());
    this.BMV = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(126116);
  }
  
  static long an(long paramLong1, long paramLong2)
  {
    long l = 0L;
    if (paramLong2 != 0L) {
      l = 100L * paramLong1 / paramLong2;
    }
    return l;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(126117);
    this.ASI += 1;
    ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.ASI) });
    this.BLm = paramb;
    this.BMT = h.aEf(paramb.etg().rfA);
    AppMethodBeat.o(126117);
  }
  
  public final void eub()
  {
    AppMethodBeat.i(126119);
    Iterator localIterator = this.BMV.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f.aGZ().Fs(str);
    }
    AppMethodBeat.o(126119);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126118);
    this.ASI -= 1;
    ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ASI) });
    if (this.ASI <= 0)
    {
      eub();
      this.BMV.clear();
      com.tencent.mm.sdk.g.b.c(new b(this.BMT), "TopStory.DeleteVideoFolderTask");
      this.BLm = null;
    }
    AppMethodBeat.o(126118);
  }
  
  final class a
    implements Runnable
  {
    private String tWN;
    
    a(String paramString)
    {
      this.tWN = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(126112);
      Object localObject1 = new k(this.tWN);
      Object localObject2;
      if (((k)localObject1).exists())
      {
        localObject1 = ((k)localObject1).fTj();
        int j = m.this.BMV.size();
        int k = m.this.BMU.size();
        if (localObject1 != null) {}
        for (int i = localObject1.length;; i = 0)
        {
          ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.tWN });
          if ((localObject1 == null) || (localObject1.length <= 10)) {
            break label448;
          }
          localObject2 = new ArrayList(localObject1.length);
          j = localObject1.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject2).add(localObject1[i]);
            i += 1;
          }
        }
        Collections.sort((List)localObject2, new Comparator() {});
        ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { i.formatTime("yyyy-MM-dd HH:mm:ss", ((k)((List)localObject2).get(0)).lastModified() / 1000L), i.formatTime("yyyy-MM-dd HH:mm:ss", ((k)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
        localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
        if (m.this.BLm == null) {
          break label478;
        }
        localObject1 = m.this.BLm.eti().BJb;
        if (localObject1 == null) {
          break label478;
        }
      }
      label448:
      label478:
      for (localObject1 = com.tencent.mm.plugin.topstory.ui.d.bt(((dpa)localObject1).udb, ((dpa)localObject1).HWh);; localObject1 = "")
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          k localk = (k)((Iterator)localObject2).next();
          String str = localk.getName().split("\\.")[0];
          if ((!str.equals(localObject1)) && (!m.this.BMV.contains(str)))
          {
            ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { localk.getName(), i.formatTime("yyyy-MM-dd HH:mm:ss", localk.lastModified() / 1000L) });
            m.this.BMU.remove(str);
            localk.delete();
          }
        }
        AppMethodBeat.o(126112);
        return;
        ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.tWN });
        AppMethodBeat.o(126112);
        return;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private String tWN;
    
    b(String paramString)
    {
      this.tWN = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(126113);
      long l = System.currentTimeMillis();
      o.dd(this.tWN, true);
      ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", new Object[] { this.tWN, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(126113);
    }
  }
  
  final class c
    implements g.b
  {
    private c() {}
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126114);
      if (m.this.BMU.containsKey(paramString))
      {
        dpb localdpb = (dpb)m.this.BMU.get(paramString);
        localdpb.HWC = paramd.field_recvedBytes;
        localdpb.HWD = m.an(localdpb.HWC, (int)paramd.field_fileLength);
        localdpb.HWo = ((int)paramd.field_fileLength);
        m.this.BMU.put(paramString, localdpb);
        ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localdpb.HWD), bu.a(localdpb.HWC, 100.0D) });
      }
      AppMethodBeat.o(126114);
    }
  }
  
  final class d
    implements g.a
  {
    private d() {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126115);
      if ((paramc != null) && (paramc.field_toltalLength > 0L) && (m.this.BMU.containsKey(paramString)))
      {
        paramd = (dpb)m.this.BMU.get(paramString);
        paramd.HWC = paramc.field_finishedLength;
        paramd.HWD = m.an(paramc.field_finishedLength, paramc.field_toltalLength);
        paramd.HWo = paramc.field_toltalLength;
        m.this.BMU.put(paramString, paramd);
      }
      AppMethodBeat.o(126115);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */