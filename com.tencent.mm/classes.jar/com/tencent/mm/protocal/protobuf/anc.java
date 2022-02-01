package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anc
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int KHd;
  public String KHe;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138174);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      paramVarArgs.aM(3, this.KHd);
      if (this.KHe != null) {
        paramVarArgs.e(4, this.KHe);
      }
      AppMethodBeat.o(138174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Desc);
      }
      i += g.a.a.b.b.a.bu(3, this.KHd);
      paramInt = i;
      if (this.KHe != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KHe);
      }
      AppMethodBeat.o(138174);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(138174);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anc localanc = (anc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138174);
          return -1;
        case 1: 
          localanc.Title = locala.UbS.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 2: 
          localanc.Desc = locala.UbS.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 3: 
          localanc.KHd = locala.UbS.zi();
          AppMethodBeat.o(138174);
          return 0;
        }
        localanc.KHe = locala.UbS.readString();
        AppMethodBeat.o(138174);
        return 0;
      }
      AppMethodBeat.o(138174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anc
 * JD-Core Version:    0.7.0.1
 */