package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzt
  extends cwj
{
  public int CreateTime;
  public cxn FNH;
  public int FRI;
  public int HnF;
  public int Ret;
  public int nJA;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.FNH != null)
      {
        paramVarArgs.lJ(2, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.xri);
      paramVarArgs.aS(4, this.HnF);
      paramVarArgs.aS(5, this.CreateTime);
      paramVarArgs.aS(6, this.FRI);
      paramVarArgs.aS(7, this.nJA);
      paramVarArgs.aZ(8, this.xrk);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FNH != null) {
        paramInt = i + f.a.a.a.lI(2, this.FNH.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.xri);
      int j = f.a.a.b.b.a.bz(4, this.HnF);
      int k = f.a.a.b.b.a.bz(5, this.CreateTime);
      int m = f.a.a.b.b.a.bz(6, this.FRI);
      int n = f.a.a.b.b.a.bz(7, this.nJA);
      int i1 = f.a.a.b.b.a.p(8, this.xrk);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FNH == null)
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
      bzt localbzt = (bzt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localbzt.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzt.FNH = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localbzt.xri = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localbzt.HnF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localbzt.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localbzt.FRI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localbzt.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43105);
        return 0;
      }
      localbzt.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzt
 * JD-Core Version:    0.7.0.1
 */