package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xx
  extends com.tencent.mm.bw.a
{
  public String ErN;
  public String ErO;
  public LinkedList<bul> ErP;
  
  public xx()
  {
    AppMethodBeat.i(116467);
    this.ErP = new LinkedList();
    AppMethodBeat.o(116467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ErN != null) {
        paramVarArgs.d(1, this.ErN);
      }
      if (this.ErO != null) {
        paramVarArgs.d(2, this.ErO);
      }
      paramVarArgs.e(3, 8, this.ErP);
      AppMethodBeat.o(116468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ErN == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.ErN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ErO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ErO);
      }
      paramInt = f.a.a.a.c(3, 8, this.ErP);
      AppMethodBeat.o(116468);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ErP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xx localxx = (xx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116468);
          return -1;
        case 1: 
          localxx.ErN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116468);
          return 0;
        case 2: 
          localxx.ErO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116468);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bul();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bul)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localxx.ErP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      AppMethodBeat.o(116468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xx
 * JD-Core Version:    0.7.0.1
 */