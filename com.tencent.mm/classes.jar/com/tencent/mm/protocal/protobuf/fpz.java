package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpz
  extends esc
{
  public String Oln;
  public String Olo;
  public String YAg;
  public String abPH;
  public String abPJ;
  public int abPK;
  public int abPL;
  public epk abPM;
  public aci abPN;
  public epl abPO;
  public epk abPn;
  public String abPr;
  public String hMy;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.abPK);
      if (this.abPn != null)
      {
        paramVarArgs.qD(5, this.abPn.computeSize());
        this.abPn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abPL);
      if (this.abPM != null)
      {
        paramVarArgs.qD(7, this.abPM.computeSize());
        this.abPM.writeFields(paramVarArgs);
      }
      if (this.abPN != null)
      {
        paramVarArgs.qD(8, this.abPN.computeSize());
        this.abPN.writeFields(paramVarArgs);
      }
      if (this.abPO != null)
      {
        paramVarArgs.qD(9, this.abPO.computeSize());
        this.abPO.writeFields(paramVarArgs);
      }
      if (this.hMy != null) {
        paramVarArgs.g(10, this.hMy);
      }
      if (this.YAg != null) {
        paramVarArgs.g(11, this.YAg);
      }
      if (this.Oln != null) {
        paramVarArgs.g(12, this.Oln);
      }
      if (this.abPH != null) {
        paramVarArgs.g(13, this.abPH);
      }
      if (this.Olo != null) {
        paramVarArgs.g(14, this.Olo);
      }
      if (this.abPJ != null) {
        paramVarArgs.g(15, this.abPJ);
      }
      if (this.abPr != null) {
        paramVarArgs.g(16, this.abPr);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1448;
      }
    }
    label1448:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abPK);
      paramInt = i;
      if (this.abPn != null) {
        paramInt = i + i.a.a.a.qC(5, this.abPn.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abPL);
      paramInt = i;
      if (this.abPM != null) {
        paramInt = i + i.a.a.a.qC(7, this.abPM.computeSize());
      }
      i = paramInt;
      if (this.abPN != null) {
        i = paramInt + i.a.a.a.qC(8, this.abPN.computeSize());
      }
      paramInt = i;
      if (this.abPO != null) {
        paramInt = i + i.a.a.a.qC(9, this.abPO.computeSize());
      }
      i = paramInt;
      if (this.hMy != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.hMy);
      }
      paramInt = i;
      if (this.YAg != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YAg);
      }
      i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.Oln);
      }
      paramInt = i;
      if (this.abPH != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abPH);
      }
      i = paramInt;
      if (this.Olo != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.Olo);
      }
      paramInt = i;
      if (this.abPJ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abPJ);
      }
      i = paramInt;
      if (this.abPr != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.abPr);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpz localfpz = (fpz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
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
            localfpz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localfpz.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localfpz.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localfpz.abPK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epk)localObject2).parseFrom((byte[])localObject1);
            }
            localfpz.abPn = ((epk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localfpz.abPL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epk)localObject2).parseFrom((byte[])localObject1);
            }
            localfpz.abPM = ((epk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aci)localObject2).parseFrom((byte[])localObject1);
            }
            localfpz.abPN = ((aci)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epl)localObject2).parseFrom((byte[])localObject1);
            }
            localfpz.abPO = ((epl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localfpz.hMy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localfpz.YAg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localfpz.Oln = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localfpz.abPH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localfpz.Olo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localfpz.abPJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localfpz.abPr = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpz
 * JD-Core Version:    0.7.0.1
 */