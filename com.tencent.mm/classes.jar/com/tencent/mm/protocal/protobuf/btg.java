package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btg
  extends com.tencent.mm.bw.a
{
  public ado DUx;
  public String DYF;
  public String DYS;
  public SKBuiltinBuffer_t DYu;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.DUx == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(1, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      if (this.DUx != null)
      {
        paramVarArgs.ln(2, this.DUx.computeSize());
        this.DUx.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      if (this.DYF != null) {
        paramVarArgs.d(4, this.DYF);
      }
      if (this.DYS != null) {
        paramVarArgs.d(5, this.DYS);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DYu == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.lm(1, this.DYu.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUx != null) {
        paramInt = i + f.a.a.a.lm(2, this.DUx.computeSize());
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncR);
      }
      paramInt = i;
      if (this.DYF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DYF);
      }
      i = paramInt;
      if (this.DYS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DYS);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DYu == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.DUx == null)
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
        btg localbtg = (btg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ado();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ado)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.DUx = ((ado)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localbtg.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localbtg.DYF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localbtg.DYS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btg
 * JD-Core Version:    0.7.0.1
 */