package com.tencent.mm.view.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.view.e.a.a;

public final class a
{
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
  public int hxB;
  public String iZD;
  public int qPB;
  public int qPC;
  public com.tencent.mm.view.f.a wvQ;
  public com.tencent.mm.view.e.a wyA;
  public int wyB;
  public int wyC;
  public int wyD;
  public boolean wyE = false;
  public int wyF;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo, int paramInt1, int paramInt2, com.tencent.mm.view.f.a parama, com.tencent.mm.view.e.a parama1, boolean paramBoolean)
  {
    if ((paramEmojiGroupInfo == null) || (bk.bl(paramEmojiGroupInfo.field_productID)))
    {
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
      return;
    }
    this.wyA = parama1;
    this.wvQ = parama;
    this.iZD = paramEmojiGroupInfo.field_productID;
    this.hxB = paramInt1;
    this.wyF = paramInt2;
    int i;
    if ((paramBoolean) || (paramEmojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.uCQ))))
    {
      parama = this.wvQ;
      if (paramEmojiGroupInfo != null) {
        if (paramEmojiGroupInfo.field_productID.equals("TAG_DEFAULT_TAB"))
        {
          paramInt2 = com.tencent.mm.cd.e.csH().asw();
          parama.cMh();
          i = paramInt2;
          if (parama.wzG) {
            i = paramInt2 - 1;
          }
          this.wyB = i;
          paramEmojiGroupInfo = this.wvQ;
          parama = this.iZD;
          if ((paramEmojiGroupInfo.hxU > 0) && (!bk.bl(parama))) {
            break label561;
          }
          paramInt2 = 1;
          label173:
          this.qPB = paramInt2;
          paramEmojiGroupInfo = this.wvQ;
          parama = this.iZD;
          if (!bk.bl(parama)) {
            break label676;
          }
          paramInt2 = 0;
          label199:
          this.qPC = paramInt2;
          this.wvQ.a(this);
        }
      }
    }
    for (;;)
    {
      this.wyE = paramBoolean;
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", new Object[] { this.iZD, Integer.valueOf(paramInt1), Integer.valueOf(this.wyB), Integer.valueOf(this.qPB), Integer.valueOf(this.qPC), Integer.valueOf(this.wyC) });
      return;
      if (paramEmojiGroupInfo.field_productID.equals(String.valueOf(EmojiGroupInfo.uCR)))
      {
        if (com.tencent.mm.view.f.a.isSDCardAvailable())
        {
          if ((!bk.bl(parama.seQ)) && ((ad.aaU(parama.seQ)) || (s.hb(parama.seQ))))
          {
            paramInt2 = ((d)g.t(d.class)).getProvider().fc(false) + 1;
            break;
          }
          paramInt2 = ((d)g.t(d.class)).getProvider().fc(true) + 1;
          break;
        }
        paramInt2 = 0;
        break;
      }
      if (paramEmojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.uCQ)))
      {
        if (com.tencent.mm.view.f.a.isSDCardAvailable())
        {
          paramInt2 = 16;
          break;
        }
        paramInt2 = 0;
        break;
      }
      if (com.tencent.mm.view.f.a.d(paramEmojiGroupInfo))
      {
        paramInt2 = 1;
        if (paramEmojiGroupInfo != null)
        {
          if (paramEmojiGroupInfo.field_count <= 0) {
            break label477;
          }
          paramInt2 = paramEmojiGroupInfo.field_count;
        }
        for (;;)
        {
          i = paramInt2;
          if (paramInt2 == 0) {
            i = 1;
          }
          paramInt2 = i;
          if (com.tencent.mm.view.f.a.isSDCardAvailable()) {
            break;
          }
          paramInt2 = 0;
          break;
          label477:
          paramInt2 = ((d)g.t(d.class)).getProvider().AE(paramEmojiGroupInfo.field_productID);
          paramEmojiGroupInfo.field_count = paramInt2;
          long l = System.currentTimeMillis();
          ((d)g.t(d.class)).getProvider().a(paramEmojiGroupInfo);
          y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      paramInt2 = 1;
      break;
      label561:
      if (parama.equals("TAG_STORE_TAB"))
      {
        paramInt2 = 1;
        break label173;
      }
      if (parama.equals("TAG_DEFAULT_TAB"))
      {
        i = (paramEmojiGroupInfo.hxU - paramEmojiGroupInfo.wzz) / paramEmojiGroupInfo.afb(parama);
        label604:
        if (!bk.bl(parama)) {
          break label656;
        }
        paramInt2 = 0;
      }
      for (;;)
      {
        int j = i;
        if (i > paramInt2) {
          j = paramInt2;
        }
        paramInt2 = j;
        if (j > 0) {
          break;
        }
        paramInt2 = 1;
        break;
        i = paramEmojiGroupInfo.hxU / paramEmojiGroupInfo.afb(parama);
        break label604;
        label656:
        if (parama.equals("TAG_DEFAULT_TAB")) {
          paramInt2 = 3;
        } else {
          paramInt2 = 2;
        }
      }
      label676:
      if (parama.equals("TAG_DEFAULT_TAB"))
      {
        if (paramEmojiGroupInfo.cMd())
        {
          paramInt2 = 7;
          break label199;
        }
        paramInt2 = paramEmojiGroupInfo.cLU() / paramEmojiGroupInfo.wzt;
        break label199;
      }
      if (paramEmojiGroupInfo.hxU <= 0)
      {
        paramInt2 = 0;
        break label199;
      }
      if (parama.equals("TAG_STORE_TAB"))
      {
        paramInt2 = 3;
        break label199;
      }
      i = paramEmojiGroupInfo.cLU() / paramEmojiGroupInfo.wzq;
      paramInt2 = i;
      if (paramEmojiGroupInfo.cMd())
      {
        paramInt2 = i;
        if (i > 4) {
          paramInt2 = 4;
        }
      }
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[] { Integer.valueOf(paramInt2) });
      break label199;
      this.wyB = 1;
      this.qPB = 1;
      this.qPC = 1;
      this.wvQ.a(this);
    }
  }
  
  public final int asD()
  {
    return this.qPB * this.qPC;
  }
  
  public final int cLI()
  {
    int i;
    if (asD() <= 0) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      if (!"TAG_DEFAULT_TAB".equals(this.iZD)) {
        break;
      }
      j = (int)Math.ceil(this.wyB / (asD() - 1));
      i = j;
    } while (!this.wvQ.cMh());
    return j + 1;
    return (int)Math.ceil(this.wyB / asD());
  }
  
  public final ChatFooterPanel.a cLJ()
  {
    com.tencent.mm.view.e.a locala = this.wyA;
    if (locala.wyV == null) {
      return null;
    }
    return locala.wyV.getTextOpListener();
  }
  
  public final int getColumnWidth()
  {
    return this.wvQ.cLU() / (this.wvQ.cLU() / this.wvQ.wzq);
  }
  
  public final j getSmileyPanelCallback()
  {
    com.tencent.mm.view.e.a locala = this.wyA;
    if (locala.wyV == null) {
      return null;
    }
    return locala.wyV.getSmileyPanelCallback();
  }
  
  public final int getType()
  {
    String str = this.iZD;
    if (str.equals("TAG_DEFAULT_TAB")) {
      return 20;
    }
    if (str.equals(String.valueOf(EmojiGroupInfo.uCR))) {
      return 25;
    }
    return 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.c.a
 * JD-Core Version:    0.7.0.1
 */