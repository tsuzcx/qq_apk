package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbo
  extends com.tencent.mm.bw.a
{
  public long Mhp;
  public long Mhq;
  public LinkedList<cyl> Mhr;
  public int Mhs;
  public LinkedList<cyh> Mht;
  public int Mhu;
  public int Mhv;
  public boolean Mhw;
  public long his;
  
  public cbo()
  {
    AppMethodBeat.i(122515);
    this.Mhp = 0L;
    this.Mhq = 0L;
    this.Mhr = new LinkedList();
    this.Mhs = -1;
    this.Mht = new LinkedList();
    this.Mhu = -1;
    this.Mhv = -1;
    this.his = 0L;
    this.Mhw = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Mhp);
      paramVarArgs.bb(2, this.Mhq);
      paramVarArgs.e(3, 8, this.Mhr);
      paramVarArgs.aM(4, this.Mhs);
      paramVarArgs.e(5, 8, this.Mht);
      paramVarArgs.aM(6, this.Mhu);
      paramVarArgs.aM(7, this.Mhv);
      paramVarArgs.bb(8, this.his);
      paramVarArgs.cc(9, this.Mhw);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Mhp);
      i = g.a.a.b.b.a.r(2, this.Mhq);
      int j = g.a.a.a.c(3, 8, this.Mhr);
      int k = g.a.a.b.b.a.bu(4, this.Mhs);
      int m = g.a.a.a.c(5, 8, this.Mht);
      int n = g.a.a.b.b.a.bu(6, this.Mhu);
      int i1 = g.a.a.b.b.a.bu(7, this.Mhv);
      int i2 = g.a.a.b.b.a.r(8, this.his);
      int i3 = g.a.a.b.b.a.fS(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + (i3 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Mhr.clear();
      this.Mht.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cbo localcbo = (cbo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localcbo.Mhp = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localcbo.Mhq = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(122516);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbo.Mhr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localcbo.Mhs = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbo.Mht.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localcbo.Mhu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localcbo.Mhv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localcbo.his = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(122516);
        return 0;
      }
      localcbo.Mhw = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbo
 * JD-Core Version:    0.7.0.1
 */