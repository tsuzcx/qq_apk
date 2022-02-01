package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxw
  extends com.tencent.mm.bx.a
{
  public boolean LqP;
  public dxx Lqd;
  public dxv Lqe;
  public LinkedList<ebw> LwS;
  public long LwT;
  public long LwU;
  public boolean LwV;
  public String gtC;
  
  public dxw()
  {
    AppMethodBeat.i(203585);
    this.LwS = new LinkedList();
    AppMethodBeat.o(203585);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203586);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LwS);
      paramVarArgs.aG(2, this.LwT);
      paramVarArgs.aG(3, this.LwU);
      paramVarArgs.bg(4, this.LqP);
      if (this.gtC != null) {
        paramVarArgs.d(5, this.gtC);
      }
      if (this.Lqd != null)
      {
        paramVarArgs.kX(6, this.Lqd.computeSize());
        this.Lqd.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(7, this.LwV);
      if (this.Lqe != null)
      {
        paramVarArgs.kX(8, this.Lqe.computeSize());
        this.Lqe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203586);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.LwS) + 0 + f.a.a.b.b.a.q(2, this.LwT) + f.a.a.b.b.a.q(3, this.LwU) + (f.a.a.b.b.a.fY(4) + 1);
      paramInt = i;
      if (this.gtC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gtC);
      }
      i = paramInt;
      if (this.Lqd != null) {
        i = paramInt + f.a.a.a.kW(6, this.Lqd.computeSize());
      }
      i += f.a.a.b.b.a.fY(7) + 1;
      paramInt = i;
      if (this.Lqe != null) {
        paramInt = i + f.a.a.a.kW(8, this.Lqe.computeSize());
      }
      AppMethodBeat.o(203586);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LwS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203586);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dxw localdxw = (dxw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203586);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxw.LwS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203586);
        return 0;
      case 2: 
        localdxw.LwT = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(203586);
        return 0;
      case 3: 
        localdxw.LwU = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(203586);
        return 0;
      case 4: 
        localdxw.LqP = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(203586);
        return 0;
      case 5: 
        localdxw.gtC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(203586);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dxx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxw.Lqd = ((dxx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203586);
        return 0;
      case 7: 
        localdxw.LwV = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(203586);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dxv();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dxv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdxw.Lqe = ((dxv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(203586);
      return 0;
    }
    AppMethodBeat.o(203586);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxw
 * JD-Core Version:    0.7.0.1
 */