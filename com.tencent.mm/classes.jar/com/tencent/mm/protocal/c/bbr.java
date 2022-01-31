package com.tencent.mm.protocal.c;

public final class bbr
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b txp;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.txp == null) {
        throw new d.a.a.b("Not all required fields were included: buf");
      }
      paramVarArgs.gB(1, this.type);
      if (this.txp != null) {
        paramVarArgs.b(2, this.txp);
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
      i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
    } while (this.txp == null);
    return i + d.a.a.a.a(2, this.txp);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.txp == null) {
        throw new d.a.a.b("Not all required fields were included: buf");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      bbr localbbr = (bbr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbbr.type = locala.xpH.oD();
        return 0;
      }
      localbbr.txp = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bbr
 * JD-Core Version:    0.7.0.1
 */