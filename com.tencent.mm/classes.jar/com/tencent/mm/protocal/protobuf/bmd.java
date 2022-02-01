package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmd
  extends cvc
{
  public int GGE;
  public String dHX;
  public String ovm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114041);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.ovm == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dHX != null) {
        paramVarArgs.d(2, this.dHX);
      }
      if (this.ovm != null) {
        paramVarArgs.d(3, this.ovm);
      }
      paramVarArgs.aS(4, this.GGE);
      AppMethodBeat.o(114041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dHX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dHX);
      }
      i = paramInt;
      if (this.ovm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ovm);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GGE);
      AppMethodBeat.o(114041);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.dHX == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        if (this.ovm == null)
        {
          paramVarArgs = new b("Not all required fields were included: to_username");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmd localbmd = (bmd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114041);
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
            localbmd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114041);
          return 0;
        case 2: 
          localbmd.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114041);
          return 0;
        case 3: 
          localbmd.ovm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114041);
          return 0;
        }
        localbmd.GGE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(114041);
        return 0;
      }
      AppMethodBeat.o(114041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmd
 * JD-Core Version:    0.7.0.1
 */