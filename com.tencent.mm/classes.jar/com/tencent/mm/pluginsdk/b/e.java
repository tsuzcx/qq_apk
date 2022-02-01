package com.tencent.mm.pluginsdk.b;

import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.x;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean aUW();
  
  public abstract boolean aUX();
  
  public abstract EmojiInfo aof(String paramString);
  
  public abstract String aoi(String paramString);
  
  public abstract void aos(String paramString);
  
  public abstract boolean aot(String paramString);
  
  public abstract boolean aou(String paramString);
  
  public abstract void aov(String paramString);
  
  public abstract void aow(String paramString);
  
  public abstract <T> T c(at.a parama, T paramT);
  
  public abstract void d(at.a parama, Object paramObject);
  
  public abstract void dzA();
  
  public abstract boolean dzD();
  
  public abstract List<x> dzE();
  
  public abstract void dzF();
  
  public abstract boolean dzG();
  
  public abstract ArrayList<SmileyInfo> dzv();
  
  public abstract ArrayList<SmileyPanelConfigInfo> dzw();
  
  public abstract String dzz();
  
  public abstract String getAccPath();
  
  public abstract void h(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void i(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void j(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void k(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract EmojiInfo o(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract EmojiInfo p(EmojiInfo paramEmojiInfo);
  
  public abstract void t(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.e
 * JD-Core Version:    0.7.0.1
 */