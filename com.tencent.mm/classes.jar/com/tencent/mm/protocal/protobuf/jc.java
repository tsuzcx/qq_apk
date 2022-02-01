package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jc
  extends com.tencent.mm.cd.a
{
  public eae ROY;
  public int dataType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.dataType);
      if (this.ROY != null)
      {
        paramVarArgs.oE(2, this.ROY.computeSize());
        this.ROY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.dataType) + 0;
      paramInt = i;
      if (this.ROY != null) {
        paramInt = i + g.a.a.a.oD(2, this.ROY.computeSize());
      }
      AppMethodBeat.o(140925);
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
      AppMethodBeat.o(140925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      jc localjc = (jc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(140925);
        return -1;
      case 1: 
        localjc.dataType = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(140925);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eae localeae = new eae();
        if ((localObject != null) && (localObject.length > 0)) {
          localeae.dd((byte[])localObject);
        }
        localjc.ROY = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(140925);
      return 0;
    }
    AppMethodBeat.o(140925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jc
 * JD-Core Version:    0.7.0.1
 */