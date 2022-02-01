package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eew
  extends com.tencent.mm.bx.a
{
  public eez HQl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQl == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110854);
        throw paramVarArgs;
      }
      if (this.HQl != null)
      {
        paramVarArgs.lC(4, this.HQl.computeSize());
        this.HQl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110854);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQl == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lB(4, this.HQl.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(110854);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HQl == null)
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
        eew localeew = (eew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110854);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eez();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeew.HQl = ((eez)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eew
 * JD-Core Version:    0.7.0.1
 */