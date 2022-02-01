package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public LinkedList<n> QCT;
  public LinkedList<n> QCU;
  public boolean QCV;
  
  public m()
  {
    AppMethodBeat.i(96162);
    this.QCT = new LinkedList();
    this.QCU = new LinkedList();
    AppMethodBeat.o(96162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96163);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.QCT);
      paramVarArgs.e(2, 8, this.QCU);
      paramVarArgs.di(3, this.QCV);
      AppMethodBeat.o(96163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.QCT);
      i = i.a.a.a.c(2, 8, this.QCU);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(96163);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.QCT.clear();
      this.QCU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(96163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      n localn;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96163);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localn = new n();
          if ((localObject != null) && (localObject.length > 0)) {
            localn.parseFrom((byte[])localObject);
          }
          localm.QCT.add(localn);
          paramInt += 1;
        }
        AppMethodBeat.o(96163);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localn = new n();
          if ((localObject != null) && (localObject.length > 0)) {
            localn.parseFrom((byte[])localObject);
          }
          localm.QCU.add(localn);
          paramInt += 1;
        }
        AppMethodBeat.o(96163);
        return 0;
      }
      localm.QCV = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(96163);
      return 0;
    }
    AppMethodBeat.o(96163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.m
 * JD-Core Version:    0.7.0.1
 */