package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atu
  extends cvw
{
  public int GKH;
  public int GKI;
  public iy Gpj;
  public String Gpk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gpj != null)
      {
        paramVarArgs.lJ(2, this.Gpj.computeSize());
        this.Gpj.writeFields(paramVarArgs);
      }
      if (this.Gpk != null) {
        paramVarArgs.d(3, this.Gpk);
      }
      paramVarArgs.aS(4, this.GKH);
      paramVarArgs.aS(5, this.GKI);
      AppMethodBeat.o(91468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gpj != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gpj.computeSize());
      }
      i = paramInt;
      if (this.Gpk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gpk);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GKH);
      int j = f.a.a.b.b.a.bz(5, this.GKI);
      AppMethodBeat.o(91468);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atu localatu = (atu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91468);
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
            localatu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatu.Gpj = ((iy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 3: 
          localatu.Gpk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91468);
          return 0;
        case 4: 
          localatu.GKH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91468);
          return 0;
        }
        localatu.GKI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91468);
        return 0;
      }
      AppMethodBeat.o(91468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atu
 * JD-Core Version:    0.7.0.1
 */