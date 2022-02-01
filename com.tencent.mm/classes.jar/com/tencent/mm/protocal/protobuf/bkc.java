package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bkc
  extends cvc
{
  public boolean GEC;
  public String GED;
  public String hAy;
  public String qmb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32281);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qmb == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32281);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.GEC);
      if (this.hAy != null) {
        paramVarArgs.d(3, this.hAy);
      }
      if (this.qmb != null) {
        paramVarArgs.d(4, this.qmb);
      }
      if (this.GED != null) {
        paramVarArgs.d(5, this.GED);
      }
      AppMethodBeat.o(32281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label593;
      }
    }
    label593:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.hAy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hAy);
      }
      i = paramInt;
      if (this.qmb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.qmb);
      }
      paramInt = i;
      if (this.GED != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GED);
      }
      AppMethodBeat.o(32281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.qmb == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32281);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkc localbkc = (bkc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32281);
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
            localbkc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32281);
          return 0;
        case 2: 
          localbkc.GEC = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32281);
          return 0;
        case 3: 
          localbkc.hAy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32281);
          return 0;
        case 4: 
          localbkc.qmb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32281);
          return 0;
        }
        localbkc.GED = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32281);
        return 0;
      }
      AppMethodBeat.o(32281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkc
 * JD-Core Version:    0.7.0.1
 */