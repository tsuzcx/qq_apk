package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmp
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public LinkedList<fml> abMT;
  
  public fmp()
  {
    AppMethodBeat.i(91714);
    this.abMT = new LinkedList();
    AppMethodBeat.o(91714);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91715);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abMT);
      if (this.YMe != null) {
        paramVarArgs.g(2, this.YMe);
      }
      AppMethodBeat.o(91715);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abMT) + 0;
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YMe);
      }
      AppMethodBeat.o(91715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abMT.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91715);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fmp localfmp = (fmp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91715);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fml localfml = new fml();
          if ((localObject != null) && (localObject.length > 0)) {
            localfml.parseFrom((byte[])localObject);
          }
          localfmp.abMT.add(localfml);
          paramInt += 1;
        }
        AppMethodBeat.o(91715);
        return 0;
      }
      localfmp.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91715);
      return 0;
    }
    AppMethodBeat.o(91715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmp
 * JD-Core Version:    0.7.0.1
 */