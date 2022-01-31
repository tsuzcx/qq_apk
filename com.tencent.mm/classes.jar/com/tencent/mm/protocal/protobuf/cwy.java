package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cwy
  extends com.tencent.mm.bv.a
{
  public String dCR;
  public String jJF;
  public String wNG;
  public int wpR;
  public String yeC;
  public String yeD;
  public String yeE;
  public String yeF;
  public String yeG;
  public String yeH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28732);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yeC == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(28732);
        throw paramVarArgs;
      }
      if (this.yeC != null) {
        paramVarArgs.e(1, this.yeC);
      }
      if (this.jJF != null) {
        paramVarArgs.e(2, this.jJF);
      }
      if (this.yeD != null) {
        paramVarArgs.e(3, this.yeD);
      }
      if (this.dCR != null) {
        paramVarArgs.e(4, this.dCR);
      }
      if (this.yeE != null) {
        paramVarArgs.e(5, this.yeE);
      }
      if (this.wNG != null) {
        paramVarArgs.e(6, this.wNG);
      }
      if (this.yeF != null) {
        paramVarArgs.e(7, this.yeF);
      }
      if (this.yeG != null) {
        paramVarArgs.e(8, this.yeG);
      }
      if (this.yeH != null) {
        paramVarArgs.e(9, this.yeH);
      }
      paramVarArgs.aO(10, this.wpR);
      AppMethodBeat.o(28732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yeC == null) {
        break label814;
      }
    }
    label814:
    for (int i = e.a.a.b.b.a.f(1, this.yeC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJF);
      }
      i = paramInt;
      if (this.yeD != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.yeD);
      }
      paramInt = i;
      if (this.dCR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.dCR);
      }
      i = paramInt;
      if (this.yeE != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.yeE);
      }
      paramInt = i;
      if (this.wNG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wNG);
      }
      i = paramInt;
      if (this.yeF != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.yeF);
      }
      paramInt = i;
      if (this.yeG != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.yeG);
      }
      i = paramInt;
      if (this.yeH != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.yeH);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.wpR);
      AppMethodBeat.o(28732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.yeC == null)
        {
          paramVarArgs = new b("Not all required fields were included: LocalNodeId");
          AppMethodBeat.o(28732);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28732);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cwy localcwy = (cwy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28732);
          return -1;
        case 1: 
          localcwy.yeC = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 2: 
          localcwy.jJF = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 3: 
          localcwy.yeD = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 4: 
          localcwy.dCR = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 5: 
          localcwy.yeE = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 6: 
          localcwy.wNG = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 7: 
          localcwy.yeF = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 8: 
          localcwy.yeG = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        case 9: 
          localcwy.yeH = locala.CLY.readString();
          AppMethodBeat.o(28732);
          return 0;
        }
        localcwy.wpR = locala.CLY.sl();
        AppMethodBeat.o(28732);
        return 0;
      }
      AppMethodBeat.o(28732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwy
 * JD-Core Version:    0.7.0.1
 */