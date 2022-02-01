package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bjf
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public SKBuiltinBuffer_t DVs;
  public long EYr;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32320);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.EYr);
      paramVarArgs.aR(2, this.CreateTime);
      if (this.DVs != null)
      {
        paramVarArgs.ln(3, this.DVs.computeSize());
        this.DVs.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.ndI);
      AppMethodBeat.o(32320);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.EYr) + 0 + f.a.a.b.b.a.bx(2, this.CreateTime);
      paramInt = i;
      if (this.DVs != null) {
        paramInt = i + f.a.a.a.lm(3, this.DVs.computeSize());
      }
      i = f.a.a.b.b.a.bx(4, this.ndI);
      AppMethodBeat.o(32320);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DVs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32320);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bjf localbjf = (bjf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32320);
        return -1;
      case 1: 
        localbjf.EYr = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32320);
        return 0;
      case 2: 
        localbjf.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32320);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjf.DVs = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32320);
        return 0;
      }
      localbjf.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(32320);
      return 0;
    }
    AppMethodBeat.o(32320);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjf
 * JD-Core Version:    0.7.0.1
 */