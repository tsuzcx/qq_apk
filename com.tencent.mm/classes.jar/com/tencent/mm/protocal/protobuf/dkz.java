package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dkz
  extends com.tencent.mm.bw.a
{
  public dqi MOT;
  public int MOU;
  public LinkedList<dsn> MOV;
  
  public dkz()
  {
    AppMethodBeat.i(6420);
    this.MOV = new LinkedList();
    AppMethodBeat.o(6420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: GroupName");
        AppMethodBeat.o(6421);
        throw paramVarArgs;
      }
      if (this.MOT != null)
      {
        paramVarArgs.ni(1, this.MOT.computeSize());
        this.MOT.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MOU);
      paramVarArgs.e(3, 8, this.MOV);
      AppMethodBeat.o(6421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MOT == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = g.a.a.a.nh(1, this.MOT.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MOU);
      int j = g.a.a.a.c(3, 8, this.MOV);
      AppMethodBeat.o(6421);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MOV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: GroupName");
          AppMethodBeat.o(6421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkz localdkz = (dkz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6421);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdkz.MOT = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6421);
          return 0;
        case 2: 
          localdkz.MOU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6421);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dsn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dsn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdkz.MOV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      AppMethodBeat.o(6421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkz
 * JD-Core Version:    0.7.0.1
 */