package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avv
  extends erp
{
  public FinderMedia AyC;
  public int AyD;
  public atz YIY;
  public String YIZ;
  public String ZFX;
  public int ZFY;
  public LinkedList<String> ZFZ;
  public int ZGa;
  public LinkedList<String> ZGb;
  public LinkedList<String> ZGc;
  public cca ZGd;
  public bqc ZGe;
  public String app_id;
  public String description;
  public boi location;
  public int scene;
  
  public avv()
  {
    AppMethodBeat.i(257447);
    this.ZFZ = new LinkedList();
    this.ZGb = new LinkedList();
    this.ZGc = new LinkedList();
    AppMethodBeat.o(257447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257454);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      if (this.AyC != null)
      {
        paramVarArgs.qD(4, this.AyC.computeSize());
        this.AyC.writeFields(paramVarArgs);
      }
      if (this.description != null) {
        paramVarArgs.g(5, this.description);
      }
      if (this.location != null)
      {
        paramVarArgs.qD(6, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.ZFX != null) {
        paramVarArgs.g(7, this.ZFX);
      }
      if (this.app_id != null) {
        paramVarArgs.g(8, this.app_id);
      }
      paramVarArgs.bS(9, this.scene);
      paramVarArgs.bS(10, this.ZFY);
      paramVarArgs.e(11, 1, this.ZFZ);
      paramVarArgs.bS(12, this.ZGa);
      paramVarArgs.bS(13, this.AyD);
      paramVarArgs.e(14, 1, this.ZGb);
      paramVarArgs.e(15, 1, this.ZGc);
      if (this.ZGd != null)
      {
        paramVarArgs.qD(16, this.ZGd.computeSize());
        this.ZGd.writeFields(paramVarArgs);
      }
      if (this.ZGe != null)
      {
        paramVarArgs.qD(17, this.ZGe.computeSize());
        this.ZGe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIZ);
      }
      paramInt = i;
      if (this.AyC != null) {
        paramInt = i + i.a.a.a.qC(4, this.AyC.computeSize());
      }
      i = paramInt;
      if (this.description != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.description);
      }
      paramInt = i;
      if (this.location != null) {
        paramInt = i + i.a.a.a.qC(6, this.location.computeSize());
      }
      i = paramInt;
      if (this.ZFX != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZFX);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.app_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.scene) + i.a.a.b.b.a.cJ(10, this.ZFY) + i.a.a.a.c(11, 1, this.ZFZ) + i.a.a.b.b.a.cJ(12, this.ZGa) + i.a.a.b.b.a.cJ(13, this.AyD) + i.a.a.a.c(14, 1, this.ZGb) + i.a.a.a.c(15, 1, this.ZGc);
      paramInt = i;
      if (this.ZGd != null) {
        paramInt = i + i.a.a.a.qC(16, this.ZGd.computeSize());
      }
      i = paramInt;
      if (this.ZGe != null) {
        i = paramInt + i.a.a.a.qC(17, this.ZGe.computeSize());
      }
      AppMethodBeat.o(257454);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZFZ.clear();
        this.ZGb.clear();
        this.ZGc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        avv localavv = (avv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257454);
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
            localavv.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257454);
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
            localavv.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257454);
          return 0;
        case 3: 
          localavv.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257454);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderMedia();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderMedia)localObject2).parseFrom((byte[])localObject1);
            }
            localavv.AyC = ((FinderMedia)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257454);
          return 0;
        case 5: 
          localavv.description = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257454);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boi)localObject2).parseFrom((byte[])localObject1);
            }
            localavv.location = ((boi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257454);
          return 0;
        case 7: 
          localavv.ZFX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257454);
          return 0;
        case 8: 
          localavv.app_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257454);
          return 0;
        case 9: 
          localavv.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257454);
          return 0;
        case 10: 
          localavv.ZFY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257454);
          return 0;
        case 11: 
          localavv.ZFZ.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257454);
          return 0;
        case 12: 
          localavv.ZGa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257454);
          return 0;
        case 13: 
          localavv.AyD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257454);
          return 0;
        case 14: 
          localavv.ZGb.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257454);
          return 0;
        case 15: 
          localavv.ZGc.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257454);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cca)localObject2).parseFrom((byte[])localObject1);
            }
            localavv.ZGd = ((cca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257454);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqc)localObject2).parseFrom((byte[])localObject1);
          }
          localavv.ZGe = ((bqc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257454);
        return 0;
      }
      AppMethodBeat.o(257454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avv
 * JD-Core Version:    0.7.0.1
 */