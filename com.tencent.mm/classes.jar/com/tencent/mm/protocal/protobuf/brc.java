package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brc
  extends com.tencent.mm.bx.a
{
  public LinkedList<brd> nUC;
  public String title;
  
  public brc()
  {
    AppMethodBeat.i(257412);
    this.nUC = new LinkedList();
    AppMethodBeat.o(257412);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257420);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.e(2, 8, this.nUC);
      AppMethodBeat.o(257420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.nUC);
      AppMethodBeat.o(257420);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        brc localbrc = (brc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257420);
          return -1;
        case 1: 
          localbrc.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257420);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          brd localbrd = new brd();
          if ((localObject != null) && (localObject.length > 0)) {
            localbrd.parseFrom((byte[])localObject);
          }
          localbrc.nUC.add(localbrd);
          paramInt += 1;
        }
        AppMethodBeat.o(257420);
        return 0;
      }
      AppMethodBeat.o(257420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brc
 * JD-Core Version:    0.7.0.1
 */