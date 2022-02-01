package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class arg
  extends com.tencent.mm.bw.a
{
  public String EKj;
  public LinkedList<String> EKn;
  public LinkedList<arh> EKo;
  
  public arg()
  {
    AppMethodBeat.i(192709);
    this.EKn = new LinkedList();
    this.EKo = new LinkedList();
    AppMethodBeat.o(192709);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKj != null) {
        paramVarArgs.d(1, this.EKj);
      }
      paramVarArgs.e(2, 1, this.EKn);
      paramVarArgs.e(3, 8, this.EKo);
      AppMethodBeat.o(192710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKj == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.EKj) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.EKn);
      int j = f.a.a.a.c(3, 8, this.EKo);
      AppMethodBeat.o(192710);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EKn.clear();
        this.EKo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(192710);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arg localarg = (arg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192710);
          return -1;
        case 1: 
          localarg.EKj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(192710);
          return 0;
        case 2: 
          localarg.EKn.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(192710);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((arh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarg.EKo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192710);
        return 0;
      }
      AppMethodBeat.o(192710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arg
 * JD-Core Version:    0.7.0.1
 */