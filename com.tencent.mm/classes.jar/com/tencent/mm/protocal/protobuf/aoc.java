package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class aoc
  extends com.tencent.mm.bx.a
{
  public String Dpj;
  public LinkedList<String> Dpn;
  public LinkedList<aod> Dpo;
  
  public aoc()
  {
    AppMethodBeat.i(190801);
    this.Dpn = new LinkedList();
    this.Dpo = new LinkedList();
    AppMethodBeat.o(190801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dpj != null) {
        paramVarArgs.d(1, this.Dpj);
      }
      paramVarArgs.e(2, 1, this.Dpn);
      paramVarArgs.e(3, 8, this.Dpo);
      AppMethodBeat.o(190802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dpj == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dpj) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.Dpn);
      int j = f.a.a.a.c(3, 8, this.Dpo);
      AppMethodBeat.o(190802);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dpn.clear();
        this.Dpo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(190802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoc localaoc = (aoc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190802);
          return -1;
        case 1: 
          localaoc.Dpj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(190802);
          return 0;
        case 2: 
          localaoc.Dpn.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(190802);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aod();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoc.Dpo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190802);
        return 0;
      }
      AppMethodBeat.o(190802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoc
 * JD-Core Version:    0.7.0.1
 */