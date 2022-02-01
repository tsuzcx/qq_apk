package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ckm
  extends com.tencent.mm.bx.a
{
  public efb HdW;
  public efe HdX;
  public eex HdY;
  public String ufQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.ufQ != null) {
        paramVarArgs.d(1, this.ufQ);
      }
      if (this.HdW != null)
      {
        paramVarArgs.lC(2, this.HdW.computeSize());
        this.HdW.writeFields(paramVarArgs);
      }
      if (this.HdX != null)
      {
        paramVarArgs.lC(3, this.HdX.computeSize());
        this.HdX.writeFields(paramVarArgs);
      }
      if (this.HdY != null)
      {
        paramVarArgs.lC(4, this.HdY.computeSize());
        this.HdY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufQ == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.b.b.a.e(1, this.ufQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HdW != null) {
        paramInt = i + f.a.a.a.lB(2, this.HdW.computeSize());
      }
      i = paramInt;
      if (this.HdX != null) {
        i = paramInt + f.a.a.a.lB(3, this.HdX.computeSize());
      }
      paramInt = i;
      if (this.HdY != null) {
        paramInt = i + f.a.a.a.lB(4, this.HdY.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ufQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckm localckm = (ckm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localckm.ufQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckm.HdW = ((efb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckm.HdX = ((efe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eex();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eex)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckm.HdY = ((eex)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckm
 * JD-Core Version:    0.7.0.1
 */