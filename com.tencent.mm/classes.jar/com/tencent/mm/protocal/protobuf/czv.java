package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czv
  extends com.tencent.mm.bw.a
{
  public long FJg;
  public czu FJh;
  public czu FJi;
  public long Id;
  public String hkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Id);
      paramVarArgs.aO(2, this.FJg);
      if (this.FJh != null)
      {
        paramVarArgs.ln(3, this.FJh.computeSize());
        this.FJh.writeFields(paramVarArgs);
      }
      if (this.FJi != null)
      {
        paramVarArgs.ln(4, this.FJi.computeSize());
        this.FJi.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(5, this.hkN);
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0 + f.a.a.b.b.a.p(2, this.FJg);
      paramInt = i;
      if (this.FJh != null) {
        paramInt = i + f.a.a.a.lm(3, this.FJh.computeSize());
      }
      i = paramInt;
      if (this.FJi != null) {
        i = paramInt + f.a.a.a.lm(4, this.FJi.computeSize());
      }
      paramInt = i;
      if (this.hkN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hkN);
      }
      AppMethodBeat.o(125772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FJh == null)
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
      czv localczv = (czv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125772);
        return -1;
      case 1: 
        localczv.Id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125772);
        return 0;
      case 2: 
        localczv.FJg = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125772);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczv.FJh = ((czu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczv.FJi = ((czu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      }
      localczv.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(125772);
      return 0;
    }
    AppMethodBeat.o(125772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czv
 * JD-Core Version:    0.7.0.1
 */