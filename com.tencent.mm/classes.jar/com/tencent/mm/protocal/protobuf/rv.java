package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rv
  extends com.tencent.mm.bx.a
{
  public String YDH;
  public int YWG;
  public fvf YWH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YWG);
      if (this.YDH != null) {
        paramVarArgs.g(2, this.YDH);
      }
      if (this.YWH != null)
      {
        paramVarArgs.qD(3, this.YWH.computeSize());
        this.YWH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257481);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YWG) + 0;
      paramInt = i;
      if (this.YDH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YDH);
      }
      i = paramInt;
      if (this.YWH != null) {
        i = paramInt + i.a.a.a.qC(3, this.YWH.computeSize());
      }
      AppMethodBeat.o(257481);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257481);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      rv localrv = (rv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257481);
        return -1;
      case 1: 
        localrv.YWG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257481);
        return 0;
      case 2: 
        localrv.YDH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257481);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fvf localfvf = new fvf();
        if ((localObject != null) && (localObject.length > 0)) {
          localfvf.parseFrom((byte[])localObject);
        }
        localrv.YWH = localfvf;
        paramInt += 1;
      }
      AppMethodBeat.o(257481);
      return 0;
    }
    AppMethodBeat.o(257481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rv
 * JD-Core Version:    0.7.0.1
 */