package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class om
  extends com.tencent.mm.bv.a
{
  public String wED;
  public String wEE;
  public String wEF;
  public int wEG;
  public ou wEH;
  public int wEI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89024);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wED != null) {
        paramVarArgs.e(1, this.wED);
      }
      if (this.wEE != null) {
        paramVarArgs.e(2, this.wEE);
      }
      if (this.wEF != null) {
        paramVarArgs.e(3, this.wEF);
      }
      paramVarArgs.aO(4, this.wEG);
      if (this.wEH != null)
      {
        paramVarArgs.iQ(5, this.wEH.computeSize());
        this.wEH.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wEI);
      AppMethodBeat.o(89024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wED == null) {
        break label582;
      }
    }
    label582:
    for (int i = e.a.a.b.b.a.f(1, this.wED) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wEE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wEE);
      }
      i = paramInt;
      if (this.wEF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wEF);
      }
      i += e.a.a.b.b.a.bl(4, this.wEG);
      paramInt = i;
      if (this.wEH != null) {
        paramInt = i + e.a.a.a.iP(5, this.wEH.computeSize());
      }
      i = e.a.a.b.b.a.bl(6, this.wEI);
      AppMethodBeat.o(89024);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        om localom = (om)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89024);
          return -1;
        case 1: 
          localom.wED = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89024);
          return 0;
        case 2: 
          localom.wEE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89024);
          return 0;
        case 3: 
          localom.wEF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89024);
          return 0;
        case 4: 
          localom.wEG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89024);
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
            localom.wEH = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89024);
          return 0;
        }
        localom.wEI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89024);
        return 0;
      }
      AppMethodBeat.o(89024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */