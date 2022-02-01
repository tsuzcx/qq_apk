package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgu
  extends dop
{
  public String LQD;
  public int LQE;
  public LinkedList<bgw> LQF;
  public int SetType;
  
  public bgu()
  {
    AppMethodBeat.i(256596);
    this.LQF = new LinkedList();
    AppMethodBeat.o(256596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74654);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.SetType);
      if (this.LQD != null) {
        paramVarArgs.e(3, this.LQD);
      }
      paramVarArgs.aM(4, this.LQE);
      paramVarArgs.e(5, 8, this.LQF);
      AppMethodBeat.o(74654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.SetType);
      paramInt = i;
      if (this.LQD != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LQD);
      }
      i = g.a.a.b.b.a.bu(4, this.LQE);
      int j = g.a.a.a.c(5, 8, this.LQF);
      AppMethodBeat.o(74654);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LQF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgu localbgu = (bgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74654);
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
            localbgu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74654);
          return 0;
        case 2: 
          localbgu.SetType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74654);
          return 0;
        case 3: 
          localbgu.LQD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74654);
          return 0;
        case 4: 
          localbgu.LQE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74654);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbgu.LQF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      AppMethodBeat.o(74654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgu
 * JD-Core Version:    0.7.0.1
 */