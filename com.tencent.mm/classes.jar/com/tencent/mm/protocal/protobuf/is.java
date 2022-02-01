package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class is
  extends com.tencent.mm.bx.a
{
  public LinkedList<csm> FBI;
  public der FBJ;
  public String FBs;
  
  public is()
  {
    AppMethodBeat.i(91357);
    this.FBI = new LinkedList();
    AppMethodBeat.o(91357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBs != null) {
        paramVarArgs.d(1, this.FBs);
      }
      paramVarArgs.e(2, 8, this.FBI);
      if (this.FBJ != null)
      {
        paramVarArgs.lC(3, this.FBJ.computeSize());
        this.FBJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBs == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.b.b.a.e(1, this.FBs) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FBI);
      paramInt = i;
      if (this.FBJ != null) {
        paramInt = i + f.a.a.a.lB(3, this.FBJ.computeSize());
      }
      AppMethodBeat.o(91358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FBI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localis.FBs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91358);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localis.FBI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91358);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new der();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((der)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localis.FBJ = ((der)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.is
 * JD-Core Version:    0.7.0.1
 */