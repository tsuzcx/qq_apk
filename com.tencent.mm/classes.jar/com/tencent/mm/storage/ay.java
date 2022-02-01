package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class ay
{
  public int GXO;
  public int GXP;
  public int GXQ;
  public int GXR;
  public String GXS = "";
  public String GXT;
  public String GXU;
  public String GXV;
  public boolean GXW = true;
  public String GXX;
  public String GXY;
  public String aeskey;
  public long createTime;
  public String dcO;
  public String dgX;
  public long dpl;
  public int euk;
  public String eul = "";
  public String fQL;
  public String gnO;
  public int height;
  public String hhL;
  public String hhR;
  public String iaC;
  public String id;
  public int idS;
  public String md5;
  public String pmO;
  public String talker;
  public String thumbUrl;
  public int width;
  
  public static ay I(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104962);
    if (paramEmojiInfo == null)
    {
      ac.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(104962);
      return null;
    }
    ay localay = new ay();
    localay.md5 = paramEmojiInfo.field_md5;
    localay.GXO = paramEmojiInfo.field_type;
    localay.GXP = paramEmojiInfo.field_size;
    localay.dcO = paramEmojiInfo.field_groupId;
    localay.GXT = paramEmojiInfo.field_designerID;
    localay.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localay.dgX = paramEmojiInfo.field_encrypturl;
    localay.aeskey = paramEmojiInfo.field_aeskey;
    localay.width = paramEmojiInfo.field_width;
    localay.height = paramEmojiInfo.field_height;
    localay.gnO = paramEmojiInfo.field_cdnUrl;
    localay.GXU = paramEmojiInfo.field_externUrl;
    localay.GXV = paramEmojiInfo.field_externMd5;
    localay.GXX = paramEmojiInfo.field_activityid;
    localay.hhL = paramEmojiInfo.field_tpurl;
    localay.hhR = paramEmojiInfo.field_tpauthkey;
    localay.fQL = paramEmojiInfo.field_attachedText;
    localay.pmO = paramEmojiInfo.field_lensId;
    localay.GXY = paramEmojiInfo.field_attachTextColor;
    AppMethodBeat.o(104962);
    return localay;
  }
  
  public static ay a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    ay localay = new ay();
    localay.GXS = paramString2;
    localay.talker = paramString1;
    localay.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localay.iaC = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localay.md5 = paramString1;
    if (paramString1 == null) {
      localay.md5 = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bs.isNullOrNil(localay.md5)) {
      localay.md5 = localay.md5.toLowerCase();
    }
    try
    {
      localay.GXO = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localay.GXP = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localay.GXQ = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localay.GXR = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localay.dcO = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localay.gnO = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localay.hhL = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localay.hhR = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localay.GXT = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localay.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localay.dgX = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localay.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localay.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localay.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localay.GXU = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localay.GXV = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localay.GXX = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localay.fQL = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localay.GXY = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localay.pmO = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (!bs.isNullOrNil(paramString3)) {
          localay.eul = paramString3;
        }
        ac.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localay.id, localay.md5, Integer.valueOf(localay.GXO), Integer.valueOf(localay.GXP), Integer.valueOf(localay.GXQ), Integer.valueOf(localay.GXR), localay.dcO, localay.gnO, localay.hhL, localay.GXT, localay.thumbUrl, localay.dgX, Integer.valueOf(localay.width), Integer.valueOf(localay.height), localay.GXU, localay.GXV });
        AppMethodBeat.o(104965);
        return localay;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localay.GXP = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      ac.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bs.m(paramMap) });
      AppMethodBeat.o(104965);
    }
  }
  
  public static ay e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = a(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static ay lB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    ac.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(bv.L(paramString2, "msg"), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ay
 * JD-Core Version:    0.7.0.1
 */