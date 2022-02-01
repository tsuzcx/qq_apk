package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hw
  extends com.tencent.mm.bw.a
{
  public String dQx;
  public String qPT;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123552);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      if (this.qPT != null) {
        paramVarArgs.e(2, this.qPT);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      AppMethodBeat.o(123552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.dQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qPT != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qPT);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      AppMethodBeat.o(123552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123552);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        hw localhw = (hw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123552);
          return -1;
        case 1: 
          localhw.dQx = locala.UbS.readString();
          AppMethodBeat.o(123552);
          return 0;
        case 2: 
          localhw.qPT = locala.UbS.readString();
          AppMethodBeat.o(123552);
          return 0;
        }
        localhw.title = locala.UbS.readString();
        AppMethodBeat.o(123552);
        return 0;
      }
      AppMethodBeat.o(123552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hw
 * JD-Core Version:    0.7.0.1
 */