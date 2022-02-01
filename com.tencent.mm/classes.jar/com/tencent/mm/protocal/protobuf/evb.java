package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evb
  extends com.tencent.mm.bw.a
{
  public String Nta;
  public String Ntb;
  public LinkedList<String> Ntc;
  public int Ntd;
  
  public evb()
  {
    AppMethodBeat.i(147784);
    this.Ntc = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nta != null) {
        paramVarArgs.e(1, this.Nta);
      }
      if (this.Ntb != null) {
        paramVarArgs.e(2, this.Ntb);
      }
      paramVarArgs.e(3, 1, this.Ntc);
      paramVarArgs.aM(4, this.Ntd);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nta == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nta) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ntb != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Ntb);
      }
      paramInt = g.a.a.a.c(3, 1, this.Ntc);
      int j = g.a.a.b.b.a.bu(4, this.Ntd);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ntc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        evb localevb = (evb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localevb.Nta = locala.UbS.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localevb.Ntb = locala.UbS.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localevb.Ntc.add(locala.UbS.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localevb.Ntd = locala.UbS.zi();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evb
 * JD-Core Version:    0.7.0.1
 */