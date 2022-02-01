package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhm
  extends com.tencent.mm.cd.a
{
  public int UHt;
  public fht UHu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258176);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UHt);
      if (this.UHu != null)
      {
        paramVarArgs.oE(2, this.UHu.computeSize());
        this.UHu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258176);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UHt) + 0;
      paramInt = i;
      if (this.UHu != null) {
        paramInt = i + g.a.a.a.oD(2, this.UHu.computeSize());
      }
      AppMethodBeat.o(258176);
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
      AppMethodBeat.o(258176);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fhm localfhm = (fhm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258176);
        return -1;
      case 1: 
        localfhm.UHt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(258176);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fht localfht = new fht();
        if ((localObject != null) && (localObject.length > 0)) {
          localfht.parseFrom((byte[])localObject);
        }
        localfhm.UHu = localfht;
        paramInt += 1;
      }
      AppMethodBeat.o(258176);
      return 0;
    }
    AppMethodBeat.o(258176);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhm
 * JD-Core Version:    0.7.0.1
 */