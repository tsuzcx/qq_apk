package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awi
  extends com.tencent.mm.bw.a
{
  public awg LGn;
  public int LHa;
  public int LHb;
  public int LHc;
  public String description;
  public int extFlag;
  public String id;
  public int iqg;
  public int trl;
  public int ugF;
  public int uhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209529);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      paramVarArgs.aM(2, this.LHa);
      paramVarArgs.aM(3, this.iqg);
      paramVarArgs.aM(4, this.LHb);
      if (this.description != null) {
        paramVarArgs.e(5, this.description);
      }
      if (this.LGn != null)
      {
        paramVarArgs.ni(6, this.LGn.computeSize());
        this.LGn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.ugF);
      paramVarArgs.aM(8, this.trl);
      paramVarArgs.aM(9, this.uhE);
      paramVarArgs.aM(10, this.extFlag);
      paramVarArgs.aM(11, this.LHc);
      AppMethodBeat.o(209529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LHa) + g.a.a.b.b.a.bu(3, this.iqg) + g.a.a.b.b.a.bu(4, this.LHb);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.description);
      }
      i = paramInt;
      if (this.LGn != null) {
        i = paramInt + g.a.a.a.nh(6, this.LGn.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(7, this.ugF);
      int j = g.a.a.b.b.a.bu(8, this.trl);
      int k = g.a.a.b.b.a.bu(9, this.uhE);
      int m = g.a.a.b.b.a.bu(10, this.extFlag);
      int n = g.a.a.b.b.a.bu(11, this.LHc);
      AppMethodBeat.o(209529);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awi localawi = (awi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209529);
          return -1;
        case 1: 
          localawi.id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209529);
          return 0;
        case 2: 
          localawi.LHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        case 3: 
          localawi.iqg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        case 4: 
          localawi.LHb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        case 5: 
          localawi.description = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209529);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((awg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawi.LGn = ((awg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209529);
          return 0;
        case 7: 
          localawi.ugF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        case 8: 
          localawi.trl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        case 9: 
          localawi.uhE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        case 10: 
          localawi.extFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209529);
          return 0;
        }
        localawi.LHc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209529);
        return 0;
      }
      AppMethodBeat.o(209529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awi
 * JD-Core Version:    0.7.0.1
 */