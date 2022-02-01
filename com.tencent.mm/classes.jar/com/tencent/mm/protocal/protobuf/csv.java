package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csv
  extends com.tencent.mm.bw.a
{
  public ehf KEN;
  public csx MxT;
  public csw MxU;
  public csw MxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KEN != null)
      {
        paramVarArgs.ni(1, this.KEN.computeSize());
        this.KEN.writeFields(paramVarArgs);
      }
      if (this.MxT != null)
      {
        paramVarArgs.ni(2, this.MxT.computeSize());
        this.MxT.writeFields(paramVarArgs);
      }
      if (this.MxU != null)
      {
        paramVarArgs.ni(3, this.MxU.computeSize());
        this.MxU.writeFields(paramVarArgs);
      }
      if (this.MxV != null)
      {
        paramVarArgs.ni(4, this.MxV.computeSize());
        this.MxV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KEN == null) {
        break label774;
      }
    }
    label774:
    for (int i = g.a.a.a.nh(1, this.KEN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MxT != null) {
        paramInt = i + g.a.a.a.nh(2, this.MxT.computeSize());
      }
      i = paramInt;
      if (this.MxU != null) {
        i = paramInt + g.a.a.a.nh(3, this.MxU.computeSize());
      }
      paramInt = i;
      if (this.MxV != null) {
        paramInt = i + g.a.a.a.nh(4, this.MxV.computeSize());
      }
      AppMethodBeat.o(91550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csv localcsv = (csv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91550);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsv.KEN = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsv.MxT = ((csx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsv.MxU = ((csw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsv.MxV = ((csw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      AppMethodBeat.o(91550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csv
 * JD-Core Version:    0.7.0.1
 */