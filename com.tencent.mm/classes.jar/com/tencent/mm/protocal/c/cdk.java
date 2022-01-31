package com.tencent.mm.protocal.c;

public final class cdk
  extends com.tencent.mm.bv.a
{
  public String bIK;
  public String bOL;
  public String ivD;
  public String tSh;
  public String tmB;
  public String tmk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.bIK != null) {
        paramVarArgs.d(2, this.bIK);
      }
      if (this.tmB != null) {
        paramVarArgs.d(3, this.tmB);
      }
      if (this.tSh != null) {
        paramVarArgs.d(4, this.tSh);
      }
      if (this.ivD != null) {
        paramVarArgs.d(5, this.ivD);
      }
      if (this.tmk != null) {
        paramVarArgs.d(6, this.tmk);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label454;
      }
    }
    label454:
    for (int i = d.a.a.b.b.a.e(1, this.bOL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bIK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bIK);
      }
      i = paramInt;
      if (this.tmB != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tmB);
      }
      paramInt = i;
      if (this.tSh != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tSh);
      }
      i = paramInt;
      if (this.ivD != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ivD);
      }
      paramInt = i;
      if (this.tmk != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tmk);
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
        cdk localcdk = (cdk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcdk.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          localcdk.bIK = locala.xpH.readString();
          return 0;
        case 3: 
          localcdk.tmB = locala.xpH.readString();
          return 0;
        case 4: 
          localcdk.tSh = locala.xpH.readString();
          return 0;
        case 5: 
          localcdk.ivD = locala.xpH.readString();
          return 0;
        }
        localcdk.tmk = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdk
 * JD-Core Version:    0.7.0.1
 */