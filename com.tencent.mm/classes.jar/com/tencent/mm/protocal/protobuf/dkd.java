package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkd
  extends com.tencent.mm.bx.a
{
  public String DFR;
  public String DFq;
  public String EzS;
  public String cMo;
  public String dlB;
  public String nCa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.cMo != null) {
        paramVarArgs.d(2, this.cMo);
      }
      if (this.DFR != null) {
        paramVarArgs.d(3, this.DFR);
      }
      if (this.EzS != null) {
        paramVarArgs.d(4, this.EzS);
      }
      if (this.nCa != null) {
        paramVarArgs.d(5, this.nCa);
      }
      if (this.DFq != null) {
        paramVarArgs.d(6, this.DFq);
      }
      AppMethodBeat.o(123678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.dlB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cMo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cMo);
      }
      i = paramInt;
      if (this.DFR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DFR);
      }
      paramInt = i;
      if (this.EzS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EzS);
      }
      i = paramInt;
      if (this.nCa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nCa);
      }
      paramInt = i;
      if (this.DFq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DFq);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkd localdkd = (dkd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localdkd.dlB = locala.KhF.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localdkd.cMo = locala.KhF.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localdkd.DFR = locala.KhF.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localdkd.EzS = locala.KhF.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localdkd.nCa = locala.KhF.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localdkd.DFq = locala.KhF.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkd
 * JD-Core Version:    0.7.0.1
 */