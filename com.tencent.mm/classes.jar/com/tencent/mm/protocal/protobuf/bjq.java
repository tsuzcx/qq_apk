package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjq
  extends com.tencent.mm.cd.a
{
  public bjv STU;
  public avr STV;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200234);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.STU != null)
      {
        paramVarArgs.oE(2, this.STU.computeSize());
        this.STU.writeFields(paramVarArgs);
      }
      if (this.STV != null)
      {
        paramVarArgs.oE(3, this.STV.computeSize());
        this.STV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200234);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.STU != null) {
        paramInt = i + g.a.a.a.oD(2, this.STU.computeSize());
      }
      i = paramInt;
      if (this.STV != null) {
        i = paramInt + g.a.a.a.oD(3, this.STV.computeSize());
      }
      AppMethodBeat.o(200234);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200234);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bjq localbjq = (bjq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200234);
        return -1;
      case 1: 
        localbjq.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(200234);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjv)localObject2).parseFrom((byte[])localObject1);
          }
          localbjq.STU = ((bjv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200234);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new avr();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((avr)localObject2).parseFrom((byte[])localObject1);
        }
        localbjq.STV = ((avr)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(200234);
      return 0;
    }
    AppMethodBeat.o(200234);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjq
 * JD-Core Version:    0.7.0.1
 */