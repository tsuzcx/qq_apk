package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oi
  extends com.tencent.mm.bv.a
{
  public String name;
  public LinkedList<vp> wDJ;
  public int wDK;
  public String wDL;
  public String wki;
  
  public oi()
  {
    AppMethodBeat.i(28351);
    this.wDJ = new LinkedList();
    AppMethodBeat.o(28351);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28352);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wDJ);
      if (this.wki != null) {
        paramVarArgs.e(2, this.wki);
      }
      paramVarArgs.aO(3, this.wDK);
      if (this.wDL != null) {
        paramVarArgs.e(4, this.wDL);
      }
      if (this.name != null) {
        paramVarArgs.e(5, this.name);
      }
      AppMethodBeat.o(28352);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.wDJ) + 0;
      paramInt = i;
      if (this.wki != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wki);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wDK);
      paramInt = i;
      if (this.wDL != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wDL);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.name);
      }
      AppMethodBeat.o(28352);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wDJ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28352);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      oi localoi = (oi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28352);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((vp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoi.wDJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28352);
        return 0;
      case 2: 
        localoi.wki = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28352);
        return 0;
      case 3: 
        localoi.wDK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28352);
        return 0;
      case 4: 
        localoi.wDL = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28352);
        return 0;
      }
      localoi.name = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(28352);
      return 0;
    }
    AppMethodBeat.o(28352);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oi
 * JD-Core Version:    0.7.0.1
 */