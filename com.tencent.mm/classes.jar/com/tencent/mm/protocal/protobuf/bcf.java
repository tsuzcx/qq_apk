package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bcf
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public zd wsy;
  public SKBuiltinBuffer_t wvN;
  public String wvW;
  public String wwj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58914);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvN == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(58914);
        throw paramVarArgs;
      }
      if (this.wsy == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(58914);
        throw paramVarArgs;
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(1, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      if (this.wsy != null)
      {
        paramVarArgs.iQ(2, this.wsy.computeSize());
        this.wsy.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(3, this.jJA);
      }
      if (this.wvW != null) {
        paramVarArgs.e(4, this.wvW);
      }
      if (this.wwj != null) {
        paramVarArgs.e(5, this.wwj);
      }
      AppMethodBeat.o(58914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wvN == null) {
        break label742;
      }
    }
    label742:
    for (int i = e.a.a.a.iP(1, this.wvN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsy != null) {
        paramInt = i + e.a.a.a.iP(2, this.wsy.computeSize());
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jJA);
      }
      paramInt = i;
      if (this.wvW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvW);
      }
      i = paramInt;
      if (this.wwj != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wwj);
      }
      AppMethodBeat.o(58914);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wvN == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(58914);
          throw paramVarArgs;
        }
        if (this.wsy == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(58914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bcf localbcf = (bcf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58914);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcf.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58914);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcf.wsy = ((zd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58914);
          return 0;
        case 3: 
          localbcf.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58914);
          return 0;
        case 4: 
          localbcf.wvW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58914);
          return 0;
        }
        localbcf.wwj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58914);
        return 0;
      }
      AppMethodBeat.o(58914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcf
 * JD-Core Version:    0.7.0.1
 */