package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class akh
  extends cpx
{
  public aiu EDL;
  public String EEA;
  public int EEB;
  public long EEy;
  public int EEz;
  public int direction;
  public b lastBuffer;
  public String objectNonceId;
  public long qXP;
  public long qXu;
  public long qXy;
  public String rfC;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.qXP);
      paramVarArgs.aO(3, this.EEy);
      paramVarArgs.aR(4, this.EEz);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aO(6, this.qXu);
      if (this.rfC != null) {
        paramVarArgs.d(7, this.rfC);
      }
      paramVarArgs.aO(8, this.qXy);
      paramVarArgs.aR(9, this.scene);
      paramVarArgs.aR(10, this.direction);
      if (this.EEA != null) {
        paramVarArgs.d(11, this.EEA);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(13, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.EEB);
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.qXP) + f.a.a.b.b.a.p(3, this.EEy) + f.a.a.b.b.a.bx(4, this.EEz);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.qXu);
      paramInt = i;
      if (this.rfC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.rfC);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.qXy) + f.a.a.b.b.a.bx(9, this.scene) + f.a.a.b.b.a.bx(10, this.direction);
      paramInt = i;
      if (this.EEA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EEA);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(13, this.EDL.computeSize());
      }
      i = f.a.a.b.b.a.bx(14, this.EEB);
      AppMethodBeat.o(168973);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akh localakh = (akh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
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
            localakh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localakh.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localakh.EEy = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localakh.EEz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localakh.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localakh.qXu = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localakh.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localakh.qXy = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localakh.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localakh.direction = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localakh.EEA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localakh.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakh.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        }
        localakh.EEB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akh
 * JD-Core Version:    0.7.0.1
 */