package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class o
{
  public static String dj(List<afy> paramList)
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
      Object localObject1 = (afy)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((afy)localObject1).Dgn) {
        localStringBuffer.append("datatype='").append(((afy)localObject1).dataType).append("'");
      }
      if (((afy)localObject1).DgQ) {
        localStringBuffer.append(" datastatus='").append(((afy)localObject1).DgP).append("'");
      }
      if (((afy)localObject1).Dgw) {
        localStringBuffer.append(" dataid='").append(((afy)localObject1).dkb).append("'");
      }
      if (((afy)localObject1).Dhc) {
        localStringBuffer.append(" htmlid='").append(((afy)localObject1).Dhb).append("'");
      }
      if (((afy)localObject1).Dhi) {
        localStringBuffer.append(" dataillegaltype='").append(((afy)localObject1).Dhh).append("'");
      }
      if (((afy)localObject1).DgI) {
        localStringBuffer.append(" datasourceid='").append(((afy)localObject1).DgH).append("'");
      }
      localStringBuffer.append(">");
      if (((afy)localObject1).Dgp) {
        localStringBuffer.append("<datafmt>").append(((afy)localObject1).Dgo).append("</datafmt>");
      }
      if (((afy)localObject1).DfS) {
        localStringBuffer.append("<datatitle>").append(bt.aGf(((afy)localObject1).title)).append("</datatitle>");
      }
      if (((afy)localObject1).DfT) {
        localStringBuffer.append("<datadesc>").append(bt.aGf(((afy)localObject1).desc)).append("</datadesc>");
      }
      if (((afy)localObject1).DfU) {
        localStringBuffer.append("<cdnthumburl>").append(bt.aGf(((afy)localObject1).gHu)).append("</cdnthumburl>");
      }
      if (((afy)localObject1).DfX) {
        localStringBuffer.append("<thumbwidth>").append(((afy)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((afy)localObject1).DfY) {
        localStringBuffer.append("<thumbheight>").append(((afy)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((afy)localObject1).Dga) {
        localStringBuffer.append("<cdndataurl>").append(bt.aGf(((afy)localObject1).DfZ)).append("</cdndataurl>");
      }
      if (((afy)localObject1).DfW) {
        localStringBuffer.append("<cdnthumbkey>").append(bt.aGf(((afy)localObject1).DfV)).append("</cdnthumbkey>");
      }
      if (((afy)localObject1).Dgc) {
        localStringBuffer.append("<cdndatakey>").append(bt.aGf(((afy)localObject1).Dgb)).append("</cdndatakey>");
      }
      if (((afy)localObject1).Dge) {
        localStringBuffer.append("<cdnencryver>").append(((afy)localObject1).Dgd).append("</cdnencryver>");
      }
      if (((afy)localObject1).Dgf) {
        localStringBuffer.append("<duration>").append(((afy)localObject1).duration).append("</duration>");
      }
      if (((afy)localObject1).Dgh) {
        localStringBuffer.append("<streamweburl>").append(bt.aGf(((afy)localObject1).Dgg)).append("</streamweburl>");
      }
      if (((afy)localObject1).Dgj) {
        localStringBuffer.append("<streamdataurl>").append(bt.aGf(((afy)localObject1).Dgi)).append("</streamdataurl>");
      }
      if (((afy)localObject1).Dgl) {
        localStringBuffer.append("<streamlowbandurl>").append(bt.aGf(((afy)localObject1).Dgk)).append("</streamlowbandurl>");
      }
      if (((afy)localObject1).Dgm) {
        localStringBuffer.append("<dataext>").append(bt.aGf(((afy)localObject1).deE)).append("</dataext>");
      }
      if (((afy)localObject1).Dgr) {
        localStringBuffer.append("<fullmd5>").append(((afy)localObject1).Dgq).append("</fullmd5>");
      }
      if (((afy)localObject1).Dgt) {
        localStringBuffer.append("<head256md5>").append(((afy)localObject1).Dgs).append("</head256md5>");
      }
      if (((afy)localObject1).Dgv) {
        localStringBuffer.append("<datasize>").append(((afy)localObject1).Dgu).append("</datasize>");
      }
      if (((afy)localObject1).DgC) {
        localStringBuffer.append("<thumbfullmd5>").append(((afy)localObject1).DgB).append("</thumbfullmd5>");
      }
      if (((afy)localObject1).DgE) {
        localStringBuffer.append("<thumbhead256md5>").append(((afy)localObject1).DgD).append("</thumbhead256md5>");
      }
      if (((afy)localObject1).DgG) {
        localStringBuffer.append("<thumbsize>").append(((afy)localObject1).DgF).append("</thumbsize>");
      }
      if (((afy)localObject1).DgK) {
        localStringBuffer.append("<streamvideoid>").append(bt.aGf(((afy)localObject1).DgJ)).append("</streamvideoid>");
      }
      if (((afy)localObject1).DgS) {
        localStringBuffer.append("<sourcetitle>").append(bt.aGf(((afy)localObject1).DgR)).append("</sourcetitle>");
      }
      if (((afy)localObject1).DgW) {
        localStringBuffer.append("<sourcename>").append(bt.aGf(((afy)localObject1).DgV)).append("</sourcename>");
      }
      if (((afy)localObject1).Dhv) {
        localStringBuffer.append("<sourcedesc>").append(bt.aGf(((afy)localObject1).Dhu)).append("</sourcedesc>");
      }
      if (((afy)localObject1).Dhx) {
        localStringBuffer.append("<sourceheadurl>").append(bt.aGf(((afy)localObject1).Dhw)).append("</sourceheadurl>");
      }
      if (((afy)localObject1).DgY) {
        localStringBuffer.append("<sourcetime>").append(bt.aGf(((afy)localObject1).DgX)).append("</sourcetime>");
      }
      if (((afy)localObject1).Dhd) {
        localStringBuffer.append("<statextstr>").append(bt.aGf(((afy)localObject1).dxG)).append("</statextstr>");
      }
      if (((afy)localObject1).Dhy) {
        localStringBuffer.append("<songalbumurl>").append(bt.aGf(((afy)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((afy)localObject1).Dhz) {
        localStringBuffer.append("<songlyric>").append(bt.aGf(((afy)localObject1).songLyric)).append("</songlyric>");
      }
      if (((afy)localObject1).Dhk) {
        localStringBuffer.append("<recordxml>").append(((afy)localObject1).Dhj).append("</recordxml>");
      }
      if (((afy)localObject1).hAv) {
        localStringBuffer.append("<messageuuid>").append(bt.aGf(((afy)localObject1).hAt)).append("</messageuuid>");
      }
      Object localObject2 = ((afy)localObject1).DgT;
      if ((localObject2 == null) || (((afz)localObject2).DhA == null) || (((afz)localObject2).DhA.computeSize() == 0))
      {
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhC != null) && (((afz)localObject2).DhC.computeSize() != 0)) {
          break label1839;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhE != null) && (((afz)localObject2).DhE.computeSize() != 0)) {
          break label2018;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhW != null)) {
          break label2273;
        }
        ad.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhU != null)) {
          break label2289;
        }
        ad.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1433:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhG != null) && (((afz)localObject2).DhG.computeSize() != 0)) {
          break label2305;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1472:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhI != null) && (((afz)localObject2).DhI.computeSize() != 0)) {
          break label2499;
        }
        ad.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1511:
        localObject1 = ((afy)localObject1).DgT;
        if ((localObject1 != null) && (((afz)localObject1).DhR != null)) {
          break label2657;
        }
        ad.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((afz)localObject2).DhA;
        if (((aga)localObject2).Dih) {
          localStringBuffer.append("<appid>").append(((aga)localObject2).appId).append("</appid>");
        }
        if (((aga)localObject2).Dii) {
          localStringBuffer.append("<link>").append(bt.aGf(((aga)localObject2).link)).append("</link>");
        }
        if (((aga)localObject2).Dil) {
          localStringBuffer.append("<brandid>").append(bt.aGf(((aga)localObject2).dbj)).append("</brandid>");
        }
        if ((((aga)localObject2).DhZ) && (((aga)localObject2).Die))
        {
          if (((aga)localObject2).dpv.equals(((aga)localObject2).Did))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bt.aGf(((aga)localObject2).dpv)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!w.pF(((aga)localObject2).dpv)) && (!e.xk(((aga)localObject2).Did))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bt.aGf(((aga)localObject2).Did)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((aga)localObject2).DhZ)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bt.aGf(((aga)localObject2).dpv)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((aga)localObject2).Die) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bt.aGf(((aga)localObject2).Did)).append("</realchatname></dataitemsource>");
        break label1299;
        label1839:
        localObject2 = ((afz)localObject2).DhC;
        localStringBuffer.append("<locitem>");
        if (((agf)localObject2).Dit) {
          localStringBuffer.append("<label>").append(bt.aGf(((agf)localObject2).label)).append("</label>");
        }
        if (((agf)localObject2).Dir) {
          localStringBuffer.append("<lat>").append(((agf)localObject2).lat).append("</lat>");
        }
        if (((agf)localObject2).Diq) {
          localStringBuffer.append("<lng>").append(((agf)localObject2).lng).append("</lng>");
        }
        if (((agf)localObject2).Dis) {
          localStringBuffer.append("<scale>").append(((agf)localObject2).dpd).append("</scale>");
        }
        if (((agf)localObject2).Diu) {
          localStringBuffer.append("<poiname>").append(((agf)localObject2).dtN).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2018:
        ahd localahd = ((afz)localObject2).DhE;
        localStringBuffer.append("<weburlitem>");
        if (localahd.Djg) {
          localStringBuffer.append("<link>").append(bt.aGf(localahd.Djf)).append("</link>");
        }
        if (localahd.DfT) {
          localStringBuffer.append("<desc>").append(bt.aGf(localahd.desc)).append("</desc>");
        }
        if (localahd.DiA) {
          localStringBuffer.append("<thumburl>").append(bt.aGf(localahd.thumbUrl)).append("</thumburl>");
        }
        if (localahd.DfS) {
          localStringBuffer.append("<title>").append(bt.aGf(localahd.title)).append("</title>");
        }
        if (localahd.Dji) {
          localStringBuffer.append("<opencache>").append(localahd.Djh).append("</opencache>");
        }
        if (localahd.Djj) {
          localStringBuffer.append("<contentattr>").append(localahd.gHj).append("</contentattr>");
        }
        if ((localObject2 == null) || (((afz)localObject2).AWL == null)) {
          ad.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((afz)localObject2).AWL));
        }
        label2273:
        localStringBuffer.append(d.a(((afz)localObject2).DhW));
        break label1405;
        label2289:
        localStringBuffer.append(b.b(((afz)localObject2).DhU));
        break label1433;
        label2305:
        localObject2 = ((afz)localObject2).DhG;
        localStringBuffer.append("<productitem");
        if (((agn)localObject2).DiC) {
          localStringBuffer.append(" type='").append(((agn)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((agn)localObject2).DfS) {
          localStringBuffer.append("<title>").append(bt.aGf(((agn)localObject2).title)).append("</title>");
        }
        if (((agn)localObject2).DfT) {
          localStringBuffer.append("<desc>").append(bt.aGf(((agn)localObject2).desc)).append("</desc>");
        }
        if (((agn)localObject2).DiA) {
          localStringBuffer.append("<thumburl>").append(bt.aGf(((agn)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((agn)localObject2).DiB) {
          localStringBuffer.append("<productinfo>").append(bt.aGf(((agn)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1472;
        label2499:
        localObject2 = ((afz)localObject2).DhI;
        localStringBuffer.append("<tvitem>");
        if (((agx)localObject2).DfS) {
          localStringBuffer.append("<title>").append(bt.aGf(((agx)localObject2).title)).append("</title>");
        }
        if (((agx)localObject2).DfT) {
          localStringBuffer.append("<desc>").append(bt.aGf(((agx)localObject2).desc)).append("</desc>");
        }
        if (((agx)localObject2).DiA) {
          localStringBuffer.append("<thumburl>").append(bt.aGf(((agx)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((agx)localObject2).DiB) {
          localStringBuffer.append("<tvinfo>").append(bt.aGf(((agx)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1511;
        label2657:
        localObject1 = ((afz)localObject1).DhR;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bt.aGf(((afw)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bt.aGf(((afw)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((afw)localObject1).dkC).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bt.aGf(((afw)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((afw)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bt.aGf(((afw)localObject1).dbu)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bt.aGf(((afw)localObject1).DfP)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((afw)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((afw)localObject1).jwB).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((afw)localObject1).cfU).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((afw)localObject1).dzY })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((afw)localObject1).subType).append("</subtype>");
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
 * Qualified Name:     com.tencent.mm.plugin.record.b.o
 * JD-Core Version:    0.7.0.1
 */