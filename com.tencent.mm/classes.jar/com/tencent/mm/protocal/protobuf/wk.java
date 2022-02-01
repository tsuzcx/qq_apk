package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wk
  extends cpx
{
  public String Eee;
  public dqp EqI;
  public int Scene;
  public String tlJ;
  public String tlK;
  public int vTH;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32166);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eee != null) {
        paramVarArgs.d(2, this.Eee);
      }
      paramVarArgs.aR(3, this.vTH);
      paramVarArgs.aR(4, this.vTO);
      if (this.EqI != null)
      {
        paramVarArgs.ln(5, this.EqI.computeSize());
        this.EqI.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.vTQ);
      paramVarArgs.aR(7, this.Scene);
      if (this.tlK != null) {
        paramVarArgs.d(8, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(9, this.tlJ);
      }
      AppMethodBeat.o(32166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eee != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eee);
      }
      i = i + f.a.a.b.b.a.bx(3, this.vTH) + f.a.a.b.b.a.bx(4, this.vTO);
      paramInt = i;
      if (this.EqI != null) {
        paramInt = i + f.a.a.a.lm(5, this.EqI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.vTQ) + f.a.a.b.b.a.bx(7, this.Scene);
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.tlJ);
      }
      AppMethodBeat.o(32166);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wk localwk = (wk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32166);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 2: 
          localwk.Eee = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32166);
          return 0;
        case 3: 
          localwk.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32166);
          return 0;
        case 4: 
          localwk.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32166);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwk.EqI = ((dqp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 6: 
          localwk.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32166);
          return 0;
        case 7: 
          localwk.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32166);
          return 0;
        case 8: 
          localwk.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32166);
          return 0;
        }
        localwk.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32166);
        return 0;
      }
      AppMethodBeat.o(32166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wk
 * JD-Core Version:    0.7.0.1
 */