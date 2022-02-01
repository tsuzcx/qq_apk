package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfk
  extends com.tencent.mm.bx.a
{
  public blu EwG;
  public blu EwH;
  public String content;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72616);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      if (this.EwG != null)
      {
        paramVarArgs.kX(3, this.EwG.computeSize());
        this.EwG.writeFields(paramVarArgs);
      }
      if (this.EwH != null)
      {
        paramVarArgs.kX(4, this.EwH.computeSize());
        this.EwH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.content);
      }
      i = paramInt;
      if (this.EwG != null) {
        i = paramInt + f.a.a.a.kW(3, this.EwG.computeSize());
      }
      paramInt = i;
      if (this.EwH != null) {
        paramInt = i + f.a.a.a.kW(4, this.EwH.computeSize());
      }
      AppMethodBeat.o(72616);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfk localdfk = (dfk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72616);
          return -1;
        case 1: 
          localdfk.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 2: 
          localdfk.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfk.EwG = ((blu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72616);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfk.EwH = ((blu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      AppMethodBeat.o(72616);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfk
 * JD-Core Version:    0.7.0.1
 */