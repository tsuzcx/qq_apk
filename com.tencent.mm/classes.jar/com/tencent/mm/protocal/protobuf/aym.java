package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aym
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String opC;
  public String opD;
  public int pdt;
  public String title;
  public boolean xog;
  public bsx xoh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56846);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pdt);
      paramVarArgs.aS(2, this.xog);
      if (this.cyA != null) {
        paramVarArgs.e(3, this.cyA);
      }
      if (this.opC != null) {
        paramVarArgs.e(4, this.opC);
      }
      if (this.opD != null) {
        paramVarArgs.e(5, this.opD);
      }
      if (this.xoh != null)
      {
        paramVarArgs.iQ(6, this.xoh.computeSize());
        this.xoh.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(7, this.title);
      }
      AppMethodBeat.o(56846);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pdt) + 0 + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.cyA);
      }
      i = paramInt;
      if (this.opC != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.opC);
      }
      paramInt = i;
      if (this.opD != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.opD);
      }
      i = paramInt;
      if (this.xoh != null) {
        i = paramInt + e.a.a.a.iP(6, this.xoh.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.title);
      }
      AppMethodBeat.o(56846);
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
      AppMethodBeat.o(56846);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      aym localaym = (aym)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56846);
        return -1;
      case 1: 
        localaym.pdt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56846);
        return 0;
      case 2: 
        localaym.xog = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(56846);
        return 0;
      case 3: 
        localaym.cyA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56846);
        return 0;
      case 4: 
        localaym.opC = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56846);
        return 0;
      case 5: 
        localaym.opD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56846);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaym.xoh = ((bsx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56846);
        return 0;
      }
      localaym.title = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56846);
      return 0;
    }
    AppMethodBeat.o(56846);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aym
 * JD-Core Version:    0.7.0.1
 */