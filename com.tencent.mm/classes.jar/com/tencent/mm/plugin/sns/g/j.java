package com.tencent.mm.plugin.sns.g;

import android.util.Base64;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cix;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class j
{
  public static String hFI = "<TimelineObject>";
  public static String hFJ = "</TimelineObject>";
  public static String hJN = "]]>";
  
  private static String Oj(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String Ok(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      if (paramString.matches("\\d*")) {}
      for (int i = 1; i == 0; i = 0) {
        return "";
      }
    }
  }
  
  public static String b(bxk parambxk)
  {
    j.a locala = new j.a();
    Object localObject1 = new HashMap();
    locala.xw("TimelineObject");
    locala.xw("id");
    Object localObject2;
    label2011:
    Object localObject3;
    if ((parambxk.lsK == null) || (parambxk.lsK.equals("")))
    {
      locala.setText("0");
      locala.xx("id");
      if (parambxk.hPY != null)
      {
        locala.xw("username");
        locala.setText(parambxk.hPY);
        locala.xx("username");
      }
      locala.xw("createTime");
      locala.setText(parambxk.mPL);
      locala.xx("createTime");
      locala.xw("contentDescShowType");
      locala.xY(parambxk.tNt);
      locala.xx("contentDescShowType");
      locala.xw("contentDescScene");
      locala.xY(parambxk.tNu);
      locala.xx("contentDescScene");
      locala.xw("private");
      locala.setText(parambxk.trR);
      locala.xx("private");
      if ((parambxk.tNq != null) && (!bk.bl(parambxk.tNq.lsK)))
      {
        locala.xw("appInfo");
        locala.xw("id");
        locala.setText(Oj(parambxk.tNq.lsK));
        locala.xx("id");
        locala.xw("version");
        locala.setText(Oj(parambxk.tNq.hQE));
        locala.xx("version");
        locala.xw("appName");
        locala.setText(Oj(parambxk.tNq.kVn));
        locala.xx("appName");
        locala.xw("installUrl");
        locala.setText(Oj(parambxk.tNq.swH));
        locala.xx("installUrl");
        locala.xw("fromUrl");
        locala.setText(Oj(parambxk.tNq.swI));
        locala.xx("fromUrl");
        locala.xx("appInfo");
      }
      if ((parambxk.tNw != null) && (!bk.bl(parambxk.tNw.dSP)))
      {
        locala.xw("streamvideo");
        locala.xw("streamvideourl");
        locala.setText(Oj(parambxk.tNw.dSP));
        locala.xx("streamvideourl");
        locala.xw("streamvideototaltime");
        locala.xY(parambxk.tNw.dSQ);
        locala.xx("streamvideototaltime");
        locala.xw("streamvideotitle");
        locala.setText(Oj(parambxk.tNw.dSR));
        locala.xx("streamvideotitle");
        locala.xw("streamvideowording");
        locala.setText(Oj(parambxk.tNw.dSS));
        locala.xx("streamvideowording");
        locala.xw("streamvideoweburl");
        locala.setText(Oj(parambxk.tNw.dST));
        locala.xx("streamvideoweburl");
        locala.xw("streamvideothumburl");
        locala.setText(Oj(parambxk.tNw.dSU));
        locala.xx("streamvideothumburl");
        locala.xw("streamvideoaduxinfo");
        locala.setText(Oj(parambxk.tNw.dSV));
        locala.xx("streamvideoaduxinfo");
        locala.xw("streamvideopublishid");
        locala.setText(Oj(parambxk.tNw.dSW));
        locala.xx("streamvideopublishid");
        locala.xx("streamvideo");
      }
      if ((parambxk.ouE != null) && (!bk.bl(parambxk.ouE.qTY)))
      {
        locala.xw("websearch");
        locala.xw("relevant_vid");
        locala.setText(Oj(parambxk.ouE.qTY));
        locala.xx("relevant_vid");
        locala.xw("relevant_expand");
        locala.setText(Oj(parambxk.ouE.qTZ));
        locala.xx("relevant_expand");
        locala.xw("relevant_pre_searchid");
        locala.setText(Oj(parambxk.ouE.qUa));
        locala.xx("relevant_pre_searchid");
        locala.xw("relevant_shared_openid");
        locala.setText(Oj(parambxk.ouE.qUb));
        locala.xx("relevant_shared_openid");
        locala.xw("rec_category");
        locala.setText(Oj(parambxk.ouE.qUc));
        locala.xx("rec_category");
        locala.xw("shareUrl");
        locala.setText(Oj(parambxk.ouE.jxR));
        locala.xx("shareUrl");
        locala.xw("shareTitle");
        locala.setText(Oj(parambxk.ouE.jxS));
        locala.xx("shareTitle");
        locala.xw("shareDesc");
        locala.setText(Oj(parambxk.ouE.oBT));
        locala.xx("shareDesc");
        locala.xw("shareImgUrl");
        locala.setText(Oj(parambxk.ouE.qUd));
        locala.xx("shareImgUrl");
        locala.xw("shareString");
        locala.setText(Oj(parambxk.ouE.qUe));
        locala.xx("shareString");
        locala.xw("shareStringUrl");
        locala.setText(Oj(parambxk.ouE.qUf));
        locala.xx("shareStringUrl");
        locala.xw("source");
        locala.setText(Oj(parambxk.ouE.aWf));
        locala.xx("source");
        locala.xw("strPlayCount");
        locala.setText(Oj(parambxk.ouE.qUg));
        locala.xx("strPlayCount");
        locala.xw("titleUrl");
        locala.setText(Oj(parambxk.ouE.qUh));
        locala.xx("titleUrl");
        locala.xw("tagList");
        locala.setText(Oj(parambxk.ouE.qUj));
        locala.xx("tagList");
        locala.xw("channelId");
        locala.setText(Oj(parambxk.ouE.qUk));
        locala.xx("channelId");
        locala.xw("thumbUrl");
        locala.setText(Oj(parambxk.ouE.thumbUrl));
        locala.xx("thumbUrl");
        locala.xx("websearch");
      }
      locala.xw("contentDesc");
      locala.setText(Oj(parambxk.tNo));
      locala.xx("contentDesc");
      locala.xw("contentattr");
      locala.setText(parambxk.dQA);
      locala.xx("contentattr");
      locala.xw("sourceUserName");
      locala.setText(Oj(parambxk.sbK));
      locala.xx("sourceUserName");
      locala.xw("sourceNickName");
      locala.setText(Oj(parambxk.sbL));
      locala.xx("sourceNickName");
      locala.xw("statisticsData");
      locala.setText(Oj(parambxk.tNv));
      locala.xx("statisticsData");
      locala.xw("weappInfo");
      locala.xw("appUserName");
      locala.setText(Oj(parambxk.tNx.username));
      locala.xx("appUserName");
      locala.xw("pagePath");
      locala.setText(Oj(parambxk.tNx.path));
      locala.xx("pagePath");
      locala.xx("weappInfo");
      locala.xw("canvasInfoXml");
      locala.setText(Oj(parambxk.pjl));
      locala.xx("canvasInfoXml");
      if (parambxk.tNp != null)
      {
        float f1 = parambxk.tNp.sGJ;
        float f2 = parambxk.tNp.sGK;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", parambxk.tNp.sGJ);
          ((Map)localObject1).put("latitude", parambxk.tNp.sGK);
          ((Map)localObject1).put("city", bk.ZP(Oj(parambxk.tNp.ffj)));
          ((Map)localObject1).put("poiName", bk.ZP(Oj(parambxk.tNp.lFn)));
          ((Map)localObject1).put("poiAddress", bk.ZP(Oj(parambxk.tNp.oQs)));
          ((Map)localObject1).put("poiScale", parambxk.tNp.tpS);
          ((Map)localObject1).put("poiClassifyId", Oj(parambxk.tNp.tpQ));
          ((Map)localObject1).put("poiClassifyType", parambxk.tNp.oQu);
          ((Map)localObject1).put("poiClickableStatus", parambxk.tNp.tpT);
          locala.k("location", (Map)localObject1);
          locala.xx("location");
        }
      }
      locala.xw("ContentObject");
      locala.xw("contentStyle");
      locala.setText(parambxk.tNr.sPI);
      locala.xx("contentStyle");
      locala.xw("contentSubStyle");
      locala.setText(parambxk.tNr.sPK);
      locala.xx("contentSubStyle");
      locala.xw("title");
      locala.setText(Oj(parambxk.tNr.bGw));
      locala.xx("title");
      locala.xw("description");
      locala.setText(Oj(parambxk.tNr.kRN));
      locala.xx("description");
      locala.xw("contentUrl");
      locala.setText(Oj(parambxk.tNr.kSC));
      locala.xx("contentUrl");
      if (parambxk.tNr.sPJ.size() <= 0) {
        break label2844;
      }
      locala.xw("mediaList");
      localObject2 = parambxk.tNr.sPJ.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label2836;
      }
      localObject3 = (awd)((Iterator)localObject2).next();
      locala.xw("media");
      locala.xw("id");
      if (!Ok(((awd)localObject3).lsK).equals("")) {
        break label2820;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.xx("id");
      locala.xw("type");
      locala.setText(((awd)localObject3).hQR);
      locala.xx("type");
      locala.xw("title");
      locala.setText(Oj(((awd)localObject3).bGw));
      locala.xx("title");
      locala.xw("description");
      locala.setText(Oj(((awd)localObject3).kRN));
      locala.xx("description");
      locala.xw("private");
      locala.setText(((awd)localObject3).trR);
      locala.xx("private");
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((awd)localObject3).trO);
      if (!bk.bl(((awd)localObject3).bIW)) {
        ((Map)localObject1).put("md5", ((awd)localObject3).bIW);
      }
      if (!bk.bl(((awd)localObject3).tsk)) {
        ((Map)localObject1).put("videomd5", ((awd)localObject3).tsk);
      }
      locala.k("url", (Map)localObject1);
      locala.setText(Oj(((awd)localObject3).kSC));
      locala.xx("url");
      if ((((awd)localObject3).trP != null) && (!((awd)localObject3).trP.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((awd)localObject3).trQ);
        locala.k("thumb", (Map)localObject1);
        locala.setText(Oj(((awd)localObject3).trP));
        locala.xx("thumb");
      }
      if (((awd)localObject3).brC > 0)
      {
        locala.xw("subType");
        locala.setText(((awd)localObject3).brC);
        locala.xx("subType");
      }
      if (!bk.bl(((awd)localObject3).oOw))
      {
        locala.xw("userData");
        locala.setText(((awd)localObject3).oOw);
        locala.xx("userData");
      }
      if ((((awd)localObject3).trT != null) && (!((awd)localObject3).trT.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((awd)localObject3).trU);
        locala.k("lowBandUrl", (Map)localObject1);
        locala.setText(Oj(((awd)localObject3).trT));
        locala.xx("lowBandUrl");
      }
      if (((awd)localObject3).trS != null)
      {
        ((Map)localObject1).clear();
        if (((awd)localObject3).trS.tsF > 0.0F) {
          ((Map)localObject1).put("width", ((awd)localObject3).trS.tsF);
        }
        if (((awd)localObject3).trS.tsG > 0.0F) {
          ((Map)localObject1).put("height", ((awd)localObject3).trS.tsG);
        }
        if (((awd)localObject3).trS.tsH > 0.0F) {
          ((Map)localObject1).put("totalSize", ((awd)localObject3).trS.tsH);
        }
        locala.k("size", (Map)localObject1);
        locala.xx("size");
      }
      locala.xx("media");
      break label2011;
      locala.setText(parambxk.lsK);
      break;
      label2820:
      locala.setText(Ok(((awd)localObject3).lsK));
    }
    label2836:
    locala.xx("mediaList");
    label2844:
    locala.hJQ.append(Oj(parambxk.tNr.sPL));
    locala.xx("ContentObject");
    if (parambxk.ouC != null)
    {
      locala.xw("actionInfo");
      if (parambxk.ouC.sug != null)
      {
        locala.xw("appMsg");
        locala.xw("mediaTagName");
        locala.setText(parambxk.ouC.sug.sua);
        locala.xx("mediaTagName");
        locala.xw("messageExt");
        locala.setText(parambxk.ouC.sug.sub);
        locala.xx("messageExt");
        locala.xw("messageAction");
        locala.setText(parambxk.ouC.sug.suc);
        locala.xx("messageAction");
        locala.xx("appMsg");
      }
      locala.xx("actionInfo");
    }
    if ((parambxk.tNq != null) && (!bk.bl(parambxk.tNq.lsK)))
    {
      localObject1 = parambxk.oPO;
      localObject2 = new bvo();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((bvo)localObject2).aH((byte[])localObject3);
      label3066:
      ((bvo)localObject2).tMo = new bvm();
      ((bvo)localObject2).tMo.kOK = parambxk.tNq.lsK;
      try
      {
        localObject2 = Base64.encodeToString(((bvo)localObject2).toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).replace("\n", "");
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TimelineConvert", localIOException, "", new Object[0]);
        }
      }
      parambxk.oPO = ((String)localObject1);
      if (parambxk.oPO != null)
      {
        locala.xw("statExtStr");
        locala.setText(parambxk.oPO);
        locala.xx("statExtStr");
      }
      locala.xx("TimelineObject");
      localObject1 = locala.hJQ.toString();
      y.d("MicroMsg.TimelineConvert", "xmlContent: " + (String)localObject1);
      parambxk = (bxk)localObject1;
      if (bn.s((String)localObject1, "TimelineObject") == null)
      {
        y.e("MicroMsg.TimelineConvert", "xml is error");
        parambxk = "";
      }
      return parambxk;
    }
    catch (Exception localException)
    {
      break label3066;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.j
 * JD-Core Version:    0.7.0.1
 */