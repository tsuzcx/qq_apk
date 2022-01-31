package com.tencent.mm.protocal.c;

public final class bjy
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public String path;
  public String tDL;
  public String tDM;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      if (this.tDL != null) {
        paramVarArgs.d(3, this.tDL);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      if (this.tDM != null) {
        paramVarArgs.d(5, this.tDM);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOL);
      }
      i = paramInt;
      if (this.tDL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tDL);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.path);
      }
      i = paramInt;
    } while (this.tDM == null);
    return paramInt + d.a.a.b.b.a.e(5, this.tDM);
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
      bjy localbjy = (bjy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbjy.type = locala.xpH.oD();
        return 0;
      case 2: 
        localbjy.bOL = locala.xpH.readString();
        return 0;
      case 3: 
        localbjy.tDL = locala.xpH.readString();
        return 0;
      case 4: 
        localbjy.path = locala.xpH.readString();
        return 0;
      }
      localbjy.tDM = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjy
 * JD-Core Version:    0.7.0.1
 */