package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnk
  extends com.tencent.mm.bw.a
{
  public String LBe;
  public int LBf;
  public LinkedList<cno> LBg;
  public LinkedList<cnv> LBi;
  public LinkedList<String> MtQ;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public cnk()
  {
    AppMethodBeat.i(209736);
    this.LBg = new LinkedList();
    this.MtQ = new LinkedList();
    this.LBi = new LinkedList();
    AppMethodBeat.o(209736);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209737);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.netType);
      if (this.LBe != null) {
        paramVarArgs.e(2, this.LBe);
      }
      paramVarArgs.aM(3, this.LBf);
      paramVarArgs.e(4, 8, this.LBg);
      if (this.deviceModel != null) {
        paramVarArgs.e(5, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.e(6, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.e(7, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.e(8, this.osVersion);
      }
      paramVarArgs.e(9, 1, this.MtQ);
      paramVarArgs.e(10, 8, this.LBi);
      AppMethodBeat.o(209737);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.netType) + 0;
      paramInt = i;
      if (this.LBe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LBe);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.LBf) + g.a.a.a.c(4, 8, this.LBg);
      paramInt = i;
      if (this.deviceModel != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.deviceModel);
      }
      i = paramInt;
      if (this.deviceBrand != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.deviceBrand);
      }
      paramInt = i;
      if (this.osName != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.osName);
      }
      i = paramInt;
      if (this.osVersion != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.osVersion);
      }
      paramInt = g.a.a.a.c(9, 1, this.MtQ);
      int j = g.a.a.a.c(10, 8, this.LBi);
      AppMethodBeat.o(209737);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LBg.clear();
      this.MtQ.clear();
      this.LBi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209737);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cnk localcnk = (cnk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209737);
        return -1;
      case 1: 
        localcnk.netType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209737);
        return 0;
      case 2: 
        localcnk.LBe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209737);
        return 0;
      case 3: 
        localcnk.LBf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209737);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cno();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cno)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnk.LBg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209737);
        return 0;
      case 5: 
        localcnk.deviceModel = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209737);
        return 0;
      case 6: 
        localcnk.deviceBrand = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209737);
        return 0;
      case 7: 
        localcnk.osName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209737);
        return 0;
      case 8: 
        localcnk.osVersion = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209737);
        return 0;
      case 9: 
        localcnk.MtQ.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(209737);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cnv();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cnv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcnk.LBi.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209737);
      return 0;
    }
    AppMethodBeat.o(209737);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnk
 * JD-Core Version:    0.7.0.1
 */