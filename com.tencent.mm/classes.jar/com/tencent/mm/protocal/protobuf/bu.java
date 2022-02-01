package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bu
  extends com.tencent.mm.bx.a
{
  public LinkedList<fme> YDy;
  public bs YDz;
  
  public bu()
  {
    AppMethodBeat.i(122483);
    this.YDy = new LinkedList();
    AppMethodBeat.o(122483);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122484);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YDy);
      if (this.YDz != null)
      {
        paramVarArgs.qD(2, this.YDz.computeSize());
        this.YDz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122484);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YDy) + 0;
      paramInt = i;
      if (this.YDz != null) {
        paramInt = i + i.a.a.a.qC(2, this.YDz.computeSize());
      }
      AppMethodBeat.o(122484);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YDy.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122484);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bu localbu = (bu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122484);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fme();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fme)localObject2).parseFrom((byte[])localObject1);
          }
          localbu.YDy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122484);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bs();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bs)localObject2).parseFrom((byte[])localObject1);
        }
        localbu.YDz = ((bs)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(122484);
      return 0;
    }
    AppMethodBeat.o(122484);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bu
 * JD-Core Version:    0.7.0.1
 */