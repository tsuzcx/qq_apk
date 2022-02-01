package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bla
  extends cvw
{
  public SKBuiltinBuffer_t FWl;
  public cxn GYs;
  public cxn GYt;
  public SKBuiltinBuffer_t GYu;
  public cxn GuF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155420);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.GYs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Pwd");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(2, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      if (this.GYs != null)
      {
        paramVarArgs.lJ(3, this.GYs.computeSize());
        this.GYs.writeFields(paramVarArgs);
      }
      if (this.GYt != null)
      {
        paramVarArgs.lJ(4, this.GYt.computeSize());
        this.GYt.writeFields(paramVarArgs);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(5, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      if (this.GYu != null)
      {
        paramVarArgs.lJ(6, this.GYu.computeSize());
        this.GYu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1178;
      }
    }
    label1178:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GuF != null) {
        paramInt = i + f.a.a.a.lI(2, this.GuF.computeSize());
      }
      i = paramInt;
      if (this.GYs != null) {
        i = paramInt + f.a.a.a.lI(3, this.GYs.computeSize());
      }
      paramInt = i;
      if (this.GYt != null) {
        paramInt = i + f.a.a.a.lI(4, this.GYt.computeSize());
      }
      i = paramInt;
      if (this.FWl != null) {
        i = paramInt + f.a.a.a.lI(5, this.FWl.computeSize());
      }
      paramInt = i;
      if (this.GYu != null) {
        paramInt = i + f.a.a.a.lI(6, this.GYu.computeSize());
      }
      AppMethodBeat.o(155420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        if (this.GYs == null)
        {
          paramVarArgs = new b("Not all required fields were included: Pwd");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bla localbla = (bla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155420);
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
            localbla.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbla.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbla.GYs = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbla.GYt = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbla.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
          localbla.GYu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      AppMethodBeat.o(155420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */