package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crb
  extends erp
{
  public int aaxJ;
  public int aaxK;
  public wy aaxL;
  public long aaxM;
  public acz aaxN;
  public int aaxO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaxJ);
      paramVarArgs.bS(3, this.aaxK);
      if (this.aaxL != null)
      {
        paramVarArgs.qD(4, this.aaxL.computeSize());
        this.aaxL.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.aaxM);
      if (this.aaxN != null)
      {
        paramVarArgs.qD(6, this.aaxN.computeSize());
        this.aaxN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.aaxO);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaxJ) + i.a.a.b.b.a.cJ(3, this.aaxK);
      paramInt = i;
      if (this.aaxL != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaxL.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.aaxM);
      paramInt = i;
      if (this.aaxN != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaxN.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.aaxO);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        crb localcrb = (crb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcrb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localcrb.aaxJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localcrb.aaxK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wy)localObject2).parseFrom((byte[])localObject1);
            }
            localcrb.aaxL = ((wy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localcrb.aaxM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acz)localObject2).parseFrom((byte[])localObject1);
            }
            localcrb.aaxN = ((acz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localcrb.aaxO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crb
 * JD-Core Version:    0.7.0.1
 */