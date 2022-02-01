package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czw
  extends com.tencent.mm.bw.a
{
  public int FRG;
  public SKBuiltinBuffer_t FRJ;
  public SKBuiltinBuffer_t FRK;
  public afy FRq;
  public SKBuiltinBuffer_t FRr;
  public SKBuiltinBuffer_t FRs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRs == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.FRq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.FRs != null)
      {
        paramVarArgs.lJ(1, this.FRs.computeSize());
        this.FRs.writeFields(paramVarArgs);
      }
      if (this.FRq != null)
      {
        paramVarArgs.lJ(2, this.FRq.computeSize());
        this.FRq.writeFields(paramVarArgs);
      }
      if (this.FRr != null)
      {
        paramVarArgs.lJ(3, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FRG);
      if (this.FRJ != null)
      {
        paramVarArgs.lJ(5, this.FRJ.computeSize());
        this.FRJ.writeFields(paramVarArgs);
      }
      if (this.FRK != null)
      {
        paramVarArgs.lJ(6, this.FRK.computeSize());
        this.FRK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FRs == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = f.a.a.a.lI(1, this.FRs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRq != null) {
        paramInt = i + f.a.a.a.lI(2, this.FRq.computeSize());
      }
      i = paramInt;
      if (this.FRr != null) {
        i = paramInt + f.a.a.a.lI(3, this.FRr.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.FRG);
      paramInt = i;
      if (this.FRJ != null) {
        paramInt = i + f.a.a.a.lI(5, this.FRJ.computeSize());
      }
      i = paramInt;
      if (this.FRK != null) {
        i = paramInt + f.a.a.a.lI(6, this.FRK.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FRs == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.FRq == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.FRr == null)
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
        czw localczw = (czw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
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
            localczw.FRs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
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
            localczw.FRq = ((afy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczw.FRr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localczw.FRG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczw.FRJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczw.FRK = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czw
 * JD-Core Version:    0.7.0.1
 */