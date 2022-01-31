package com.tencent.mm.protocal.c;

public final class ob
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public String sLC;
  public String sLD;
  public String sLE;
  public int sLF;
  public String sLG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.sLC != null) {
        paramVarArgs.d(3, this.sLC);
      }
      if (this.sLD != null) {
        paramVarArgs.d(4, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(5, this.sLE);
      }
      paramVarArgs.gB(6, this.sLF);
      if (this.sLG != null) {
        paramVarArgs.d(7, this.sLG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label497;
      }
    }
    label497:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.sLC != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLC);
      }
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sLE);
      }
      i += d.a.a.a.gy(6, this.sLF);
      paramInt = i;
      if (this.sLG != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sLG);
      }
      return paramInt;
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
        ob localob = (ob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localob.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localob.hRf = locala.xpH.readString();
          return 0;
        case 3: 
          localob.sLC = locala.xpH.readString();
          return 0;
        case 4: 
          localob.sLD = locala.xpH.readString();
          return 0;
        case 5: 
          localob.sLE = locala.xpH.readString();
          return 0;
        case 6: 
          localob.sLF = locala.xpH.oD();
          return 0;
        }
        localob.sLG = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ob
 * JD-Core Version:    0.7.0.1
 */