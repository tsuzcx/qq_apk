package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbs
  extends cvc
{
  public String GyE;
  public String GyF;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.GyE != null) {
        paramVarArgs.d(3, this.GyE);
      }
      if (this.GyF != null) {
        paramVarArgs.d(4, this.GyF);
      }
      AppMethodBeat.o(125730);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.GyE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GyE);
      }
      paramInt = i;
      if (this.GyF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GyF);
      }
      AppMethodBeat.o(125730);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125730);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbs localbbs = (bbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125730);
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
            localbbs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125730);
          return 0;
        case 2: 
          localbbs.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125730);
          return 0;
        case 3: 
          localbbs.GyE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125730);
          return 0;
        }
        localbbs.GyF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125730);
        return 0;
      }
      AppMethodBeat.o(125730);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbs
 * JD-Core Version:    0.7.0.1
 */