package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class bk
{
  public int adji;
  public int adjj;
  public int adjk;
  public int adjl;
  public String adjm = "";
  public String adjn;
  public String adjo;
  public String adjp;
  public boolean adjq = true;
  public String adjr;
  public String adjs;
  public String adjt;
  public String aeskey;
  public long createTime;
  public String desc;
  public String hIp;
  public long hTh;
  public int height;
  public String id;
  public int jUq;
  public String jUr = "";
  public String mOI;
  public String md5;
  public String nRn;
  public String paV;
  public int peI;
  public String productId;
  public String talker;
  public String thumbUrl;
  public String tpurl;
  public int width;
  public String ygi;
  public String ygo;
  
  public static bk J(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104962);
    if (paramEmojiInfo == null)
    {
      Log.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(104962);
      return null;
    }
    bk localbk = new bk();
    localbk.md5 = paramEmojiInfo.field_md5;
    localbk.adji = paramEmojiInfo.field_type;
    localbk.adjj = paramEmojiInfo.field_size;
    localbk.productId = paramEmojiInfo.field_groupId;
    localbk.adjn = paramEmojiInfo.field_designerID;
    localbk.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localbk.hIp = paramEmojiInfo.field_encrypturl;
    localbk.aeskey = paramEmojiInfo.field_aeskey;
    localbk.width = paramEmojiInfo.field_width;
    localbk.height = paramEmojiInfo.field_height;
    localbk.mOI = paramEmojiInfo.field_cdnUrl;
    localbk.adjo = paramEmojiInfo.field_externUrl;
    localbk.adjp = paramEmojiInfo.field_externMd5;
    localbk.adjr = paramEmojiInfo.field_activityid;
    localbk.tpurl = paramEmojiInfo.field_tpurl;
    localbk.nRn = paramEmojiInfo.field_tpauthkey;
    localbk.ygi = paramEmojiInfo.field_attachedText;
    localbk.ygo = paramEmojiInfo.field_lensId;
    localbk.adjt = paramEmojiInfo.field_attachTextColor;
    localbk.adjs = paramEmojiInfo.field_linkId;
    AppMethodBeat.o(104962);
    return localbk;
  }
  
  private static bk b(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    bk localbk = new bk();
    localbk.adjm = paramString2;
    localbk.talker = paramString1;
    localbk.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localbk.paV = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localbk.md5 = paramString1;
    if (paramString1 == null) {
      localbk.md5 = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!Util.isNullOrNil(localbk.md5)) {
      localbk.md5 = localbk.md5.toLowerCase();
    }
    try
    {
      localbk.adji = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localbk.adjj = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localbk.adjk = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localbk.adjl = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localbk.productId = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localbk.mOI = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localbk.tpurl = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localbk.nRn = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localbk.adjn = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localbk.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localbk.hIp = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localbk.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localbk.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localbk.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localbk.adjo = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localbk.adjp = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localbk.adjr = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localbk.ygi = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localbk.adjt = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localbk.ygo = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (paramMap.get(".msg.emoji.$linkid") != null) {
          localbk.adjs = ((String)paramMap.get(".msg.emoji.$linkid"));
        }
        if (paramMap.get(".msg.emoji.$desc") != null) {
          localbk.desc = ((String)paramMap.get(".msg.emoji.$desc"));
        }
        if (!Util.isNullOrNil(paramString3)) {
          localbk.jUr = paramString3;
        }
        Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localbk.id, localbk.md5, Integer.valueOf(localbk.adji), Integer.valueOf(localbk.adjj), Integer.valueOf(localbk.adjk), Integer.valueOf(localbk.adjl), localbk.productId, localbk.mOI, localbk.tpurl, localbk.adjn, localbk.thumbUrl, localbk.hIp, Integer.valueOf(localbk.width), Integer.valueOf(localbk.height), localbk.adjo, localbk.adjp });
        AppMethodBeat.o(104965);
        return localbk;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localbk.adjj = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
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
  
  public static bk bH(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(248715);
    Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = b(XmlParser.parseXml(paramString2, "msg", null), paramString1, paramString2, paramString3);
    AppMethodBeat.o(248715);
    return paramString1;
  }
  
  public static bk e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = b(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static bk pK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(XmlParser.parseXml(paramString2, "msg", null), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bk
 * JD-Core Version:    0.7.0.1
 */