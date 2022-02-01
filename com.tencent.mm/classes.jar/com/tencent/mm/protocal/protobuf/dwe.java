package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwe
  extends cvw
{
  public SKBuiltinBuffer_t FWl;
  public String GYw;
  public int HEI;
  public int HEK;
  public dyb Ibx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ibx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Piece");
        AppMethodBeat.o(32496);
        throw paramVarArgs;
      }
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(32496);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ibx != null)
      {
        paramVarArgs.lJ(2, this.Ibx.computeSize());
        this.Ibx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HEI);
      paramVarArgs.aS(4, this.HEK);
      if (this.GYw != null) {
        paramVarArgs.d(5, this.GYw);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(6, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ibx != null) {
        i = paramInt + f.a.a.a.lI(2, this.Ibx.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.HEI) + f.a.a.b.b.a.bz(4, this.HEK);
      paramInt = i;
      if (this.GYw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GYw);
      }
      i = paramInt;
      if (this.FWl != null) {
        i = paramInt + f.a.a.a.lI(6, this.FWl.computeSize());
      }
      AppMethodBeat.o(32496);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Ibx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Piece");
          AppMethodBeat.o(32496);
          throw paramVarArgs;
        }
        if (this.FWl == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(32496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwe localdwe = (dwe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32496);
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
            localdwe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32496);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwe.Ibx = ((dyb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32496);
          return 0;
        case 3: 
          localdwe.HEI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32496);
          return 0;
        case 4: 
          localdwe.HEK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32496);
          return 0;
        case 5: 
          localdwe.GYw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32496);
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
          localdwe.FWl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32496);
        return 0;
      }
      AppMethodBeat.o(32496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwe
 * JD-Core Version:    0.7.0.1
 */