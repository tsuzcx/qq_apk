package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qa
  extends com.tencent.mm.bx.a
{
  public LinkedList<qb> YUw;
  public String YUx;
  public int YUy;
  
  public qa()
  {
    AppMethodBeat.i(257672);
    this.YUw = new LinkedList();
    AppMethodBeat.o(257672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257675);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YUw);
      if (this.YUx != null) {
        paramVarArgs.g(2, this.YUx);
      }
      paramVarArgs.bS(3, this.YUy);
      AppMethodBeat.o(257675);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YUw) + 0;
      paramInt = i;
      if (this.YUx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YUx);
      }
      i = i.a.a.b.b.a.cJ(3, this.YUy);
      AppMethodBeat.o(257675);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YUw.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257675);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      qa localqa = (qa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257675);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          qb localqb = new qb();
          if ((localObject != null) && (localObject.length > 0)) {
            localqb.parseFrom((byte[])localObject);
          }
          localqa.YUw.add(localqb);
          paramInt += 1;
        }
        AppMethodBeat.o(257675);
        return 0;
      case 2: 
        localqa.YUx = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257675);
        return 0;
      }
      localqa.YUy = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(257675);
      return 0;
    }
    AppMethodBeat.o(257675);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qa
 * JD-Core Version:    0.7.0.1
 */