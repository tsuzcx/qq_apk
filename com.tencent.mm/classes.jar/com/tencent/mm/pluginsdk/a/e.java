package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.at.a.a;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract int KF(String paramString);
  
  public abstract boolean KG(String paramString);
  
  public abstract void KH(String paramString);
  
  public abstract EmojiInfo Ku(String paramString);
  
  public abstract String Kx(String paramString);
  
  public abstract ArrayList<EmojiInfo> OA();
  
  public abstract ArrayList<EmojiGroupInfo> OB();
  
  public abstract boolean OQ();
  
  public abstract boolean OR();
  
  public abstract void a(EmojiCaptureUploadManager.UploadTask paramUploadTask);
  
  public abstract void a(cda paramcda);
  
  public abstract boolean a(EmojiGroupInfo paramEmojiGroupInfo);
  
  public abstract void b(EmojiCaptureUploadManager.UploadTask paramUploadTask);
  
  public abstract ArrayList<SmileyInfo> bkU();
  
  public abstract ArrayList<SmileyPanelConfigInfo> bkV();
  
  public abstract String bkY();
  
  public abstract void bkZ();
  
  public abstract cda blb();
  
  public abstract int blc();
  
  public abstract a bld();
  
  public abstract boolean ble();
  
  public abstract List<s> blf();
  
  public abstract void blg();
  
  public abstract boolean blh();
  
  public abstract <T> T c(ac.a parama, T paramT);
  
  public abstract void cb(String paramString, int paramInt);
  
  public abstract ArrayList<EmojiInfo> ch(boolean paramBoolean);
  
  public abstract void d(ac.a parama, Object paramObject);
  
  public abstract void e(k.a parama);
  
  public abstract void f(k.a parama);
  
  public abstract void g(k.a parama);
  
  public abstract String getAccPath();
  
  public abstract void h(k.a parama);
  
  public abstract void i(k.a parama);
  
  public abstract EmojiInfo j(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void j(k.a parama);
  
  public abstract byte[] l(EmojiInfo paramEmojiInfo);
  
  public abstract ArrayList<EmojiInfo> lL(String paramString);
  
  public abstract EmojiInfo n(EmojiInfo paramEmojiInfo);
  
  public abstract void onDestroy();
  
  public abstract void r(EmojiInfo paramEmojiInfo);
  
  public abstract void s(EmojiInfo paramEmojiInfo);
  
  public abstract void updateEmojiInfo(EmojiInfo paramEmojiInfo);
  
  public abstract int y(boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */