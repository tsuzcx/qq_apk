package com.tencent.mm.protocal.c;

public final class bxw
  extends com.tencent.mm.bv.a
{
  public String iQn;
  public String path;
  public int showType;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.showType);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.iQn != null) {
        paramVarArgs.d(3, this.iQn);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
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
      i = d.a.a.a.gy(1, this.showType) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.iQn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iQn);
      }
      paramInt = i;
    } while (this.path == null);
    return i + d.a.a.b.b.a.e(4, this.path);
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
      bxw localbxw = (bxw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbxw.showType = locala.xpH.oD();
        return 0;
      case 2: 
        localbxw.title = locala.xpH.readString();
        return 0;
      case 3: 
        localbxw.iQn = locala.xpH.readString();
        return 0;
      }
      localbxw.path = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxw
 * JD-Core Version:    0.7.0.1
 */