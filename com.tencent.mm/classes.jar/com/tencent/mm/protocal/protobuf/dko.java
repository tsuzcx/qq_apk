package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dko
  extends com.tencent.mm.bw.a
{
  public long HRo;
  public SKBuiltinBuffer_t HSr;
  public int gvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118463);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSr == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.HRo);
      paramVarArgs.aS(2, this.gvx);
      if (this.HSr != null)
      {
        paramVarArgs.lJ(3, this.HSr.computeSize());
        this.HSr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HRo) + 0 + f.a.a.b.b.a.bz(2, this.gvx);
      paramInt = i;
      if (this.HSr != null) {
        paramInt = i + f.a.a.a.lI(3, this.HSr.computeSize());
      }
      AppMethodBeat.o(118463);
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
      if (this.HSr == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dko localdko = (dko)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118463);
        return -1;
      case 1: 
        localdko.HRo = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(118463);
        return 0;
      case 2: 
        localdko.gvx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118463);
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
        localdko.HSr = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    AppMethodBeat.o(118463);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dko
 * JD-Core Version:    0.7.0.1
 */