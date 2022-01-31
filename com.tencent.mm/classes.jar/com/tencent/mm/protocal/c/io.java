package com.tencent.mm.protocal.c;

public final class io
  extends com.tencent.mm.bv.a
{
  public String name;
  public String sCI;
  public String sCJ;
  public int sCK;
  public int sCL;
  public String sCM;
  public String sCN;
  public int type;
  public int ver;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCI != null) {
        paramVarArgs.d(1, this.sCI);
      }
      paramVarArgs.gB(2, this.type);
      if (this.sCJ != null) {
        paramVarArgs.d(3, this.sCJ);
      }
      if (this.name != null) {
        paramVarArgs.d(4, this.name);
      }
      paramVarArgs.gB(5, this.ver);
      paramVarArgs.gB(6, this.sCK);
      paramVarArgs.gB(7, this.sCL);
      if (this.sCM != null) {
        paramVarArgs.d(8, this.sCM);
      }
      if (this.sCN != null) {
        paramVarArgs.d(9, this.sCN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sCI == null) {
        break label559;
      }
    }
    label559:
    for (paramInt = d.a.a.b.b.a.e(1, this.sCI) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.type);
      paramInt = i;
      if (this.sCJ != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sCJ);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.name);
      }
      i = i + d.a.a.a.gy(5, this.ver) + d.a.a.a.gy(6, this.sCK) + d.a.a.a.gy(7, this.sCL);
      paramInt = i;
      if (this.sCM != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sCM);
      }
      i = paramInt;
      if (this.sCN != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sCN);
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
        io localio = (io)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localio.sCI = locala.xpH.readString();
          return 0;
        case 2: 
          localio.type = locala.xpH.oD();
          return 0;
        case 3: 
          localio.sCJ = locala.xpH.readString();
          return 0;
        case 4: 
          localio.name = locala.xpH.readString();
          return 0;
        case 5: 
          localio.ver = locala.xpH.oD();
          return 0;
        case 6: 
          localio.sCK = locala.xpH.oD();
          return 0;
        case 7: 
          localio.sCL = locala.xpH.oD();
          return 0;
        case 8: 
          localio.sCM = locala.xpH.readString();
          return 0;
        }
        localio.sCN = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.io
 * JD-Core Version:    0.7.0.1
 */