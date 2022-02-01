package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bye
  extends erp
{
  public String GaE;
  public long ZFw;
  public long ZNy;
  public atz aagN;
  public int aagR;
  public int aagS;
  public b aagU;
  public String mdD;
  public String xlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257965);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aagN != null)
      {
        paramVarArgs.qD(2, this.aagN.computeSize());
        this.aagN.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.ZNy);
      if (this.xlJ != null) {
        paramVarArgs.g(4, this.xlJ);
      }
      if (this.GaE != null) {
        paramVarArgs.g(5, this.GaE);
      }
      if (this.mdD != null) {
        paramVarArgs.g(6, this.mdD);
      }
      paramVarArgs.bv(7, this.ZFw);
      paramVarArgs.bS(8, this.aagR);
      paramVarArgs.bS(9, this.aagS);
      if (this.aagU != null) {
        paramVarArgs.d(100, this.aagU);
      }
      AppMethodBeat.o(257965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aagN != null) {
        i = paramInt + i.a.a.a.qC(2, this.aagN.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.ZNy);
      paramInt = i;
      if (this.xlJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xlJ);
      }
      i = paramInt;
      if (this.GaE != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.GaE);
      }
      paramInt = i;
      if (this.mdD != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mdD);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.ZFw) + i.a.a.b.b.a.cJ(8, this.aagR) + i.a.a.b.b.a.cJ(9, this.aagS);
      paramInt = i;
      if (this.aagU != null) {
        paramInt = i + i.a.a.b.b.a.c(100, this.aagU);
      }
      AppMethodBeat.o(257965);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bye localbye = (bye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257965);
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
            localbye.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257965);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbye.aagN = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257965);
          return 0;
        case 3: 
          localbye.ZNy = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257965);
          return 0;
        case 4: 
          localbye.xlJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257965);
          return 0;
        case 5: 
          localbye.GaE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257965);
          return 0;
        case 6: 
          localbye.mdD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257965);
          return 0;
        case 7: 
          localbye.ZFw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257965);
          return 0;
        case 8: 
          localbye.aagR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257965);
          return 0;
        case 9: 
          localbye.aagS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257965);
          return 0;
        }
        localbye.aagU = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(257965);
        return 0;
      }
      AppMethodBeat.o(257965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bye
 * JD-Core Version:    0.7.0.1
 */