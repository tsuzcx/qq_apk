package com.tencent.mm.protocal.c;

public final class dp
  extends com.tencent.mm.bv.a
{
  public String kSC;
  public int pyo;
  public long sxc;
  public int sxd;
  public String sxe;
  public int sxf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSC != null) {
        paramVarArgs.d(1, this.kSC);
      }
      paramVarArgs.Y(2, this.sxc);
      paramVarArgs.gB(3, this.sxd);
      if (this.sxe != null) {
        paramVarArgs.d(4, this.sxe);
      }
      paramVarArgs.gB(5, this.pyo);
      paramVarArgs.gB(6, this.sxf);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSC == null) {
        break label386;
      }
    }
    label386:
    for (paramInt = d.a.a.b.b.a.e(1, this.kSC) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sxc) + d.a.a.a.gy(3, this.sxd);
      paramInt = i;
      if (this.sxe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sxe);
      }
      return paramInt + d.a.a.a.gy(5, this.pyo) + d.a.a.a.gy(6, this.sxf);
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
        dp localdp = (dp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdp.kSC = locala.xpH.readString();
          return 0;
        case 2: 
          localdp.sxc = locala.xpH.oE();
          return 0;
        case 3: 
          localdp.sxd = locala.xpH.oD();
          return 0;
        case 4: 
          localdp.sxe = locala.xpH.readString();
          return 0;
        case 5: 
          localdp.pyo = locala.xpH.oD();
          return 0;
        }
        localdp.sxf = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dp
 * JD-Core Version:    0.7.0.1
 */