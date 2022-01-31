package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public String content;
  public int pII;
  public String pIJ;
  public LinkedList<o> pIK;
  public LinkedList<o> pIL;
  public LinkedList<o> pIM;
  public LinkedList<ai> pIN;
  public String pIO;
  public int pIP;
  
  public j()
  {
    AppMethodBeat.i(67931);
    this.pIK = new LinkedList();
    this.pIL = new LinkedList();
    this.pIM = new LinkedList();
    this.pIN = new LinkedList();
    this.pIP = 5;
    AppMethodBeat.o(67931);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(67932);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(67932);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.pII);
      if (this.pIJ != null) {
        paramVarArgs.e(2, this.pIJ);
      }
      paramVarArgs.e(3, 8, this.pIK);
      paramVarArgs.e(4, 8, this.pIL);
      paramVarArgs.e(5, 8, this.pIM);
      paramVarArgs.e(6, 8, this.pIN);
      if (this.pIO != null) {
        paramVarArgs.e(7, this.pIO);
      }
      if (this.content != null) {
        paramVarArgs.e(8, this.content);
      }
      paramVarArgs.aO(9, this.pIP);
      AppMethodBeat.o(67932);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pII) + 0;
      paramInt = i;
      if (this.pIJ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.pIJ);
      }
      i = paramInt + e.a.a.a.c(3, 8, this.pIK) + e.a.a.a.c(4, 8, this.pIL) + e.a.a.a.c(5, 8, this.pIM) + e.a.a.a.c(6, 8, this.pIN);
      paramInt = i;
      if (this.pIO != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.pIO);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.content);
      }
      paramInt = e.a.a.b.b.a.bl(9, this.pIP);
      AppMethodBeat.o(67932);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.pIK.clear();
      this.pIL.clear();
      this.pIM.clear();
      this.pIN.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(67932);
        throw paramVarArgs;
      }
      AppMethodBeat.o(67932);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(67932);
        return -1;
      case 1: 
        localj.pII = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(67932);
        return 0;
      case 2: 
        localj.pIJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(67932);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localj.pIK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(67932);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localj.pIL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(67932);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localj.pIM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(67932);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ai();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localj.pIN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(67932);
        return 0;
      case 7: 
        localj.pIO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(67932);
        return 0;
      case 8: 
        localj.content = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(67932);
        return 0;
      }
      localj.pIP = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(67932);
      return 0;
    }
    AppMethodBeat.o(67932);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.j
 * JD-Core Version:    0.7.0.1
 */