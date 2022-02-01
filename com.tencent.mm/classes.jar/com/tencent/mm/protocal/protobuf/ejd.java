package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejd
  extends com.tencent.mm.bx.a
{
  public cyw abnT;
  public agp abnU;
  public rw abnV;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258477);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.wuj);
      if (this.abnT != null)
      {
        paramVarArgs.qD(2, this.abnT.computeSize());
        this.abnT.writeFields(paramVarArgs);
      }
      if (this.abnU != null)
      {
        paramVarArgs.qD(3, this.abnU.computeSize());
        this.abnU.writeFields(paramVarArgs);
      }
      if (this.abnV != null)
      {
        paramVarArgs.qD(4, this.abnV.computeSize());
        this.abnV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258477);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.wuj) + 0;
      paramInt = i;
      if (this.abnT != null) {
        paramInt = i + i.a.a.a.qC(2, this.abnT.computeSize());
      }
      i = paramInt;
      if (this.abnU != null) {
        i = paramInt + i.a.a.a.qC(3, this.abnU.computeSize());
      }
      paramInt = i;
      if (this.abnV != null) {
        paramInt = i + i.a.a.a.qC(4, this.abnV.computeSize());
      }
      AppMethodBeat.o(258477);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258477);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ejd localejd = (ejd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258477);
        return -1;
      case 1: 
        localejd.wuj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258477);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cyw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cyw)localObject2).parseFrom((byte[])localObject1);
          }
          localejd.abnT = ((cyw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258477);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new agp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((agp)localObject2).parseFrom((byte[])localObject1);
          }
          localejd.abnU = ((agp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258477);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new rw();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((rw)localObject2).parseFrom((byte[])localObject1);
        }
        localejd.abnV = ((rw)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258477);
      return 0;
    }
    AppMethodBeat.o(258477);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejd
 * JD-Core Version:    0.7.0.1
 */