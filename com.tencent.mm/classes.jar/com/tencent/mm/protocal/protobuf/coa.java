package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coa
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public String HzT;
  public int HzU;
  public int HzV;
  public long Hzw;
  public long Hzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32390);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HzT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(32390);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzT != null) {
        paramVarArgs.d(2, this.HzT);
      }
      paramVarArgs.aS(3, this.Gxq);
      paramVarArgs.aZ(4, this.Gxr);
      paramVarArgs.aZ(5, this.Hzw);
      paramVarArgs.aS(6, this.HzU);
      paramVarArgs.aZ(7, this.Hzz);
      paramVarArgs.aS(8, this.HzV);
      AppMethodBeat.o(32390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HzT);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Gxq);
      int j = f.a.a.b.b.a.p(4, this.Gxr);
      int k = f.a.a.b.b.a.p(5, this.Hzw);
      int m = f.a.a.b.b.a.bz(6, this.HzU);
      int n = f.a.a.b.b.a.p(7, this.Hzz);
      int i1 = f.a.a.b.b.a.bz(8, this.HzV);
      AppMethodBeat.o(32390);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HzT == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUsername");
          AppMethodBeat.o(32390);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32390);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coa localcoa = (coa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32390);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32390);
          return 0;
        case 2: 
          localcoa.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32390);
          return 0;
        case 3: 
          localcoa.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32390);
          return 0;
        case 4: 
          localcoa.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32390);
          return 0;
        case 5: 
          localcoa.Hzw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32390);
          return 0;
        case 6: 
          localcoa.HzU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32390);
          return 0;
        case 7: 
          localcoa.Hzz = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32390);
          return 0;
        }
        localcoa.HzV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32390);
        return 0;
      }
      AppMethodBeat.o(32390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coa
 * JD-Core Version:    0.7.0.1
 */