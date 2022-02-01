package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract EmojiInfo acj(String paramString);
  
  public abstract String acm(String paramString);
  
  public abstract void acu(String paramString);
  
  public abstract boolean acv(String paramString);
  
  public abstract void acw(String paramString);
  
  public abstract void acx(String paramString);
  
  public abstract boolean afq();
  
  public abstract boolean afr();
  
  public abstract <T> T c(am.a parama, T paramT);
  
  public abstract ArrayList<SmileyInfo> chL();
  
  public abstract ArrayList<SmileyPanelConfigInfo> chM();
  
  public abstract String chP();
  
  public abstract void chQ();
  
  public abstract boolean chR();
  
  public abstract List<v> chS();
  
  public abstract void chT();
  
  public abstract boolean chU();
  
  public abstract void d(am.a parama, Object paramObject);
  
  public abstract String getAccPath();
  
  public abstract void h(k.a parama);
  
  public abstract void i(k.a parama);
  
  public abstract void j(k.a parama);
  
  public abstract void k(k.a parama);
  
  public abstract EmojiInfo l(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onDestroy();
  
  public abstract EmojiInfo p(EmojiInfo paramEmojiInfo);
  
  public abstract void t(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */