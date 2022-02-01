package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djy
  extends cvw
{
  public String GvK;
  public long HNy;
  public String nIJ;
  public int qld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.qld);
      if (this.GvK != null) {
        paramVarArgs.d(4, this.GvK);
      }
      paramVarArgs.aZ(5, this.HNy);
      AppMethodBeat.o(118444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(3, this.qld);
      paramInt = i;
      if (this.GvK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GvK);
      }
      i = f.a.a.b.b.a.p(5, this.HNy);
      AppMethodBeat.o(118444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djy localdjy = (djy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118444);
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
            localdjy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118444);
          return 0;
        case 2: 
          localdjy.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118444);
          return 0;
        case 3: 
          localdjy.qld = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118444);
          return 0;
        case 4: 
          localdjy.GvK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118444);
          return 0;
        }
        localdjy.HNy = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(118444);
        return 0;
      }
      AppMethodBeat.o(118444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djy
 * JD-Core Version:    0.7.0.1
 */