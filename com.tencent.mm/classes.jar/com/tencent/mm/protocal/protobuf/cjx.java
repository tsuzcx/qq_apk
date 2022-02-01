package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjx
  extends com.tencent.mm.bw.a
{
  public erf Mpq;
  public bej Mpr;
  public erf Mps;
  public int dvv;
  public int height;
  public int iqg;
  public int retryCount;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mpq != null)
      {
        paramVarArgs.ni(1, this.Mpq.computeSize());
        this.Mpq.writeFields(paramVarArgs);
      }
      if (this.Mpr != null)
      {
        paramVarArgs.ni(2, this.Mpr.computeSize());
        this.Mpr.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.dvv);
      paramVarArgs.aM(4, this.iqg);
      paramVarArgs.aM(5, this.width);
      paramVarArgs.aM(6, this.height);
      if (this.Mps != null)
      {
        paramVarArgs.ni(7, this.Mps.computeSize());
        this.Mps.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.retryCount);
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mpq == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = g.a.a.a.nh(1, this.Mpq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mpr != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mpr.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.dvv) + g.a.a.b.b.a.bu(4, this.iqg) + g.a.a.b.b.a.bu(5, this.width) + g.a.a.b.b.a.bu(6, this.height);
      paramInt = i;
      if (this.Mps != null) {
        paramInt = i + g.a.a.a.nh(7, this.Mps.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.retryCount);
      AppMethodBeat.o(169087);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjx localcjx = (cjx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjx.Mpq = ((erf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bej();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bej)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjx.Mpr = ((bej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localcjx.dvv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localcjx.iqg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localcjx.width = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localcjx.height = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjx.Mps = ((erf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        }
        localcjx.retryCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjx
 * JD-Core Version:    0.7.0.1
 */