package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aca
  extends erp
{
  public String IcT;
  public String RZY;
  public String UserName;
  public int YFx;
  public String YNW;
  public bi Zbi;
  public String ZiL;
  public String ZjI;
  public String ZjJ;
  public String ZjK;
  public String ZjL;
  public int ZjM;
  public int ZjO;
  public String ZjP;
  public int ZkA;
  public int ZkB;
  public String mXG;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91418);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.ZjI != null) {
        paramVarArgs.g(3, this.ZjI);
      }
      if (this.YNW != null) {
        paramVarArgs.g(4, this.YNW);
      }
      if (this.ZjJ != null) {
        paramVarArgs.g(5, this.ZjJ);
      }
      if (this.ZjK != null) {
        paramVarArgs.g(6, this.ZjK);
      }
      if (this.ZjL != null) {
        paramVarArgs.g(7, this.ZjL);
      }
      if (this.ZiL != null) {
        paramVarArgs.g(8, this.ZiL);
      }
      paramVarArgs.bS(9, this.ZjM);
      if (this.Zbi != null)
      {
        paramVarArgs.qD(10, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(11, this.UserName);
      }
      if (this.IcT != null) {
        paramVarArgs.g(12, this.IcT);
      }
      paramVarArgs.bS(13, this.YFx);
      paramVarArgs.bS(14, this.ZkA);
      if (this.RZY != null) {
        paramVarArgs.g(15, this.RZY);
      }
      if (this.mXG != null) {
        paramVarArgs.g(16, this.mXG);
      }
      paramVarArgs.bS(17, this.ZkB);
      paramVarArgs.bS(18, this.ZjO);
      if (this.ZjP != null) {
        paramVarArgs.g(19, this.ZjP);
      }
      AppMethodBeat.o(91418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1382;
      }
    }
    label1382:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.ZjI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZjI);
      }
      paramInt = i;
      if (this.YNW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNW);
      }
      i = paramInt;
      if (this.ZjJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjJ);
      }
      paramInt = i;
      if (this.ZjK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjK);
      }
      i = paramInt;
      if (this.ZjL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjL);
      }
      paramInt = i;
      if (this.ZiL != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZiL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.ZjM);
      paramInt = i;
      if (this.Zbi != null) {
        paramInt = i + i.a.a.a.qC(10, this.Zbi.computeSize());
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.UserName);
      }
      paramInt = i;
      if (this.IcT != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.IcT);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.YFx) + i.a.a.b.b.a.cJ(14, this.ZkA);
      paramInt = i;
      if (this.RZY != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.RZY);
      }
      i = paramInt;
      if (this.mXG != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.mXG);
      }
      i = i + i.a.a.b.b.a.cJ(17, this.ZkB) + i.a.a.b.b.a.cJ(18, this.ZjO);
      paramInt = i;
      if (this.ZjP != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.ZjP);
      }
      AppMethodBeat.o(91418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aca localaca = (aca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91418);
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
            localaca.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 2: 
          localaca.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 3: 
          localaca.ZjI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 4: 
          localaca.YNW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 5: 
          localaca.ZjJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 6: 
          localaca.ZjK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 7: 
          localaca.ZjL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 8: 
          localaca.ZiL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 9: 
          localaca.ZjM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91418);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bi)localObject2).parseFrom((byte[])localObject1);
            }
            localaca.Zbi = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 11: 
          localaca.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 12: 
          localaca.IcT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 13: 
          localaca.YFx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91418);
          return 0;
        case 14: 
          localaca.ZkA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91418);
          return 0;
        case 15: 
          localaca.RZY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 16: 
          localaca.mXG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 17: 
          localaca.ZkB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91418);
          return 0;
        case 18: 
          localaca.ZjO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91418);
          return 0;
        }
        localaca.ZjP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91418);
        return 0;
      }
      AppMethodBeat.o(91418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aca
 * JD-Core Version:    0.7.0.1
 */