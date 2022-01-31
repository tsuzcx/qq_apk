package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class as
{
  public String aeskey;
  public String bIW;
  public String bJd;
  public String bNn;
  public long bXr;
  public long createTime;
  public int czq;
  public String czr = "";
  public String dQB;
  public String dQH;
  public String eHA;
  public int eKX;
  public int height;
  public String iYZ;
  public String id;
  public String lnw;
  public String talker;
  public String thumbUrl;
  public int uAR;
  public int uAS;
  public int uAT;
  public int uAU;
  public String uAV = "";
  public String uAW;
  public String uAX;
  public String uAY;
  public boolean uAZ = true;
  public String uBa;
  public int width;
  
  public static as a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    if (paramMap == null) {
      return null;
    }
    as localas = new as();
    localas.uAV = paramString2;
    localas.talker = paramString1;
    localas.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localas.eHA = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localas.bIW = paramString1;
    if (paramString1 == null) {
      localas.bIW = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bk.bl(localas.bIW)) {
      localas.bIW = localas.bIW.toLowerCase();
    }
    try
    {
      localas.uAR = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localas.uAS = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localas.uAT = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localas.uAU = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localas.bJd = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localas.lnw = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$tpurl") != null) {
          localas.dQB = ((String)paramMap.get(".msg.emoji.$tpurl"));
        }
        if (paramMap.get(".msg.emoji.$tpauthkey") != null) {
          localas.dQH = ((String)paramMap.get(".msg.emoji.$tpauthkey"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localas.uAW = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localas.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localas.bNn = ((String)paramMap.get(".msg.emoji.$encrypturl"));
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
          localas.uAX = ((String)paramMap.get(".msg.emoji.$externurl"));
        }
        if (paramMap.get(".msg.emoji.$externmd5") != null) {
          localas.uAY = ((String)paramMap.get(".msg.emoji.$externmd5"));
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localas.uBa = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (paramMap.get(".msg.emoji.$attachedtext") != null) {
          localas.iYZ = ((String)paramMap.get(".msg.emoji.$attachedtext"));
        }
        if (!bk.bl(paramString3)) {
          localas.czr = paramString3;
        }
        y.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[] { localas.id, localas.bIW, Integer.valueOf(localas.uAR), Integer.valueOf(localas.uAS), Integer.valueOf(localas.uAT), Integer.valueOf(localas.uAU), localas.bJd, localas.lnw, localas.dQB, localas.uAW, localas.thumbUrl, localas.bNn, Integer.valueOf(localas.width), Integer.valueOf(localas.height), localas.uAX, localas.uAY });
        return localas;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localas.uAS = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      y.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bk.j(paramMap) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.as
 * JD-Core Version:    0.7.0.1
 */