package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dha
  extends com.tencent.mm.bw.a
{
  public dzi EwB;
  public long FQe;
  public long FQf;
  public long FQg;
  public long FQh;
  public LinkedList<b> FQi;
  public long begin_time;
  public long duration;
  public String text;
  
  public dha()
  {
    AppMethodBeat.i(110911);
    this.FQi = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EwB != null)
      {
        paramVarArgs.ln(1, this.EwB.computeSize());
        this.EwB.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.begin_time);
      paramVarArgs.aO(3, this.duration);
      if (this.text != null) {
        paramVarArgs.d(4, this.text);
      }
      paramVarArgs.aO(5, this.FQe);
      paramVarArgs.aO(6, this.FQf);
      paramVarArgs.aO(7, this.FQg);
      paramVarArgs.aO(8, this.FQh);
      paramVarArgs.e(9, 6, this.FQi);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EwB == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lm(1, this.EwB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.begin_time) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.text);
      }
      i = f.a.a.b.b.a.p(5, this.FQe);
      int j = f.a.a.b.b.a.p(6, this.FQf);
      int k = f.a.a.b.b.a.p(7, this.FQg);
      int m = f.a.a.b.b.a.p(8, this.FQh);
      int n = f.a.a.a.c(9, 6, this.FQi);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FQi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dha localdha = (dha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdha.EwB = ((dzi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localdha.begin_time = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localdha.duration = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localdha.text = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localdha.FQe = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localdha.FQf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localdha.FQg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localdha.FQh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110912);
          return 0;
        }
        localdha.FQi.add(((f.a.a.a.a)localObject1).LVo.gfk());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dha
 * JD-Core Version:    0.7.0.1
 */