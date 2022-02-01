package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcs
  extends dop
{
  public apc LAv;
  public LinkedList<ecq> LEw;
  public long LLM;
  public cnk LLN;
  public String finderUsername;
  public aov uli;
  
  public bcs()
  {
    AppMethodBeat.i(169053);
    this.LEw = new LinkedList();
    AppMethodBeat.o(169053);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169054);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LEw);
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(4, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.LAv != null)
      {
        paramVarArgs.ni(5, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(7, this.LLM);
      if (this.LLN != null)
      {
        paramVarArgs.ni(8, this.LLN.computeSize());
        this.LLN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LEw);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(4, this.uli.computeSize());
      }
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(5, this.LAv.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(7, this.LLM);
      paramInt = i;
      if (this.LLN != null) {
        paramInt = i + g.a.a.a.nh(8, this.LLN.computeSize());
      }
      AppMethodBeat.o(169054);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LEw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcs localbcs = (bcs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(169054);
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
            localbcs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcs.LEw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 3: 
          localbcs.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169054);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcs.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcs.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 7: 
          localbcs.LLM = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169054);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcs.LLN = ((cnk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      AppMethodBeat.o(169054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcs
 * JD-Core Version:    0.7.0.1
 */