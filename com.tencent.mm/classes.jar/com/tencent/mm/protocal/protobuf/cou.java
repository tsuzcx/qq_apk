package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cou
  extends dpc
{
  public int Brl;
  public long Brn;
  public int CreateTime;
  public dqi KHm;
  public int KLp;
  public int MuU;
  public int Ret;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Ret);
      if (this.KHm != null)
      {
        paramVarArgs.ni(2, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Brl);
      paramVarArgs.aM(4, this.MuU);
      paramVarArgs.aM(5, this.CreateTime);
      paramVarArgs.aM(6, this.KLp);
      paramVarArgs.aM(7, this.oUv);
      paramVarArgs.bb(8, this.Brn);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.KHm != null) {
        paramInt = i + g.a.a.a.nh(2, this.KHm.computeSize());
      }
      i = g.a.a.b.b.a.bu(3, this.Brl);
      int j = g.a.a.b.b.a.bu(4, this.MuU);
      int k = g.a.a.b.b.a.bu(5, this.CreateTime);
      int m = g.a.a.b.b.a.bu(6, this.KLp);
      int n = g.a.a.b.b.a.bu(7, this.oUv);
      int i1 = g.a.a.b.b.a.r(8, this.Brn);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43105);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cou localcou = (cou)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localcou.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcou.KHm = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localcou.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localcou.MuU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localcou.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localcou.KLp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localcou.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43105);
        return 0;
      }
      localcou.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cou
 * JD-Core Version:    0.7.0.1
 */