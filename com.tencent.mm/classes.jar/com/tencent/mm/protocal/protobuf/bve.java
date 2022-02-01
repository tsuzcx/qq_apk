package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bve
  extends com.tencent.mm.bx.a
{
  public bwi AAm;
  public String PNd;
  public int STX;
  public String aacF;
  public String aacG;
  public int aacH;
  public String aacI;
  public String aacJ;
  public bbg aacK;
  public baw aacL;
  public int qvo;
  public int recommendType;
  public String wFL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258964);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wFL != null) {
        paramVarArgs.g(1, this.wFL);
      }
      if (this.aacF != null) {
        paramVarArgs.g(2, this.aacF);
      }
      if (this.aacG != null) {
        paramVarArgs.g(3, this.aacG);
      }
      paramVarArgs.bS(4, this.STX);
      paramVarArgs.bS(5, this.aacH);
      if (this.aacI != null) {
        paramVarArgs.g(6, this.aacI);
      }
      if (this.aacJ != null) {
        paramVarArgs.g(7, this.aacJ);
      }
      if (this.PNd != null) {
        paramVarArgs.g(8, this.PNd);
      }
      paramVarArgs.bS(9, this.qvo);
      if (this.aacK != null)
      {
        paramVarArgs.qD(10, this.aacK.computeSize());
        this.aacK.writeFields(paramVarArgs);
      }
      if (this.AAm != null)
      {
        paramVarArgs.qD(11, this.AAm.computeSize());
        this.AAm.writeFields(paramVarArgs);
      }
      if (this.aacL != null)
      {
        paramVarArgs.qD(12, this.aacL.computeSize());
        this.aacL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.recommendType);
      AppMethodBeat.o(258964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wFL == null) {
        break label1100;
      }
    }
    label1100:
    for (int i = i.a.a.b.b.a.h(1, this.wFL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aacF != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aacF);
      }
      i = paramInt;
      if (this.aacG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aacG);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.STX) + i.a.a.b.b.a.cJ(5, this.aacH);
      paramInt = i;
      if (this.aacI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aacI);
      }
      i = paramInt;
      if (this.aacJ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aacJ);
      }
      paramInt = i;
      if (this.PNd != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.PNd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.qvo);
      paramInt = i;
      if (this.aacK != null) {
        paramInt = i + i.a.a.a.qC(10, this.aacK.computeSize());
      }
      i = paramInt;
      if (this.AAm != null) {
        i = paramInt + i.a.a.a.qC(11, this.AAm.computeSize());
      }
      paramInt = i;
      if (this.aacL != null) {
        paramInt = i + i.a.a.a.qC(12, this.aacL.computeSize());
      }
      i = i.a.a.b.b.a.cJ(13, this.recommendType);
      AppMethodBeat.o(258964);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bve localbve = (bve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258964);
          return -1;
        case 1: 
          localbve.wFL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258964);
          return 0;
        case 2: 
          localbve.aacF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258964);
          return 0;
        case 3: 
          localbve.aacG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258964);
          return 0;
        case 4: 
          localbve.STX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258964);
          return 0;
        case 5: 
          localbve.aacH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258964);
          return 0;
        case 6: 
          localbve.aacI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258964);
          return 0;
        case 7: 
          localbve.aacJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258964);
          return 0;
        case 8: 
          localbve.PNd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258964);
          return 0;
        case 9: 
          localbve.qvo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258964);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbg)localObject2).parseFrom((byte[])localObject1);
            }
            localbve.aacK = ((bbg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258964);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwi)localObject2).parseFrom((byte[])localObject1);
            }
            localbve.AAm = ((bwi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258964);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new baw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((baw)localObject2).parseFrom((byte[])localObject1);
            }
            localbve.aacL = ((baw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258964);
          return 0;
        }
        localbve.recommendType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258964);
        return 0;
      }
      AppMethodBeat.o(258964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bve
 * JD-Core Version:    0.7.0.1
 */