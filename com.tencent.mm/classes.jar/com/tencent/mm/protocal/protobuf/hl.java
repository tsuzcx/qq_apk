package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hl
  extends com.tencent.mm.bv.a
{
  public String title;
  public bvz wna;
  public String wug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48778);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.wna != null)
      {
        paramVarArgs.iQ(2, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      if (this.wug != null) {
        paramVarArgs.e(3, this.wug);
      }
      AppMethodBeat.o(48778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label430;
      }
    }
    label430:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wna != null) {
        paramInt = i + e.a.a.a.iP(2, this.wna.computeSize());
      }
      i = paramInt;
      if (this.wug != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wug);
      }
      AppMethodBeat.o(48778);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        hl localhl = (hl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48778);
          return -1;
        case 1: 
          localhl.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48778);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhl.wna = ((bvz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48778);
          return 0;
        }
        localhl.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48778);
        return 0;
      }
      AppMethodBeat.o(48778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */