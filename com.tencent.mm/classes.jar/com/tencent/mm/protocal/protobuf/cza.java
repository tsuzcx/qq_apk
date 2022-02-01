package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cza
  extends cvc
{
  public String FKK;
  public long HmK;
  public long HmP;
  public int HpJ;
  public long HpK;
  public boolean HpL;
  public ehn HpM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FKK != null) {
        paramVarArgs.d(2, this.FKK);
      }
      paramVarArgs.aY(3, this.HmK);
      paramVarArgs.aS(4, this.HpJ);
      paramVarArgs.aY(5, this.HpK);
      paramVarArgs.bt(6, this.HpL);
      if (this.HpM != null)
      {
        paramVarArgs.lC(7, this.HpM.computeSize());
        this.HpM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.HmP);
      AppMethodBeat.o(117921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FKK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FKK);
      }
      i = i + f.a.a.b.b.a.p(3, this.HmK) + f.a.a.b.b.a.bz(4, this.HpJ) + f.a.a.b.b.a.p(5, this.HpK) + f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.HpM != null) {
        paramInt = i + f.a.a.a.lB(7, this.HpM.computeSize());
      }
      i = f.a.a.b.b.a.p(8, this.HmP);
      AppMethodBeat.o(117921);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cza localcza = (cza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117921);
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
            localcza.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        case 2: 
          localcza.FKK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117921);
          return 0;
        case 3: 
          localcza.HmK = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(117921);
          return 0;
        case 4: 
          localcza.HpJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117921);
          return 0;
        case 5: 
          localcza.HpK = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(117921);
          return 0;
        case 6: 
          localcza.HpL = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(117921);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcza.HpM = ((ehn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        }
        localcza.HmP = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117921);
        return 0;
      }
      AppMethodBeat.o(117921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cza
 * JD-Core Version:    0.7.0.1
 */