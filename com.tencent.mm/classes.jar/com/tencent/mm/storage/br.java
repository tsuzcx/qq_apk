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

public abstract interface br
  extends h
{
  public abstract int Bk(String paramString);
  
  public abstract boolean Kh(String paramString);
  
  public abstract b MV();
  
  public abstract int a(au paramau, String paramString);
  
  public abstract int a(au paramau, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(g paramg);
  
  public abstract void a(f paramf);
  
  public abstract void a(au paramau, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void aL(bv parambv);
  
  public abstract void aUY(String paramString);
  
  public abstract boolean aUZ(String paramString);
  
  public abstract au aVa(String paramString);
  
  public abstract void aVb(String paramString);
  
  public abstract boolean aVc(String paramString);
  
  public abstract boolean aVd(String paramString);
  
  public abstract boolean aVe(String paramString);
  
  public abstract boolean aVf(String paramString);
  
  public abstract boolean aVg(String paramString);
  
  public abstract boolean aVh(String paramString);
  
  public abstract boolean aVi(String paramString);
  
  public abstract Cursor aVj(String paramString);
  
  public abstract Cursor aVk(String paramString);
  
  public abstract Cursor aVl(String paramString);
  
  public abstract int aVm(String paramString);
  
  public abstract String aVn(String paramString);
  
  public abstract au aVo(String paramString);
  
  public abstract int aVp(String paramString);
  
  public abstract void aVq(String paramString);
  
  public abstract void aVr(String paramString);
  
  public abstract int aVs(String paramString);
  
  public abstract boolean alg(String paramString);
  
  public abstract void b(i parami, i.c paramc);
  
  public abstract void b(g paramg);
  
  public abstract void b(a parama);
  
  public abstract void bn(LinkedList<String> paramLinkedList);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract String cP(int paramInt, String paramString);
  
  public abstract void d(a parama);
  
  public abstract long e(au paramau);
  
  public abstract Cursor f(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract boolean fuL();
  
  public abstract HashMap<String, Long> fuM();
  
  public abstract void fuN();
  
  public abstract List<String> fuO();
  
  public abstract List<String> fuP();
  
  public abstract Cursor fuQ();
  
  public abstract int fuR();
  
  public abstract String fuS();
  
  public abstract Cursor fuT();
  
  public abstract au fuU();
  
  public abstract Cursor fuV();
  
  public abstract boolean g(au paramau);
  
  public abstract boolean h(au paramau);
  
  public abstract Cursor mf(String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void a(au paramau, br parambr);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(bv parambv, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */