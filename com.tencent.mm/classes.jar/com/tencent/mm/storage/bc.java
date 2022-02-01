package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class bc
{
  public int ILc;
  public int ILd;
  public int ILe;
  public int ILf;
  public String ILg = "";
  public String ILh;
  public String ILi;
  public String ILj;
  public boolean ILk = true;
  public String ILl;
  public String ILm;
  public String aeskey;
  public long createTime;
  public long dAY;
  public String dok;
  public String dsv;
  public int eLr;
  public String eLs = "";
  public String gHx;
  public String gkl;
  public String hAa;
  public int height;
  public String hzU;
  public String id;
  public String itY;
  public int ixn;
  public String md5;
  public String pQo;
  public String talker;
  public String thumbUrl;
  public int width;
  
  public static bc H(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104962);
    if (paramEmojiInfo == null)
    {
      ad.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      AppMethodBeat.o(104962);
      return null;
    }
    bc localbc = new bc();
    localbc.md5 = paramEmojiInfo.field_md5;
    localbc.ILc = paramEmojiInfo.field_type;
    localbc.ILd = paramEmojiInfo.field_size;
    localbc.dok = paramEmojiInfo.field_groupId;
    localbc.ILh = paramEmojiInfo.field_designerID;
    localbc.thumbUrl = paramEmojiInfo.field_thumbUrl;
    localbc.dsv = paramEmojiInfo.field_encrypturl;
    localbc.aeskey = paramEmojiInfo.field_aeskey;
    localbc.width = paramEmojiInfo.field_width;
    localbc.height = paramEmojiInfo.field_height;
    localbc.gHx = paramEmojiInfo.field_cdnUrl;
    localbc.ILi = paramEmojiInfo.field_externUrl;
    localbc.ILj = paramEmojiInfo.field_externMd5;
    localbc.ILl = paramEmojiInfo.field_activityid;
    localbc.hzU = paramEmojiInfo.field_tpurl;
    localbc.hAa = paramEmojiInfo.field_tpauthkey;
    localbc.gkl = paramEmojiInfo.field_attachedText;
    localbc.pQo = paramEmojiInfo.field_lensId;
    localbc.ILm = paramEmojiInfo.field_attachTextColor;
    AppMethodBeat.o(104962);
    return localbc;
  }
  
  public static bc a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104965);
    if (paramMap == null)
    {
      AppMethodBeat.o(104965);
      return null;
    }
    bc localbc = new bc();
    localbc.ILg = paramString2;
    localbc.talker = paramString1;
    localbc.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localbc.itY = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localbc.md5 = paramString1;
    if (paramString1 == null) {
      localbc.md5 = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bt.isNullOrNil(localbc.md5)) {
      localbc.md5 = localbc.md5.toLowerCase();
    }
    try
    {
      localbc.ILc = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localbc.ILd = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localbc.ILe = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localbc.ILf = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localbc.dok = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localbc.gHx = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localbc.hzU = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localbc.hAa = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localbc.ILh = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localbc.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localbc.dsv = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localbc.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localbc.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localbc.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$externurl") != null) {
          localbc.ILi = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localbc.ILj = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localbc.ILl = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localbc.gkl = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (paramMap.get(".msg.emoji.$attachedtextcolor") != null) {
          localbc.ILm = ((String)paramMap.get(".msg.emoji.$attachedtextcolor"));
        }
        if (paramMap.get(".msg.emoji.$lensid") != null) {
          localbc.pQo = ((String)paramMap.get(".msg.emoji.$lensid"));
        }
        if (!bt.isNullOrNil(paramString3)) {
          localbc.eLs = paramString3;
        }
        ad.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localbc.id, localbc.md5, Integer.valueOf(localbc.ILc), Integer.valueOf(localbc.ILd), Integer.valueOf(localbc.ILe), Integer.valueOf(localbc.ILf), localbc.dok, localbc.gHx, localbc.hzU, localbc.ILh, localbc.thumbUrl, localbc.dsv, Integer.valueOf(localbc.width), Integer.valueOf(localbc.height), localbc.ILi, localbc.ILj });
        AppMethodBeat.o(104965);
        return localbc;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localbc.ILd = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      ad.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bt.n(paramMap) });
      AppMethodBeat.o(104965);
    }
  }
  
  public static bc e(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104964);
    paramMap = a(paramMap, paramString1, paramString2, "");
    AppMethodBeat.o(104964);
    return paramMap;
  }
  
  public static bc lZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104963);
    ad.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = e(bw.M(paramString2, "msg"), paramString1, paramString2);
    AppMethodBeat.o(104963);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */