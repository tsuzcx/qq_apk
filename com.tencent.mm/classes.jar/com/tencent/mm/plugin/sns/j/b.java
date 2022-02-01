package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int DRJ;
  public cnb ebR;
  public int iXu;
  public String parentId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96151);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ebR != null)
      {
        paramVarArgs.ni(1, this.ebR.computeSize());
        this.ebR.writeFields(paramVarArgs);
      }
      if (this.parentId != null) {
        paramVarArgs.e(2, this.parentId);
      }
      paramVarArgs.aM(3, this.iXu);
      paramVarArgs.aM(4, this.DRJ);
      AppMethodBeat.o(96151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ebR == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.a.nh(1, this.ebR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.parentId != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.parentId);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.iXu);
      int j = g.a.a.b.b.a.bu(4, this.DRJ);
      AppMethodBeat.o(96151);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(96151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96151);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.ebR = ((cnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96151);
          return 0;
        case 2: 
          localb.parentId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(96151);
          return 0;
        case 3: 
          localb.iXu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(96151);
          return 0;
        }
        localb.DRJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(96151);
        return 0;
      }
      AppMethodBeat.o(96151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.b
 * JD-Core Version:    0.7.0.1
 */