package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bh
  extends com.tencent.mm.cd.a
{
  public LinkedList<bg> RGi;
  public erh RGj;
  
  public bh()
  {
    AppMethodBeat.i(91343);
    this.RGi = new LinkedList();
    AppMethodBeat.o(91343);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91344);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RGi);
      if (this.RGj != null)
      {
        paramVarArgs.oE(2, this.RGj.computeSize());
        this.RGj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91344);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RGi) + 0;
      paramInt = i;
      if (this.RGj != null) {
        paramInt = i + g.a.a.a.oD(2, this.RGj.computeSize());
      }
      AppMethodBeat.o(91344);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RGi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91344);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bh localbh = (bh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91344);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bg)localObject2).parseFrom((byte[])localObject1);
          }
          localbh.RGi.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91344);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new erh();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((erh)localObject2).parseFrom((byte[])localObject1);
        }
        localbh.RGj = ((erh)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91344);
      return 0;
    }
    AppMethodBeat.o(91344);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */