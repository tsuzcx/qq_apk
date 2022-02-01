package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cng
  extends cvc
{
  public int GeI;
  public long GeJ;
  public long HfW;
  public long HfZ;
  public String Hgt;
  public int Hgu;
  public int Hgv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32390);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hgt == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(32390);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgt != null) {
        paramVarArgs.d(2, this.Hgt);
      }
      paramVarArgs.aS(3, this.GeI);
      paramVarArgs.aY(4, this.GeJ);
      paramVarArgs.aY(5, this.HfW);
      paramVarArgs.aS(6, this.Hgu);
      paramVarArgs.aY(7, this.HfZ);
      paramVarArgs.aS(8, this.Hgv);
      AppMethodBeat.o(32390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hgt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hgt);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GeI);
      int j = f.a.a.b.b.a.p(4, this.GeJ);
      int k = f.a.a.b.b.a.p(5, this.HfW);
      int m = f.a.a.b.b.a.bz(6, this.Hgu);
      int n = f.a.a.b.b.a.p(7, this.HfZ);
      int i1 = f.a.a.b.b.a.bz(8, this.Hgv);
      AppMethodBeat.o(32390);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hgt == null)
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
        cng localcng = (cng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32390);
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
            localcng.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32390);
          return 0;
        case 2: 
          localcng.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32390);
          return 0;
        case 3: 
          localcng.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32390);
          return 0;
        case 4: 
          localcng.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32390);
          return 0;
        case 5: 
          localcng.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32390);
          return 0;
        case 6: 
          localcng.Hgu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32390);
          return 0;
        case 7: 
          localcng.HfZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32390);
          return 0;
        }
        localcng.Hgv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32390);
        return 0;
      }
      AppMethodBeat.o(32390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cng
 * JD-Core Version:    0.7.0.1
 */