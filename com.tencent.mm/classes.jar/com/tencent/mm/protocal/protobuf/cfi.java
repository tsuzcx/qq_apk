package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cfi
  extends com.tencent.mm.bw.a
{
  public ade Mlu;
  public LinkedList<cft> Mlv;
  public int cSx;
  public String dNA;
  
  public cfi()
  {
    AppMethodBeat.i(220710);
    this.cSx = 0;
    this.Mlv = new LinkedList();
    AppMethodBeat.o(220710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mlu == null)
      {
        paramVarArgs = new b("Not all required fields were included: idInfo");
        AppMethodBeat.o(220711);
        throw paramVarArgs;
      }
      if (this.Mlu != null)
      {
        paramVarArgs.ni(1, this.Mlu.computeSize());
        this.Mlu.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.cSx);
      if (this.dNA != null) {
        paramVarArgs.e(3, this.dNA);
      }
      paramVarArgs.e(4, 8, this.Mlv);
      AppMethodBeat.o(220711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mlu == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = g.a.a.a.nh(1, this.Mlu.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.cSx);
      paramInt = i;
      if (this.dNA != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dNA);
      }
      i = g.a.a.a.c(4, 8, this.Mlv);
      AppMethodBeat.o(220711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mlv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Mlu == null)
        {
          paramVarArgs = new b("Not all required fields were included: idInfo");
          AppMethodBeat.o(220711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cfi localcfi = (cfi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220711);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ade();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ade)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcfi.Mlu = ((ade)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220711);
          return 0;
        case 2: 
          localcfi.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220711);
          return 0;
        case 3: 
          localcfi.dNA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220711);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cft();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cft)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcfi.Mlv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(220711);
        return 0;
      }
      AppMethodBeat.o(220711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfi
 * JD-Core Version:    0.7.0.1
 */