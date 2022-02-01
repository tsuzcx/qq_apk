package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abr
  extends com.tencent.mm.bx.a
{
  public int Dca;
  public abp Dcb;
  public abp Dcc;
  public int Dcd;
  public int Dce;
  public int Dcf;
  public int Dcg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dca);
      if (this.Dcb != null)
      {
        paramVarArgs.kX(2, this.Dcb.computeSize());
        this.Dcb.writeFields(paramVarArgs);
      }
      if (this.Dcc != null)
      {
        paramVarArgs.kX(3, this.Dcc.computeSize());
        this.Dcc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Dcd);
      paramVarArgs.aR(5, this.Dce);
      paramVarArgs.aR(6, this.Dcf);
      paramVarArgs.aR(7, this.Dcg);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Dca) + 0;
      paramInt = i;
      if (this.Dcb != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dcb.computeSize());
      }
      i = paramInt;
      if (this.Dcc != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dcc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Dcd);
      int j = f.a.a.b.b.a.bA(5, this.Dce);
      int k = f.a.a.b.b.a.bA(6, this.Dcf);
      int m = f.a.a.b.b.a.bA(7, this.Dcg);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abr localabr = (abr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localabr.Dca = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabr.Dcb = ((abp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabr.Dcc = ((abp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localabr.Dcd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localabr.Dce = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localabr.Dcf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(90966);
        return 0;
      }
      localabr.Dcg = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abr
 * JD-Core Version:    0.7.0.1
 */