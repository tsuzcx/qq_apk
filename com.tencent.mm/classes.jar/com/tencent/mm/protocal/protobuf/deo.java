package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deo
  extends com.tencent.mm.bw.a
{
  public String HLI;
  public String HLJ;
  public String HLK;
  public String HLL;
  public int HLM;
  public String HLN;
  public String content;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153299);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.HLI != null) {
        paramVarArgs.d(2, this.HLI);
      }
      if (this.HLJ != null) {
        paramVarArgs.d(3, this.HLJ);
      }
      if (this.HLK != null) {
        paramVarArgs.d(4, this.HLK);
      }
      if (this.HLL != null) {
        paramVarArgs.d(5, this.HLL);
      }
      paramVarArgs.aS(6, this.HLM);
      paramVarArgs.aS(7, this.state);
      if (this.HLN != null) {
        paramVarArgs.d(8, this.HLN);
      }
      AppMethodBeat.o(153299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label606;
      }
    }
    label606:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HLI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HLI);
      }
      i = paramInt;
      if (this.HLJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HLJ);
      }
      paramInt = i;
      if (this.HLK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HLK);
      }
      i = paramInt;
      if (this.HLL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HLL);
      }
      i = i + f.a.a.b.b.a.bz(6, this.HLM) + f.a.a.b.b.a.bz(7, this.state);
      paramInt = i;
      if (this.HLN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HLN);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        deo localdeo = (deo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localdeo.content = locala.OmT.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localdeo.HLI = locala.OmT.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localdeo.HLJ = locala.OmT.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localdeo.HLK = locala.OmT.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localdeo.HLL = locala.OmT.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localdeo.HLM = locala.OmT.zc();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localdeo.state = locala.OmT.zc();
          AppMethodBeat.o(153299);
          return 0;
        }
        localdeo.HLN = locala.OmT.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deo
 * JD-Core Version:    0.7.0.1
 */