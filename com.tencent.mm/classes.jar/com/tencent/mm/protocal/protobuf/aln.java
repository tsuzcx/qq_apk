package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aln
  extends com.tencent.mm.bx.a
{
  public String Gln;
  public int Glo;
  public LinkedList<amk> Glp;
  public LinkedList<String> Glq;
  public LinkedList<ejc> Oes;
  public String deviceBrand;
  public String deviceModel;
  public int netType;
  public String osName;
  public String osVersion;
  
  public aln()
  {
    AppMethodBeat.i(184195);
    this.Glp = new LinkedList();
    this.Glq = new LinkedList();
    this.Oes = new LinkedList();
    AppMethodBeat.o(184195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.netType);
      if (this.Gln != null) {
        paramVarArgs.d(2, this.Gln);
      }
      paramVarArgs.aS(3, this.Glo);
      paramVarArgs.e(4, 8, this.Glp);
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
      paramVarArgs.e(9, 1, this.Glq);
      paramVarArgs.e(10, 8, this.Oes);
      AppMethodBeat.o(184196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.netType) + 0;
      paramInt = i;
      if (this.Gln != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gln);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Glo) + f.a.a.a.c(4, 8, this.Glp);
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
      paramInt = f.a.a.a.c(9, 1, this.Glq);
      int j = f.a.a.a.c(10, 8, this.Oes);
      AppMethodBeat.o(184196);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Glp.clear();
      this.Glq.clear();
      this.Oes.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aln localaln = (aln)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184196);
        return -1;
      case 1: 
        localaln.netType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184196);
        return 0;
      case 2: 
        localaln.Gln = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 3: 
        localaln.Glo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184196);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaln.Glp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184196);
        return 0;
      case 5: 
        localaln.deviceModel = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 6: 
        localaln.deviceBrand = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 7: 
        localaln.osName = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 8: 
        localaln.osVersion = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184196);
        return 0;
      case 9: 
        localaln.Glq.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(184196);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ejc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ejc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaln.Oes.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aln
 * JD-Core Version:    0.7.0.1
 */