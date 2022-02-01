package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cuj
  extends com.tencent.mm.bx.a
{
  public long Emh;
  public cui Emi;
  public cui Emj;
  public long Id;
  public String gKn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Emi == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.Id);
      paramVarArgs.aG(2, this.Emh);
      if (this.Emi != null)
      {
        paramVarArgs.kX(3, this.Emi.computeSize());
        this.Emi.writeFields(paramVarArgs);
      }
      if (this.Emj != null)
      {
        paramVarArgs.kX(4, this.Emj.computeSize());
        this.Emj.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(5, this.gKn);
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0 + f.a.a.b.b.a.q(2, this.Emh);
      paramInt = i;
      if (this.Emi != null) {
        paramInt = i + f.a.a.a.kW(3, this.Emi.computeSize());
      }
      i = paramInt;
      if (this.Emj != null) {
        i = paramInt + f.a.a.a.kW(4, this.Emj.computeSize());
      }
      paramInt = i;
      if (this.gKn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gKn);
      }
      AppMethodBeat.o(125772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Emi == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cuj localcuj = (cuj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125772);
        return -1;
      case 1: 
        localcuj.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125772);
        return 0;
      case 2: 
        localcuj.Emh = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125772);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cui();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cui)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcuj.Emi = ((cui)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cui();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cui)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcuj.Emj = ((cui)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      }
      localcuj.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(125772);
      return 0;
    }
    AppMethodBeat.o(125772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuj
 * JD-Core Version:    0.7.0.1
 */