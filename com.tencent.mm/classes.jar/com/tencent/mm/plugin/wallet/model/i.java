package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public LinkedList<j> VlL;
  public b VlM;
  
  public i()
  {
    AppMethodBeat.i(91294);
    this.VlL = new LinkedList();
    AppMethodBeat.o(91294);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91295);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.VlL);
      if (this.VlM != null) {
        paramVarArgs.d(2, this.VlM);
      }
      AppMethodBeat.o(91295);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.VlL) + 0;
      paramInt = i;
      if (this.VlM != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.VlM);
      }
      AppMethodBeat.o(91295);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.VlL.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91295);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91295);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          j localj = new j();
          if ((localObject != null) && (localObject.length > 0)) {
            localj.parseFrom((byte[])localObject);
          }
          locali.VlL.add(localj);
          paramInt += 1;
        }
        AppMethodBeat.o(91295);
        return 0;
      }
      locali.VlM = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(91295);
      return 0;
    }
    AppMethodBeat.o(91295);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.i
 * JD-Core Version:    0.7.0.1
 */