package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dmn
  extends erp
{
  public int IIs;
  public String IJC;
  public String ThumbUrl;
  public int ZaD;
  public int ZaE;
  public String aaSA;
  public String aaSB;
  public String aaSC;
  public int aaSD;
  public gol aaSE;
  public int aaSF;
  public int aaSG;
  public int aaSH;
  public int aaSI;
  public gol aaSJ;
  public int aaSK;
  public int aaSL;
  public int aaSM;
  public int aaSN;
  public int aaSO;
  public String aaSP;
  public String aaSQ;
  public int aava;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaSE == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.aaSJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaSA != null) {
        paramVarArgs.g(2, this.aaSA);
      }
      if (this.aaSB != null) {
        paramVarArgs.g(3, this.aaSB);
      }
      if (this.aaSC != null) {
        paramVarArgs.g(4, this.aaSC);
      }
      paramVarArgs.bS(5, this.IIs);
      paramVarArgs.bS(6, this.aaSD);
      if (this.aaSE != null)
      {
        paramVarArgs.qD(7, this.aaSE.computeSize());
        this.aaSE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.aaSF);
      paramVarArgs.bS(9, this.aaSG);
      paramVarArgs.bS(10, this.aaSH);
      paramVarArgs.bS(11, this.aaSI);
      if (this.aaSJ != null)
      {
        paramVarArgs.qD(12, this.aaSJ.computeSize());
        this.aaSJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.aaSK);
      paramVarArgs.bS(14, this.aaSL);
      paramVarArgs.bS(15, this.aaSM);
      paramVarArgs.bS(16, this.aaSN);
      paramVarArgs.bS(17, this.aava);
      paramVarArgs.bS(18, this.aaSO);
      if (this.IJC != null) {
        paramVarArgs.g(19, this.IJC);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(20, this.ThumbUrl);
      }
      paramVarArgs.bS(21, this.ZaE);
      paramVarArgs.bS(22, this.ZaD);
      if (this.aaSP != null) {
        paramVarArgs.g(23, this.aaSP);
      }
      if (this.aaSQ != null) {
        paramVarArgs.g(24, this.aaSQ);
      }
      AppMethodBeat.o(32345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1734;
      }
    }
    label1734:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaSA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaSA);
      }
      i = paramInt;
      if (this.aaSB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaSB);
      }
      paramInt = i;
      if (this.aaSC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaSC);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.IIs) + i.a.a.b.b.a.cJ(6, this.aaSD);
      paramInt = i;
      if (this.aaSE != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaSE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aaSF) + i.a.a.b.b.a.cJ(9, this.aaSG) + i.a.a.b.b.a.cJ(10, this.aaSH) + i.a.a.b.b.a.cJ(11, this.aaSI);
      paramInt = i;
      if (this.aaSJ != null) {
        paramInt = i + i.a.a.a.qC(12, this.aaSJ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aaSK) + i.a.a.b.b.a.cJ(14, this.aaSL) + i.a.a.b.b.a.cJ(15, this.aaSM) + i.a.a.b.b.a.cJ(16, this.aaSN) + i.a.a.b.b.a.cJ(17, this.aava) + i.a.a.b.b.a.cJ(18, this.aaSO);
      paramInt = i;
      if (this.IJC != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.IJC);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.ThumbUrl);
      }
      i = i + i.a.a.b.b.a.cJ(21, this.ZaE) + i.a.a.b.b.a.cJ(22, this.ZaD);
      paramInt = i;
      if (this.aaSP != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.aaSP);
      }
      i = paramInt;
      if (this.aaSQ != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.aaSQ);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaSE == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.aaSJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dmn localdmn = (dmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localdmn.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localdmn.aaSA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localdmn.aaSB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localdmn.aaSC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localdmn.IIs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localdmn.aaSD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localdmn.aaSE = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localdmn.aaSF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localdmn.aaSG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localdmn.aaSH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localdmn.aaSI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localdmn.aaSJ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localdmn.aaSK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localdmn.aaSL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localdmn.aaSM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localdmn.aaSN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localdmn.aava = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localdmn.aaSO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localdmn.IJC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localdmn.ThumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localdmn.ZaE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localdmn.ZaD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localdmn.aaSP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localdmn.aaSQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmn
 * JD-Core Version:    0.7.0.1
 */