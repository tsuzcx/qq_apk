package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.bb.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends e
{
  public abstract boolean O(ArrayList<SmileyInfo> paramArrayList);
  
  public abstract boolean P(ArrayList<SmileyPanelConfigInfo> paramArrayList);
  
  public abstract EmojiInfo XL(String paramString);
  
  public abstract String XN(String paramString);
  
  public abstract List<EmojiInfo> XO(String paramString);
  
  public abstract boolean XQ(String paramString);
  
  public abstract ArrayList<String> XR(String paramString);
  
  public abstract String XS(String paramString);
  
  public abstract String XT(String paramString);
  
  public abstract int XU(String paramString);
  
  public abstract String XV(String paramString);
  
  public abstract void XW(String paramString);
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, bo parambo, String paramString);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, bo parambo);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, f.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean cbQ();
  
  public abstract f cbT();
  
  public abstract boolean cbU();
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract ay fn(String paramString1, String paramString2);
  
  public abstract String fo(String paramString1, String paramString2);
  
  public abstract String getDataEmojiPath();
  
  public abstract int q(EmojiInfo paramEmojiInfo);
  
  public abstract int[] r(EmojiInfo paramEmojiInfo);
  
  public abstract byte[] s(EmojiInfo paramEmojiInfo);
  
  public abstract boolean u(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.d
 * JD-Core Version:    0.7.0.1
 */