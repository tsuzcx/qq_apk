package com.tencent.mm.protocal;

import com.tencent.mm.bv.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.protocal.c.gd;

public final class k
{
  public static gc a(d paramd)
  {
    gc localgc = new gc();
    localgc.sAl = paramd.spF;
    localgc.pyo = paramd.spI;
    localgc.jwX = paramd.spE;
    localgc.sAk = b.bk(paramd.spH.getBytes());
    if (localgc.sAk.oY.length >= 16) {
      localgc.sAk = localgc.sAk.EB(16);
    }
    localgc.sAm = b.bk(paramd.spG.getBytes());
    if (localgc.sAm.oY.length >= 132) {
      localgc.sAm = localgc.sAm.EB(132);
    }
    localgc.sAj = b.bk(paramd.aYR);
    if (localgc.sAj.oY.length >= 36) {
      localgc.sAj = localgc.sAj.EB(36);
    }
    return localgc;
  }
  
  public static void a(e parame, gd paramgd)
  {
    if (paramgd.sAn != null)
    {
      parame.spP = paramgd.sAn.tFO;
      return;
    }
    parame.spP = "";
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract byte[] HG();
    
    public abstract int HH();
    
    public abstract int cpd();
    
    public abstract boolean cpe();
  }
  
  public static abstract interface c
  {
    public abstract int A(byte[] paramArrayOfByte);
    
    public abstract boolean cpe();
  }
  
  public static class d
  {
    public byte[] aYR = new byte[0];
    public long bufferSize = 0L;
    public int ecM = 0;
    public int spE = 0;
    public int spF = 0;
    public String spG = "";
    public String spH = "";
    public int spI = 0;
    public boolean spJ = true;
    public k.a spK;
    public byte[] spL;
    public y spM = new y("", "", 0);
    
    public boolean Lb()
    {
      return this.spJ;
    }
    
    public final int cpd()
    {
      return this.ecM;
    }
    
    public boolean cpe()
    {
      return false;
    }
    
    public void fn(int paramInt)
    {
      this.spE = paramInt;
    }
    
    public int getCmdId()
    {
      return 0;
    }
  }
  
  public static class e
  {
    public long bufferSize = 0L;
    public int spN = -99;
    public int spO = 255;
    public String spP = "";
    
    public boolean cpe()
    {
      return false;
    }
    
    public int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.k
 * JD-Core Version:    0.7.0.1
 */