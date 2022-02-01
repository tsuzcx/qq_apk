package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahq
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String title;
  public String yUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.yUB != null) {
        paramVarArgs.e(3, this.yUB);
      }
      AppMethodBeat.o(91437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.yUB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yUB);
      }
      AppMethodBeat.o(91437);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91437);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ahq localahq = (ahq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91437);
          return -1;
        case 1: 
          localahq.title = locala.UbS.readString();
          AppMethodBeat.o(91437);
          return 0;
        case 2: 
          localahq.desc = locala.UbS.readString();
          AppMethodBeat.o(91437);
          return 0;
        }
        localahq.yUB = locala.UbS.readString();
        AppMethodBeat.o(91437);
        return 0;
      }
      AppMethodBeat.o(91437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahq
 * JD-Core Version:    0.7.0.1
 */