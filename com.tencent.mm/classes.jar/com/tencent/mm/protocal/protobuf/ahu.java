package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahu
  extends com.tencent.mm.bx.a
{
  public String Dkp;
  public int Dkq;
  public LinkedList<aif> Dkr;
  public LinkedList<String> Dks;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public ahu()
  {
    AppMethodBeat.i(184195);
    this.Dkr = new LinkedList();
    this.Dks = new LinkedList();
    AppMethodBeat.o(184195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.netType);
      if (this.Dkp != null) {
        paramVarArgs.d(2, this.Dkp);
      }
      paramVarArgs.aR(3, this.Dkq);
      paramVarArgs.e(4, 8, this.Dkr);
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
      paramVarArgs.e(9, 1, this.Dks);
      AppMethodBeat.o(184196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.netType) + 0;
      paramInt = i;
      if (this.Dkp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dkp);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.Dkq) + f.a.a.a.c(4, 8, this.Dkr);
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
      paramInt = f.a.a.a.c(9, 1, this.Dks);
      AppMethodBeat.o(184196);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dkr.clear();
      this.Dks.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahu localahu = (ahu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184196);
        return -1;
      case 1: 
        localahu.netType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184196);
        return 0;
      case 2: 
        localahu.Dkp = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 3: 
        localahu.Dkq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184196);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aif();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahu.Dkr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 5: 
        localahu.deviceModel = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 6: 
        localahu.deviceBrand = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 7: 
        localahu.osName = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 8: 
        localahu.osVersion = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184196);
        return 0;
      }
      localahu.Dks.add(((f.a.a.a.a)localObject1).KhF.readString());
      AppMethodBeat.o(184196);
      return 0;
    }
    AppMethodBeat.o(184196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahu
 * JD-Core Version:    0.7.0.1
 */