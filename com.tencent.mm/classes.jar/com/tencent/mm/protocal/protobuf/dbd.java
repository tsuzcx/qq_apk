package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dbd
  extends dpc
{
  public int MGd;
  public String MGe;
  public SKBuiltinBuffer_t MhT;
  public int MhU;
  public String MhV;
  public int MhW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91611);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MhT != null)
      {
        paramVarArgs.ni(2, this.MhT.computeSize());
        this.MhT.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MhU);
      if (this.MhV != null) {
        paramVarArgs.e(4, this.MhV);
      }
      paramVarArgs.aM(5, this.MhW);
      paramVarArgs.aM(6, this.MGd);
      if (this.MGe != null) {
        paramVarArgs.e(7, this.MGe);
      }
      AppMethodBeat.o(91611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MhT != null) {
        i = paramInt + g.a.a.a.nh(2, this.MhT.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.MhU);
      paramInt = i;
      if (this.MhV != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MhV);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MhW) + g.a.a.b.b.a.bu(6, this.MGd);
      paramInt = i;
      if (this.MGe != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MGe);
      }
      AppMethodBeat.o(91611);
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
          AppMethodBeat.o(91611);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbd localdbd = (dbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91611);
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
            localdbd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbd.MhT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 3: 
          localdbd.MhU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91611);
          return 0;
        case 4: 
          localdbd.MhV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91611);
          return 0;
        case 5: 
          localdbd.MhW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91611);
          return 0;
        case 6: 
          localdbd.MGd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91611);
          return 0;
        }
        localdbd.MGe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91611);
        return 0;
      }
      AppMethodBeat.o(91611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbd
 * JD-Core Version:    0.7.0.1
 */