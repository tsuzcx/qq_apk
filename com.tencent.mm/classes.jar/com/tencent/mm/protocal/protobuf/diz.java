package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class diz
  extends com.tencent.mm.bw.a
{
  public String HQE;
  public String HQF;
  public String HQG;
  public String HQH;
  public int iqa;
  public int iqb;
  public int iqc;
  public int iqd;
  public int opType;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQE == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HQF == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HQG == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HQH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.opType);
      paramVarArgs.aS(2, this.iqd);
      paramVarArgs.aS(3, this.iqa);
      paramVarArgs.aZ(4, this.timeStamp);
      paramVarArgs.aS(5, this.iqb);
      paramVarArgs.aS(6, this.iqc);
      if (this.HQE != null) {
        paramVarArgs.d(7, this.HQE);
      }
      if (this.HQF != null) {
        paramVarArgs.d(8, this.HQF);
      }
      if (this.HQG != null) {
        paramVarArgs.d(9, this.HQG);
      }
      if (this.HQH != null) {
        paramVarArgs.d(10, this.HQH);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.opType) + 0 + f.a.a.b.b.a.bz(2, this.iqd) + f.a.a.b.b.a.bz(3, this.iqa) + f.a.a.b.b.a.p(4, this.timeStamp) + f.a.a.b.b.a.bz(5, this.iqb) + f.a.a.b.b.a.bz(6, this.iqc);
      paramInt = i;
      if (this.HQE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HQE);
      }
      i = paramInt;
      if (this.HQF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HQF);
      }
      paramInt = i;
      if (this.HQG != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HQG);
      }
      i = paramInt;
      if (this.HQH != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HQH);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HQE == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HQF == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HQG == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HQH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      diz localdiz = (diz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localdiz.opType = locala.OmT.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localdiz.iqd = locala.OmT.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localdiz.iqa = locala.OmT.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localdiz.timeStamp = locala.OmT.zd();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localdiz.iqb = locala.OmT.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localdiz.iqc = locala.OmT.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localdiz.HQE = locala.OmT.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localdiz.HQF = locala.OmT.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localdiz.HQG = locala.OmT.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localdiz.HQH = locala.OmT.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diz
 * JD-Core Version:    0.7.0.1
 */