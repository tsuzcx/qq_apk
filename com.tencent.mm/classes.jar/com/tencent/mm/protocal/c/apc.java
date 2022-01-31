package com.tencent.mm.protocal.c;

public final class apc
  extends com.tencent.mm.bv.a
{
  public String nve;
  public String sFw;
  public int state;
  public String title;
  public String tkX;
  public long tkY;
  public String tkZ;
  public String tla;
  public String tlb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sFw != null) {
        paramVarArgs.d(1, this.sFw);
      }
      paramVarArgs.gB(2, this.state);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.tkX != null) {
        paramVarArgs.d(4, this.tkX);
      }
      paramVarArgs.Y(5, this.tkY);
      if (this.tkZ != null) {
        paramVarArgs.d(6, this.tkZ);
      }
      if (this.nve != null) {
        paramVarArgs.d(7, this.nve);
      }
      if (this.tla != null) {
        paramVarArgs.d(8, this.tla);
      }
      if (this.tlb != null) {
        paramVarArgs.d(9, this.tlb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sFw == null) {
        break label595;
      }
    }
    label595:
    for (paramInt = d.a.a.b.b.a.e(1, this.sFw) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.tkX != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tkX);
      }
      i += d.a.a.a.X(5, this.tkY);
      paramInt = i;
      if (this.tkZ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tkZ);
      }
      i = paramInt;
      if (this.nve != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.nve);
      }
      paramInt = i;
      if (this.tla != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tla);
      }
      i = paramInt;
      if (this.tlb != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tlb);
      }
      return i;
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
        apc localapc = (apc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapc.sFw = locala.xpH.readString();
          return 0;
        case 2: 
          localapc.state = locala.xpH.oD();
          return 0;
        case 3: 
          localapc.title = locala.xpH.readString();
          return 0;
        case 4: 
          localapc.tkX = locala.xpH.readString();
          return 0;
        case 5: 
          localapc.tkY = locala.xpH.oE();
          return 0;
        case 6: 
          localapc.tkZ = locala.xpH.readString();
          return 0;
        case 7: 
          localapc.nve = locala.xpH.readString();
          return 0;
        case 8: 
          localapc.tla = locala.xpH.readString();
          return 0;
        }
        localapc.tlb = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apc
 * JD-Core Version:    0.7.0.1
 */