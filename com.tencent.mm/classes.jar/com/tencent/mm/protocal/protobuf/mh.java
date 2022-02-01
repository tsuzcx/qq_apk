package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mh
  extends com.tencent.mm.cd.a
{
  public String RRW;
  public String UserName;
  public String mVB;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.RRW != null) {
        paramVarArgs.f(3, this.RRW);
      }
      if (this.mVB != null) {
        paramVarArgs.f(4, this.mVB);
      }
      AppMethodBeat.o(205244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.RRW != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RRW);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVB);
      }
      AppMethodBeat.o(205244);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205244);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205244);
          return -1;
        case 1: 
          localmh.UserName = locala.abFh.readString();
          AppMethodBeat.o(205244);
          return 0;
        case 2: 
          localmh.rWI = locala.abFh.readString();
          AppMethodBeat.o(205244);
          return 0;
        case 3: 
          localmh.RRW = locala.abFh.readString();
          AppMethodBeat.o(205244);
          return 0;
        }
        localmh.mVB = locala.abFh.readString();
        AppMethodBeat.o(205244);
        return 0;
      }
      AppMethodBeat.o(205244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */