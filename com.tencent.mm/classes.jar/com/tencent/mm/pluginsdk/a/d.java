package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.bb.g;
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
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, ca paramca);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, h.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract EmojiInfo aml(String paramString);
  
  public abstract String amn(String paramString);
  
  public abstract List<EmojiInfo> amo(String paramString);
  
  public abstract boolean amq(String paramString);
  
  public abstract ArrayList<String> amr(String paramString);
  
  public abstract String ams(String paramString);
  
  public abstract String amt(String paramString);
  
  public abstract int amu(String paramString);
  
  public abstract String amv(String paramString);
  
  public abstract void amw(String paramString);
  
  public abstract boolean cFH();
  
  public abstract g cFL();
  
  public abstract boolean cFM();
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract bi fT(String paramString1, String paramString2);
  
  public abstract String fU(String paramString1, String paramString2);
  
  public abstract String getDataEmojiPath();
  
  public abstract int q(EmojiInfo paramEmojiInfo);
  
  public abstract int[] r(EmojiInfo paramEmojiInfo);
  
  public abstract byte[] s(EmojiInfo paramEmojiInfo);
  
  public abstract boolean u(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.d
 * JD-Core Version:    0.7.0.1
 */