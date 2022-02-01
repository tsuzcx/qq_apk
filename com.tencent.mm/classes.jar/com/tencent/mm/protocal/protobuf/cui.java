package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cui
  extends esc
{
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74660);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(74660);
        throw paramVarArgs;
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(74660);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkN);
      paramVarArgs.bS(3, this.NkO);
      paramVarArgs.bS(4, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(5, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(74660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkN) + i.a.a.b.b.a.cJ(3, this.NkO) + i.a.a.b.b.a.cJ(4, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(5, this.NkQ.computeSize());
      }
      AppMethodBeat.o(74660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(74660);
          throw paramVarArgs;
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(74660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(74660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cui localcui = (cui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74660);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcui.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74660);
          return 0;
        case 2: 
          localcui.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(74660);
          return 0;
        case 3: 
          localcui.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(74660);
          return 0;
        case 4: 
          localcui.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(74660);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localcui.NkQ = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(74660);
        return 0;
      }
      AppMethodBeat.o(74660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cui
 * JD-Core Version:    0.7.0.1
 */