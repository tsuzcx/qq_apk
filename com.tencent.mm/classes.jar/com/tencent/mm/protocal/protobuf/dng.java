package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dng
  extends com.tencent.mm.bx.a
{
  public String ZEZ;
  public int ZFa;
  public LinkedList<dnk> ZFb;
  public LinkedList<dnr> ZFd;
  public LinkedList<String> aaUB;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public dng()
  {
    AppMethodBeat.i(258678);
    this.ZFb = new LinkedList();
    this.aaUB = new LinkedList();
    this.ZFd = new LinkedList();
    AppMethodBeat.o(258678);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258681);
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
      paramVarArgs.e(9, 1, this.aaUB);
      paramVarArgs.e(10, 8, this.ZFd);
      AppMethodBeat.o(258681);
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
      paramInt = i.a.a.a.c(9, 1, this.aaUB);
      int j = i.a.a.a.c(10, 8, this.ZFd);
      AppMethodBeat.o(258681);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZFb.clear();
      this.aaUB.clear();
      this.ZFd.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258681);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dng localdng = (dng)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258681);
        return -1;
      case 1: 
        localdng.netType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258681);
        return 0;
      case 2: 
        localdng.ZEZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258681);
        return 0;
      case 3: 
        localdng.ZFa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258681);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dnk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dnk)localObject2).parseFrom((byte[])localObject1);
          }
          localdng.ZFb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258681);
        return 0;
      case 5: 
        localdng.deviceModel = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258681);
        return 0;
      case 6: 
        localdng.deviceBrand = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258681);
        return 0;
      case 7: 
        localdng.osName = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258681);
        return 0;
      case 8: 
        localdng.osVersion = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258681);
        return 0;
      case 9: 
        localdng.aaUB.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(258681);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dnr();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dnr)localObject2).parseFrom((byte[])localObject1);
        }
        localdng.ZFd.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258681);
      return 0;
    }
    AppMethodBeat.o(258681);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dng
 * JD-Core Version:    0.7.0.1
 */