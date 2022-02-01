package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnc
  extends com.tencent.mm.bw.a
{
  public String EQe;
  public dhb Ete;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.EQe != null) {
        paramVarArgs.d(2, this.EQe);
      }
      if (this.Ete != null)
      {
        paramVarArgs.ln(3, this.Ete.computeSize());
        this.Ete.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.EQe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EQe);
      }
      i = paramInt;
      if (this.Ete != null) {
        i = paramInt + f.a.a.a.lm(3, this.Ete.computeSize());
      }
      AppMethodBeat.o(91664);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cnc localcnc = (cnc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localcnc.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localcnc.EQe = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dhb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcnc.Ete = ((dhb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnc
 * JD-Core Version:    0.7.0.1
 */