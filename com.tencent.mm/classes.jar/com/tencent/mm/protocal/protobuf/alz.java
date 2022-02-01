package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alz
  extends com.tencent.mm.bw.a
{
  public String GEp;
  public int GEq;
  public LinkedList<amw> GEr;
  public LinkedList<String> GEs;
  public LinkedList<anj> GEt;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public alz()
  {
    AppMethodBeat.i(184195);
    this.GEr = new LinkedList();
    this.GEs = new LinkedList();
    this.GEt = new LinkedList();
    AppMethodBeat.o(184195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.netType);
      if (this.GEp != null) {
        paramVarArgs.d(2, this.GEp);
      }
      paramVarArgs.aS(3, this.GEq);
      paramVarArgs.e(4, 8, this.GEr);
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
      paramVarArgs.e(9, 1, this.GEs);
      paramVarArgs.e(10, 8, this.GEt);
      AppMethodBeat.o(184196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.netType) + 0;
      paramInt = i;
      if (this.GEp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GEp);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GEq) + f.a.a.a.c(4, 8, this.GEr);
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
      paramInt = f.a.a.a.c(9, 1, this.GEs);
      int j = f.a.a.a.c(10, 8, this.GEt);
      AppMethodBeat.o(184196);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GEr.clear();
      this.GEs.clear();
      this.GEt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alz localalz = (alz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184196);
        return -1;
      case 1: 
        localalz.netType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184196);
        return 0;
      case 2: 
        localalz.GEp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 3: 
        localalz.GEq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184196);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalz.GEr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 5: 
        localalz.deviceModel = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 6: 
        localalz.deviceBrand = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 7: 
        localalz.osName = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 8: 
        localalz.osVersion = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 9: 
        localalz.GEs.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(184196);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new anj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((anj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localalz.GEt.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alz
 * JD-Core Version:    0.7.0.1
 */