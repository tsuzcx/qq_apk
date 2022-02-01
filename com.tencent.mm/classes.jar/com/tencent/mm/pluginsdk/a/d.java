package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.bb.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
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
  
  public abstract void a(Context paramContext, bv parambv, String paramString);
  
  public abstract void a(String paramString, EmojiInfo paramEmojiInfo, bv parambv);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString);
  
  public abstract boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract EmojiInfo aci(String paramString);
  
  public abstract String ack(String paramString);
  
  public abstract List<EmojiInfo> acl(String paramString);
  
  public abstract boolean acn(String paramString);
  
  public abstract ArrayList<String> aco(String paramString);
  
  public abstract String acp(String paramString);
  
  public abstract String acq(String paramString);
  
  public abstract int acr(String paramString);
  
  public abstract String acs(String paramString);
  
  public abstract void act(String paramString);
  
  public abstract boolean chK();
  
  public abstract f chN();
  
  public abstract boolean chO();
  
  public abstract int d(EmojiInfo paramEmojiInfo, boolean paramBoolean);
  
  public abstract bd fB(String paramString1, String paramString2);
  
  public abstract String fC(String paramString1, String paramString2);
  
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