package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.findersdk.a.k;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.List;

public final class q
{
  public static String dK(List<anm> paramList)
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
      Object localObject1 = (anm)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((anm)localObject1).Syb) {
        localStringBuffer.append("datatype='").append(((anm)localObject1).dataType).append("'");
      }
      if (((anm)localObject1).SyD) {
        localStringBuffer.append(" datastatus='").append(((anm)localObject1).SyC).append("'");
      }
      if (((anm)localObject1).Syk) {
        localStringBuffer.append(" dataid='").append(((anm)localObject1).fEa).append("'");
      }
      if (((anm)localObject1).SyP) {
        localStringBuffer.append(" htmlid='").append(((anm)localObject1).SyO).append("'");
      }
      if (((anm)localObject1).SyV) {
        localStringBuffer.append(" dataillegaltype='").append(((anm)localObject1).SyU).append("'");
      }
      if (((anm)localObject1).Syv) {
        localStringBuffer.append(" datasourceid='").append(((anm)localObject1).Syu).append("'");
      }
      localStringBuffer.append(">");
      if (((anm)localObject1).Syd) {
        localStringBuffer.append("<datafmt>").append(((anm)localObject1).Syc).append("</datafmt>");
      }
      if (((anm)localObject1).SxH) {
        localStringBuffer.append("<datatitle>").append(Util.escapeStringForXml(((anm)localObject1).title)).append("</datatitle>");
      }
      if (((anm)localObject1).SxI) {
        localStringBuffer.append("<datadesc>").append(Util.escapeStringForXml(((anm)localObject1).desc)).append("</datadesc>");
      }
      if (((anm)localObject1).SxJ) {
        localStringBuffer.append("<cdnthumburl>").append(Util.escapeStringForXml(((anm)localObject1).lmm)).append("</cdnthumburl>");
      }
      if (((anm)localObject1).SxM) {
        localStringBuffer.append("<thumbwidth>").append(((anm)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((anm)localObject1).SxN) {
        localStringBuffer.append("<thumbheight>").append(((anm)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((anm)localObject1).SxO) {
        localStringBuffer.append("<cdndataurl>").append(Util.escapeStringForXml(((anm)localObject1).Rwb)).append("</cdndataurl>");
      }
      if (((anm)localObject1).SxL) {
        localStringBuffer.append("<cdnthumbkey>").append(Util.escapeStringForXml(((anm)localObject1).SxK)).append("</cdnthumbkey>");
      }
      if (((anm)localObject1).SxQ) {
        localStringBuffer.append("<cdndatakey>").append(Util.escapeStringForXml(((anm)localObject1).SxP)).append("</cdndatakey>");
      }
      if (((anm)localObject1).SxS) {
        localStringBuffer.append("<cdnencryver>").append(((anm)localObject1).SxR).append("</cdnencryver>");
      }
      if (((anm)localObject1).SxT) {
        localStringBuffer.append("<duration>").append(((anm)localObject1).duration).append("</duration>");
      }
      if (((anm)localObject1).SxV) {
        localStringBuffer.append("<streamweburl>").append(Util.escapeStringForXml(((anm)localObject1).SxU)).append("</streamweburl>");
      }
      if (((anm)localObject1).SxX) {
        localStringBuffer.append("<streamdataurl>").append(Util.escapeStringForXml(((anm)localObject1).SxW)).append("</streamdataurl>");
      }
      if (((anm)localObject1).SxZ) {
        localStringBuffer.append("<streamlowbandurl>").append(Util.escapeStringForXml(((anm)localObject1).SxY)).append("</streamlowbandurl>");
      }
      if (((anm)localObject1).Sya) {
        localStringBuffer.append("<dataext>").append(Util.escapeStringForXml(((anm)localObject1).fyu)).append("</dataext>");
      }
      if (((anm)localObject1).Syf) {
        localStringBuffer.append("<fullmd5>").append(((anm)localObject1).Sye).append("</fullmd5>");
      }
      if (((anm)localObject1).Syh) {
        localStringBuffer.append("<head256md5>").append(((anm)localObject1).Syg).append("</head256md5>");
      }
      if (((anm)localObject1).Syj) {
        localStringBuffer.append("<datasize>").append(((anm)localObject1).Syi).append("</datasize>");
      }
      if (((anm)localObject1).Syp) {
        localStringBuffer.append("<thumbfullmd5>").append(((anm)localObject1).Kll).append("</thumbfullmd5>");
      }
      if (((anm)localObject1).Syr) {
        localStringBuffer.append("<thumbhead256md5>").append(((anm)localObject1).Syq).append("</thumbhead256md5>");
      }
      if (((anm)localObject1).Syt) {
        localStringBuffer.append("<thumbsize>").append(((anm)localObject1).Sys).append("</thumbsize>");
      }
      if (((anm)localObject1).Syx) {
        localStringBuffer.append("<streamvideoid>").append(Util.escapeStringForXml(((anm)localObject1).Syw)).append("</streamvideoid>");
      }
      if (((anm)localObject1).SyF) {
        localStringBuffer.append("<sourcetitle>").append(Util.escapeStringForXml(((anm)localObject1).SyE)).append("</sourcetitle>");
      }
      if (((anm)localObject1).SyJ) {
        localStringBuffer.append("<sourcename>").append(Util.escapeStringForXml(((anm)localObject1).SyI)).append("</sourcename>");
      }
      if (((anm)localObject1).Szi) {
        localStringBuffer.append("<sourcedesc>").append(Util.escapeStringForXml(((anm)localObject1).Szh)).append("</sourcedesc>");
      }
      if (((anm)localObject1).Szk) {
        localStringBuffer.append("<sourceheadurl>").append(Util.escapeStringForXml(((anm)localObject1).Szj)).append("</sourceheadurl>");
      }
      if (((anm)localObject1).SyL) {
        localStringBuffer.append("<sourcetime>").append(Util.escapeStringForXml(((anm)localObject1).SyK)).append("</sourcetime>");
      }
      if (((anm)localObject1).SyQ) {
        localStringBuffer.append("<statextstr>").append(Util.escapeStringForXml(((anm)localObject1).fUk)).append("</statextstr>");
      }
      if (((anm)localObject1).Szl) {
        localStringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(((anm)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((anm)localObject1).Szm) {
        localStringBuffer.append("<songlyric>").append(Util.escapeStringForXml(((anm)localObject1).songLyric)).append("</songlyric>");
      }
      if (((anm)localObject1).SyX) {
        localStringBuffer.append("<recordxml>").append(((anm)localObject1).SyW).append("</recordxml>");
      }
      if (((anm)localObject1).mie) {
        localStringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(((anm)localObject1).mic)).append("</messageuuid>");
      }
      Object localObject2 = ((anm)localObject1).SyG;
      if ((localObject2 == null) || (((ann)localObject2).Szn == null) || (((ann)localObject2).Szn.computeSize() == 0))
      {
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szp != null) && (((ann)localObject2).Szp.computeSize() != 0)) {
          break label2007;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szr != null) && (((ann)localObject2).Szr.computeSize() != 0)) {
          break label2186;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzJ != null)) {
          break label2463;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzL != null)) {
          break label2479;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1433:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzV != null)) {
          break label2495;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder activity item empty");
        label1461:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzT != null)) {
          break label2511;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder topic item empty");
        label1489:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzN != null)) {
          break label2527;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder namecard item empty");
        label1517:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzP != null)) {
          break label2652;
        }
        Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder column item empty");
        label1545:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzH != null)) {
          break label2668;
        }
        Log.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1573:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szt != null) && (((ann)localObject2).Szt.computeSize() != 0)) {
          break label2684;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1612:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szv != null) && (((ann)localObject2).Szv.computeSize() != 0)) {
          break label2878;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1651:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzE != null)) {
          break label3036;
        }
        Log.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
        label1679:
        localObject1 = ((anm)localObject1).SyG;
        if ((localObject1 != null) && (((ann)localObject1).SzR != null)) {
          break label3359;
        }
        Log.w("MicroMsg.RecordMsgParser", "klem toXml, music item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((ann)localObject2).Szn;
        if (((ano)localObject2).SAf) {
          localStringBuffer.append("<appid>").append(((ano)localObject2).appId).append("</appid>");
        }
        if (((ano)localObject2).SAg) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((ano)localObject2).link)).append("</link>");
        }
        if (((ano)localObject2).SAj) {
          localStringBuffer.append("<brandid>").append(Util.escapeStringForXml(((ano)localObject2).fuO)).append("</brandid>");
        }
        if ((((ano)localObject2).SzY) && (((ano)localObject2).SAc))
        {
          if (((ano)localObject2).fLi.equals(((ano)localObject2).SAb))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(((ano)localObject2).fLi)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!ab.Lj(((ano)localObject2).fLi)) && (!e.Vb(((ano)localObject2).SAb))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(((ano)localObject2).SAb)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((ano)localObject2).SzY)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(((ano)localObject2).fLi)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((ano)localObject2).SAc) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(((ano)localObject2).SAb)).append("</realchatname></dataitemsource>");
        break label1299;
        label2007:
        localObject2 = ((ann)localObject2).Szp;
        localStringBuffer.append("<locitem>");
        if (((ant)localObject2).SAr) {
          localStringBuffer.append("<label>").append(Util.escapeStringForXml(((ant)localObject2).label)).append("</label>");
        }
        if (((ant)localObject2).SAp) {
          localStringBuffer.append("<lat>").append(((ant)localObject2).lat).append("</lat>");
        }
        if (((ant)localObject2).SAo) {
          localStringBuffer.append("<lng>").append(((ant)localObject2).lng).append("</lng>");
        }
        if (((ant)localObject2).SAq) {
          localStringBuffer.append("<scale>").append(((ant)localObject2).fKJ).append("</scale>");
        }
        if (((ant)localObject2).SAs) {
          localStringBuffer.append("<poiname>").append(((ant)localObject2).fPN).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2186:
        Object localObject3 = ((ann)localObject2).Szr;
        localStringBuffer.append("<weburlitem>");
        if (((aor)localObject3).SBd) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((aor)localObject3).SBc)).append("</link>");
        }
        if (((aor)localObject3).SxI) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((aor)localObject3).desc)).append("</desc>");
        }
        if (((aor)localObject3).SAy) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((aor)localObject3).thumbUrl)).append("</thumburl>");
        }
        if (((aor)localObject3).SxH) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((aor)localObject3).title)).append("</title>");
        }
        if (((aor)localObject3).SBf) {
          localStringBuffer.append("<opencache>").append(((aor)localObject3).SBe).append("</opencache>");
        }
        if (((aor)localObject3).SBg) {
          localStringBuffer.append("<contentattr>").append(((aor)localObject3).contentattr).append("</contentattr>");
        }
        localStringBuffer.append("<forwardflag>").append(((aor)localObject3).mjT).append("</forwardflag>");
        if ((localObject2 == null) || (((ann)localObject2).PTL == null)) {
          Log.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((ann)localObject2).PTL));
        }
        label2463:
        localStringBuffer.append(k.b(((ann)localObject2).SzJ));
        break label1405;
        label2479:
        localStringBuffer.append(k.c(((ann)localObject2).SzL));
        break label1433;
        label2495:
        localStringBuffer.append(k.c(((ann)localObject2).SzV));
        break label1461;
        label2511:
        localStringBuffer.append(k.c(((ann)localObject2).SzT));
        break label1489;
        label2527:
        localObject2 = ((ann)localObject2).SzN;
        localObject3 = new StringBuilder();
        if (localObject2 != null) {
          ((StringBuilder)localObject3).append("<finderShareNameCard><username>").append(Util.escapeStringForXml(((bjd)localObject2).username)).append("</username><nickname>").append(Util.escapeStringForXml(((bjd)localObject2).nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(((bjd)localObject2).avatar)).append("</avatar><authJob>").append(Util.escapeStringForXml(((bjd)localObject2).Bvd)).append("</authJob><authIcon>").append(((bjd)localObject2).Bve).append("</authIcon></finderShareNameCard>");
        }
        localStringBuffer.append(((StringBuilder)localObject3).toString());
        break label1517;
        label2652:
        localStringBuffer.append(k.b(((ann)localObject2).SzP));
        break label1545;
        label2668:
        localStringBuffer.append(b.b(((ann)localObject2).SzH));
        break label1573;
        label2684:
        localObject2 = ((ann)localObject2).Szt;
        localStringBuffer.append("<productitem");
        if (((aob)localObject2).SAA) {
          localStringBuffer.append(" type='").append(((aob)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((aob)localObject2).SxH) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((aob)localObject2).title)).append("</title>");
        }
        if (((aob)localObject2).SxI) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((aob)localObject2).desc)).append("</desc>");
        }
        if (((aob)localObject2).SAy) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((aob)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((aob)localObject2).SAz) {
          localStringBuffer.append("<productinfo>").append(Util.escapeStringForXml(((aob)localObject2).fTp)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1612;
        label2878:
        localObject2 = ((ann)localObject2).Szv;
        localStringBuffer.append("<tvitem>");
        if (((aol)localObject2).SxH) {
          localStringBuffer.append("<title>").append(Util.escapeStringForXml(((aol)localObject2).title)).append("</title>");
        }
        if (((aol)localObject2).SxI) {
          localStringBuffer.append("<desc>").append(Util.escapeStringForXml(((aol)localObject2).desc)).append("</desc>");
        }
        if (((aol)localObject2).SAy) {
          localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(((aol)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((aol)localObject2).SAz) {
          localStringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(((aol)localObject2).fTp)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1651;
        label3036:
        localObject2 = ((ann)localObject2).SzE;
        if (localObject2 == null) {
          break label1679;
        }
        localStringBuffer.append("<appbranditem>");
        localStringBuffer.append("<username>").append(Util.escapeStringForXml(((ank)localObject2).username)).append("</username>");
        localStringBuffer.append("<appid>").append(Util.escapeStringForXml(((ank)localObject2).appId)).append("</appid>");
        localStringBuffer.append("<pkgtype>").append(((ank)localObject2).fES).append("</pkgtype>");
        localStringBuffer.append("<iconurl>").append(Util.escapeStringForXml(((ank)localObject2).iconUrl)).append("</iconurl>");
        localStringBuffer.append("<type>").append(((ank)localObject2).type).append("</type>");
        localStringBuffer.append("<pagepath>").append(Util.escapeStringForXml(((ank)localObject2).fve)).append("</pagepath>");
        localStringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(((ank)localObject2).SxE)).append("</sourcedisplayname>");
        localStringBuffer.append("<version>").append(((ank)localObject2).version).append("</version>");
        localStringBuffer.append("<disableforward>").append(((ank)localObject2).otE).append("</disableforward>");
        localStringBuffer.append("<tradingguaranteeflag>").append(((ank)localObject2).nYp).append("</tradingguaranteeflag>");
        localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ank)localObject2).fXg })).append("</messageextradata>");
        localStringBuffer.append("<subtype>").append(((ank)localObject2).subType).append("</subtype>");
        localStringBuffer.append("</appbranditem>");
        break label1679;
        label3359:
        localStringBuffer.append(am.a(((ann)localObject1).SzR));
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(9550);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q
 * JD-Core Version:    0.7.0.1
 */