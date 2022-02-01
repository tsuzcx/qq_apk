package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fs
  extends com.tencent.mm.bx.a
{
  public String YHe;
  public String YHf;
  public String YHg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125710);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YHe != null) {
        paramVarArgs.g(1, this.YHe);
      }
      if (this.YHf != null) {
        paramVarArgs.g(2, this.YHf);
      }
      if (this.YHg != null) {
        paramVarArgs.g(3, this.YHg);
      }
      AppMethodBeat.o(125710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YHe == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.YHe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YHf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YHf);
      }
      i = paramInt;
      if (this.YHg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YHg);
      }
      AppMethodBeat.o(125710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125710);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fs localfs = (fs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125710);
          return -1;
        case 1: 
          localfs.YHe = locala.ajGk.readString();
          AppMethodBeat.o(125710);
          return 0;
        case 2: 
          localfs.YHf = locala.ajGk.readString();
          AppMethodBeat.o(125710);
          return 0;
        }
        localfs.YHg = locala.ajGk.readString();
        AppMethodBeat.o(125710);
        return 0;
      }
      AppMethodBeat.o(125710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fs
 * JD-Core Version:    0.7.0.1
 */