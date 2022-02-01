package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkv
  extends com.tencent.mm.bx.a
{
  public long CFc;
  public bsn EAA;
  public LinkedList<dbo> EAB;
  public LinkedList<acv> EAC;
  public LinkedList<bpc> zcd;
  
  public dkv()
  {
    AppMethodBeat.i(110917);
    this.EAB = new LinkedList();
    this.EAC = new LinkedList();
    this.zcd = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CFc);
      if (this.EAA != null)
      {
        paramVarArgs.kX(2, this.EAA.computeSize());
        this.EAA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.EAB);
      paramVarArgs.e(4, 8, this.EAC);
      paramVarArgs.e(5, 8, this.zcd);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.CFc) + 0;
      paramInt = i;
      if (this.EAA != null) {
        paramInt = i + f.a.a.a.kW(2, this.EAA.computeSize());
      }
      i = f.a.a.a.c(3, 8, this.EAB);
      int j = f.a.a.a.c(4, 8, this.EAC);
      int k = f.a.a.a.c(5, 8, this.zcd);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EAB.clear();
      this.EAC.clear();
      this.zcd.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkv localdkv = (dkv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localdkv.CFc = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkv.EAA = ((bsn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkv.EAB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkv.EAC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bpc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bpc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdkv.zcd.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkv
 * JD-Core Version:    0.7.0.1
 */