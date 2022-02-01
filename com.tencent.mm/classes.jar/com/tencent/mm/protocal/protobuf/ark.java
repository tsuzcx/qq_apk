package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ark
  extends com.tencent.mm.bw.a
{
  public int DLI;
  public String EKB;
  public String EKC;
  public String EKD;
  public String EKE;
  public String EKF;
  public int EKG;
  public int EKH;
  public int EKI;
  public LinkedList<bki> EKJ;
  public int EKs;
  public b Jsk;
  public String Title;
  public String hkR;
  public String ncR;
  public String tLG;
  
  public ark()
  {
    AppMethodBeat.i(192712);
    this.EKJ = new LinkedList();
    AppMethodBeat.o(192712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EKs);
      if (this.EKB != null) {
        paramVarArgs.d(2, this.EKB);
      }
      if (this.EKC != null) {
        paramVarArgs.d(3, this.EKC);
      }
      paramVarArgs.aR(4, this.DLI);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.hkR != null) {
        paramVarArgs.d(6, this.hkR);
      }
      if (this.ncR != null) {
        paramVarArgs.d(7, this.ncR);
      }
      if (this.EKD != null) {
        paramVarArgs.d(8, this.EKD);
      }
      if (this.tLG != null) {
        paramVarArgs.d(10, this.tLG);
      }
      if (this.EKE != null) {
        paramVarArgs.d(11, this.EKE);
      }
      if (this.EKF != null) {
        paramVarArgs.d(12, this.EKF);
      }
      paramVarArgs.aR(13, this.EKG);
      paramVarArgs.aR(14, this.EKH);
      paramVarArgs.aR(15, this.EKI);
      if (this.Jsk != null) {
        paramVarArgs.c(16, this.Jsk);
      }
      paramVarArgs.e(17, 8, this.EKJ);
      AppMethodBeat.o(152549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EKs) + 0;
      paramInt = i;
      if (this.EKB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EKB);
      }
      i = paramInt;
      if (this.EKC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EKC);
      }
      i += f.a.a.b.b.a.bx(4, this.DLI);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hkR);
      }
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ncR);
      }
      i = paramInt;
      if (this.EKD != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EKD);
      }
      paramInt = i;
      if (this.tLG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.tLG);
      }
      i = paramInt;
      if (this.EKE != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EKE);
      }
      paramInt = i;
      if (this.EKF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EKF);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.EKG) + f.a.a.b.b.a.bx(14, this.EKH) + f.a.a.b.b.a.bx(15, this.EKI);
      paramInt = i;
      if (this.Jsk != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.Jsk);
      }
      i = f.a.a.a.c(17, 8, this.EKJ);
      AppMethodBeat.o(152549);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EKJ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ark localark = (ark)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localark.EKs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localark.EKB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localark.EKC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localark.DLI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localark.Title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localark.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localark.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localark.EKD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localark.tLG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localark.EKE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localark.EKF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localark.EKG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152549);
        return 0;
      case 14: 
        localark.EKH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152549);
        return 0;
      case 15: 
        localark.EKI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152549);
        return 0;
      case 16: 
        localark.Jsk = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(152549);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bki();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bki)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localark.EKJ.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ark
 * JD-Core Version:    0.7.0.1
 */