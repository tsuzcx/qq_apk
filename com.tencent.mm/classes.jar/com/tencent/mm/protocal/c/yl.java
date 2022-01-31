package com.tencent.mm.protocal.c;

public final class yl
  extends com.tencent.mm.bv.a
{
  public String bIB;
  public String bVk;
  public int index;
  public int jYS;
  public String jYU;
  public int scene;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.scene);
      paramVarArgs.gB(2, this.jYS);
      paramVarArgs.gB(3, this.index);
      if (this.bIB != null) {
        paramVarArgs.d(4, this.bIB);
      }
      if (this.bVk != null) {
        paramVarArgs.d(5, this.bVk);
      }
      if (this.jYU != null) {
        paramVarArgs.d(6, this.jYU);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.scene) + 0 + d.a.a.a.gy(2, this.jYS) + d.a.a.a.gy(3, this.index);
      paramInt = i;
      if (this.bIB != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bIB);
      }
      i = paramInt;
      if (this.bVk != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.bVk);
      }
      paramInt = i;
    } while (this.jYU == null);
    return i + d.a.a.b.b.a.e(6, this.jYU);
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
      yl localyl = (yl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localyl.scene = locala.xpH.oD();
        return 0;
      case 2: 
        localyl.jYS = locala.xpH.oD();
        return 0;
      case 3: 
        localyl.index = locala.xpH.oD();
        return 0;
      case 4: 
        localyl.bIB = locala.xpH.readString();
        return 0;
      case 5: 
        localyl.bVk = locala.xpH.readString();
        return 0;
      }
      localyl.jYU = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yl
 * JD-Core Version:    0.7.0.1
 */