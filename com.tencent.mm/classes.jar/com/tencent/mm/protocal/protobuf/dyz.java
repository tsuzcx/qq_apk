package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyz
  extends cvp
{
  public int FMr;
  public SKBuiltinBuffer_t FRr;
  public int GeI;
  public long GeJ;
  public dxp HMt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.HMt == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GeI);
      if (this.FRr != null)
      {
        paramVarArgs.lC(4, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      if (this.HMt != null)
      {
        paramVarArgs.lC(5, this.HMt.computeSize());
        this.HMt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.FMr);
      paramVarArgs.aY(8, this.GeJ);
      AppMethodBeat.o(115926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.GeI);
      paramInt = i;
      if (this.FRr != null) {
        paramInt = i + f.a.a.a.lB(4, this.FRr.computeSize());
      }
      i = paramInt;
      if (this.HMt != null) {
        i = paramInt + f.a.a.a.lB(5, this.HMt.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.FMr);
      int j = f.a.a.b.b.a.p(8, this.GeJ);
      AppMethodBeat.o(115926);
      return i + paramInt + j;
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
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.FRr == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.HMt == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyz localdyz = (dyz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 6: 
        default: 
          AppMethodBeat.o(115926);
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
            localdyz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 3: 
          localdyz.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115926);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyz.FRr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyz.HMt = ((dxp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 7: 
          localdyz.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115926);
          return 0;
        }
        localdyz.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(115926);
        return 0;
      }
      AppMethodBeat.o(115926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyz
 * JD-Core Version:    0.7.0.1
 */