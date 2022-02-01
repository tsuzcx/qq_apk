package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqh
  extends com.tencent.mm.bw.a
{
  public ze FXs;
  public boolean FXt = true;
  public dpu FXu;
  public String FXv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FXs != null)
      {
        paramVarArgs.ln(1, this.FXs.computeSize());
        this.FXs.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.FXt);
      if (this.FXu != null)
      {
        paramVarArgs.ln(3, this.FXu.computeSize());
        this.FXu.writeFields(paramVarArgs);
      }
      if (this.FXv != null) {
        paramVarArgs.d(4, this.FXv);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FXs == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lm(1, this.FXs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.FXu != null) {
        paramInt = i + f.a.a.a.lm(3, this.FXu.computeSize());
      }
      i = paramInt;
      if (this.FXv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FXv);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqh localdqh = (dqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ze();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqh.FXs = ((ze)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localdqh.FXt = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqh.FXu = ((dpu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localdqh.FXv = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqh
 * JD-Core Version:    0.7.0.1
 */