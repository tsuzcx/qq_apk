package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfk
  extends com.tencent.mm.bw.a
{
  public eih LOX;
  public String LOY = "";
  public int LOZ = 0;
  public String LPa = "";
  public boolean LPb = false;
  public boolean LPc = false;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LOX != null)
      {
        paramVarArgs.ni(1, this.LOX.computeSize());
        this.LOX.writeFields(paramVarArgs);
      }
      if (this.LPa != null) {
        paramVarArgs.e(2, this.LPa);
      }
      paramVarArgs.cc(3, this.LPb);
      if (this.LOY != null) {
        paramVarArgs.e(4, this.LOY);
      }
      paramVarArgs.cc(5, this.LPc);
      paramVarArgs.bb(6, this.timestamp);
      paramVarArgs.aM(7, this.LOZ);
      AppMethodBeat.o(122493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LOX == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.a.nh(1, this.LOX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LPa != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LPa);
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.LOY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LOY);
      }
      i = g.a.a.b.b.a.fS(5);
      int j = g.a.a.b.b.a.r(6, this.timestamp);
      int k = g.a.a.b.b.a.bu(7, this.LOZ);
      AppMethodBeat.o(122493);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfk localbfk = (bfk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122493);
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
            localbfk.LOX = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122493);
          return 0;
        case 2: 
          localbfk.LPa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 3: 
          localbfk.LPb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122493);
          return 0;
        case 4: 
          localbfk.LOY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 5: 
          localbfk.LPc = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122493);
          return 0;
        case 6: 
          localbfk.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122493);
          return 0;
        }
        localbfk.LOZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122493);
        return 0;
      }
      AppMethodBeat.o(122493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfk
 * JD-Core Version:    0.7.0.1
 */