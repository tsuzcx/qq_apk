package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwh
  extends cvc
{
  public String FuL;
  public int Hok;
  public cwn Hol;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FuL != null) {
        paramVarArgs.d(2, this.FuL);
      }
      paramVarArgs.aS(3, this.Hok);
      if (this.Hol != null)
      {
        paramVarArgs.lC(4, this.Hol.computeSize());
        this.Hol.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FuL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FuL);
      }
      i += f.a.a.b.b.a.bz(3, this.Hok);
      paramInt = i;
      if (this.Hol != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hol.computeSize());
      }
      AppMethodBeat.o(181506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(181506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwh localcwh = (cwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181506);
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
            localcwh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181506);
          return 0;
        case 2: 
          localcwh.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(181506);
          return 0;
        case 3: 
          localcwh.Hok = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(181506);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwh.Hol = ((cwn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(181506);
        return 0;
      }
      AppMethodBeat.o(181506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwh
 * JD-Core Version:    0.7.0.1
 */