package com.tencent.mm.protocal.c;

public final class lt
  extends com.tencent.mm.bv.a
{
  public int imX;
  public String text;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.imX);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.imX) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
    } while (this.url == null);
    return paramInt + d.a.a.b.b.a.e(3, this.url);
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
      lt locallt = (lt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locallt.imX = locala.xpH.oD();
        return 0;
      case 2: 
        locallt.text = locala.xpH.readString();
        return 0;
      }
      locallt.url = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lt
 * JD-Core Version:    0.7.0.1
 */