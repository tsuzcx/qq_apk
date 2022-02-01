package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class bd
{
  public int JfJ;
  public int JfK;
  public int JfL;
  public int JfM;
  public String JfN = "";
  public String JfO;
  public String JfP;
  public String JfQ;
  public boolean JfR = true;
  public String JfS;
  public String JfT;
  public String aeskey;
  public long createTime;
  public long dCd;
  public String dpp;
  public String dtB;
  public int eNc;
  public String eNd = "";
  public String gKg;
  public String gmF;
  public String hCI;
  public String hCO;
  public int height;
  public int iAg;
  public String id;
  public String iwS;
  public String md5;
  public String pWT;
  public String talker;
  public String thumbUrl;
  public int width;
  
  public static bd H(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104962);
    if (paramEmojiInfo == null)
    {
      ae.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(104962);
      return null;
    }
    bd localbd = new bd();
    localbd.md5 = paramEmojiInfo.field_md5;
    localbd.JfJ = paramEmojiInfo.field_type;
    localbd.JfK = paramEmojiInfo.field_size;
    localbd.dpp = paramEmojiInfo.field_groupId;
    localbd.JfO = paramEmojiInfo.field_designerID;
    localbd.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localbd.dtB = paramEmojiInfo.field_encrypturl;
    localbd.aeskey = paramEmojiInfo.field_aeskey;
    localbd.width = paramEmojiInfo.field_width;
    localbd.height = paramEmojiInfo.field_height;
    localbd.gKg = paramEmojiInfo.field_cdnUrl;
    localbd.JfP = paramEmojiInfo.field_externUrl;
    localbd.JfQ = paramEmojiInfo.field_externMd5;
    localbd.JfS = paramEmojiInfo.field_activityid;
    localbd.hCI = paramEmojiInfo.field_tpurl;
    localbd.hCO = paramEmojiInfo.field_tpauthkey;
    localbd.gmF = paramEmojiInfo.field_attachedText;
    localbd.pWT = paramEmojiInfo.field_lensId;
    localbd.JfT = paramEmojiInfo.field_attachTextColor;
    AppMethodBeat.o(104962);
    return localbd;
  }
  
  public static bd a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    bd localbd = new bd();
    localbd.JfN = paramString2;
    localbd.talker = paramString1;
    localbd.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localbd.iwS = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localbd.md5 = paramString1;
    if (paramString1 == null) {
      localbd.md5 = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bu.isNullOrNil(localbd.md5)) {
      localbd.md5 = localbd.md5.toLowerCase();
    }
    try
    {
      localbd.JfJ = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localbd.JfK = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localbd.JfL = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localbd.JfM = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localbd.dpp = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localbd.gKg = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localbd.hCI = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localbd.hCO = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localbd.JfO = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localbd.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localbd.dtB = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localbd.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localbd.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localbd.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localbd.JfP = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localbd.JfQ = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localbd.JfS = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localbd.gmF = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localbd.JfT = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localbd.pWT = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (!bu.isNullOrNil(paramString3)) {
          localbd.eNd = paramString3;
        }
        ae.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localbd.id, localbd.md5, Integer.valueOf(localbd.JfJ), Integer.valueOf(localbd.JfK), Integer.valueOf(localbd.JfL), Integer.valueOf(localbd.JfM), localbd.dpp, localbd.gKg, localbd.hCI, localbd.JfO, localbd.thumbUrl, localbd.dtB, Integer.valueOf(localbd.width), Integer.valueOf(localbd.height), localbd.JfP, localbd.JfQ });
        AppMethodBeat.o(104965);
        return localbd;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localbd.JfK = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      ae.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bu.o(paramMap) });
      AppMethodBeat.o(104965);
    }
  }
  
  public static bd e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = a(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static bd mg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    ae.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(bx.M(paramString2, "msg"), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bd
 * JD-Core Version:    0.7.0.1
 */