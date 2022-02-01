package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ecd
  extends com.tencent.mm.bw.a
{
  public int NbF;
  public esq NbG;
  public int Ncl;
  public int Ncm;
  public int Ncn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NbG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.NbG != null)
      {
        paramVarArgs.ni(1, this.NbG.computeSize());
        this.NbG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.NbF);
      paramVarArgs.aM(3, this.Ncl);
      paramVarArgs.aM(4, this.Ncm);
      paramVarArgs.aM(5, this.Ncn);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NbG == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = g.a.a.a.nh(1, this.NbG.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.NbF);
      int j = g.a.a.b.b.a.bu(3, this.Ncl);
      int k = g.a.a.b.b.a.bu(4, this.Ncm);
      int m = g.a.a.b.b.a.bu(5, this.Ncn);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NbG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecd localecd = (ecd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localecd.NbG = ((esq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localecd.NbF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localecd.Ncl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localecd.Ncm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115855);
          return 0;
        }
        localecd.Ncn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecd
 * JD-Core Version:    0.7.0.1
 */