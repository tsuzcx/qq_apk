package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract EmojiInfo XM(String paramString);
  
  public abstract String XP(String paramString);
  
  public abstract void XX(String paramString);
  
  public abstract boolean XY(String paramString);
  
  public abstract void XZ(String paramString);
  
  public abstract void Ya(String paramString);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean acy();
  
  public abstract boolean acz();
  
  public abstract <T> T c(ah.a parama, T paramT);
  
  public abstract ArrayList<SmileyInfo> cbR();
  
  public abstract ArrayList<SmileyPanelConfigInfo> cbS();
  
  public abstract String cbV();
  
  public abstract void cbW();
  
  public abstract boolean cbX();
  
  public abstract List<v> cbY();
  
  public abstract void cbZ();
  
  public abstract boolean cca();
  
  public abstract void d(ah.a parama, Object paramObject);
  
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