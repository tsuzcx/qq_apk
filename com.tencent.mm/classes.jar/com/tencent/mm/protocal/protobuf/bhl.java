package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhl
  extends cwj
{
  public SKBuiltinBuffer_t GVE;
  public String GVF;
  public String GVG;
  public String GVH;
  public int Gan;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152593);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.GVE == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GVE != null)
      {
        paramVarArgs.lJ(2, this.GVE.computeSize());
        this.GVE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Gan);
      if (this.GVF != null) {
        paramVarArgs.d(6, this.GVF);
      }
      if (this.GVG != null) {
        paramVarArgs.d(7, this.GVG);
      }
      if (this.GVH != null) {
        paramVarArgs.d(8, this.GVH);
      }
      AppMethodBeat.o(152593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GVE != null) {
        i = paramInt + f.a.a.a.lI(2, this.GVE.computeSize());
      }
      i += f.a.a.b.b.a.bz(5, this.Gan);
      paramInt = i;
      if (this.GVF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GVF);
      }
      i = paramInt;
      if (this.GVG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GVG);
      }
      paramInt = i;
      if (this.GVH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GVH);
      }
      AppMethodBeat.o(152593);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.GVE == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152593);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhl localbhl = (bhl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(152593);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhl.GVE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localbhl.Gan = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localbhl.GVF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localbhl.GVG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localbhl.GVH = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhl
 * JD-Core Version:    0.7.0.1
 */