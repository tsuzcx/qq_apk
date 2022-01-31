package com.tencent.mm.plugin.wallet.a;

public final class d
  extends com.tencent.mm.bv.a
{
  public String dTJ;
  public String name;
  public String qkP;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.qkP != null) {
        paramVarArgs.d(3, this.qkP);
      }
      if (this.dTJ != null) {
        paramVarArgs.d(4, this.dTJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.qkP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.qkP);
      }
      paramInt = i;
      if (this.dTJ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.dTJ);
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
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locald.url = locala.xpH.readString();
          return 0;
        case 2: 
          locald.name = locala.xpH.readString();
          return 0;
        case 3: 
          locald.qkP = locala.xpH.readString();
          return 0;
        }
        locald.dTJ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.d
 * JD-Core Version:    0.7.0.1
 */