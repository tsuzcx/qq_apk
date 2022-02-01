package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract void abD(String paramString);
  
  public abstract boolean abE(String paramString);
  
  public abstract void abF(String paramString);
  
  public abstract void abG(String paramString);
  
  public abstract EmojiInfo abs(String paramString);
  
  public abstract String abv(String paramString);
  
  public abstract boolean afc();
  
  public abstract boolean afd();
  
  public abstract <T> T c(al.a parama, T paramT);
  
  public abstract void cgA();
  
  public abstract boolean cgB();
  
  public abstract List<v> cgC();
  
  public abstract void cgD();
  
  public abstract boolean cgE();
  
  public abstract ArrayList<SmileyInfo> cgv();
  
  public abstract ArrayList<SmileyPanelConfigInfo> cgw();
  
  public abstract String cgz();
  
  public abstract void d(al.a parama, Object paramObject);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */