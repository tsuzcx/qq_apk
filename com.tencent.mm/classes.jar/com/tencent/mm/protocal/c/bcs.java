package com.tencent.mm.protocal.c;

public final class bcs
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String ivD;
  public String ivF;
  public String quW;
  public String tya;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.quW != null) {
        paramVarArgs.d(2, this.quW);
      }
      if (this.ivF != null) {
        paramVarArgs.d(3, this.ivF);
      }
      if (this.ivD != null) {
        paramVarArgs.d(4, this.ivD);
      }
      if (this.tya != null) {
        paramVarArgs.d(5, this.tya);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.quW != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.quW);
      }
      i = paramInt;
      if (this.ivF != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ivF);
      }
      paramInt = i;
      if (this.ivD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ivD);
      }
      i = paramInt;
      if (this.tya != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tya);
      }
      return i;
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
        bcs localbcs = (bcs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbcs.app_id = locala.xpH.readString();
          return 0;
        case 2: 
          localbcs.quW = locala.xpH.readString();
          return 0;
        case 3: 
          localbcs.ivF = locala.xpH.readString();
          return 0;
        case 4: 
          localbcs.ivD = locala.xpH.readString();
          return 0;
        }
        localbcs.tya = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcs
 * JD-Core Version:    0.7.0.1
 */