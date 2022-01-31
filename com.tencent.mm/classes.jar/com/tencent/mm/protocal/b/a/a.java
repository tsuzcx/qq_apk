package com.tencent.mm.protocal.b.a;

import d.a.a.b;

public final class a
  extends com.tencent.mm.bv.a
{
  public int actionType;
  public int id;
  public String srk;
  public String srl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.srk == null) {
        throw new b("Not all required fields were included: btnStr");
      }
      paramVarArgs.gB(1, this.id);
      paramVarArgs.gB(2, this.actionType);
      if (this.srk != null) {
        paramVarArgs.d(3, this.srk);
      }
      if (this.srl != null) {
        paramVarArgs.d(4, this.srl);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.id) + 0 + d.a.a.a.gy(2, this.actionType);
      paramInt = i;
      if (this.srk != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.srk);
      }
      i = paramInt;
    } while (this.srl == null);
    return paramInt + d.a.a.b.b.a.e(4, this.srl);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.srk == null) {
        throw new b("Not all required fields were included: btnStr");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locala1.id = locala.xpH.oD();
        return 0;
      case 2: 
        locala1.actionType = locala.xpH.oD();
        return 0;
      case 3: 
        locala1.srk = locala.xpH.readString();
        return 0;
      }
      locala1.srl = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.a
 * JD-Core Version:    0.7.0.1
 */