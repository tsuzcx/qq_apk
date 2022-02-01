package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ekx
  extends erp
{
  public jw Zjm;
  public int ZkA;
  public int ZkB;
  public int abpI;
  public b abpJ;
  public b abpK;
  public b abpL;
  public int abpM;
  public eky abpN;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zjm != null)
      {
        paramVarArgs.qD(2, this.Zjm.computeSize());
        this.Zjm.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abpI);
      if (this.abpJ != null) {
        paramVarArgs.d(4, this.abpJ);
      }
      if (this.abpK != null) {
        paramVarArgs.d(5, this.abpK);
      }
      if (this.abpL != null) {
        paramVarArgs.d(6, this.abpL);
      }
      paramVarArgs.bS(7, this.ZkB);
      paramVarArgs.bS(8, this.ZkA);
      paramVarArgs.bS(9, this.abpM);
      paramVarArgs.bv(10, this.timestamp);
      if (this.abpN != null)
      {
        paramVarArgs.qD(11, this.abpN.computeSize());
        this.abpN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label956;
      }
    }
    label956:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zjm != null) {
        i = paramInt + i.a.a.a.qC(2, this.Zjm.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.abpI);
      paramInt = i;
      if (this.abpJ != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.abpJ);
      }
      i = paramInt;
      if (this.abpK != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.abpK);
      }
      paramInt = i;
      if (this.abpL != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.abpL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZkB) + i.a.a.b.b.a.cJ(8, this.ZkA) + i.a.a.b.b.a.cJ(9, this.abpM) + i.a.a.b.b.a.q(10, this.timestamp);
      paramInt = i;
      if (this.abpN != null) {
        paramInt = i + i.a.a.a.qC(11, this.abpN.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ekx localekx = (ekx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
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
            localekx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jw)localObject2).parseFrom((byte[])localObject1);
            }
            localekx.Zjm = ((jw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localekx.abpI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localekx.abpJ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localekx.abpK = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localekx.abpL = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localekx.ZkB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localekx.ZkA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localekx.abpM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localekx.timestamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eky();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eky)localObject2).parseFrom((byte[])localObject1);
          }
          localekx.abpN = ((eky)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekx
 * JD-Core Version:    0.7.0.1
 */