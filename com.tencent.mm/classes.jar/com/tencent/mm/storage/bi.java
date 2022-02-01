package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class bi
{
  public String VFA;
  public String VFB;
  public String VFC;
  public boolean VFD = true;
  public String VFE;
  public String VFF;
  public String VFG;
  public int VFv;
  public int VFw;
  public int VFx;
  public int VFy;
  public String VFz = "";
  public String aeskey;
  public long createTime;
  public String fDz;
  public long fNu;
  public int height;
  public int hxx;
  public String hxy = "";
  public String id;
  public String jIv;
  public String lmc;
  public String lmi;
  public String md5;
  public String mhK;
  public int mkX;
  public String productId;
  public String smT;
  public String talker;
  public String thumbUrl;
  public String uTz;
  public int width;
  
  public static bi J(EmojiInfo paramEmojiInfo)
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
    localbi.VFv = paramEmojiInfo.field_type;
    localbi.VFw = paramEmojiInfo.field_size;
    localbi.productId = paramEmojiInfo.field_groupId;
    localbi.VFA = paramEmojiInfo.field_designerID;
    localbi.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localbi.fDz = paramEmojiInfo.field_encrypturl;
    localbi.aeskey = paramEmojiInfo.field_aeskey;
    localbi.width = paramEmojiInfo.field_width;
    localbi.height = paramEmojiInfo.field_height;
    localbi.smT = paramEmojiInfo.field_cdnUrl;
    localbi.VFB = paramEmojiInfo.field_externUrl;
    localbi.VFC = paramEmojiInfo.field_externMd5;
    localbi.VFE = paramEmojiInfo.field_activityid;
    localbi.lmc = paramEmojiInfo.field_tpurl;
    localbi.lmi = paramEmojiInfo.field_tpauthkey;
    localbi.jIv = paramEmojiInfo.field_attachedText;
    localbi.uTz = paramEmojiInfo.field_lensId;
    localbi.VFG = paramEmojiInfo.field_attachTextColor;
    localbi.VFF = paramEmojiInfo.field_linkId;
    AppMethodBeat.o(104962);
    return localbi;
  }
  
  private static bi b(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    bi localbi = new bi();
    localbi.VFz = paramString2;
    localbi.talker = paramString1;
    localbi.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localbi.mhK = ((String)paramMap.get(".msg.emoji.$fromusername"));
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
      localbi.VFv = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localbi.VFw = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localbi.VFx = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localbi.VFy = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localbi.productId = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localbi.smT = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localbi.lmc = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localbi.lmi = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localbi.VFA = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localbi.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localbi.fDz = ((String)paramMap.get(".msg.emoji.$encrypturl"));
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
          localbi.VFB = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localbi.VFC = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localbi.VFE = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localbi.jIv = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localbi.VFG = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localbi.uTz = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (paramMap.get(".msg.emoji.$linkid") != null) {
          localbi.VFF = ((String)paramMap.get(".msg.emoji.$linkid"));
        }
        if (!Util.isNullOrNil(paramString3)) {
          localbi.hxy = paramString3;
        }
        Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localbi.id, localbi.md5, Integer.valueOf(localbi.VFv), Integer.valueOf(localbi.VFw), Integer.valueOf(localbi.VFx), Integer.valueOf(localbi.VFy), localbi.productId, localbi.smT, localbi.lmc, localbi.VFA, localbi.thumbUrl, localbi.fDz, Integer.valueOf(localbi.width), Integer.valueOf(localbi.height), localbi.VFB, localbi.VFC });
        AppMethodBeat.o(104965);
        return localbi;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localbi.VFw = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
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
  
  public static bi bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(229041);
    Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = b(XmlParser.parseXml(paramString2, "msg", null), paramString1, paramString2, paramString3);
    AppMethodBeat.o(229041);
    return paramString1;
  }
  
  public static bi e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = b(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static bi nM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(XmlParser.parseXml(paramString2, "msg", null), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bi
 * JD-Core Version:    0.7.0.1
 */