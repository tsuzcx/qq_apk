package com.tencent.mm.protocal.c;

public final class aob
  extends com.tencent.mm.bv.a
{
  public int group_id;
  public String lnY;
  public String sQH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQH != null) {
        paramVarArgs.d(1, this.sQH);
      }
      paramVarArgs.gB(2, this.group_id);
      if (this.lnY != null) {
        paramVarArgs.d(3, this.lnY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQH == null) {
        break label273;
      }
    }
    label273:
    for (paramInt = d.a.a.b.b.a.e(1, this.sQH) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.group_id);
      paramInt = i;
      if (this.lnY != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.lnY);
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
        aob localaob = (aob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaob.sQH = locala.xpH.readString();
          return 0;
        case 2: 
          localaob.group_id = locala.xpH.oD();
          return 0;
        }
        localaob.lnY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aob
 * JD-Core Version:    0.7.0.1
 */