package com.tencent.mm.plugin.readerapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.b;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  public static boolean buX()
  {
    return (q.Gp() & 0x400) == 0;
  }
  
  public final void a(e.c paramc)
  {
    Object localObject3 = (String)paramc.ecW;
    y.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", new Object[] { localObject3 });
    Object localObject2 = g.buZ();
    Object localObject1 = ((com.tencent.mm.model.bk)localObject2).J((String)localObject3, 20);
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      return;
    }
    paramc = (bj)((List)localObject1).get(0);
    Iterator localIterator = ((List)localObject1).iterator();
    if (localIterator.hasNext())
    {
      localObject1 = (bj)localIterator.next();
      if (((bj)localObject1).dXj != 1) {
        break label430;
      }
      paramc = (e.c)localObject1;
    }
    label430:
    for (;;)
    {
      break;
      if (((com.tencent.mm.model.bk)localObject2).dXo.delete(com.tencent.mm.model.bk.hT(20), "reserved3=?", new String[] { localObject3 }) >= 0) {
        ((com.tencent.mm.model.bk)localObject2).doNotify();
      }
      localObject1 = com.tencent.mm.model.bk.iP(com.tencent.mm.model.bk.hT(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2";
      y.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[] { localObject1 });
      localObject3 = ((com.tencent.mm.model.bk)localObject2).dXo.a((String)localObject1, null, 2);
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        paramc = new ak();
        paramc.setUsername(bj.hS(20));
        paramc.setContent("");
        paramc.ba(0L);
        paramc.fA(0);
        paramc.fy(0);
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(paramc, bj.hS(20));
        return;
      }
      localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(bj.hS(20));
      localObject2 = new bj();
      ((bj)localObject2).d((Cursor)localObject3);
      ((Cursor)localObject3).close();
      localObject3 = new ak();
      ((ak)localObject3).setUsername(bj.hS(20));
      ((ak)localObject3).setContent(((bj)localObject2).getTitle());
      ((ak)localObject3).ba(((bj)localObject2).time);
      ((ak)localObject3).fA(0);
      if ((((as)localObject1).field_unReadCount > 0) && (paramc != null) && (((as)localObject1).field_content.equals(paramc.getTitle()))) {
        ((ak)localObject3).fy(((as)localObject1).field_unReadCount - 1);
      }
      for (;;)
      {
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a((ak)localObject3, bj.hS(20));
        return;
        ((ak)localObject3).fy(0);
      }
    }
  }
  
  public final e.b b(e.a parama)
  {
    cd localcd = parama.dBs;
    if (parama.ecW == null)
    {
      parama = "fake#" + System.currentTimeMillis() / 1000L;
      y.w("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] fake! functionMsgId:%s", new Object[] { parama });
    }
    while (localcd == null)
    {
      y.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
      return null;
      parama = ((d.b)parama.ecW).ecR;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(13440, new Object[] { Integer.valueOf(1) });
    localObject1 = g.buZ();
    localObject2 = "delete from " + com.tencent.mm.model.bk.hT(20) + " where reserved3 = " + com.tencent.mm.cf.h.fA(parama);
    y.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", new Object[] { localObject2 });
    if (((com.tencent.mm.model.bk)localObject1).dXo.gk(com.tencent.mm.model.bk.hT(20), (String)localObject2)) {
      ((com.tencent.mm.model.bk)localObject1).doNotify();
    }
    localObject1 = aa.a(localcd.svH);
    long l = localcd.mPL;
    y.d("MicroMsg.ReaderAppMsgExtension", "parseMsg, createTime: %s, content: %s", new Object[] { Integer.valueOf(localcd.mPL), localObject1 });
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    k = 0;
    try
    {
      localMap = bn.s((String)localObject1, "mmreader");
      if (localMap == null) {
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
        label2321:
        j = k;
        i = m;
        y.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", parama, "", new Object[0]);
        continue;
        label2430:
        i1 = 0;
        continue;
        label2436:
        i += 1;
        k = j;
        continue;
        j = k;
        continue;
        if (com.tencent.mm.sdk.platformtools.bk.bl(((bj)localObject1).getUrl()))
        {
          y.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + ((bj)localObject1).HW() + ", type = " + ((bj)localObject1).type);
          k = 0;
          continue;
          localObject1 = ((bj)localObject3).dXf;
          continue;
          localObject1 = ((bj)localObject3).dXm;
          continue;
          localObject1 = ((bj)localObject3).dXn;
          continue;
          n = 0;
        }
      }
      y.i("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] insertCount:%s catIdx:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
      if (m <= 0) {
        break label2845;
      }
      localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(bj.hS(j));
      if ((localObject1 != null) && (((as)localObject1).field_username.equals(bj.hS(j)))) {
        break label2781;
      }
      localObject2 = new ak();
      ((ak)localObject2).setUsername(bj.hS(j));
      if (parama != null) {
        break label2763;
      }
      localObject1 = "";
      ((ak)localObject2).setContent((String)localObject1);
      if (parama != null) {
        break label2772;
      }
      l = com.tencent.mm.sdk.platformtools.bk.UY();
      label2663:
      ((ak)localObject2).ba(l);
      ((ak)localObject2).fA(0);
      ((ak)localObject2).fy(i);
      ((j)com.tencent.mm.kernel.g.r(j.class)).FB().d((ak)localObject2);
      for (;;)
      {
        g.buZ().doNotify();
        parama = parama.getTitle();
        localObject1 = new bi();
        ((bi)localObject1).setContent(parama);
        ((bi)localObject1).ec(bj.hS(j));
        ((bi)localObject1).setType(1);
        ((bi)localObject1).setMsgId(7377812L);
        return new e.b((bi)localObject1, true);
        label2763:
        localObject1 = parama.getTitle();
        break;
        label2772:
        l = parama.time;
        break label2663;
        label2781:
        ((ak)localObject1).setContent(parama.getTitle());
        ((ak)localObject1).ba(parama.time);
        ((ak)localObject1).fA(0);
        ((ak)localObject1).fy(((as)localObject1).field_unReadCount + i);
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a((ak)localObject1, bj.hS(j));
      }
      label2845:
      y.e("MicroMsg.ReaderAppMsgExtension", "insert error");
      return null;
    }
    if (i <= 0)
    {
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
          j = com.tencent.mm.sdk.platformtools.bk.getInt((String)localMap.get((String)localObject1 + ".$type"), 0);
          if (j != 0) {
            continue;
          }
          y.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".$type  error");
          j = k;
          boolean bool = buX();
          y.d("MicroMsg.ReaderAppMsgExtension", "type = " + j + ", want to receive news? " + bool);
          parama = localArrayList.iterator();
          if (!parama.hasNext()) {
            continue;
          }
          localObject1 = (bj)parama.next();
          if (!com.tencent.mm.sdk.platformtools.bk.bl(((bj)localObject1).getTitle())) {
            continue;
          }
          y.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + ((bj)localObject1).HW() + ", type = " + ((bj)localObject1).type);
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
          bj localbj;
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
        if ((localArrayList.size() <= 0) || (k == 0)) {
          continue;
        }
        m = 0;
        parama = null;
        k = 0;
        if (k >= localArrayList.size()) {
          continue;
        }
        localObject2 = g.buZ();
        localObject3 = (bj)localArrayList.get(k);
        if (localObject3 == null) {
          continue;
        }
        ((bj)localObject3).bcw = -1;
        localObject4 = new ContentValues();
        if ((((bj)localObject3).bcw & 0x1) != 0) {
          ((ContentValues)localObject4).put("tweetid", ((bj)localObject3).HW());
        }
        if ((((bj)localObject3).bcw & 0x2) != 0) {
          ((ContentValues)localObject4).put("time", Long.valueOf(((bj)localObject3).time));
        }
        if ((((bj)localObject3).bcw & 0x4) != 0) {
          ((ContentValues)localObject4).put("type", Integer.valueOf(((bj)localObject3).type));
        }
        if ((((bj)localObject3).bcw & 0x8) != 0) {
          ((ContentValues)localObject4).put("name", ((bj)localObject3).getName());
        }
        if ((((bj)localObject3).bcw & 0x10) != 0) {
          ((ContentValues)localObject4).put("title", ((bj)localObject3).getTitle());
        }
        if ((((bj)localObject3).bcw & 0x20) != 0) {
          ((ContentValues)localObject4).put("url", ((bj)localObject3).getUrl());
        }
        if ((((bj)localObject3).bcw & 0x40) != 0) {
          ((ContentValues)localObject4).put("shorturl", ((bj)localObject3).HX());
        }
        if ((((bj)localObject3).bcw & 0x80) != 0)
        {
          if (((bj)localObject3).dXf != null) {
            continue;
          }
          localObject1 = "";
          ((ContentValues)localObject4).put("longurl", (String)localObject1);
        }
        if ((((bj)localObject3).bcw & 0x100) != 0) {
          ((ContentValues)localObject4).put("pubtime", Long.valueOf(((bj)localObject3).dXg));
        }
        if ((((bj)localObject3).bcw & 0x200) != 0) {
          ((ContentValues)localObject4).put("sourcename", ((bj)localObject3).HY());
        }
        if ((((bj)localObject3).bcw & 0x400) != 0) {
          ((ContentValues)localObject4).put("sourceicon", ((bj)localObject3).HZ());
        }
        if ((((bj)localObject3).bcw & 0x800) != 0) {
          ((ContentValues)localObject4).put("istop", Integer.valueOf(((bj)localObject3).dXj));
        }
        if ((((bj)localObject3).bcw & 0x1000) != 0) {
          ((ContentValues)localObject4).put("cover", ((bj)localObject3).Ia());
        }
        if ((((bj)localObject3).bcw & 0x2000) != 0) {
          ((ContentValues)localObject4).put("digest", ((bj)localObject3).getDigest());
        }
        if ((((bj)localObject3).bcw & 0x4000) != 0) {
          ((ContentValues)localObject4).put("reserved1", Integer.valueOf(((bj)localObject3).dXk));
        }
        if ((((bj)localObject3).bcw & 0x8000) != 0) {
          ((ContentValues)localObject4).put("reserved2", Long.valueOf(((bj)localObject3).dXl));
        }
        if ((((bj)localObject3).bcw & 0x10000) != 0)
        {
          if (((bj)localObject3).dXm != null) {
            continue;
          }
          localObject1 = "";
          ((ContentValues)localObject4).put("reserved3", (String)localObject1);
        }
        if ((((bj)localObject3).bcw & 0x20000) != 0)
        {
          if (((bj)localObject3).dXn != null) {
            continue;
          }
          localObject1 = "";
          ((ContentValues)localObject4).put("reserved4", (String)localObject1);
        }
        if ((int)((com.tencent.mm.model.bk)localObject2).dXo.insert(com.tencent.mm.model.bk.hT(((bj)localObject3).type), "tweetid", (ContentValues)localObject4) == -1) {
          continue;
        }
        n = 1;
        if (n == 0) {
          continue;
        }
        if (parama != null) {
          continue;
        }
        parama = (bj)localArrayList.get(k);
        parama.dXj = 1;
        m += 1;
        k += 1;
        continue;
        localObject1 = "";
        continue;
        if ((j != 20) && (j != 11))
        {
          y.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".$type  error Type:" + j);
          j = k;
        }
        else
        {
          k = j;
          m = i;
          str1 = (String)localMap.get((String)localObject1 + ".name");
          k = j;
          m = i;
          if (com.tencent.mm.sdk.platformtools.bk.bl(str1))
          {
            k = j;
            m = i;
            y.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".name  error");
          }
          else
          {
            k = j;
            m = i;
            str2 = (String)localMap.get((String)localObject1 + ".topnew.cover");
            k = j;
            m = i;
            localObject3 = (String)localMap.get((String)localObject1 + ".topnew.digest");
            k = j;
            m = i;
            i2 = com.tencent.mm.sdk.platformtools.bk.getInt((String)localMap.get((String)localObject1 + ".$count"), 0);
            if (i2 != 0) {
              continue;
            }
            k = j;
            m = i;
            y.e("MicroMsg.ReaderAppMsgExtension", "get " + (String)localObject1 + ".$count  error");
          }
        }
      }
      if (i2 > 1)
      {
        k = j;
        m = i;
        localObject2 = new StringBuilder().append((String)localObject1);
        if (j != 20) {
          break label2882;
        }
        localObject1 = ".newitem";
        k = j;
        m = i;
        localObject1 = (String)localObject1;
        break label2876;
        if (n >= i2) {
          break label2436;
        }
        k = j;
        m = i;
        localObject4 = new StringBuilder().append((String)localObject1);
        if (n <= 0) {
          break label2890;
        }
        k = j;
        m = i;
        localObject2 = Integer.valueOf(n);
        k = j;
        m = i;
        str3 = localObject2;
        k = j;
        m = i;
        localbj = new bj();
        k = j;
        m = i;
        localbj.dXl = localcd.ndm;
        k = j;
        m = i;
        localbj.title = ((String)localMap.get(str3 + ".title"));
        if (n != 0) {
          break label2321;
        }
        k = j;
        m = i;
        localbj.dXj = 1;
        k = j;
        m = i;
        localbj.dTD = str2;
        k = j;
        m = i;
        if (!com.tencent.mm.sdk.platformtools.bk.bl((String)localObject3)) {
          break label2897;
        }
        k = j;
        m = i;
        localObject2 = (String)localMap.get(str3 + ".digest");
        k = j;
        m = i;
      }
      for (localbj.dTF = ((String)localObject2);; localbj.dTF = ((String)localMap.get(str3 + ".digest")))
      {
        k = j;
        m = i;
        if (!localMap.containsKey(str3 + ".vedio")) {
          break label2430;
        }
        i1 = 1;
        k = j;
        m = i;
        localbj.dXk = i1;
        k = j;
        m = i;
        localbj.url = ((String)localMap.get(str3 + ".url"));
        k = j;
        m = i;
        localbj.dXe = ((String)localMap.get(str3 + ".shorturl"));
        k = j;
        m = i;
        localbj.dXf = ((String)localMap.get(str3 + ".longurl"));
        k = j;
        m = i;
        localbj.dXg = com.tencent.mm.sdk.platformtools.bk.getLong((String)localMap.get(str3 + ".pub_time"), 0L);
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
          y.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = " + (String)localObject2);
        }
        k = j;
        m = i;
        localbj.dXd = ((String)localObject2);
        k = j;
        m = i;
        localbj.dXh = ((String)localMap.get(str3 + ".sources.source.name"));
        k = j;
        m = i;
        localbj.dXi = ((String)localMap.get(str3 + ".sources.source.icon"));
        k = j;
        m = i;
        localbj.time = (i + l * 1000L);
        k = j;
        m = i;
        localbj.type = j;
        k = j;
        m = i;
        localbj.name = str1;
        k = j;
        m = i;
        localbj.dXm = parama;
        k = j;
        m = i;
        localArrayList.add(localbj);
        n += 1;
        break;
        k = j;
        m = i;
        localObject1 = (String)localObject1 + ".item";
        break label2876;
        k = j;
        m = i;
        localbj.dTD = ((String)localMap.get(str3 + ".cover"));
        k = j;
        m = i;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.c
 * JD-Core Version:    0.7.0.1
 */