package com.tencent.mm.protocal.c;

public final class bfh
  extends com.tencent.mm.bv.a
{
  public String bVk;
  public String path;
  public int scene;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      if (this.bVk != null) {
        paramVarArgs.d(2, this.bVk);
      }
      paramVarArgs.gB(3, this.scene);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bVk != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bVk);
      }
      return i + d.a.a.a.gy(3, this.scene);
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
        bfh localbfh = (bfh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbfh.path = locala.xpH.readString();
          return 0;
        case 2: 
          localbfh.bVk = locala.xpH.readString();
          return 0;
        }
        localbfh.scene = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfh
 * JD-Core Version:    0.7.0.1
 */