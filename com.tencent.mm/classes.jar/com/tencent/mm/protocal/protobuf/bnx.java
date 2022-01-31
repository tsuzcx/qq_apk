package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnx
  extends com.tencent.mm.bv.a
{
  public String title;
  public String url;
  public boolean xCh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56935);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.aS(3, this.xCh);
      AppMethodBeat.o(56935);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.url);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(56935);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56935);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bnx localbnx = (bnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56935);
          return -1;
        case 1: 
          localbnx.title = locala.CLY.readString();
          AppMethodBeat.o(56935);
          return 0;
        case 2: 
          localbnx.url = locala.CLY.readString();
          AppMethodBeat.o(56935);
          return 0;
        }
        localbnx.xCh = locala.CLY.emu();
        AppMethodBeat.o(56935);
        return 0;
      }
      AppMethodBeat.o(56935);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnx
 * JD-Core Version:    0.7.0.1
 */