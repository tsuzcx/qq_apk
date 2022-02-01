package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byo
  extends com.tencent.mm.bw.a
{
  public afy FSp;
  public String FWJ;
  public SKBuiltinBuffer_t FWl;
  public String FWw;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.FSp == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(1, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      if (this.FSp != null)
      {
        paramVarArgs.lJ(2, this.FSp.computeSize());
        this.FSp.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      if (this.FWw != null) {
        paramVarArgs.d(4, this.FWw);
      }
      if (this.FWJ != null) {
        paramVarArgs.d(5, this.FWJ);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWl == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.lI(1, this.FWl.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSp != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSp.computeSize());
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      paramInt = i;
      if (this.FWw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWw);
      }
      i = paramInt;
      if (this.FWJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FWJ);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FWl == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.FSp == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byo localbyo = (byo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyo.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyo.FSp = ((afy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localbyo.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localbyo.FWw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localbyo.FWJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byo
 * JD-Core Version:    0.7.0.1
 */