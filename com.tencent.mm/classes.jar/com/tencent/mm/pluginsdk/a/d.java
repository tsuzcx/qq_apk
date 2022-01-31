package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ba.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends e
{
  public abstract String KA(String paramString);
  
  public abstract String KB(String paramString);
  
  public abstract int KC(String paramString);
  
  public abstract String KD(String paramString);
  
  public abstract void KE(String paramString);
  
  public abstract EmojiInfo Kt(String paramString);
  
  public abstract String Kv(String paramString);
  
  public abstract List<EmojiInfo> Kw(String paramString);
  
  public abstract boolean Ky(String paramString);
  
  public abstract ArrayList<String> Kz(String paramString);
  
  public abstract EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, bi parambi, String paramString);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, bi parambi);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama);
  
  public abstract boolean bkT();
  
  public abstract f bkW();
  
  public abstract boolean bkX();
  
  public abstract boolean c(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract as dN(String paramString1, String paramString2);
  
  public abstract String dO(String paramString1, String paramString2);
  
  public abstract int e(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract byte[] l(EmojiInfo paramEmojiInfo);
  
  public abstract int o(EmojiInfo paramEmojiInfo);
  
  public abstract int[] p(EmojiInfo paramEmojiInfo);
  
  public abstract byte[] q(EmojiInfo paramEmojiInfo);
  
  public abstract boolean r(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
  
  public abstract boolean w(ArrayList<SmileyInfo> paramArrayList);
  
  public abstract boolean x(ArrayList<SmileyPanelConfigInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.d
 * JD-Core Version:    0.7.0.1
 */