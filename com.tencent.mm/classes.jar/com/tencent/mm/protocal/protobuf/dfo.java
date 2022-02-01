package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfo
  extends cvc
{
  public dfi Hts;
  public cwt Htt;
  public String hCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hts == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125780);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hts != null)
      {
        paramVarArgs.lC(2, this.Hts.computeSize());
        this.Hts.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(3, this.hCW);
      }
      if (this.Htt != null)
      {
        paramVarArgs.lC(4, this.Htt.computeSize());
        this.Htt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hts != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hts.computeSize());
      }
      i = paramInt;
      if (this.hCW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCW);
      }
      paramInt = i;
      if (this.Htt != null) {
        paramInt = i + f.a.a.a.lB(4, this.Htt.computeSize());
      }
      AppMethodBeat.o(125780);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hts == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfo localdfo = (dfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125780);
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
            localdfo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfo.Hts = ((dfi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 3: 
          localdfo.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125780);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfo.Htt = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      AppMethodBeat.o(125780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfo
 * JD-Core Version:    0.7.0.1
 */