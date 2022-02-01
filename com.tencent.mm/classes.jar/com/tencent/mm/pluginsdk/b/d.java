package com.tencent.mm.pluginsdk.b;

import android.content.Context;
import com.tencent.mm.an.h.a;
import com.tencent.mm.be.g;
import com.tencent.mm.emoji.sync.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends e
{
  public abstract boolean V(ArrayList<SmileyInfo> paramArrayList);
  
  public abstract boolean W(ArrayList<SmileyPanelConfigInfo> paramArrayList);
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, ca paramca, String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, ca paramca);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, h.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract EmojiInfo aud(String paramString);
  
  public abstract String auf(String paramString);
  
  public abstract List<EmojiInfo> aug(String paramString);
  
  public abstract boolean aui(String paramString);
  
  public abstract ArrayList<String> auj(String paramString);
  
  public abstract String auk(String paramString);
  
  public abstract String aul(String paramString);
  
  public abstract int aum(String paramString);
  
  public abstract String aun(String paramString);
  
  public abstract void auo(String paramString);
  
  public abstract void aup(String paramString);
  
  public abstract void b(a parama);
  
  public abstract boolean cUm();
  
  public abstract g cUq();
  
  public abstract boolean cUr();
  
  public abstract void cUu();
  
  public abstract boolean cUv();
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract String getDataEmojiPath();
  
  public abstract bi gg(String paramString1, String paramString2);
  
  public abstract String gh(String paramString1, String paramString2);
  
  public abstract int q(EmojiInfo paramEmojiInfo);
  
  public abstract int[] r(EmojiInfo paramEmojiInfo);
  
  public abstract byte[] s(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
  
  public abstract boolean x(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.d
 * JD-Core Version:    0.7.0.1
 */