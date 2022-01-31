package com.tencent.mm.protocal.c;

public final class ly
  extends com.tencent.mm.bv.a
{
  public int create_time;
  public int nZA;
  public String sHO;
  public String text;
  public int type;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.gB(4, this.nZA);
      paramVarArgs.gB(5, this.create_time);
      if (this.sHO != null) {
        paramVarArgs.d(6, this.sHO);
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
      if (this.text != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.url);
      }
      i = i + d.a.a.a.gy(4, this.nZA) + d.a.a.a.gy(5, this.create_time);
      paramInt = i;
    } while (this.sHO == null);
    return i + d.a.a.b.b.a.e(6, this.sHO);
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
      ly locally = (ly)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locally.type = locala.xpH.oD();
        return 0;
      case 2: 
        locally.text = locala.xpH.readString();
        return 0;
      case 3: 
        locally.url = locala.xpH.readString();
        return 0;
      case 4: 
        locally.nZA = locala.xpH.oD();
        return 0;
      case 5: 
        locally.create_time = locala.xpH.oD();
        return 0;
      }
      locally.sHO = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ly
 * JD-Core Version:    0.7.0.1
 */