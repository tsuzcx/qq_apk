package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bb
  extends com.tencent.mm.bx.a
{
  public String YCj;
  public LinkedList<dyj> YCk;
  public LinkedList<dyi> hrh;
  
  public bb()
  {
    AppMethodBeat.i(152476);
    this.YCk = new LinkedList();
    this.hrh = new LinkedList();
    AppMethodBeat.o(152476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152477);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YCj != null) {
        paramVarArgs.g(1, this.YCj);
      }
      paramVarArgs.e(2, 8, this.YCk);
      paramVarArgs.e(3, 8, this.hrh);
      AppMethodBeat.o(152477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YCj == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.b.b.a.h(1, this.YCj) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YCk);
      int j = i.a.a.a.c(3, 8, this.hrh);
      AppMethodBeat.o(152477);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YCk.clear();
        this.hrh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152477);
          return -1;
        case 1: 
          localbb.YCj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152477);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyj)localObject2).parseFrom((byte[])localObject1);
            }
            localbb.YCk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152477);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyi)localObject2).parseFrom((byte[])localObject1);
          }
          localbb.hrh.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      AppMethodBeat.o(152477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */