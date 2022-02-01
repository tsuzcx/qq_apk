package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afy
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FSl;
  public int Gwi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133169);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Gwi);
      if (this.FSl != null)
      {
        paramVarArgs.lJ(2, this.FSl.computeSize());
        this.FSl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gwi) + 0;
      paramInt = i;
      if (this.FSl != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSl.computeSize());
      }
      AppMethodBeat.o(133169);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FSl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133169);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afy localafy = (afy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133169);
        return -1;
      case 1: 
        localafy.Gwi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133169);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localafy.FSl = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    AppMethodBeat.o(133169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afy
 * JD-Core Version:    0.7.0.1
 */