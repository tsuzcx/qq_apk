package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhi
  extends cvw
{
  public SKBuiltinBuffer_t GVA;
  public SKBuiltinBuffer_t GVx;
  public int GVy;
  public int GVz;
  public int iko;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GVx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(63273);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.iko);
      if (this.GVx != null)
      {
        paramVarArgs.lJ(3, this.GVx.computeSize());
        this.GVx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GVy);
      paramVarArgs.aS(5, this.GVz);
      if (this.GVA != null)
      {
        paramVarArgs.lJ(6, this.GVA.computeSize());
        this.GVA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.iko);
      paramInt = i;
      if (this.GVx != null) {
        paramInt = i + f.a.a.a.lI(3, this.GVx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GVy) + f.a.a.b.b.a.bz(5, this.GVz);
      paramInt = i;
      if (this.GVA != null) {
        paramInt = i + f.a.a.a.lI(6, this.GVA.computeSize());
      }
      AppMethodBeat.o(63273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GVx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(63273);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhi localbhi = (bhi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63273);
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
            localbhi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 2: 
          localbhi.iko = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(63273);
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
            localbhi.GVx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 4: 
          localbhi.GVy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(63273);
          return 0;
        case 5: 
          localbhi.GVz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(63273);
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
          localbhi.GVA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      AppMethodBeat.o(63273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhi
 * JD-Core Version:    0.7.0.1
 */