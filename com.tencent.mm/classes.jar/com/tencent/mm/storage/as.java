package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class as
{
  public String aeskey;
  public long cFn;
  public String cqq;
  public String cqx;
  public long createTime;
  public String cuF;
  public int dnr;
  public String dns = "";
  public String ewF;
  public String fXq;
  public String fgC;
  public String fgI;
  public int gaE;
  public int height;
  public String id;
  public String lsW;
  public String nKP;
  public String talker;
  public String thumbUrl;
  public int width;
  public int yNc;
  public int yNd;
  public int yNe;
  public int yNf;
  public String yNg = "";
  public String yNh;
  public String yNi;
  public String yNj;
  public boolean yNk = true;
  public String yNl;
  public String yNm;
  
  public static as G(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62707);
    if (paramEmojiInfo == null)
    {
      ab.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(62707);
      return null;
    }
    as localas = new as();
    localas.cqq = paramEmojiInfo.field_md5;
    localas.yNc = paramEmojiInfo.field_type;
    localas.yNd = paramEmojiInfo.field_size;
    localas.cqx = paramEmojiInfo.field_groupId;
    localas.yNh = paramEmojiInfo.field_designerID;
    localas.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localas.cuF = paramEmojiInfo.field_encrypturl;
    localas.aeskey = paramEmojiInfo.field_aeskey;
    localas.width = paramEmojiInfo.field_width;
    localas.height = paramEmojiInfo.field_height;
    localas.nKP = paramEmojiInfo.field_cdnUrl;
    localas.yNi = paramEmojiInfo.field_externUrl;
    localas.yNj = paramEmojiInfo.field_externMd5;
    localas.yNl = paramEmojiInfo.field_activityid;
    localas.fgC = paramEmojiInfo.field_tpurl;
    localas.fgI = paramEmojiInfo.field_tpauthkey;
    localas.ewF = paramEmojiInfo.field_attachedText;
    localas.lsW = paramEmojiInfo.field_lensId;
    localas.yNm = paramEmojiInfo.field_attachTextColor;
    AppMethodBeat.o(62707);
    return localas;
  }
  
  public static as a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(62708);
    if (paramMap == null)
    {
      AppMethodBeat.o(62708);
      return null;
    }
    as localas = new as();
    localas.yNg = paramString2;
    localas.talker = paramString1;
    localas.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localas.fXq = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localas.cqq = paramString1;
    if (paramString1 == null) {
      localas.cqq = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bo.isNullOrNil(localas.cqq)) {
      localas.cqq = localas.cqq.toLowerCase();
    }
    try
    {
      localas.yNc = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localas.yNd = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localas.yNe = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localas.yNf = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localas.cqx = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localas.nKP = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localas.fgC = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localas.fgI = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localas.yNh = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localas.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localas.cuF = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localas.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localas.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localas.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localas.yNi = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localas.yNj = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localas.yNl = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localas.ewF = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localas.yNm = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localas.lsW = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (!bo.isNullOrNil(paramString3)) {
          localas.dns = paramString3;
        }
        ab.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localas.id, localas.cqq, Integer.valueOf(localas.yNc), Integer.valueOf(localas.yNd), Integer.valueOf(localas.yNe), Integer.valueOf(localas.yNf), localas.cqx, localas.nKP, localas.fgC, localas.yNh, localas.thumbUrl, localas.cuF, Integer.valueOf(localas.width), Integer.valueOf(localas.height), localas.yNi, localas.yNj });
        AppMethodBeat.o(62708);
        return localas;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localas.yNd = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      ab.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bo.l(paramMap) });
      AppMethodBeat.o(62708);
    }
  }
  
  public static void b(as paramas, EmojiInfo paramEmojiInfo)
  {
    paramEmojiInfo.field_md5 = paramas.cqq;
    paramEmojiInfo.field_svrid = paramas.id;
    paramEmojiInfo.field_type = paramas.yNc;
    paramEmojiInfo.field_size = paramas.yNd;
    paramEmojiInfo.field_groupId = paramas.cqx;
    paramEmojiInfo.field_designerID = paramas.yNh;
    paramEmojiInfo.field_thumbUrl = paramas.thumbUrl;
    paramEmojiInfo.field_cdnUrl = paramas.nKP;
    paramEmojiInfo.field_encrypturl = paramas.cuF;
    paramEmojiInfo.field_aeskey = paramas.aeskey;
    paramEmojiInfo.field_width = paramas.width;
    paramEmojiInfo.field_height = paramas.height;
    paramEmojiInfo.field_externUrl = paramas.yNi;
    paramEmojiInfo.field_externMd5 = paramas.yNj;
    paramEmojiInfo.field_activityid = paramas.yNl;
    paramEmojiInfo.field_tpurl = paramas.fgC;
    paramEmojiInfo.field_tpauthkey = paramas.fgI;
    paramEmojiInfo.field_attachedText = paramas.ewF;
    paramEmojiInfo.field_lensId = paramas.lsW;
    paramEmojiInfo.field_attachTextColor = paramas.yNm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.as
 * JD-Core Version:    0.7.0.1
 */