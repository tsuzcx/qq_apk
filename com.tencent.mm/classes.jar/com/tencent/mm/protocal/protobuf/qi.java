package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qi
  extends com.tencent.mm.bx.a
{
  public long YVd;
  public LinkedList<czv> YVe;
  
  public qi()
  {
    AppMethodBeat.i(258033);
    this.YVd = 0L;
    this.YVe = new LinkedList();
    AppMethodBeat.o(258033);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258037);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YVd);
      paramVarArgs.e(2, 8, this.YVe);
      AppMethodBeat.o(258037);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.YVd);
      i = i.a.a.a.c(2, 8, this.YVe);
      AppMethodBeat.o(258037);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YVe.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258037);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      qi localqi = (qi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258037);
        return -1;
      case 1: 
        localqi.YVd = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258037);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        czv localczv = new czv();
        if ((localObject != null) && (localObject.length > 0)) {
          localczv.parseFrom((byte[])localObject);
        }
        localqi.YVe.add(localczv);
        paramInt += 1;
      }
      AppMethodBeat.o(258037);
      return 0;
    }
    AppMethodBeat.o(258037);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qi
 * JD-Core Version:    0.7.0.1
 */