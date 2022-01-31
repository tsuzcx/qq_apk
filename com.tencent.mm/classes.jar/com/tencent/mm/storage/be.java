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

public abstract interface be
  extends com.tencent.mm.sdk.e.h
{
  public abstract Cursor B(String paramString, List<String> paramList);
  
  public abstract b BX();
  
  public abstract Cursor C(String paramString, List<String> paramList);
  
  public abstract boolean OU(String paramString);
  
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
  
  public abstract void aK(LinkedList<String> paramLinkedList);
  
  public abstract String ac(int paramInt, String paramString);
  
  public abstract void ar(bi parambi);
  
  public abstract void arF(String paramString);
  
  public abstract boolean arG(String paramString);
  
  public abstract ak arH(String paramString);
  
  public abstract void arI(String paramString);
  
  public abstract boolean arJ(String paramString);
  
  public abstract boolean arK(String paramString);
  
  public abstract boolean arL(String paramString);
  
  public abstract boolean arM(String paramString);
  
  public abstract boolean arN(String paramString);
  
  public abstract boolean arO(String paramString);
  
  public abstract boolean arP(String paramString);
  
  public abstract Cursor arQ(String paramString);
  
  public abstract Cursor arR(String paramString);
  
  public abstract int arS(String paramString);
  
  public abstract String arT(String paramString);
  
  public abstract ak arU(String paramString);
  
  public abstract int arV(String paramString);
  
  public abstract void arW(String paramString);
  
  public abstract void arX(String paramString);
  
  public abstract int arY(String paramString);
  
  public abstract void b(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc);
  
  public abstract void b(a parama);
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract long d(ak paramak);
  
  public abstract void d(a parama);
  
  public abstract boolean dxd();
  
  public abstract HashMap<String, Long> dxe();
  
  public abstract void dxf();
  
  public abstract List<String> dxh();
  
  public abstract List<String> dxi();
  
  public abstract Cursor dxj();
  
  public abstract int dxk();
  
  public abstract String dxl();
  
  public abstract Cursor dxm();
  
  public abstract ak dxn();
  
  public abstract Cursor dxo();
  
  public abstract Cursor eC(String paramString, int paramInt);
  
  public abstract boolean f(ak paramak);
  
  public abstract boolean g(ak paramak);
  
  public abstract Cursor ip(String paramString1, String paramString2);
  
  public abstract int oM(String paramString);
  
  public abstract Cursor s(List<String> paramList, int paramInt);
  
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