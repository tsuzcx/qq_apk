package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ai.a.e;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class i
{
  public static String bo(List<xv> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (xv)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((xv)localObject1).sUU) {
        localStringBuffer.append("datatype='").append(((xv)localObject1).aYU).append("'");
      }
      if (((xv)localObject1).sVx) {
        localStringBuffer.append(" datastatus='").append(((xv)localObject1).sVw).append("'");
      }
      if (((xv)localObject1).sVd) {
        localStringBuffer.append(" dataid='").append(((xv)localObject1).kgC).append("'");
      }
      if (((xv)localObject1).sVJ) {
        localStringBuffer.append(" htmlid='").append(((xv)localObject1).sVI).append("'");
      }
      if (((xv)localObject1).sVP) {
        localStringBuffer.append(" dataillegaltype='").append(((xv)localObject1).sVO).append("'");
      }
      if (((xv)localObject1).sVp) {
        localStringBuffer.append(" datasourceid='").append(((xv)localObject1).sVo).append("'");
      }
      localStringBuffer.append(">");
      if (((xv)localObject1).sUW) {
        localStringBuffer.append("<datafmt>").append(((xv)localObject1).sUV).append("</datafmt>");
      }
      if (((xv)localObject1).sUz) {
        localStringBuffer.append("<datatitle>").append(bk.ZP(((xv)localObject1).title)).append("</datatitle>");
      }
      if (((xv)localObject1).sUA) {
        localStringBuffer.append("<datadesc>").append(bk.ZP(((xv)localObject1).desc)).append("</datadesc>");
      }
      if (((xv)localObject1).sUB) {
        localStringBuffer.append("<cdnthumburl>").append(bk.ZP(((xv)localObject1).dQL)).append("</cdnthumburl>");
      }
      if (((xv)localObject1).sUE) {
        localStringBuffer.append("<thumbwidth>").append(((xv)localObject1).dQQ).append("</thumbwidth>");
      }
      if (((xv)localObject1).sUF) {
        localStringBuffer.append("<thumbheight>").append(((xv)localObject1).dQP).append("</thumbheight>");
      }
      if (((xv)localObject1).sUH) {
        localStringBuffer.append("<cdndataurl>").append(bk.ZP(((xv)localObject1).sUG)).append("</cdndataurl>");
      }
      if (((xv)localObject1).sUD) {
        localStringBuffer.append("<cdnthumbkey>").append(bk.ZP(((xv)localObject1).sUC)).append("</cdnthumbkey>");
      }
      if (((xv)localObject1).sUJ) {
        localStringBuffer.append("<cdndatakey>").append(bk.ZP(((xv)localObject1).sUI)).append("</cdndatakey>");
      }
      if (((xv)localObject1).sUL) {
        localStringBuffer.append("<cdnencryver>").append(((xv)localObject1).sUK).append("</cdnencryver>");
      }
      if (((xv)localObject1).sUM) {
        localStringBuffer.append("<duration>").append(((xv)localObject1).duration).append("</duration>");
      }
      if (((xv)localObject1).sUO) {
        localStringBuffer.append("<streamweburl>").append(bk.ZP(((xv)localObject1).sUN)).append("</streamweburl>");
      }
      if (((xv)localObject1).sUQ) {
        localStringBuffer.append("<streamdataurl>").append(bk.ZP(((xv)localObject1).sUP)).append("</streamdataurl>");
      }
      if (((xv)localObject1).sUS) {
        localStringBuffer.append("<streamlowbandurl>").append(bk.ZP(((xv)localObject1).sUR)).append("</streamlowbandurl>");
      }
      if (((xv)localObject1).sUT) {
        localStringBuffer.append("<dataext>").append(bk.ZP(((xv)localObject1).bIm)).append("</dataext>");
      }
      if (((xv)localObject1).sUY) {
        localStringBuffer.append("<fullmd5>").append(((xv)localObject1).sUX).append("</fullmd5>");
      }
      if (((xv)localObject1).sVa) {
        localStringBuffer.append("<head256md5>").append(((xv)localObject1).sUZ).append("</head256md5>");
      }
      if (((xv)localObject1).sVc) {
        localStringBuffer.append("<datasize>").append(((xv)localObject1).sVb).append("</datasize>");
      }
      if (((xv)localObject1).sVj) {
        localStringBuffer.append("<thumbfullmd5>").append(((xv)localObject1).sVi).append("</thumbfullmd5>");
      }
      if (((xv)localObject1).sVl) {
        localStringBuffer.append("<thumbhead256md5>").append(((xv)localObject1).sVk).append("</thumbhead256md5>");
      }
      if (((xv)localObject1).sVn) {
        localStringBuffer.append("<thumbsize>").append(((xv)localObject1).sVm).append("</thumbsize>");
      }
      if (((xv)localObject1).sVr) {
        localStringBuffer.append("<streamvideoid>").append(bk.ZP(((xv)localObject1).sVq)).append("</streamvideoid>");
      }
      if (((xv)localObject1).sVz) {
        localStringBuffer.append("<sourcetitle>").append(bk.ZP(((xv)localObject1).sVy)).append("</sourcetitle>");
      }
      if (((xv)localObject1).sVD) {
        localStringBuffer.append("<sourcename>").append(bk.ZP(((xv)localObject1).sVC)).append("</sourcename>");
      }
      if (((xv)localObject1).sWc) {
        localStringBuffer.append("<sourcedesc>").append(bk.ZP(((xv)localObject1).sWb)).append("</sourcedesc>");
      }
      if (((xv)localObject1).sVF) {
        localStringBuffer.append("<sourcetime>").append(bk.ZP(((xv)localObject1).sVE)).append("</sourcetime>");
      }
      if (((xv)localObject1).sVK) {
        localStringBuffer.append("<statextstr>").append(bk.ZP(((xv)localObject1).bYN)).append("</statextstr>");
      }
      if (((xv)localObject1).sVR) {
        localStringBuffer.append("<recordxml>").append(((xv)localObject1).sVQ).append("</recordxml>");
      }
      Object localObject2 = ((xv)localObject1).sVA;
      if ((localObject2 == null) || (((xw)localObject2).sWd == null) || (((xw)localObject2).sWd.btq() == 0))
      {
        y.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1153:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWf != null) && (((xw)localObject2).sWf.btq() != 0)) {
          break label1637;
        }
        y.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1192:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWh != null) && (((xw)localObject2).sWh.btq() != 0)) {
          break label1816;
        }
        y.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        label1231:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWj != null) && (((xw)localObject2).sWj.btq() != 0)) {
          break label2034;
        }
        y.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1270:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWl != null) && (((xw)localObject2).sWl.btq() != 0)) {
          break label2228;
        }
        y.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1309:
        localObject1 = ((xv)localObject1).sVA;
        if ((localObject1 != null) && (((xw)localObject1).sWu != null)) {
          break label2386;
        }
        y.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((xw)localObject2).sWd;
        if (((xx)localObject2).sWF) {
          localStringBuffer.append("<appid>").append(((xx)localObject2).appId).append("</appid>");
        }
        if (((xx)localObject2).sWG) {
          localStringBuffer.append("<link>").append(bk.ZP(((xx)localObject2).eAl)).append("</link>");
        }
        if (((xx)localObject2).sWJ) {
          localStringBuffer.append("<brandid>").append(bk.ZP(((xx)localObject2).bFn)).append("</brandid>");
        }
        if ((((xx)localObject2).sWx) && (((xx)localObject2).sWC))
        {
          if (((xx)localObject2).bRO.equals(((xx)localObject2).sWB))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bk.ZP(((xx)localObject2).bRO)).append("</fromusr></dataitemsource>");
            break label1153;
          }
          if ((!s.fn(((xx)localObject2).bRO)) && (!e.lq(((xx)localObject2).sWB))) {
            break label1153;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bk.ZP(((xx)localObject2).sWB)).append("</realchatname></dataitemsource>");
          break label1153;
        }
        if (((xx)localObject2).sWx)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bk.ZP(((xx)localObject2).bRO)).append("</fromusr></dataitemsource>");
          break label1153;
        }
        if (!((xx)localObject2).sWC) {
          break label1153;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bk.ZP(((xx)localObject2).sWB)).append("</realchatname></dataitemsource>");
        break label1153;
        label1637:
        localObject2 = ((xw)localObject2).sWf;
        localStringBuffer.append("<locitem>");
        if (((yc)localObject2).sWR) {
          localStringBuffer.append("<label>").append(bk.ZP(((yc)localObject2).label)).append("</label>");
        }
        if (((yc)localObject2).sWP) {
          localStringBuffer.append("<lat>").append(((yc)localObject2).lat).append("</lat>");
        }
        if (((yc)localObject2).sWO) {
          localStringBuffer.append("<lng>").append(((yc)localObject2).lng).append("</lng>");
        }
        if (((yc)localObject2).sWQ) {
          localStringBuffer.append("<scale>").append(((yc)localObject2).bRv).append("</scale>");
        }
        if (((yc)localObject2).sWS) {
          localStringBuffer.append("<poiname>").append(((yc)localObject2).bVA).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1192;
        label1816:
        localObject2 = ((xw)localObject2).sWh;
        localStringBuffer.append("<weburlitem>");
        if (((yy)localObject2).sXH) {
          localStringBuffer.append("<link>").append(bk.ZP(((yy)localObject2).sXG)).append("</link>");
        }
        if (((yy)localObject2).sUA) {
          localStringBuffer.append("<desc>").append(bk.ZP(((yy)localObject2).desc)).append("</desc>");
        }
        if (((yy)localObject2).sWX) {
          localStringBuffer.append("<thumburl>").append(bk.ZP(((yy)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((yy)localObject2).sUz) {
          localStringBuffer.append("<title>").append(bk.ZP(((yy)localObject2).title)).append("</title>");
        }
        if (((yy)localObject2).sXJ) {
          localStringBuffer.append("<opencache>").append(((yy)localObject2).sXI).append("</opencache>");
        }
        if (((yy)localObject2).sXK) {
          localStringBuffer.append("<contentattr>").append(((yy)localObject2).dQA).append("</contentattr>");
        }
        localStringBuffer.append("</weburlitem>");
        break label1231;
        label2034:
        localObject2 = ((xw)localObject2).sWj;
        localStringBuffer.append("<productitem");
        if (((yi)localObject2).sWZ) {
          localStringBuffer.append(" type='").append(((yi)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((yi)localObject2).sUz) {
          localStringBuffer.append("<title>").append(bk.ZP(((yi)localObject2).title)).append("</title>");
        }
        if (((yi)localObject2).sUA) {
          localStringBuffer.append("<desc>").append(bk.ZP(((yi)localObject2).desc)).append("</desc>");
        }
        if (((yi)localObject2).sWX) {
          localStringBuffer.append("<thumburl>").append(bk.ZP(((yi)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((yi)localObject2).sWY) {
          localStringBuffer.append("<productinfo>").append(bk.ZP(((yi)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1270;
        label2228:
        localObject2 = ((xw)localObject2).sWl;
        localStringBuffer.append("<tvitem>");
        if (((ys)localObject2).sUz) {
          localStringBuffer.append("<title>").append(bk.ZP(((ys)localObject2).title)).append("</title>");
        }
        if (((ys)localObject2).sUA) {
          localStringBuffer.append("<desc>").append(bk.ZP(((ys)localObject2).desc)).append("</desc>");
        }
        if (((ys)localObject2).sWX) {
          localStringBuffer.append("<thumburl>").append(bk.ZP(((ys)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((ys)localObject2).sWY) {
          localStringBuffer.append("<tvinfo>").append(bk.ZP(((ys)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1309;
        label2386:
        localObject1 = ((xw)localObject1).sWu;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bk.ZP(((xt)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bk.ZP(((xt)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((xt)localObject1).bOa).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bk.ZP(((xt)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((xt)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bk.ZP(((xt)localObject1).bFw)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bk.ZP(((xt)localObject1).sUv)).append("</sourcedisplayname>");
          localStringBuffer.append("</appbranditem>");
        }
      }
    }
    localStringBuffer.append("</datalist>");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */