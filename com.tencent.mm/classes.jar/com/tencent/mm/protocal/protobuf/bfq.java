package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfq
  extends cvc
{
  public String GBn;
  public int GBo;
  public LinkedList<cwt> GBp;
  public int GBq;
  public String ukw;
  
  public bfq()
  {
    AppMethodBeat.i(91494);
    this.GBp = new LinkedList();
    AppMethodBeat.o(91494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GBn != null) {
        paramVarArgs.d(2, this.GBn);
      }
      paramVarArgs.aS(3, this.GBo);
      paramVarArgs.e(4, 8, this.GBp);
      if (this.ukw != null) {
        paramVarArgs.d(5, this.ukw);
      }
      paramVarArgs.aS(6, this.GBq);
      AppMethodBeat.o(91495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GBn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GBn);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GBo) + f.a.a.a.c(4, 8, this.GBp);
      paramInt = i;
      if (this.ukw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ukw);
      }
      i = f.a.a.b.b.a.bz(6, this.GBq);
      AppMethodBeat.o(91495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GBp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfq localbfq = (bfq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91495);
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
            localbfq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 2: 
          localbfq.GBn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91495);
          return 0;
        case 3: 
          localbfq.GBo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91495);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfq.GBp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 5: 
          localbfq.ukw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91495);
          return 0;
        }
        localbfq.GBq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91495);
        return 0;
      }
      AppMethodBeat.o(91495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfq
 * JD-Core Version:    0.7.0.1
 */