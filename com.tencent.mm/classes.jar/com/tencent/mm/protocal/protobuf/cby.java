package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cby
  extends com.tencent.mm.bw.a
{
  public String DWw;
  public che FpV;
  public LinkedList<czd> FpW;
  
  public cby()
  {
    AppMethodBeat.i(91568);
    this.FpW = new LinkedList();
    AppMethodBeat.o(91568);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FpV != null)
      {
        paramVarArgs.ln(1, this.FpV.computeSize());
        this.FpV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FpW);
      if (this.DWw != null) {
        paramVarArgs.d(3, this.DWw);
      }
      AppMethodBeat.o(91569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FpV == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lm(1, this.FpV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FpW);
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DWw);
      }
      AppMethodBeat.o(91569);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FpW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cby localcby = (cby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91569);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new che();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((che)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcby.FpV = ((che)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91569);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcby.FpW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91569);
          return 0;
        }
        localcby.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91569);
        return 0;
      }
      AppMethodBeat.o(91569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cby
 * JD-Core Version:    0.7.0.1
 */