package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byq
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public int GPx;
  public int GSK;
  public byi GTC;
  public int GTD;
  public LinkedList<byi> GTE;
  public String GTF;
  public String GTG;
  public String GTH;
  public bxm GTI;
  public int GTJ;
  public String GTd;
  public int GTf;
  public int GTg;
  public int GTo;
  public String GTp;
  public int beN;
  public int dqR;
  public String duW;
  public int hfV;
  public String md5;
  public String token;
  public String videoPath;
  
  public byq()
  {
    AppMethodBeat.i(125747);
    this.GTE = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GTf);
      paramVarArgs.aS(2, this.GTg);
      paramVarArgs.aS(3, this.GSK);
      if (this.GTC != null)
      {
        paramVarArgs.lC(4, this.GTC.computeSize());
        this.GTC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GTD);
      paramVarArgs.e(6, 8, this.GTE);
      paramVarArgs.aS(7, this.hfV);
      paramVarArgs.aS(8, this.GPx);
      if (this.Desc != null) {
        paramVarArgs.d(9, this.Desc);
      }
      if (this.GTF != null) {
        paramVarArgs.d(10, this.GTF);
      }
      if (this.token != null) {
        paramVarArgs.d(11, this.token);
      }
      if (this.GTp != null) {
        paramVarArgs.d(12, this.GTp);
      }
      paramVarArgs.aS(13, this.GTo);
      if (this.videoPath != null) {
        paramVarArgs.d(14, this.videoPath);
      }
      if (this.GTG != null) {
        paramVarArgs.d(15, this.GTG);
      }
      if (this.GTH != null) {
        paramVarArgs.d(16, this.GTH);
      }
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.duW != null) {
        paramVarArgs.d(18, this.duW);
      }
      paramVarArgs.aS(19, this.beN);
      paramVarArgs.aS(20, this.dqR);
      if (this.GTd != null) {
        paramVarArgs.d(21, this.GTd);
      }
      if (this.GTI != null)
      {
        paramVarArgs.lC(22, this.GTI.computeSize());
        this.GTI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(23, this.GTJ);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GTf) + 0 + f.a.a.b.b.a.bz(2, this.GTg) + f.a.a.b.b.a.bz(3, this.GSK);
      paramInt = i;
      if (this.GTC != null) {
        paramInt = i + f.a.a.a.lB(4, this.GTC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GTD) + f.a.a.a.c(6, 8, this.GTE) + f.a.a.b.b.a.bz(7, this.hfV) + f.a.a.b.b.a.bz(8, this.GPx);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Desc);
      }
      i = paramInt;
      if (this.GTF != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GTF);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.token);
      }
      i = paramInt;
      if (this.GTp != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GTp);
      }
      i += f.a.a.b.b.a.bz(13, this.GTo);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.videoPath);
      }
      i = paramInt;
      if (this.GTG != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GTG);
      }
      paramInt = i;
      if (this.GTH != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GTH);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.md5);
      }
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.duW);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.beN) + f.a.a.b.b.a.bz(20, this.dqR);
      paramInt = i;
      if (this.GTd != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GTd);
      }
      i = paramInt;
      if (this.GTI != null) {
        i = paramInt + f.a.a.a.lB(22, this.GTI.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(23, this.GTJ);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GTE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byq localbyq = (byq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localbyq.GTf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localbyq.GTg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localbyq.GSK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyq.GTC = ((byi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localbyq.GTD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyq.GTE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localbyq.hfV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localbyq.GPx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localbyq.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localbyq.GTF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localbyq.token = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localbyq.GTp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localbyq.GTo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localbyq.videoPath = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localbyq.GTG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localbyq.GTH = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localbyq.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localbyq.duW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localbyq.beN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localbyq.dqR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localbyq.GTd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyq.GTI = ((bxm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localbyq.GTJ = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byq
 * JD-Core Version:    0.7.0.1
 */