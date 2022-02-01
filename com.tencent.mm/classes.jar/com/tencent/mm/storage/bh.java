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

public abstract interface bh
  extends com.tencent.mm.sdk.e.h
{
  public abstract Cursor H(String paramString, List<String> paramList);
  
  public abstract Cursor I(String paramString, List<String> paramList);
  
  public abstract b Lu();
  
  public abstract int a(am paramam, String paramString);
  
  public abstract int a(am paramam, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(f paramf);
  
  public abstract void a(e parame);
  
  public abstract void a(am paramam, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void aH(bl parambl);
  
  public abstract am aIA(String paramString);
  
  public abstract int aIB(String paramString);
  
  public abstract void aIC(String paramString);
  
  public abstract void aID(String paramString);
  
  public abstract int aIE(String paramString);
  
  public abstract void aIl(String paramString);
  
  public abstract boolean aIm(String paramString);
  
  public abstract am aIn(String paramString);
  
  public abstract void aIo(String paramString);
  
  public abstract boolean aIp(String paramString);
  
  public abstract boolean aIq(String paramString);
  
  public abstract boolean aIr(String paramString);
  
  public abstract boolean aIs(String paramString);
  
  public abstract boolean aIt(String paramString);
  
  public abstract boolean aIu(String paramString);
  
  public abstract boolean aIv(String paramString);
  
  public abstract Cursor aIw(String paramString);
  
  public abstract Cursor aIx(String paramString);
  
  public abstract int aIy(String paramString);
  
  public abstract String aIz(String paramString);
  
  public abstract boolean aaS(String paramString);
  
  public abstract void b(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc);
  
  public abstract void b(a parama);
  
  public abstract void be(LinkedList<String> paramLinkedList);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract String cF(int paramInt, String paramString);
  
  public abstract Cursor d(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void d(a parama);
  
  public abstract long e(am paramam);
  
  public abstract boolean eLg();
  
  public abstract HashMap<String, Long> eLh();
  
  public abstract void eLi();
  
  public abstract List<String> eLj();
  
  public abstract List<String> eLk();
  
  public abstract Cursor eLl();
  
  public abstract int eLm();
  
  public abstract String eLn();
  
  public abstract Cursor eLo();
  
  public abstract am eLp();
  
  public abstract Cursor eLq();
  
  public abstract Cursor f(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract Cursor fL(String paramString, int paramInt);
  
  public abstract boolean g(am paramam);
  
  public abstract boolean h(am paramam);
  
  public abstract Cursor ld(String paramString1, String paramString2);
  
  public abstract int tz(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(am paramam, bh parambh);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(bl parambl, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bh
 * JD-Core Version:    0.7.0.1
 */