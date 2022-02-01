package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arc
  extends com.tencent.mm.bw.a
{
  public LinkedList<btr> AoH;
  public long DXI;
  public long DXJ;
  public boolean DXL;
  public cvi EKb;
  public long EKc;
  public long EKd;
  public long EKe;
  public long EKf;
  public long EKg;
  public long uin;
  
  public arc()
  {
    AppMethodBeat.i(110895);
    this.AoH = new LinkedList();
    this.EKc = 10L;
    this.EKd = 0L;
    this.DXL = false;
    this.EKe = 0L;
    this.EKf = 0L;
    this.EKg = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DXI);
      paramVarArgs.aO(2, this.uin);
      paramVarArgs.aO(3, this.DXJ);
      paramVarArgs.e(4, 8, this.AoH);
      if (this.EKb != null)
      {
        paramVarArgs.ln(5, this.EKb.computeSize());
        this.EKb.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.EKc);
      paramVarArgs.aO(7, this.EKd);
      paramVarArgs.bl(8, this.DXL);
      paramVarArgs.aO(9, this.EKe);
      paramVarArgs.aO(10, this.EKf);
      paramVarArgs.aO(11, this.EKg);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.DXI) + 0 + f.a.a.b.b.a.p(2, this.uin) + f.a.a.b.b.a.p(3, this.DXJ) + f.a.a.a.c(4, 8, this.AoH);
      paramInt = i;
      if (this.EKb != null) {
        paramInt = i + f.a.a.a.lm(5, this.EKb.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.EKc);
      int j = f.a.a.b.b.a.p(7, this.EKd);
      int k = f.a.a.b.b.a.fK(8);
      int m = f.a.a.b.b.a.p(9, this.EKe);
      int n = f.a.a.b.b.a.p(10, this.EKf);
      int i1 = f.a.a.b.b.a.p(11, this.EKg);
      AppMethodBeat.o(110896);
      return paramInt + i + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.AoH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      arc localarc = (arc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localarc.DXI = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localarc.uin = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localarc.DXJ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarc.AoH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarc.EKb = ((cvi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localarc.EKc = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localarc.EKd = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localarc.DXL = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localarc.EKe = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localarc.EKf = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110896);
        return 0;
      }
      localarc.EKg = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arc
 * JD-Core Version:    0.7.0.1
 */