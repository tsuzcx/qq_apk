package com.tencent.mm.protocal.c;

public final class vv
  extends com.tencent.mm.bv.a
{
  public String color;
  public int nvl;
  public String nvm;
  public String nvn;
  public int nvo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.nvl);
      if (this.nvm != null) {
        paramVarArgs.d(2, this.nvm);
      }
      if (this.nvn != null) {
        paramVarArgs.d(3, this.nvn);
      }
      paramVarArgs.gB(4, this.nvo);
      if (this.color != null) {
        paramVarArgs.d(5, this.color);
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
      i = d.a.a.a.gy(1, this.nvl) + 0;
      paramInt = i;
      if (this.nvm != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nvm);
      }
      i = paramInt;
      if (this.nvn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nvn);
      }
      i += d.a.a.a.gy(4, this.nvo);
      paramInt = i;
    } while (this.color == null);
    return i + d.a.a.b.b.a.e(5, this.color);
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
      vv localvv = (vv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localvv.nvl = locala.xpH.oD();
        return 0;
      case 2: 
        localvv.nvm = locala.xpH.readString();
        return 0;
      case 3: 
        localvv.nvn = locala.xpH.readString();
        return 0;
      case 4: 
        localvv.nvo = locala.xpH.oD();
        return 0;
      }
      localvv.color = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vv
 * JD-Core Version:    0.7.0.1
 */