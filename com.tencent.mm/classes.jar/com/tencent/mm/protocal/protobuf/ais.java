package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ais
  extends dpc
{
  public String Bri;
  public dyh KLj;
  public ccb KQj;
  public qy KQk;
  public ctb KQl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155403);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155403);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Bri != null) {
        paramVarArgs.e(2, this.Bri);
      }
      if (this.KQk != null)
      {
        paramVarArgs.ni(3, this.KQk.computeSize());
        this.KQk.writeFields(paramVarArgs);
      }
      if (this.KQj != null)
      {
        paramVarArgs.ni(4, this.KQj.computeSize());
        this.KQj.writeFields(paramVarArgs);
      }
      if (this.KLj != null)
      {
        paramVarArgs.ni(5, this.KLj.computeSize());
        this.KLj.writeFields(paramVarArgs);
      }
      if (this.KQl != null)
      {
        paramVarArgs.ni(6, this.KQl.computeSize());
        this.KQl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Bri != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Bri);
      }
      i = paramInt;
      if (this.KQk != null) {
        i = paramInt + g.a.a.a.nh(3, this.KQk.computeSize());
      }
      paramInt = i;
      if (this.KQj != null) {
        paramInt = i + g.a.a.a.nh(4, this.KQj.computeSize());
      }
      i = paramInt;
      if (this.KLj != null) {
        i = paramInt + g.a.a.a.nh(5, this.KLj.computeSize());
      }
      paramInt = i;
      if (this.KQl != null) {
        paramInt = i + g.a.a.a.nh(6, this.KQl.computeSize());
      }
      AppMethodBeat.o(155403);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155403);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ais localais = (ais)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155403);
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
            localais.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 2: 
          localais.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155403);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localais.KQk = ((qy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localais.KQj = ((ccb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localais.KLj = ((dyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localais.KQl = ((ctb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      AppMethodBeat.o(155403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ais
 * JD-Core Version:    0.7.0.1
 */