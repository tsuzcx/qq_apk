package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cyi
  extends com.tencent.mm.bx.a
{
  public String DcA;
  public int EpS;
  public cyt Eqj;
  public LinkedList<Integer> Eqw;
  public long Id;
  
  public cyi()
  {
    AppMethodBeat.i(118447);
    this.Eqw = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Id);
      if (this.DcA != null) {
        paramVarArgs.d(2, this.DcA);
      }
      if (this.Eqj != null)
      {
        paramVarArgs.kX(3, this.Eqj.computeSize());
        this.Eqj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EpS);
      paramVarArgs.f(5, 2, this.Eqw);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.DcA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DcA);
      }
      i = paramInt;
      if (this.Eqj != null) {
        i = paramInt + f.a.a.a.kW(3, this.Eqj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(4, this.EpS);
      int j = f.a.a.a.d(5, 2, this.Eqw);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eqw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cyi localcyi = (cyi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localcyi.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localcyi.DcA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cyt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyi.Eqj = ((cyt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localcyi.EpS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118448);
        return 0;
      }
      localcyi.Eqw = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyi
 * JD-Core Version:    0.7.0.1
 */