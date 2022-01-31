package com.tencent.mm.protocal.c;

public final class cnh
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int ham;
  public int han;
  public int type;
  public String uaa;
  public String uab;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      if (this.uaa != null) {
        paramVarArgs.d(3, this.uaa);
      }
      if (this.uab != null) {
        paramVarArgs.d(4, this.uab);
      }
      paramVarArgs.gB(5, this.ham);
      paramVarArgs.gB(6, this.han);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOL);
      }
      i = paramInt;
      if (this.uaa != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.uaa);
      }
      paramInt = i;
      if (this.uab != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.uab);
      }
      return paramInt + d.a.a.a.gy(5, this.ham) + d.a.a.a.gy(6, this.han);
    }
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
      cnh localcnh = (cnh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcnh.type = locala.xpH.oD();
        return 0;
      case 2: 
        localcnh.bOL = locala.xpH.readString();
        return 0;
      case 3: 
        localcnh.uaa = locala.xpH.readString();
        return 0;
      case 4: 
        localcnh.uab = locala.xpH.readString();
        return 0;
      case 5: 
        localcnh.ham = locala.xpH.oD();
        return 0;
      }
      localcnh.han = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnh
 * JD-Core Version:    0.7.0.1
 */