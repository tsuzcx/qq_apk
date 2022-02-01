package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dta
  extends com.tencent.mm.bw.a
{
  public aif KKX;
  public SKBuiltinBuffer_t KKY;
  public SKBuiltinBuffer_t KKZ;
  public int KLn;
  public SKBuiltinBuffer_t KLq;
  public SKBuiltinBuffer_t KLr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.KKX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.KKY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.KKZ != null)
      {
        paramVarArgs.ni(1, this.KKZ.computeSize());
        this.KKZ.writeFields(paramVarArgs);
      }
      if (this.KKX != null)
      {
        paramVarArgs.ni(2, this.KKX.computeSize());
        this.KKX.writeFields(paramVarArgs);
      }
      if (this.KKY != null)
      {
        paramVarArgs.ni(3, this.KKY.computeSize());
        this.KKY.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KLn);
      if (this.KLq != null)
      {
        paramVarArgs.ni(5, this.KLq.computeSize());
        this.KLq.writeFields(paramVarArgs);
      }
      if (this.KLr != null)
      {
        paramVarArgs.ni(6, this.KLr.computeSize());
        this.KLr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KKZ == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = g.a.a.a.nh(1, this.KKZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KKX != null) {
        paramInt = i + g.a.a.a.nh(2, this.KKX.computeSize());
      }
      i = paramInt;
      if (this.KKY != null) {
        i = paramInt + g.a.a.a.nh(3, this.KKY.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.KLn);
      paramInt = i;
      if (this.KLq != null) {
        paramInt = i + g.a.a.a.nh(5, this.KLq.computeSize());
      }
      i = paramInt;
      if (this.KLr != null) {
        i = paramInt + g.a.a.a.nh(6, this.KLr.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KKZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.KKX == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.KKY == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dta localdta = (dta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdta.KKZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aif();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aif)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdta.KKX = ((aif)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdta.KKY = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localdta.KLn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdta.KLq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdta.KLr = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */