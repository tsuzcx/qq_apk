package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class is
  extends com.tencent.mm.bw.a
{
  public String FTN;
  public LinkedList<ctg> FUd;
  public dfl FUe;
  
  public is()
  {
    AppMethodBeat.i(91357);
    this.FUd = new LinkedList();
    AppMethodBeat.o(91357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTN != null) {
        paramVarArgs.d(1, this.FTN);
      }
      paramVarArgs.e(2, 8, this.FUd);
      if (this.FUe != null)
      {
        paramVarArgs.lJ(3, this.FUe.computeSize());
        this.FUe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FTN == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.b.b.a.e(1, this.FTN) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FUd);
      paramInt = i;
      if (this.FUe != null) {
        paramInt = i + f.a.a.a.lI(3, this.FUe.computeSize());
      }
      AppMethodBeat.o(91358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        is localis = (is)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91358);
          return -1;
        case 1: 
          localis.FTN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91358);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localis.FUd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91358);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localis.FUe = ((dfl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      AppMethodBeat.o(91358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.is
 * JD-Core Version:    0.7.0.1
 */