package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.h;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface bq
  extends h
{
  public abstract int AA(String paramString);
  
  public abstract boolean JI(String paramString);
  
  public abstract b Na();
  
  public abstract int a(at paramat, String paramString);
  
  public abstract int a(at paramat, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(g paramg);
  
  public abstract void a(f paramf);
  
  public abstract void a(at paramat, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void aM(bu parambu);
  
  public abstract void aTA(String paramString);
  
  public abstract boolean aTB(String paramString);
  
  public abstract boolean aTC(String paramString);
  
  public abstract boolean aTD(String paramString);
  
  public abstract boolean aTE(String paramString);
  
  public abstract boolean aTF(String paramString);
  
  public abstract boolean aTG(String paramString);
  
  public abstract boolean aTH(String paramString);
  
  public abstract Cursor aTI(String paramString);
  
  public abstract Cursor aTJ(String paramString);
  
  public abstract Cursor aTK(String paramString);
  
  public abstract int aTL(String paramString);
  
  public abstract String aTM(String paramString);
  
  public abstract at aTN(String paramString);
  
  public abstract int aTO(String paramString);
  
  public abstract void aTP(String paramString);
  
  public abstract void aTQ(String paramString);
  
  public abstract int aTR(String paramString);
  
  public abstract void aTx(String paramString);
  
  public abstract boolean aTy(String paramString);
  
  public abstract at aTz(String paramString);
  
  public abstract boolean aki(String paramString);
  
  public abstract void b(i parami, i.c paramc);
  
  public abstract void b(g paramg);
  
  public abstract void b(a parama);
  
  public abstract void bm(LinkedList<String> paramLinkedList);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract String cP(int paramInt, String paramString);
  
  public abstract void d(a parama);
  
  public abstract long e(at paramat);
  
  public abstract Cursor f(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract boolean fqL();
  
  public abstract HashMap<String, Long> fqM();
  
  public abstract void fqN();
  
  public abstract List<String> fqO();
  
  public abstract List<String> fqP();
  
  public abstract Cursor fqQ();
  
  public abstract int fqR();
  
  public abstract String fqS();
  
  public abstract Cursor fqT();
  
  public abstract at fqU();
  
  public abstract Cursor fqV();
  
  public abstract boolean g(at paramat);
  
  public abstract boolean h(at paramat);
  
  public abstract Cursor lY(String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void a(at paramat, bq parambq);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(bu parambu, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bq
 * JD-Core Version:    0.7.0.1
 */