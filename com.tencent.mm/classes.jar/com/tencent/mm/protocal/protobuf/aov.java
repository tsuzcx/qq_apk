package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aov
  extends com.tencent.mm.bw.a
{
  public int LAQ;
  public b LAR;
  public int LAS;
  public aas LAT;
  public int scene;
  public long ulj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LAQ);
      paramVarArgs.aM(2, this.scene);
      if (this.LAR != null) {
        paramVarArgs.c(3, this.LAR);
      }
      paramVarArgs.aM(4, this.LAS);
      if (this.LAT != null)
      {
        paramVarArgs.ni(5, this.LAT.computeSize());
        this.LAT.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.ulj);
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LAQ) + 0 + g.a.a.b.b.a.bu(2, this.scene);
      paramInt = i;
      if (this.LAR != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LAR);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LAS);
      paramInt = i;
      if (this.LAT != null) {
        paramInt = i + g.a.a.a.nh(5, this.LAT.computeSize());
      }
      i = g.a.a.b.b.a.r(6, this.ulj);
      AppMethodBeat.o(168937);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aov localaov = (aov)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localaov.LAQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localaov.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localaov.LAR = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localaov.LAS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168937);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aas();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aas)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaov.LAT = ((aas)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168937);
        return 0;
      }
      localaov.ulj = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aov
 * JD-Core Version:    0.7.0.1
 */