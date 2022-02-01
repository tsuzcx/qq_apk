package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class egm
  extends com.tencent.mm.bx.a
{
  public String ablN;
  public int ablO;
  public String appId;
  public int hDq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153295);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.ablN != null) {
        paramVarArgs.g(2, this.ablN);
      }
      paramVarArgs.bS(3, this.hDq);
      paramVarArgs.bS(4, this.ablO);
      AppMethodBeat.o(153295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ablN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ablN);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.hDq);
      int j = i.a.a.b.b.a.cJ(4, this.ablO);
      AppMethodBeat.o(153295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153295);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        egm localegm = (egm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153295);
          return -1;
        case 1: 
          localegm.appId = locala.ajGk.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 2: 
          localegm.ablN = locala.ajGk.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 3: 
          localegm.hDq = locala.ajGk.aar();
          AppMethodBeat.o(153295);
          return 0;
        }
        localegm.ablO = locala.ajGk.aar();
        AppMethodBeat.o(153295);
        return 0;
      }
      AppMethodBeat.o(153295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egm
 * JD-Core Version:    0.7.0.1
 */