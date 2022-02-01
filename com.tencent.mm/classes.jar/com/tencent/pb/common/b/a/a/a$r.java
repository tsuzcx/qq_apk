package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$r
  extends e
{
  public int TFq = 0;
  public int UAZ = 0;
  public long UBa = 0L;
  public a.bd ahdA = null;
  public a.ay ahdv = null;
  public int ahdy = 0;
  public int ahee = 0;
  public a.bb[] ahef = a.bb.jRn();
  public a.ba[] aheg = a.ba.jRm();
  public a.ax aheh = null;
  public int ahei = 0;
  public int ahej = 0;
  public int ahek = 0;
  public byte[] ahel = g.dXB;
  public byte[] ahem = g.dXB;
  public a.ba[] ahen = a.ba.jRm();
  public String groupId = "";
  public long msgId = 0L;
  public int oUj = 0;
  
  public a$r()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.ahee != 0) {
      paramb.cF(1, this.ahee);
    }
    if (!this.groupId.equals("")) {
      paramb.g(2, this.groupId);
    }
    if (this.UAZ != 0) {
      paramb.cF(3, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(4, this.UBa);
    }
    if (this.ahdy != 0) {
      paramb.cG(5, this.ahdy);
    }
    if (this.ahdv != null) {
      paramb.a(6, this.ahdv);
    }
    int i;
    Object localObject;
    if ((this.ahef != null) && (this.ahef.length > 0))
    {
      i = 0;
      while (i < this.ahef.length)
      {
        localObject = this.ahef[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.aheg != null) && (this.aheg.length > 0))
    {
      i = 0;
      while (i < this.aheg.length)
      {
        localObject = this.aheg[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheh != null) {
      paramb.a(9, this.aheh);
    }
    if (this.ahdA != null) {
      paramb.a(10, this.ahdA);
    }
    if (this.ahei != 0) {
      paramb.cG(11, this.ahei);
    }
    if (this.ahej != 0) {
      paramb.cG(12, this.ahej);
    }
    if (this.oUj != 0) {
      paramb.cG(13, this.oUj);
    }
    if (this.msgId != 0L) {
      paramb.n(101, this.msgId);
    }
    if (this.ahek != 0) {
      paramb.cG(102, this.ahek);
    }
    if (!Arrays.equals(this.ahel, g.dXB)) {
      paramb.b(103, this.ahel);
    }
    if (!Arrays.equals(this.ahem, g.dXB)) {
      paramb.b(200, this.ahem);
    }
    if ((this.ahen != null) && (this.ahen.length > 0))
    {
      i = j;
      while (i < this.ahen.length)
      {
        localObject = this.ahen[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.TFq != 0) {
      paramb.cF(202, this.TFq);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int m = 0;
    int j = super.akc();
    int i = j;
    if (this.ahee != 0) {
      i = j + b.cJ(1, this.ahee);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.h(2, this.groupId);
    }
    i = j;
    if (this.UAZ != 0) {
      i = j + b.cJ(3, this.UAZ);
    }
    j = i;
    if (this.UBa != 0L) {
      j = i + b.q(4, this.UBa);
    }
    int k = j;
    if (this.ahdy != 0) {
      k = j + b.cK(5, this.ahdy);
    }
    i = k;
    if (this.ahdv != null) {
      i = k + b.b(6, this.ahdv);
    }
    j = i;
    Object localObject;
    if (this.ahef != null)
    {
      j = i;
      if (this.ahef.length > 0)
      {
        j = 0;
        while (j < this.ahef.length)
        {
          localObject = this.ahef[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.aheg != null)
    {
      i = j;
      if (this.aheg.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.aheg.length)
        {
          localObject = this.aheg[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(8, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.aheh != null) {
      j = i + b.b(9, this.aheh);
    }
    i = j;
    if (this.ahdA != null) {
      i = j + b.b(10, this.ahdA);
    }
    j = i;
    if (this.ahei != 0) {
      j = i + b.cK(11, this.ahei);
    }
    i = j;
    if (this.ahej != 0) {
      i = j + b.cK(12, this.ahej);
    }
    j = i;
    if (this.oUj != 0) {
      j = i + b.cK(13, this.oUj);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.r(101, this.msgId);
    }
    j = i;
    if (this.ahek != 0) {
      j = i + b.cK(102, this.ahek);
    }
    k = j;
    if (!Arrays.equals(this.ahel, g.dXB)) {
      k = j + b.c(103, this.ahel);
    }
    i = k;
    if (!Arrays.equals(this.ahem, g.dXB)) {
      i = k + b.c(200, this.ahem);
    }
    j = i;
    if (this.ahen != null)
    {
      j = i;
      if (this.ahen.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.ahen.length) {
            break;
          }
          localObject = this.ahen[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(201, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.TFq != 0) {
      i = j + b.cJ(202, this.TFq);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.r
 * JD-Core Version:    0.7.0.1
 */