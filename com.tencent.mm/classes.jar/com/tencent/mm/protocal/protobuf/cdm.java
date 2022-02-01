package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdm
  extends com.tencent.mm.bw.a
{
  public int GeQ;
  public SKBuiltinBuffer_t GjQ;
  public zy GjT;
  public int Hqv;
  public int Hqw;
  public int Ret;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133187);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GjT == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.GjT != null)
      {
        paramVarArgs.lJ(2, this.GjT.computeSize());
        this.GjT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GeQ);
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(4, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.nJb);
      paramVarArgs.aS(6, this.Hqv);
      paramVarArgs.aS(7, this.Hqw);
      AppMethodBeat.o(133187);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.GjT != null) {
        paramInt = i + f.a.a.a.lI(2, this.GjT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GeQ);
      paramInt = i;
      if (this.GjQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GjQ.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.nJb);
      int j = f.a.a.b.b.a.bz(6, this.Hqv);
      int k = f.a.a.b.b.a.bz(7, this.Hqw);
      AppMethodBeat.o(133187);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GjT == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133187);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdm localcdm = (cdm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133187);
        return -1;
      case 1: 
        localcdm.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133187);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdm.GjT = ((zy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 3: 
        localcdm.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133187);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdm.GjQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 5: 
        localcdm.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133187);
        return 0;
      case 6: 
        localcdm.Hqv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133187);
        return 0;
      }
      localcdm.Hqw = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(133187);
      return 0;
    }
    AppMethodBeat.o(133187);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdm
 * JD-Core Version:    0.7.0.1
 */