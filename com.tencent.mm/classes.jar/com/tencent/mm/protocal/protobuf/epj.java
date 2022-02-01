package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epj
  extends com.tencent.mm.cd.a
{
  public LinkedList<epk> Crl;
  public LinkedList<epk> Ush;
  
  public epj()
  {
    AppMethodBeat.i(203041);
    this.Crl = new LinkedList();
    this.Ush = new LinkedList();
    AppMethodBeat.o(203041);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203055);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Crl);
      paramVarArgs.e(2, 8, this.Ush);
      AppMethodBeat.o(203055);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.Crl);
      i = g.a.a.a.c(2, 8, this.Ush);
      AppMethodBeat.o(203055);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Crl.clear();
      this.Ush.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203055);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      epj localepj = (epj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      epk localepk;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203055);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localepk = new epk();
          if ((localObject != null) && (localObject.length > 0)) {
            localepk.parseFrom((byte[])localObject);
          }
          localepj.Crl.add(localepk);
          paramInt += 1;
        }
        AppMethodBeat.o(203055);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localepk = new epk();
        if ((localObject != null) && (localObject.length > 0)) {
          localepk.parseFrom((byte[])localObject);
        }
        localepj.Ush.add(localepk);
        paramInt += 1;
      }
      AppMethodBeat.o(203055);
      return 0;
    }
    AppMethodBeat.o(203055);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epj
 * JD-Core Version:    0.7.0.1
 */