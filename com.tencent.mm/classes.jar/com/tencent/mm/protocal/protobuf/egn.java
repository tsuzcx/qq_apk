package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class egn
  extends com.tencent.mm.bw.a
{
  public egq Iks;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iks == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110854);
        throw paramVarArgs;
      }
      if (this.Iks != null)
      {
        paramVarArgs.lJ(4, this.Iks.computeSize());
        this.Iks.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110854);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Iks == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lI(4, this.Iks.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(110854);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Iks == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(110854);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110854);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egn localegn = (egn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110854);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((egq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegn.Iks = ((egq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110854);
        return 0;
      }
      AppMethodBeat.o(110854);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egn
 * JD-Core Version:    0.7.0.1
 */