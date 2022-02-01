package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fsv
  extends com.tencent.mm.bx.a
{
  public String hFb;
  public String hMM;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181514);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMM != null) {
        paramVarArgs.g(1, this.hMM);
      }
      if (this.hFb != null) {
        paramVarArgs.g(2, this.hFb);
      }
      paramVarArgs.bS(3, this.scene);
      AppMethodBeat.o(181514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hMM == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.hMM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hFb != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hFb);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.scene);
      AppMethodBeat.o(181514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181514);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fsv localfsv = (fsv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181514);
          return -1;
        case 1: 
          localfsv.hMM = locala.ajGk.readString();
          AppMethodBeat.o(181514);
          return 0;
        case 2: 
          localfsv.hFb = locala.ajGk.readString();
          AppMethodBeat.o(181514);
          return 0;
        }
        localfsv.scene = locala.ajGk.aar();
        AppMethodBeat.o(181514);
        return 0;
      }
      AppMethodBeat.o(181514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fsv
 * JD-Core Version:    0.7.0.1
 */