package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dcs
  extends cvw
{
  public int GPd;
  public nn GPf;
  public int mask;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPf == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(124551);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GPd);
      paramVarArgs.aS(3, this.mask);
      if (this.GPf != null)
      {
        paramVarArgs.lJ(4, this.GPf.computeSize());
        this.GPf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GPd) + f.a.a.b.b.a.bz(3, this.mask);
      paramInt = i;
      if (this.GPf != null) {
        paramInt = i + f.a.a.a.lI(4, this.GPf.computeSize());
      }
      AppMethodBeat.o(124551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GPf == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(124551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcs localdcs = (dcs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124551);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124551);
          return 0;
        case 2: 
          localdcs.GPd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124551);
          return 0;
        case 3: 
          localdcs.mask = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124551);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcs.GPf = ((nn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      AppMethodBeat.o(124551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcs
 * JD-Core Version:    0.7.0.1
 */