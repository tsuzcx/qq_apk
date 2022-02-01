package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cq
  extends cvw
{
  public String FNA;
  public int FNy;
  public String FNz;
  public String hFO;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hFO != null) {
        paramVarArgs.d(2, this.hFO);
      }
      paramVarArgs.aS(3, this.nJA);
      paramVarArgs.aS(4, this.FNy);
      if (this.FNz != null) {
        paramVarArgs.d(5, this.FNz);
      }
      if (this.FNA != null) {
        paramVarArgs.d(6, this.FNA);
      }
      AppMethodBeat.o(127430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hFO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hFO);
      }
      i = i + f.a.a.b.b.a.bz(3, this.nJA) + f.a.a.b.b.a.bz(4, this.FNy);
      paramInt = i;
      if (this.FNz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FNz);
      }
      i = paramInt;
      if (this.FNA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FNA);
      }
      AppMethodBeat.o(127430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cq localcq = (cq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127430);
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
            localcq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127430);
          return 0;
        case 2: 
          localcq.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127430);
          return 0;
        case 3: 
          localcq.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127430);
          return 0;
        case 4: 
          localcq.FNy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127430);
          return 0;
        case 5: 
          localcq.FNz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127430);
          return 0;
        }
        localcq.FNA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127430);
        return 0;
      }
      AppMethodBeat.o(127430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cq
 * JD-Core Version:    0.7.0.1
 */