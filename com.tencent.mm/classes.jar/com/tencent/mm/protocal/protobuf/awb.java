package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class awb
  extends erp
{
  public atz ZEc;
  public int ZFY;
  public LinkedList<String> ZFZ;
  public String ZGH;
  public b ZGI;
  public LinkedList<bxx> ZGJ;
  public bno ZGK;
  public LinkedList<String> ZGL;
  public String ZGM;
  public int ZGN;
  public int ZGO;
  public bfw ZGP;
  public LinkedList<String> ZGQ;
  public LinkedList<String> ZGR;
  public b ZGS;
  public glm ZGT;
  public LinkedList<String> ZGb;
  public LinkedList<String> ZGc;
  public int businessType;
  public String clientId;
  public String finderUsername;
  public FinderObjectDesc objectDesc;
  public int scene;
  
  public awb()
  {
    AppMethodBeat.i(257386);
    this.ZGJ = new LinkedList();
    this.ZFZ = new LinkedList();
    this.ZGL = new LinkedList();
    this.ZGb = new LinkedList();
    this.ZGc = new LinkedList();
    this.ZGQ = new LinkedList();
    this.ZGR = new LinkedList();
    AppMethodBeat.o(257386);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257396);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.qD(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.g(5, this.clientId);
      }
      if (this.ZGH != null) {
        paramVarArgs.g(6, this.ZGH);
      }
      paramVarArgs.bS(7, this.businessType);
      paramVarArgs.bS(8, this.scene);
      if (this.ZGI != null) {
        paramVarArgs.d(9, this.ZGI);
      }
      paramVarArgs.e(10, 8, this.ZGJ);
      if (this.ZGK != null)
      {
        paramVarArgs.qD(11, this.ZGK.computeSize());
        this.ZGK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.ZFY);
      paramVarArgs.e(13, 1, this.ZFZ);
      paramVarArgs.e(14, 1, this.ZGL);
      paramVarArgs.e(15, 1, this.ZGb);
      paramVarArgs.e(16, 1, this.ZGc);
      if (this.ZGM != null) {
        paramVarArgs.g(17, this.ZGM);
      }
      paramVarArgs.bS(18, this.ZGN);
      paramVarArgs.bS(19, this.ZGO);
      if (this.ZGP != null)
      {
        paramVarArgs.qD(20, this.ZGP.computeSize());
        this.ZGP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(21, 1, this.ZGQ);
      paramVarArgs.e(22, 1, this.ZGR);
      if (this.ZGS != null) {
        paramVarArgs.d(23, this.ZGS);
      }
      if (this.ZGT != null)
      {
        paramVarArgs.qD(24, this.ZGT.computeSize());
        this.ZGT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2012;
      }
    }
    label2012:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + i.a.a.a.qC(4, this.objectDesc.computeSize());
      }
      i = paramInt;
      if (this.clientId != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.clientId);
      }
      paramInt = i;
      if (this.ZGH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZGH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.businessType) + i.a.a.b.b.a.cJ(8, this.scene);
      paramInt = i;
      if (this.ZGI != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.ZGI);
      }
      i = paramInt + i.a.a.a.c(10, 8, this.ZGJ);
      paramInt = i;
      if (this.ZGK != null) {
        paramInt = i + i.a.a.a.qC(11, this.ZGK.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.ZFY) + i.a.a.a.c(13, 1, this.ZFZ) + i.a.a.a.c(14, 1, this.ZGL) + i.a.a.a.c(15, 1, this.ZGb) + i.a.a.a.c(16, 1, this.ZGc);
      paramInt = i;
      if (this.ZGM != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ZGM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.ZGN) + i.a.a.b.b.a.cJ(19, this.ZGO);
      paramInt = i;
      if (this.ZGP != null) {
        paramInt = i + i.a.a.a.qC(20, this.ZGP.computeSize());
      }
      i = paramInt + i.a.a.a.c(21, 1, this.ZGQ) + i.a.a.a.c(22, 1, this.ZGR);
      paramInt = i;
      if (this.ZGS != null) {
        paramInt = i + i.a.a.b.b.a.c(23, this.ZGS);
      }
      i = paramInt;
      if (this.ZGT != null) {
        i = paramInt + i.a.a.a.qC(24, this.ZGT.computeSize());
      }
      AppMethodBeat.o(257396);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZGJ.clear();
        this.ZFZ.clear();
        this.ZGL.clear();
        this.ZGb.clear();
        this.ZGc.clear();
        this.ZGQ.clear();
        this.ZGR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awb localawb = (awb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257396);
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
            localawb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257396);
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
            localawb.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257396);
          return 0;
        case 3: 
          localawb.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257396);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObjectDesc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
            }
            localawb.objectDesc = ((FinderObjectDesc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257396);
          return 0;
        case 5: 
          localawb.clientId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257396);
          return 0;
        case 6: 
          localawb.ZGH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257396);
          return 0;
        case 7: 
          localawb.businessType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257396);
          return 0;
        case 8: 
          localawb.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257396);
          return 0;
        case 9: 
          localawb.ZGI = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257396);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxx)localObject2).parseFrom((byte[])localObject1);
            }
            localawb.ZGJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257396);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bno();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bno)localObject2).parseFrom((byte[])localObject1);
            }
            localawb.ZGK = ((bno)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257396);
          return 0;
        case 12: 
          localawb.ZFY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257396);
          return 0;
        case 13: 
          localawb.ZFZ.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257396);
          return 0;
        case 14: 
          localawb.ZGL.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257396);
          return 0;
        case 15: 
          localawb.ZGb.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257396);
          return 0;
        case 16: 
          localawb.ZGc.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257396);
          return 0;
        case 17: 
          localawb.ZGM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257396);
          return 0;
        case 18: 
          localawb.ZGN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257396);
          return 0;
        case 19: 
          localawb.ZGO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257396);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfw)localObject2).parseFrom((byte[])localObject1);
            }
            localawb.ZGP = ((bfw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257396);
          return 0;
        case 21: 
          localawb.ZGQ.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257396);
          return 0;
        case 22: 
          localawb.ZGR.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257396);
          return 0;
        case 23: 
          localawb.ZGS = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257396);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new glm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((glm)localObject2).parseFrom((byte[])localObject1);
          }
          localawb.ZGT = ((glm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257396);
        return 0;
      }
      AppMethodBeat.o(257396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awb
 * JD-Core Version:    0.7.0.1
 */