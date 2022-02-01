package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dic
  extends com.tencent.mm.bw.a
{
  public int DSv;
  public String EIi;
  public String FCu;
  public String FRc;
  public String FRd;
  public String FhW;
  public String FrN;
  public String FrP;
  public int Scene;
  public String Title;
  public String hkR;
  public String nOK;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrP != null) {
        paramVarArgs.d(1, this.FrP);
      }
      if (this.FrN != null) {
        paramVarArgs.d(2, this.FrN);
      }
      if (this.hkR != null) {
        paramVarArgs.d(3, this.hkR);
      }
      if (this.FRc != null) {
        paramVarArgs.d(4, this.FRc);
      }
      if (this.FRd != null) {
        paramVarArgs.d(5, this.FRd);
      }
      if (this.EIi != null) {
        paramVarArgs.d(6, this.EIi);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.FhW != null) {
        paramVarArgs.d(8, this.FhW);
      }
      paramVarArgs.aR(9, this.Scene);
      paramVarArgs.aR(10, this.DSv);
      if (this.FCu != null) {
        paramVarArgs.d(11, this.FCu);
      }
      if (this.nOK != null) {
        paramVarArgs.d(12, this.nOK);
      }
      paramVarArgs.aR(13, this.sVo);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrP == null) {
        break label902;
      }
    }
    label902:
    for (int i = f.a.a.b.b.a.e(1, this.FrP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FrN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FrN);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkR);
      }
      paramInt = i;
      if (this.FRc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FRc);
      }
      i = paramInt;
      if (this.FRd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FRd);
      }
      paramInt = i;
      if (this.EIi != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EIi);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.FhW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FhW);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.Scene) + f.a.a.b.b.a.bx(10, this.DSv);
      paramInt = i;
      if (this.FCu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FCu);
      }
      i = paramInt;
      if (this.nOK != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.nOK);
      }
      paramInt = f.a.a.b.b.a.bx(13, this.sVo);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dic localdic = (dic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localdic.FrP = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localdic.FrN = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localdic.hkR = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localdic.FRc = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localdic.FRd = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localdic.EIi = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localdic.Title = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localdic.FhW = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localdic.Scene = locala.LVo.xF();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localdic.DSv = locala.LVo.xF();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localdic.FCu = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localdic.nOK = locala.LVo.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localdic.sVo = locala.LVo.xF();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dic
 * JD-Core Version:    0.7.0.1
 */