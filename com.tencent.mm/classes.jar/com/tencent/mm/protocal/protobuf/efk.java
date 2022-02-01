package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class efk
  extends com.tencent.mm.bw.a
{
  public b KZE;
  public String MEq;
  public String MGp;
  public String NfG;
  public b NfH;
  public int xJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117930);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MGp != null) {
        paramVarArgs.e(1, this.MGp);
      }
      if (this.MEq != null) {
        paramVarArgs.e(2, this.MEq);
      }
      if (this.KZE != null) {
        paramVarArgs.c(3, this.KZE);
      }
      if (this.NfG != null) {
        paramVarArgs.e(4, this.NfG);
      }
      paramVarArgs.aM(5, this.xJa);
      if (this.NfH != null) {
        paramVarArgs.c(6, this.NfH);
      }
      AppMethodBeat.o(117930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MGp == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.f(1, this.MGp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MEq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MEq);
      }
      i = paramInt;
      if (this.KZE != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.KZE);
      }
      paramInt = i;
      if (this.NfG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NfG);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.xJa);
      paramInt = i;
      if (this.NfH != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.NfH);
      }
      AppMethodBeat.o(117930);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117930);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        efk localefk = (efk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117930);
          return -1;
        case 1: 
          localefk.MGp = locala.UbS.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 2: 
          localefk.MEq = locala.UbS.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 3: 
          localefk.KZE = locala.UbS.hPo();
          AppMethodBeat.o(117930);
          return 0;
        case 4: 
          localefk.NfG = locala.UbS.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 5: 
          localefk.xJa = locala.UbS.zi();
          AppMethodBeat.o(117930);
          return 0;
        }
        localefk.NfH = locala.UbS.hPo();
        AppMethodBeat.o(117930);
        return 0;
      }
      AppMethodBeat.o(117930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efk
 * JD-Core Version:    0.7.0.1
 */