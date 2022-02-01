package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gd
  extends com.tencent.mm.bx.a
{
  public LinkedList<dtq> YHU;
  public String vYn;
  
  public gd()
  {
    AppMethodBeat.i(258062);
    this.YHU = new LinkedList();
    AppMethodBeat.o(258062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258065);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YHU);
      if (this.vYn != null) {
        paramVarArgs.g(2, this.vYn);
      }
      AppMethodBeat.o(258065);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YHU) + 0;
      paramInt = i;
      if (this.vYn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vYn);
      }
      AppMethodBeat.o(258065);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YHU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258065);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gd localgd = (gd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258065);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dtq localdtq = new dtq();
          if ((localObject != null) && (localObject.length > 0)) {
            localdtq.parseFrom((byte[])localObject);
          }
          localgd.YHU.add(localdtq);
          paramInt += 1;
        }
        AppMethodBeat.o(258065);
        return 0;
      }
      localgd.vYn = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258065);
      return 0;
    }
    AppMethodBeat.o(258065);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gd
 * JD-Core Version:    0.7.0.1
 */