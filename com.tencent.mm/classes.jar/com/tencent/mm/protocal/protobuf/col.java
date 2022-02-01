package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class col
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String GnN;
  public String GnO;
  public int HAo;
  public String HAp;
  public int HAq;
  public String HAr;
  public dia HhA;
  public aco HhB;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public int jfZ;
  public String jga;
  public int jgb;
  public int jgc;
  public String jgd;
  public String jge;
  public String jgf;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HAo);
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.HAp != null) {
        paramVarArgs.d(4, this.HAp);
      }
      paramVarArgs.aS(5, this.HAq);
      if (this.HAr != null) {
        paramVarArgs.d(6, this.HAr);
      }
      paramVarArgs.aS(7, this.jfV);
      if (this.jfW != null) {
        paramVarArgs.d(8, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(9, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(10, this.jfY);
      }
      paramVarArgs.aS(11, this.jfZ);
      if (this.jga != null) {
        paramVarArgs.d(12, this.jga);
      }
      paramVarArgs.aS(13, this.jgb);
      paramVarArgs.aS(14, this.jgc);
      if (this.jgd != null) {
        paramVarArgs.d(15, this.jgd);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(16, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(17, this.jge);
      }
      if (this.jgf != null) {
        paramVarArgs.d(18, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(19, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.GnN != null) {
        paramVarArgs.d(20, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(21, this.GnO);
      }
      if (this.GNI != null) {
        paramVarArgs.d(22, this.GNI);
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HAo) + 0;
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      paramInt = i;
      if (this.HAp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HAp);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HAq);
      paramInt = i;
      if (this.HAr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HAr);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jfV);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.jfZ);
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.jga);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.jgb) + f.a.a.b.b.a.bz(14, this.jgc);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jgd);
      }
      i = paramInt;
      if (this.HhA != null) {
        i = paramInt + f.a.a.a.lI(16, this.HhA.computeSize());
      }
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.jge);
      }
      i = paramInt;
      if (this.jgf != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.jgf);
      }
      paramInt = i;
      if (this.HhB != null) {
        paramInt = i + f.a.a.a.lI(19, this.HhB.computeSize());
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GnO);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.GNI);
      }
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      col localcol = (col)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localcol.HAo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localcol.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localcol.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localcol.HAp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localcol.HAq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localcol.HAr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localcol.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localcol.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localcol.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localcol.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localcol.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localcol.jga = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localcol.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localcol.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localcol.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dia();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcol.HhA = ((dia)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localcol.jge = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localcol.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aco();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcol.HhB = ((aco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localcol.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localcol.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localcol.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.col
 * JD-Core Version:    0.7.0.1
 */