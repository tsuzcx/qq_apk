package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cg
  extends com.tencent.mm.bw.a
{
  public cv FNf;
  public String FNg;
  public b FNh;
  public boolean FNi;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220220);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNf != null)
      {
        paramVarArgs.lJ(1, this.FNf.computeSize());
        this.FNf.writeFields(paramVarArgs);
      }
      if (this.FNg != null) {
        paramVarArgs.d(2, this.FNg);
      }
      paramVarArgs.aZ(3, this.seq);
      if (this.FNh != null) {
        paramVarArgs.c(4, this.FNh);
      }
      paramVarArgs.bC(5, this.FNi);
      AppMethodBeat.o(220220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNf == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lI(1, this.FNf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FNg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FNg);
      }
      i += f.a.a.b.b.a.p(3, this.seq);
      paramInt = i;
      if (this.FNh != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FNh);
      }
      i = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(220220);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(220220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220220);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcg.FNf = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220220);
          return 0;
        case 2: 
          localcg.FNg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220220);
          return 0;
        case 3: 
          localcg.seq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(220220);
          return 0;
        case 4: 
          localcg.FNh = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(220220);
          return 0;
        }
        localcg.FNi = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(220220);
        return 0;
      }
      AppMethodBeat.o(220220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */