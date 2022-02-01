package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ceg
  extends dpc
{
  public LinkedList<epn> MjP;
  public LinkedList<String> MjQ;
  public String MjR;
  public LinkedList<cel> MjS;
  public cdz Mjz;
  
  public ceg()
  {
    AppMethodBeat.i(82440);
    this.MjP = new LinkedList();
    this.MjQ = new LinkedList();
    this.MjS = new LinkedList();
    AppMethodBeat.o(82440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mjz != null)
      {
        paramVarArgs.ni(2, this.Mjz.computeSize());
        this.Mjz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.MjP);
      paramVarArgs.e(4, 1, this.MjQ);
      if (this.MjR != null) {
        paramVarArgs.e(5, this.MjR);
      }
      paramVarArgs.e(6, 8, this.MjS);
      AppMethodBeat.o(82441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mjz != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mjz.computeSize());
      }
      i = i + g.a.a.a.c(3, 8, this.MjP) + g.a.a.a.c(4, 1, this.MjQ);
      paramInt = i;
      if (this.MjR != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MjR);
      }
      i = g.a.a.a.c(6, 8, this.MjS);
      AppMethodBeat.o(82441);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MjP.clear();
        this.MjQ.clear();
        this.MjS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ceg localceg = (ceg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82441);
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
            localceg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localceg.Mjz = ((cdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new epn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((epn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localceg.MjP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 4: 
          localceg.MjQ.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(82441);
          return 0;
        case 5: 
          localceg.MjR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82441);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cel();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cel)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localceg.MjS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      AppMethodBeat.o(82441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceg
 * JD-Core Version:    0.7.0.1
 */