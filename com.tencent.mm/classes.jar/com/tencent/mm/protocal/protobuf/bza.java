package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bza
  extends com.tencent.mm.bw.a
{
  public long HlU;
  public long HlV;
  public long HlW;
  public LinkedList<ehb> HlX;
  public long HlY;
  public boolean HlZ;
  public double Hma;
  public LinkedList<ehb> Hmb;
  public LinkedList<dqs> Hmc;
  public dps Hmd;
  public long begin_time;
  public long dmg;
  public long duration;
  public long id;
  public String path;
  
  public bza()
  {
    AppMethodBeat.i(110905);
    this.HlX = new LinkedList();
    this.Hmb = new LinkedList();
    this.Hmc = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.id);
      paramVarArgs.aZ(2, this.dmg);
      paramVarArgs.aZ(3, this.begin_time);
      paramVarArgs.aZ(4, this.duration);
      paramVarArgs.aZ(5, this.HlU);
      paramVarArgs.aZ(6, this.HlV);
      paramVarArgs.aZ(7, this.HlW);
      paramVarArgs.e(8, 8, this.HlX);
      paramVarArgs.aZ(9, this.HlY);
      paramVarArgs.bC(10, this.HlZ);
      paramVarArgs.e(11, this.Hma);
      paramVarArgs.e(12, 8, this.Hmb);
      paramVarArgs.e(13, 8, this.Hmc);
      if (this.Hmd != null)
      {
        paramVarArgs.lJ(14, this.Hmd.computeSize());
        this.Hmd.writeFields(paramVarArgs);
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
      i = f.a.a.b.b.a.p(1, this.id) + 0 + f.a.a.b.b.a.p(2, this.dmg) + f.a.a.b.b.a.p(3, this.begin_time) + f.a.a.b.b.a.p(4, this.duration) + f.a.a.b.b.a.p(5, this.HlU) + f.a.a.b.b.a.p(6, this.HlV) + f.a.a.b.b.a.p(7, this.HlW) + f.a.a.a.c(8, 8, this.HlX) + f.a.a.b.b.a.p(9, this.HlY) + f.a.a.b.b.a.amF(10) + f.a.a.b.b.a.amD(11) + f.a.a.a.c(12, 8, this.Hmb) + f.a.a.a.c(13, 8, this.Hmc);
      paramInt = i;
      if (this.Hmd != null) {
        paramInt = i + f.a.a.a.lI(14, this.Hmd.computeSize());
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
      this.HlX.clear();
      this.Hmb.clear();
      this.Hmc.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bza localbza = (bza)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localbza.id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localbza.dmg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localbza.begin_time = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localbza.duration = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localbza.HlU = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localbza.HlV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localbza.HlW = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbza.HlX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localbza.HlY = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localbza.HlZ = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localbza.Hma = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbza.Hmb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbza.Hmc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dps();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbza.Hmd = ((dps)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localbza.path = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bza
 * JD-Core Version:    0.7.0.1
 */