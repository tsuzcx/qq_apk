package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bqi
  extends com.tencent.mm.bx.a
{
  public int ZYl;
  public int ZYm;
  public b ZYn;
  public String hgl;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257717);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hgl != null) {
        paramVarArgs.g(1, this.hgl);
      }
      if (this.sessionId != null) {
        paramVarArgs.g(2, this.sessionId);
      }
      paramVarArgs.bS(3, this.ZYl);
      paramVarArgs.bS(4, this.ZYm);
      if (this.ZYn != null) {
        paramVarArgs.d(5, this.ZYn);
      }
      AppMethodBeat.o(257717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hgl == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.hgl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.sessionId);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.ZYl) + i.a.a.b.b.a.cJ(4, this.ZYm);
      paramInt = i;
      if (this.ZYn != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZYn);
      }
      AppMethodBeat.o(257717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257717);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bqi localbqi = (bqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257717);
          return -1;
        case 1: 
          localbqi.hgl = locala.ajGk.readString();
          AppMethodBeat.o(257717);
          return 0;
        case 2: 
          localbqi.sessionId = locala.ajGk.readString();
          AppMethodBeat.o(257717);
          return 0;
        case 3: 
          localbqi.ZYl = locala.ajGk.aar();
          AppMethodBeat.o(257717);
          return 0;
        case 4: 
          localbqi.ZYm = locala.ajGk.aar();
          AppMethodBeat.o(257717);
          return 0;
        }
        localbqi.ZYn = locala.ajGk.kFX();
        AppMethodBeat.o(257717);
        return 0;
      }
      AppMethodBeat.o(257717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqi
 * JD-Core Version:    0.7.0.1
 */