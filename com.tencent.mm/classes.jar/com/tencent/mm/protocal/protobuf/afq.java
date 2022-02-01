package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afq
  extends cvw
{
  public String FNj;
  public String FOR;
  public int GaC;
  public int GeT;
  public long GvY;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xri);
      paramVarArgs.aS(2, this.GeT);
      paramVarArgs.aS(3, this.GaC);
      if (this.FOR != null) {
        paramVarArgs.d(4, this.FOR);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.xrk);
      if (this.FNj != null) {
        paramVarArgs.d(7, this.FNj);
      }
      paramVarArgs.aZ(8, this.GvY);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xri) + 0 + f.a.a.b.b.a.bz(2, this.GeT) + f.a.a.b.b.a.bz(3, this.GaC);
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FOR);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + f.a.a.a.lI(5, this.BaseRequest.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.xrk);
      paramInt = i;
      if (this.FNj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FNj);
      }
      i = f.a.a.b.b.a.p(8, this.GvY);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afq localafq = (afq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localafq.xri = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localafq.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localafq.GaC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localafq.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafq.BaseRequest = ((jc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localafq.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localafq.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localafq.GvY = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afq
 * JD-Core Version:    0.7.0.1
 */