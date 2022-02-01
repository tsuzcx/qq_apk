package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ni
  extends com.tencent.mm.bw.a
{
  public ng KSJ;
  public LinkedList<nh> KSK;
  public String KSL;
  
  public ni()
  {
    AppMethodBeat.i(124400);
    this.KSK = new LinkedList();
    AppMethodBeat.o(124400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124401);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KSJ != null)
      {
        paramVarArgs.ni(1, this.KSJ.computeSize());
        this.KSJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KSK);
      if (this.KSL != null) {
        paramVarArgs.e(6, this.KSL);
      }
      AppMethodBeat.o(124401);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KSJ == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.nh(1, this.KSJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KSK);
      paramInt = i;
      if (this.KSL != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KSL);
      }
      AppMethodBeat.o(124401);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KSK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124401);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ni localni = (ni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(124401);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ng();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ng)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localni.KSJ = ((ng)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124401);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localni.KSK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124401);
          return 0;
        }
        localni.KSL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124401);
        return 0;
      }
      AppMethodBeat.o(124401);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ni
 * JD-Core Version:    0.7.0.1
 */