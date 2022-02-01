package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.al.e.a;
import com.tencent.mm.bc.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bu;
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
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, bu parambu, String paramString);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, bu parambu);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract int abA(String paramString);
  
  public abstract String abB(String paramString);
  
  public abstract void abC(String paramString);
  
  public abstract EmojiInfo abr(String paramString);
  
  public abstract String abt(String paramString);
  
  public abstract List<EmojiInfo> abu(String paramString);
  
  public abstract boolean abw(String paramString);
  
  public abstract ArrayList<String> abx(String paramString);
  
  public abstract String aby(String paramString);
  
  public abstract String abz(String paramString);
  
  public abstract boolean cgu();
  
  public abstract f cgx();
  
  public abstract boolean cgy();
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract bc fx(String paramString1, String paramString2);
  
  public abstract String fy(String paramString1, String paramString2);
  
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