package com.tencent.mm.pluginsdk.b;

import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean aBZ();
  
  public abstract boolean aCa();
  
  public abstract EmojiInfo aue(String paramString);
  
  public abstract String auh(String paramString);
  
  public abstract void aur(String paramString);
  
  public abstract boolean aus(String paramString);
  
  public abstract boolean aut(String paramString);
  
  public abstract void auu(String paramString);
  
  public abstract void auv(String paramString);
  
  public abstract <T> T c(ar.a parama, T paramT);
  
  public abstract ArrayList<SmileyInfo> cUo();
  
  public abstract ArrayList<SmileyPanelConfigInfo> cUp();
  
  public abstract String cUs();
  
  public abstract void cUt();
  
  public abstract boolean cUw();
  
  public abstract List<v> cUx();
  
  public abstract void cUy();
  
  public abstract boolean cUz();
  
  public abstract void d(ar.a parama, Object paramObject);
  
  public abstract String getAccPath();
  
  public abstract void h(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void i(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void j(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void k(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract EmojiInfo n(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract EmojiInfo p(EmojiInfo paramEmojiInfo);
  
  public abstract void t(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.e
 * JD-Core Version:    0.7.0.1
 */