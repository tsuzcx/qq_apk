package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class o
{
  public static String dl(List<agx> paramList)
  {
    AppMethodBeat.i(9550);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      AppMethodBeat.o(9550);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (agx)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((agx)localObject1).Ezt) {
        localStringBuffer.append("datatype='").append(((agx)localObject1).dataType).append("'");
      }
      if (((agx)localObject1).EzW) {
        localStringBuffer.append(" datastatus='").append(((agx)localObject1).EzV).append("'");
      }
      if (((agx)localObject1).EzC) {
        localStringBuffer.append(" dataid='").append(((agx)localObject1).dhw).append("'");
      }
      if (((agx)localObject1).EAi) {
        localStringBuffer.append(" htmlid='").append(((agx)localObject1).EAh).append("'");
      }
      if (((agx)localObject1).EAo) {
        localStringBuffer.append(" dataillegaltype='").append(((agx)localObject1).EAn).append("'");
      }
      if (((agx)localObject1).EzO) {
        localStringBuffer.append(" datasourceid='").append(((agx)localObject1).EzN).append("'");
      }
      localStringBuffer.append(">");
      if (((agx)localObject1).Ezv) {
        localStringBuffer.append("<datafmt>").append(((agx)localObject1).Ezu).append("</datafmt>");
      }
      if (((agx)localObject1).EyY) {
        localStringBuffer.append("<datatitle>").append(bs.aLw(((agx)localObject1).title)).append("</datatitle>");
      }
      if (((agx)localObject1).EyZ) {
        localStringBuffer.append("<datadesc>").append(bs.aLw(((agx)localObject1).desc)).append("</datadesc>");
      }
      if (((agx)localObject1).Eza) {
        localStringBuffer.append("<cdnthumburl>").append(bs.aLw(((agx)localObject1).hhV)).append("</cdnthumburl>");
      }
      if (((agx)localObject1).Ezd) {
        localStringBuffer.append("<thumbwidth>").append(((agx)localObject1).thumbWidth).append("</thumbwidth>");
      }
      if (((agx)localObject1).Eze) {
        localStringBuffer.append("<thumbheight>").append(((agx)localObject1).thumbHeight).append("</thumbheight>");
      }
      if (((agx)localObject1).Ezg) {
        localStringBuffer.append("<cdndataurl>").append(bs.aLw(((agx)localObject1).Ezf)).append("</cdndataurl>");
      }
      if (((agx)localObject1).Ezc) {
        localStringBuffer.append("<cdnthumbkey>").append(bs.aLw(((agx)localObject1).Ezb)).append("</cdnthumbkey>");
      }
      if (((agx)localObject1).Ezi) {
        localStringBuffer.append("<cdndatakey>").append(bs.aLw(((agx)localObject1).Ezh)).append("</cdndatakey>");
      }
      if (((agx)localObject1).Ezk) {
        localStringBuffer.append("<cdnencryver>").append(((agx)localObject1).Ezj).append("</cdnencryver>");
      }
      if (((agx)localObject1).Ezl) {
        localStringBuffer.append("<duration>").append(((agx)localObject1).duration).append("</duration>");
      }
      if (((agx)localObject1).Ezn) {
        localStringBuffer.append("<streamweburl>").append(bs.aLw(((agx)localObject1).Ezm)).append("</streamweburl>");
      }
      if (((agx)localObject1).Ezp) {
        localStringBuffer.append("<streamdataurl>").append(bs.aLw(((agx)localObject1).Ezo)).append("</streamdataurl>");
      }
      if (((agx)localObject1).Ezr) {
        localStringBuffer.append("<streamlowbandurl>").append(bs.aLw(((agx)localObject1).Ezq)).append("</streamlowbandurl>");
      }
      if (((agx)localObject1).Ezs) {
        localStringBuffer.append("<dataext>").append(bs.aLw(((agx)localObject1).dbZ)).append("</dataext>");
      }
      if (((agx)localObject1).Ezx) {
        localStringBuffer.append("<fullmd5>").append(((agx)localObject1).Ezw).append("</fullmd5>");
      }
      if (((agx)localObject1).Ezz) {
        localStringBuffer.append("<head256md5>").append(((agx)localObject1).Ezy).append("</head256md5>");
      }
      if (((agx)localObject1).EzB) {
        localStringBuffer.append("<datasize>").append(((agx)localObject1).EzA).append("</datasize>");
      }
      if (((agx)localObject1).EzI) {
        localStringBuffer.append("<thumbfullmd5>").append(((agx)localObject1).EzH).append("</thumbfullmd5>");
      }
      if (((agx)localObject1).EzK) {
        localStringBuffer.append("<thumbhead256md5>").append(((agx)localObject1).EzJ).append("</thumbhead256md5>");
      }
      if (((agx)localObject1).EzM) {
        localStringBuffer.append("<thumbsize>").append(((agx)localObject1).EzL).append("</thumbsize>");
      }
      if (((agx)localObject1).EzQ) {
        localStringBuffer.append("<streamvideoid>").append(bs.aLw(((agx)localObject1).EzP)).append("</streamvideoid>");
      }
      if (((agx)localObject1).EzY) {
        localStringBuffer.append("<sourcetitle>").append(bs.aLw(((agx)localObject1).EzX)).append("</sourcetitle>");
      }
      if (((agx)localObject1).EAc) {
        localStringBuffer.append("<sourcename>").append(bs.aLw(((agx)localObject1).EAb)).append("</sourcename>");
      }
      if (((agx)localObject1).EAB) {
        localStringBuffer.append("<sourcedesc>").append(bs.aLw(((agx)localObject1).EAA)).append("</sourcedesc>");
      }
      if (((agx)localObject1).EAD) {
        localStringBuffer.append("<sourceheadurl>").append(bs.aLw(((agx)localObject1).EAC)).append("</sourceheadurl>");
      }
      if (((agx)localObject1).EAe) {
        localStringBuffer.append("<sourcetime>").append(bs.aLw(((agx)localObject1).EAd)).append("</sourcetime>");
      }
      if (((agx)localObject1).EAj) {
        localStringBuffer.append("<statextstr>").append(bs.aLw(((agx)localObject1).dvs)).append("</statextstr>");
      }
      if (((agx)localObject1).EAE) {
        localStringBuffer.append("<songalbumurl>").append(bs.aLw(((agx)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((agx)localObject1).EAF) {
        localStringBuffer.append("<songlyric>").append(bs.aLw(((agx)localObject1).songLyric)).append("</songlyric>");
      }
      if (((agx)localObject1).EAq) {
        localStringBuffer.append("<recordxml>").append(((agx)localObject1).EAp).append("</recordxml>");
      }
      if (((agx)localObject1).iaW) {
        localStringBuffer.append("<messageuuid>").append(bs.aLw(((agx)localObject1).iaU)).append("</messageuuid>");
      }
      Object localObject2 = ((agx)localObject1).EzZ;
      if ((localObject2 == null) || (((agy)localObject2).EAG == null) || (((agy)localObject2).EAG.computeSize() == 0))
      {
        ac.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1299:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAI != null) && (((agy)localObject2).EAI.computeSize() != 0)) {
          break label1839;
        }
        ac.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1338:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAK != null) && (((agy)localObject2).EAK.computeSize() != 0)) {
          break label2018;
        }
        ac.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EBc != null)) {
          break label2273;
        }
        ac.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
        label1405:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EBa != null)) {
          break label2289;
        }
        ac.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
        label1433:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAM != null) && (((agy)localObject2).EAM.computeSize() != 0)) {
          break label2305;
        }
        ac.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1472:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAO != null) && (((agy)localObject2).EAO.computeSize() != 0)) {
          break label2499;
        }
        ac.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1511:
        localObject1 = ((agx)localObject1).EzZ;
        if ((localObject1 != null) && (((agy)localObject1).EAX != null)) {
          break label2657;
        }
        ac.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((agy)localObject2).EAG;
        if (((agz)localObject2).EBn) {
          localStringBuffer.append("<appid>").append(((agz)localObject2).appId).append("</appid>");
        }
        if (((agz)localObject2).EBo) {
          localStringBuffer.append("<link>").append(bs.aLw(((agz)localObject2).link)).append("</link>");
        }
        if (((agz)localObject2).EBr) {
          localStringBuffer.append("<brandid>").append(bs.aLw(((agz)localObject2).cYF)).append("</brandid>");
        }
        if ((((agz)localObject2).EBf) && (((agz)localObject2).EBk))
        {
          if (((agz)localObject2).dng.equals(((agz)localObject2).EBj))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bs.aLw(((agz)localObject2).dng)).append("</fromusr></dataitemsource>");
            break label1299;
          }
          if ((!w.sQ(((agz)localObject2).dng)) && (!com.tencent.mm.al.a.e.Bq(((agz)localObject2).EBj))) {
            break label1299;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bs.aLw(((agz)localObject2).EBj)).append("</realchatname></dataitemsource>");
          break label1299;
        }
        if (((agz)localObject2).EBf)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bs.aLw(((agz)localObject2).dng)).append("</fromusr></dataitemsource>");
          break label1299;
        }
        if (!((agz)localObject2).EBk) {
          break label1299;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bs.aLw(((agz)localObject2).EBj)).append("</realchatname></dataitemsource>");
        break label1299;
        label1839:
        localObject2 = ((agy)localObject2).EAI;
        localStringBuffer.append("<locitem>");
        if (((ahe)localObject2).EBz) {
          localStringBuffer.append("<label>").append(bs.aLw(((ahe)localObject2).label)).append("</label>");
        }
        if (((ahe)localObject2).EBx) {
          localStringBuffer.append("<lat>").append(((ahe)localObject2).lat).append("</lat>");
        }
        if (((ahe)localObject2).EBw) {
          localStringBuffer.append("<lng>").append(((ahe)localObject2).lng).append("</lng>");
        }
        if (((ahe)localObject2).EBy) {
          localStringBuffer.append("<scale>").append(((ahe)localObject2).dmN).append("</scale>");
        }
        if (((ahe)localObject2).EBA) {
          localStringBuffer.append("<poiname>").append(((ahe)localObject2).dry).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1338;
        label2018:
        aic localaic = ((agy)localObject2).EAK;
        localStringBuffer.append("<weburlitem>");
        if (localaic.ECm) {
          localStringBuffer.append("<link>").append(bs.aLw(localaic.ECl)).append("</link>");
        }
        if (localaic.EyZ) {
          localStringBuffer.append("<desc>").append(bs.aLw(localaic.desc)).append("</desc>");
        }
        if (localaic.EBG) {
          localStringBuffer.append("<thumburl>").append(bs.aLw(localaic.thumbUrl)).append("</thumburl>");
        }
        if (localaic.EyY) {
          localStringBuffer.append("<title>").append(bs.aLw(localaic.title)).append("</title>");
        }
        if (localaic.ECo) {
          localStringBuffer.append("<opencache>").append(localaic.ECn).append("</opencache>");
        }
        if (localaic.ECp) {
          localStringBuffer.append("<contentattr>").append(localaic.hhK).append("</contentattr>");
        }
        if ((localObject2 == null) || (((agy)localObject2).CoY == null)) {
          ac.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((agy)localObject2).CoY));
        }
        label2273:
        localStringBuffer.append(com.tencent.mm.plugin.i.a.e.b(((agy)localObject2).EBc));
        break label1405;
        label2289:
        localStringBuffer.append(b.b(((agy)localObject2).EBa));
        break label1433;
        label2305:
        localObject2 = ((agy)localObject2).EAM;
        localStringBuffer.append("<productitem");
        if (((ahm)localObject2).EBI) {
          localStringBuffer.append(" type='").append(((ahm)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((ahm)localObject2).EyY) {
          localStringBuffer.append("<title>").append(bs.aLw(((ahm)localObject2).title)).append("</title>");
        }
        if (((ahm)localObject2).EyZ) {
          localStringBuffer.append("<desc>").append(bs.aLw(((ahm)localObject2).desc)).append("</desc>");
        }
        if (((ahm)localObject2).EBG) {
          localStringBuffer.append("<thumburl>").append(bs.aLw(((ahm)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((ahm)localObject2).EBH) {
          localStringBuffer.append("<productinfo>").append(bs.aLw(((ahm)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1472;
        label2499:
        localObject2 = ((agy)localObject2).EAO;
        localStringBuffer.append("<tvitem>");
        if (((ahw)localObject2).EyY) {
          localStringBuffer.append("<title>").append(bs.aLw(((ahw)localObject2).title)).append("</title>");
        }
        if (((ahw)localObject2).EyZ) {
          localStringBuffer.append("<desc>").append(bs.aLw(((ahw)localObject2).desc)).append("</desc>");
        }
        if (((ahw)localObject2).EBG) {
          localStringBuffer.append("<thumburl>").append(bs.aLw(((ahw)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((ahw)localObject2).EBH) {
          localStringBuffer.append("<tvinfo>").append(bs.aLw(((ahw)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1511;
        label2657:
        localObject1 = ((agy)localObject1).EAX;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bs.aLw(((agv)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bs.aLw(((agv)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((agv)localObject1).dib).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bs.aLw(((agv)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((agv)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bs.aLw(((agv)localObject1).cYQ)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bs.aLw(((agv)localObject1).EyV)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((agv)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((agv)localObject1).jWX).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((agv)localObject1).ccR).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((agv)localObject1).dxK })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((agv)localObject1).subType).append("</subtype>");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.o
 * JD-Core Version:    0.7.0.1
 */