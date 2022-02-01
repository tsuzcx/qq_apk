package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cs
  extends dop
{
  public LinkedList<con> KGQ;
  public dqi KGR;
  public int KGS;
  public String KGT;
  public cbr KGU;
  public int gsq;
  
  public cs()
  {
    AppMethodBeat.i(101790);
    this.KGQ = new LinkedList();
    AppMethodBeat.o(101790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101791);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.gsq);
      paramVarArgs.e(3, 8, this.KGQ);
      if (this.KGR != null)
      {
        paramVarArgs.ni(4, this.KGR.computeSize());
        this.KGR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.KGS);
      if (this.KGT != null) {
        paramVarArgs.e(6, this.KGT);
      }
      if (this.KGU != null)
      {
        paramVarArgs.ni(7, this.KGU.computeSize());
        this.KGU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.gsq) + g.a.a.a.c(3, 8, this.KGQ);
      paramInt = i;
      if (this.KGR != null) {
        paramInt = i + g.a.a.a.nh(4, this.KGR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KGS);
      paramInt = i;
      if (this.KGT != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KGT);
      }
      i = paramInt;
      if (this.KGU != null) {
        i = paramInt + g.a.a.a.nh(7, this.KGU.computeSize());
      }
      AppMethodBeat.o(101791);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KGR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101791);
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
            localcs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 2: 
          localcs.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101791);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new con();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((con)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcs.KGQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcs.KGR = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 5: 
          localcs.KGS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101791);
          return 0;
        case 6: 
          localcs.KGT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101791);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcs.KGU = ((cbr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      AppMethodBeat.o(101791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cs
 * JD-Core Version:    0.7.0.1
 */