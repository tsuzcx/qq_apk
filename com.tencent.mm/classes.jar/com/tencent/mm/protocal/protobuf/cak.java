package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cak
  extends com.tencent.mm.bw.a
{
  public caj LWF;
  public boolean MfE;
  public String icon;
  public int nHh;
  public String pTn;
  public String pWf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pTn != null) {
        paramVarArgs.e(1, this.pTn);
      }
      if (this.pWf != null) {
        paramVarArgs.e(2, this.pWf);
      }
      if (this.icon != null) {
        paramVarArgs.e(3, this.icon);
      }
      paramVarArgs.cc(4, this.MfE);
      paramVarArgs.aM(5, this.nHh);
      if (this.LWF != null)
      {
        paramVarArgs.ni(6, this.LWF.computeSize());
        this.LWF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pTn == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.pTn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pWf != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pWf);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.icon);
      }
      i = i + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.b.b.a.bu(5, this.nHh);
      paramInt = i;
      if (this.LWF != null) {
        paramInt = i + g.a.a.a.nh(6, this.LWF.computeSize());
      }
      AppMethodBeat.o(72496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cak localcak = (cak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72496);
          return -1;
        case 1: 
          localcak.pTn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 2: 
          localcak.pWf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 3: 
          localcak.icon = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 4: 
          localcak.MfE = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72496);
          return 0;
        case 5: 
          localcak.nHh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72496);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new caj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((caj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcak.LWF = ((caj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      AppMethodBeat.o(72496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cak
 * JD-Core Version:    0.7.0.1
 */