package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmn
  extends com.tencent.mm.bv.a
{
  public int cnK;
  public String content;
  public int state;
  public String xMC;
  public int xMG;
  public String xMI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114992);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xMI != null) {
        paramVarArgs.e(1, this.xMI);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.content != null) {
        paramVarArgs.e(3, this.content);
      }
      if (this.xMC != null) {
        paramVarArgs.e(4, this.xMC);
      }
      paramVarArgs.aO(5, this.xMG);
      paramVarArgs.aO(6, this.state);
      AppMethodBeat.o(114992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMI == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = e.a.a.b.b.a.f(1, this.xMI) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.content);
      }
      i = paramInt;
      if (this.xMC != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xMC);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.xMG);
      int j = e.a.a.b.b.a.bl(6, this.state);
      AppMethodBeat.o(114992);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114992);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cmn localcmn = (cmn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114992);
          return -1;
        case 1: 
          localcmn.xMI = locala.CLY.readString();
          AppMethodBeat.o(114992);
          return 0;
        case 2: 
          localcmn.cnK = locala.CLY.sl();
          AppMethodBeat.o(114992);
          return 0;
        case 3: 
          localcmn.content = locala.CLY.readString();
          AppMethodBeat.o(114992);
          return 0;
        case 4: 
          localcmn.xMC = locala.CLY.readString();
          AppMethodBeat.o(114992);
          return 0;
        case 5: 
          localcmn.xMG = locala.CLY.sl();
          AppMethodBeat.o(114992);
          return 0;
        }
        localcmn.state = locala.CLY.sl();
        AppMethodBeat.o(114992);
        return 0;
      }
      AppMethodBeat.o(114992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmn
 * JD-Core Version:    0.7.0.1
 */