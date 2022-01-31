package com.tencent.mm.plugin.product.c;

public final class e
  extends com.tencent.mm.bv.a
{
  public int id;
  public String name;
  public int value;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.id);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.gB(3, this.value);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      return paramInt + d.a.a.a.gy(3, this.value);
    }
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
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locale.id = locala.xpH.oD();
        return 0;
      case 2: 
        locale.name = locala.xpH.readString();
        return 0;
      }
      locale.value = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.e
 * JD-Core Version:    0.7.0.1
 */