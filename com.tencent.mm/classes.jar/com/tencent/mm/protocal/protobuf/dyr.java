package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyr
  extends com.tencent.mm.bw.a
{
  public String KNW;
  public dpq MYf;
  public ehf Mwy;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91693);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mwy != null)
      {
        paramVarArgs.ni(1, this.Mwy.computeSize());
        this.Mwy.writeFields(paramVarArgs);
      }
      if (this.MYf != null)
      {
        paramVarArgs.ni(2, this.MYf.computeSize());
        this.MYf.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.type);
      if (this.KNW != null) {
        paramVarArgs.e(4, this.KNW);
      }
      AppMethodBeat.o(91693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mwy == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = g.a.a.a.nh(1, this.Mwy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MYf != null) {
        i = paramInt + g.a.a.a.nh(2, this.MYf.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.type);
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KNW);
      }
      AppMethodBeat.o(91693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dyr localdyr = (dyr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91693);
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
            localdyr.Mwy = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyr.MYf = ((dpq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 3: 
          localdyr.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91693);
          return 0;
        }
        localdyr.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91693);
        return 0;
      }
      AppMethodBeat.o(91693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyr
 * JD-Core Version:    0.7.0.1
 */