package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cdj
  extends dop
{
  public LinkedList<con> KGQ;
  public dqi KGR;
  public cbr KGU;
  public int Mjh;
  public String Mji;
  public int gsq;
  
  public cdj()
  {
    AppMethodBeat.i(101819);
    this.KGQ = new LinkedList();
    AppMethodBeat.o(101819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101820);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101820);
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
      paramVarArgs.aM(5, this.Mjh);
      if (this.Mji != null) {
        paramVarArgs.e(6, this.Mji);
      }
      if (this.KGU != null)
      {
        paramVarArgs.ni(7, this.KGU.computeSize());
        this.KGU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101820);
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
      i = paramInt + g.a.a.b.b.a.bu(5, this.Mjh);
      paramInt = i;
      if (this.Mji != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mji);
      }
      i = paramInt;
      if (this.KGU != null) {
        i = paramInt + g.a.a.a.nh(7, this.KGU.computeSize());
      }
      AppMethodBeat.o(101820);
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
          AppMethodBeat.o(101820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdj localcdj = (cdj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101820);
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
            localcdj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 2: 
          localcdj.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101820);
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
            localcdj.KGQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
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
            localcdj.KGR = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 5: 
          localcdj.Mjh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101820);
          return 0;
        case 6: 
          localcdj.Mji = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101820);
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
          localcdj.KGU = ((cbr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101820);
        return 0;
      }
      AppMethodBeat.o(101820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdj
 * JD-Core Version:    0.7.0.1
 */