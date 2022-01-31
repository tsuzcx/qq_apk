package com.tencent.mm.plugin.readerapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements d
{
  public static boolean cfj()
  {
    AppMethodBeat.i(76757);
    if ((r.Zt() & 0x400) == 0)
    {
      AppMethodBeat.o(76757);
      return true;
    }
    AppMethodBeat.o(76757);
    return false;
  }
  
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(76758);
    Object localObject3 = (String)paramc.fti;
    ab.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", new Object[] { localObject3 });
    label501:
    label504:
    for (;;)
    {
      try
      {
        localObject2 = g.cfl();
        localObject1 = ((bm)localObject2).R((String)localObject3, 20);
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          AppMethodBeat.o(76758);
          return;
        }
        paramc = (bl)((List)localObject1).get(0);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (bl)localIterator.next();
          if (((bl)localObject1).fnr != 1) {
            break label501;
          }
          paramc = (e.c)localObject1;
          break label504;
        }
        if (((bm)localObject2).fnw.delete(bm.kG(20), "reserved3=?", new String[] { localObject3 }) >= 0) {
          ((bm)localObject2).doNotify();
        }
        localObject1 = bm.pD(bm.kG(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2";
        ab.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[] { localObject1 });
        localObject3 = ((bm)localObject2).fnw.a((String)localObject1, null, 2);
        if (!((Cursor)localObject3).moveToFirst())
        {
          ((Cursor)localObject3).close();
          paramc = new ak();
          paramc.setUsername(bl.kF(20));
          paramc.setContent("");
          paramc.fK(0L);
          paramc.hL(0);
          paramc.hJ(0);
          ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a(paramc, bl.kF(20));
          AppMethodBeat.o(76758);
          return;
        }
      }
      catch (Exception paramc)
      {
        ab.e("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] Exception:%s", new Object[] { paramc });
        AppMethodBeat.o(76758);
        return;
      }
      Object localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arH(bl.kF(20));
      if (localObject1 == null)
      {
        ab.e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", new Object[] { bl.kF(20) });
        AppMethodBeat.o(76758);
        return;
      }
      Object localObject2 = new bl();
      ((bl)localObject2).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      localObject3 = new ak();
      ((ak)localObject3).setUsername(bl.kF(20));
      ((ak)localObject3).setContent(((bl)localObject2).getTitle());
      ((ak)localObject3).fK(((bl)localObject2).time);
      ((ak)localObject3).hL(0);
      if ((((au)localObject1).field_unReadCount > 0) && (paramc != null) && (((au)localObject1).field_content.equals(paramc.getTitle()))) {
        ((ak)localObject3).hJ(((au)localObject1).field_unReadCount - 1);
      }
      for (;;)
      {
        ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a((ak)localObject3, bl.kF(20));
        AppMethodBeat.o(76758);
        return;
        ((ak)localObject3).hJ(0);
      }
    }
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(76756);
    cm localcm = parama.eyJ;
    if (parama.fti == null)
    {
      parama = "fake#" + System.currentTimeMillis() / 1000L;
      ab.w("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] fake! functionMsgId:%s", new Object[] { parama });
    }
    while (localcm == null)
    {
      ab.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(76756);
      return null;
      parama = ((d.b)parama.fti).ftd;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(13440, new Object[] { Integer.valueOf(1) });
    localObject1 = g.cfl();
    localObject2 = "delete from " + bm.kG(20) + " where reserved3 = " + com.tencent.mm.cg.h.escape(parama);
    ab.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", new Object[] { localObject2 });
    if (((bm)localObject1).fnw.execSQL(bm.kG(20), (String)localObject2)) {
      ((bm)localObject1).doNotify();
    }
    localObject1 = aa.a(localcm.woR);
    long l = localcm.CreateTime;
    ab.i("MicroMsg.ReaderAppMsgExtension", "parseMsg, createTime: %s", new Object[] { Integer.valueOf(localcm.CreateTime) });
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    k = 0;
    try
    {
      localMap = br.F((String)localObject1, "mmreader");
      if (localMap == null)
      {
        AppMethodBeat.o(76756);
        return null;
      }
      i = 0;
      k = 0;
    }
    catch (Exception parama)
    {
      int i;
      for (;;)
      {
        Map localMap;
        j = k;
        i = m;
        ab.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", parama, "", new Object[0]);
        continue;
        i1 = 0;
        continue;
        i += 1;
        k = j;
        continue;
        j = k;
        continue;
        if (bo.isNullOrNil(((bl)localObject1).getUrl()))
        {
          ab.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + ((bl)localObject1).aaV() + ", type = " + ((bl)localObject1).type);
          k = 0;
          continue;
          localObject1 = ((bl)localObject3).fnn;
          continue;
          localObject1 = ((bl)localObject3).fnu;
          continue;
          localObject1 = ((bl)localObject3).fnv;
          continue;
          n = 0;
        }
      }
      ab.i("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] insertCount:%s catIdx:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
      if (m <= 0) {
        break label2855;
      }
      localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arH(bl.kF(j));
      if ((localObject1 != null) && (((au)localObject1).field_username.equals(bl.kF(j)))) {
        break label2791;
      }
      localObject2 = new ak();
      ((ak)localObject2).setUsername(bl.kF(j));
      if (parama != null) {
        break label2773;
      }
      localObject1 = "";
      ((ak)localObject2).setContent((String)localObject1);
      if (parama != null) {
        break label2782;
      }
      l = bo.aoy();
      ((ak)localObject2).fK(l);
      ((ak)localObject2).hL(0);
      ((ak)localObject2).hJ(i);
      ((j)com.tencent.mm.kernel.g.E(j.class)).YF().d((ak)localObject2);
      for (;;)
      {
        g.cfl().doNotify();
        parama = parama.getTitle();
        localObject1 = new bi();
        ((bi)localObject1).setContent(parama);
        ((bi)localObject1).kj(bl.kF(j));
        ((bi)localObject1).setType(1);
        ((bi)localObject1).setMsgId(7377812L);
        parama = new e.b((bi)localObject1, true);
        AppMethodBeat.o(76756);
        return parama;
        localObject1 = parama.getTitle();
        break;
        l = parama.time;
        break label2666;
        ((ak)localObject1).setContent(parama.getTitle());
        ((ak)localObject1).fK(parama.time);
        ((ak)localObject1).hL(0);
        ((ak)localObject1).hJ(((au)localObject1).field_unReadCount + i);
        ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a((ak)localObject1, bl.kF(j));
      }
      ab.e("MicroMsg.ReaderAppMsgExtension", "insert error");
      AppMethodBeat.o(76756);
      return null;
    }
    if (i <= 0) {
      for (;;)
      {
        try
        {
          localObject2 = new StringBuilder(".mmreader.category");
          if (i <= 0) {
            continue;
          }
          localObject1 = Integer.valueOf(i);
          localObject1 = localObject1;
          j = bo.getInt((String)localMap.get((String)localObject1 + ".$type"), 0);
          if (j != 0) {
            continue;
          }
          ab.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".$type  error");
          j = k;
          boolean bool = cfj();
          ab.d("MicroMsg.ReaderAppMsgExtension", "type = " + j + ", want to receive news? " + bool);
          parama = localArrayList.iterator();
          if (!parama.hasNext()) {
            continue;
          }
          localObject1 = (bl)parama.next();
          if (!bo.isNullOrNil(((bl)localObject1).getTitle())) {
            continue;
          }
          ab.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + ((bl)localObject1).aaV() + ", type = " + ((bl)localObject1).type);
          k = 0;
        }
        catch (Exception parama)
        {
          Object localObject3;
          Object localObject4;
          String str1;
          String str2;
          int i2;
          String str3;
          bl localbl;
          int i1;
          int j = k;
          continue;
          continue;
          continue;
          k = 1;
          continue;
          int n = 0;
          continue;
          localObject1 = ".item";
          continue;
          localObject2 = "";
          continue;
          localObject2 = localObject3;
          continue;
        }
        if ((localArrayList.size() > 0) && (k != 0))
        {
          m = 0;
          parama = null;
          k = 0;
          if (k < localArrayList.size())
          {
            localObject2 = g.cfl();
            localObject3 = (bl)localArrayList.get(k);
            if (localObject3 != null)
            {
              ((bl)localObject3).bsY = -1;
              localObject4 = new ContentValues();
              if ((((bl)localObject3).bsY & 0x1) != 0) {
                ((ContentValues)localObject4).put("tweetid", ((bl)localObject3).aaV());
              }
              if ((((bl)localObject3).bsY & 0x2) != 0) {
                ((ContentValues)localObject4).put("time", Long.valueOf(((bl)localObject3).time));
              }
              if ((((bl)localObject3).bsY & 0x4) != 0) {
                ((ContentValues)localObject4).put("type", Integer.valueOf(((bl)localObject3).type));
              }
              if ((((bl)localObject3).bsY & 0x8) != 0) {
                ((ContentValues)localObject4).put("name", ((bl)localObject3).getName());
              }
              if ((((bl)localObject3).bsY & 0x10) != 0) {
                ((ContentValues)localObject4).put("title", ((bl)localObject3).getTitle());
              }
              if ((((bl)localObject3).bsY & 0x20) != 0) {
                ((ContentValues)localObject4).put("url", ((bl)localObject3).getUrl());
              }
              if ((((bl)localObject3).bsY & 0x40) != 0) {
                ((ContentValues)localObject4).put("shorturl", ((bl)localObject3).aaW());
              }
              if ((((bl)localObject3).bsY & 0x80) != 0)
              {
                if (((bl)localObject3).fnn == null)
                {
                  localObject1 = "";
                  ((ContentValues)localObject4).put("longurl", (String)localObject1);
                }
              }
              else
              {
                if ((((bl)localObject3).bsY & 0x100) != 0) {
                  ((ContentValues)localObject4).put("pubtime", Long.valueOf(((bl)localObject3).fno));
                }
                if ((((bl)localObject3).bsY & 0x200) != 0) {
                  ((ContentValues)localObject4).put("sourcename", ((bl)localObject3).aaX());
                }
                if ((((bl)localObject3).bsY & 0x400) != 0) {
                  ((ContentValues)localObject4).put("sourceicon", ((bl)localObject3).aaY());
                }
                if ((((bl)localObject3).bsY & 0x800) != 0) {
                  ((ContentValues)localObject4).put("istop", Integer.valueOf(((bl)localObject3).fnr));
                }
                if ((((bl)localObject3).bsY & 0x1000) != 0) {
                  ((ContentValues)localObject4).put("cover", ((bl)localObject3).aaZ());
                }
                if ((((bl)localObject3).bsY & 0x2000) != 0) {
                  ((ContentValues)localObject4).put("digest", ((bl)localObject3).getDigest());
                }
                if ((((bl)localObject3).bsY & 0x4000) != 0) {
                  ((ContentValues)localObject4).put("reserved1", Integer.valueOf(((bl)localObject3).fns));
                }
                if ((((bl)localObject3).bsY & 0x8000) != 0) {
                  ((ContentValues)localObject4).put("reserved2", Long.valueOf(((bl)localObject3).fnt));
                }
                if ((((bl)localObject3).bsY & 0x10000) != 0)
                {
                  if (((bl)localObject3).fnu != null) {
                    continue;
                  }
                  localObject1 = "";
                  ((ContentValues)localObject4).put("reserved3", (String)localObject1);
                }
                if ((((bl)localObject3).bsY & 0x20000) != 0)
                {
                  if (((bl)localObject3).fnv != null) {
                    continue;
                  }
                  localObject1 = "";
                  ((ContentValues)localObject4).put("reserved4", (String)localObject1);
                }
                if ((int)((bm)localObject2).fnw.a(bm.kG(((bl)localObject3).type), "tweetid", (ContentValues)localObject4) == -1) {
                  continue;
                }
                n = 1;
                if (n == 0) {
                  continue;
                }
                if (parama != null) {
                  continue;
                }
                parama = (bl)localArrayList.get(k);
                parama.fnr = 1;
                m += 1;
                k += 1;
                continue;
                localObject1 = "";
                continue;
                if ((j != 20) && (j != 11))
                {
                  ab.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".$type  error Type:" + j);
                  j = k;
                  continue;
                }
                k = j;
                m = i;
                str1 = (String)localMap.get((String)localObject1 + ".name");
                k = j;
                m = i;
                if (bo.isNullOrNil(str1))
                {
                  k = j;
                  m = i;
                  ab.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".name  error");
                  continue;
                }
                k = j;
                m = i;
                str2 = (String)localMap.get((String)localObject1 + ".topnew.cover");
                k = j;
                m = i;
                localObject3 = (String)localMap.get((String)localObject1 + ".topnew.digest");
                k = j;
                m = i;
                i2 = bo.getInt((String)localMap.get((String)localObject1 + ".$count"), 0);
                if (i2 == 0)
                {
                  k = j;
                  m = i;
                  ab.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".$count  error");
                  continue;
                }
                if (i2 > 1)
                {
                  k = j;
                  m = i;
                  localObject2 = new StringBuilder().append((String)localObject1);
                  if (j != 20) {
                    continue;
                  }
                  localObject1 = ".newitem";
                  k = j;
                  m = i;
                  localObject1 = (String)localObject1;
                  continue;
                  if (n >= i2) {
                    continue;
                  }
                  k = j;
                  m = i;
                  localObject4 = new StringBuilder().append((String)localObject1);
                  if (n <= 0) {
                    continue;
                  }
                  k = j;
                  m = i;
                  localObject2 = Integer.valueOf(n);
                  k = j;
                  m = i;
                  str3 = localObject2;
                  k = j;
                  m = i;
                  localbl = new bl();
                  k = j;
                  m = i;
                  localbl.fnt = localcm.pIE;
                  k = j;
                  m = i;
                  localbl.title = ((String)localMap.get(str3 + ".title"));
                  if (n != 0) {
                    continue;
                  }
                  k = j;
                  m = i;
                  localbl.fnr = 1;
                  k = j;
                  m = i;
                  localbl.fjJ = str2;
                  k = j;
                  m = i;
                  if (!bo.isNullOrNil((String)localObject3)) {
                    continue;
                  }
                  k = j;
                  m = i;
                  localObject2 = (String)localMap.get(str3 + ".digest");
                  k = j;
                  m = i;
                }
                for (localbl.fjL = ((String)localObject2);; localbl.fjL = ((String)localMap.get(str3 + ".digest")))
                {
                  k = j;
                  m = i;
                  if (!localMap.containsKey(str3 + ".vedio")) {
                    break label2433;
                  }
                  i1 = 1;
                  k = j;
                  m = i;
                  localbl.fns = i1;
                  k = j;
                  m = i;
                  localbl.url = ((String)localMap.get(str3 + ".url"));
                  k = j;
                  m = i;
                  localbl.fnm = ((String)localMap.get(str3 + ".shorturl"));
                  k = j;
                  m = i;
                  localbl.fnn = ((String)localMap.get(str3 + ".longurl"));
                  k = j;
                  m = i;
                  localbl.fno = bo.getLong((String)localMap.get(str3 + ".pub_time"), 0L);
                  k = j;
                  m = i;
                  localObject4 = (String)localMap.get(str3 + ".tweetid");
                  if (localObject4 != null)
                  {
                    localObject2 = localObject4;
                    k = j;
                    m = i;
                    if (!"".equals(localObject4)) {}
                  }
                  else
                  {
                    k = j;
                    m = i;
                    localObject2 = new Date(System.currentTimeMillis() + n);
                    k = j;
                    m = i;
                    localObject2 = "N" + localSimpleDateFormat.format((Date)localObject2);
                    k = j;
                    m = i;
                    ab.i("MicroMsg.ReaderAppMsgExtension", "create tweetID = ".concat(String.valueOf(localObject2)));
                  }
                  k = j;
                  m = i;
                  localbl.fnl = ((String)localObject2);
                  k = j;
                  m = i;
                  localbl.fnp = ((String)localMap.get(str3 + ".sources.source.name"));
                  k = j;
                  m = i;
                  localbl.fnq = ((String)localMap.get(str3 + ".sources.source.icon"));
                  k = j;
                  m = i;
                  localbl.time = (i + l * 1000L);
                  k = j;
                  m = i;
                  localbl.type = j;
                  k = j;
                  m = i;
                  localbl.name = str1;
                  k = j;
                  m = i;
                  localbl.fnu = parama;
                  k = j;
                  m = i;
                  localArrayList.add(localbl);
                  n += 1;
                  break;
                  k = j;
                  m = i;
                  localObject1 = (String)localObject1 + ".item";
                  break label2896;
                  k = j;
                  m = i;
                  localbl.fjJ = ((String)localMap.get(str3 + ".cover"));
                  k = j;
                  m = i;
                }
              }
            }
          }
        }
      }
    }
    label2433:
    label2666:
    AppMethodBeat.o(76756);
    label2773:
    label2782:
    label2791:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.c
 * JD-Core Version:    0.7.0.1
 */