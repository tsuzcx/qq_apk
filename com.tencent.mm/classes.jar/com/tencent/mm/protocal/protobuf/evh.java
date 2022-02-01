package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class evh
  extends com.tencent.mm.bw.a
{
  public float KGp;
  public String LnW;
  public String Ntg;
  public String Nth;
  public String Nti;
  public int Ntj;
  public float Ntk;
  public String Ntl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ntg != null) {
        paramVarArgs.e(1, this.Ntg);
      }
      if (this.LnW != null) {
        paramVarArgs.e(2, this.LnW);
      }
      if (this.Nth != null) {
        paramVarArgs.e(3, this.Nth);
      }
      if (this.Nti != null) {
        paramVarArgs.e(4, this.Nti);
      }
      paramVarArgs.aM(5, this.Ntj);
      paramVarArgs.E(6, this.KGp);
      paramVarArgs.E(7, this.Ntk);
      if (this.Ntl != null) {
        paramVarArgs.e(8, this.Ntl);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ntg == null) {
        break label592;
      }
    }
    label592:
    for (int i = g.a.a.b.b.a.f(1, this.Ntg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LnW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LnW);
      }
      i = paramInt;
      if (this.Nth != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nth);
      }
      paramInt = i;
      if (this.Nti != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nti);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Ntj) + (g.a.a.b.b.a.fS(6) + 4) + (g.a.a.b.b.a.fS(7) + 4);
      paramInt = i;
      if (this.Ntl != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Ntl);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        evh localevh = (evh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localevh.Ntg = locala.UbS.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localevh.LnW = locala.UbS.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localevh.Nth = locala.UbS.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localevh.Nti = locala.UbS.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localevh.Ntj = locala.UbS.zi();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localevh.KGp = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localevh.Ntk = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(147791);
          return 0;
        }
        localevh.Ntl = locala.UbS.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evh
 * JD-Core Version:    0.7.0.1
 */