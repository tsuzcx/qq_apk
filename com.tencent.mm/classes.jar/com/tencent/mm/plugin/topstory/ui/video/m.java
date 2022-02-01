package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
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
  private int Fdo;
  b GlS;
  Map<String, eix> GnA;
  Set<String> GnB;
  String Gnz;
  
  public m()
  {
    AppMethodBeat.i(126116);
    this.Fdo = 0;
    this.GnA = Collections.synchronizedMap(new HashMap());
    this.GnB = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(126116);
  }
  
  static long au(long paramLong1, long paramLong2)
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
    this.Fdo += 1;
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.Fdo) });
    this.GlS = paramb;
    this.Gnz = h.aTv(paramb.fyD().sGQ);
    AppMethodBeat.o(126117);
  }
  
  public final void fzx()
  {
    AppMethodBeat.i(126119);
    Iterator localIterator = this.GnB.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.an.f.baQ().Oc(str);
    }
    AppMethodBeat.o(126119);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126118);
    this.Fdo -= 1;
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.Fdo) });
    if (this.Fdo <= 0)
    {
      fzx();
      this.GnB.clear();
      ThreadPool.post(new m.b(this, this.Gnz), "TopStory.DeleteVideoFolderTask");
      this.GlS = null;
    }
    AppMethodBeat.o(126118);
  }
  
  final class a
    implements Runnable
  {
    private String xnX;
    
    a(String paramString)
    {
      this.xnX = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(126112);
      Object localObject1 = new o(this.xnX);
      Object localObject2;
      if (((o)localObject1).exists())
      {
        localObject1 = ((o)localObject1).het();
        int j = m.this.GnB.size();
        int k = m.this.GnA.size();
        if (localObject1 != null) {}
        for (int i = localObject1.length;; i = 0)
        {
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.xnX });
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
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((o)((List)localObject2).get(0)).lastModified() / 1000L), com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((o)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
        localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
        if (m.this.GlS == null) {
          break label478;
        }
        localObject1 = m.this.GlS.fyF().GjK;
        if (localObject1 == null) {
          break label478;
        }
      }
      label448:
      label478:
      for (localObject1 = com.tencent.mm.plugin.topstory.ui.c.bu(((eiw)localObject1).psI, ((eiw)localObject1).Nip);; localObject1 = "")
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          o localo = (o)((Iterator)localObject2).next();
          String str = localo.getName().split("\\.")[0];
          if ((!str.equals(localObject1)) && (!m.this.GnB.contains(str)))
          {
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { localo.getName(), com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", localo.lastModified() / 1000L) });
            m.this.GnA.remove(str);
            localo.delete();
          }
        }
        AppMethodBeat.o(126112);
        return;
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.xnX });
        AppMethodBeat.o(126112);
        return;
      }
    }
  }
  
  final class c
    implements g.b
  {
    private c() {}
    
    public final void b(String paramString, d paramd)
    {
      AppMethodBeat.i(126114);
      if (m.this.GnA.containsKey(paramString))
      {
        eix localeix = (eix)m.this.GnA.get(paramString);
        localeix.NiK = paramd.field_recvedBytes;
        localeix.NiL = m.au(localeix.NiK, (int)paramd.field_fileLength);
        localeix.Niv = ((int)paramd.field_fileLength);
        m.this.GnA.put(paramString, localeix);
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localeix.NiL), Util.getSizeMB(localeix.NiK, 100.0D) });
      }
      AppMethodBeat.o(126114);
    }
  }
  
  final class d
    implements g.a
  {
    private d() {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126115);
      if ((paramc != null) && (paramc.field_toltalLength > 0L) && (m.this.GnA.containsKey(paramString)))
      {
        paramd = (eix)m.this.GnA.get(paramString);
        paramd.NiK = paramc.field_finishedLength;
        paramd.NiL = m.au(paramc.field_finishedLength, paramc.field_toltalLength);
        paramd.Niv = paramc.field_toltalLength;
        m.this.GnA.put(paramString, paramd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */