package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fki
  extends com.tencent.mm.bx.a
{
  public LinkedList<fkj> Ids;
  public LinkedList<fkj> abLk;
  
  public fki()
  {
    AppMethodBeat.i(259370);
    this.Ids = new LinkedList();
    this.abLk = new LinkedList();
    AppMethodBeat.o(259370);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259374);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Ids);
      paramVarArgs.e(2, 8, this.abLk);
      AppMethodBeat.o(259374);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.Ids);
      i = i.a.a.a.c(2, 8, this.abLk);
      AppMethodBeat.o(259374);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ids.clear();
      this.abLk.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259374);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fki localfki = (fki)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fkj localfkj;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259374);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfkj = new fkj();
          if ((localObject != null) && (localObject.length > 0)) {
            localfkj.parseFrom((byte[])localObject);
          }
          localfki.Ids.add(localfkj);
          paramInt += 1;
        }
        AppMethodBeat.o(259374);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localfkj = new fkj();
        if ((localObject != null) && (localObject.length > 0)) {
          localfkj.parseFrom((byte[])localObject);
        }
        localfki.abLk.add(localfkj);
        paramInt += 1;
      }
      AppMethodBeat.o(259374);
      return 0;
    }
    AppMethodBeat.o(259374);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fki
 * JD-Core Version:    0.7.0.1
 */