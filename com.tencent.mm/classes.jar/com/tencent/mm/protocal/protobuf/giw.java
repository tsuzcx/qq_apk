package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class giw
  extends com.tencent.mm.bx.a
{
  public LinkedList<git> acfj;
  public boolean acfk;
  
  public giw()
  {
    AppMethodBeat.i(110861);
    this.acfj = new LinkedList();
    AppMethodBeat.o(110861);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110862);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.acfj);
      paramVarArgs.di(2, this.acfk);
      AppMethodBeat.o(110862);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.acfj);
      i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(110862);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acfj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110862);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      giw localgiw = (giw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110862);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          git localgit = new git();
          if ((localObject != null) && (localObject.length > 0)) {
            localgit.parseFrom((byte[])localObject);
          }
          localgiw.acfj.add(localgit);
          paramInt += 1;
        }
        AppMethodBeat.o(110862);
        return 0;
      }
      localgiw.acfk = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(110862);
      return 0;
    }
    AppMethodBeat.o(110862);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.giw
 * JD-Core Version:    0.7.0.1
 */