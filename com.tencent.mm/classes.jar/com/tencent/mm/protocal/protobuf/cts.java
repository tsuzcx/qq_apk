package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cts
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DTA;
  public int DTO;
  public SKBuiltinBuffer_t DTR;
  public SKBuiltinBuffer_t DTS;
  public ado DTy;
  public SKBuiltinBuffer_t DTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.DTy == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.DTz == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.DTA != null)
      {
        paramVarArgs.ln(1, this.DTA.computeSize());
        this.DTA.writeFields(paramVarArgs);
      }
      if (this.DTy != null)
      {
        paramVarArgs.ln(2, this.DTy.computeSize());
        this.DTy.writeFields(paramVarArgs);
      }
      if (this.DTz != null)
      {
        paramVarArgs.ln(3, this.DTz.computeSize());
        this.DTz.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DTO);
      if (this.DTR != null)
      {
        paramVarArgs.ln(5, this.DTR.computeSize());
        this.DTR.writeFields(paramVarArgs);
      }
      if (this.DTS != null)
      {
        paramVarArgs.ln(6, this.DTS.computeSize());
        this.DTS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DTA == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = f.a.a.a.lm(1, this.DTA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DTy != null) {
        paramInt = i + f.a.a.a.lm(2, this.DTy.computeSize());
      }
      i = paramInt;
      if (this.DTz != null) {
        i = paramInt + f.a.a.a.lm(3, this.DTz.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.DTO);
      paramInt = i;
      if (this.DTR != null) {
        paramInt = i + f.a.a.a.lm(5, this.DTR.computeSize());
      }
      i = paramInt;
      if (this.DTS != null) {
        i = paramInt + f.a.a.a.lm(6, this.DTS.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DTA == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.DTy == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.DTz == null)
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
        cts localcts = (cts)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
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
            localcts.DTA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
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
            localcts.DTy = ((ado)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcts.DTz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localcts.DTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcts.DTR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcts.DTS = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cts
 * JD-Core Version:    0.7.0.1
 */