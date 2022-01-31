package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cge
  extends com.tencent.mm.bv.a
{
  public int fQC;
  public int fQD;
  public int fQE;
  public int fQF;
  public int opType;
  public long timeStamp;
  public String xQT;
  public String xQU;
  public String xQV;
  public String xQW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94628);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQT == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      if (this.xQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      if (this.xQV == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      if (this.xQW == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.opType);
      paramVarArgs.aO(2, this.fQF);
      paramVarArgs.aO(3, this.fQC);
      paramVarArgs.am(4, this.timeStamp);
      paramVarArgs.aO(5, this.fQD);
      paramVarArgs.aO(6, this.fQE);
      if (this.xQT != null) {
        paramVarArgs.e(7, this.xQT);
      }
      if (this.xQU != null) {
        paramVarArgs.e(8, this.xQU);
      }
      if (this.xQV != null) {
        paramVarArgs.e(9, this.xQV);
      }
      if (this.xQW != null) {
        paramVarArgs.e(10, this.xQW);
      }
      AppMethodBeat.o(94628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.opType) + 0 + e.a.a.b.b.a.bl(2, this.fQF) + e.a.a.b.b.a.bl(3, this.fQC) + e.a.a.b.b.a.p(4, this.timeStamp) + e.a.a.b.b.a.bl(5, this.fQD) + e.a.a.b.b.a.bl(6, this.fQE);
      paramInt = i;
      if (this.xQT != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xQT);
      }
      i = paramInt;
      if (this.xQU != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xQU);
      }
      paramInt = i;
      if (this.xQV != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xQV);
      }
      i = paramInt;
      if (this.xQW != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xQW);
      }
      AppMethodBeat.o(94628);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xQT == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      if (this.xQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      if (this.xQV == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      if (this.xQW == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(94628);
        throw paramVarArgs;
      }
      AppMethodBeat.o(94628);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cge localcge = (cge)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94628);
        return -1;
      case 1: 
        localcge.opType = locala.CLY.sl();
        AppMethodBeat.o(94628);
        return 0;
      case 2: 
        localcge.fQF = locala.CLY.sl();
        AppMethodBeat.o(94628);
        return 0;
      case 3: 
        localcge.fQC = locala.CLY.sl();
        AppMethodBeat.o(94628);
        return 0;
      case 4: 
        localcge.timeStamp = locala.CLY.sm();
        AppMethodBeat.o(94628);
        return 0;
      case 5: 
        localcge.fQD = locala.CLY.sl();
        AppMethodBeat.o(94628);
        return 0;
      case 6: 
        localcge.fQE = locala.CLY.sl();
        AppMethodBeat.o(94628);
        return 0;
      case 7: 
        localcge.xQT = locala.CLY.readString();
        AppMethodBeat.o(94628);
        return 0;
      case 8: 
        localcge.xQU = locala.CLY.readString();
        AppMethodBeat.o(94628);
        return 0;
      case 9: 
        localcge.xQV = locala.CLY.readString();
        AppMethodBeat.o(94628);
        return 0;
      }
      localcge.xQW = locala.CLY.readString();
      AppMethodBeat.o(94628);
      return 0;
    }
    AppMethodBeat.o(94628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cge
 * JD-Core Version:    0.7.0.1
 */