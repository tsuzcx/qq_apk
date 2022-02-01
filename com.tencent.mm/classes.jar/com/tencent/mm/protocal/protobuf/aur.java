package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aur
  extends com.tencent.mm.bx.a
{
  public int YDV;
  public String ZEZ;
  public int ZFa;
  public LinkedList<awn> ZFb;
  public LinkedList<String> ZFc;
  public LinkedList<axm> ZFd;
  public int ZFe;
  public LinkedList<akz> ZFf;
  public LinkedList<akz> ZFg;
  public LinkedList<awn> ZFh;
  public String Zsk;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public aur()
  {
    AppMethodBeat.i(184195);
    this.ZFb = new LinkedList();
    this.ZFc = new LinkedList();
    this.ZFd = new LinkedList();
    this.ZFf = new LinkedList();
    this.ZFg = new LinkedList();
    this.ZFh = new LinkedList();
    AppMethodBeat.o(184195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184196);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.netType);
      if (this.ZEZ != null) {
        paramVarArgs.g(2, this.ZEZ);
      }
      paramVarArgs.bS(3, this.ZFa);
      paramVarArgs.e(4, 8, this.ZFb);
      if (this.deviceModel != null) {
        paramVarArgs.g(5, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.g(6, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.g(7, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.g(8, this.osVersion);
      }
      paramVarArgs.e(9, 1, this.ZFc);
      paramVarArgs.e(10, 8, this.ZFd);
      paramVarArgs.bS(11, this.ZFe);
      paramVarArgs.bS(12, this.YDV);
      if (this.Zsk != null) {
        paramVarArgs.g(13, this.Zsk);
      }
      paramVarArgs.e(14, 8, this.ZFf);
      paramVarArgs.e(15, 8, this.ZFg);
      paramVarArgs.e(16, 8, this.ZFh);
      AppMethodBeat.o(184196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.netType) + 0;
      paramInt = i;
      if (this.ZEZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZEZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZFa) + i.a.a.a.c(4, 8, this.ZFb);
      paramInt = i;
      if (this.deviceModel != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.deviceModel);
      }
      i = paramInt;
      if (this.deviceBrand != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.deviceBrand);
      }
      paramInt = i;
      if (this.osName != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.osName);
      }
      i = paramInt;
      if (this.osVersion != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.osVersion);
      }
      i = i + i.a.a.a.c(9, 1, this.ZFc) + i.a.a.a.c(10, 8, this.ZFd) + i.a.a.b.b.a.cJ(11, this.ZFe) + i.a.a.b.b.a.cJ(12, this.YDV);
      paramInt = i;
      if (this.Zsk != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Zsk);
      }
      i = i.a.a.a.c(14, 8, this.ZFf);
      int j = i.a.a.a.c(15, 8, this.ZFg);
      int k = i.a.a.a.c(16, 8, this.ZFh);
      AppMethodBeat.o(184196);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZFb.clear();
      this.ZFc.clear();
      this.ZFd.clear();
      this.ZFf.clear();
      this.ZFg.clear();
      this.ZFh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      aur localaur = (aur)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184196);
        return -1;
      case 1: 
        localaur.netType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184196);
        return 0;
      case 2: 
        localaur.ZEZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 3: 
        localaur.ZFa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184196);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new awn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((awn)localObject2).parseFrom((byte[])localObject1);
          }
          localaur.ZFb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 5: 
        localaur.deviceModel = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 6: 
        localaur.deviceBrand = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 7: 
        localaur.osName = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 8: 
        localaur.osVersion = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 9: 
        localaur.ZFc.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(184196);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new axm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((axm)localObject2).parseFrom((byte[])localObject1);
          }
          localaur.ZFd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 11: 
        localaur.ZFe = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184196);
        return 0;
      case 12: 
        localaur.YDV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184196);
        return 0;
      case 13: 
        localaur.Zsk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 14: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akz)localObject2).parseFrom((byte[])localObject1);
          }
          localaur.ZFf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akz)localObject2).parseFrom((byte[])localObject1);
          }
          localaur.ZFg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new awn();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((awn)localObject2).parseFrom((byte[])localObject1);
        }
        localaur.ZFh.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    AppMethodBeat.o(184196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aur
 * JD-Core Version:    0.7.0.1
 */