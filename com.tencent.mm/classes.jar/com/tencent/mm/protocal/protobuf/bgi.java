package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bgi
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int wFQ;
  public SKBuiltinBuffer_t wFR;
  public String wsq;
  public ue xvF;
  public int xvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58922);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xvF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(58922);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(58922);
        throw paramVarArgs;
      }
      if (this.xvF != null)
      {
        paramVarArgs.iQ(1, this.xvF.computeSize());
        this.xvF.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wFQ);
      if (this.wFR != null)
      {
        paramVarArgs.iQ(3, this.wFR.computeSize());
        this.wFR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.Scene);
      if (this.wsq != null) {
        paramVarArgs.e(5, this.wsq);
      }
      paramVarArgs.aO(6, this.xvG);
      AppMethodBeat.o(58922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xvF == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = e.a.a.a.iP(1, this.xvF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wFQ);
      paramInt = i;
      if (this.wFR != null) {
        paramInt = i + e.a.a.a.iP(3, this.wFR.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.Scene);
      paramInt = i;
      if (this.wsq != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wsq);
      }
      i = e.a.a.b.b.a.bl(6, this.xvG);
      AppMethodBeat.o(58922);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xvF == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(58922);
          throw paramVarArgs;
        }
        if (this.wFR == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(58922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgi localbgi = (bgi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58922);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ue();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgi.xvF = ((ue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58922);
          return 0;
        case 2: 
          localbgi.wFQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58922);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgi.wFR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58922);
          return 0;
        case 4: 
          localbgi.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58922);
          return 0;
        case 5: 
          localbgi.wsq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58922);
          return 0;
        }
        localbgi.xvG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58922);
        return 0;
      }
      AppMethodBeat.o(58922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgi
 * JD-Core Version:    0.7.0.1
 */