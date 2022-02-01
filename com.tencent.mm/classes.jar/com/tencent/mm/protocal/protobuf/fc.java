package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fc
  extends com.tencent.mm.bw.a
{
  public String KIw;
  public String KIx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KIw != null) {
        paramVarArgs.e(1, this.KIw);
      }
      if (this.KIx != null) {
        paramVarArgs.e(2, this.KIx);
      }
      AppMethodBeat.o(125711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KIw == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.KIw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KIx != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KIx);
      }
      AppMethodBeat.o(125711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125711);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fc localfc = (fc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125711);
          return -1;
        case 1: 
          localfc.KIw = locala.UbS.readString();
          AppMethodBeat.o(125711);
          return 0;
        }
        localfc.KIx = locala.UbS.readString();
        AppMethodBeat.o(125711);
        return 0;
      }
      AppMethodBeat.o(125711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fc
 * JD-Core Version:    0.7.0.1
 */