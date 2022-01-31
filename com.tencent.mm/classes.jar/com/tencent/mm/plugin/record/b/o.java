package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class o
{
  public static String bH(List<aca> paramList)
  {
    AppMethodBeat.i(135721);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      AppMethodBeat.o(135721);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (aca)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((aca)localObject1).wSQ) {
        localStringBuffer.append("datatype='").append(((aca)localObject1).dataType).append("'");
      }
      if (((aca)localObject1).wTt) {
        localStringBuffer.append(" datastatus='").append(((aca)localObject1).wTs).append("'");
      }
      if (((aca)localObject1).wSZ) {
        localStringBuffer.append(" dataid='").append(((aca)localObject1).mBq).append("'");
      }
      if (((aca)localObject1).wTF) {
        localStringBuffer.append(" htmlid='").append(((aca)localObject1).wTE).append("'");
      }
      if (((aca)localObject1).wTL) {
        localStringBuffer.append(" dataillegaltype='").append(((aca)localObject1).wTK).append("'");
      }
      if (((aca)localObject1).wTl) {
        localStringBuffer.append(" datasourceid='").append(((aca)localObject1).wTk).append("'");
      }
      localStringBuffer.append(">");
      if (((aca)localObject1).wSS) {
        localStringBuffer.append("<datafmt>").append(((aca)localObject1).wSR).append("</datafmt>");
      }
      if (((aca)localObject1).wSv) {
        localStringBuffer.append("<datatitle>").append(bo.apT(((aca)localObject1).title)).append("</datatitle>");
      }
      if (((aca)localObject1).wSw) {
        localStringBuffer.append("<datadesc>").append(bo.apT(((aca)localObject1).desc)).append("</datadesc>");
      }
      if (((aca)localObject1).wSx) {
        localStringBuffer.append("<cdnthumburl>").append(bo.apT(((aca)localObject1).fgM)).append("</cdnthumburl>");
      }
      if (((aca)localObject1).wSA) {
        localStringBuffer.append("<thumbwidth>").append(((aca)localObject1).fgR).append("</thumbwidth>");
      }
      if (((aca)localObject1).wSB) {
        localStringBuffer.append("<thumbheight>").append(((aca)localObject1).fgQ).append("</thumbheight>");
      }
      if (((aca)localObject1).wSD) {
        localStringBuffer.append("<cdndataurl>").append(bo.apT(((aca)localObject1).wSC)).append("</cdndataurl>");
      }
      if (((aca)localObject1).wSz) {
        localStringBuffer.append("<cdnthumbkey>").append(bo.apT(((aca)localObject1).wSy)).append("</cdnthumbkey>");
      }
      if (((aca)localObject1).wSF) {
        localStringBuffer.append("<cdndatakey>").append(bo.apT(((aca)localObject1).wSE)).append("</cdndatakey>");
      }
      if (((aca)localObject1).wSH) {
        localStringBuffer.append("<cdnencryver>").append(((aca)localObject1).wSG).append("</cdnencryver>");
      }
      if (((aca)localObject1).wSI) {
        localStringBuffer.append("<duration>").append(((aca)localObject1).duration).append("</duration>");
      }
      if (((aca)localObject1).wSK) {
        localStringBuffer.append("<streamweburl>").append(bo.apT(((aca)localObject1).wSJ)).append("</streamweburl>");
      }
      if (((aca)localObject1).wSM) {
        localStringBuffer.append("<streamdataurl>").append(bo.apT(((aca)localObject1).wSL)).append("</streamdataurl>");
      }
      if (((aca)localObject1).wSO) {
        localStringBuffer.append("<streamlowbandurl>").append(bo.apT(((aca)localObject1).wSN)).append("</streamlowbandurl>");
      }
      if (((aca)localObject1).wSP) {
        localStringBuffer.append("<dataext>").append(bo.apT(((aca)localObject1).cpH)).append("</dataext>");
      }
      if (((aca)localObject1).wSU) {
        localStringBuffer.append("<fullmd5>").append(((aca)localObject1).wST).append("</fullmd5>");
      }
      if (((aca)localObject1).wSW) {
        localStringBuffer.append("<head256md5>").append(((aca)localObject1).wSV).append("</head256md5>");
      }
      if (((aca)localObject1).wSY) {
        localStringBuffer.append("<datasize>").append(((aca)localObject1).wSX).append("</datasize>");
      }
      if (((aca)localObject1).wTf) {
        localStringBuffer.append("<thumbfullmd5>").append(((aca)localObject1).wTe).append("</thumbfullmd5>");
      }
      if (((aca)localObject1).wTh) {
        localStringBuffer.append("<thumbhead256md5>").append(((aca)localObject1).wTg).append("</thumbhead256md5>");
      }
      if (((aca)localObject1).wTj) {
        localStringBuffer.append("<thumbsize>").append(((aca)localObject1).wTi).append("</thumbsize>");
      }
      if (((aca)localObject1).wTn) {
        localStringBuffer.append("<streamvideoid>").append(bo.apT(((aca)localObject1).wTm)).append("</streamvideoid>");
      }
      if (((aca)localObject1).wTv) {
        localStringBuffer.append("<sourcetitle>").append(bo.apT(((aca)localObject1).wTu)).append("</sourcetitle>");
      }
      if (((aca)localObject1).wTz) {
        localStringBuffer.append("<sourcename>").append(bo.apT(((aca)localObject1).wTy)).append("</sourcename>");
      }
      if (((aca)localObject1).wTY) {
        localStringBuffer.append("<sourcedesc>").append(bo.apT(((aca)localObject1).wTX)).append("</sourcedesc>");
      }
      if (((aca)localObject1).wUa) {
        localStringBuffer.append("<sourceheadurl>").append(bo.apT(((aca)localObject1).wTZ)).append("</sourceheadurl>");
      }
      if (((aca)localObject1).wTB) {
        localStringBuffer.append("<sourcetime>").append(bo.apT(((aca)localObject1).wTA)).append("</sourcetime>");
      }
      if (((aca)localObject1).wTG) {
        localStringBuffer.append("<statextstr>").append(bo.apT(((aca)localObject1).cGU)).append("</statextstr>");
      }
      if (((aca)localObject1).wTN) {
        localStringBuffer.append("<recordxml>").append(((aca)localObject1).wTM).append("</recordxml>");
      }
      Object localObject2 = ((aca)localObject1).wTw;
      if ((localObject2 == null) || (((acb)localObject2).wUb == null) || (((acb)localObject2).wUb.computeSize() == 0))
      {
        ab.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1198:
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUd != null) && (((acb)localObject2).wUd.computeSize() != 0)) {
          break label1682;
        }
        ab.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1237:
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUf != null) && (((acb)localObject2).wUf.computeSize() != 0)) {
          break label1861;
        }
        ab.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUh != null) && (((acb)localObject2).wUh.computeSize() != 0)) {
          break label2116;
        }
        ab.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1315:
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUj != null) && (((acb)localObject2).wUj.computeSize() != 0)) {
          break label2310;
        }
        ab.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1354:
        localObject1 = ((aca)localObject1).wTw;
        if ((localObject1 != null) && (((acb)localObject1).wUs != null)) {
          break label2468;
        }
        ab.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((acb)localObject2).wUb;
        if (((acc)localObject2).wUE) {
          localStringBuffer.append("<appid>").append(((acc)localObject2).appId).append("</appid>");
        }
        if (((acc)localObject2).wUF) {
          localStringBuffer.append("<link>").append(bo.apT(((acc)localObject2).link)).append("</link>");
        }
        if (((acc)localObject2).wUI) {
          localStringBuffer.append("<brandid>").append(bo.apT(((acc)localObject2).cmx)).append("</brandid>");
        }
        if ((((acc)localObject2).wUw) && (((acc)localObject2).wUB))
        {
          if (((acc)localObject2).czp.equals(((acc)localObject2).wUA))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bo.apT(((acc)localObject2).czp)).append("</fromusr></dataitemsource>");
            break label1198;
          }
          if ((!t.lA(((acc)localObject2).czp)) && (!e.sm(((acc)localObject2).wUA))) {
            break label1198;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bo.apT(((acc)localObject2).wUA)).append("</realchatname></dataitemsource>");
          break label1198;
        }
        if (((acc)localObject2).wUw)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bo.apT(((acc)localObject2).czp)).append("</fromusr></dataitemsource>");
          break label1198;
        }
        if (!((acc)localObject2).wUB) {
          break label1198;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bo.apT(((acc)localObject2).wUA)).append("</realchatname></dataitemsource>");
        break label1198;
        label1682:
        localObject2 = ((acb)localObject2).wUd;
        localStringBuffer.append("<locitem>");
        if (((ach)localObject2).wUQ) {
          localStringBuffer.append("<label>").append(bo.apT(((ach)localObject2).label)).append("</label>");
        }
        if (((ach)localObject2).wUO) {
          localStringBuffer.append("<lat>").append(((ach)localObject2).lat).append("</lat>");
        }
        if (((ach)localObject2).wUN) {
          localStringBuffer.append("<lng>").append(((ach)localObject2).lng).append("</lng>");
        }
        if (((ach)localObject2).wUP) {
          localStringBuffer.append("<scale>").append(((ach)localObject2).cyX).append("</scale>");
        }
        if (((ach)localObject2).wUR) {
          localStringBuffer.append("<poiname>").append(((ach)localObject2).cDl).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1237;
        label1861:
        adf localadf = ((acb)localObject2).wUf;
        localStringBuffer.append("<weburlitem>");
        if (localadf.wVG) {
          localStringBuffer.append("<link>").append(bo.apT(localadf.wVF)).append("</link>");
        }
        if (localadf.wSw) {
          localStringBuffer.append("<desc>").append(bo.apT(localadf.desc)).append("</desc>");
        }
        if (localadf.wUX) {
          localStringBuffer.append("<thumburl>").append(bo.apT(localadf.thumbUrl)).append("</thumburl>");
        }
        if (localadf.wSv) {
          localStringBuffer.append("<title>").append(bo.apT(localadf.title)).append("</title>");
        }
        if (localadf.wVI) {
          localStringBuffer.append("<opencache>").append(localadf.wVH).append("</opencache>");
        }
        if (localadf.wVJ) {
          localStringBuffer.append("<contentattr>").append(localadf.fgB).append("</contentattr>");
        }
        if ((localObject2 == null) || (((acb)localObject2).uVl == null)) {
          ab.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((acb)localObject2).uVl));
        }
        label2116:
        localObject2 = ((acb)localObject2).wUh;
        localStringBuffer.append("<productitem");
        if (((acp)localObject2).wUZ) {
          localStringBuffer.append(" type='").append(((acp)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((acp)localObject2).wSv) {
          localStringBuffer.append("<title>").append(bo.apT(((acp)localObject2).title)).append("</title>");
        }
        if (((acp)localObject2).wSw) {
          localStringBuffer.append("<desc>").append(bo.apT(((acp)localObject2).desc)).append("</desc>");
        }
        if (((acp)localObject2).wUX) {
          localStringBuffer.append("<thumburl>").append(bo.apT(((acp)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((acp)localObject2).wUY) {
          localStringBuffer.append("<productinfo>").append(bo.apT(((acp)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1315;
        label2310:
        localObject2 = ((acb)localObject2).wUj;
        localStringBuffer.append("<tvitem>");
        if (((acz)localObject2).wSv) {
          localStringBuffer.append("<title>").append(bo.apT(((acz)localObject2).title)).append("</title>");
        }
        if (((acz)localObject2).wSw) {
          localStringBuffer.append("<desc>").append(bo.apT(((acz)localObject2).desc)).append("</desc>");
        }
        if (((acz)localObject2).wUX) {
          localStringBuffer.append("<thumburl>").append(bo.apT(((acz)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((acz)localObject2).wUY) {
          localStringBuffer.append("<tvinfo>").append(bo.apT(((acz)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1354;
        label2468:
        localObject1 = ((acb)localObject1).wUs;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bo.apT(((aby)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bo.apT(((aby)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((aby)localObject1).cvs).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bo.apT(((aby)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((aby)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bo.apT(((aby)localObject1).cmG)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bo.apT(((aby)localObject1).wSs)).append("</sourcedisplayname>");
          localStringBuffer.append("</appbranditem>");
        }
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(135721);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.o
 * JD-Core Version:    0.7.0.1
 */