package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdb
  extends ckq
{
  public long DYU;
  public long DYX;
  public int DdZ;
  public long Dea;
  public int mBi;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(2, this.sdQ);
      }
      paramVarArgs.aR(3, this.DdZ);
      paramVarArgs.aG(4, this.Dea);
      paramVarArgs.aG(5, this.DYU);
      paramVarArgs.aG(6, this.DYX);
      paramVarArgs.aR(7, this.mBi);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label667;
      }
    }
    label667:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdQ);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DdZ);
      int j = f.a.a.b.b.a.q(4, this.Dea);
      int k = f.a.a.b.b.a.q(5, this.DYU);
      int m = f.a.a.b.b.a.q(6, this.DYX);
      int n = f.a.a.b.b.a.bA(7, this.mBi);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sdQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(32388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdb localcdb = (cdb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localcdb.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localcdb.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localcdb.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localcdb.DYU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localcdb.DYX = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32388);
          return 0;
        }
        localcdb.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdb
 * JD-Core Version:    0.7.0.1
 */