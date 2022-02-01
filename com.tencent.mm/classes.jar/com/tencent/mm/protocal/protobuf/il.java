package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class il
  extends cvc
{
  public boolean FBr;
  public long Fsa;
  public String Fsb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Fsa);
      if (this.Fsb != null) {
        paramVarArgs.d(3, this.Fsb);
      }
      paramVarArgs.bt(4, this.FBr);
      AppMethodBeat.o(211925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Fsa);
      paramInt = i;
      if (this.Fsb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fsb);
      }
      i = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(211925);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        il localil = (il)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211925);
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
            localil.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211925);
          return 0;
        case 2: 
          localil.Fsa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(211925);
          return 0;
        case 3: 
          localil.Fsb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211925);
          return 0;
        }
        localil.FBr = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(211925);
        return 0;
      }
      AppMethodBeat.o(211925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.il
 * JD-Core Version:    0.7.0.1
 */