package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzk
  extends dop
{
  public int Mfb;
  public int Mfc;
  public int Mfd;
  public int bDZ;
  public int condition;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123598);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.bDZ);
      paramVarArgs.aM(3, this.condition);
      paramVarArgs.aM(4, this.Mfb);
      paramVarArgs.aM(5, this.Mfc);
      paramVarArgs.aM(6, this.Mfd);
      AppMethodBeat.o(123598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.bDZ);
      int j = g.a.a.b.b.a.bu(3, this.condition);
      int k = g.a.a.b.b.a.bu(4, this.Mfb);
      int m = g.a.a.b.b.a.bu(5, this.Mfc);
      int n = g.a.a.b.b.a.bu(6, this.Mfd);
      AppMethodBeat.o(123598);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bzk localbzk = (bzk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123598);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbzk.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123598);
          return 0;
        case 2: 
          localbzk.bDZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123598);
          return 0;
        case 3: 
          localbzk.condition = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123598);
          return 0;
        case 4: 
          localbzk.Mfb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123598);
          return 0;
        case 5: 
          localbzk.Mfc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123598);
          return 0;
        }
        localbzk.Mfd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123598);
        return 0;
      }
      AppMethodBeat.o(123598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzk
 * JD-Core Version:    0.7.0.1
 */