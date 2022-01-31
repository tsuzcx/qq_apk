package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bhw
  extends com.tencent.mm.bv.a
{
  public String gyF;
  public int kTS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.gyF == null) {
        throw new b("Not all required fields were included: jsonData");
      }
      paramVarArgs.gB(1, this.kTS);
      if (this.gyF != null) {
        paramVarArgs.d(2, this.gyF);
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
      i = d.a.a.a.gy(1, this.kTS) + 0;
      paramInt = i;
    } while (this.gyF == null);
    return i + d.a.a.b.b.a.e(2, this.gyF);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.gyF == null) {
        throw new b("Not all required fields were included: jsonData");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      bhw localbhw = (bhw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbhw.kTS = locala.xpH.oD();
        return 0;
      }
      localbhw.gyF = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhw
 * JD-Core Version:    0.7.0.1
 */