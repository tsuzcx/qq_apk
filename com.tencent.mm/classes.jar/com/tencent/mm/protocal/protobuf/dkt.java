package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkt
  extends com.tencent.mm.bw.a
{
  public ait MOJ;
  public String MOK;
  public String MOL;
  public int MOM;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MOJ != null)
      {
        paramVarArgs.ni(1, this.MOJ.computeSize());
        this.MOJ.writeFields(paramVarArgs);
      }
      if (this.MOK != null) {
        paramVarArgs.e(2, this.MOK);
      }
      paramVarArgs.aM(3, this.type);
      if (this.MOL != null) {
        paramVarArgs.e(4, this.MOL);
      }
      paramVarArgs.aM(5, this.MOM);
      AppMethodBeat.o(104830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MOJ == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.nh(1, this.MOJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MOK != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MOK);
      }
      i += g.a.a.b.b.a.bu(3, this.type);
      paramInt = i;
      if (this.MOL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MOL);
      }
      i = g.a.a.b.b.a.bu(5, this.MOM);
      AppMethodBeat.o(104830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkt localdkt = (dkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104830);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ait();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ait)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdkt.MOJ = ((ait)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104830);
          return 0;
        case 2: 
          localdkt.MOK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104830);
          return 0;
        case 3: 
          localdkt.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104830);
          return 0;
        case 4: 
          localdkt.MOL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104830);
          return 0;
        }
        localdkt.MOM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104830);
        return 0;
      }
      AppMethodBeat.o(104830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkt
 * JD-Core Version:    0.7.0.1
 */