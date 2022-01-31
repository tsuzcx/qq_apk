package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uf
  extends com.tencent.mm.bv.a
{
  public String wME;
  public String wMF;
  public LinkedList<bde> wMG;
  
  public uf()
  {
    AppMethodBeat.i(2538);
    this.wMG = new LinkedList();
    AppMethodBeat.o(2538);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2539);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wME != null) {
        paramVarArgs.e(1, this.wME);
      }
      if (this.wMF != null) {
        paramVarArgs.e(2, this.wMF);
      }
      paramVarArgs.e(3, 8, this.wMG);
      AppMethodBeat.o(2539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wME == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.wME) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wMF != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wMF);
      }
      paramInt = e.a.a.a.c(3, 8, this.wMG);
      AppMethodBeat.o(2539);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wMG.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(2539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        uf localuf = (uf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(2539);
          return -1;
        case 1: 
          localuf.wME = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2539);
          return 0;
        case 2: 
          localuf.wMF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2539);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bde();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bde)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localuf.wMG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(2539);
        return 0;
      }
      AppMethodBeat.o(2539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uf
 * JD-Core Version:    0.7.0.1
 */