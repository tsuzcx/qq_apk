package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aci
  extends com.tencent.mm.bw.a
{
  public String KXB;
  public String LmS;
  public long LmT;
  public int LmU;
  public int LmV;
  public LinkedList<ack> LmW;
  
  public aci()
  {
    AppMethodBeat.i(219124);
    this.LmW = new LinkedList();
    AppMethodBeat.o(219124);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219125);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LmS != null) {
        paramVarArgs.e(1, this.LmS);
      }
      if (this.KXB != null) {
        paramVarArgs.e(2, this.KXB);
      }
      paramVarArgs.bb(3, this.LmT);
      paramVarArgs.aM(4, this.LmU);
      paramVarArgs.aM(5, this.LmV);
      paramVarArgs.e(6, 8, this.LmW);
      AppMethodBeat.o(219125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LmS == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.b.b.a.f(1, this.LmS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KXB != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KXB);
      }
      paramInt = g.a.a.b.b.a.r(3, this.LmT);
      int j = g.a.a.b.b.a.bu(4, this.LmU);
      int k = g.a.a.b.b.a.bu(5, this.LmV);
      int m = g.a.a.a.c(6, 8, this.LmW);
      AppMethodBeat.o(219125);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LmW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(219125);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aci localaci = (aci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(219125);
          return -1;
        case 1: 
          localaci.LmS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(219125);
          return 0;
        case 2: 
          localaci.KXB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(219125);
          return 0;
        case 3: 
          localaci.LmT = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(219125);
          return 0;
        case 4: 
          localaci.LmU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(219125);
          return 0;
        case 5: 
          localaci.LmV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(219125);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ack();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ack)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaci.LmW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(219125);
        return 0;
      }
      AppMethodBeat.o(219125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aci
 * JD-Core Version:    0.7.0.1
 */