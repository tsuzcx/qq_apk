package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dni
  extends com.tencent.mm.bx.a
{
  public String FIi;
  public int FXJ;
  public String GsT;
  public LinkedList<dnh> HBq;
  public boolean HBr;
  public LinkedList<dnk> HBs;
  public String HBt;
  public int HnC;
  public String Md5;
  public int Version;
  public int nEf;
  
  public dni()
  {
    AppMethodBeat.i(6438);
    this.HBq = new LinkedList();
    this.HBs = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      paramVarArgs.aS(2, this.Version);
      if (this.FIi != null) {
        paramVarArgs.d(3, this.FIi);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aS(5, this.FXJ);
      paramVarArgs.aS(6, this.HnC);
      paramVarArgs.e(7, 8, this.HBq);
      paramVarArgs.bt(8, this.HBr);
      if (this.GsT != null) {
        paramVarArgs.d(9, this.GsT);
      }
      paramVarArgs.e(10, 8, this.HBs);
      if (this.HBt != null) {
        paramVarArgs.d(11, this.HBt);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0 + f.a.a.b.b.a.bz(2, this.Version);
      paramInt = i;
      if (this.FIi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FIi);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = i + f.a.a.b.b.a.bz(5, this.FXJ) + f.a.a.b.b.a.bz(6, this.HnC) + f.a.a.a.c(7, 8, this.HBq) + f.a.a.b.b.a.alV(8);
      paramInt = i;
      if (this.GsT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GsT);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.HBs);
      paramInt = i;
      if (this.HBt != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HBt);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HBq.clear();
      this.HBs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dni localdni = (dni)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localdni.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localdni.Version = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localdni.FIi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localdni.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localdni.FXJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localdni.HnC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdni.HBq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localdni.HBr = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localdni.GsT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdni.HBs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localdni.HBt = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dni
 * JD-Core Version:    0.7.0.1
 */