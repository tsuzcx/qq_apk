package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byz
  extends cvp
{
  public int CreateTime;
  public cwt Fvj;
  public int Fzk;
  public int GUe;
  public int Ret;
  public int nEf;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.Fvj != null)
      {
        paramVarArgs.lC(2, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.xbr);
      paramVarArgs.aS(4, this.GUe);
      paramVarArgs.aS(5, this.CreateTime);
      paramVarArgs.aS(6, this.Fzk);
      paramVarArgs.aS(7, this.nEf);
      paramVarArgs.aY(8, this.xbt);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.Fvj != null) {
        paramInt = i + f.a.a.a.lB(2, this.Fvj.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.xbr);
      int j = f.a.a.b.b.a.bz(4, this.GUe);
      int k = f.a.a.b.b.a.bz(5, this.CreateTime);
      int m = f.a.a.b.b.a.bz(6, this.Fzk);
      int n = f.a.a.b.b.a.bz(7, this.nEf);
      int i1 = f.a.a.b.b.a.p(8, this.xbt);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Fvj == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byz localbyz = (byz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localbyz.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyz.Fvj = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localbyz.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localbyz.GUe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localbyz.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localbyz.Fzk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localbyz.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43105);
        return 0;
      }
      localbyz.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byz
 * JD-Core Version:    0.7.0.1
 */