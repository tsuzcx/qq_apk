package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkd
  extends cvw
{
  public String HNx;
  public long HNy;
  public long HOJ;
  public int HOK;
  public String nIJ;
  public int qld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      paramVarArgs.aS(4, this.qld);
      paramVarArgs.aZ(5, this.HNy);
      paramVarArgs.aZ(6, this.HOJ);
      paramVarArgs.aS(7, this.HOK);
      AppMethodBeat.o(118449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.qld);
      int j = f.a.a.b.b.a.p(5, this.HNy);
      int k = f.a.a.b.b.a.p(6, this.HOJ);
      int m = f.a.a.b.b.a.bz(7, this.HOK);
      AppMethodBeat.o(118449);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkd localdkd = (dkd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118449);
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
            localdkd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118449);
          return 0;
        case 2: 
          localdkd.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 3: 
          localdkd.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 4: 
          localdkd.qld = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118449);
          return 0;
        case 5: 
          localdkd.HNy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118449);
          return 0;
        case 6: 
          localdkd.HOJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118449);
          return 0;
        }
        localdkd.HOK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118449);
        return 0;
      }
      AppMethodBeat.o(118449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkd
 * JD-Core Version:    0.7.0.1
 */