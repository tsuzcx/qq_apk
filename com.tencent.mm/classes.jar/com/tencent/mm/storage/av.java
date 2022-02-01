package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class av
{
  public int FyN;
  public int FyO;
  public int FyP;
  public int FyQ;
  public String FyR = "";
  public String FyS;
  public String FyT;
  public String FyU;
  public boolean FyV = true;
  public String FyW;
  public String FyX;
  public String aeskey;
  public long createTime;
  public String dft;
  public String djC;
  public long drA;
  public int esg;
  public String esh = "";
  public String fNa;
  public String gHk;
  public String gHq;
  public String hAb;
  public int hDq;
  public int height;
  public String id;
  public String md5;
  public String oJp;
  public String syH;
  public String talker;
  public String thumbUrl;
  public int width;
  
  public static av I(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104962);
    if (paramEmojiInfo == null)
    {
      ad.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(104962);
      return null;
    }
    av localav = new av();
    localav.md5 = paramEmojiInfo.field_md5;
    localav.FyN = paramEmojiInfo.field_type;
    localav.FyO = paramEmojiInfo.field_size;
    localav.dft = paramEmojiInfo.field_groupId;
    localav.FyS = paramEmojiInfo.field_designerID;
    localav.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localav.djC = paramEmojiInfo.field_encrypturl;
    localav.aeskey = paramEmojiInfo.field_aeskey;
    localav.width = paramEmojiInfo.field_width;
    localav.height = paramEmojiInfo.field_height;
    localav.syH = paramEmojiInfo.field_cdnUrl;
    localav.FyT = paramEmojiInfo.field_externUrl;
    localav.FyU = paramEmojiInfo.field_externMd5;
    localav.FyW = paramEmojiInfo.field_activityid;
    localav.gHk = paramEmojiInfo.field_tpurl;
    localav.gHq = paramEmojiInfo.field_tpauthkey;
    localav.fNa = paramEmojiInfo.field_attachedText;
    localav.oJp = paramEmojiInfo.field_lensId;
    localav.FyX = paramEmojiInfo.field_attachTextColor;
    AppMethodBeat.o(104962);
    return localav;
  }
  
  public static av a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    av localav = new av();
    localav.FyR = paramString2;
    localav.talker = paramString1;
    localav.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localav.hAb = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localav.md5 = paramString1;
    if (paramString1 == null) {
      localav.md5 = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bt.isNullOrNil(localav.md5)) {
      localav.md5 = localav.md5.toLowerCase();
    }
    try
    {
      localav.FyN = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localav.FyO = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localav.FyP = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localav.FyQ = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localav.dft = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localav.syH = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localav.gHk = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localav.gHq = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localav.FyS = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localav.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localav.djC = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localav.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localav.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localav.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localav.FyT = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localav.FyU = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localav.FyW = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localav.fNa = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localav.FyX = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localav.oJp = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (!bt.isNullOrNil(paramString3)) {
          localav.esh = paramString3;
        }
        ad.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localav.id, localav.md5, Integer.valueOf(localav.FyN), Integer.valueOf(localav.FyO), Integer.valueOf(localav.FyP), Integer.valueOf(localav.FyQ), localav.dft, localav.syH, localav.gHk, localav.FyS, localav.thumbUrl, localav.djC, Integer.valueOf(localav.width), Integer.valueOf(localav.height), localav.FyT, localav.FyU });
        AppMethodBeat.o(104965);
        return localav;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localav.FyO = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      ad.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bt.m(paramMap) });
      AppMethodBeat.o(104965);
    }
  }
  
  public static av e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = a(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static av le(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    ad.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(bw.K(paramString2, "msg"), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.av
 * JD-Core Version:    0.7.0.1
 */