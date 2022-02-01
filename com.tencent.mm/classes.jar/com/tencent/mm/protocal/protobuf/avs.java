package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class avs
  extends com.tencent.mm.bw.a
{
  public String GMJ;
  public LinkedList<String> GMN;
  public LinkedList<avt> GMO;
  
  public avs()
  {
    AppMethodBeat.i(218924);
    this.GMN = new LinkedList();
    this.GMO = new LinkedList();
    AppMethodBeat.o(218924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GMJ != null) {
        paramVarArgs.d(1, this.GMJ);
      }
      paramVarArgs.e(2, 1, this.GMN);
      paramVarArgs.e(3, 8, this.GMO);
      AppMethodBeat.o(218925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GMJ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.GMJ) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.GMN);
      int j = f.a.a.a.c(3, 8, this.GMO);
      AppMethodBeat.o(218925);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GMN.clear();
        this.GMO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avs localavs = (avs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218925);
          return -1;
        case 1: 
          localavs.GMJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218925);
          return 0;
        case 2: 
          localavs.GMN.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(218925);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavs.GMO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(218925);
        return 0;
      }
      AppMethodBeat.o(218925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avs
 * JD-Core Version:    0.7.0.1
 */