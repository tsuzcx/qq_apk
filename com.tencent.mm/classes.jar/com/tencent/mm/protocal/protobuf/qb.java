package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qb
  extends com.tencent.mm.bw.a
{
  public LinkedList<ale> GdG;
  public LinkedList<ald> GdH;
  public String GdI;
  public String GdJ;
  public String GdK;
  
  public qb()
  {
    AppMethodBeat.i(91368);
    this.GdG = new LinkedList();
    this.GdH = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GdG);
      paramVarArgs.e(2, 8, this.GdH);
      if (this.GdI != null) {
        paramVarArgs.d(3, this.GdI);
      }
      if (this.GdJ != null) {
        paramVarArgs.d(4, this.GdJ);
      }
      if (this.GdK != null) {
        paramVarArgs.d(5, this.GdK);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GdG) + 0 + f.a.a.a.c(2, 8, this.GdH);
      paramInt = i;
      if (this.GdI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GdI);
      }
      i = paramInt;
      if (this.GdJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GdJ);
      }
      paramInt = i;
      if (this.GdK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GdK);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GdG.clear();
      this.GdH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qb localqb = (qb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ale();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ale)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqb.GdG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ald();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ald)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqb.GdH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localqb.GdI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localqb.GdJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localqb.GdK = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qb
 * JD-Core Version:    0.7.0.1
 */