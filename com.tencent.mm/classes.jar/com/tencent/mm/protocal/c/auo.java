package com.tencent.mm.protocal.c;

public final class auo
  extends com.tencent.mm.bv.a
{
  public String dCX;
  public String devicename;
  public String devicetype;
  public int tqa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.dCX != null) {
        paramVarArgs.d(1, this.dCX);
      }
      if (this.devicename != null) {
        paramVarArgs.d(2, this.devicename);
      }
      if (this.devicetype != null) {
        paramVarArgs.d(3, this.devicetype);
      }
      paramVarArgs.gB(4, this.tqa);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dCX == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.dCX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicename != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.devicename);
      }
      i = paramInt;
      if (this.devicetype != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.devicetype);
      }
      return i + d.a.a.a.gy(4, this.tqa);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localauo.dCX = locala.xpH.readString();
          return 0;
        case 2: 
          localauo.devicename = locala.xpH.readString();
          return 0;
        case 3: 
          localauo.devicetype = locala.xpH.readString();
          return 0;
        }
        localauo.tqa = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.auo
 * JD-Core Version:    0.7.0.1
 */