package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bwa
  extends com.tencent.mm.bx.a
{
  public b AEA;
  public int AYX;
  public String AZa;
  public boolean ECL;
  public long ECY;
  public String Wqu;
  public String Zsy;
  public String aadM;
  public int aadN;
  public LinkedList<Integer> aadO;
  public boolean aadP;
  public int aadQ;
  public int aadR;
  public String aadS;
  public bwm aadT;
  public bwb aadU;
  public LinkedList<bwb> aadV;
  public bwb aadW;
  public bwb aadX;
  public bwb aadY;
  public bwb aadZ;
  public int aaea;
  public long id;
  public LinkedList<FinderObject> object;
  public String sessionBuffer;
  
  public bwa()
  {
    AppMethodBeat.i(258715);
    this.object = new LinkedList();
    this.aadO = new LinkedList();
    this.aadV = new LinkedList();
    AppMethodBeat.o(258715);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258726);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ECY);
      if (this.Wqu != null) {
        paramVarArgs.g(2, this.Wqu);
      }
      if (this.aadM != null) {
        paramVarArgs.g(3, this.aadM);
      }
      paramVarArgs.bS(4, this.aadN);
      paramVarArgs.e(5, 8, this.object);
      paramVarArgs.e(6, 2, this.aadO);
      if (this.AEA != null) {
        paramVarArgs.d(7, this.AEA);
      }
      paramVarArgs.bS(8, this.AYX);
      paramVarArgs.di(9, this.aadP);
      paramVarArgs.bS(10, this.aadQ);
      paramVarArgs.di(11, this.ECL);
      if (this.AZa != null) {
        paramVarArgs.g(12, this.AZa);
      }
      paramVarArgs.bS(13, this.aadR);
      if (this.aadS != null) {
        paramVarArgs.g(14, this.aadS);
      }
      paramVarArgs.bv(15, this.id);
      if (this.sessionBuffer != null) {
        paramVarArgs.g(16, this.sessionBuffer);
      }
      if (this.aadT != null)
      {
        paramVarArgs.qD(17, this.aadT.computeSize());
        this.aadT.writeFields(paramVarArgs);
      }
      if (this.aadU != null)
      {
        paramVarArgs.qD(18, this.aadU.computeSize());
        this.aadU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(19, 8, this.aadV);
      if (this.aadW != null)
      {
        paramVarArgs.qD(20, this.aadW.computeSize());
        this.aadW.writeFields(paramVarArgs);
      }
      if (this.aadX != null)
      {
        paramVarArgs.qD(21, this.aadX.computeSize());
        this.aadX.writeFields(paramVarArgs);
      }
      if (this.Zsy != null) {
        paramVarArgs.g(22, this.Zsy);
      }
      if (this.aadY != null)
      {
        paramVarArgs.qD(23, this.aadY.computeSize());
        this.aadY.writeFields(paramVarArgs);
      }
      if (this.aadZ != null)
      {
        paramVarArgs.qD(24, this.aadZ.computeSize());
        this.aadZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(25, this.aaea);
      AppMethodBeat.o(258726);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ECY) + 0;
      paramInt = i;
      if (this.Wqu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Wqu);
      }
      i = paramInt;
      if (this.aadM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aadM);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aadN) + i.a.a.a.c(5, 8, this.object) + i.a.a.a.c(6, 2, this.aadO);
      paramInt = i;
      if (this.AEA != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.AEA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.AYX) + (i.a.a.b.b.a.ko(9) + 1) + i.a.a.b.b.a.cJ(10, this.aadQ) + (i.a.a.b.b.a.ko(11) + 1);
      paramInt = i;
      if (this.AZa != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.AZa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aadR);
      paramInt = i;
      if (this.aadS != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aadS);
      }
      i = paramInt + i.a.a.b.b.a.q(15, this.id);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.sessionBuffer);
      }
      i = paramInt;
      if (this.aadT != null) {
        i = paramInt + i.a.a.a.qC(17, this.aadT.computeSize());
      }
      paramInt = i;
      if (this.aadU != null) {
        paramInt = i + i.a.a.a.qC(18, this.aadU.computeSize());
      }
      i = paramInt + i.a.a.a.c(19, 8, this.aadV);
      paramInt = i;
      if (this.aadW != null) {
        paramInt = i + i.a.a.a.qC(20, this.aadW.computeSize());
      }
      i = paramInt;
      if (this.aadX != null) {
        i = paramInt + i.a.a.a.qC(21, this.aadX.computeSize());
      }
      paramInt = i;
      if (this.Zsy != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.Zsy);
      }
      i = paramInt;
      if (this.aadY != null) {
        i = paramInt + i.a.a.a.qC(23, this.aadY.computeSize());
      }
      paramInt = i;
      if (this.aadZ != null) {
        paramInt = i + i.a.a.a.qC(24, this.aadZ.computeSize());
      }
      i = i.a.a.b.b.a.cJ(25, this.aaea);
      AppMethodBeat.o(258726);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.object.clear();
      this.aadO.clear();
      this.aadV.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258726);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bwa localbwa = (bwa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258726);
        return -1;
      case 1: 
        localbwa.ECY = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258726);
        return 0;
      case 2: 
        localbwa.Wqu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258726);
        return 0;
      case 3: 
        localbwa.aadM = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258726);
        return 0;
      case 4: 
        localbwa.aadN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258726);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.object.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 6: 
        localbwa.aadO.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
        AppMethodBeat.o(258726);
        return 0;
      case 7: 
        localbwa.AEA = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258726);
        return 0;
      case 8: 
        localbwa.AYX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258726);
        return 0;
      case 9: 
        localbwa.aadP = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(258726);
        return 0;
      case 10: 
        localbwa.aadQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258726);
        return 0;
      case 11: 
        localbwa.ECL = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(258726);
        return 0;
      case 12: 
        localbwa.AZa = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258726);
        return 0;
      case 13: 
        localbwa.aadR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258726);
        return 0;
      case 14: 
        localbwa.aadS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258726);
        return 0;
      case 15: 
        localbwa.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258726);
        return 0;
      case 16: 
        localbwa.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258726);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwm)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadT = ((bwm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 18: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadU = ((bwb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 19: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadW = ((bwb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 21: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadX = ((bwb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 22: 
        localbwa.Zsy = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258726);
        return 0;
      case 23: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadY = ((bwb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.aadZ = ((bwb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258726);
        return 0;
      }
      localbwa.aaea = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(258726);
      return 0;
    }
    AppMethodBeat.o(258726);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwa
 * JD-Core Version:    0.7.0.1
 */