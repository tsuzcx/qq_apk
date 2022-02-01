package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aix
  extends com.tencent.mm.bw.a
{
  public String EDD;
  public int EDE;
  public LinkedList<ajp> EDF;
  public LinkedList<String> EDG;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public aix()
  {
    AppMethodBeat.i(184195);
    this.EDF = new LinkedList();
    this.EDG = new LinkedList();
    AppMethodBeat.o(184195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.netType);
      if (this.EDD != null) {
        paramVarArgs.d(2, this.EDD);
      }
      paramVarArgs.aR(3, this.EDE);
      paramVarArgs.e(4, 8, this.EDF);
      if (this.deviceModel != null) {
        paramVarArgs.d(5, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.d(6, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.d(7, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.d(8, this.osVersion);
      }
      paramVarArgs.e(9, 1, this.EDG);
      AppMethodBeat.o(184196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.netType) + 0;
      paramInt = i;
      if (this.EDD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EDD);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EDE) + f.a.a.a.c(4, 8, this.EDF);
      paramInt = i;
      if (this.deviceModel != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.deviceModel);
      }
      i = paramInt;
      if (this.deviceBrand != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.deviceBrand);
      }
      paramInt = i;
      if (this.osName != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.osName);
      }
      i = paramInt;
      if (this.osVersion != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.osVersion);
      }
      paramInt = f.a.a.a.c(9, 1, this.EDG);
      AppMethodBeat.o(184196);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EDF.clear();
      this.EDG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aix localaix = (aix)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184196);
        return -1;
      case 1: 
        localaix.netType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184196);
        return 0;
      case 2: 
        localaix.EDD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 3: 
        localaix.EDE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184196);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ajp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaix.EDF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 5: 
        localaix.deviceModel = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 6: 
        localaix.deviceBrand = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 7: 
        localaix.osName = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 8: 
        localaix.osVersion = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184196);
        return 0;
      }
      localaix.EDG.add(((f.a.a.a.a)localObject1).LVo.readString());
      AppMethodBeat.o(184196);
      return 0;
    }
    AppMethodBeat.o(184196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aix
 * JD-Core Version:    0.7.0.1
 */