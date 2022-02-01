package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.List;

public final class q
{
  public static String dE(List<aml> paramList)
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
      Object localObject1 = (aml)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((aml)localObject1).LvB) {
        localStringBuffer.append("datatype='").append(((aml)localObject1).dataType).append("'");
      }
      if (((aml)localObject1).Lwe) {
        localStringBuffer.append(" datastatus='").append(((aml)localObject1).Lwd).append("'");
      }
      if (((aml)localObject1).LvK) {
        localStringBuffer.append(" dataid='").append(((aml)localObject1).dLl).append("'");
      }
      if (((aml)localObject1).Lwq) {
        localStringBuffer.append(" htmlid='").append(((aml)localObject1).Lwp).append("'");
      }
      if (((aml)localObject1).Lww) {
        localStringBuffer.append(" dataillegaltype='").append(((aml)localObject1).Lwv).append("'");
      }
      if (((aml)localObject1).LvW) {
        localStringBuffer.append(" datasourceid='").append(((aml)localObject1).LvV).append("'");
      }
      localStringBuffer.append(">");
      if (((aml)localObject1).LvD) {
        localStringBuffer.append("<datafmt>").append(((aml)localObject1).LvC).append("</datafmt>");
      }
      if (((aml)localObject1).Lvh) {
        localStringBuffer.append("<datatitle>").append(Util.escapeStringForXml(((aml)localObject1).title)).append("</datatitle>");
      }
      if (((aml)localObject1).Lvi) {
        localStringBuffer.append("<datadesc>").append(Util.escapeStringForXml(((aml)localObject1).desc)).append("</datadesc>");
      }
      if (((aml)localObject1).Lvj) {
        localStringBuffer.append("<cdnthumburl>").append(Util.escapeStringForXml(((aml)localObject1).iwX)).append("</cdnthumburl>");
      }
      if (((aml)localObject1).Lvm) {
        localStringBuffer.append("<thumbwidth>").append(((aml)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((aml)localObject1).Lvn) {
        localStringBuffer.append("<thumbheight>").append(((aml)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((aml)localObject1).Lvo) {
        localStringBuffer.append("<cdndataurl>").append(Util.escapeStringForXml(((aml)localObject1).KuR)).append("</cdndataurl>");
      }
      if (((aml)localObject1).Lvl) {
        localStringBuffer.append("<cdnthumbkey>").append(Util.escapeStringForXml(((aml)localObject1).Lvk)).append("</cdnthumbkey>");
      }
      if (((aml)localObject1).Lvq) {
        localStringBuffer.append("<cdndatakey>").append(Util.escapeStringForXml(((aml)localObject1).Lvp)).append("</cdndatakey>");
      }
      if (((aml)localObject1).Lvs) {
        localStringBuffer.append("<cdnencryver>").append(((aml)localObject1).Lvr).append("</cdnencryver>");
      }
      if (((aml)localObject1).Lvt) {
        localStringBuffer.append("<duration>").append(((aml)localObject1).duration).append("</duration>");
      }
      if (((aml)localObject1).Lvv) {
        localStringBuffer.append("<streamweburl>").append(Util.escapeStringForXml(((aml)localObject1).Lvu)).append("</streamweburl>");
      }
      if (((aml)localObject1).Lvx) {
        localStringBuffer.append("<streamdataurl>").append(Util.escapeStringForXml(((aml)localObject1).Lvw)).append("</streamdataurl>");
      }
      if (((aml)localObject1).Lvz) {
        localStringBuffer.append("<streamlowbandurl>").append(Util.escapeStringForXml(((aml)localObject1).Lvy)).append("</streamlowbandurl>");
      }
      if (((aml)localObject1).LvA) {
        localStringBuffer.append("<dataext>").append(Util.escapeStringForXml(((aml)localObject1).dFN)).append("</dataext>");
      }
      if (((aml)localObject1).LvF) {
        localStringBuffer.append("<fullmd5>").append(((aml)localObject1).LvE).append("</fullmd5>");
      }
      if (((aml)localObject1).LvH) {
        localStringBuffer.append("<head256md5>").append(((aml)localObject1).LvG).append("</head256md5>");
      }
      if (((aml)localObject1).LvJ) {
        localStringBuffer.append("<datasize>").append(((aml)localObject1).LvI).append("</datasize>");
      }
      if (((aml)localObject1).LvQ) {
        localStringBuffer.append("<thumbfullmd5>").append(((aml)localObject1).LvP).append("</thumbfullmd5>");
      }
      if (((aml)localObject1).LvS) {
        localStringBuffer.append("<thumbhead256md5>").append(((aml)localObject1).LvR).append("</thumbhead256md5>");
      }
      if (((aml)localObject1).LvU) {
        localStringBuffer.append("<thumbsize>").append(((aml)localObject1).LvT).append("</thumbsize>");
      }
      if (((aml)localObject1).LvY) {
        localStringBuffer.append("<streamvideoid>").append(Util.escapeStringForXml(((aml)localObject1).LvX)).append("</streamvideoid>");
      }
      if (((aml)localObject1).Lwg) {
        localStringBuffer.append("<sourcetitle>").append(Util.escapeStringForXml(((aml)localObject1).Lwf)).append("</sourcetitle>");
      }
      if (((aml)localObject1).Lwk) {
        localStringBuffer.append("<sourcename>").append(Util.escapeStringForXml(((aml)localObject1).Lwj)).append("</sourcename>");
      }
      if (((aml)localObject1).LwJ) {
        localStringBuffer.append("<sourcedesc>").append(Util.escapeStringForXml(((aml)localObject1).LwI)).append("</sourcedesc>");
      }
      if (((aml)localObject1).LwL) {
        localStringBuffer.append("<sourceheadurl>").append(Util.escapeStringForXml(((aml)localObject1).LwK)).append("</sourceheadurl>");
      }
      if (((aml)localObject1).Lwm) {
        localStringBuffer.append("<sourcetime>").append(Util.escapeStringForXml(((aml)localObject1).Lwl)).append("</sourcetime>");
      }
      if (((aml)localObject1).Lwr) {
        localStringBuffer.append("<statextstr>").append(Util.escapeStringForXml(((aml)localObject1).ean)).append("</statextstr>");
      }
      if (((aml)localObject1).LwM) {
        localStringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(((aml)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((aml)localObject1).LwN) {
        localStringBuffer.append("<songlyric>").append(Util.escapeStringForXml(((aml)localObject1).songLyric)).append("</songlyric>");
      }
      if (((aml)localObject1).Lwy) {
        localStringBuffer.append("<recordxml>").append(((aml)localObject1).Lwx).append("</recordxml>");
      }
      if (((aml)localObject1).jsB) {
        localStringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(((aml)localObject1).jsz)).append("</messageuuid>");
      }
      Object localObject2 = ((aml)localObject1).Lwh;
      if ((localObject2 == null) || (((amm)localObject2).LwO == null) || (((amm)localObject2).LwO.computeSize() == 0))
      {
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwQ != null) && (((amm)localObject2).LwQ.computeSize() != 0)) {
          break label1979;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwS != null) && (((amm)localObject2).LwS.computeSize() != 0)) {
          break label2158;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxk != null)) {
          break label2413;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxm != null)) {
          break label2429;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1433:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxu != null)) {
          break label2445;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder topic item empty");
        label1461:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxo != null)) {
          break label2724;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder namecard item empty");
        label1489:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxq != null)) {
          break label2849;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder column item empty");
        label1517:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxi != null)) {
          break label2865;
        }
        Log.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1545:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwU != null) && (((amm)localObject2).LwU.computeSize() != 0)) {
          break label2881;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1584:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwW != null) && (((amm)localObject2).LwW.computeSize() != 0)) {
          break label3075;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1623:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxf != null)) {
          break label3233;
        }
        Log.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
        label1651:
        localObject1 = ((aml)localObject1).Lwh;
        if ((localObject1 != null) && (((amm)localObject1).Lxs != null)) {
          break label3556;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, music item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((amm)localObject2).LwO;
        if (((amn)localObject2).LxE) {
          localStringBuffer.append("<appid>").append(((amn)localObject2).appId).append("</appid>");
        }
        if (((amn)localObject2).LxF) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((amn)localObject2).link)).append("</link>");
        }
        if (((amn)localObject2).LxI) {
          localStringBuffer.append("<brandid>").append(Util.escapeStringForXml(((amn)localObject2).dCl)).append("</brandid>");
        }
        if ((((amn)localObject2).Lxx) && (((amn)localObject2).LxB))
        {
          if (((amn)localObject2).dRL.equals(((amn)localObject2).LxA))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(((amn)localObject2).dRL)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!ab.Eq(((amn)localObject2).dRL)) && (!e.NF(((amn)localObject2).LxA))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(((amn)localObject2).LxA)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((amn)localObject2).Lxx)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(((amn)localObject2).dRL)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((amn)localObject2).LxB) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(((amn)localObject2).LxA)).append("</realchatname></dataitemsource>");
        break label1299;
        label1979:
        localObject2 = ((amm)localObject2).LwQ;
        localStringBuffer.append("<locitem>");
        if (((ams)localObject2).LxQ) {
          localStringBuffer.append("<label>").append(Util.escapeStringForXml(((ams)localObject2).label)).append("</label>");
        }
        if (((ams)localObject2).LxO) {
          localStringBuffer.append("<lat>").append(((ams)localObject2).lat).append("</lat>");
        }
        if (((ams)localObject2).LxN) {
          localStringBuffer.append("<lng>").append(((ams)localObject2).lng).append("</lng>");
        }
        if (((ams)localObject2).LxP) {
          localStringBuffer.append("<scale>").append(((ams)localObject2).dRt).append("</scale>");
        }
        if (((ams)localObject2).LxR) {
          localStringBuffer.append("<poiname>").append(((ams)localObject2).dWi).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2158:
        Object localObject3 = ((amm)localObject2).LwS;
        localStringBuffer.append("<weburlitem>");
        if (((anq)localObject3).LyD) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((anq)localObject3).LyC)).append("</link>");
        }
        if (((anq)localObject3).Lvi) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((anq)localObject3).desc)).append("</desc>");
        }
        if (((anq)localObject3).LxX) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((anq)localObject3).thumbUrl)).append("</thumburl>");
        }
        if (((anq)localObject3).Lvh) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((anq)localObject3).title)).append("</title>");
        }
        if (((anq)localObject3).LyF) {
          localStringBuffer.append("<opencache>").append(((anq)localObject3).LyE).append("</opencache>");
        }
        if (((anq)localObject3).LyG) {
          localStringBuffer.append("<contentattr>").append(((anq)localObject3).contentattr).append("</contentattr>");
        }
        if ((localObject2 == null) || (((amm)localObject2).IXu == null)) {
          Log.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((amm)localObject2).IXu));
        }
        label2413:
        localStringBuffer.append(l.b(((amm)localObject2).Lxk));
        break label1405;
        label2429:
        localStringBuffer.append(l.c(((amm)localObject2).Lxm));
        break label1433;
        label2445:
        localObject2 = ((amm)localObject2).Lxu;
        localObject3 = new StringBuilder();
        if (localObject2 != null)
        {
          ((StringBuilder)localObject3).append("<finderTopicShareItem><topic>").append(Util.escapeStringForXml(((bcl)localObject2).dST)).append("</topic><topicType>").append(((bcl)localObject2).tvC).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(((bcl)localObject2).iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(((bcl)localObject2).desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(((bcl)localObject2).LLC)).append("</patMusicId>");
          if (((bcl)localObject2).LLB != null) {
            ((StringBuilder)localObject3).append("<location><poiClassifyId>").append(Util.escapeStringForXml(((bcl)localObject2).LLB.LIb)).append("</poiClassifyId><longitude>").append(((bcl)localObject2).LLB.dTj).append("</longitude><latitude>").append(((bcl)localObject2).LLB.latitude).append("</latitude></location>");
          }
          if (((bcl)localObject2).LLD != null) {
            ((StringBuilder)localObject3).append("<event><topicId>").append(((bcl)localObject2).LLD.LAp).append("</topicId><topicEventName>").append(Util.escapeStringForXml(((bcl)localObject2).LLD.LAq)).append("</topicEventName><creatorNickName>").append(Util.escapeStringForXml(((bcl)localObject2).LLD.LAr)).append("</creatorNickName></event>");
          }
          ((StringBuilder)localObject3).append("</finderTopicShareItem>");
        }
        localStringBuffer.append(((StringBuilder)localObject3).toString());
        break label1461;
        label2724:
        localObject2 = ((amm)localObject2).Lxo;
        localObject3 = new StringBuilder();
        if (localObject2 != null) {
          ((StringBuilder)localObject3).append("<finderShareNameCard><username>").append(Util.escapeStringForXml(((bci)localObject2).username)).append("</username><nickname>").append(Util.escapeStringForXml(((bci)localObject2).nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(((bci)localObject2).uNR)).append("</avatar><authJob>").append(Util.escapeStringForXml(((bci)localObject2).wDX)).append("</authJob><authIcon>").append(((bci)localObject2).wDY).append("</authIcon></finderShareNameCard>");
        }
        localStringBuffer.append(((StringBuilder)localObject3).toString());
        break label1489;
        label2849:
        localStringBuffer.append(l.b(((amm)localObject2).Lxq));
        break label1517;
        label2865:
        localStringBuffer.append(b.b(((amm)localObject2).Lxi));
        break label1545;
        label2881:
        localObject2 = ((amm)localObject2).LwU;
        localStringBuffer.append("<productitem");
        if (((ana)localObject2).LxZ) {
          localStringBuffer.append(" type='").append(((ana)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((ana)localObject2).Lvh) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((ana)localObject2).title)).append("</title>");
        }
        if (((ana)localObject2).Lvi) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((ana)localObject2).desc)).append("</desc>");
        }
        if (((ana)localObject2).LxX) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((ana)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((ana)localObject2).LxY) {
          localStringBuffer.append("<productinfo>").append(Util.escapeStringForXml(((ana)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1584;
        label3075:
        localObject2 = ((amm)localObject2).LwW;
        localStringBuffer.append("<tvitem>");
        if (((ank)localObject2).Lvh) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((ank)localObject2).title)).append("</title>");
        }
        if (((ank)localObject2).Lvi) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((ank)localObject2).desc)).append("</desc>");
        }
        if (((ank)localObject2).LxX) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((ank)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((ank)localObject2).LxY) {
          localStringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(((ank)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1623;
        label3233:
        localObject2 = ((amm)localObject2).Lxf;
        if (localObject2 == null) {
          break label1651;
        }
        localStringBuffer.append("<appbranditem>");
        localStringBuffer.append("<username>").append(Util.escapeStringForXml(((amj)localObject2).username)).append("</username>");
        localStringBuffer.append("<appid>").append(Util.escapeStringForXml(((amj)localObject2).appId)).append("</appid>");
        localStringBuffer.append("<pkgtype>").append(((amj)localObject2).dMe).append("</pkgtype>");
        localStringBuffer.append("<iconurl>").append(Util.escapeStringForXml(((amj)localObject2).iconUrl)).append("</iconurl>");
        localStringBuffer.append("<type>").append(((amj)localObject2).type).append("</type>");
        localStringBuffer.append("<pagepath>").append(Util.escapeStringForXml(((amj)localObject2).dCx)).append("</pagepath>");
        localStringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(((amj)localObject2).Lve)).append("</sourcedisplayname>");
        localStringBuffer.append("<version>").append(((amj)localObject2).version).append("</version>");
        localStringBuffer.append("<disableforward>").append(((amj)localObject2).lyE).append("</disableforward>");
        localStringBuffer.append("<tradingguaranteeflag>").append(((amj)localObject2).leb).append("</tradingguaranteeflag>");
        localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((amj)localObject2).eda })).append("</messageextradata>");
        localStringBuffer.append("<subtype>").append(((amj)localObject2).subType).append("</subtype>");
        localStringBuffer.append("</appbranditem>");
        break label1651;
        label3556:
        localStringBuffer.append(ak.a(((amm)localObject1).Lxs));
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(9550);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q
 * JD-Core Version:    0.7.0.1
 */