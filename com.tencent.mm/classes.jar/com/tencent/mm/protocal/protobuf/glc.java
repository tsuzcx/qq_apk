package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class glc
  extends com.tencent.mm.bx.a
{
  public LinkedList<flc> YNp;
  public int acgL;
  
  public glc()
  {
    AppMethodBeat.i(153322);
    this.YNp = new LinkedList();
    AppMethodBeat.o(153322);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153323);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YNp);
      paramVarArgs.bS(2, this.acgL);
      AppMethodBeat.o(153323);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.YNp);
      i = i.a.a.b.b.a.cJ(2, this.acgL);
      AppMethodBeat.o(153323);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YNp.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153323);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      glc localglc = (glc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153323);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          flc localflc = new flc();
          if ((localObject != null) && (localObject.length > 0)) {
            localflc.parseFrom((byte[])localObject);
          }
          localglc.YNp.add(localflc);
          paramInt += 1;
        }
        AppMethodBeat.o(153323);
        return 0;
      }
      localglc.acgL = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(153323);
      return 0;
    }
    AppMethodBeat.o(153323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glc
 * JD-Core Version:    0.7.0.1
 */