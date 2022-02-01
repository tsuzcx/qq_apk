package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgv
  extends cvp
{
  public int FHR;
  public SKBuiltinBuffer_t GCe;
  public String GCf;
  public String GCg;
  public String GCh;
  
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
      if (this.GCe == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GCe != null)
      {
        paramVarArgs.lC(2, this.GCe.computeSize());
        this.GCe.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.FHR);
      if (this.GCf != null) {
        paramVarArgs.d(6, this.GCf);
      }
      if (this.GCg != null) {
        paramVarArgs.d(7, this.GCg);
      }
      if (this.GCh != null) {
        paramVarArgs.d(8, this.GCh);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GCe != null) {
        i = paramInt + f.a.a.a.lB(2, this.GCe.computeSize());
      }
      i += f.a.a.b.b.a.bz(5, this.FHR);
      paramInt = i;
      if (this.GCf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GCf);
      }
      i = paramInt;
      if (this.GCg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GCg);
      }
      paramInt = i;
      if (this.GCh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GCh);
      }
      AppMethodBeat.o(152593);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.GCe == null)
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
        bgv localbgv = (bgv)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgv.GCe = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localbgv.FHR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localbgv.GCf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localbgv.GCg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localbgv.GCh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgv
 * JD-Core Version:    0.7.0.1
 */