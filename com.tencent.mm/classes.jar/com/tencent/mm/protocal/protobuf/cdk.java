package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdk
  extends com.tencent.mm.bw.a
{
  public int Fse;
  public SKBuiltinBuffer_t Fsf;
  public int Fsg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fse);
      if (this.Fsf != null)
      {
        paramVarArgs.ln(2, this.Fsf.computeSize());
        this.Fsf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Fsg);
      AppMethodBeat.o(134248);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Fse) + 0;
      paramInt = i;
      if (this.Fsf != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fsf.computeSize());
      }
      i = f.a.a.b.b.a.bx(3, this.Fsg);
      AppMethodBeat.o(134248);
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
      AppMethodBeat.o(134248);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdk localcdk = (cdk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134248);
        return -1;
      case 1: 
        localcdk.Fse = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(134248);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdk.Fsf = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134248);
        return 0;
      }
      localcdk.Fsg = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(134248);
      return 0;
    }
    AppMethodBeat.o(134248);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdk
 * JD-Core Version:    0.7.0.1
 */