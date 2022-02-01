package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cck
  extends cvp
{
  public int FMr;
  public int Frh;
  public SKBuiltinBuffer_t GWb;
  public SKBuiltinBuffer_t GWc;
  public int GWd;
  public int GWe;
  public LinkedList<zu> GWf;
  
  public cck()
  {
    AppMethodBeat.i(133182);
    this.GWf = new LinkedList();
    AppMethodBeat.o(133182);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133183);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.GWb == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.GWc == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GWb != null)
      {
        paramVarArgs.lC(2, this.GWb.computeSize());
        this.GWb.writeFields(paramVarArgs);
      }
      if (this.GWc != null)
      {
        paramVarArgs.lC(3, this.GWc.computeSize());
        this.GWc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FMr);
      paramVarArgs.aS(5, this.GWd);
      paramVarArgs.aS(6, this.GWe);
      paramVarArgs.e(7, 8, this.GWf);
      paramVarArgs.aS(8, this.Frh);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GWb != null) {
        paramInt = i + f.a.a.a.lB(2, this.GWb.computeSize());
      }
      i = paramInt;
      if (this.GWc != null) {
        i = paramInt + f.a.a.a.lB(3, this.GWc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FMr);
      int j = f.a.a.b.b.a.bz(5, this.GWd);
      int k = f.a.a.b.b.a.bz(6, this.GWe);
      int m = f.a.a.a.c(7, 8, this.GWf);
      int n = f.a.a.b.b.a.bz(8, this.Frh);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GWf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.GWb == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.GWc == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133183);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cck localcck = (cck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
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
            localcck.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
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
            localcck.GWb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcck.GWc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localcck.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localcck.GWd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localcck.GWe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcck.GWf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localcck.Frh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cck
 * JD-Core Version:    0.7.0.1
 */