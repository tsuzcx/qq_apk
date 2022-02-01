package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcg
  extends com.tencent.mm.bx.a
{
  public LinkedList<FinderObject> ZIQ;
  public FinderJumpInfo ZNm;
  
  public bcg()
  {
    AppMethodBeat.i(259350);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(259350);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259353);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZIQ);
      if (this.ZNm != null)
      {
        paramVarArgs.qD(2, this.ZNm.computeSize());
        this.ZNm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259353);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZIQ) + 0;
      paramInt = i;
      if (this.ZNm != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZNm.computeSize());
      }
      AppMethodBeat.o(259353);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZIQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259353);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bcg localbcg = (bcg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259353);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbcg.ZIQ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259353);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new FinderJumpInfo();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
        }
        localbcg.ZNm = ((FinderJumpInfo)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259353);
      return 0;
    }
    AppMethodBeat.o(259353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcg
 * JD-Core Version:    0.7.0.1
 */