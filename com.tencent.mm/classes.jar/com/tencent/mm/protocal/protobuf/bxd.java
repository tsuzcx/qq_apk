package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxd
  extends com.tencent.mm.bx.a
{
  public int GQZ;
  public float GRd;
  public float GRe;
  public String GRf;
  public LinkedList<String> GRg;
  public String GRh;
  public LinkedList<String> GRi;
  public LinkedList<bxe> GRj;
  public LinkedList<bxb> GRk;
  public int GRl;
  public int duration;
  public int dvd;
  public String hDz;
  public String iTL;
  
  public bxd()
  {
    AppMethodBeat.i(169924);
    this.GRg = new LinkedList();
    this.GRi = new LinkedList();
    this.GRj = new LinkedList();
    this.GRk = new LinkedList();
    this.GRl = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GRf == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GQZ);
      paramVarArgs.z(2, this.GRd);
      paramVarArgs.z(3, this.GRe);
      if (this.GRf != null) {
        paramVarArgs.d(4, this.GRf);
      }
      paramVarArgs.e(5, 1, this.GRg);
      if (this.GRh != null) {
        paramVarArgs.d(6, this.GRh);
      }
      paramVarArgs.e(7, 1, this.GRi);
      paramVarArgs.e(8, 8, this.GRj);
      if (this.iTL != null) {
        paramVarArgs.d(9, this.iTL);
      }
      if (this.hDz != null) {
        paramVarArgs.d(10, this.hDz);
      }
      paramVarArgs.e(11, 8, this.GRk);
      paramVarArgs.aS(12, this.dvd);
      paramVarArgs.aS(13, this.duration);
      paramVarArgs.aS(14, this.GRl);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GQZ) + 0 + f.a.a.b.b.a.alU(2) + f.a.a.b.b.a.alU(3);
      paramInt = i;
      if (this.GRf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GRf);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.GRg);
      paramInt = i;
      if (this.GRh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GRh);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.GRi) + f.a.a.a.c(8, 8, this.GRj);
      paramInt = i;
      if (this.iTL != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iTL);
      }
      i = paramInt;
      if (this.hDz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.hDz);
      }
      paramInt = f.a.a.a.c(11, 8, this.GRk);
      int j = f.a.a.b.b.a.bz(12, this.dvd);
      int k = f.a.a.b.b.a.bz(13, this.duration);
      int m = f.a.a.b.b.a.bz(14, this.GRl);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GRg.clear();
      this.GRi.clear();
      this.GRj.clear();
      this.GRk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.GRf == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      AppMethodBeat.o(169925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxd localbxd = (bxd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localbxd.GQZ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localbxd.GRd = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localbxd.GRe = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localbxd.GRf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localbxd.GRg.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localbxd.GRh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localbxd.GRi.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxd.GRj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localbxd.iTL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localbxd.hDz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxd.GRk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localbxd.dvd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localbxd.duration = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169925);
        return 0;
      }
      localbxd.GRl = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxd
 * JD-Core Version:    0.7.0.1
 */