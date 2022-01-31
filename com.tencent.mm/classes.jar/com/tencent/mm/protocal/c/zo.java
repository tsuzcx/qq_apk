package com.tencent.mm.protocal.c;

public final class zo
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public String kSF;
  public String sBi;
  public String sNh;
  public String sYN;
  public String sYO;
  public String sYP;
  public int ssu;
  public String svu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svu != null) {
        paramVarArgs.d(1, this.svu);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      if (this.kSF != null) {
        paramVarArgs.d(4, this.kSF);
      }
      if (this.sYN != null) {
        paramVarArgs.d(5, this.sYN);
      }
      if (this.sYO != null) {
        paramVarArgs.d(6, this.sYO);
      }
      if (this.sBi != null) {
        paramVarArgs.d(7, this.sBi);
      }
      if (this.sNh != null) {
        paramVarArgs.d(8, this.sNh);
      }
      if (this.sYP != null) {
        paramVarArgs.d(9, this.sYP);
      }
      paramVarArgs.gB(10, this.ssu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.svu == null) {
        break label666;
      }
    }
    label666:
    for (int i = d.a.a.b.b.a.e(1, this.svu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hPY);
      }
      paramInt = i;
      if (this.kSF != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSF);
      }
      i = paramInt;
      if (this.sYN != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sYN);
      }
      paramInt = i;
      if (this.sYO != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sYO);
      }
      i = paramInt;
      if (this.sBi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sBi);
      }
      paramInt = i;
      if (this.sNh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sNh);
      }
      i = paramInt;
      if (this.sYP != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sYP);
      }
      return i + d.a.a.a.gy(10, this.ssu);
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
        zo localzo = (zo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localzo.svu = locala.xpH.readString();
          return 0;
        case 2: 
          localzo.hRf = locala.xpH.readString();
          return 0;
        case 3: 
          localzo.hPY = locala.xpH.readString();
          return 0;
        case 4: 
          localzo.kSF = locala.xpH.readString();
          return 0;
        case 5: 
          localzo.sYN = locala.xpH.readString();
          return 0;
        case 6: 
          localzo.sYO = locala.xpH.readString();
          return 0;
        case 7: 
          localzo.sBi = locala.xpH.readString();
          return 0;
        case 8: 
          localzo.sNh = locala.xpH.readString();
          return 0;
        case 9: 
          localzo.sYP = locala.xpH.readString();
          return 0;
        }
        localzo.ssu = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zo
 * JD-Core Version:    0.7.0.1
 */