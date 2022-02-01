package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.g.b;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.u;
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
  private int RUS;
  b TLn;
  String TMV;
  Map<String, foi> TMW;
  Set<String> TMX;
  
  public m()
  {
    AppMethodBeat.i(126116);
    this.RUS = 0;
    this.TMW = Collections.synchronizedMap(new HashMap());
    this.TMX = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(126116);
  }
  
  static long bu(long paramLong1, long paramLong2)
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
    this.RUS += 1;
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.RUS) });
    this.TLn = paramb;
    this.TMV = com.tencent.mm.plugin.topstory.a.g.beq(paramb.hNz().zIO);
    AppMethodBeat.o(126117);
  }
  
  public final void hOy()
  {
    AppMethodBeat.i(126119);
    Iterator localIterator = this.TMX.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      k.bHW().Nz(str);
    }
    AppMethodBeat.o(126119);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126118);
    this.RUS -= 1;
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.RUS) });
    if (this.RUS <= 0)
    {
      hOy();
      this.TMX.clear();
      ThreadPool.post(new m.b(this, this.TMV), "TopStory.DeleteVideoFolderTask");
      this.TLn = null;
    }
    AppMethodBeat.o(126118);
  }
  
  final class a
    implements Runnable
  {
    private String HMr;
    
    a(String paramString)
    {
      this.HMr = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(126112);
      Object localObject1 = new u(this.HMr);
      Object localObject2;
      if (((u)localObject1).jKS())
      {
        localObject1 = ((u)localObject1).jKX();
        int j = m.this.TMX.size();
        int k = m.this.TMW.size();
        if (localObject1 != null) {}
        for (int i = localObject1.length;; i = 0)
        {
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.HMr });
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
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", ((u)((List)localObject2).get(0)).lastModified() / 1000L), f.formatTime("yyyy-MM-dd HH:mm:ss", ((u)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
        localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
        if (m.this.TLn == null) {
          break label478;
        }
        localObject1 = m.this.TLn.hNB().TIZ;
        if (localObject1 == null) {
          break label478;
        }
      }
      label448:
      label478:
      for (localObject1 = com.tencent.mm.plugin.topstory.ui.d.bL(((foh)localObject1).Ido, ((foh)localObject1).abOw);; localObject1 = "")
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          u localu = (u)((Iterator)localObject2).next();
          String str = localu.getName().split("\\.")[0];
          if ((!str.equals(localObject1)) && (!m.this.TMX.contains(str)))
          {
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { localu.getName(), f.formatTime("yyyy-MM-dd HH:mm:ss", localu.lastModified() / 1000L) });
            m.this.TMW.remove(str);
            localu.diJ();
          }
        }
        AppMethodBeat.o(126112);
        return;
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.HMr });
        AppMethodBeat.o(126112);
        return;
      }
    }
  }
  
  final class c
    implements g.b
  {
    private c() {}
    
    public final void b(String paramString, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(126114);
      if (m.this.TMW.containsKey(paramString))
      {
        foi localfoi = (foi)m.this.TMW.get(paramString);
        localfoi.abOQ = paramd.field_recvedBytes;
        localfoi.abOR = m.bu(localfoi.abOQ, (int)paramd.field_fileLength);
        localfoi.abOC = ((int)paramd.field_fileLength);
        m.this.TMW.put(paramString, localfoi);
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localfoi.abOR), Util.getSizeMB(localfoi.abOQ, 100.0D) });
      }
      AppMethodBeat.o(126114);
    }
  }
  
  final class d
    implements g.a
  {
    private d() {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126115);
      if ((paramc != null) && (paramc.field_toltalLength > 0L) && (m.this.TMW.containsKey(paramString)))
      {
        paramd = (foi)m.this.TMW.get(paramString);
        paramd.abOQ = paramc.field_finishedLength;
        paramd.abOR = m.bu(paramc.field_finishedLength, paramc.field_toltalLength);
        paramd.abOC = paramc.field_toltalLength;
        m.this.TMW.put(paramString, paramd);
      }
      AppMethodBeat.o(126115);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */