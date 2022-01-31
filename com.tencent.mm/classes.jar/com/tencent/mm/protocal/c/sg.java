package com.tencent.mm.protocal.c;

public final class sg
  extends com.tencent.mm.bv.a
{
  public int ffv;
  public String ffw;
  public String ffx;
  public String ffy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ffv);
      if (this.ffw != null) {
        paramVarArgs.d(2, this.ffw);
      }
      if (this.ffx != null) {
        paramVarArgs.d(3, this.ffx);
      }
      if (this.ffy != null) {
        paramVarArgs.d(4, this.ffy);
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
      i = d.a.a.a.gy(1, this.ffv) + 0;
      paramInt = i;
      if (this.ffw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ffw);
      }
      i = paramInt;
      if (this.ffx != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ffx);
      }
      paramInt = i;
    } while (this.ffy == null);
    return i + d.a.a.b.b.a.e(4, this.ffy);
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
      sg localsg = (sg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localsg.ffv = locala.xpH.oD();
        return 0;
      case 2: 
        localsg.ffw = locala.xpH.readString();
        return 0;
      case 3: 
        localsg.ffx = locala.xpH.readString();
        return 0;
      }
      localsg.ffy = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.sg
 * JD-Core Version:    0.7.0.1
 */