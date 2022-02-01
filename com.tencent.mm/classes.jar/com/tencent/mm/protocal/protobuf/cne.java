package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cne
  extends cvc
{
  public int GeI;
  public long GeJ;
  public long HfW;
  public long HfZ;
  public int nDG;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ukj == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ukj != null) {
        paramVarArgs.d(2, this.ukj);
      }
      paramVarArgs.aS(3, this.GeI);
      paramVarArgs.aY(4, this.GeJ);
      paramVarArgs.aY(5, this.HfW);
      paramVarArgs.aY(6, this.HfZ);
      paramVarArgs.aS(7, this.nDG);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label667;
      }
    }
    label667:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ukj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ukj);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GeI);
      int j = f.a.a.b.b.a.p(4, this.GeJ);
      int k = f.a.a.b.b.a.p(5, this.HfW);
      int m = f.a.a.b.b.a.p(6, this.HfZ);
      int n = f.a.a.b.b.a.bz(7, this.nDG);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ukj == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(32388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cne localcne = (cne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
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
            localcne.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localcne.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localcne.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localcne.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localcne.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localcne.HfZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32388);
          return 0;
        }
        localcne.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cne
 * JD-Core Version:    0.7.0.1
 */