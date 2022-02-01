package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bya
  extends erp
{
  public String GaE;
  public long ZFw;
  public atz aagN;
  public String aagO;
  public long aagP;
  public long aagQ;
  public int aagR;
  public int aagS;
  public LinkedList<avc> aagT;
  public b aagU;
  public String mdD;
  public String oUw;
  public String xlJ;
  
  public bya()
  {
    AppMethodBeat.i(258103);
    this.aagT = new LinkedList();
    AppMethodBeat.o(258103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258107);
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
      if (this.oUw != null) {
        paramVarArgs.g(3, this.oUw);
      }
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
      if (this.aagO != null) {
        paramVarArgs.g(8, this.aagO);
      }
      paramVarArgs.bv(9, this.aagP);
      paramVarArgs.bv(10, this.aagQ);
      paramVarArgs.bS(11, this.aagR);
      paramVarArgs.bS(12, this.aagS);
      paramVarArgs.e(13, 8, this.aagT);
      if (this.aagU != null) {
        paramVarArgs.d(100, this.aagU);
      }
      AppMethodBeat.o(258107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1180;
      }
    }
    label1180:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aagN != null) {
        paramInt = i + i.a.a.a.qC(2, this.aagN.computeSize());
      }
      i = paramInt;
      if (this.oUw != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oUw);
      }
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
      i = paramInt + i.a.a.b.b.a.q(7, this.ZFw);
      paramInt = i;
      if (this.aagO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aagO);
      }
      i = paramInt + i.a.a.b.b.a.q(9, this.aagP) + i.a.a.b.b.a.q(10, this.aagQ) + i.a.a.b.b.a.cJ(11, this.aagR) + i.a.a.b.b.a.cJ(12, this.aagS) + i.a.a.a.c(13, 8, this.aagT);
      paramInt = i;
      if (this.aagU != null) {
        paramInt = i + i.a.a.b.b.a.c(100, this.aagU);
      }
      AppMethodBeat.o(258107);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aagT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bya localbya = (bya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258107);
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
            localbya.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258107);
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
            localbya.aagN = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258107);
          return 0;
        case 3: 
          localbya.oUw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258107);
          return 0;
        case 4: 
          localbya.xlJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258107);
          return 0;
        case 5: 
          localbya.GaE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258107);
          return 0;
        case 6: 
          localbya.mdD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258107);
          return 0;
        case 7: 
          localbya.ZFw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258107);
          return 0;
        case 8: 
          localbya.aagO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258107);
          return 0;
        case 9: 
          localbya.aagP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258107);
          return 0;
        case 10: 
          localbya.aagQ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258107);
          return 0;
        case 11: 
          localbya.aagR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258107);
          return 0;
        case 12: 
          localbya.aagS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258107);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avc)localObject2).parseFrom((byte[])localObject1);
            }
            localbya.aagT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258107);
          return 0;
        }
        localbya.aagU = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258107);
        return 0;
      }
      AppMethodBeat.o(258107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bya
 * JD-Core Version:    0.7.0.1
 */