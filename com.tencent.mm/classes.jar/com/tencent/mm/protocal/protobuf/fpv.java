package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpv
  extends esc
{
  public boolean Vpn;
  public aez abPD;
  public int abPF;
  public dfc abPG;
  public String abPw;
  public String igN;
  public dus ign;
  public LinkedList<dfc> menu;
  public String title;
  public String wuA;
  public int wuz;
  
  public fpv()
  {
    AppMethodBeat.i(72603);
    this.menu = new LinkedList();
    AppMethodBeat.o(72603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72604);
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
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      if (this.igN != null) {
        paramVarArgs.g(5, this.igN);
      }
      paramVarArgs.bS(6, this.abPF);
      paramVarArgs.e(7, 8, this.menu);
      if (this.abPG != null)
      {
        paramVarArgs.qD(8, this.abPG.computeSize());
        this.abPG.writeFields(paramVarArgs);
      }
      if (this.abPw != null) {
        paramVarArgs.g(9, this.abPw);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(10, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      paramVarArgs.di(11, this.Vpn);
      if (this.abPD != null)
      {
        paramVarArgs.qD(12, this.abPD.computeSize());
        this.abPD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1184;
      }
    }
    label1184:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.title);
      }
      paramInt = i;
      if (this.igN != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.igN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abPF) + i.a.a.a.c(7, 8, this.menu);
      paramInt = i;
      if (this.abPG != null) {
        paramInt = i + i.a.a.a.qC(8, this.abPG.computeSize());
      }
      i = paramInt;
      if (this.abPw != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abPw);
      }
      paramInt = i;
      if (this.ign != null) {
        paramInt = i + i.a.a.a.qC(10, this.ign.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(11) + 1);
      paramInt = i;
      if (this.abPD != null) {
        paramInt = i + i.a.a.a.qC(12, this.abPD.computeSize());
      }
      AppMethodBeat.o(72604);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.menu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpv localfpv = (fpv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
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
            localfpv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localfpv.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localfpv.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localfpv.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localfpv.igN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localfpv.abPF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfc)localObject2).parseFrom((byte[])localObject1);
            }
            localfpv.menu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfc)localObject2).parseFrom((byte[])localObject1);
            }
            localfpv.abPG = ((dfc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 9: 
          localfpv.abPw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dus();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dus)localObject2).parseFrom((byte[])localObject1);
            }
            localfpv.ign = ((dus)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 11: 
          localfpv.Vpn = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72604);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aez();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aez)localObject2).parseFrom((byte[])localObject1);
          }
          localfpv.abPD = ((aez)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpv
 * JD-Core Version:    0.7.0.1
 */