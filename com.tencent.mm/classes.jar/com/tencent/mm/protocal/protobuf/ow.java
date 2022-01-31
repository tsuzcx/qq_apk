package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ow
  extends com.tencent.mm.bv.a
{
  public int wFs;
  public String wFt;
  public String wFu;
  public String wFv;
  public int wFw;
  public String wFx;
  public ou wFy;
  public String wFz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89037);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wFs);
      if (this.wFt != null) {
        paramVarArgs.e(2, this.wFt);
      }
      if (this.wFu != null) {
        paramVarArgs.e(3, this.wFu);
      }
      if (this.wFv != null) {
        paramVarArgs.e(4, this.wFv);
      }
      paramVarArgs.aO(5, this.wFw);
      if (this.wFx != null) {
        paramVarArgs.e(6, this.wFx);
      }
      if (this.wFy != null)
      {
        paramVarArgs.iQ(7, this.wFy.computeSize());
        this.wFy.writeFields(paramVarArgs);
      }
      if (this.wFz != null) {
        paramVarArgs.e(8, this.wFz);
      }
      AppMethodBeat.o(89037);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wFs) + 0;
      paramInt = i;
      if (this.wFt != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wFt);
      }
      i = paramInt;
      if (this.wFu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wFu);
      }
      paramInt = i;
      if (this.wFv != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wFv);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wFw);
      paramInt = i;
      if (this.wFx != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wFx);
      }
      i = paramInt;
      if (this.wFy != null) {
        i = paramInt + e.a.a.a.iP(7, this.wFy.computeSize());
      }
      paramInt = i;
      if (this.wFz != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wFz);
      }
      AppMethodBeat.o(89037);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(89037);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ow localow = (ow)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(89037);
        return -1;
      case 1: 
        localow.wFs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89037);
        return 0;
      case 2: 
        localow.wFt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89037);
        return 0;
      case 3: 
        localow.wFu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89037);
        return 0;
      case 4: 
        localow.wFv = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89037);
        return 0;
      case 5: 
        localow.wFw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89037);
        return 0;
      case 6: 
        localow.wFx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89037);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ou();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localow.wFy = ((ou)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89037);
        return 0;
      }
      localow.wFz = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(89037);
      return 0;
    }
    AppMethodBeat.o(89037);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ow
 * JD-Core Version:    0.7.0.1
 */