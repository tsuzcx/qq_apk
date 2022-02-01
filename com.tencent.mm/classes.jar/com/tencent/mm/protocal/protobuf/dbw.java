package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbw
  extends com.tencent.mm.bx.a
{
  public dbq aaHm;
  public LinkedList<dbt> aaHn;
  
  public dbw()
  {
    AppMethodBeat.i(259335);
    this.aaHn = new LinkedList();
    AppMethodBeat.o(259335);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259338);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aaHn);
      if (this.aaHm != null)
      {
        paramVarArgs.qD(2, this.aaHm.computeSize());
        this.aaHm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259338);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aaHn) + 0;
      paramInt = i;
      if (this.aaHm != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaHm.computeSize());
      }
      AppMethodBeat.o(259338);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaHn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259338);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dbw localdbw = (dbw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259338);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbt)localObject2).parseFrom((byte[])localObject1);
          }
          localdbw.aaHn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259338);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dbq();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dbq)localObject2).parseFrom((byte[])localObject1);
        }
        localdbw.aaHm = ((dbq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259338);
      return 0;
    }
    AppMethodBeat.o(259338);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbw
 * JD-Core Version:    0.7.0.1
 */