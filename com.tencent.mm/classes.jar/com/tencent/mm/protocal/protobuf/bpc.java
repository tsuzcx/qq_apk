package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpc
  extends com.tencent.mm.bx.a
{
  public long DMC;
  public long DMD;
  public long DME;
  public LinkedList<dtr> DMF;
  public long DMG;
  public boolean DMH;
  public double DMI;
  public LinkedList<dtr> DMJ;
  public LinkedList<dep> DMK;
  public ddr DML;
  public long begin_time;
  public long dcn;
  public long duration;
  public long id;
  public String path;
  
  public bpc()
  {
    AppMethodBeat.i(110905);
    this.DMF = new LinkedList();
    this.DMJ = new LinkedList();
    this.DMK = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.id);
      paramVarArgs.aG(2, this.dcn);
      paramVarArgs.aG(3, this.begin_time);
      paramVarArgs.aG(4, this.duration);
      paramVarArgs.aG(5, this.DMC);
      paramVarArgs.aG(6, this.DMD);
      paramVarArgs.aG(7, this.DME);
      paramVarArgs.e(8, 8, this.DMF);
      paramVarArgs.aG(9, this.DMG);
      paramVarArgs.bg(10, this.DMH);
      paramVarArgs.e(11, this.DMI);
      paramVarArgs.e(12, 8, this.DMJ);
      paramVarArgs.e(13, 8, this.DMK);
      if (this.DML != null)
      {
        paramVarArgs.kX(14, this.DML.computeSize());
        this.DML.writeFields(paramVarArgs);
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
      i = f.a.a.b.b.a.q(1, this.id) + 0 + f.a.a.b.b.a.q(2, this.dcn) + f.a.a.b.b.a.q(3, this.begin_time) + f.a.a.b.b.a.q(4, this.duration) + f.a.a.b.b.a.q(5, this.DMC) + f.a.a.b.b.a.q(6, this.DMD) + f.a.a.b.b.a.q(7, this.DME) + f.a.a.a.c(8, 8, this.DMF) + f.a.a.b.b.a.q(9, this.DMG) + (f.a.a.b.b.a.fY(10) + 1) + (f.a.a.b.b.a.fY(11) + 8) + f.a.a.a.c(12, 8, this.DMJ) + f.a.a.a.c(13, 8, this.DMK);
      paramInt = i;
      if (this.DML != null) {
        paramInt = i + f.a.a.a.kW(14, this.DML.computeSize());
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
      this.DMF.clear();
      this.DMJ.clear();
      this.DMK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpc localbpc = (bpc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localbpc.id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localbpc.dcn = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localbpc.begin_time = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localbpc.duration = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localbpc.DMC = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localbpc.DMD = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localbpc.DME = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpc.DMF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localbpc.DMG = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localbpc.DMH = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localbpc.DMI = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpc.DMJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dep();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dep)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpc.DMK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpc.DML = ((ddr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localbpc.path = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpc
 * JD-Core Version:    0.7.0.1
 */