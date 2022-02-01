package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnf
  extends com.tencent.mm.bw.a
{
  public cng ETB;
  public String FAq;
  public String content;
  public String hhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168758);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.hhq != null) {
        paramVarArgs.d(2, this.hhq);
      }
      if (this.FAq != null) {
        paramVarArgs.d(3, this.FAq);
      }
      if (this.ETB != null)
      {
        paramVarArgs.ln(4, this.ETB.computeSize());
        this.ETB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hhq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hhq);
      }
      i = paramInt;
      if (this.FAq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FAq);
      }
      paramInt = i;
      if (this.ETB != null) {
        paramInt = i + f.a.a.a.lm(4, this.ETB.computeSize());
      }
      AppMethodBeat.o(168758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnf localcnf = (cnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168758);
          return -1;
        case 1: 
          localcnf.content = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 2: 
          localcnf.hhq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 3: 
          localcnf.FAq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cng();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cng)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnf.ETB = ((cng)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      AppMethodBeat.o(168758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnf
 * JD-Core Version:    0.7.0.1
 */