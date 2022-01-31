package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnc;
import com.tencent.mm.protocal.c.bnd;
import java.util.LinkedList;

public final class y
  extends m
  implements k
{
  private f dIJ;
  private final b dmK;
  
  public y(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bnc();
    ((b.a)localObject).ecI = new bnd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm ";
    ((b.a)localObject).ecG = 1346;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bnc)this.dmK.ecE.ecN;
    ((bnc)localObject).tvG = paramInt;
    ((bnc)localObject).bOL = paramString1;
    ((bnc)localObject).tvH = paramLinkedList;
    ((bnc)localObject).state = paramString2;
    ((bnc)localObject).tGh = paramString3;
  }
  
  public y(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bnc();
    ((b.a)localObject).ecI = new bnd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm ";
    ((b.a)localObject).ecG = 1346;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bnc)this.dmK.ecE.ecN;
    ((bnc)localObject).tvG = 1;
    ((bnc)localObject).bOL = paramString1;
    ((bnc)localObject).tvH = paramLinkedList;
    ((bnc)localObject).state = paramString2;
    ((bnc)localObject).tGh = paramString3;
    ((bnc)localObject).sQr = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bnd cbN()
  {
    return (bnd)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 1346;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */