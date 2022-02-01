package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiv
  extends cvc
{
  public String FzG;
  public String HTs;
  public String qei;
  public int ufj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qei != null) {
        paramVarArgs.d(2, this.qei);
      }
      if (this.FzG != null) {
        paramVarArgs.d(3, this.FzG);
      }
      if (this.HTs != null) {
        paramVarArgs.d(4, this.HTs);
      }
      paramVarArgs.aS(5, this.ufj);
      AppMethodBeat.o(152731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qei);
      }
      i = paramInt;
      if (this.FzG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FzG);
      }
      paramInt = i;
      if (this.HTs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HTs);
      }
      i = f.a.a.b.b.a.bz(5, this.ufj);
      AppMethodBeat.o(152731);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eiv localeiv = (eiv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152731);
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
            localeiv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152731);
          return 0;
        case 2: 
          localeiv.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 3: 
          localeiv.FzG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 4: 
          localeiv.HTs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152731);
          return 0;
        }
        localeiv.ufj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152731);
        return 0;
      }
      AppMethodBeat.o(152731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiv
 * JD-Core Version:    0.7.0.1
 */