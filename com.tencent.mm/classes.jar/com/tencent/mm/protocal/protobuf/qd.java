package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class qd
  extends dpc
{
  public dar KWW;
  public fo KWX;
  public qb KWY;
  public dez KWZ;
  public eqo KXa;
  public dt KXb;
  public dkw KXc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124461);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124461);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KWW != null)
      {
        paramVarArgs.ni(2, this.KWW.computeSize());
        this.KWW.writeFields(paramVarArgs);
      }
      if (this.KWX != null)
      {
        paramVarArgs.ni(3, this.KWX.computeSize());
        this.KWX.writeFields(paramVarArgs);
      }
      if (this.KWY != null)
      {
        paramVarArgs.ni(4, this.KWY.computeSize());
        this.KWY.writeFields(paramVarArgs);
      }
      if (this.KWZ != null)
      {
        paramVarArgs.ni(5, this.KWZ.computeSize());
        this.KWZ.writeFields(paramVarArgs);
      }
      if (this.KXa != null)
      {
        paramVarArgs.ni(6, this.KXa.computeSize());
        this.KXa.writeFields(paramVarArgs);
      }
      if (this.KXb != null)
      {
        paramVarArgs.ni(7, this.KXb.computeSize());
        this.KXb.writeFields(paramVarArgs);
      }
      if (this.KXc != null)
      {
        paramVarArgs.ni(8, this.KXc.computeSize());
        this.KXc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1442;
      }
    }
    label1442:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KWW != null) {
        paramInt = i + g.a.a.a.nh(2, this.KWW.computeSize());
      }
      i = paramInt;
      if (this.KWX != null) {
        i = paramInt + g.a.a.a.nh(3, this.KWX.computeSize());
      }
      paramInt = i;
      if (this.KWY != null) {
        paramInt = i + g.a.a.a.nh(4, this.KWY.computeSize());
      }
      i = paramInt;
      if (this.KWZ != null) {
        i = paramInt + g.a.a.a.nh(5, this.KWZ.computeSize());
      }
      paramInt = i;
      if (this.KXa != null) {
        paramInt = i + g.a.a.a.nh(6, this.KXa.computeSize());
      }
      i = paramInt;
      if (this.KXb != null) {
        i = paramInt + g.a.a.a.nh(7, this.KXb.computeSize());
      }
      paramInt = i;
      if (this.KXc != null) {
        paramInt = i + g.a.a.a.nh(8, this.KXc.computeSize());
      }
      AppMethodBeat.o(124461);
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
          AppMethodBeat.o(124461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        qd localqd = (qd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124461);
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
            localqd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dar();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dar)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqd.KWW = ((dar)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqd.KWX = ((fo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqd.KWY = ((qb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dez();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dez)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqd.KWZ = ((dez)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqd.KXa = ((eqo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqd.KXb = ((dt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localqd.KXc = ((dkw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      AppMethodBeat.o(124461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qd
 * JD-Core Version:    0.7.0.1
 */