package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bub
  extends cvc
{
  public int dFJ;
  public String hAy;
  public String qmb;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.qmb == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.hAy == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.qmb != null) {
        paramVarArgs.d(3, this.qmb);
      }
      paramVarArgs.aS(4, this.dFJ);
      if (this.hAy != null) {
        paramVarArgs.d(5, this.hAy);
      }
      AppMethodBeat.o(32336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label697;
      }
    }
    label697:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.qmb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qmb);
      }
      i += f.a.a.b.b.a.bz(4, this.dFJ);
      paramInt = i;
      if (this.hAy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hAy);
      }
      AppMethodBeat.o(32336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.qmb == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.hAy == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bub localbub = (bub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32336);
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
            localbub.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32336);
          return 0;
        case 2: 
          localbub.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 3: 
          localbub.qmb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 4: 
          localbub.dFJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32336);
          return 0;
        }
        localbub.hAy = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32336);
        return 0;
      }
      AppMethodBeat.o(32336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bub
 * JD-Core Version:    0.7.0.1
 */