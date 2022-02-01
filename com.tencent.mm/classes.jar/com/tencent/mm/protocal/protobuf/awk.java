package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awk
  extends cpx
{
  public LinkedList<String> EOu;
  public int scene;
  
  public awk()
  {
    AppMethodBeat.i(114025);
    this.EOu = new LinkedList();
    AppMethodBeat.o(114025);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114026);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.EOu);
      paramVarArgs.aR(3, this.scene);
      AppMethodBeat.o(114026);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.EOu);
      int j = f.a.a.b.b.a.bx(3, this.scene);
      AppMethodBeat.o(114026);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EOu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114026);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awk localawk = (awk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114026);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114026);
          return 0;
        case 2: 
          localawk.EOu.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(114026);
          return 0;
        }
        localawk.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114026);
        return 0;
      }
      AppMethodBeat.o(114026);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awk
 * JD-Core Version:    0.7.0.1
 */