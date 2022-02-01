package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.c.an;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.webcanvas.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Calendar;
import kotlin.g.b.p;

final class ab$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(205417);
    ab.hxh();
    r localr = r.VcW;
    if (r.hvM())
    {
      Object localObject1;
      Object localObject2;
      Object localObject4;
      long l1;
      if (r.hvM())
      {
        if (ab.hxl()) {
          break label378;
        }
        if (!r.hvQ()) {
          break label368;
        }
        localObject1 = af.bjB();
        localObject2 = String.format("DELETE FROM %s WHERE type = %d and isRead = 1 and createTime < %d", new Object[] { "BizTimeLineInfo", Integer.valueOf(637534257), Long.valueOf(bq.beS() - 86400000L) });
        Log.d("MicroMsg.BizTimeLineInfoStorage", "deleteExposedAdMsgByType ret:%b, sql=%s", new Object[] { Boolean.valueOf(((aa)localObject1).lvy.execSQL("BizTimeLineInfo", (String)localObject2)), localObject2 });
        localObject2 = new aa.a();
        ((aa.a)localObject2).VeB = aa.b.VeE;
        ((aa)localObject1).a((aa.a)localObject2);
        localObject1 = l.PuB;
        l.Tt(29L);
        localObject4 = r.hvJ().decodeString(r.buZ("biz_ad_card_data"));
        localObject2 = r.hwb();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!r.cr(((z)localObject2).hwM()))
          {
            af.bjB().UI(((z)localObject2).field_msgId);
            r.bvd(((z)localObject2).hwO());
            Log.i("MicroMsg.BizCardLogic", "insertAd delete expire ad aid=" + ((z)localObject2).hwO());
            localObject1 = null;
          }
        }
        if (r.cr(r.bvb((String)localObject4))) {
          break label495;
        }
        Log.w("MicroMsg.BizCardLogic", "insertAd ad data invalid");
        if (!Util.isNullOrNil((String)localObject4))
        {
          r.hvJ().encode(r.buZ("biz_ad_card_data"), "");
          localObject2 = l.PuB;
          l.Tt(102L);
        }
        localObject2 = l.PuB;
        l.Tt(30L);
        if (localObject1 != null)
        {
          localObject2 = r.VcW;
          l1 = r.Us(((z)localObject1).field_orderFlag);
          if ((((z)localObject1).field_orderFlag != l1) && (l1 > 0L)) {
            break label389;
          }
        }
      }
      label389:
      label801:
      label1080:
      label1089:
      for (;;)
      {
        label495:
        if (r.hvQ())
        {
          ((c)com.tencent.mm.kernel.h.ae(c.class)).n("wxa06c02b5c00ff39b", null, "bizBoxClick", null);
          AppMethodBeat.o(205417);
          return;
          label368:
          af.bjB().asr(1);
          break;
          label378:
          if (localr.hvO())
          {
            break;
            ((z)localObject1).field_orderFlag = l1;
            localObject2 = l.PuB;
            l.Tt(36L);
            r.VcW.B((z)localObject1);
            boolean bool = af.bjB().d((z)localObject1, true);
            Log.i("MicroMsg.BizCardLogic", "insertAd updateById result: " + bool + ", msgId:" + ((z)localObject1).field_msgId + " orderFlag:" + ((z)localObject1).field_orderFlag + " aid: " + ((z)localObject1).hwO());
            continue;
            localObject2 = af.bjB();
            p.j(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
            localObject2 = ((aa)localObject2).hwU();
            if (localObject2 == null)
            {
              Log.i("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
            }
            else
            {
              Object localObject3 = af.bjB();
              p.j(localObject3, "SubCoreBiz.getBizTimeLineInfoStorage()");
              int i = ((aa)localObject3).dpe();
              if (i <= 3)
              {
                Log.i("MicroMsg.BizCardLogic", "insertAd return for: msgCount = ".concat(String.valueOf(i)));
              }
              else
              {
                localObject3 = l.PuB;
                l.Tt(31L);
                com.tencent.mm.plugin.report.service.h.IzE.a(20636, new Object[] { "", "", Integer.valueOf(4) });
                localObject3 = af.bjB();
                p.j(localObject3, "SubCoreBiz.getBizTimeLineInfoStorage()");
                l1 = ((aa)localObject3).hxb();
                localObject3 = new z();
                ((z)localObject3).field_content = ((String)localObject4);
                ((z)localObject3).field_type = 637534257;
                if ((r.hvR()) && (!localr.hvO()) && (af.bjB().UK(l1 << 32) != null))
                {
                  Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a recCard", new Object[] { Long.valueOf(l1) });
                  com.tencent.mm.plugin.report.service.h.IzE.a(20636, new Object[] { ((z)localObject3).hwO(), ((z)localObject3).getTraceId(), Integer.valueOf(1) });
                  localObject1 = l.PuB;
                  l.Tt(34L);
                }
                else
                {
                  int j;
                  int k;
                  if (localObject1 != null)
                  {
                    localObject4 = l.PuB;
                    l.Tt(37L);
                    af.bjB().asr(0);
                    localObject4 = r.VcW;
                    r.bvd(((z)localObject1).hwO());
                    i = 1;
                    Log.d("MicroMsg.BizCardLogic", "insertAd delete un expose ad");
                    if (localr.hvO()) {
                      break label1089;
                    }
                    localObject1 = af.bjC();
                    localObject4 = Calendar.getInstance();
                    p.j(localObject4, "Calendar.getInstance()");
                    ((Calendar)localObject4).setTimeInMillis(System.currentTimeMillis());
                    ((Calendar)localObject4).set(11, 0);
                    ((Calendar)localObject4).set(13, 0);
                    ((Calendar)localObject4).set(12, 0);
                    ((Calendar)localObject4).set(14, 0);
                    long l2 = ((Calendar)localObject4).getTimeInMillis();
                    localObject4 = "SELECT count(*) FROM BizAdInfo where exposeTime > ".concat(String.valueOf(l2));
                    localObject1 = ((q)localObject1).lvy.rawQuery((String)localObject4, null);
                    j = 0;
                    if (((Cursor)localObject1).moveToFirst()) {
                      j = ((Cursor)localObject1).getInt(0);
                    }
                    ((Cursor)localObject1).close();
                    Log.d("MicroMsg.BizAdInfoStorage", "getAdCardCount count=" + j + ", beginTime=" + l2);
                    k = r.VcC;
                    if (1 <= k) {
                      break label1080;
                    }
                  }
                  for (;;)
                  {
                    r.VcC = r.hvJ().decodeInt("biz_card_max_ad_count", 1);
                    k = r.VcC;
                    if ((1 > k) || (10 < k)) {
                      r.VcC = 1;
                    }
                    do
                    {
                      if (j < r.VcC) {
                        break label1195;
                      }
                      Log.i("MicroMsg.BizCardLogic", "insertAd too much ad count=".concat(String.valueOf(j)));
                      localObject1 = l.PuB;
                      l.Tt(32L);
                      com.tencent.mm.plugin.report.service.h.IzE.a(20636, new Object[] { ((z)localObject3).hwO(), ((z)localObject3).getTraceId(), Integer.valueOf(3) });
                      break;
                      i = 0;
                      break label801;
                    } while (10 >= k);
                  }
                  Log.i("MicroMsg.BizCardLogic", "insertAd delete all ad msg");
                  localObject1 = af.bjB();
                  localObject4 = String.format("DELETE FROM %s WHERE %s = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257) });
                  Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(((aa)localObject1).lvy.execSQL("BizTimeLineInfo", (String)localObject4)) });
                  localObject4 = new aa.a();
                  ((aa.a)localObject4).VeB = aa.b.VeE;
                  ((aa)localObject1).a((aa.a)localObject4);
                  localObject1 = af.bjB();
                  localObject4 = "SELECT * FROM BizTimeLineInfo where type=637534257 and orderFlag > ".concat(String.valueOf(l1 << 32));
                  localObject4 = ((aa)localObject1).lvy.rawQuery((String)localObject4, null);
                  localObject1 = null;
                  if (((Cursor)localObject4).moveToFirst())
                  {
                    localObject1 = new z();
                    ((z)localObject1).convertFrom((Cursor)localObject4);
                  }
                  ((Cursor)localObject4).close();
                  if (localObject1 != null)
                  {
                    Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a adCard", new Object[] { Long.valueOf(l1) });
                    com.tencent.mm.plugin.report.service.h.IzE.a(20636, new Object[] { ((z)localObject3).hwO(), ((z)localObject3).getTraceId(), Integer.valueOf(2) });
                    localObject1 = l.PuB;
                    l.Tt(33L);
                  }
                  else
                  {
                    ((z)localObject3).field_msgId = af.bjB().hxf();
                    ((z)localObject3).field_msgSvrId = 0L;
                    ((z)localObject3).field_talker = "";
                    ((z)localObject3).field_talkerId = 0;
                    ((z)localObject3).field_hasShow = 1;
                    ((z)localObject3).field_createTime = bq.beS();
                    if (((z)localObject2).hwC()) {}
                    for (l1 = ((an)localObject2).hxA;; l1 = ((z)localObject2).field_createTime)
                    {
                      ((an)localObject3).hxA = l1;
                      ((an)localObject3).hwY = true;
                      ((z)localObject3).pp(1);
                      ((z)localObject3).field_status = 3;
                      ((z)localObject3).field_orderFlag = r.Us(0L);
                      if (((z)localObject3).field_orderFlag <= 0L) {
                        break;
                      }
                      r.VcE = null;
                      r.hvJ().encode(r.buZ("biz_ad_card_data"), "");
                      localr.B((z)localObject3);
                      bool = af.bjB().F((z)localObject3);
                      Log.i("MicroMsg.BizCardLogic", "insertAd result: " + bool + ", msgId:" + ((z)localObject3).field_msgId + " orderFlag:" + ((z)localObject3).field_orderFlag + " aid: " + ((z)localObject3).hwO());
                      com.tencent.mm.plugin.report.service.h.IzE.a(20636, new Object[] { ((z)localObject3).hwO(), ((z)localObject3).getTraceId(), Integer.valueOf(0) });
                      localObject1 = l.PuB;
                      l.Tt(35L);
                      if (i == 0)
                      {
                        localObject1 = l.PuB;
                        l.Tt(38L);
                      }
                      if (!bool) {
                        break;
                      }
                      af.bjC().buY(((z)localObject3).hwO());
                      break;
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1195:
      r.fKR();
    }
    AppMethodBeat.o(205417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ab.2
 * JD-Core Version:    0.7.0.1
 */