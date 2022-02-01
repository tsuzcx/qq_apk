package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpt
  extends cld
{
  public int CBs;
  public int CreateTime;
  public cmf Cxy;
  public int DOf;
  public int Ret;
  public int mBH;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.Cxy != null)
      {
        paramVarArgs.kX(2, this.Cxy.computeSize());
        this.Cxy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.uKX);
      paramVarArgs.aR(4, this.DOf);
      paramVarArgs.aR(5, this.CreateTime);
      paramVarArgs.aR(6, this.CBs);
      paramVarArgs.aR(7, this.mBH);
      paramVarArgs.aG(8, this.uKZ);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ret) + 0;
      paramInt = i;
      if (this.Cxy != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cxy.computeSize());
      }
      i = f.a.a.b.b.a.bA(3, this.uKX);
      int j = f.a.a.b.b.a.bA(4, this.DOf);
      int k = f.a.a.b.b.a.bA(5, this.CreateTime);
      int m = f.a.a.b.b.a.bA(6, this.CBs);
      int n = f.a.a.b.b.a.bA(7, this.mBH);
      int i1 = f.a.a.b.b.a.q(8, this.uKZ);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Cxy == null)
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
      bpt localbpt = (bpt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localbpt.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpt.Cxy = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localbpt.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localbpt.DOf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localbpt.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localbpt.CBs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localbpt.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43105);
        return 0;
      }
      localbpt.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpt
 * JD-Core Version:    0.7.0.1
 */