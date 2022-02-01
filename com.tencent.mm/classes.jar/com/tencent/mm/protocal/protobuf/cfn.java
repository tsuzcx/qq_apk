package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfn
  extends com.tencent.mm.bw.a
{
  public dyz FtR;
  public dzc FtS;
  public dyv FtT;
  public String thZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.thZ != null) {
        paramVarArgs.d(1, this.thZ);
      }
      if (this.FtR != null)
      {
        paramVarArgs.ln(2, this.FtR.computeSize());
        this.FtR.writeFields(paramVarArgs);
      }
      if (this.FtS != null)
      {
        paramVarArgs.ln(3, this.FtS.computeSize());
        this.FtS.writeFields(paramVarArgs);
      }
      if (this.FtT != null)
      {
        paramVarArgs.ln(4, this.FtT.computeSize());
        this.FtT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thZ == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.b.b.a.e(1, this.thZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FtR != null) {
        paramInt = i + f.a.a.a.lm(2, this.FtR.computeSize());
      }
      i = paramInt;
      if (this.FtS != null) {
        i = paramInt + f.a.a.a.lm(3, this.FtS.computeSize());
      }
      paramInt = i;
      if (this.FtT != null) {
        paramInt = i + f.a.a.a.lm(4, this.FtT.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.thZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfn localcfn = (cfn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localcfn.thZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfn.FtR = ((dyz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfn.FtS = ((dzc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfn.FtT = ((dyv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfn
 * JD-Core Version:    0.7.0.1
 */