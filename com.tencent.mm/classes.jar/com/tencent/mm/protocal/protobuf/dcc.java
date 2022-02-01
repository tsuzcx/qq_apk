package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcc
  extends com.tencent.mm.bw.a
{
  public LinkedList<cid> HKC;
  public LinkedList<dwy> HKD;
  public String duQ;
  
  public dcc()
  {
    AppMethodBeat.i(122536);
    this.duQ = "";
    this.HKC = new LinkedList();
    this.HKD = new LinkedList();
    AppMethodBeat.o(122536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duQ != null) {
        paramVarArgs.d(1, this.duQ);
      }
      paramVarArgs.e(2, 8, this.HKC);
      paramVarArgs.e(3, 8, this.HKD);
      AppMethodBeat.o(122537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duQ == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.b.b.a.e(1, this.duQ) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.HKC);
      int j = f.a.a.a.c(3, 8, this.HKD);
      AppMethodBeat.o(122537);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKC.clear();
        this.HKD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcc localdcc = (dcc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122537);
          return -1;
        case 1: 
          localdcc.duQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122537);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cid();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcc.HKC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122537);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcc.HKD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      AppMethodBeat.o(122537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcc
 * JD-Core Version:    0.7.0.1
 */