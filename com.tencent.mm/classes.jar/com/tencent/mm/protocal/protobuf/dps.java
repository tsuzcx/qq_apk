package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dps
  extends com.tencent.mm.bx.a
{
  public String dkR;
  public String uJF;
  public String xSA;
  public String xSB;
  public String xSC;
  public String xSd;
  public String xSz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xSz != null) {
        paramVarArgs.d(1, this.xSz);
      }
      if (this.xSA != null) {
        paramVarArgs.d(2, this.xSA);
      }
      if (this.xSd != null) {
        paramVarArgs.d(3, this.xSd);
      }
      if (this.uJF != null) {
        paramVarArgs.d(4, this.uJF);
      }
      if (this.dkR != null) {
        paramVarArgs.d(5, this.dkR);
      }
      if (this.xSB != null) {
        paramVarArgs.d(6, this.xSB);
      }
      if (this.xSC != null) {
        paramVarArgs.d(7, this.xSC);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xSz == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.xSz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xSA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xSA);
      }
      i = paramInt;
      if (this.xSd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xSd);
      }
      paramInt = i;
      if (this.uJF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uJF);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dkR);
      }
      paramInt = i;
      if (this.xSB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.xSB);
      }
      i = paramInt;
      if (this.xSC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xSC);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dps localdps = (dps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localdps.xSz = locala.NPN.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localdps.xSA = locala.NPN.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localdps.xSd = locala.NPN.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localdps.uJF = locala.NPN.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localdps.dkR = locala.NPN.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localdps.xSB = locala.NPN.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localdps.xSC = locala.NPN.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dps
 * JD-Core Version:    0.7.0.1
 */