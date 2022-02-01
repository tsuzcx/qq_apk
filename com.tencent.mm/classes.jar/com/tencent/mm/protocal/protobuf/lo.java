package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lo
  extends com.tencent.mm.bx.a
{
  public LinkedList<ln> YNf;
  public lm YNg;
  public int YNh;
  
  public lo()
  {
    AppMethodBeat.i(82389);
    this.YNf = new LinkedList();
    AppMethodBeat.o(82389);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82390);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YNf);
      if (this.YNg != null)
      {
        paramVarArgs.qD(2, this.YNg.computeSize());
        this.YNg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YNh);
      AppMethodBeat.o(82390);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YNf) + 0;
      paramInt = i;
      if (this.YNg != null) {
        paramInt = i + i.a.a.a.qC(2, this.YNg.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.YNh);
      AppMethodBeat.o(82390);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YNf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(82390);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      lo locallo = (lo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82390);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ln();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ln)localObject2).parseFrom((byte[])localObject1);
          }
          locallo.YNf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82390);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new lm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((lm)localObject2).parseFrom((byte[])localObject1);
          }
          locallo.YNg = ((lm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82390);
        return 0;
      }
      locallo.YNh = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(82390);
      return 0;
    }
    AppMethodBeat.o(82390);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lo
 * JD-Core Version:    0.7.0.1
 */