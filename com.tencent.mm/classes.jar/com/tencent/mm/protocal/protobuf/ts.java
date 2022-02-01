package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ts
  extends cvw
{
  public int GjP;
  public SKBuiltinBuffer_t GjQ;
  public bud GjR;
  public int GjS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93330);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(93330);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GjP);
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(3, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      if (this.GjR != null)
      {
        paramVarArgs.lJ(4, this.GjR.computeSize());
        this.GjR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GjS);
      AppMethodBeat.o(93330);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GjP);
      paramInt = i;
      if (this.GjQ != null) {
        paramInt = i + f.a.a.a.lI(3, this.GjQ.computeSize());
      }
      i = paramInt;
      if (this.GjR != null) {
        i = paramInt + f.a.a.a.lI(4, this.GjR.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(5, this.GjS);
      AppMethodBeat.o(93330);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GjQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(93330);
          throw paramVarArgs;
        }
        AppMethodBeat.o(93330);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ts localts = (ts)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93330);
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
            localts.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        case 2: 
          localts.GjP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(93330);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localts.GjQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bud();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localts.GjR = ((bud)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        }
        localts.GjS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(93330);
        return 0;
      }
      AppMethodBeat.o(93330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ts
 * JD-Core Version:    0.7.0.1
 */