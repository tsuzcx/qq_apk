package com.tencent.mm.protocal.c;

public final class aqb
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public String tlU;
  public String tlV;
  
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
      if (this.tlU != null) {
        paramVarArgs.d(3, this.tlU);
      }
      if (this.tlV != null) {
        paramVarArgs.d(4, this.tlV);
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
      if (this.tlU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tlU);
      }
      paramInt = i;
      if (this.tlV != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tlV);
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
        aqb localaqb = (aqb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaqb.title = locala.xpH.readString();
          return 0;
        case 2: 
          localaqb.desc = locala.xpH.readString();
          return 0;
        case 3: 
          localaqb.tlU = locala.xpH.readString();
          return 0;
        }
        localaqb.tlV = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqb
 * JD-Core Version:    0.7.0.1
 */