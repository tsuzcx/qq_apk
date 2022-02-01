package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bts
  extends com.tencent.mm.bw.a
{
  public long FiS;
  public long FiT;
  public long FiU;
  public LinkedList<dzi> FiV;
  public long FiW;
  public boolean FiX;
  public double FiY;
  public LinkedList<dzi> FiZ;
  public LinkedList<dke> Fja;
  public djg Fjb;
  public long begin_time;
  public long cZM;
  public long duration;
  public long id;
  public String path;
  
  public bts()
  {
    AppMethodBeat.i(110905);
    this.FiV = new LinkedList();
    this.FiZ = new LinkedList();
    this.Fja = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      paramVarArgs.aO(2, this.cZM);
      paramVarArgs.aO(3, this.begin_time);
      paramVarArgs.aO(4, this.duration);
      paramVarArgs.aO(5, this.FiS);
      paramVarArgs.aO(6, this.FiT);
      paramVarArgs.aO(7, this.FiU);
      paramVarArgs.e(8, 8, this.FiV);
      paramVarArgs.aO(9, this.FiW);
      paramVarArgs.bl(10, this.FiX);
      paramVarArgs.e(11, this.FiY);
      paramVarArgs.e(12, 8, this.FiZ);
      paramVarArgs.e(13, 8, this.Fja);
      if (this.Fjb != null)
      {
        paramVarArgs.ln(14, this.Fjb.computeSize());
        this.Fjb.writeFields(paramVarArgs);
      }
      if (this.path != null) {
        paramVarArgs.d(15, this.path);
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.id) + 0 + f.a.a.b.b.a.p(2, this.cZM) + f.a.a.b.b.a.p(3, this.begin_time) + f.a.a.b.b.a.p(4, this.duration) + f.a.a.b.b.a.p(5, this.FiS) + f.a.a.b.b.a.p(6, this.FiT) + f.a.a.b.b.a.p(7, this.FiU) + f.a.a.a.c(8, 8, this.FiV) + f.a.a.b.b.a.p(9, this.FiW) + (f.a.a.b.b.a.fK(10) + 1) + (f.a.a.b.b.a.fK(11) + 8) + f.a.a.a.c(12, 8, this.FiZ) + f.a.a.a.c(13, 8, this.Fja);
      paramInt = i;
      if (this.Fjb != null) {
        paramInt = i + f.a.a.a.lm(14, this.Fjb.computeSize());
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.path);
      }
      AppMethodBeat.o(110906);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FiV.clear();
      this.FiZ.clear();
      this.Fja.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bts localbts = (bts)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localbts.id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localbts.cZM = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localbts.begin_time = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localbts.duration = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localbts.FiS = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localbts.FiT = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localbts.FiU = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbts.FiV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localbts.FiW = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localbts.FiX = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localbts.FiY = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbts.FiZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dke();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dke)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbts.Fja.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbts.Fjb = ((djg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localbts.path = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bts
 * JD-Core Version:    0.7.0.1
 */