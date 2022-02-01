package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amx
  extends com.tencent.mm.bx.a
{
  public int IHj;
  public int IJG;
  public LinkedList<ftf> ZtR;
  public int ZtS;
  public boolean ZtT;
  
  public amx()
  {
    AppMethodBeat.i(104763);
    this.ZtR = new LinkedList();
    this.ZtT = false;
    this.IHj = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZtR);
      paramVarArgs.bS(2, this.ZtS);
      paramVarArgs.di(3, this.ZtT);
      paramVarArgs.bS(4, this.IHj);
      paramVarArgs.bS(5, this.IJG);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZtR);
      i = i.a.a.b.b.a.cJ(2, this.ZtS);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.cJ(4, this.IHj);
      int m = i.a.a.b.b.a.cJ(5, this.IJG);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + (j + 1) + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZtR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      amx localamx = (amx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ftf localftf = new ftf();
          if ((localObject != null) && (localObject.length > 0)) {
            localftf.parseFrom((byte[])localObject);
          }
          localamx.ZtR.add(localftf);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localamx.ZtS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localamx.ZtT = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localamx.IHj = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104764);
        return 0;
      }
      localamx.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amx
 * JD-Core Version:    0.7.0.1
 */