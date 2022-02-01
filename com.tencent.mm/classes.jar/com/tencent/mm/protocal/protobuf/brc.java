package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brc
  extends com.tencent.mm.bw.a
{
  public dqk Fgj;
  public aoz Fgk;
  public dqk Fgl;
  public int cSh;
  public int hbI;
  public int height;
  public int retryCount;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fgj != null)
      {
        paramVarArgs.ln(1, this.Fgj.computeSize());
        this.Fgj.writeFields(paramVarArgs);
      }
      if (this.Fgk != null)
      {
        paramVarArgs.ln(2, this.Fgk.computeSize());
        this.Fgk.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.cSh);
      paramVarArgs.aR(4, this.hbI);
      paramVarArgs.aR(5, this.width);
      paramVarArgs.aR(6, this.height);
      if (this.Fgl != null)
      {
        paramVarArgs.ln(7, this.Fgl.computeSize());
        this.Fgl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.retryCount);
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fgj == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.a.lm(1, this.Fgj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fgk != null) {
        i = paramInt + f.a.a.a.lm(2, this.Fgk.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.cSh) + f.a.a.b.b.a.bx(4, this.hbI) + f.a.a.b.b.a.bx(5, this.width) + f.a.a.b.b.a.bx(6, this.height);
      paramInt = i;
      if (this.Fgl != null) {
        paramInt = i + f.a.a.a.lm(7, this.Fgl.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.retryCount);
      AppMethodBeat.o(169087);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brc localbrc = (brc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrc.Fgj = ((dqk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrc.Fgk = ((aoz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localbrc.cSh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localbrc.hbI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localbrc.width = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localbrc.height = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrc.Fgl = ((dqk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        }
        localbrc.retryCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brc
 * JD-Core Version:    0.7.0.1
 */