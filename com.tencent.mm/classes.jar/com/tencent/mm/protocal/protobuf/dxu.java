package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxu
  extends cvc
{
  public int GeI;
  public long GeJ;
  public long HJh;
  public String HKm;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      if (this.HKm != null) {
        paramVarArgs.d(4, this.HKm);
      }
      paramVarArgs.aS(5, this.nEf);
      paramVarArgs.aY(6, this.HJh);
      AppMethodBeat.o(115878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ);
      paramInt = i;
      if (this.HKm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HKm);
      }
      i = f.a.a.b.b.a.bz(5, this.nEf);
      int j = f.a.a.b.b.a.p(6, this.HJh);
      AppMethodBeat.o(115878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxu localdxu = (dxu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115878);
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
            localdxu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115878);
          return 0;
        case 2: 
          localdxu.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115878);
          return 0;
        case 3: 
          localdxu.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115878);
          return 0;
        case 4: 
          localdxu.HKm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115878);
          return 0;
        case 5: 
          localdxu.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115878);
          return 0;
        }
        localdxu.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(115878);
        return 0;
      }
      AppMethodBeat.o(115878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxu
 * JD-Core Version:    0.7.0.1
 */