package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afq
  extends com.tencent.mm.bx.a
{
  public LinkedList<afp> YFR;
  public long ZnD;
  public long ZnE;
  public int ZoG;
  public int ZoH;
  
  public afq()
  {
    AppMethodBeat.i(90962);
    this.YFR = new LinkedList();
    AppMethodBeat.o(90962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90963);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnD);
      paramVarArgs.bv(2, this.ZnE);
      paramVarArgs.e(3, 8, this.YFR);
      paramVarArgs.bS(4, this.ZoG);
      paramVarArgs.bS(5, this.ZoH);
      AppMethodBeat.o(90963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.ZnD);
      i = i.a.a.b.b.a.q(2, this.ZnE);
      int j = i.a.a.a.c(3, 8, this.YFR);
      int k = i.a.a.b.b.a.cJ(4, this.ZoG);
      int m = i.a.a.b.b.a.cJ(5, this.ZoH);
      AppMethodBeat.o(90963);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YFR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(90963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      afq localafq = (afq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90963);
        return -1;
      case 1: 
        localafq.ZnD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(90963);
        return 0;
      case 2: 
        localafq.ZnE = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(90963);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          afp localafp = new afp();
          if ((localObject != null) && (localObject.length > 0)) {
            localafp.parseFrom((byte[])localObject);
          }
          localafq.YFR.add(localafp);
          paramInt += 1;
        }
        AppMethodBeat.o(90963);
        return 0;
      case 4: 
        localafq.ZoG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(90963);
        return 0;
      }
      localafq.ZoH = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(90963);
      return 0;
    }
    AppMethodBeat.o(90963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afq
 * JD-Core Version:    0.7.0.1
 */