package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
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
  b Acd;
  String AdK;
  Map<String, dip> AdL;
  Set<String> AdM;
  private int zjn;
  
  public m()
  {
    AppMethodBeat.i(126116);
    this.zjn = 0;
    this.AdL = Collections.synchronizedMap(new HashMap());
    this.AdM = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(126116);
  }
  
  static long al(long paramLong1, long paramLong2)
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
    this.zjn += 1;
    ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.zjn) });
    this.Acd = paramb;
    this.AdK = com.tencent.mm.plugin.topstory.a.h.axH(paramb.edh().qox);
    AppMethodBeat.o(126117);
  }
  
  public final void eec()
  {
    AppMethodBeat.i(126119);
    Iterator localIterator = this.AdM.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f.aDD().BR(str);
    }
    AppMethodBeat.o(126119);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126118);
    this.zjn -= 1;
    ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.zjn) });
    if (this.zjn <= 0)
    {
      eec();
      this.AdM.clear();
      com.tencent.mm.sdk.g.b.c(new m.b(this, this.AdK), "TopStory.DeleteVideoFolderTask");
      this.Acd = null;
    }
    AppMethodBeat.o(126118);
  }
  
  final class a
    implements Runnable
  {
    private String sPs;
    
    a(String paramString)
    {
      this.sPs = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(126112);
      Object localObject1 = new e(this.sPs);
      Object localObject2;
      if (((e)localObject1).exists())
      {
        localObject1 = ((e)localObject1).fxX();
        int j = m.this.AdM.size();
        int k = m.this.AdL.size();
        if (localObject1 != null) {}
        for (int i = localObject1.length;; i = 0)
        {
          ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.sPs });
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
        ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((e)((List)localObject2).get(0)).lastModified() / 1000L), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((e)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
        localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
        if (m.this.Acd == null) {
          break label478;
        }
        localObject1 = m.this.Acd.edj().zZQ;
        if (localObject1 == null) {
          break label478;
        }
      }
      label448:
      label478:
      for (localObject1 = com.tencent.mm.plugin.topstory.ui.d.bp(((dio)localObject1).sVF, ((dio)localObject1).FRO);; localObject1 = "")
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          e locale = (e)((Iterator)localObject2).next();
          String str = locale.getName().split("\\.")[0];
          if ((!str.equals(localObject1)) && (!m.this.AdM.contains(str)))
          {
            ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { locale.getName(), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", locale.lastModified() / 1000L) });
            m.this.AdL.remove(str);
            locale.delete();
          }
        }
        AppMethodBeat.o(126112);
        return;
        ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.sPs });
        AppMethodBeat.o(126112);
        return;
      }
    }
  }
  
  final class c
    implements g.b
  {
    private c() {}
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126114);
      if (m.this.AdL.containsKey(paramString))
      {
        dip localdip = (dip)m.this.AdL.get(paramString);
        localdip.FSj = paramd.field_recvedBytes;
        localdip.FSk = m.al(localdip.FSj, (int)paramd.field_fileLength);
        localdip.FRV = ((int)paramd.field_fileLength);
        m.this.AdL.put(paramString, localdip);
        ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localdip.FSk), bs.a(localdip.FSj, 100.0D) });
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
      if ((paramc != null) && (paramc.field_toltalLength > 0L) && (m.this.AdL.containsKey(paramString)))
      {
        paramd = (dip)m.this.AdL.get(paramString);
        paramd.FSj = paramc.field_finishedLength;
        paramd.FSk = m.al(paramc.field_finishedLength, paramc.field_toltalLength);
        paramd.FRV = paramc.field_toltalLength;
        m.this.AdL.put(paramString, paramd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */