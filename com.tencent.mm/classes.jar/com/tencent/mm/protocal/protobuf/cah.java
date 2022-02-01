package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cah
  extends com.tencent.mm.bw.a
{
  public cxn FNm;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101827);
        throw paramVarArgs;
      }
      if (this.FNm != null)
      {
        paramVarArgs.lJ(1, this.FNm.computeSize());
        this.FNm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nJb);
      AppMethodBeat.o(101827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNm == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.a.lI(1, this.FNm.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nJb);
      AppMethodBeat.o(101827);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101827);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cah localcah = (cah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101827);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcah.FNm = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101827);
          return 0;
        }
        localcah.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(101827);
        return 0;
      }
      AppMethodBeat.o(101827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cah
 * JD-Core Version:    0.7.0.1
 */