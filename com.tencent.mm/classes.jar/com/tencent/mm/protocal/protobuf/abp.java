package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abp
  extends com.tencent.mm.bw.a
{
  public String Lmu;
  public String Lmv;
  public LinkedList<cow> Lmw;
  
  public abp()
  {
    AppMethodBeat.i(116467);
    this.Lmw = new LinkedList();
    AppMethodBeat.o(116467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116468);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lmu != null) {
        paramVarArgs.e(1, this.Lmu);
      }
      if (this.Lmv != null) {
        paramVarArgs.e(2, this.Lmv);
      }
      paramVarArgs.e(3, 8, this.Lmw);
      AppMethodBeat.o(116468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lmu == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lmu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lmv != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lmv);
      }
      paramInt = g.a.a.a.c(3, 8, this.Lmw);
      AppMethodBeat.o(116468);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lmw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        abp localabp = (abp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116468);
          return -1;
        case 1: 
          localabp.Lmu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116468);
          return 0;
        case 2: 
          localabp.Lmv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116468);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cow();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cow)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localabp.Lmw.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abp
 * JD-Core Version:    0.7.0.1
 */