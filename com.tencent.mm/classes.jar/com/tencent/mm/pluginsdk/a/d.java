package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.al.f.a;
import com.tencent.mm.bc.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends e
{
  public abstract boolean J(ArrayList<SmileyInfo> paramArrayList);
  
  public abstract boolean K(ArrayList<SmileyPanelConfigInfo> paramArrayList);
  
  public abstract String TB(String paramString);
  
  public abstract List<EmojiInfo> TC(String paramString);
  
  public abstract boolean TE(String paramString);
  
  public abstract ArrayList<String> TF(String paramString);
  
  public abstract String TG(String paramString);
  
  public abstract String TH(String paramString);
  
  public abstract int TI(String paramString);
  
  public abstract String TJ(String paramString);
  
  public abstract void TK(String paramString);
  
  public abstract EmojiInfo Tz(String paramString);
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, bl parambl, String paramString);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, bl parambl);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, f.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract boolean bUD();
  
  public abstract f bUG();
  
  public abstract boolean bUH();
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract av fa(String paramString1, String paramString2);
  
  public abstract String fb(String paramString1, String paramString2);
  
  public abstract String getDataEmojiPath();
  
  public abstract int q(EmojiInfo paramEmojiInfo);
  
  public abstract int[] r(EmojiInfo paramEmojiInfo);
  
  public abstract byte[] s(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
  
  public abstract boolean v(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.d
 * JD-Core Version:    0.7.0.1
 */