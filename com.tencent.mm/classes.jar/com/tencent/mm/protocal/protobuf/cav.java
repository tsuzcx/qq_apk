package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cav
  extends com.tencent.mm.bw.a
{
  public int DeleteFlag;
  public cxn GuF;
  public int Hov;
  public int How;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32351);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32351);
        throw paramVarArgs;
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(1, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hov);
      paramVarArgs.aS(3, this.How);
      paramVarArgs.aS(4, this.DeleteFlag);
      AppMethodBeat.o(32351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = f.a.a.a.lI(1, this.GuF.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Hov);
      int j = f.a.a.b.b.a.bz(3, this.How);
      int k = f.a.a.b.b.a.bz(4, this.DeleteFlag);
      AppMethodBeat.o(32351);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32351);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cav localcav = (cav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32351);
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
            localcav.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32351);
          return 0;
        case 2: 
          localcav.Hov = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32351);
          return 0;
        case 3: 
          localcav.How = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32351);
          return 0;
        }
        localcav.DeleteFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32351);
        return 0;
      }
      AppMethodBeat.o(32351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cav
 * JD-Core Version:    0.7.0.1
 */