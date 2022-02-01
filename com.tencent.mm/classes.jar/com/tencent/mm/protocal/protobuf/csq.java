package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csq
  extends cvc
{
  public String GeT;
  public dub HkV;
  public don HkW;
  public int gsU;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HkV == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GeT != null) {
        paramVarArgs.d(2, this.GeT);
      }
      paramVarArgs.aS(3, this.nEf);
      if (this.HkV != null)
      {
        paramVarArgs.lC(4, this.HkV.computeSize());
        this.HkV.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.gsU);
      if (this.HkW != null)
      {
        paramVarArgs.lC(6, this.HkW.computeSize());
        this.HkW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GeT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GeT);
      }
      i += f.a.a.b.b.a.bz(3, this.nEf);
      paramInt = i;
      if (this.HkV != null) {
        paramInt = i + f.a.a.a.lB(4, this.HkV.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.gsU);
      paramInt = i;
      if (this.HkW != null) {
        paramInt = i + f.a.a.a.lB(6, this.HkW.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HkV == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(56259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csq localcsq = (csq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
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
            localcsq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localcsq.GeT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localcsq.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dub();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsq.HkV = ((dub)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localcsq.gsU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new don();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((don)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsq.HkW = ((don)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      AppMethodBeat.o(56259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csq
 * JD-Core Version:    0.7.0.1
 */