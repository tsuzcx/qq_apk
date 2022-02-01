package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ha
  extends com.tencent.mm.cd.a
{
  public String RFB;
  public aiq RLT;
  public eae RLU;
  public eae RLV;
  public int RLW;
  public eae RLX;
  public fhe RLY;
  public fmy RLZ;
  public eae RMa;
  public eae RMb;
  public String RMc;
  public eae RMd;
  public String RMe;
  public eii RMf;
  public String RMg;
  public int RMh;
  public int RMi;
  public int RMj;
  public int RMk;
  public int RMl;
  public eae RMm;
  public eae RMn;
  public int RMo;
  public int vhf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RLV == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RMm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RMn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.vhf);
      if (this.RLT != null)
      {
        paramVarArgs.oE(2, this.RLT.computeSize());
        this.RLT.writeFields(paramVarArgs);
      }
      if (this.RLU != null)
      {
        paramVarArgs.oE(3, this.RLU.computeSize());
        this.RLU.writeFields(paramVarArgs);
      }
      if (this.RLV != null)
      {
        paramVarArgs.oE(4, this.RLV.computeSize());
        this.RLV.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.RLW);
      if (this.RLX != null)
      {
        paramVarArgs.oE(6, this.RLX.computeSize());
        this.RLX.writeFields(paramVarArgs);
      }
      if (this.RLY != null)
      {
        paramVarArgs.oE(7, this.RLY.computeSize());
        this.RLY.writeFields(paramVarArgs);
      }
      if (this.RLZ != null)
      {
        paramVarArgs.oE(8, this.RLZ.computeSize());
        this.RLZ.writeFields(paramVarArgs);
      }
      if (this.RMa != null)
      {
        paramVarArgs.oE(9, this.RMa.computeSize());
        this.RMa.writeFields(paramVarArgs);
      }
      if (this.RMb != null)
      {
        paramVarArgs.oE(10, this.RMb.computeSize());
        this.RMb.writeFields(paramVarArgs);
      }
      if (this.RMc != null) {
        paramVarArgs.f(11, this.RMc);
      }
      if (this.RMd != null)
      {
        paramVarArgs.oE(12, this.RMd.computeSize());
        this.RMd.writeFields(paramVarArgs);
      }
      if (this.RMe != null) {
        paramVarArgs.f(14, this.RMe);
      }
      if (this.RMf != null)
      {
        paramVarArgs.oE(15, this.RMf.computeSize());
        this.RMf.writeFields(paramVarArgs);
      }
      if (this.RMg != null) {
        paramVarArgs.f(16, this.RMg);
      }
      paramVarArgs.aY(17, this.RMh);
      paramVarArgs.aY(18, this.RMi);
      paramVarArgs.aY(19, this.RMj);
      if (this.RFB != null) {
        paramVarArgs.f(20, this.RFB);
      }
      paramVarArgs.aY(21, this.RMk);
      paramVarArgs.aY(22, this.RMl);
      if (this.RMm != null)
      {
        paramVarArgs.oE(23, this.RMm.computeSize());
        this.RMm.writeFields(paramVarArgs);
      }
      if (this.RMn != null)
      {
        paramVarArgs.oE(24, this.RMn.computeSize());
        this.RMn.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(25, this.RMo);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.vhf) + 0;
      paramInt = i;
      if (this.RLT != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLT.computeSize());
      }
      i = paramInt;
      if (this.RLU != null) {
        i = paramInt + g.a.a.a.oD(3, this.RLU.computeSize());
      }
      paramInt = i;
      if (this.RLV != null) {
        paramInt = i + g.a.a.a.oD(4, this.RLV.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RLW);
      paramInt = i;
      if (this.RLX != null) {
        paramInt = i + g.a.a.a.oD(6, this.RLX.computeSize());
      }
      i = paramInt;
      if (this.RLY != null) {
        i = paramInt + g.a.a.a.oD(7, this.RLY.computeSize());
      }
      paramInt = i;
      if (this.RLZ != null) {
        paramInt = i + g.a.a.a.oD(8, this.RLZ.computeSize());
      }
      i = paramInt;
      if (this.RMa != null) {
        i = paramInt + g.a.a.a.oD(9, this.RMa.computeSize());
      }
      paramInt = i;
      if (this.RMb != null) {
        paramInt = i + g.a.a.a.oD(10, this.RMb.computeSize());
      }
      i = paramInt;
      if (this.RMc != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RMc);
      }
      paramInt = i;
      if (this.RMd != null) {
        paramInt = i + g.a.a.a.oD(12, this.RMd.computeSize());
      }
      i = paramInt;
      if (this.RMe != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.RMe);
      }
      paramInt = i;
      if (this.RMf != null) {
        paramInt = i + g.a.a.a.oD(15, this.RMf.computeSize());
      }
      i = paramInt;
      if (this.RMg != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.RMg);
      }
      i = i + g.a.a.b.b.a.bM(17, this.RMh) + g.a.a.b.b.a.bM(18, this.RMi) + g.a.a.b.b.a.bM(19, this.RMj);
      paramInt = i;
      if (this.RFB != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.RFB);
      }
      i = paramInt + g.a.a.b.b.a.bM(21, this.RMk) + g.a.a.b.b.a.bM(22, this.RMl);
      paramInt = i;
      if (this.RMm != null) {
        paramInt = i + g.a.a.a.oD(23, this.RMm.computeSize());
      }
      i = paramInt;
      if (this.RMn != null) {
        i = paramInt + g.a.a.a.oD(24, this.RMn.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(25, this.RMo);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RLT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RLV == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RMm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.RMn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133145);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ha localha = (ha)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(133145);
        return -1;
      case 1: 
        localha.vhf = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aiq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aiq)localObject2).parseFrom((byte[])localObject1);
          }
          localha.RLT = ((aiq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RLU = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RLV = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localha.RLW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RLX = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhe)localObject2).parseFrom((byte[])localObject1);
          }
          localha.RLY = ((fhe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmy)localObject2).parseFrom((byte[])localObject1);
          }
          localha.RLZ = ((fmy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RMa = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RMb = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localha.RMc = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RMd = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localha.RMe = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eii();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eii)localObject2).parseFrom((byte[])localObject1);
          }
          localha.RMf = ((eii)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localha.RMg = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localha.RMh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localha.RMi = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localha.RMj = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localha.RFB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localha.RMk = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localha.RMl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133145);
        return 0;
      case 23: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RMm = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localha.RMn = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localha.RMo = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ha
 * JD-Core Version:    0.7.0.1
 */