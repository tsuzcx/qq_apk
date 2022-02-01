package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hs
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FSF;
  public bpj FSG;
  public int FSH;
  public SKBuiltinBuffer_t FSI;
  public String FSJ;
  public int uuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSF == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.FSI == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.uuz);
      if (this.FSF != null)
      {
        paramVarArgs.lJ(2, this.FSF.computeSize());
        this.FSF.writeFields(paramVarArgs);
      }
      if (this.FSG != null)
      {
        paramVarArgs.lJ(3, this.FSG.computeSize());
        this.FSG.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FSH);
      if (this.FSI != null)
      {
        paramVarArgs.lJ(5, this.FSI.computeSize());
        this.FSI.writeFields(paramVarArgs);
      }
      if (this.FSJ != null) {
        paramVarArgs.d(6, this.FSJ);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uuz) + 0;
      paramInt = i;
      if (this.FSF != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSF.computeSize());
      }
      i = paramInt;
      if (this.FSG != null) {
        i = paramInt + f.a.a.a.lI(3, this.FSG.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.FSH);
      paramInt = i;
      if (this.FSI != null) {
        paramInt = i + f.a.a.a.lI(5, this.FSI.computeSize());
      }
      i = paramInt;
      if (this.FSJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FSJ);
      }
      AppMethodBeat.o(133152);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FSF == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.FSI == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      hs localhs = (hs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localhs.uuz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhs.FSF = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhs.FSG = ((bpj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localhs.FSH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133152);
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
          localhs.FSI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localhs.FSJ = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hs
 * JD-Core Version:    0.7.0.1
 */