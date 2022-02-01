package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface bk
  extends com.tencent.mm.sdk.e.h
{
  public abstract boolean Gt(String paramString);
  
  public abstract b Ls();
  
  public abstract int a(ap paramap, String paramString);
  
  public abstract int a(ap paramap, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(f paramf);
  
  public abstract void a(e parame);
  
  public abstract void a(ap paramap, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void aJ(bo parambo);
  
  public abstract void aNG(String paramString);
  
  public abstract boolean aNH(String paramString);
  
  public abstract ap aNI(String paramString);
  
  public abstract void aNJ(String paramString);
  
  public abstract boolean aNK(String paramString);
  
  public abstract boolean aNL(String paramString);
  
  public abstract boolean aNM(String paramString);
  
  public abstract boolean aNN(String paramString);
  
  public abstract boolean aNO(String paramString);
  
  public abstract boolean aNP(String paramString);
  
  public abstract boolean aNQ(String paramString);
  
  public abstract Cursor aNR(String paramString);
  
  public abstract Cursor aNS(String paramString);
  
  public abstract Cursor aNT(String paramString);
  
  public abstract int aNU(String paramString);
  
  public abstract String aNV(String paramString);
  
  public abstract ap aNW(String paramString);
  
  public abstract int aNX(String paramString);
  
  public abstract void aNY(String paramString);
  
  public abstract void aNZ(String paramString);
  
  public abstract int aOa(String paramString);
  
  public abstract boolean afK(String paramString);
  
  public abstract void b(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc);
  
  public abstract void b(f paramf);
  
  public abstract void b(a parama);
  
  public abstract void bl(LinkedList<String> paramLinkedList);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract String cI(int paramInt, String paramString);
  
  public abstract void d(a parama);
  
  public abstract long e(ap paramap);
  
  public abstract Cursor f(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract boolean faI();
  
  public abstract HashMap<String, Long> faJ();
  
  public abstract void faK();
  
  public abstract List<String> faL();
  
  public abstract List<String> faM();
  
  public abstract Cursor faN();
  
  public abstract int faO();
  
  public abstract String faP();
  
  public abstract Cursor faQ();
  
  public abstract ap faR();
  
  public abstract Cursor faS();
  
  public abstract boolean g(ap paramap);
  
  public abstract boolean h(ap paramap);
  
  public abstract Cursor lA(String paramString1, String paramString2);
  
  public abstract int xC(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(ap paramap, bk parambk);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(bo parambo, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bk
 * JD-Core Version:    0.7.0.1
 */