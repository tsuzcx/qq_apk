package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aek
  extends dpc
{
  public LinkedList<cvu> KHx;
  public String LpH;
  public String LpI;
  public String jHa;
  
  public aek()
  {
    AppMethodBeat.i(152524);
    this.KHx = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jHa != null) {
        paramVarArgs.e(2, this.jHa);
      }
      paramVarArgs.e(3, 8, this.KHx);
      if (this.LpH != null) {
        paramVarArgs.e(4, this.LpH);
      }
      if (this.LpI != null) {
        paramVarArgs.e(5, this.LpI);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jHa != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.jHa);
      }
      i += g.a.a.a.c(3, 8, this.KHx);
      paramInt = i;
      if (this.LpH != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LpH);
      }
      i = paramInt;
      if (this.LpI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LpI);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KHx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aek localaek = (aek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
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
            localaek.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localaek.jHa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaek.KHx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localaek.LpH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localaek.LpI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aek
 * JD-Core Version:    0.7.0.1
 */