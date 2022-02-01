package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ate
  extends cvc
{
  public iy FWK;
  public String FWL;
  public int Grj;
  public int Grk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWK != null)
      {
        paramVarArgs.lC(2, this.FWK.computeSize());
        this.FWK.writeFields(paramVarArgs);
      }
      if (this.FWL != null) {
        paramVarArgs.d(3, this.FWL);
      }
      paramVarArgs.aS(4, this.Grj);
      paramVarArgs.aS(5, this.Grk);
      AppMethodBeat.o(91468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWK != null) {
        paramInt = i + f.a.a.a.lB(2, this.FWK.computeSize());
      }
      i = paramInt;
      if (this.FWL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWL);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Grj);
      int j = f.a.a.b.b.a.bz(5, this.Grk);
      AppMethodBeat.o(91468);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ate localate = (ate)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91468);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localate.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localate.FWK = ((iy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 3: 
          localate.FWL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91468);
          return 0;
        case 4: 
          localate.Grj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91468);
          return 0;
        }
        localate.Grk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91468);
        return 0;
      }
      AppMethodBeat.o(91468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ate
 * JD-Core Version:    0.7.0.1
 */