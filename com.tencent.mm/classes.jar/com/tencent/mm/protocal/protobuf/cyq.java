package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyq
  extends com.tencent.mm.bw.a
{
  public String MDE;
  public String MDF;
  public String MDG;
  public String MDH;
  public un MDI;
  public String MDJ;
  public int MtC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MDE != null) {
        paramVarArgs.e(1, this.MDE);
      }
      if (this.MDF != null) {
        paramVarArgs.e(2, this.MDF);
      }
      if (this.MDG != null) {
        paramVarArgs.e(3, this.MDG);
      }
      paramVarArgs.aM(4, this.MtC);
      if (this.MDH != null) {
        paramVarArgs.e(5, this.MDH);
      }
      if (this.MDI != null)
      {
        paramVarArgs.ni(6, this.MDI.computeSize());
        this.MDI.writeFields(paramVarArgs);
      }
      if (this.MDJ != null) {
        paramVarArgs.e(7, this.MDJ);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MDE == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.b.b.a.f(1, this.MDE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MDF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MDF);
      }
      i = paramInt;
      if (this.MDG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MDG);
      }
      i += g.a.a.b.b.a.bu(4, this.MtC);
      paramInt = i;
      if (this.MDH != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MDH);
      }
      i = paramInt;
      if (this.MDI != null) {
        i = paramInt + g.a.a.a.nh(6, this.MDI.computeSize());
      }
      paramInt = i;
      if (this.MDJ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MDJ);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyq localcyq = (cyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localcyq.MDE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localcyq.MDF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localcyq.MDG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localcyq.MtC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localcyq.MDH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyq.MDI = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localcyq.MDJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyq
 * JD-Core Version:    0.7.0.1
 */