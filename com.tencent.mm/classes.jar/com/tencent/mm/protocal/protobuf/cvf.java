package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvf
  extends cvc
{
  public int FpJ;
  public long GZk;
  public int Hnl;
  public int Hnm;
  public String duW;
  public int vjq;
  public String vjr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.aS(3, this.vjq);
      paramVarArgs.aS(4, this.FpJ);
      paramVarArgs.aY(5, this.GZk);
      paramVarArgs.aS(6, this.Hnl);
      if (this.vjr != null) {
        paramVarArgs.d(7, this.vjr);
      }
      paramVarArgs.aS(8, this.Hnm);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      i = i + f.a.a.b.b.a.bz(3, this.vjq) + f.a.a.b.b.a.bz(4, this.FpJ) + f.a.a.b.b.a.p(5, this.GZk) + f.a.a.b.b.a.bz(6, this.Hnl);
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vjr);
      }
      i = f.a.a.b.b.a.bz(8, this.Hnm);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvf localcvf = (cvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localcvf.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localcvf.vjq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localcvf.FpJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localcvf.GZk = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localcvf.Hnl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localcvf.vjr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localcvf.Hnm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvf
 * JD-Core Version:    0.7.0.1
 */