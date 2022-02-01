package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dz
  extends com.tencent.mm.bw.a
{
  public String KHW;
  public String dQx;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168751);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.KHW != null) {
        paramVarArgs.e(3, this.KHW);
      }
      AppMethodBeat.o(168751);
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
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.KHW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHW);
      }
      AppMethodBeat.o(168751);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168751);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dz localdz = (dz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168751);
          return -1;
        case 1: 
          localdz.title = locala.UbS.readString();
          AppMethodBeat.o(168751);
          return 0;
        case 2: 
          localdz.dQx = locala.UbS.readString();
          AppMethodBeat.o(168751);
          return 0;
        }
        localdz.KHW = locala.UbS.readString();
        AppMethodBeat.o(168751);
        return 0;
      }
      AppMethodBeat.o(168751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */