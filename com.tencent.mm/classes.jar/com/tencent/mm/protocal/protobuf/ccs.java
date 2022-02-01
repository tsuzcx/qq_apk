package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ccs
  extends com.tencent.mm.bx.a
{
  public int FMr;
  public SKBuiltinBuffer_t FRr;
  public zv FRu;
  public int GWV;
  public int GWW;
  public int Ret;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133187);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRu == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.FRu != null)
      {
        paramVarArgs.lC(2, this.FRu.computeSize());
        this.FRu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FMr);
      if (this.FRr != null)
      {
        paramVarArgs.lC(4, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.nDG);
      paramVarArgs.aS(6, this.GWV);
      paramVarArgs.aS(7, this.GWW);
      AppMethodBeat.o(133187);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FRu != null) {
        paramInt = i + f.a.a.a.lB(2, this.FRu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FMr);
      paramInt = i;
      if (this.FRr != null) {
        paramInt = i + f.a.a.a.lB(4, this.FRr.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.nDG);
      int j = f.a.a.b.b.a.bz(6, this.GWV);
      int k = f.a.a.b.b.a.bz(7, this.GWW);
      AppMethodBeat.o(133187);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FRu == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.FRr == null)
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
      ccs localccs = (ccs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133187);
        return -1;
      case 1: 
        localccs.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133187);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccs.FRu = ((zv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 3: 
        localccs.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133187);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccs.FRr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 5: 
        localccs.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133187);
        return 0;
      case 6: 
        localccs.GWV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133187);
        return 0;
      }
      localccs.GWW = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(133187);
      return 0;
    }
    AppMethodBeat.o(133187);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccs
 * JD-Core Version:    0.7.0.1
 */