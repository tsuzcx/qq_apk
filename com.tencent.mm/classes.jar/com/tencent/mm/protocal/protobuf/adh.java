package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adh
  extends com.tencent.mm.bx.a
{
  public int ZlT;
  public LinkedList<adg> ZlU;
  
  public adh()
  {
    AppMethodBeat.i(145669);
    this.ZlU = new LinkedList();
    AppMethodBeat.o(145669);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145670);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZlT);
      paramVarArgs.e(2, 8, this.ZlU);
      AppMethodBeat.o(145670);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZlT);
      i = i.a.a.a.c(2, 8, this.ZlU);
      AppMethodBeat.o(145670);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZlU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(145670);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      adh localadh = (adh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145670);
        return -1;
      case 1: 
        localadh.ZlT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(145670);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        adg localadg = new adg();
        if ((localObject != null) && (localObject.length > 0)) {
          localadg.parseFrom((byte[])localObject);
        }
        localadh.ZlU.add(localadg);
        paramInt += 1;
      }
      AppMethodBeat.o(145670);
      return 0;
    }
    AppMethodBeat.o(145670);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adh
 * JD-Core Version:    0.7.0.1
 */