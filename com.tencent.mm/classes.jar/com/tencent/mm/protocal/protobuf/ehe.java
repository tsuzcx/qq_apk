package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ehe
  extends com.tencent.mm.bw.a
{
  public fbr Lsr;
  public long NgO;
  public long NgP;
  public long NgQ;
  public long NgR;
  public LinkedList<b> NgS;
  public long begin_time;
  public long duration;
  public String text;
  
  public ehe()
  {
    AppMethodBeat.i(110911);
    this.NgS = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lsr != null)
      {
        paramVarArgs.ni(1, this.Lsr.computeSize());
        this.Lsr.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.begin_time);
      paramVarArgs.bb(3, this.duration);
      if (this.text != null) {
        paramVarArgs.e(4, this.text);
      }
      paramVarArgs.bb(5, this.NgO);
      paramVarArgs.bb(6, this.NgP);
      paramVarArgs.bb(7, this.NgQ);
      paramVarArgs.bb(8, this.NgR);
      paramVarArgs.e(9, 6, this.NgS);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lsr == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = g.a.a.a.nh(1, this.Lsr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.begin_time) + g.a.a.b.b.a.r(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.text);
      }
      i = g.a.a.b.b.a.r(5, this.NgO);
      int j = g.a.a.b.b.a.r(6, this.NgP);
      int k = g.a.a.b.b.a.r(7, this.NgQ);
      int m = g.a.a.b.b.a.r(8, this.NgR);
      int n = g.a.a.a.c(9, 6, this.NgS);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NgS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ehe localehe = (ehe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fbr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fbr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localehe.Lsr = ((fbr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localehe.begin_time = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localehe.duration = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localehe.text = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localehe.NgO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localehe.NgP = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localehe.NgQ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localehe.NgR = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110912);
          return 0;
        }
        localehe.NgS.add(((g.a.a.a.a)localObject1).UbS.hPo());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehe
 * JD-Core Version:    0.7.0.1
 */