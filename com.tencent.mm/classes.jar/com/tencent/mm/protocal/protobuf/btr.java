package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class btr
  extends com.tencent.mm.bw.a
{
  public long Fhw;
  public LinkedList<b> FiP;
  public blc FiQ;
  public long FiR;
  public long cZM;
  public long id;
  
  public btr()
  {
    AppMethodBeat.i(110903);
    this.FiP = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      paramVarArgs.e(2, 6, this.FiP);
      if (this.FiQ != null)
      {
        paramVarArgs.ln(3, this.FiQ.computeSize());
        this.FiQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.cZM);
      paramVarArgs.aO(5, this.Fhw);
      paramVarArgs.aO(6, this.FiR);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.id) + 0 + f.a.a.a.c(2, 6, this.FiP);
      paramInt = i;
      if (this.FiQ != null) {
        paramInt = i + f.a.a.a.lm(3, this.FiQ.computeSize());
      }
      i = f.a.a.b.b.a.p(4, this.cZM);
      int j = f.a.a.b.b.a.p(5, this.Fhw);
      int k = f.a.a.b.b.a.p(6, this.FiR);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FiP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      btr localbtr = (btr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localbtr.id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localbtr.FiP.add(((f.a.a.a.a)localObject1).LVo.gfk());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((blc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbtr.FiQ = ((blc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localbtr.cZM = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localbtr.Fhw = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110904);
        return 0;
      }
      localbtr.FiR = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btr
 * JD-Core Version:    0.7.0.1
 */