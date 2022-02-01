package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class byc
  extends erp
{
  public String GaE;
  public b ZEQ;
  public long ZFw;
  public int ZRo;
  public atz aagN;
  public long aagP;
  public int aagS;
  public long aagV;
  public long aagW;
  public int direction;
  public String xlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258132);
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
      if (this.xlJ != null) {
        paramVarArgs.g(3, this.xlJ);
      }
      if (this.GaE != null) {
        paramVarArgs.g(4, this.GaE);
      }
      paramVarArgs.bv(5, this.ZFw);
      paramVarArgs.bv(6, this.aagP);
      paramVarArgs.bv(7, this.aagV);
      paramVarArgs.bv(8, this.aagW);
      paramVarArgs.bS(9, this.direction);
      paramVarArgs.bS(10, this.aagS);
      paramVarArgs.bS(11, this.ZRo);
      if (this.ZEQ != null) {
        paramVarArgs.d(100, this.ZEQ);
      }
      AppMethodBeat.o(258132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label950;
      }
    }
    label950:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aagN != null) {
        paramInt = i + i.a.a.a.qC(2, this.aagN.computeSize());
      }
      i = paramInt;
      if (this.xlJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xlJ);
      }
      paramInt = i;
      if (this.GaE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.GaE);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZFw) + i.a.a.b.b.a.q(6, this.aagP) + i.a.a.b.b.a.q(7, this.aagV) + i.a.a.b.b.a.q(8, this.aagW) + i.a.a.b.b.a.cJ(9, this.direction) + i.a.a.b.b.a.cJ(10, this.aagS) + i.a.a.b.b.a.cJ(11, this.ZRo);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(100, this.ZEQ);
      }
      AppMethodBeat.o(258132);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258132);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byc localbyc = (byc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258132);
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
            localbyc.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258132);
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
            localbyc.aagN = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258132);
          return 0;
        case 3: 
          localbyc.xlJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258132);
          return 0;
        case 4: 
          localbyc.GaE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258132);
          return 0;
        case 5: 
          localbyc.ZFw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258132);
          return 0;
        case 6: 
          localbyc.aagP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258132);
          return 0;
        case 7: 
          localbyc.aagV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258132);
          return 0;
        case 8: 
          localbyc.aagW = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258132);
          return 0;
        case 9: 
          localbyc.direction = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258132);
          return 0;
        case 10: 
          localbyc.aagS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258132);
          return 0;
        case 11: 
          localbyc.ZRo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258132);
          return 0;
        }
        localbyc.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258132);
        return 0;
      }
      AppMethodBeat.o(258132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byc
 * JD-Core Version:    0.7.0.1
 */