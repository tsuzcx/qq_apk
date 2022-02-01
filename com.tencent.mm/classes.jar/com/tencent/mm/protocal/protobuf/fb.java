package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fb
  extends com.tencent.mm.bw.a
{
  public String KIt;
  public String KIu;
  public String KIv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KIt != null) {
        paramVarArgs.e(1, this.KIt);
      }
      if (this.KIu != null) {
        paramVarArgs.e(2, this.KIu);
      }
      if (this.KIv != null) {
        paramVarArgs.e(3, this.KIv);
      }
      AppMethodBeat.o(125710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KIt == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.KIt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KIu != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KIu);
      }
      i = paramInt;
      if (this.KIv != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KIv);
      }
      AppMethodBeat.o(125710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125710);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fb localfb = (fb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125710);
          return -1;
        case 1: 
          localfb.KIt = locala.UbS.readString();
          AppMethodBeat.o(125710);
          return 0;
        case 2: 
          localfb.KIu = locala.UbS.readString();
          AppMethodBeat.o(125710);
          return 0;
        }
        localfb.KIv = locala.UbS.readString();
        AppMethodBeat.o(125710);
        return 0;
      }
      AppMethodBeat.o(125710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fb
 * JD-Core Version:    0.7.0.1
 */