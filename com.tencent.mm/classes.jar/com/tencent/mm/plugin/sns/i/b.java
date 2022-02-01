package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btz;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public btz dwE;
  public int hGU;
  public String yav;
  public int yax;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96151);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwE != null)
      {
        paramVarArgs.ln(1, this.dwE.computeSize());
        this.dwE.writeFields(paramVarArgs);
      }
      if (this.yav != null) {
        paramVarArgs.d(2, this.yav);
      }
      paramVarArgs.aR(3, this.hGU);
      paramVarArgs.aR(4, this.yax);
      AppMethodBeat.o(96151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwE == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.lm(1, this.dwE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yav != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yav);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.hGU);
      int j = f.a.a.b.b.a.bx(4, this.yax);
      AppMethodBeat.o(96151);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(96151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96151);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((btz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.dwE = ((btz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96151);
          return 0;
        case 2: 
          localb.yav = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(96151);
          return 0;
        case 3: 
          localb.hGU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(96151);
          return 0;
        }
        localb.yax = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(96151);
        return 0;
      }
      AppMethodBeat.o(96151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.b
 * JD-Core Version:    0.7.0.1
 */