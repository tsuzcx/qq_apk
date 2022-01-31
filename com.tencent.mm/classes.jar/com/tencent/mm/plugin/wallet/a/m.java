package com.tencent.mm.plugin.wallet.a;

public final class m
  extends com.tencent.mm.bv.a
{
  public String dTJ;
  public int id;
  public String name;
  public String qkP;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.id);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.qkP != null) {
        paramVarArgs.d(4, this.qkP);
      }
      if (this.dTJ != null) {
        paramVarArgs.d(5, this.dTJ);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.qkP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.qkP);
      }
      i = paramInt;
    } while (this.dTJ == null);
    return paramInt + d.a.a.b.b.a.e(5, this.dTJ);
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
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localm.id = locala.xpH.oD();
        return 0;
      case 2: 
        localm.name = locala.xpH.readString();
        return 0;
      case 3: 
        localm.url = locala.xpH.readString();
        return 0;
      case 4: 
        localm.qkP = locala.xpH.readString();
        return 0;
      }
      localm.dTJ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.m
 * JD-Core Version:    0.7.0.1
 */