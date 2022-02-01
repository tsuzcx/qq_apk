package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class id
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t FAD;
  public String FAE;
  public int FAF;
  public String ID;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAD == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.FAD != null)
      {
        paramVarArgs.lC(2, this.FAD.computeSize());
        this.FAD.writeFields(paramVarArgs);
      }
      if (this.FAE != null) {
        paramVarArgs.d(3, this.FAE);
      }
      paramVarArgs.aS(4, this.FAF);
      if (this.ID != null) {
        paramVarArgs.d(5, this.ID);
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FAD != null) {
        paramInt = i + f.a.a.a.lB(2, this.FAD.computeSize());
      }
      i = paramInt;
      if (this.FAE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FAE);
      }
      i += f.a.a.b.b.a.bz(4, this.FAF);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ID);
      }
      AppMethodBeat.o(32135);
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
      if (this.FAD == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      id localid = (id)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32135);
        return -1;
      case 1: 
        localid.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32135);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localid.FAD = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32135);
        return 0;
      case 3: 
        localid.FAE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32135);
        return 0;
      case 4: 
        localid.FAF = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32135);
        return 0;
      }
      localid.ID = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(32135);
      return 0;
    }
    AppMethodBeat.o(32135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.id
 * JD-Core Version:    0.7.0.1
 */