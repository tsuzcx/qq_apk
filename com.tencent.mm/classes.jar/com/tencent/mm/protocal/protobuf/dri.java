package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dri
  extends dpc
{
  public String KJw;
  public String MTT;
  public String MTV;
  public String MTW;
  public com.tencent.mm.bw.b MTX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82472);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KJw != null) {
        paramVarArgs.e(3, this.KJw);
      }
      if (this.MTT != null) {
        paramVarArgs.e(4, this.MTT);
      }
      if (this.MTV != null) {
        paramVarArgs.e(5, this.MTV);
      }
      if (this.MTW != null) {
        paramVarArgs.e(6, this.MTW);
      }
      if (this.MTX != null) {
        paramVarArgs.c(7, this.MTX);
      }
      AppMethodBeat.o(82472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KJw != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KJw);
      }
      i = paramInt;
      if (this.MTT != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MTT);
      }
      paramInt = i;
      if (this.MTV != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MTV);
      }
      i = paramInt;
      if (this.MTW != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MTW);
      }
      paramInt = i;
      if (this.MTX != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.MTX);
      }
      AppMethodBeat.o(82472);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82472);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dri localdri = (dri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(82472);
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
            localdri.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82472);
          return 0;
        case 3: 
          localdri.KJw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 4: 
          localdri.MTT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 5: 
          localdri.MTV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 6: 
          localdri.MTW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82472);
          return 0;
        }
        localdri.MTX = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(82472);
        return 0;
      }
      AppMethodBeat.o(82472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dri
 * JD-Core Version:    0.7.0.1
 */