package com.tencent.mm.pluginsdk.a;

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
  
  public abstract boolean amA(String paramString);
  
  public abstract void amB(String paramString);
  
  public abstract void amC(String paramString);
  
  public abstract EmojiInfo amm(String paramString);
  
  public abstract String amp(String paramString);
  
  public abstract void amy(String paramString);
  
  public abstract boolean amz(String paramString);
  
  public abstract boolean ave();
  
  public abstract boolean avf();
  
  public abstract <T> T c(ar.a parama, T paramT);
  
  public abstract ArrayList<SmileyInfo> cFJ();
  
  public abstract ArrayList<SmileyPanelConfigInfo> cFK();
  
  public abstract String cFN();
  
  public abstract void cFO();
  
  public abstract boolean cFP();
  
  public abstract List<v> cFQ();
  
  public abstract void cFR();
  
  public abstract boolean cFS();
  
  public abstract void d(ar.a parama, Object paramObject);
  
  public abstract String getAccPath();
  
  public abstract void h(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void i(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void j(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void k(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract EmojiInfo l(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onDestroy();
  
  public abstract EmojiInfo p(EmojiInfo paramEmojiInfo);
  
  public abstract void t(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */