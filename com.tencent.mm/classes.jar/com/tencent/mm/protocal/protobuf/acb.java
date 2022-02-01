package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acb
  extends ckq
{
  public int CNt;
  public bxo DcF;
  public int DcG;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DcF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Package");
        AppMethodBeat.o(152536);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DcF != null)
      {
        paramVarArgs.kX(2, this.DcF.computeSize());
        this.DcF.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.CNt);
      paramVarArgs.aR(4, this.DcG);
      paramVarArgs.aR(5, this.mBH);
      AppMethodBeat.o(152536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DcF != null) {
        i = paramInt + f.a.a.a.kW(2, this.DcF.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(3, this.CNt);
      int j = f.a.a.b.b.a.bA(4, this.DcG);
      int k = f.a.a.b.b.a.bA(5, this.mBH);
      AppMethodBeat.o(152536);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DcF == null)
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
        acb localacb = (acb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152536);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacb.DcF = ((bxo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 3: 
          localacb.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152536);
          return 0;
        case 4: 
          localacb.DcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152536);
          return 0;
        }
        localacb.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152536);
        return 0;
      }
      AppMethodBeat.o(152536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acb
 * JD-Core Version:    0.7.0.1
 */