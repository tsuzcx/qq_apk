package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public LinkedList<l> QCM;
  public long QCN;
  public long QxZ;
  
  public k()
  {
    AppMethodBeat.i(179119);
    this.QCM = new LinkedList();
    AppMethodBeat.o(179119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179120);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.QCM);
      paramVarArgs.bv(2, this.QCN);
      paramVarArgs.bv(3, this.QxZ);
      AppMethodBeat.o(179120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.QCM);
      i = i.a.a.b.b.a.q(2, this.QCN);
      int j = i.a.a.b.b.a.q(3, this.QxZ);
      AppMethodBeat.o(179120);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.QCM.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(179120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(179120);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          l locall = new l();
          if ((localObject != null) && (localObject.length > 0)) {
            locall.parseFrom((byte[])localObject);
          }
          localk.QCM.add(locall);
          paramInt += 1;
        }
        AppMethodBeat.o(179120);
        return 0;
      case 2: 
        localk.QCN = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(179120);
        return 0;
      }
      localk.QxZ = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(179120);
      return 0;
    }
    AppMethodBeat.o(179120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.k
 * JD-Core Version:    0.7.0.1
 */