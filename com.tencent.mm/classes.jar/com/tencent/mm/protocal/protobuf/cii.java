package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cii
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t Hch;
  public int Hci;
  public SKBuiltinBuffer_t Hcj;
  public int uin;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.version);
      if (this.Hch != null)
      {
        paramVarArgs.lC(3, this.Hch.computeSize());
        this.Hch.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Hci);
      if (this.Hcj != null)
      {
        paramVarArgs.lC(5, this.Hcj.computeSize());
        this.Hcj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uin) + 0 + f.a.a.b.b.a.bz(2, this.version);
      paramInt = i;
      if (this.Hch != null) {
        paramInt = i + f.a.a.a.lB(3, this.Hch.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Hci);
      paramInt = i;
      if (this.Hcj != null) {
        paramInt = i + f.a.a.a.lB(5, this.Hcj.computeSize());
      }
      AppMethodBeat.o(129972);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cii localcii = (cii)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(129972);
        return -1;
      case 1: 
        localcii.uin = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(129972);
        return 0;
      case 2: 
        localcii.version = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(129972);
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
          localcii.Hch = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(129972);
        return 0;
      case 4: 
        localcii.Hci = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(129972);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcii.Hcj = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    AppMethodBeat.o(129972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cii
 * JD-Core Version:    0.7.0.1
 */