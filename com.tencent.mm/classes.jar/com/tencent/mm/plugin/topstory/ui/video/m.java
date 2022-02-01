package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int ABn;
  b BtO;
  String Bvv;
  Map<String, doe> Bvw;
  Set<String> Bvx;
  
  public m()
  {
    AppMethodBeat.i(126116);
    this.ABn = 0;
    this.Bvw = Collections.synchronizedMap(new HashMap());
    this.Bvx = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(126116);
  }
  
  static long ao(long paramLong1, long paramLong2)
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
    this.ABn += 1;
    ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.ABn) });
    this.BtO = paramb;
    this.Bvv = h.aCM(paramb.epz().qXu);
    AppMethodBeat.o(126117);
  }
  
  public final void equ()
  {
    AppMethodBeat.i(126119);
    Iterator localIterator = this.Bvx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f.aGI().EQ(str);
    }
    AppMethodBeat.o(126119);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126118);
    this.ABn -= 1;
    ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ABn) });
    if (this.ABn <= 0)
    {
      equ();
      this.Bvx.clear();
      com.tencent.mm.sdk.g.b.c(new m.b(this, this.Bvv), "TopStory.DeleteVideoFolderTask");
      this.BtO = null;
    }
    AppMethodBeat.o(126118);
  }
  
  final class a
    implements Runnable
  {
    private String tLW;
    
    a(String paramString)
    {
      this.tLW = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(126112);
      Object localObject1 = new e(this.tLW);
      Object localObject2;
      if (((e)localObject1).exists())
      {
        localObject1 = ((e)localObject1).fOM();
        int j = m.this.Bvx.size();
        int k = m.this.Bvw.size();
        if (localObject1 != null) {}
        for (int i = localObject1.length;; i = 0)
        {
          ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.tLW });
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
        ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { i.formatTime("yyyy-MM-dd HH:mm:ss", ((e)((List)localObject2).get(0)).lastModified() / 1000L), i.formatTime("yyyy-MM-dd HH:mm:ss", ((e)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
        localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
        if (m.this.BtO == null) {
          break label478;
        }
        localObject1 = m.this.BtO.epB().BrC;
        if (localObject1 == null) {
          break label478;
        }
      }
      label448:
      label478:
      for (localObject1 = com.tencent.mm.plugin.topstory.ui.d.bs(((dod)localObject1).tSk, ((dod)localObject1).HCu);; localObject1 = "")
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          e locale = (e)((Iterator)localObject2).next();
          String str = locale.getName().split("\\.")[0];
          if ((!str.equals(localObject1)) && (!m.this.Bvx.contains(str)))
          {
            ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { locale.getName(), i.formatTime("yyyy-MM-dd HH:mm:ss", locale.lastModified() / 1000L) });
            m.this.Bvw.remove(str);
            locale.delete();
          }
        }
        AppMethodBeat.o(126112);
        return;
        ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.tLW });
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
      if (m.this.Bvw.containsKey(paramString))
      {
        doe localdoe = (doe)m.this.Bvw.get(paramString);
        localdoe.HCP = paramd.field_recvedBytes;
        localdoe.HCQ = m.ao(localdoe.HCP, (int)paramd.field_fileLength);
        localdoe.HCB = ((int)paramd.field_fileLength);
        m.this.Bvw.put(paramString, localdoe);
        ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localdoe.HCQ), bt.a(localdoe.HCP, 100.0D) });
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
      if ((paramc != null) && (paramc.field_toltalLength > 0L) && (m.this.Bvw.containsKey(paramString)))
      {
        paramd = (doe)m.this.Bvw.get(paramString);
        paramd.HCP = paramc.field_finishedLength;
        paramd.HCQ = m.ao(paramc.field_finishedLength, paramc.field_toltalLength);
        paramd.HCB = paramc.field_toltalLength;
        m.this.Bvw.put(paramString, paramd);
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