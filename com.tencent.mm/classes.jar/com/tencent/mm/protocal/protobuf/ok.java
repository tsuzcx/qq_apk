package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ok
  extends com.tencent.mm.bv.a
{
  public String wEk;
  public String wEl;
  public String wEm;
  public int wEn;
  public ou wEo;
  public int wEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89021);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wEk != null) {
        paramVarArgs.e(1, this.wEk);
      }
      if (this.wEl != null) {
        paramVarArgs.e(2, this.wEl);
      }
      if (this.wEm != null) {
        paramVarArgs.e(3, this.wEm);
      }
      paramVarArgs.aO(4, this.wEn);
      if (this.wEo != null)
      {
        paramVarArgs.iQ(5, this.wEo.computeSize());
        this.wEo.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wEp);
      AppMethodBeat.o(89021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wEk == null) {
        break label582;
      }
    }
    label582:
    for (int i = e.a.a.b.b.a.f(1, this.wEk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wEl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wEl);
      }
      i = paramInt;
      if (this.wEm != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wEm);
      }
      i += e.a.a.b.b.a.bl(4, this.wEn);
      paramInt = i;
      if (this.wEo != null) {
        paramInt = i + e.a.a.a.iP(5, this.wEo.computeSize());
      }
      i = e.a.a.b.b.a.bl(6, this.wEp);
      AppMethodBeat.o(89021);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ok localok = (ok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89021);
          return -1;
        case 1: 
          localok.wEk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89021);
          return 0;
        case 2: 
          localok.wEl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89021);
          return 0;
        case 3: 
          localok.wEm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89021);
          return 0;
        case 4: 
          localok.wEn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89021);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ou();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localok.wEo = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89021);
          return 0;
        }
        localok.wEp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89021);
        return 0;
      }
      AppMethodBeat.o(89021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ok
 * JD-Core Version:    0.7.0.1
 */