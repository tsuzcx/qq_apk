package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class col
  extends com.tencent.mm.bx.a
{
  public acp CBa;
  public SKBuiltinBuffer_t CBb;
  public SKBuiltinBuffer_t CBc;
  public int CBq;
  public SKBuiltinBuffer_t CBt;
  public SKBuiltinBuffer_t CBu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBc == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.CBa == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.CBb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.CBc != null)
      {
        paramVarArgs.kX(1, this.CBc.computeSize());
        this.CBc.writeFields(paramVarArgs);
      }
      if (this.CBa != null)
      {
        paramVarArgs.kX(2, this.CBa.computeSize());
        this.CBa.writeFields(paramVarArgs);
      }
      if (this.CBb != null)
      {
        paramVarArgs.kX(3, this.CBb.computeSize());
        this.CBb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CBq);
      if (this.CBt != null)
      {
        paramVarArgs.kX(5, this.CBt.computeSize());
        this.CBt.writeFields(paramVarArgs);
      }
      if (this.CBu != null)
      {
        paramVarArgs.kX(6, this.CBu.computeSize());
        this.CBu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CBc == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = f.a.a.a.kW(1, this.CBc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBa != null) {
        paramInt = i + f.a.a.a.kW(2, this.CBa.computeSize());
      }
      i = paramInt;
      if (this.CBb != null) {
        i = paramInt + f.a.a.a.kW(3, this.CBb.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.CBq);
      paramInt = i;
      if (this.CBt != null) {
        paramInt = i + f.a.a.a.kW(5, this.CBt.computeSize());
      }
      i = paramInt;
      if (this.CBu != null) {
        i = paramInt + f.a.a.a.kW(6, this.CBu.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CBc == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.CBa == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.CBb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        col localcol = (col)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcol.CBc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcol.CBa = ((acp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
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
            localcol.CBb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localcol.CBq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcol.CBt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcol.CBu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133194);
        return 0;
      }
      AppMethodBeat.o(133194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.col
 * JD-Core Version:    0.7.0.1
 */