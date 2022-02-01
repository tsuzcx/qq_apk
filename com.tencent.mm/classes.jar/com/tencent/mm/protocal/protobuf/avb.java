package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avb
  extends com.tencent.mm.bw.a
{
  public auu GMg;
  public LinkedList<String> GMh;
  
  public avb()
  {
    AppMethodBeat.i(42644);
    this.GMh = new LinkedList();
    AppMethodBeat.o(42644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GMg == null)
      {
        paramVarArgs = new b("Not all required fields were included: GameItem");
        AppMethodBeat.o(42645);
        throw paramVarArgs;
      }
      if (this.GMg != null)
      {
        paramVarArgs.lJ(1, this.GMg.computeSize());
        this.GMg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.GMh);
      AppMethodBeat.o(42645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GMg == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.a.lI(1, this.GMg.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.GMh);
      AppMethodBeat.o(42645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GMh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GMg == null)
        {
          paramVarArgs = new b("Not all required fields were included: GameItem");
          AppMethodBeat.o(42645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avb localavb = (avb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((auu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavb.GMg = ((auu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42645);
          return 0;
        }
        localavb.GMh.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(42645);
        return 0;
      }
      AppMethodBeat.o(42645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avb
 * JD-Core Version:    0.7.0.1
 */