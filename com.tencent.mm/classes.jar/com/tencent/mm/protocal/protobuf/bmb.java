package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmb
  extends cvw
{
  public SKBuiltinBuffer_t FRA;
  public SKBuiltinBuffer_t GNw;
  public String GZd;
  public int Scene;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32315);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRA == null)
      {
        paramVarArgs = new b("Not all required fields were included: A2Key");
        AppMethodBeat.o(32315);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FRA != null)
      {
        paramVarArgs.lJ(2, this.FRA.computeSize());
        this.FRA.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.GZd != null) {
        paramVarArgs.d(5, this.GZd);
      }
      if (this.GNw != null)
      {
        paramVarArgs.lJ(6, this.GNw.computeSize());
        this.GNw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRA != null) {
        paramInt = i + f.a.a.a.lI(2, this.FRA.computeSize());
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.GZd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GZd);
      }
      i = paramInt;
      if (this.GNw != null) {
        i = paramInt + f.a.a.a.lI(6, this.GNw.computeSize());
      }
      AppMethodBeat.o(32315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FRA == null)
        {
          paramVarArgs = new b("Not all required fields were included: A2Key");
          AppMethodBeat.o(32315);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmb localbmb = (bmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32315);
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
            localbmb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmb.FRA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
          return 0;
        case 3: 
          localbmb.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32315);
          return 0;
        case 4: 
          localbmb.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32315);
          return 0;
        case 5: 
          localbmb.GZd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32315);
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
          localbmb.GNw = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      AppMethodBeat.o(32315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmb
 * JD-Core Version:    0.7.0.1
 */