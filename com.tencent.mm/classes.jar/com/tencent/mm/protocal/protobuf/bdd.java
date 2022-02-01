package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bdd
  extends cvc
{
  public b GzP;
  public b GzQ;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104807);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ReqType);
      if (this.GzP != null) {
        paramVarArgs.c(3, this.GzP);
      }
      if (this.GzQ != null) {
        paramVarArgs.c(4, this.GzQ);
      }
      AppMethodBeat.o(104807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ReqType);
      paramInt = i;
      if (this.GzP != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GzP);
      }
      i = paramInt;
      if (this.GzQ != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.GzQ);
      }
      AppMethodBeat.o(104807);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdd localbdd = (bdd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104807);
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
            localbdd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104807);
          return 0;
        case 2: 
          localbdd.ReqType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104807);
          return 0;
        case 3: 
          localbdd.GzP = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(104807);
          return 0;
        }
        localbdd.GzQ = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(104807);
        return 0;
      }
      AppMethodBeat.o(104807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdd
 * JD-Core Version:    0.7.0.1
 */