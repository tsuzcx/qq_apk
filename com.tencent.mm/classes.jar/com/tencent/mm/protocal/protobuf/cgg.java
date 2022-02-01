package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgg
  extends com.tencent.mm.bw.a
{
  public int EPO;
  public String EPP;
  public String EPQ;
  public dkl Fus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EPO);
      if (this.EPP != null) {
        paramVarArgs.d(2, this.EPP);
      }
      if (this.EPQ != null) {
        paramVarArgs.d(3, this.EPQ);
      }
      if (this.Fus != null)
      {
        paramVarArgs.ln(4, this.Fus.computeSize());
        this.Fus.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EPO) + 0;
      paramInt = i;
      if (this.EPP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EPP);
      }
      i = paramInt;
      if (this.EPQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EPQ);
      }
      paramInt = i;
      if (this.Fus != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fus.computeSize());
      }
      AppMethodBeat.o(32369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cgg localcgg = (cgg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localcgg.EPO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localcgg.EPP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localcgg.EPQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dkl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dkl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcgg.Fus = ((dkl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgg
 * JD-Core Version:    0.7.0.1
 */