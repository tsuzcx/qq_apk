package com.tencent.mm.protocal.c;

public final class cfm
  extends com.tencent.mm.bv.a
{
  public String foj;
  public int tUF;
  public int tUG;
  public int tUH;
  public String userName;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tUF);
      paramVarArgs.gB(2, this.tUG);
      paramVarArgs.gB(3, this.tUH);
      if (this.userName != null) {
        paramVarArgs.d(4, this.userName);
      }
      if (this.foj != null) {
        paramVarArgs.d(5, this.foj);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tUF) + 0 + d.a.a.a.gy(2, this.tUG) + d.a.a.a.gy(3, this.tUH);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.userName);
      }
      i = paramInt;
    } while (this.foj == null);
    return paramInt + d.a.a.b.b.a.e(5, this.foj);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cfm localcfm = (cfm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcfm.tUF = locala.xpH.oD();
        return 0;
      case 2: 
        localcfm.tUG = locala.xpH.oD();
        return 0;
      case 3: 
        localcfm.tUH = locala.xpH.oD();
        return 0;
      case 4: 
        localcfm.userName = locala.xpH.readString();
        return 0;
      }
      localcfm.foj = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfm
 * JD-Core Version:    0.7.0.1
 */