package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqo
  extends com.tencent.mm.cd.a
{
  public String SDN;
  public int SDO;
  public LinkedList<asb> SDP;
  public LinkedList<String> SDQ;
  public LinkedList<asy> SDR;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public aqo()
  {
    AppMethodBeat.i(184195);
    this.SDP = new LinkedList();
    this.SDQ = new LinkedList();
    this.SDR = new LinkedList();
    AppMethodBeat.o(184195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184196);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.netType);
      if (this.SDN != null) {
        paramVarArgs.f(2, this.SDN);
      }
      paramVarArgs.aY(3, this.SDO);
      paramVarArgs.e(4, 8, this.SDP);
      if (this.deviceModel != null) {
        paramVarArgs.f(5, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.f(6, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.f(7, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.f(8, this.osVersion);
      }
      paramVarArgs.e(9, 1, this.SDQ);
      paramVarArgs.e(10, 8, this.SDR);
      AppMethodBeat.o(184196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.netType) + 0;
      paramInt = i;
      if (this.SDN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SDN);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SDO) + g.a.a.a.c(4, 8, this.SDP);
      paramInt = i;
      if (this.deviceModel != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.deviceModel);
      }
      i = paramInt;
      if (this.deviceBrand != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.deviceBrand);
      }
      paramInt = i;
      if (this.osName != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.osName);
      }
      i = paramInt;
      if (this.osVersion != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.osVersion);
      }
      paramInt = g.a.a.a.c(9, 1, this.SDQ);
      int j = g.a.a.a.c(10, 8, this.SDR);
      AppMethodBeat.o(184196);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SDP.clear();
      this.SDQ.clear();
      this.SDR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aqo localaqo = (aqo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184196);
        return -1;
      case 1: 
        localaqo.netType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(184196);
        return 0;
      case 2: 
        localaqo.SDN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 3: 
        localaqo.SDO = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(184196);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asb)localObject2).parseFrom((byte[])localObject1);
          }
          localaqo.SDP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 5: 
        localaqo.deviceModel = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 6: 
        localaqo.deviceBrand = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 7: 
        localaqo.osName = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 8: 
        localaqo.osVersion = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 9: 
        localaqo.SDQ.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(184196);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new asy();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((asy)localObject2).parseFrom((byte[])localObject1);
        }
        localaqo.SDR.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqo
 * JD-Core Version:    0.7.0.1
 */