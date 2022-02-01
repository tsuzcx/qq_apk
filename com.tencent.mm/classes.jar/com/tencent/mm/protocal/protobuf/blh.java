package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blh
  extends cvw
{
  public SKBuiltinBuffer_t FWl;
  public int GYy;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32293);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(32293);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.GYy);
      if (this.FWl != null)
      {
        paramVarArgs.lJ(4, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(3, this.GYy);
      paramInt = i;
      if (this.FWl != null) {
        paramInt = i + f.a.a.a.lI(4, this.FWl.computeSize());
      }
      AppMethodBeat.o(32293);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FWl == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(32293);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32293);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blh localblh = (blh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32293);
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
            localblh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32293);
          return 0;
        case 2: 
          localblh.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32293);
          return 0;
        case 3: 
          localblh.GYy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32293);
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
          localblh.FWl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32293);
        return 0;
      }
      AppMethodBeat.o(32293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blh
 * JD-Core Version:    0.7.0.1
 */