package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nn
  extends com.tencent.mm.bv.a
{
  public int knS;
  public int state;
  public String text;
  public int wCB;
  public awf wCC;
  public uc wCD;
  public bvz wna;
  public String wug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48784);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.state);
      if (this.wna != null)
      {
        paramVarArgs.iQ(2, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wCB);
      if (this.wCC != null)
      {
        paramVarArgs.iQ(4, this.wCC.computeSize());
        this.wCC.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.e(5, this.text);
      }
      if (this.wug != null) {
        paramVarArgs.e(6, this.wug);
      }
      paramVarArgs.aO(7, this.knS);
      if (this.wCD != null)
      {
        paramVarArgs.iQ(8, this.wCD.computeSize());
        this.wCD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.state) + 0;
      paramInt = i;
      if (this.wna != null) {
        paramInt = i + e.a.a.a.iP(2, this.wna.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wCB);
      paramInt = i;
      if (this.wCC != null) {
        paramInt = i + e.a.a.a.iP(4, this.wCC.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.text);
      }
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wug);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.knS);
      paramInt = i;
      if (this.wCD != null) {
        paramInt = i + e.a.a.a.iP(8, this.wCD.computeSize());
      }
      AppMethodBeat.o(48784);
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
      AppMethodBeat.o(48784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      nn localnn = (nn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48784);
        return -1;
      case 1: 
        localnn.state = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48784);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnn.wna = ((bvz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48784);
        return 0;
      case 3: 
        localnn.wCB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48784);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnn.wCC = ((awf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48784);
        return 0;
      case 5: 
        localnn.text = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48784);
        return 0;
      case 6: 
        localnn.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48784);
        return 0;
      case 7: 
        localnn.knS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48784);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new uc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((uc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localnn.wCD = ((uc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48784);
      return 0;
    }
    AppMethodBeat.o(48784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nn
 * JD-Core Version:    0.7.0.1
 */