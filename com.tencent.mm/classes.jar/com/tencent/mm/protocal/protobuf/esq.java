package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esq
  extends com.tencent.mm.bx.a
{
  public LinkedList<dol> abwj;
  public String title;
  
  public esq()
  {
    AppMethodBeat.i(72583);
    this.abwj = new LinkedList();
    AppMethodBeat.o(72583);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72584);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abwj);
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      AppMethodBeat.o(72584);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abwj) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      AppMethodBeat.o(72584);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abwj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(72584);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      esq localesq = (esq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72584);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dol localdol = new dol();
          if ((localObject != null) && (localObject.length > 0)) {
            localdol.parseFrom((byte[])localObject);
          }
          localesq.abwj.add(localdol);
          paramInt += 1;
        }
        AppMethodBeat.o(72584);
        return 0;
      }
      localesq.title = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(72584);
      return 0;
    }
    AppMethodBeat.o(72584);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esq
 * JD-Core Version:    0.7.0.1
 */