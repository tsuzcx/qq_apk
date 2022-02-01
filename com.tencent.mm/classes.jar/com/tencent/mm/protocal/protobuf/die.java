package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class die
  extends com.tencent.mm.bw.a
{
  public int DSv;
  public String FCu;
  public String FRe;
  public String FhW;
  public String FrN;
  public String FrP;
  public int Scene;
  public int fZz;
  public String hkR;
  public String nOK;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrN != null) {
        paramVarArgs.d(1, this.FrN);
      }
      if (this.FRe != null) {
        paramVarArgs.d(2, this.FRe);
      }
      paramVarArgs.aR(3, this.fZz);
      if (this.FrP != null) {
        paramVarArgs.d(4, this.FrP);
      }
      if (this.hkR != null) {
        paramVarArgs.d(5, this.hkR);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.FhW != null) {
        paramVarArgs.d(7, this.FhW);
      }
      paramVarArgs.aR(8, this.DSv);
      if (this.nOK != null) {
        paramVarArgs.d(9, this.nOK);
      }
      if (this.FCu != null) {
        paramVarArgs.d(10, this.FCu);
      }
      paramVarArgs.aR(11, this.sVo);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrN == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.FrN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FRe != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FRe);
      }
      i += f.a.a.b.b.a.bx(3, this.fZz);
      paramInt = i;
      if (this.FrP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FrP);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hkR);
      }
      i += f.a.a.b.b.a.bx(6, this.Scene);
      paramInt = i;
      if (this.FhW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FhW);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.DSv);
      paramInt = i;
      if (this.nOK != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nOK);
      }
      i = paramInt;
      if (this.FCu != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FCu);
      }
      paramInt = f.a.a.b.b.a.bx(11, this.sVo);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        die localdie = (die)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localdie.FrN = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localdie.FRe = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localdie.fZz = locala.LVo.xF();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localdie.FrP = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localdie.hkR = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localdie.Scene = locala.LVo.xF();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localdie.FhW = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localdie.DSv = locala.LVo.xF();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localdie.nOK = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localdie.FCu = locala.LVo.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localdie.sVo = locala.LVo.xF();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.die
 * JD-Core Version:    0.7.0.1
 */