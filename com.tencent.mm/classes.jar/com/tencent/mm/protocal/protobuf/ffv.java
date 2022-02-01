package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ffv
  extends com.tencent.mm.bx.a
{
  public long abFR;
  public long abFS;
  public String musicId;
  public String nSg;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257974);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.g(1, this.type);
      }
      if (this.nSg != null) {
        paramVarArgs.g(2, this.nSg);
      }
      if (this.musicId != null) {
        paramVarArgs.g(3, this.musicId);
      }
      paramVarArgs.bv(4, this.abFR);
      paramVarArgs.bv(5, this.abFS);
      AppMethodBeat.o(257974);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label422;
      }
    }
    label422:
    for (int i = i.a.a.b.b.a.h(1, this.type) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nSg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nSg);
      }
      i = paramInt;
      if (this.musicId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.musicId);
      }
      paramInt = i.a.a.b.b.a.q(4, this.abFR);
      int j = i.a.a.b.b.a.q(5, this.abFS);
      AppMethodBeat.o(257974);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257974);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ffv localffv = (ffv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257974);
          return -1;
        case 1: 
          localffv.type = locala.ajGk.readString();
          AppMethodBeat.o(257974);
          return 0;
        case 2: 
          localffv.nSg = locala.ajGk.readString();
          AppMethodBeat.o(257974);
          return 0;
        case 3: 
          localffv.musicId = locala.ajGk.readString();
          AppMethodBeat.o(257974);
          return 0;
        case 4: 
          localffv.abFR = locala.ajGk.aaw();
          AppMethodBeat.o(257974);
          return 0;
        }
        localffv.abFS = locala.ajGk.aaw();
        AppMethodBeat.o(257974);
        return 0;
      }
      AppMethodBeat.o(257974);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffv
 * JD-Core Version:    0.7.0.1
 */