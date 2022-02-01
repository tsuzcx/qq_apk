package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dal
  extends cvw
{
  public bob FVS;
  public bof HJR;
  public SKBuiltinBuffer_t Hbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.HJR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.Hbk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FVS != null)
      {
        paramVarArgs.lJ(2, this.FVS.computeSize());
        this.FVS.writeFields(paramVarArgs);
      }
      if (this.HJR != null)
      {
        paramVarArgs.lJ(3, this.HJR.computeSize());
        this.HJR.writeFields(paramVarArgs);
      }
      if (this.Hbk != null)
      {
        paramVarArgs.lJ(4, this.Hbk.computeSize());
        this.Hbk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label932;
      }
    }
    label932:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVS != null) {
        paramInt = i + f.a.a.a.lI(2, this.FVS.computeSize());
      }
      i = paramInt;
      if (this.HJR != null) {
        i = paramInt + f.a.a.a.lI(3, this.HJR.computeSize());
      }
      paramInt = i;
      if (this.Hbk != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hbk.computeSize());
      }
      AppMethodBeat.o(32428);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FVS == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        if (this.HJR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        if (this.Hbk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dal localdal = (dal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32428);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdal.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdal.FVS = ((bob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bof();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bof)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdal.HJR = ((bof)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdal.Hbk = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32428);
        return 0;
      }
      AppMethodBeat.o(32428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dal
 * JD-Core Version:    0.7.0.1
 */