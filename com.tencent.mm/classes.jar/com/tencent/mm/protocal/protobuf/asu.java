package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asu
  extends dpc
{
  public LinkedList<avn> LDL;
  public LinkedList<avn> LDM;
  public long LDN;
  public int LDO;
  public int LDP;
  public avn LDQ;
  public long hyH;
  
  public asu()
  {
    AppMethodBeat.i(209425);
    this.LDL = new LinkedList();
    this.LDM = new LinkedList();
    AppMethodBeat.o(209425);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LDL);
      paramVarArgs.bb(3, this.hyH);
      paramVarArgs.e(4, 8, this.LDM);
      paramVarArgs.bb(5, this.LDN);
      paramVarArgs.aM(6, this.LDO);
      paramVarArgs.aM(7, this.LDP);
      if (this.LDQ != null)
      {
        paramVarArgs.ni(8, this.LDQ.computeSize());
        this.LDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label918;
      }
    }
    label918:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LDL) + g.a.a.b.b.a.r(3, this.hyH) + g.a.a.a.c(4, 8, this.LDM) + g.a.a.b.b.a.r(5, this.LDN) + g.a.a.b.b.a.bu(6, this.LDO) + g.a.a.b.b.a.bu(7, this.LDP);
      paramInt = i;
      if (this.LDQ != null) {
        paramInt = i + g.a.a.a.nh(8, this.LDQ.computeSize());
      }
      AppMethodBeat.o(209426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDL.clear();
        this.LDM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asu localasu = (asu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209426);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209426);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasu.LDL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209426);
          return 0;
        case 3: 
          localasu.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209426);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasu.LDM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209426);
          return 0;
        case 5: 
          localasu.LDN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209426);
          return 0;
        case 6: 
          localasu.LDO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209426);
          return 0;
        case 7: 
          localasu.LDP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209426);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localasu.LDQ = ((avn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209426);
        return 0;
      }
      AppMethodBeat.o(209426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asu
 * JD-Core Version:    0.7.0.1
 */