package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzh
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FTj;
  public int Gru;
  public int qkC;
  public int yxe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Gru);
      paramVarArgs.aS(2, this.qkC);
      paramVarArgs.aS(3, this.yxe);
      if (this.FTj != null)
      {
        paramVarArgs.lJ(4, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gru) + 0 + f.a.a.b.b.a.bz(2, this.qkC) + f.a.a.b.b.a.bz(3, this.yxe);
      paramInt = i;
      if (this.FTj != null) {
        paramInt = i + f.a.a.a.lI(4, this.FTj.computeSize());
      }
      AppMethodBeat.o(115873);
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
      if (this.FTj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dzh localdzh = (dzh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115873);
        return -1;
      case 1: 
        localdzh.Gru = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115873);
        return 0;
      case 2: 
        localdzh.qkC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115873);
        return 0;
      case 3: 
        localdzh.yxe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115873);
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
        localdzh.FTj = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    AppMethodBeat.o(115873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzh
 * JD-Core Version:    0.7.0.1
 */