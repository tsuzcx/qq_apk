package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsh
  extends cvw
{
  public SKBuiltinBuffer_t FWl;
  public String HYB;
  public String HYC;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HYB != null) {
        paramVarArgs.d(2, this.HYB);
      }
      if (this.HYC != null) {
        paramVarArgs.d(3, this.HYC);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.FWl != null)
      {
        paramVarArgs.lJ(5, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(130921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HYB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HYB);
      }
      i = paramInt;
      if (this.HYC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HYC);
      }
      i += f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.FWl != null) {
        paramInt = i + f.a.a.a.lI(5, this.FWl.computeSize());
      }
      AppMethodBeat.o(130921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsh localdsh = (dsh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130921);
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
            localdsh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130921);
          return 0;
        case 2: 
          localdsh.HYB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 3: 
          localdsh.HYC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 4: 
          localdsh.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(130921);
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
          localdsh.FWl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      AppMethodBeat.o(130921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsh
 * JD-Core Version:    0.7.0.1
 */