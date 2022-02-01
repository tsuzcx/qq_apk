package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btj
  extends com.tencent.mm.bx.a
{
  public String CBS;
  public int CRw;
  public SKBuiltinBuffer_t CRx;
  public xe DQS;
  public int DQT;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.CRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.DQS != null)
      {
        paramVarArgs.kX(1, this.DQS.computeSize());
        this.DQS.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CRw);
      if (this.CRx != null)
      {
        paramVarArgs.kX(3, this.CRx.computeSize());
        this.CRx.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.CBS != null) {
        paramVarArgs.d(5, this.CBS);
      }
      paramVarArgs.aR(6, this.DQT);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQS == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.kW(1, this.DQS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CRw);
      paramInt = i;
      if (this.CRx != null) {
        paramInt = i + f.a.a.a.kW(3, this.CRx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Scene);
      paramInt = i;
      if (this.CBS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CBS);
      }
      i = f.a.a.b.b.a.bA(6, this.DQT);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DQS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.CRx == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btj localbtj = (btj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtj.DQS = ((xe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localbtj.CRw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtj.CRx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localbtj.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localbtj.CBS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localbtj.DQT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btj
 * JD-Core Version:    0.7.0.1
 */