package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hu
  extends com.tencent.mm.bw.a
{
  public String KLH;
  public String KLI;
  public String dDj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLH != null) {
        paramVarArgs.e(1, this.KLH);
      }
      if (this.KLI != null) {
        paramVarArgs.e(2, this.KLI);
      }
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      AppMethodBeat.o(123549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KLH == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.KLH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KLI);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dDj);
      }
      AppMethodBeat.o(123549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123549);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        hu localhu = (hu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123549);
          return -1;
        case 1: 
          localhu.KLH = locala.UbS.readString();
          AppMethodBeat.o(123549);
          return 0;
        case 2: 
          localhu.KLI = locala.UbS.readString();
          AppMethodBeat.o(123549);
          return 0;
        }
        localhu.dDj = locala.UbS.readString();
        AppMethodBeat.o(123549);
        return 0;
      }
      AppMethodBeat.o(123549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hu
 * JD-Core Version:    0.7.0.1
 */