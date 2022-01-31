package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.as.a.a;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.u;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract int AE(String paramString);
  
  public abstract ArrayList<EmojiInfo> AF(String paramString);
  
  public abstract boolean AG(String paramString);
  
  public abstract EmojiInfo At(String paramString);
  
  public abstract String Aw(String paramString);
  
  public abstract String FU();
  
  public abstract <T> T a(ac.a parama, T paramT);
  
  public abstract void a(bsl parambsl);
  
  public abstract boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, ArrayList<String> paramArrayList, String paramString2);
  
  public abstract boolean a(EmojiGroupInfo paramEmojiGroupInfo);
  
  public abstract byte[] a(EmojiInfo paramEmojiInfo);
  
  public abstract bsl aHm();
  
  public abstract ArrayList<EmojiGroupInfo> aHn();
  
  public abstract int aHo();
  
  public abstract ArrayList<EmojiInfo> aHp();
  
  public abstract ArrayList<EmojiInfo> aHq();
  
  public abstract a aHr();
  
  public abstract boolean aHs();
  
  public abstract boolean aHt();
  
  public abstract boolean aHu();
  
  public abstract List<u> aHv();
  
  public abstract void aHw();
  
  public abstract void b(ac.a parama, Object paramObject);
  
  public abstract boolean bNy();
  
  public abstract void bv(String paramString, int paramInt);
  
  public abstract EmojiInfo c(EmojiInfo paramEmojiInfo);
  
  public abstract void d(EmojiInfo paramEmojiInfo);
  
  public abstract int fc(boolean paramBoolean);
  
  public abstract void g(j.a parama);
  
  public abstract EmojiInfo h(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void h(j.a parama);
  
  public abstract void i(j.a parama);
  
  public abstract void j(j.a parama);
  
  public abstract void k(j.a parama);
  
  public abstract void l(j.a parama);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */