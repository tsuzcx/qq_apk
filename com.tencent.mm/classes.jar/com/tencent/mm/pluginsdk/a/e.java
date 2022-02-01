package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.u;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract EmojiInfo TA(String paramString);
  
  public abstract String TD(String paramString);
  
  public abstract void TL(String paramString);
  
  public abstract boolean TM(String paramString);
  
  public abstract void TN(String paramString);
  
  public abstract void TO(String paramString);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean abA();
  
  public abstract boolean abz();
  
  public abstract ArrayList<SmileyInfo> bUE();
  
  public abstract ArrayList<SmileyPanelConfigInfo> bUF();
  
  public abstract String bUI();
  
  public abstract void bUJ();
  
  public abstract boolean bUK();
  
  public abstract List<u> bUL();
  
  public abstract void bUM();
  
  public abstract boolean bUN();
  
  public abstract <T> T c(ae.a parama, T paramT);
  
  public abstract void d(ae.a parama, Object paramObject);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */