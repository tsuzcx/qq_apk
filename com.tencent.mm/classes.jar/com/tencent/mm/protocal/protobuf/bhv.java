package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhv
  extends com.tencent.mm.cd.a
{
  public int SSi;
  public bhw SSj;
  public LinkedList<bhw> SSk;
  
  public bhv()
  {
    AppMethodBeat.i(199693);
    this.SSk = new LinkedList();
    AppMethodBeat.o(199693);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169043);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SSi);
      if (this.SSj != null)
      {
        paramVarArgs.oE(2, this.SSj.computeSize());
        this.SSj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.SSk);
      AppMethodBeat.o(169043);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SSi) + 0;
      paramInt = i;
      if (this.SSj != null) {
        paramInt = i + g.a.a.a.oD(2, this.SSj.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.SSk);
      AppMethodBeat.o(169043);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SSk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bhv localbhv = (bhv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      bhw localbhw;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169043);
        return -1;
      case 1: 
        localbhv.SSi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169043);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbhw = new bhw();
          if ((localObject != null) && (localObject.length > 0)) {
            localbhw.parseFrom((byte[])localObject);
          }
          localbhv.SSj = localbhw;
          paramInt += 1;
        }
        AppMethodBeat.o(169043);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localbhw = new bhw();
        if ((localObject != null) && (localObject.length > 0)) {
          localbhw.parseFrom((byte[])localObject);
        }
        localbhv.SSk.add(localbhw);
        paramInt += 1;
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    AppMethodBeat.o(169043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhv
 * JD-Core Version:    0.7.0.1
 */