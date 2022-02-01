package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class akl
  extends com.tencent.mm.bx.a
  implements deo
{
  public int FMr;
  public SKBuiltinBuffer_t FRr;
  public zv FRu;
  public int Ret;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRu == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.FRu != null)
      {
        paramVarArgs.lC(2, this.FRu.computeSize());
        this.FRu.writeFields(paramVarArgs);
      }
      if (this.FRr != null)
      {
        paramVarArgs.lC(3, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FMr);
      AppMethodBeat.o(127483);
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
      i = paramInt;
      if (this.FRr != null) {
        i = paramInt + f.a.a.a.lB(3, this.FRr.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FMr);
      AppMethodBeat.o(127483);
      return i + paramInt;
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
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      akl localakl = (akl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127483);
        return -1;
      case 1: 
        localakl.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127483);
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
          localakl.FRu = ((zv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakl.FRr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      }
      localakl.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(127483);
      return 0;
    }
    AppMethodBeat.o(127483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akl
 * JD-Core Version:    0.7.0.1
 */