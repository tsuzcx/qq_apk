package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfj
  extends com.tencent.mm.bw.a
{
  public eih LOX;
  public String LOY = "";
  public int LOZ = 0;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LOX != null)
      {
        paramVarArgs.ni(1, this.LOX.computeSize());
        this.LOX.writeFields(paramVarArgs);
      }
      if (this.LOY != null) {
        paramVarArgs.e(2, this.LOY);
      }
      paramVarArgs.bb(3, this.timestamp);
      paramVarArgs.aM(4, this.LOZ);
      AppMethodBeat.o(122492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LOX == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.a.nh(1, this.LOX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LOY != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LOY);
      }
      paramInt = g.a.a.b.b.a.r(3, this.timestamp);
      int j = g.a.a.b.b.a.bu(4, this.LOZ);
      AppMethodBeat.o(122492);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfj localbfj = (bfj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122492);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfj.LOX = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122492);
          return 0;
        case 2: 
          localbfj.LOY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122492);
          return 0;
        case 3: 
          localbfj.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122492);
          return 0;
        }
        localbfj.LOZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122492);
        return 0;
      }
      AppMethodBeat.o(122492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfj
 * JD-Core Version:    0.7.0.1
 */