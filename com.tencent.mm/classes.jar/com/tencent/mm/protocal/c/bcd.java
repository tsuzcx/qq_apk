package com.tencent.mm.protocal.c;

public final class bcd
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String detail;
  public String sQT;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.sQT != null) {
        paramVarArgs.d(3, this.sQT);
      }
      if (this.detail != null) {
        paramVarArgs.d(4, this.detail);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.sQT != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sQT);
      }
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.detail);
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
        bcd localbcd = (bcd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbcd.title = locala.xpH.readString();
          return 0;
        case 2: 
          localbcd.desc = locala.xpH.readString();
          return 0;
        case 3: 
          localbcd.sQT = locala.xpH.readString();
          return 0;
        }
        localbcd.detail = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcd
 * JD-Core Version:    0.7.0.1
 */