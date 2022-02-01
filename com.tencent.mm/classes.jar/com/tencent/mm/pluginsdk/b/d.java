package com.tencent.mm.pluginsdk.b;

import android.content.Context;
import com.tencent.mm.am.g.a;
import com.tencent.mm.emoji.sync.a;
import com.tencent.mm.modelpackage.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends e
{
  public abstract boolean Z(ArrayList<SmileyInfo> paramArrayList);
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, cc paramcc, String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, cc paramcc);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, g.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean aa(ArrayList<SmileyPanelConfigInfo> paramArrayList);
  
  public abstract EmojiInfo aoe(String paramString);
  
  public abstract String aog(String paramString);
  
  public abstract List<EmojiInfo> aoh(String paramString);
  
  public abstract boolean aoj(String paramString);
  
  public abstract ArrayList<String> aok(String paramString);
  
  public abstract String aol(String paramString);
  
  public abstract String aom(String paramString);
  
  public abstract int aon(String paramString);
  
  public abstract String aoo(String paramString);
  
  public abstract void aop(String paramString);
  
  public abstract void aoq(String paramString);
  
  public abstract void b(a parama);
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract void dzB();
  
  public abstract boolean dzC();
  
  public abstract boolean dzt();
  
  public abstract g dzx();
  
  public abstract boolean dzy();
  
  public abstract bk gM(String paramString1, String paramString2);
  
  public abstract String gN(String paramString1, String paramString2);
  
  public abstract String getDataEmojiPath();
  
  public abstract int q(EmojiInfo paramEmojiInfo);
  
  public abstract int[] r(EmojiInfo paramEmojiInfo);
  
  public abstract byte[] s(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
  
  public abstract boolean y(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.d
 * JD-Core Version:    0.7.0.1
 */