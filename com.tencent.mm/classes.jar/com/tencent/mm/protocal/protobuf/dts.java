package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dts
  extends com.tencent.mm.bx.a
{
  public String aaZm;
  public String aaZn;
  public int aaZo;
  public int aaZp;
  public int aaZq;
  public int aaZr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaZm != null) {
        paramVarArgs.g(1, this.aaZm);
      }
      if (this.aaZn != null) {
        paramVarArgs.g(2, this.aaZn);
      }
      paramVarArgs.bS(3, this.aaZo);
      paramVarArgs.bS(4, this.aaZp);
      paramVarArgs.bS(5, this.aaZq);
      paramVarArgs.bS(7, this.aaZr);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaZm == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaZm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaZn != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaZn);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaZo);
      int j = i.a.a.b.b.a.cJ(4, this.aaZp);
      int k = i.a.a.b.b.a.cJ(5, this.aaZq);
      int m = i.a.a.b.b.a.cJ(7, this.aaZr);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dts localdts = (dts)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localdts.aaZm = locala.ajGk.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localdts.aaZn = locala.ajGk.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localdts.aaZo = locala.ajGk.aar();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localdts.aaZp = locala.ajGk.aar();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localdts.aaZq = locala.ajGk.aar();
          AppMethodBeat.o(133179);
          return 0;
        }
        localdts.aaZr = locala.ajGk.aar();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dts
 * JD-Core Version:    0.7.0.1
 */