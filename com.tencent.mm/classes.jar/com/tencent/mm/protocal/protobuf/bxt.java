package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxt
  extends cqk
{
  public int DMc;
  public int EfS;
  public SKBuiltinBuffer_t Fms;
  public SKBuiltinBuffer_t Fmt;
  public int Fmu;
  public int Fmv;
  public LinkedList<xv> Fmw;
  
  public bxt()
  {
    AppMethodBeat.i(133182);
    this.Fmw = new LinkedList();
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
      if (this.Fms == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.Fmt == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fms != null)
      {
        paramVarArgs.ln(2, this.Fms.computeSize());
        this.Fms.writeFields(paramVarArgs);
      }
      if (this.Fmt != null)
      {
        paramVarArgs.ln(3, this.Fmt.computeSize());
        this.Fmt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EfS);
      paramVarArgs.aR(5, this.Fmu);
      paramVarArgs.aR(6, this.Fmv);
      paramVarArgs.e(7, 8, this.Fmw);
      paramVarArgs.aR(8, this.DMc);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fms != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fms.computeSize());
      }
      i = paramInt;
      if (this.Fmt != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fmt.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EfS);
      int j = f.a.a.b.b.a.bx(5, this.Fmu);
      int k = f.a.a.b.b.a.bx(6, this.Fmv);
      int m = f.a.a.a.c(7, 8, this.Fmw);
      int n = f.a.a.b.b.a.bx(8, this.DMc);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fmw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.Fms == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.Fmt == null)
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
        bxt localbxt = (bxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxt.Fms = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxt.Fmt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localbxt.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localbxt.Fmu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localbxt.Fmv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxt.Fmw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localbxt.DMc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxt
 * JD-Core Version:    0.7.0.1
 */