package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class brs
  extends com.tencent.mm.bx.a
{
  public String ZVp;
  public String ZVq;
  public String ZVr;
  public String ZVs;
  public int ZZU;
  public String finderUsername;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260204);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZVp != null) {
        paramVarArgs.g(1, this.ZVp);
      }
      if (this.ZVq != null) {
        paramVarArgs.g(2, this.ZVq);
      }
      if (this.ZVr != null) {
        paramVarArgs.g(3, this.ZVr);
      }
      if (this.ZVs != null) {
        paramVarArgs.g(4, this.ZVs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(5, this.finderUsername);
      }
      paramVarArgs.bS(6, this.ZZU);
      AppMethodBeat.o(260204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZVp == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.ZVp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZVq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZVq);
      }
      i = paramInt;
      if (this.ZVr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZVr);
      }
      paramInt = i;
      if (this.ZVs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZVs);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.finderUsername);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.ZZU);
      AppMethodBeat.o(260204);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260204);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        brs localbrs = (brs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260204);
          return -1;
        case 1: 
          localbrs.ZVp = locala.ajGk.readString();
          AppMethodBeat.o(260204);
          return 0;
        case 2: 
          localbrs.ZVq = locala.ajGk.readString();
          AppMethodBeat.o(260204);
          return 0;
        case 3: 
          localbrs.ZVr = locala.ajGk.readString();
          AppMethodBeat.o(260204);
          return 0;
        case 4: 
          localbrs.ZVs = locala.ajGk.readString();
          AppMethodBeat.o(260204);
          return 0;
        case 5: 
          localbrs.finderUsername = locala.ajGk.readString();
          AppMethodBeat.o(260204);
          return 0;
        }
        localbrs.ZZU = locala.ajGk.aar();
        AppMethodBeat.o(260204);
        return 0;
      }
      AppMethodBeat.o(260204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brs
 * JD-Core Version:    0.7.0.1
 */