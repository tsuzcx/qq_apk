package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class q
{
  public static String dn(List<ajn> paramList)
  {
    AppMethodBeat.i(9550);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      AppMethodBeat.o(9550);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (ajn)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((ajn)localObject1).Ghf) {
        localStringBuffer.append("datatype='").append(((ajn)localObject1).dataType).append("'");
      }
      if (((ajn)localObject1).GhI) {
        localStringBuffer.append(" datastatus='").append(((ajn)localObject1).GhH).append("'");
      }
      if (((ajn)localObject1).Gho) {
        localStringBuffer.append(" dataid='").append(((ajn)localObject1).dsU).append("'");
      }
      if (((ajn)localObject1).GhU) {
        localStringBuffer.append(" htmlid='").append(((ajn)localObject1).GhT).append("'");
      }
      if (((ajn)localObject1).Gia) {
        localStringBuffer.append(" dataillegaltype='").append(((ajn)localObject1).GhZ).append("'");
      }
      if (((ajn)localObject1).GhA) {
        localStringBuffer.append(" datasourceid='").append(((ajn)localObject1).Ghz).append("'");
      }
      localStringBuffer.append(">");
      if (((ajn)localObject1).Ghh) {
        localStringBuffer.append("<datafmt>").append(((ajn)localObject1).Ghg).append("</datafmt>");
      }
      if (((ajn)localObject1).GgK) {
        localStringBuffer.append("<datatitle>").append(bt.aRc(((ajn)localObject1).title)).append("</datatitle>");
      }
      if (((ajn)localObject1).GgL) {
        localStringBuffer.append("<datadesc>").append(bt.aRc(((ajn)localObject1).desc)).append("</datadesc>");
      }
      if (((ajn)localObject1).GgM) {
        localStringBuffer.append("<cdnthumburl>").append(bt.aRc(((ajn)localObject1).hAe)).append("</cdnthumburl>");
      }
      if (((ajn)localObject1).GgP) {
        localStringBuffer.append("<thumbwidth>").append(((ajn)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((ajn)localObject1).GgQ) {
        localStringBuffer.append("<thumbheight>").append(((ajn)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((ajn)localObject1).GgS) {
        localStringBuffer.append("<cdndataurl>").append(bt.aRc(((ajn)localObject1).GgR)).append("</cdndataurl>");
      }
      if (((ajn)localObject1).GgO) {
        localStringBuffer.append("<cdnthumbkey>").append(bt.aRc(((ajn)localObject1).GgN)).append("</cdnthumbkey>");
      }
      if (((ajn)localObject1).GgU) {
        localStringBuffer.append("<cdndatakey>").append(bt.aRc(((ajn)localObject1).GgT)).append("</cdndatakey>");
      }
      if (((ajn)localObject1).GgW) {
        localStringBuffer.append("<cdnencryver>").append(((ajn)localObject1).GgV).append("</cdnencryver>");
      }
      if (((ajn)localObject1).GgX) {
        localStringBuffer.append("<duration>").append(((ajn)localObject1).duration).append("</duration>");
      }
      if (((ajn)localObject1).GgZ) {
        localStringBuffer.append("<streamweburl>").append(bt.aRc(((ajn)localObject1).GgY)).append("</streamweburl>");
      }
      if (((ajn)localObject1).Ghb) {
        localStringBuffer.append("<streamdataurl>").append(bt.aRc(((ajn)localObject1).Gha)).append("</streamdataurl>");
      }
      if (((ajn)localObject1).Ghd) {
        localStringBuffer.append("<streamlowbandurl>").append(bt.aRc(((ajn)localObject1).Ghc)).append("</streamlowbandurl>");
      }
      if (((ajn)localObject1).Ghe) {
        localStringBuffer.append("<dataext>").append(bt.aRc(((ajn)localObject1).dnv)).append("</dataext>");
      }
      if (((ajn)localObject1).Ghj) {
        localStringBuffer.append("<fullmd5>").append(((ajn)localObject1).Ghi).append("</fullmd5>");
      }
      if (((ajn)localObject1).Ghl) {
        localStringBuffer.append("<head256md5>").append(((ajn)localObject1).Ghk).append("</head256md5>");
      }
      if (((ajn)localObject1).Ghn) {
        localStringBuffer.append("<datasize>").append(((ajn)localObject1).Ghm).append("</datasize>");
      }
      if (((ajn)localObject1).Ghu) {
        localStringBuffer.append("<thumbfullmd5>").append(((ajn)localObject1).Ght).append("</thumbfullmd5>");
      }
      if (((ajn)localObject1).Ghw) {
        localStringBuffer.append("<thumbhead256md5>").append(((ajn)localObject1).Ghv).append("</thumbhead256md5>");
      }
      if (((ajn)localObject1).Ghy) {
        localStringBuffer.append("<thumbsize>").append(((ajn)localObject1).Ghx).append("</thumbsize>");
      }
      if (((ajn)localObject1).GhC) {
        localStringBuffer.append("<streamvideoid>").append(bt.aRc(((ajn)localObject1).GhB)).append("</streamvideoid>");
      }
      if (((ajn)localObject1).GhK) {
        localStringBuffer.append("<sourcetitle>").append(bt.aRc(((ajn)localObject1).GhJ)).append("</sourcetitle>");
      }
      if (((ajn)localObject1).GhO) {
        localStringBuffer.append("<sourcename>").append(bt.aRc(((ajn)localObject1).GhN)).append("</sourcename>");
      }
      if (((ajn)localObject1).Gin) {
        localStringBuffer.append("<sourcedesc>").append(bt.aRc(((ajn)localObject1).Gim)).append("</sourcedesc>");
      }
      if (((ajn)localObject1).Gip) {
        localStringBuffer.append("<sourceheadurl>").append(bt.aRc(((ajn)localObject1).Gio)).append("</sourceheadurl>");
      }
      if (((ajn)localObject1).GhQ) {
        localStringBuffer.append("<sourcetime>").append(bt.aRc(((ajn)localObject1).GhP)).append("</sourcetime>");
      }
      if (((ajn)localObject1).GhV) {
        localStringBuffer.append("<statextstr>").append(bt.aRc(((ajn)localObject1).dHv)).append("</statextstr>");
      }
      if (((ajn)localObject1).Giq) {
        localStringBuffer.append("<songalbumurl>").append(bt.aRc(((ajn)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((ajn)localObject1).Gir) {
        localStringBuffer.append("<songlyric>").append(bt.aRc(((ajn)localObject1).songLyric)).append("</songlyric>");
      }
      if (((ajn)localObject1).Gic) {
        localStringBuffer.append("<recordxml>").append(((ajn)localObject1).Gib).append("</recordxml>");
      }
      if (((ajn)localObject1).ius) {
        localStringBuffer.append("<messageuuid>").append(bt.aRc(((ajn)localObject1).iuq)).append("</messageuuid>");
      }
      Object localObject2 = ((ajn)localObject1).GhL;
      if ((localObject2 == null) || (((ajo)localObject2).Gis == null) || (((ajo)localObject2).Gis.computeSize() == 0))
      {
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).Giu != null) && (((ajo)localObject2).Giu.computeSize() != 0)) {
          break label1839;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).Giw != null) && (((ajo)localObject2).Giw.computeSize() != 0)) {
          break label2018;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).GiO != null)) {
          break label2273;
        }
        ad.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).GiM != null)) {
          break label2289;
        }
        ad.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1433:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).Giy != null) && (((ajo)localObject2).Giy.computeSize() != 0)) {
          break label2305;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1472:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).GiA != null) && (((ajo)localObject2).GiA.computeSize() != 0)) {
          break label2499;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1511:
        localObject1 = ((ajn)localObject1).GhL;
        if ((localObject1 != null) && (((ajo)localObject1).GiJ != null)) {
          break label2657;
        }
        ad.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((ajo)localObject2).Gis;
        if (((ajp)localObject2).GiZ) {
          localStringBuffer.append("<appid>").append(((ajp)localObject2).appId).append("</appid>");
        }
        if (((ajp)localObject2).Gja) {
          localStringBuffer.append("<link>").append(bt.aRc(((ajp)localObject2).link)).append("</link>");
        }
        if (((ajp)localObject2).Gjd) {
          localStringBuffer.append("<brandid>").append(bt.aRc(((ajp)localObject2).djX)).append("</brandid>");
        }
        if ((((ajp)localObject2).GiR) && (((ajp)localObject2).GiW))
        {
          if (((ajp)localObject2).dyU.equals(((ajp)localObject2).GiV))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bt.aRc(((ajp)localObject2).dyU)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!w.vF(((ajp)localObject2).dyU)) && (!com.tencent.mm.am.a.e.Ep(((ajp)localObject2).GiV))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bt.aRc(((ajp)localObject2).GiV)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((ajp)localObject2).GiR)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bt.aRc(((ajp)localObject2).dyU)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((ajp)localObject2).GiW) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bt.aRc(((ajp)localObject2).GiV)).append("</realchatname></dataitemsource>");
        break label1299;
        label1839:
        localObject2 = ((ajo)localObject2).Giu;
        localStringBuffer.append("<locitem>");
        if (((aju)localObject2).Gjl) {
          localStringBuffer.append("<label>").append(bt.aRc(((aju)localObject2).label)).append("</label>");
        }
        if (((aju)localObject2).Gjj) {
          localStringBuffer.append("<lat>").append(((aju)localObject2).lat).append("</lat>");
        }
        if (((aju)localObject2).Gji) {
          localStringBuffer.append("<lng>").append(((aju)localObject2).lng).append("</lng>");
        }
        if (((aju)localObject2).Gjk) {
          localStringBuffer.append("<scale>").append(((aju)localObject2).dyB).append("</scale>");
        }
        if (((aju)localObject2).Gjm) {
          localStringBuffer.append("<poiname>").append(((aju)localObject2).dDq).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2018:
        aks localaks = ((ajo)localObject2).Giw;
        localStringBuffer.append("<weburlitem>");
        if (localaks.GjY) {
          localStringBuffer.append("<link>").append(bt.aRc(localaks.GjX)).append("</link>");
        }
        if (localaks.GgL) {
          localStringBuffer.append("<desc>").append(bt.aRc(localaks.desc)).append("</desc>");
        }
        if (localaks.Gjs) {
          localStringBuffer.append("<thumburl>").append(bt.aRc(localaks.thumbUrl)).append("</thumburl>");
        }
        if (localaks.GgK) {
          localStringBuffer.append("<title>").append(bt.aRc(localaks.title)).append("</title>");
        }
        if (localaks.Gka) {
          localStringBuffer.append("<opencache>").append(localaks.GjZ).append("</opencache>");
        }
        if (localaks.Gkb) {
          localStringBuffer.append("<contentattr>").append(localaks.hzT).append("</contentattr>");
        }
        if ((localObject2 == null) || (((ajo)localObject2).DSw == null)) {
          ad.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((ajo)localObject2).DSw));
        }
        label2273:
        localStringBuffer.append(com.tencent.mm.plugin.i.a.e.b(((ajo)localObject2).GiO));
        break label1405;
        label2289:
        localStringBuffer.append(b.b(((ajo)localObject2).GiM));
        break label1433;
        label2305:
        localObject2 = ((ajo)localObject2).Giy;
        localStringBuffer.append("<productitem");
        if (((akc)localObject2).Gju) {
          localStringBuffer.append(" type='").append(((akc)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((akc)localObject2).GgK) {
          localStringBuffer.append("<title>").append(bt.aRc(((akc)localObject2).title)).append("</title>");
        }
        if (((akc)localObject2).GgL) {
          localStringBuffer.append("<desc>").append(bt.aRc(((akc)localObject2).desc)).append("</desc>");
        }
        if (((akc)localObject2).Gjs) {
          localStringBuffer.append("<thumburl>").append(bt.aRc(((akc)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((akc)localObject2).Gjt) {
          localStringBuffer.append("<productinfo>").append(bt.aRc(((akc)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1472;
        label2499:
        localObject2 = ((ajo)localObject2).GiA;
        localStringBuffer.append("<tvitem>");
        if (((akm)localObject2).GgK) {
          localStringBuffer.append("<title>").append(bt.aRc(((akm)localObject2).title)).append("</title>");
        }
        if (((akm)localObject2).GgL) {
          localStringBuffer.append("<desc>").append(bt.aRc(((akm)localObject2).desc)).append("</desc>");
        }
        if (((akm)localObject2).Gjs) {
          localStringBuffer.append("<thumburl>").append(bt.aRc(((akm)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((akm)localObject2).Gjt) {
          localStringBuffer.append("<tvinfo>").append(bt.aRc(((akm)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1511;
        label2657:
        localObject1 = ((ajo)localObject1).GiJ;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bt.aRc(((ajl)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bt.aRc(((ajl)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((ajl)localObject1).dtF).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bt.aRc(((ajl)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((ajl)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bt.aRc(((ajl)localObject1).dki)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bt.aRc(((ajl)localObject1).GgH)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((ajl)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((ajl)localObject1).kro).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((ajl)localObject1).jXI).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ajl)localObject1).dJW })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((ajl)localObject1).subType).append("</subtype>");
          localStringBuffer.append("</appbranditem>");
        }
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