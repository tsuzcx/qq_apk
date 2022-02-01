package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxb
  extends com.tencent.mm.bw.a
{
  public LinkedList<bza> BXX;
  public long FVt;
  public LinkedList<agm> HiR;
  public cco Icw;
  public LinkedList<dnk> Icx;
  
  public dxb()
  {
    AppMethodBeat.i(110917);
    this.Icx = new LinkedList();
    this.HiR = new LinkedList();
    this.BXX = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FVt);
      if (this.Icw != null)
      {
        paramVarArgs.lJ(2, this.Icw.computeSize());
        this.Icw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Icx);
      paramVarArgs.e(4, 8, this.HiR);
      paramVarArgs.e(5, 8, this.BXX);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FVt) + 0;
      paramInt = i;
      if (this.Icw != null) {
        paramInt = i + f.a.a.a.lI(2, this.Icw.computeSize());
      }
      i = f.a.a.a.c(3, 8, this.Icx);
      int j = f.a.a.a.c(4, 8, this.HiR);
      int k = f.a.a.a.c(5, 8, this.BXX);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Icx.clear();
      this.HiR.clear();
      this.BXX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dxb localdxb = (dxb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localdxb.FVt = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cco();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxb.Icw = ((cco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxb.Icx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxb.HiR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bza();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdxb.BXX.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxb
 * JD-Core Version:    0.7.0.1
 */