package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ku
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kSC;
  public String sFK;
  public String sFL;
  public int sFM;
  public String sFN;
  public int sFO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kSC == null) {
        throw new b("Not all required fields were included: Url");
      }
      if (this.sFK == null) {
        throw new b("Not all required fields were included: Position");
      }
      if (this.sFL == null) {
        throw new b("Not all required fields were included: DetailInfo");
      }
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kSC != null) {
        paramVarArgs.d(2, this.kSC);
      }
      if (this.sFK != null) {
        paramVarArgs.d(3, this.sFK);
      }
      if (this.sFL != null) {
        paramVarArgs.d(4, this.sFL);
      }
      paramVarArgs.gB(5, this.sFM);
      if (this.sFN != null) {
        paramVarArgs.d(6, this.sFN);
      }
      paramVarArgs.gB(7, this.sFO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label613;
      }
    }
    label613:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSC);
      }
      i = paramInt;
      if (this.sFK != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sFK);
      }
      paramInt = i;
      if (this.sFL != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sFL);
      }
      i = paramInt + d.a.a.a.gy(5, this.sFM);
      paramInt = i;
      if (this.sFN != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sFN);
      }
      return paramInt + d.a.a.a.gy(7, this.sFO);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kSC == null) {
          throw new b("Not all required fields were included: Url");
        }
        if (this.sFK == null) {
          throw new b("Not all required fields were included: Position");
        }
        if (this.sFL != null) {
          break;
        }
        throw new b("Not all required fields were included: DetailInfo");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ku localku = (ku)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localku.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localku.kSC = locala.xpH.readString();
          return 0;
        case 3: 
          localku.sFK = locala.xpH.readString();
          return 0;
        case 4: 
          localku.sFL = locala.xpH.readString();
          return 0;
        case 5: 
          localku.sFM = locala.xpH.oD();
          return 0;
        case 6: 
          localku.sFN = locala.xpH.readString();
          return 0;
        }
        localku.sFO = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ku
 * JD-Core Version:    0.7.0.1
 */