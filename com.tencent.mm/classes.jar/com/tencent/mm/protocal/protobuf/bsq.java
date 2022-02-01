package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bsq
  extends com.tencent.mm.bw.a
{
  public float FhB;
  public float FhC;
  public String FhD;
  public LinkedList<String> FhE;
  public String FhF;
  public LinkedList<String> FhG;
  public LinkedList<bsr> FhH;
  public LinkedList<bso> FhI;
  public int FhJ;
  public int Fhx;
  public int djq;
  public int duration;
  public String hlq;
  public String iAB;
  
  public bsq()
  {
    AppMethodBeat.i(169924);
    this.FhE = new LinkedList();
    this.FhG = new LinkedList();
    this.FhH = new LinkedList();
    this.FhI = new LinkedList();
    this.FhJ = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FhD == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Fhx);
      paramVarArgs.x(2, this.FhB);
      paramVarArgs.x(3, this.FhC);
      if (this.FhD != null) {
        paramVarArgs.d(4, this.FhD);
      }
      paramVarArgs.e(5, 1, this.FhE);
      if (this.FhF != null) {
        paramVarArgs.d(6, this.FhF);
      }
      paramVarArgs.e(7, 1, this.FhG);
      paramVarArgs.e(8, 8, this.FhH);
      if (this.iAB != null) {
        paramVarArgs.d(9, this.iAB);
      }
      if (this.hlq != null) {
        paramVarArgs.d(10, this.hlq);
      }
      paramVarArgs.e(11, 8, this.FhI);
      paramVarArgs.aR(12, this.djq);
      paramVarArgs.aR(13, this.duration);
      paramVarArgs.aR(14, this.FhJ);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Fhx) + 0 + (f.a.a.b.b.a.fK(2) + 4) + (f.a.a.b.b.a.fK(3) + 4);
      paramInt = i;
      if (this.FhD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FhD);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.FhE);
      paramInt = i;
      if (this.FhF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FhF);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.FhG) + f.a.a.a.c(8, 8, this.FhH);
      paramInt = i;
      if (this.iAB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iAB);
      }
      i = paramInt;
      if (this.hlq != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.hlq);
      }
      paramInt = f.a.a.a.c(11, 8, this.FhI);
      int j = f.a.a.b.b.a.bx(12, this.djq);
      int k = f.a.a.b.b.a.bx(13, this.duration);
      int m = f.a.a.b.b.a.bx(14, this.FhJ);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FhE.clear();
      this.FhG.clear();
      this.FhH.clear();
      this.FhI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FhD == null)
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
      bsq localbsq = (bsq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localbsq.Fhx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localbsq.FhB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localbsq.FhC = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localbsq.FhD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localbsq.FhE.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localbsq.FhF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localbsq.FhG.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsq.FhH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localbsq.iAB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localbsq.hlq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bso();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bso)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsq.FhI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localbsq.djq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localbsq.duration = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169925);
        return 0;
      }
      localbsq.FhJ = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsq
 * JD-Core Version:    0.7.0.1
 */