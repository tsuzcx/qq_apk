package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.storage.IStorageEx;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface bw
  extends IStorageEx
{
  public abstract int JP(String paramString);
  
  public abstract boolean Tf(String paramString);
  
  public abstract b Xh();
  
  public abstract int a(az paramaz, String paramString);
  
  public abstract int a(az paramaz, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(g paramg);
  
  public abstract void a(f paramf);
  
  public abstract void a(az paramaz, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void aY(ca paramca);
  
  public abstract boolean ayk(String paramString);
  
  public abstract Cursor b(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3);
  
  public abstract void b(i parami, i.c paramc);
  
  public abstract void b(g paramg);
  
  public abstract void b(a parama);
  
  public abstract void bI(LinkedList<String> paramLinkedList);
  
  public abstract void bjW(String paramString);
  
  public abstract boolean bjX(String paramString);
  
  public abstract az bjY(String paramString);
  
  public abstract void bjZ(String paramString);
  
  public abstract boolean bka(String paramString);
  
  public abstract boolean bkb(String paramString);
  
  public abstract boolean bkc(String paramString);
  
  public abstract boolean bkd(String paramString);
  
  public abstract boolean bke(String paramString);
  
  public abstract boolean bkf(String paramString);
  
  public abstract boolean bkg(String paramString);
  
  public abstract Cursor bkh(String paramString);
  
  public abstract Cursor bki(String paramString);
  
  public abstract Cursor bkj(String paramString);
  
  public abstract int bkk(String paramString);
  
  public abstract String bkl(String paramString);
  
  public abstract az bkm(String paramString);
  
  public abstract int bkn(String paramString);
  
  public abstract void bko(String paramString);
  
  public abstract void bkp(String paramString);
  
  public abstract int bkq(String paramString);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract void d(a parama);
  
  public abstract String dk(int paramInt, String paramString);
  
  public abstract long e(az paramaz);
  
  public abstract Cursor f(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract boolean g(az paramaz);
  
  public abstract Cursor gCA();
  
  public abstract az gCB();
  
  public abstract Cursor gCC();
  
  public abstract boolean gCs();
  
  public abstract HashMap<String, Long> gCt();
  
  public abstract void gCu();
  
  public abstract List<String> gCv();
  
  public abstract List<String> gCw();
  
  public abstract Cursor gCx();
  
  public abstract int gCy();
  
  public abstract String gCz();
  
  public abstract boolean h(az paramaz);
  
  public abstract Cursor mT(String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void a(az paramaz, bw parambw);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(ca paramca, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bw
 * JD-Core Version:    0.7.0.1
 */