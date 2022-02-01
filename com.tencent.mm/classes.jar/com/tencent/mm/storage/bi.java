package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class bi
{
  public int OpC;
  public int OpD;
  public int OpE;
  public int OpF;
  public String OpG = "";
  public String OpH;
  public String OpI;
  public String OpJ;
  public boolean OpK = true;
  public String OpL;
  public String OpM;
  public String aeskey;
  public long createTime;
  public String dKK;
  public long dTS;
  public int fqJ;
  public String fqK = "";
  public String gXx;
  public int height;
  public String id;
  public String iwN;
  public String iwT;
  public String jsh;
  public int jvu;
  public String md5;
  public String pkK;
  public String productId;
  public String rnS;
  public String talker;
  public String thumbUrl;
  public int width;
  
  public static bi I(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104962);
    if (paramEmojiInfo == null)
    {
      Log.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(104962);
      return null;
    }
    bi localbi = new bi();
    localbi.md5 = paramEmojiInfo.field_md5;
    localbi.OpC = paramEmojiInfo.field_type;
    localbi.OpD = paramEmojiInfo.field_size;
    localbi.productId = paramEmojiInfo.field_groupId;
    localbi.OpH = paramEmojiInfo.field_designerID;
    localbi.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localbi.dKK = paramEmojiInfo.field_encrypturl;
    localbi.aeskey = paramEmojiInfo.field_aeskey;
    localbi.width = paramEmojiInfo.field_width;
    localbi.height = paramEmojiInfo.field_height;
    localbi.pkK = paramEmojiInfo.field_cdnUrl;
    localbi.OpI = paramEmojiInfo.field_externUrl;
    localbi.OpJ = paramEmojiInfo.field_externMd5;
    localbi.OpL = paramEmojiInfo.field_activityid;
    localbi.iwN = paramEmojiInfo.field_tpurl;
    localbi.iwT = paramEmojiInfo.field_tpauthkey;
    localbi.gXx = paramEmojiInfo.field_attachedText;
    localbi.rnS = paramEmojiInfo.field_lensId;
    localbi.OpM = paramEmojiInfo.field_attachTextColor;
    AppMethodBeat.o(104962);
    return localbi;
  }
  
  private static bi a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    bi localbi = new bi();
    localbi.OpG = paramString2;
    localbi.talker = paramString1;
    localbi.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localbi.jsh = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localbi.md5 = paramString1;
    if (paramString1 == null) {
      localbi.md5 = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!Util.isNullOrNil(localbi.md5)) {
      localbi.md5 = localbi.md5.toLowerCase();
    }
    try
    {
      localbi.OpC = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localbi.OpD = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localbi.OpE = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localbi.OpF = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localbi.productId = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localbi.pkK = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localbi.iwN = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localbi.iwT = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localbi.OpH = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localbi.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localbi.dKK = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localbi.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localbi.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localbi.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localbi.OpI = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localbi.OpJ = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localbi.OpL = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localbi.gXx = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localbi.OpM = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localbi.rnS = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (!Util.isNullOrNil(paramString3)) {
          localbi.fqK = paramString3;
        }
        Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localbi.id, localbi.md5, Integer.valueOf(localbi.OpC), Integer.valueOf(localbi.OpD), Integer.valueOf(localbi.OpE), Integer.valueOf(localbi.OpF), localbi.productId, localbi.pkK, localbi.iwN, localbi.OpH, localbi.thumbUrl, localbi.dKK, Integer.valueOf(localbi.width), Integer.valueOf(localbi.height), localbi.OpI, localbi.OpJ });
        AppMethodBeat.o(104965);
        return localbi;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localbi.OpD = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      Log.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramMap) });
      AppMethodBeat.o(104965);
    }
  }
  
  public static bi bp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(199820);
    Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = a(XmlParser.parseXml(paramString2, "msg", null), paramString1, paramString2, paramString3);
    AppMethodBeat.o(199820);
    return paramString1;
  }
  
  public static bi e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = a(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static bi mU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(XmlParser.parseXml(paramString2, "msg", null), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bi
 * JD-Core Version:    0.7.0.1
 */