package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface be
  extends com.tencent.mm.sdk.e.g
{
  public abstract boolean DL(String paramString);
  
  public abstract boolean HH(String paramString);
  
  public abstract int a(ak paramak, String paramString);
  
  public abstract int a(ak paramak, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(f paramf);
  
  public abstract void a(e parame);
  
  public abstract void a(ak paramak, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void aA(LinkedList<String> paramLinkedList);
  
  public abstract boolean abA(String paramString);
  
  public abstract boolean abB(String paramString);
  
  public abstract boolean abC(String paramString);
  
  public abstract boolean abD(String paramString);
  
  public abstract Cursor abE(String paramString);
  
  public abstract Cursor abF(String paramString);
  
  public abstract Cursor abG(String paramString);
  
  public abstract Cursor abH(String paramString);
  
  public abstract int abI(String paramString);
  
  public abstract String abJ(String paramString);
  
  public abstract ak abK(String paramString);
  
  public abstract int abL(String paramString);
  
  public abstract void abM(String paramString);
  
  public abstract void abN(String paramString);
  
  public abstract int abO(String paramString);
  
  public abstract void abu(String paramString);
  
  public abstract ak abv(String paramString);
  
  public abstract void abw(String paramString);
  
  public abstract boolean abx(String paramString);
  
  public abstract boolean aby(String paramString);
  
  public abstract boolean abz(String paramString);
  
  public abstract void aj(bi parambi);
  
  public abstract void b(com.tencent.mm.plugin.messenger.foundation.a.a.g paramg, g.c paramc);
  
  public abstract void b(a parama);
  
  public abstract String bd(int paramInt, String paramString);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract boolean cuC();
  
  public abstract boolean cuD();
  
  public abstract HashMap<String, Long> cuE();
  
  public abstract void cuF();
  
  public abstract List<String> cuH();
  
  public abstract List<String> cuI();
  
  public abstract Cursor cuJ();
  
  public abstract int cuK();
  
  public abstract String cuL();
  
  public abstract Cursor cuM();
  
  public abstract ak cuN();
  
  public abstract long d(ak paramak);
  
  public abstract void d(a parama);
  
  public abstract void d(String[] paramArrayOfString, String paramString);
  
  public abstract boolean f(ak paramak);
  
  public abstract boolean g(ak paramak);
  
  public abstract Cursor go(String paramString1, String paramString2);
  
  public abstract int ie(String paramString);
  
  public abstract Cursor l(List<String> paramList, int paramInt);
  
  public abstract b tt();
  
  public abstract Cursor x(String paramString, List<String> paramList);
  
  public static abstract interface a
  {
    public abstract void a(ak paramak, be parambe);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(bi parambi, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.be
 * JD-Core Version:    0.7.0.1
 */