package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.e;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import java.util.List;

public final class r
{
  public static String fF(List<arf> paramList)
  {
    AppMethodBeat.i(9550);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      AppMethodBeat.o(9550);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (arf)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((arf)localObject1).ZyT) {
        localStringBuffer.append("datatype='").append(((arf)localObject1).dataType).append("'");
      }
      if (((arf)localObject1).Zzv) {
        localStringBuffer.append(" datastatus='").append(((arf)localObject1).Zzu).append("'");
      }
      if (((arf)localObject1).Zzc) {
        localStringBuffer.append(" dataid='").append(((arf)localObject1).hIQ).append("'");
      }
      if (((arf)localObject1).ZzH) {
        localStringBuffer.append(" htmlid='").append(((arf)localObject1).ZzG).append("'");
      }
      if (((arf)localObject1).ZzN) {
        localStringBuffer.append(" dataillegaltype='").append(((arf)localObject1).ZzM).append("'");
      }
      if (((arf)localObject1).Zzn) {
        localStringBuffer.append(" datasourceid='").append(((arf)localObject1).Zzm).append("'");
      }
      localStringBuffer.append(">");
      if (((arf)localObject1).ZyV) {
        localStringBuffer.append("<datafmt>").append(((arf)localObject1).ZyU).append("</datafmt>");
      }
      if (((arf)localObject1).Zyz) {
        localStringBuffer.append("<datatitle>").append(Util.escapeStringForXml(((arf)localObject1).title)).append("</datatitle>");
      }
      if (((arf)localObject1).ZyA) {
        localStringBuffer.append("<datadesc>").append(Util.escapeStringForXml(((arf)localObject1).desc)).append("</datadesc>");
      }
      if (((arf)localObject1).ZyB) {
        localStringBuffer.append("<cdnthumburl>").append(Util.escapeStringForXml(((arf)localObject1).nRr)).append("</cdnthumburl>");
      }
      if (((arf)localObject1).ZyE) {
        localStringBuffer.append("<thumbwidth>").append(((arf)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((arf)localObject1).ZyF) {
        localStringBuffer.append("<thumbheight>").append(((arf)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((arf)localObject1).ZyG) {
        localStringBuffer.append("<cdndataurl>").append(Util.escapeStringForXml(((arf)localObject1).Ysw)).append("</cdndataurl>");
      }
      if (((arf)localObject1).ZyD) {
        localStringBuffer.append("<cdnthumbkey>").append(Util.escapeStringForXml(((arf)localObject1).ZyC)).append("</cdnthumbkey>");
      }
      if (((arf)localObject1).ZyI) {
        localStringBuffer.append("<cdndatakey>").append(Util.escapeStringForXml(((arf)localObject1).ZyH)).append("</cdndatakey>");
      }
      if (((arf)localObject1).ZyK) {
        localStringBuffer.append("<cdnencryver>").append(((arf)localObject1).ZyJ).append("</cdnencryver>");
      }
      if (((arf)localObject1).ZyL) {
        localStringBuffer.append("<duration>").append(((arf)localObject1).duration).append("</duration>");
      }
      if (((arf)localObject1).ZyN) {
        localStringBuffer.append("<streamweburl>").append(Util.escapeStringForXml(((arf)localObject1).ZyM)).append("</streamweburl>");
      }
      if (((arf)localObject1).ZyP) {
        localStringBuffer.append("<streamdataurl>").append(Util.escapeStringForXml(((arf)localObject1).ZyO)).append("</streamdataurl>");
      }
      if (((arf)localObject1).ZyR) {
        localStringBuffer.append("<streamlowbandurl>").append(Util.escapeStringForXml(((arf)localObject1).ZyQ)).append("</streamlowbandurl>");
      }
      if (((arf)localObject1).ZyS) {
        localStringBuffer.append("<dataext>").append(Util.escapeStringForXml(((arf)localObject1).hDd)).append("</dataext>");
      }
      if (((arf)localObject1).ZyX) {
        localStringBuffer.append("<fullmd5>").append(((arf)localObject1).ZyW).append("</fullmd5>");
      }
      if (((arf)localObject1).ZyZ) {
        localStringBuffer.append("<head256md5>").append(((arf)localObject1).ZyY).append("</head256md5>");
      }
      if (((arf)localObject1).Zzb) {
        localStringBuffer.append("<datasize>").append(((arf)localObject1).Zza).append("</datasize>");
      }
      if (((arf)localObject1).Zzh) {
        localStringBuffer.append("<thumbfullmd5>").append(((arf)localObject1).QJs).append("</thumbfullmd5>");
      }
      if (((arf)localObject1).Zzj) {
        localStringBuffer.append("<thumbhead256md5>").append(((arf)localObject1).Zzi).append("</thumbhead256md5>");
      }
      if (((arf)localObject1).Zzl) {
        localStringBuffer.append("<thumbsize>").append(((arf)localObject1).Zzk).append("</thumbsize>");
      }
      if (((arf)localObject1).Zzp) {
        localStringBuffer.append("<streamvideoid>").append(Util.escapeStringForXml(((arf)localObject1).Zzo)).append("</streamvideoid>");
      }
      if (((arf)localObject1).Zzx) {
        localStringBuffer.append("<sourcetitle>").append(Util.escapeStringForXml(((arf)localObject1).Zzw)).append("</sourcetitle>");
      }
      if (((arf)localObject1).ZzB) {
        localStringBuffer.append("<sourcename>").append(Util.escapeStringForXml(((arf)localObject1).ZzA)).append("</sourcename>");
      }
      if (((arf)localObject1).ZAa) {
        localStringBuffer.append("<sourcedesc>").append(Util.escapeStringForXml(((arf)localObject1).ZzZ)).append("</sourcedesc>");
      }
      if (((arf)localObject1).ZAc) {
        localStringBuffer.append("<sourceheadurl>").append(Util.escapeStringForXml(((arf)localObject1).ZAb)).append("</sourceheadurl>");
      }
      if (((arf)localObject1).ZzD) {
        localStringBuffer.append("<sourcetime>").append(Util.escapeStringForXml(((arf)localObject1).ZzC)).append("</sourcetime>");
      }
      if (((arf)localObject1).ZzI) {
        localStringBuffer.append("<statextstr>").append(Util.escapeStringForXml(((arf)localObject1).iah)).append("</statextstr>");
      }
      if (((arf)localObject1).ZAd) {
        localStringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(((arf)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((arf)localObject1).ZAe) {
        localStringBuffer.append("<songlyric>").append(Util.escapeStringForXml(((arf)localObject1).songLyric)).append("</songlyric>");
      }
      if (((arf)localObject1).ZzP) {
        localStringBuffer.append("<recordxml>").append(((arf)localObject1).ZzO).append("</recordxml>");
      }
      if (((arf)localObject1).pbr) {
        localStringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(((arf)localObject1).pbn)).append("</messageuuid>");
      }
      Object localObject2 = ((arf)localObject1).Zzy;
      if ((localObject2 == null) || (((arg)localObject2).ZAf == null) || (((arg)localObject2).ZAf.computeSize() == 0))
      {
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAh != null) && (((arg)localObject2).ZAh.computeSize() != 0)) {
          break label2007;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAj != null) && (((arg)localObject2).ZAj.computeSize() != 0)) {
          break label2186;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAB != null)) {
          break label2463;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAD != null)) {
          break label2479;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1433:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAN != null)) {
          break label2495;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder activity item empty");
        label1461:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAL != null)) {
          break label2511;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder topic item empty");
        label1489:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAF != null)) {
          break label2527;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder namecard item empty");
        label1517:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAH != null)) {
          break label2652;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder column item empty");
        label1545:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAz != null)) {
          break label2668;
        }
        Log.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1573:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAl != null) && (((arg)localObject2).ZAl.computeSize() != 0)) {
          break label2684;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1612:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAn != null) && (((arg)localObject2).ZAn.computeSize() != 0)) {
          break label2878;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1651:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAw != null)) {
          break label3036;
        }
        Log.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
        label1679:
        localObject1 = ((arf)localObject1).Zzy;
        if ((localObject1 != null) && (((arg)localObject1).ZAJ != null)) {
          break label3359;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, music item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((arg)localObject2).ZAf;
        if (((arh)localObject2).ZAX) {
          localStringBuffer.append("<appid>").append(((arh)localObject2).appId).append("</appid>");
        }
        if (((arh)localObject2).ZAY) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((arh)localObject2).link)).append("</link>");
        }
        if (((arh)localObject2).ZBb) {
          localStringBuffer.append("<brandid>").append(Util.escapeStringForXml(((arh)localObject2).hzi)).append("</brandid>");
        }
        if ((((arh)localObject2).ZAQ) && (((arh)localObject2).ZAU))
        {
          if (((arh)localObject2).hQQ.equals(((arh)localObject2).ZAT))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(((arh)localObject2).hQQ)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!au.bwE(((arh)localObject2).hQQ)) && (!e.Na(((arh)localObject2).ZAT))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(((arh)localObject2).ZAT)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((arh)localObject2).ZAQ)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(((arh)localObject2).hQQ)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((arh)localObject2).ZAU) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(((arh)localObject2).ZAT)).append("</realchatname></dataitemsource>");
        break label1299;
        label2007:
        localObject2 = ((arg)localObject2).ZAh;
        localStringBuffer.append("<locitem>");
        if (((arm)localObject2).ZBj) {
          localStringBuffer.append("<label>").append(Util.escapeStringForXml(((arm)localObject2).label)).append("</label>");
        }
        if (((arm)localObject2).ZBh) {
          localStringBuffer.append("<lat>").append(((arm)localObject2).lat).append("</lat>");
        }
        if (((arm)localObject2).ZBg) {
          localStringBuffer.append("<lng>").append(((arm)localObject2).lng).append("</lng>");
        }
        if (((arm)localObject2).ZBi) {
          localStringBuffer.append("<scale>").append(((arm)localObject2).hQp).append("</scale>");
        }
        if (((arm)localObject2).ZBk) {
          localStringBuffer.append("<poiname>").append(((arm)localObject2).hVI).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2186:
        Object localObject3 = ((arg)localObject2).ZAj;
        localStringBuffer.append("<weburlitem>");
        if (((ask)localObject3).ZBW) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((ask)localObject3).ZBV)).append("</link>");
        }
        if (((ask)localObject3).ZyA) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((ask)localObject3).desc)).append("</desc>");
        }
        if (((ask)localObject3).ZBq) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((ask)localObject3).thumbUrl)).append("</thumburl>");
        }
        if (((ask)localObject3).Zyz) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((ask)localObject3).title)).append("</title>");
        }
        if (((ask)localObject3).ZBY) {
          localStringBuffer.append("<opencache>").append(((ask)localObject3).ZBX).append("</opencache>");
        }
        if (((ask)localObject3).ZBZ) {
          localStringBuffer.append("<contentattr>").append(((ask)localObject3).contentattr).append("</contentattr>");
        }
        localStringBuffer.append("<forwardflag>").append(((ask)localObject3).pdq).append("</forwardflag>");
        if ((localObject2 == null) || (((arg)localObject2).WKx == null)) {
          Log.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((arg)localObject2).WKx));
        }
        label2463:
        localStringBuffer.append(q.d(((arg)localObject2).ZAB));
        break label1405;
        label2479:
        localStringBuffer.append(q.c(((arg)localObject2).ZAD));
        break label1433;
        label2495:
        localStringBuffer.append(q.b(((arg)localObject2).ZAN));
        break label1461;
        label2511:
        localStringBuffer.append(q.b(((arg)localObject2).ZAL));
        break label1489;
        label2527:
        localObject2 = ((arg)localObject2).ZAF;
        localObject3 = new StringBuilder();
        if (localObject2 != null) {
          ((StringBuilder)localObject3).append("<finderShareNameCard><username>").append(Util.escapeStringForXml(((bvk)localObject2).username)).append("</username><nickname>").append(Util.escapeStringForXml(((bvk)localObject2).nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(((bvk)localObject2).avatar)).append("</avatar><authJob>").append(Util.escapeStringForXml(((bvk)localObject2).HbX)).append("</authJob><authIcon>").append(((bvk)localObject2).HbY).append("</authIcon></finderShareNameCard>");
        }
        localStringBuffer.append(((StringBuilder)localObject3).toString());
        break label1517;
        label2652:
        localStringBuffer.append(q.b(((arg)localObject2).ZAH));
        break label1545;
        label2668:
        localStringBuffer.append(b.b(((arg)localObject2).ZAz));
        break label1573;
        label2684:
        localObject2 = ((arg)localObject2).ZAl;
        localStringBuffer.append("<productitem");
        if (((aru)localObject2).ZBs) {
          localStringBuffer.append(" type='").append(((aru)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((aru)localObject2).Zyz) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((aru)localObject2).title)).append("</title>");
        }
        if (((aru)localObject2).ZyA) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((aru)localObject2).desc)).append("</desc>");
        }
        if (((aru)localObject2).ZBq) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((aru)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((aru)localObject2).ZBr) {
          localStringBuffer.append("<productinfo>").append(Util.escapeStringForXml(((aru)localObject2).hZn)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1612;
        label2878:
        localObject2 = ((arg)localObject2).ZAn;
        localStringBuffer.append("<tvitem>");
        if (((ase)localObject2).Zyz) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((ase)localObject2).title)).append("</title>");
        }
        if (((ase)localObject2).ZyA) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((ase)localObject2).desc)).append("</desc>");
        }
        if (((ase)localObject2).ZBq) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((ase)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((ase)localObject2).ZBr) {
          localStringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(((ase)localObject2).hZn)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1651;
        label3036:
        localObject2 = ((arg)localObject2).ZAw;
        if (localObject2 == null) {
          break label1679;
        }
        localStringBuffer.append("<appbranditem>");
        localStringBuffer.append("<username>").append(Util.escapeStringForXml(((ard)localObject2).username)).append("</username>");
        localStringBuffer.append("<appid>").append(Util.escapeStringForXml(((ard)localObject2).appId)).append("</appid>");
        localStringBuffer.append("<pkgtype>").append(((ard)localObject2).hJK).append("</pkgtype>");
        localStringBuffer.append("<iconurl>").append(Util.escapeStringForXml(((ard)localObject2).iconUrl)).append("</iconurl>");
        localStringBuffer.append("<type>").append(((ard)localObject2).type).append("</type>");
        localStringBuffer.append("<pagepath>").append(Util.escapeStringForXml(((ard)localObject2).hzy)).append("</pagepath>");
        localStringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(((ard)localObject2).Zyw)).append("</sourcedisplayname>");
        localStringBuffer.append("<version>").append(((ard)localObject2).version).append("</version>");
        localStringBuffer.append("<disableforward>").append(((ard)localObject2).rxs).append("</disableforward>");
        localStringBuffer.append("<showRelievedBuyFlag>").append(((ard)localObject2).nOX).append("</showRelievedBuyFlag>");
        localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ard)localObject2).idf })).append("</messageextradata>");
        localStringBuffer.append("<subtype>").append(((ard)localObject2).subType).append("</subtype>");
        localStringBuffer.append("</appbranditem>");
        break label1679;
        label3359:
        localStringBuffer.append(cq.a(((arg)localObject1).ZAJ));
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(9550);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.r
 * JD-Core Version:    0.7.0.1
 */