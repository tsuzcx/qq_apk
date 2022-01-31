package com.tencent.mm.plugin.order.model;

public final class d
  extends com.tencent.mm.bv.a
{
  public String mPC;
  public int month;
  public int year;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.year);
      paramVarArgs.gB(2, this.month);
      if (this.mPC != null) {
        paramVarArgs.d(3, this.mPC);
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
      i = d.a.a.a.gy(1, this.year) + 0 + d.a.a.a.gy(2, this.month);
      paramInt = i;
    } while (this.mPC == null);
    return i + d.a.a.b.b.a.e(3, this.mPC);
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
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locald.year = locala.xpH.oD();
        return 0;
      case 2: 
        locald.month = locala.xpH.oD();
        return 0;
      }
      locald.mPC = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.d
 * JD-Core Version:    0.7.0.1
 */