package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ej
  extends com.tencent.mm.bw.a
{
  public String DQS;
  public String DQT;
  public int DQU;
  public String Id;
  public String Version;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.Version != null) {
        paramVarArgs.d(2, this.Version);
      }
      if (this.tkL != null) {
        paramVarArgs.d(3, this.tkL);
      }
      if (this.DQS != null) {
        paramVarArgs.d(4, this.DQS);
      }
      if (this.DQT != null) {
        paramVarArgs.d(5, this.DQT);
      }
      paramVarArgs.aR(6, this.DQU);
      AppMethodBeat.o(125709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Version);
      }
      i = paramInt;
      if (this.tkL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tkL);
      }
      paramInt = i;
      if (this.DQS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DQS);
      }
      i = paramInt;
      if (this.DQT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DQT);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.DQU);
      AppMethodBeat.o(125709);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125709);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125709);
          return -1;
        case 1: 
          localej.Id = locala.LVo.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 2: 
          localej.Version = locala.LVo.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 3: 
          localej.tkL = locala.LVo.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 4: 
          localej.DQS = locala.LVo.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 5: 
          localej.DQT = locala.LVo.readString();
          AppMethodBeat.o(125709);
          return 0;
        }
        localej.DQU = locala.LVo.xF();
        AppMethodBeat.o(125709);
        return 0;
      }
      AppMethodBeat.o(125709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */