package com.tencent.mm.protocal.c;

public final class awm
  extends com.tencent.mm.bv.a
{
  public String color;
  public String iet;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iet != null) {
        paramVarArgs.d(1, this.iet);
      }
      if (this.color != null) {
        paramVarArgs.d(2, this.color);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.iet == null) {
        break label293;
      }
    }
    label293:
    for (int i = d.a.a.b.b.a.e(1, this.iet) + 0;; i = 0)
    {
      paramInt = i;
      if (this.color != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.color);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.url);
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
        awm localawm = (awm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          return -1;
        case 1: 
          localawm.iet = locala.xpH.readString();
          return 0;
        case 2: 
          localawm.color = locala.xpH.readString();
          return 0;
        }
        localawm.url = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awm
 * JD-Core Version:    0.7.0.1
 */