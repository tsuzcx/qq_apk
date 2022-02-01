package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String Gal;
  public String Gam;
  public String Gan;
  public String Gao;
  public String Gap;
  public String dST;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222819);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Gal != null) {
        paramVarArgs.e(1, this.Gal);
      }
      if (this.Gam != null) {
        paramVarArgs.e(2, this.Gam);
      }
      if (this.Gan != null) {
        paramVarArgs.e(3, this.Gan);
      }
      if (this.dST != null) {
        paramVarArgs.e(4, this.dST);
      }
      if (this.Gao != null) {
        paramVarArgs.e(5, this.Gao);
      }
      if (this.Gap != null) {
        paramVarArgs.e(6, this.Gap);
      }
      AppMethodBeat.o(222819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gal == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.Gal) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gam != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Gam);
      }
      i = paramInt;
      if (this.Gan != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Gan);
      }
      paramInt = i;
      if (this.dST != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dST);
      }
      i = paramInt;
      if (this.Gao != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Gao);
      }
      paramInt = i;
      if (this.Gap != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Gap);
      }
      AppMethodBeat.o(222819);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222819);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(222819);
          return -1;
        case 1: 
          localb.Gal = locala.UbS.readString();
          AppMethodBeat.o(222819);
          return 0;
        case 2: 
          localb.Gam = locala.UbS.readString();
          AppMethodBeat.o(222819);
          return 0;
        case 3: 
          localb.Gan = locala.UbS.readString();
          AppMethodBeat.o(222819);
          return 0;
        case 4: 
          localb.dST = locala.UbS.readString();
          AppMethodBeat.o(222819);
          return 0;
        case 5: 
          localb.Gao = locala.UbS.readString();
          AppMethodBeat.o(222819);
          return 0;
        }
        localb.Gap = locala.UbS.readString();
        AppMethodBeat.o(222819);
        return 0;
      }
      AppMethodBeat.o(222819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.b
 * JD-Core Version:    0.7.0.1
 */