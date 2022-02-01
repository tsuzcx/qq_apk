package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class alo
  extends dpc
{
  public int Lut;
  public int dDN;
  public String qwn;
  public String rCq;
  public String yQE;
  public String yRZ;
  public String ySa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.yQE != null) {
        paramVarArgs.e(4, this.yQE);
      }
      if (this.rCq != null) {
        paramVarArgs.e(5, this.rCq);
      }
      paramVarArgs.aM(6, this.Lut);
      if (this.ySa != null) {
        paramVarArgs.e(7, this.ySa);
      }
      if (this.yRZ != null) {
        paramVarArgs.e(8, this.yRZ);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yQE);
      }
      paramInt = i;
      if (this.rCq != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.rCq);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Lut);
      paramInt = i;
      if (this.ySa != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.ySa);
      }
      i = paramInt;
      if (this.yRZ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.yRZ);
      }
      AppMethodBeat.o(91455);
      return i;
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
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alo localalo = (alo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localalo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localalo.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localalo.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localalo.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localalo.rCq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localalo.Lut = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localalo.ySa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localalo.yRZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alo
 * JD-Core Version:    0.7.0.1
 */