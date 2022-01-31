package com.tencent.mm.view.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;

public final class a
{
  public com.tencent.mm.view.f.a AQS;
  public com.tencent.mm.view.e.a ATS;
  public int ATT;
  public int ATU;
  public int ATV;
  public boolean ATW;
  public int ATX;
  private final String TAG;
  public int jpL;
  public String liu;
  public int uEJ;
  public int uEK;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo, int paramInt1, int paramInt2, com.tencent.mm.view.f.a parama, com.tencent.mm.view.e.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(63015);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
    this.ATW = false;
    if ((paramEmojiGroupInfo == null) || (bo.isNullOrNil(paramEmojiGroupInfo.field_productID)))
    {
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
      AppMethodBeat.o(63015);
      return;
    }
    this.ATS = parama1;
    this.AQS = parama;
    this.liu = paramEmojiGroupInfo.field_productID;
    this.jpL = paramInt1;
    this.ATX = paramInt2;
    if ((paramBoolean) || (paramEmojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yPd))))
    {
      parama = this.AQS;
      if (paramEmojiGroupInfo != null) {
        if (paramEmojiGroupInfo.field_productID.equals("TAG_DEFAULT_TAB"))
        {
          paramInt2 = com.tencent.mm.cd.e.dve().aRA();
          parama.dRF();
          this.ATT = paramInt2;
          paramEmojiGroupInfo = this.AQS;
          parama = this.liu;
          if ((paramEmojiGroupInfo.jqe > 0) && (!bo.isNullOrNil(parama))) {
            break label552;
          }
          paramInt2 = 1;
          label166:
          this.uEJ = paramInt2;
          paramEmojiGroupInfo = this.AQS;
          parama = this.liu;
          if (!bo.isNullOrNil(parama)) {
            break label667;
          }
          paramInt2 = 0;
          label192:
          this.uEK = paramInt2;
          this.AQS.a(this);
        }
      }
    }
    for (;;)
    {
      this.ATW = paramBoolean;
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", new Object[] { this.liu, Integer.valueOf(paramInt1), Integer.valueOf(this.ATT), Integer.valueOf(this.uEJ), Integer.valueOf(this.uEK), Integer.valueOf(this.ATU) });
      AppMethodBeat.o(63015);
      return;
      if (paramEmojiGroupInfo.field_productID.equals(String.valueOf(EmojiGroupInfo.yPe)))
      {
        if (com.tencent.mm.view.f.a.isSDCardAvailable())
        {
          paramInt2 = parama.dRv();
          break;
        }
        paramInt2 = 0;
        break;
      }
      if (paramEmojiGroupInfo.field_productID.equals("capture"))
      {
        if (parama.mScene == ChatFooterPanel.vQm) {}
        for (boolean bool = true;; bool = false)
        {
          i = com.tencent.mm.emoji.a.d.Oz().ci(bool).size();
          paramInt2 = i;
          if (!com.tencent.mm.view.f.a.RR(parama.mScene)) {
            break;
          }
          paramInt2 = i + 1;
          break;
        }
      }
      if (paramEmojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yPd)))
      {
        if (com.tencent.mm.view.f.a.isSDCardAvailable())
        {
          paramInt2 = 16;
          break;
        }
        paramInt2 = 0;
        break;
      }
      if (com.tencent.mm.view.f.a.e(paramEmojiGroupInfo))
      {
        paramInt2 = 1;
        if (paramEmojiGroupInfo != null)
        {
          if (paramEmojiGroupInfo.field_count <= 0) {
            break label468;
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
          label468:
          paramInt2 = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().KF(paramEmojiGroupInfo.field_productID);
          paramEmojiGroupInfo.field_count = paramInt2;
          long l = System.currentTimeMillis();
          ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a(paramEmojiGroupInfo);
          ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      paramInt2 = 1;
      break;
      label552:
      if (parama.equals("TAG_STORE_TAB"))
      {
        paramInt2 = 1;
        break label166;
      }
      if (parama.equals("TAG_DEFAULT_TAB"))
      {
        i = (paramEmojiGroupInfo.jqe - paramEmojiGroupInfo.AUU) / paramEmojiGroupInfo.avS(parama);
        label595:
        if (!bo.isNullOrNil(parama)) {
          break label647;
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
        i = paramEmojiGroupInfo.jqe / paramEmojiGroupInfo.avS(parama);
        break label595;
        label647:
        if (parama.equals("TAG_DEFAULT_TAB")) {
          paramInt2 = 3;
        } else {
          paramInt2 = 2;
        }
      }
      label667:
      if (parama.equals("TAG_DEFAULT_TAB"))
      {
        if (x.gN(paramEmojiGroupInfo.zF))
        {
          paramInt2 = 7;
          break label192;
        }
        paramInt2 = paramEmojiGroupInfo.aRI() / paramEmojiGroupInfo.AUO;
        break label192;
      }
      if (paramEmojiGroupInfo.jqe <= 0)
      {
        paramInt2 = 0;
        break label192;
      }
      if (parama.equals("TAG_STORE_TAB"))
      {
        paramInt2 = 3;
        break label192;
      }
      int i = paramEmojiGroupInfo.aRI() / paramEmojiGroupInfo.AUL;
      paramInt2 = i;
      if (x.gN(paramEmojiGroupInfo.zF))
      {
        paramInt2 = i;
        if (i > 4) {
          paramInt2 = 4;
        }
      }
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[] { Integer.valueOf(paramInt2) });
      break label192;
      this.ATT = 1;
      this.uEJ = 1;
      this.uEK = 1;
      this.AQS.a(this);
    }
  }
  
  private boolean dRd()
  {
    AppMethodBeat.i(63016);
    boolean bool = "TAG_DEFAULT_TAB".equals(this.liu);
    AppMethodBeat.o(63016);
    return bool;
  }
  
  public final int aRG()
  {
    return this.uEJ * this.uEK;
  }
  
  public final int dRe()
  {
    return this.uEJ * this.uEK;
  }
  
  public final int dRf()
  {
    AppMethodBeat.i(63017);
    if (aRG() <= 0)
    {
      AppMethodBeat.o(63017);
      return 0;
    }
    if (dRd())
    {
      i = (int)Math.ceil(this.ATT / (aRG() - 1));
      if (this.AQS.dRF())
      {
        AppMethodBeat.o(63017);
        return i + 1;
      }
      AppMethodBeat.o(63017);
      return i;
    }
    int i = (int)Math.ceil(this.ATT / aRG());
    AppMethodBeat.o(63017);
    return i;
  }
  
  public final int getColumnWidth()
  {
    AppMethodBeat.i(63018);
    int i = this.AQS.aRI();
    int j = this.AQS.AUL;
    if ((i == 0) || (j == 0) || (i / j == 0))
    {
      AppMethodBeat.o(63018);
      return j;
    }
    i /= i / j;
    AppMethodBeat.o(63018);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.c.a
 * JD-Core Version:    0.7.0.1
 */