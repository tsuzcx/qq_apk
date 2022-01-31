package com.tencent.mm.protocal.c;

public final class cgm
  extends com.tencent.mm.bv.a
{
  public String sPc;
  public float tVA;
  public String tVB;
  public String tVv;
  public String tVw;
  public String tVx;
  public int tVy;
  public float tVz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tVv != null) {
        paramVarArgs.d(1, this.tVv);
      }
      if (this.sPc != null) {
        paramVarArgs.d(2, this.sPc);
      }
      if (this.tVw != null) {
        paramVarArgs.d(3, this.tVw);
      }
      if (this.tVx != null) {
        paramVarArgs.d(4, this.tVx);
      }
      paramVarArgs.gB(5, this.tVy);
      paramVarArgs.m(6, this.tVz);
      paramVarArgs.m(7, this.tVA);
      if (this.tVB != null) {
        paramVarArgs.d(8, this.tVB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVv == null) {
        break label512;
      }
    }
    label512:
    for (int i = d.a.a.b.b.a.e(1, this.tVv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sPc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sPc);
      }
      i = paramInt;
      if (this.tVw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tVw);
      }
      paramInt = i;
      if (this.tVx != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tVx);
      }
      i = paramInt + d.a.a.a.gy(5, this.tVy) + (d.a.a.b.b.a.dQ(6) + 4) + (d.a.a.b.b.a.dQ(7) + 4);
      paramInt = i;
      if (this.tVB != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tVB);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cgm localcgm = (cgm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcgm.tVv = locala.xpH.readString();
          return 0;
        case 2: 
          localcgm.sPc = locala.xpH.readString();
          return 0;
        case 3: 
          localcgm.tVw = locala.xpH.readString();
          return 0;
        case 4: 
          localcgm.tVx = locala.xpH.readString();
          return 0;
        case 5: 
          localcgm.tVy = locala.xpH.oD();
          return 0;
        case 6: 
          localcgm.tVz = locala.xpH.readFloat();
          return 0;
        case 7: 
          localcgm.tVA = locala.xpH.readFloat();
          return 0;
        }
        localcgm.tVB = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgm
 * JD-Core Version:    0.7.0.1
 */