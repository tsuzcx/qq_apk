package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.az.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends e
{
  public abstract String AA(String paramString);
  
  public abstract int AB(String paramString);
  
  public abstract String AC(String paramString);
  
  public abstract void AD(String paramString);
  
  public abstract EmojiInfo As(String paramString);
  
  public abstract String Au(String paramString);
  
  public abstract List<EmojiInfo> Av(String paramString);
  
  public abstract boolean Ax(String paramString);
  
  public abstract ArrayList<String> Ay(String paramString);
  
  public abstract String Az(String paramString);
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, bi parambi, String paramString);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, bi parambi);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean aHf();
  
  public abstract boolean aHg();
  
  public abstract ArrayList<q> aHh();
  
  public abstract ArrayList<s> aHi();
  
  public abstract f aHj();
  
  public abstract String aHk();
  
  public abstract void aHl();
  
  public abstract as cM(String paramString1, String paramString2);
  
  public abstract String cN(String paramString1, String paramString2);
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract void d(EmojiInfo paramEmojiInfo);
  
  public abstract int e(EmojiInfo paramEmojiInfo);
  
  public abstract int[] f(EmojiInfo paramEmojiInfo);
  
  public abstract boolean g(EmojiInfo paramEmojiInfo);
  
  public abstract boolean h(EmojiInfo paramEmojiInfo);
  
  public abstract boolean m(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean r(ArrayList<q> paramArrayList);
  
  public abstract boolean s(ArrayList<s> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.d
 * JD-Core Version:    0.7.0.1
 */