package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.cd.a
{
  public LinkedList<n> Kfm;
  public LinkedList<n> Kfn;
  public boolean Kfo;
  
  public m()
  {
    AppMethodBeat.i(96162);
    this.Kfm = new LinkedList();
    this.Kfn = new LinkedList();
    AppMethodBeat.o(96162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96163);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Kfm);
      paramVarArgs.e(2, 8, this.Kfn);
      paramVarArgs.co(3, this.Kfo);
      AppMethodBeat.o(96163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.Kfm);
      i = g.a.a.a.c(2, 8, this.Kfn);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(96163);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Kfm.clear();
      this.Kfn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(96163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      n localn;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96163);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localn = new n();
          if ((localObject != null) && (localObject.length > 0)) {
            localn.parseFrom((byte[])localObject);
          }
          localm.Kfm.add(localn);
          paramInt += 1;
        }
        AppMethodBeat.o(96163);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localn = new n();
          if ((localObject != null) && (localObject.length > 0)) {
            localn.parseFrom((byte[])localObject);
          }
          localm.Kfn.add(localn);
          paramInt += 1;
        }
        AppMethodBeat.o(96163);
        return 0;
      }
      localm.Kfo = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(96163);
      return 0;
    }
    AppMethodBeat.o(96163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.m
 * JD-Core Version:    0.7.0.1
 */