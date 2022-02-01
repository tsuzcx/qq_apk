package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbn
  extends com.tencent.mm.bx.a
{
  public int Height;
  public String MD5;
  public int Width;
  public String abBn;
  public String abvZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32452);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.g(1, this.MD5);
      }
      paramVarArgs.bS(2, this.Width);
      paramVarArgs.bS(3, this.Height);
      if (this.abvZ != null) {
        paramVarArgs.g(4, this.abvZ);
      }
      if (this.abBn != null) {
        paramVarArgs.g(5, this.abBn);
      }
      AppMethodBeat.o(32452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label429;
      }
    }
    label429:
    for (paramInt = i.a.a.b.b.a.h(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Width) + i.a.a.b.b.a.cJ(3, this.Height);
      paramInt = i;
      if (this.abvZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abvZ);
      }
      i = paramInt;
      if (this.abBn != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abBn);
      }
      AppMethodBeat.o(32452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32452);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fbn localfbn = (fbn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32452);
          return -1;
        case 1: 
          localfbn.MD5 = locala.ajGk.readString();
          AppMethodBeat.o(32452);
          return 0;
        case 2: 
          localfbn.Width = locala.ajGk.aar();
          AppMethodBeat.o(32452);
          return 0;
        case 3: 
          localfbn.Height = locala.ajGk.aar();
          AppMethodBeat.o(32452);
          return 0;
        case 4: 
          localfbn.abvZ = locala.ajGk.readString();
          AppMethodBeat.o(32452);
          return 0;
        }
        localfbn.abBn = locala.ajGk.readString();
        AppMethodBeat.o(32452);
        return 0;
      }
      AppMethodBeat.o(32452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbn
 * JD-Core Version:    0.7.0.1
 */