package com.tencent.mm.protocal.c;

public final class aph
  extends com.tencent.mm.bv.a
{
  public int create_time;
  public String iQn;
  public int ild;
  public int ilo;
  public String imz;
  public String lLm;
  public String nvB;
  public String srM;
  public int state;
  public String tef;
  public long tli;
  public String tlk;
  public int tlm;
  public int tln;
  public String tlo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tef != null) {
        paramVarArgs.d(1, this.tef);
      }
      if (this.srM != null) {
        paramVarArgs.d(2, this.srM);
      }
      paramVarArgs.Y(3, this.tli);
      paramVarArgs.gB(4, this.state);
      paramVarArgs.gB(5, this.create_time);
      paramVarArgs.gB(6, this.ild);
      paramVarArgs.gB(7, this.tlm);
      paramVarArgs.gB(8, this.tln);
      if (this.tlo != null) {
        paramVarArgs.d(9, this.tlo);
      }
      if (this.imz != null) {
        paramVarArgs.d(10, this.imz);
      }
      if (this.lLm != null) {
        paramVarArgs.d(11, this.lLm);
      }
      if (this.iQn != null) {
        paramVarArgs.d(12, this.iQn);
      }
      if (this.nvB != null) {
        paramVarArgs.d(13, this.nvB);
      }
      if (this.tlk != null) {
        paramVarArgs.d(14, this.tlk);
      }
      paramVarArgs.gB(15, this.ilo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tef == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = d.a.a.b.b.a.e(1, this.tef) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.srM != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.srM);
      }
      i = i + d.a.a.a.X(3, this.tli) + d.a.a.a.gy(4, this.state) + d.a.a.a.gy(5, this.create_time) + d.a.a.a.gy(6, this.ild) + d.a.a.a.gy(7, this.tlm) + d.a.a.a.gy(8, this.tln);
      paramInt = i;
      if (this.tlo != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tlo);
      }
      i = paramInt;
      if (this.imz != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.imz);
      }
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.lLm);
      }
      i = paramInt;
      if (this.iQn != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.iQn);
      }
      paramInt = i;
      if (this.nvB != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.nvB);
      }
      i = paramInt;
      if (this.tlk != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.tlk);
      }
      return i + d.a.a.a.gy(15, this.ilo);
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
        aph localaph = (aph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaph.tef = locala.xpH.readString();
          return 0;
        case 2: 
          localaph.srM = locala.xpH.readString();
          return 0;
        case 3: 
          localaph.tli = locala.xpH.oE();
          return 0;
        case 4: 
          localaph.state = locala.xpH.oD();
          return 0;
        case 5: 
          localaph.create_time = locala.xpH.oD();
          return 0;
        case 6: 
          localaph.ild = locala.xpH.oD();
          return 0;
        case 7: 
          localaph.tlm = locala.xpH.oD();
          return 0;
        case 8: 
          localaph.tln = locala.xpH.oD();
          return 0;
        case 9: 
          localaph.tlo = locala.xpH.readString();
          return 0;
        case 10: 
          localaph.imz = locala.xpH.readString();
          return 0;
        case 11: 
          localaph.lLm = locala.xpH.readString();
          return 0;
        case 12: 
          localaph.iQn = locala.xpH.readString();
          return 0;
        case 13: 
          localaph.nvB = locala.xpH.readString();
          return 0;
        case 14: 
          localaph.tlk = locala.xpH.readString();
          return 0;
        }
        localaph.ilo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aph
 * JD-Core Version:    0.7.0.1
 */