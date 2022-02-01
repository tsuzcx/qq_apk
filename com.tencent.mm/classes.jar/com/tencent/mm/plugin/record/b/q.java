package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class q
{
  public static String dq(List<ajx> paramList)
  {
    AppMethodBeat.i(9550);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      AppMethodBeat.o(9550);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (ajx)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((ajx)localObject1).GzO) {
        localStringBuffer.append("datatype='").append(((ajx)localObject1).dataType).append("'");
      }
      if (((ajx)localObject1).GAr) {
        localStringBuffer.append(" datastatus='").append(((ajx)localObject1).GAq).append("'");
      }
      if (((ajx)localObject1).GzX) {
        localStringBuffer.append(" dataid='").append(((ajx)localObject1).dua).append("'");
      }
      if (((ajx)localObject1).GAD) {
        localStringBuffer.append(" htmlid='").append(((ajx)localObject1).GAC).append("'");
      }
      if (((ajx)localObject1).GAJ) {
        localStringBuffer.append(" dataillegaltype='").append(((ajx)localObject1).GAI).append("'");
      }
      if (((ajx)localObject1).GAj) {
        localStringBuffer.append(" datasourceid='").append(((ajx)localObject1).GAi).append("'");
      }
      localStringBuffer.append(">");
      if (((ajx)localObject1).GzQ) {
        localStringBuffer.append("<datafmt>").append(((ajx)localObject1).GzP).append("</datafmt>");
      }
      if (((ajx)localObject1).Gzt) {
        localStringBuffer.append("<datatitle>").append(bu.aSz(((ajx)localObject1).title)).append("</datatitle>");
      }
      if (((ajx)localObject1).Gzu) {
        localStringBuffer.append("<datadesc>").append(bu.aSz(((ajx)localObject1).desc)).append("</datadesc>");
      }
      if (((ajx)localObject1).Gzv) {
        localStringBuffer.append("<cdnthumburl>").append(bu.aSz(((ajx)localObject1).hCS)).append("</cdnthumburl>");
      }
      if (((ajx)localObject1).Gzy) {
        localStringBuffer.append("<thumbwidth>").append(((ajx)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((ajx)localObject1).Gzz) {
        localStringBuffer.append("<thumbheight>").append(((ajx)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((ajx)localObject1).GzB) {
        localStringBuffer.append("<cdndataurl>").append(bu.aSz(((ajx)localObject1).GzA)).append("</cdndataurl>");
      }
      if (((ajx)localObject1).Gzx) {
        localStringBuffer.append("<cdnthumbkey>").append(bu.aSz(((ajx)localObject1).Gzw)).append("</cdnthumbkey>");
      }
      if (((ajx)localObject1).GzD) {
        localStringBuffer.append("<cdndatakey>").append(bu.aSz(((ajx)localObject1).GzC)).append("</cdndatakey>");
      }
      if (((ajx)localObject1).GzF) {
        localStringBuffer.append("<cdnencryver>").append(((ajx)localObject1).GzE).append("</cdnencryver>");
      }
      if (((ajx)localObject1).GzG) {
        localStringBuffer.append("<duration>").append(((ajx)localObject1).duration).append("</duration>");
      }
      if (((ajx)localObject1).GzI) {
        localStringBuffer.append("<streamweburl>").append(bu.aSz(((ajx)localObject1).GzH)).append("</streamweburl>");
      }
      if (((ajx)localObject1).GzK) {
        localStringBuffer.append("<streamdataurl>").append(bu.aSz(((ajx)localObject1).GzJ)).append("</streamdataurl>");
      }
      if (((ajx)localObject1).GzM) {
        localStringBuffer.append("<streamlowbandurl>").append(bu.aSz(((ajx)localObject1).GzL)).append("</streamlowbandurl>");
      }
      if (((ajx)localObject1).GzN) {
        localStringBuffer.append("<dataext>").append(bu.aSz(((ajx)localObject1).dox)).append("</dataext>");
      }
      if (((ajx)localObject1).GzS) {
        localStringBuffer.append("<fullmd5>").append(((ajx)localObject1).GzR).append("</fullmd5>");
      }
      if (((ajx)localObject1).GzU) {
        localStringBuffer.append("<head256md5>").append(((ajx)localObject1).GzT).append("</head256md5>");
      }
      if (((ajx)localObject1).GzW) {
        localStringBuffer.append("<datasize>").append(((ajx)localObject1).GzV).append("</datasize>");
      }
      if (((ajx)localObject1).GAd) {
        localStringBuffer.append("<thumbfullmd5>").append(((ajx)localObject1).GAc).append("</thumbfullmd5>");
      }
      if (((ajx)localObject1).GAf) {
        localStringBuffer.append("<thumbhead256md5>").append(((ajx)localObject1).GAe).append("</thumbhead256md5>");
      }
      if (((ajx)localObject1).GAh) {
        localStringBuffer.append("<thumbsize>").append(((ajx)localObject1).GAg).append("</thumbsize>");
      }
      if (((ajx)localObject1).GAl) {
        localStringBuffer.append("<streamvideoid>").append(bu.aSz(((ajx)localObject1).GAk)).append("</streamvideoid>");
      }
      if (((ajx)localObject1).GAt) {
        localStringBuffer.append("<sourcetitle>").append(bu.aSz(((ajx)localObject1).GAs)).append("</sourcetitle>");
      }
      if (((ajx)localObject1).GAx) {
        localStringBuffer.append("<sourcename>").append(bu.aSz(((ajx)localObject1).GAw)).append("</sourcename>");
      }
      if (((ajx)localObject1).GAW) {
        localStringBuffer.append("<sourcedesc>").append(bu.aSz(((ajx)localObject1).GAV)).append("</sourcedesc>");
      }
      if (((ajx)localObject1).GAY) {
        localStringBuffer.append("<sourceheadurl>").append(bu.aSz(((ajx)localObject1).GAX)).append("</sourceheadurl>");
      }
      if (((ajx)localObject1).GAz) {
        localStringBuffer.append("<sourcetime>").append(bu.aSz(((ajx)localObject1).GAy)).append("</sourcetime>");
      }
      if (((ajx)localObject1).GAE) {
        localStringBuffer.append("<statextstr>").append(bu.aSz(((ajx)localObject1).dIA)).append("</statextstr>");
      }
      if (((ajx)localObject1).GAZ) {
        localStringBuffer.append("<songalbumurl>").append(bu.aSz(((ajx)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((ajx)localObject1).GBa) {
        localStringBuffer.append("<songlyric>").append(bu.aSz(((ajx)localObject1).songLyric)).append("</songlyric>");
      }
      if (((ajx)localObject1).GAL) {
        localStringBuffer.append("<recordxml>").append(((ajx)localObject1).GAK).append("</recordxml>");
      }
      if (((ajx)localObject1).ixm) {
        localStringBuffer.append("<messageuuid>").append(bu.aSz(((ajx)localObject1).ixk)).append("</messageuuid>");
      }
      Object localObject2 = ((ajx)localObject1).GAu;
      if ((localObject2 == null) || (((ajy)localObject2).GBb == null) || (((ajy)localObject2).GBb.computeSize() == 0))
      {
        ae.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBd != null) && (((ajy)localObject2).GBd.computeSize() != 0)) {
          break label1839;
        }
        ae.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBf != null) && (((ajy)localObject2).GBf.computeSize() != 0)) {
          break label2018;
        }
        ae.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBx != null)) {
          break label2273;
        }
        ae.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBv != null)) {
          break label2289;
        }
        ae.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1433:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBh != null) && (((ajy)localObject2).GBh.computeSize() != 0)) {
          break label2305;
        }
        ae.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1472:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBj != null) && (((ajy)localObject2).GBj.computeSize() != 0)) {
          break label2499;
        }
        ae.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1511:
        localObject1 = ((ajx)localObject1).GAu;
        if ((localObject1 != null) && (((ajy)localObject1).GBs != null)) {
          break label2657;
        }
        ae.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((ajy)localObject2).GBb;
        if (((ajz)localObject2).GBI) {
          localStringBuffer.append("<appid>").append(((ajz)localObject2).appId).append("</appid>");
        }
        if (((ajz)localObject2).GBJ) {
          localStringBuffer.append("<link>").append(bu.aSz(((ajz)localObject2).link)).append("</link>");
        }
        if (((ajz)localObject2).GBM) {
          localStringBuffer.append("<brandid>").append(bu.aSz(((ajz)localObject2).dkZ)).append("</brandid>");
        }
        if ((((ajz)localObject2).GBA) && (((ajz)localObject2).GBF))
        {
          if (((ajz)localObject2).dzZ.equals(((ajz)localObject2).GBE))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bu.aSz(((ajz)localObject2).dzZ)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!x.wb(((ajz)localObject2).dzZ)) && (!com.tencent.mm.al.a.e.ER(((ajz)localObject2).GBE))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bu.aSz(((ajz)localObject2).GBE)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((ajz)localObject2).GBA)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bu.aSz(((ajz)localObject2).dzZ)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((ajz)localObject2).GBF) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bu.aSz(((ajz)localObject2).GBE)).append("</realchatname></dataitemsource>");
        break label1299;
        label1839:
        localObject2 = ((ajy)localObject2).GBd;
        localStringBuffer.append("<locitem>");
        if (((ake)localObject2).GBU) {
          localStringBuffer.append("<label>").append(bu.aSz(((ake)localObject2).label)).append("</label>");
        }
        if (((ake)localObject2).GBS) {
          localStringBuffer.append("<lat>").append(((ake)localObject2).lat).append("</lat>");
        }
        if (((ake)localObject2).GBR) {
          localStringBuffer.append("<lng>").append(((ake)localObject2).lng).append("</lng>");
        }
        if (((ake)localObject2).GBT) {
          localStringBuffer.append("<scale>").append(((ake)localObject2).dzG).append("</scale>");
        }
        if (((ake)localObject2).GBV) {
          localStringBuffer.append("<poiname>").append(((ake)localObject2).dEv).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2018:
        alc localalc = ((ajy)localObject2).GBf;
        localStringBuffer.append("<weburlitem>");
        if (localalc.GCH) {
          localStringBuffer.append("<link>").append(bu.aSz(localalc.GCG)).append("</link>");
        }
        if (localalc.Gzu) {
          localStringBuffer.append("<desc>").append(bu.aSz(localalc.desc)).append("</desc>");
        }
        if (localalc.GCb) {
          localStringBuffer.append("<thumburl>").append(bu.aSz(localalc.thumbUrl)).append("</thumburl>");
        }
        if (localalc.Gzt) {
          localStringBuffer.append("<title>").append(bu.aSz(localalc.title)).append("</title>");
        }
        if (localalc.GCJ) {
          localStringBuffer.append("<opencache>").append(localalc.GCI).append("</opencache>");
        }
        if (localalc.GCK) {
          localStringBuffer.append("<contentattr>").append(localalc.hCH).append("</contentattr>");
        }
        if ((localObject2 == null) || (((ajy)localObject2).Ekw == null)) {
          ae.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((ajy)localObject2).Ekw));
        }
        label2273:
        localStringBuffer.append(com.tencent.mm.plugin.i.a.e.b(((ajy)localObject2).GBx));
        break label1405;
        label2289:
        localStringBuffer.append(b.b(((ajy)localObject2).GBv));
        break label1433;
        label2305:
        localObject2 = ((ajy)localObject2).GBh;
        localStringBuffer.append("<productitem");
        if (((akm)localObject2).GCd) {
          localStringBuffer.append(" type='").append(((akm)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((akm)localObject2).Gzt) {
          localStringBuffer.append("<title>").append(bu.aSz(((akm)localObject2).title)).append("</title>");
        }
        if (((akm)localObject2).Gzu) {
          localStringBuffer.append("<desc>").append(bu.aSz(((akm)localObject2).desc)).append("</desc>");
        }
        if (((akm)localObject2).GCb) {
          localStringBuffer.append("<thumburl>").append(bu.aSz(((akm)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((akm)localObject2).GCc) {
          localStringBuffer.append("<productinfo>").append(bu.aSz(((akm)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1472;
        label2499:
        localObject2 = ((ajy)localObject2).GBj;
        localStringBuffer.append("<tvitem>");
        if (((akw)localObject2).Gzt) {
          localStringBuffer.append("<title>").append(bu.aSz(((akw)localObject2).title)).append("</title>");
        }
        if (((akw)localObject2).Gzu) {
          localStringBuffer.append("<desc>").append(bu.aSz(((akw)localObject2).desc)).append("</desc>");
        }
        if (((akw)localObject2).GCb) {
          localStringBuffer.append("<thumburl>").append(bu.aSz(((akw)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((akw)localObject2).GCc) {
          localStringBuffer.append("<tvinfo>").append(bu.aSz(((akw)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1511;
        label2657:
        localObject1 = ((ajy)localObject1).GBs;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bu.aSz(((ajv)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bu.aSz(((ajv)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((ajv)localObject1).duK).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bu.aSz(((ajv)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((ajv)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bu.aSz(((ajv)localObject1).dlk)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bu.aSz(((ajv)localObject1).Gzq)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((ajv)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((ajv)localObject1).kuE).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((ajv)localObject1).kaX).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ajv)localObject1).dLl })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((ajv)localObject1).subType).append("</subtype>");
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