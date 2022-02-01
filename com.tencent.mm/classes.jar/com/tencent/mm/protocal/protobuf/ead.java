package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ead
  extends com.tencent.mm.bw.a
{
  public int ChE;
  public String DSu;
  public int EJL;
  public String EvK;
  public String Gga;
  public String Ggb;
  public String Ggc;
  public int Ggd;
  public int dxE;
  public String dxF;
  public String hOf;
  public String lTg;
  public int lTl;
  public int ndI;
  public int pAS;
  public int wTD;
  public int wTE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.Gga != null) {
        paramVarArgs.d(3, this.Gga);
      }
      paramVarArgs.aR(4, this.wTD);
      paramVarArgs.aR(5, this.pAS);
      paramVarArgs.aR(6, this.wTE);
      if (this.Ggb != null) {
        paramVarArgs.d(7, this.Ggb);
      }
      paramVarArgs.aR(8, this.EJL);
      if (this.DSu != null) {
        paramVarArgs.d(9, this.DSu);
      }
      if (this.Ggc != null) {
        paramVarArgs.d(10, this.Ggc);
      }
      paramVarArgs.aR(11, this.ChE);
      paramVarArgs.aR(12, this.Ggd);
      if (this.EvK != null) {
        paramVarArgs.d(13, this.EvK);
      }
      if (this.lTg != null) {
        paramVarArgs.d(14, this.lTg);
      }
      paramVarArgs.aR(15, this.dxE);
      if (this.dxF != null) {
        paramVarArgs.d(16, this.dxF);
      }
      paramVarArgs.aR(17, this.lTl);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ndI) + 0;
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.Gga != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gga);
      }
      i = i + f.a.a.b.b.a.bx(4, this.wTD) + f.a.a.b.b.a.bx(5, this.pAS) + f.a.a.b.b.a.bx(6, this.wTE);
      paramInt = i;
      if (this.Ggb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ggb);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.EJL);
      paramInt = i;
      if (this.DSu != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DSu);
      }
      i = paramInt;
      if (this.Ggc != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Ggc);
      }
      i = i + f.a.a.b.b.a.bx(11, this.ChE) + f.a.a.b.b.a.bx(12, this.Ggd);
      paramInt = i;
      if (this.EvK != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EvK);
      }
      i = paramInt;
      if (this.lTg != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.lTg);
      }
      i += f.a.a.b.b.a.bx(15, this.dxE);
      paramInt = i;
      if (this.dxF != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.dxF);
      }
      i = f.a.a.b.b.a.bx(17, this.lTl);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ead localead = (ead)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localead.ndI = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localead.hOf = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localead.Gga = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localead.wTD = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localead.pAS = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localead.wTE = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localead.Ggb = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localead.EJL = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localead.DSu = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localead.Ggc = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localead.ChE = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localead.Ggd = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localead.EvK = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localead.lTg = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localead.dxE = locala.LVo.xF();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localead.dxF = locala.LVo.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localead.lTl = locala.LVo.xF();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ead
 * JD-Core Version:    0.7.0.1
 */