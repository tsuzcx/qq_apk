package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsz
  extends cwj
{
  public int GPU;
  public int GPV;
  public int GPW;
  public int GPX;
  public String GPY;
  public int GPZ;
  public String HnR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101834);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HnR != null) {
        paramVarArgs.d(2, this.HnR);
      }
      if (this.GPY != null) {
        paramVarArgs.d(3, this.GPY);
      }
      paramVarArgs.aS(4, this.GPX);
      paramVarArgs.aS(5, this.GPU);
      paramVarArgs.aS(6, this.GPV);
      paramVarArgs.aS(7, this.GPW);
      paramVarArgs.aS(8, this.GPZ);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HnR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HnR);
      }
      i = paramInt;
      if (this.GPY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GPY);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GPX);
      int j = f.a.a.b.b.a.bz(5, this.GPU);
      int k = f.a.a.b.b.a.bz(6, this.GPV);
      int m = f.a.a.b.b.a.bz(7, this.GPW);
      int n = f.a.a.b.b.a.bz(8, this.GPZ);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101834);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101834);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsz localdsz = (dsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localdsz.HnR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localdsz.GPY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localdsz.GPX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localdsz.GPU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localdsz.GPV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localdsz.GPW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101834);
          return 0;
        }
        localdsz.GPZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsz
 * JD-Core Version:    0.7.0.1
 */