package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dmi
  extends dop
{
  public int MPQ;
  public esi MPR;
  public int MPS;
  public int oUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MPR == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oUu);
      paramVarArgs.aM(3, this.MPQ);
      if (this.MPR != null)
      {
        paramVarArgs.ni(4, this.MPR.computeSize());
        this.MPR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MPS);
      AppMethodBeat.o(32412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label657;
      }
    }
    label657:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUu) + g.a.a.b.b.a.bu(3, this.MPQ);
      paramInt = i;
      if (this.MPR != null) {
        paramInt = i + g.a.a.a.nh(4, this.MPR.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.MPS);
      AppMethodBeat.o(32412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MPR == null)
        {
          paramVarArgs = new b("Not all required fields were included: PieceData");
          AppMethodBeat.o(32412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dmi localdmi = (dmi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32412);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmi.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        case 2: 
          localdmi.oUu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32412);
          return 0;
        case 3: 
          localdmi.MPQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32412);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmi.MPR = ((esi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        }
        localdmi.MPS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32412);
        return 0;
      }
      AppMethodBeat.o(32412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmi
 * JD-Core Version:    0.7.0.1
 */