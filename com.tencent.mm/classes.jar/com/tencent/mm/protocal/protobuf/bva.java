package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bva
  extends esc
{
  public LinkedList<FinderObject> AdW;
  public b BgS;
  public LinkedList<buy> KNn;
  public int aacA;
  public bvb aacB;
  public bux aacC;
  public LinkedList<bxx> aacw;
  public int aacx;
  public int aacy;
  public LinkedList<bqk> aacz;
  public int continueFlag;
  public String hOG;
  public int offset;
  
  public bva()
  {
    AppMethodBeat.i(169049);
    this.KNn = new LinkedList();
    this.AdW = new LinkedList();
    this.aacw = new LinkedList();
    this.aacz = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KNn);
      paramVarArgs.bS(3, this.offset);
      paramVarArgs.bS(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.AdW);
      if (this.BgS != null) {
        paramVarArgs.d(6, this.BgS);
      }
      if (this.hOG != null) {
        paramVarArgs.g(7, this.hOG);
      }
      paramVarArgs.e(8, 8, this.aacw);
      paramVarArgs.bS(9, this.aacx);
      paramVarArgs.bS(10, this.aacy);
      paramVarArgs.e(11, 8, this.aacz);
      paramVarArgs.bS(12, this.aacA);
      if (this.aacB != null)
      {
        paramVarArgs.qD(13, this.aacB.computeSize());
        this.aacB.writeFields(paramVarArgs);
      }
      if (this.aacC != null)
      {
        paramVarArgs.qD(14, this.aacC.computeSize());
        this.aacC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1364;
      }
    }
    label1364:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.KNn) + i.a.a.b.b.a.cJ(3, this.offset) + i.a.a.b.b.a.cJ(4, this.continueFlag) + i.a.a.a.c(5, 8, this.AdW);
      paramInt = i;
      if (this.BgS != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.BgS);
      }
      i = paramInt;
      if (this.hOG != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hOG);
      }
      i = i + i.a.a.a.c(8, 8, this.aacw) + i.a.a.b.b.a.cJ(9, this.aacx) + i.a.a.b.b.a.cJ(10, this.aacy) + i.a.a.a.c(11, 8, this.aacz) + i.a.a.b.b.a.cJ(12, this.aacA);
      paramInt = i;
      if (this.aacB != null) {
        paramInt = i + i.a.a.a.qC(13, this.aacB.computeSize());
      }
      i = paramInt;
      if (this.aacC != null) {
        i = paramInt + i.a.a.a.qC(14, this.aacC.computeSize());
      }
      AppMethodBeat.o(169050);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KNn.clear();
        this.AdW.clear();
        this.aacw.clear();
        this.aacz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bva localbva = (bva)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbva.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new buy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((buy)localObject2).parseFrom((byte[])localObject1);
            }
            localbva.KNn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localbva.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localbva.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169050);
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
            localbva.AdW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localbva.BgS = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169050);
          return 0;
        case 7: 
          localbva.hOG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169050);
          return 0;
        case 8: 
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
            localbva.aacw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 9: 
          localbva.aacx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169050);
          return 0;
        case 10: 
          localbva.aacy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169050);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqk)localObject2).parseFrom((byte[])localObject1);
            }
            localbva.aacz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 12: 
          localbva.aacA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169050);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvb)localObject2).parseFrom((byte[])localObject1);
            }
            localbva.aacB = ((bvb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bux();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bux)localObject2).parseFrom((byte[])localObject1);
          }
          localbva.aacC = ((bux)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bva
 * JD-Core Version:    0.7.0.1
 */