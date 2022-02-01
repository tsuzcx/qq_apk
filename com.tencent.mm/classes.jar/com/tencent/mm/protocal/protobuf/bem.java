package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bem
  extends com.tencent.mm.cd.a
{
  public bfl Alq;
  public ben SPD;
  public int dataType;
  public FinderObject xcx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208356);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.dataType);
      if (this.SPD != null)
      {
        paramVarArgs.oE(2, this.SPD.computeSize());
        this.SPD.writeFields(paramVarArgs);
      }
      if (this.Alq != null)
      {
        paramVarArgs.oE(3, this.Alq.computeSize());
        this.Alq.writeFields(paramVarArgs);
      }
      if (this.xcx != null)
      {
        paramVarArgs.oE(4, this.xcx.computeSize());
        this.xcx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(208356);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.dataType) + 0;
      paramInt = i;
      if (this.SPD != null) {
        paramInt = i + g.a.a.a.oD(2, this.SPD.computeSize());
      }
      i = paramInt;
      if (this.Alq != null) {
        i = paramInt + g.a.a.a.oD(3, this.Alq.computeSize());
      }
      paramInt = i;
      if (this.xcx != null) {
        paramInt = i + g.a.a.a.oD(4, this.xcx.computeSize());
      }
      AppMethodBeat.o(208356);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208356);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bem localbem = (bem)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(208356);
        return -1;
      case 1: 
        localbem.dataType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208356);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ben();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ben)localObject2).parseFrom((byte[])localObject1);
          }
          localbem.SPD = ((ben)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(208356);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfl)localObject2).parseFrom((byte[])localObject1);
          }
          localbem.Alq = ((bfl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(208356);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new FinderObject();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((FinderObject)localObject2).parseFrom((byte[])localObject1);
        }
        localbem.xcx = ((FinderObject)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(208356);
      return 0;
    }
    AppMethodBeat.o(208356);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bem
 * JD-Core Version:    0.7.0.1
 */