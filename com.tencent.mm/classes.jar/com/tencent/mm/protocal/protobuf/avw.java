package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class avw
  extends com.tencent.mm.bw.a
{
  public int FJl;
  public int GMS;
  public String GNc;
  public String GNd;
  public String GNe;
  public String GNf;
  public String GNg;
  public int GNh;
  public int GNi;
  public int GNj;
  public b GNk;
  public LinkedList<bpk> GNl;
  public String Title;
  public String hFS;
  public String nIJ;
  public String urq;
  
  public avw()
  {
    AppMethodBeat.i(218927);
    this.GNl = new LinkedList();
    AppMethodBeat.o(218927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GMS);
      if (this.GNc != null) {
        paramVarArgs.d(2, this.GNc);
      }
      if (this.GNd != null) {
        paramVarArgs.d(3, this.GNd);
      }
      paramVarArgs.aS(4, this.FJl);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.hFS != null) {
        paramVarArgs.d(6, this.hFS);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(7, this.nIJ);
      }
      if (this.GNe != null) {
        paramVarArgs.d(8, this.GNe);
      }
      if (this.urq != null) {
        paramVarArgs.d(10, this.urq);
      }
      if (this.GNf != null) {
        paramVarArgs.d(11, this.GNf);
      }
      if (this.GNg != null) {
        paramVarArgs.d(12, this.GNg);
      }
      paramVarArgs.aS(13, this.GNh);
      paramVarArgs.aS(14, this.GNi);
      paramVarArgs.aS(15, this.GNj);
      if (this.GNk != null) {
        paramVarArgs.c(16, this.GNk);
      }
      paramVarArgs.e(17, 8, this.GNl);
      AppMethodBeat.o(152549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GMS) + 0;
      paramInt = i;
      if (this.GNc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNc);
      }
      i = paramInt;
      if (this.GNd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GNd);
      }
      i += f.a.a.b.b.a.bz(4, this.FJl);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hFS);
      }
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nIJ);
      }
      i = paramInt;
      if (this.GNe != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GNe);
      }
      paramInt = i;
      if (this.urq != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.urq);
      }
      i = paramInt;
      if (this.GNf != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GNf);
      }
      paramInt = i;
      if (this.GNg != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GNg);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.GNh) + f.a.a.b.b.a.bz(14, this.GNi) + f.a.a.b.b.a.bz(15, this.GNj);
      paramInt = i;
      if (this.GNk != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.GNk);
      }
      i = f.a.a.a.c(17, 8, this.GNl);
      AppMethodBeat.o(152549);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GNl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avw localavw = (avw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localavw.GMS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localavw.GNc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localavw.GNd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localavw.FJl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localavw.Title = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localavw.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localavw.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localavw.GNe = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localavw.urq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localavw.GNf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localavw.GNg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localavw.GNh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 14: 
        localavw.GNi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 15: 
        localavw.GNj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 16: 
        localavw.GNk = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(152549);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bpk();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localavw.GNl.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avw
 * JD-Core Version:    0.7.0.1
 */