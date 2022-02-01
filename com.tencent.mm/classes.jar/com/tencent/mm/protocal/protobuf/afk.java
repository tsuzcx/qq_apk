package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afk
  extends cvw
{
  public int GeT;
  public chu GvP;
  public int GvQ;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GvP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Package");
        AppMethodBeat.o(152536);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GvP != null)
      {
        paramVarArgs.lJ(2, this.GvP.computeSize());
        this.GvP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GeT);
      paramVarArgs.aS(4, this.GvQ);
      paramVarArgs.aS(5, this.nJA);
      AppMethodBeat.o(152536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GvP != null) {
        i = paramInt + f.a.a.a.lI(2, this.GvP.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GeT);
      int j = f.a.a.b.b.a.bz(4, this.GvQ);
      int k = f.a.a.b.b.a.bz(5, this.nJA);
      AppMethodBeat.o(152536);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GvP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Package");
          AppMethodBeat.o(152536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afk localafk = (afk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152536);
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
            localafk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafk.GvP = ((chu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 3: 
          localafk.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152536);
          return 0;
        case 4: 
          localafk.GvQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152536);
          return 0;
        }
        localafk.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152536);
        return 0;
      }
      AppMethodBeat.o(152536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afk
 * JD-Core Version:    0.7.0.1
 */