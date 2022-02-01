package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckt
  extends ckq
{
  public int Csl;
  public long DTe;
  public int EfY;
  public int EfZ;
  public String dlB;
  public int sYs;
  public String sYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.aR(3, this.sYs);
      paramVarArgs.aR(4, this.Csl);
      paramVarArgs.aG(5, this.DTe);
      paramVarArgs.aR(6, this.EfY);
      if (this.sYt != null) {
        paramVarArgs.d(7, this.sYt);
      }
      paramVarArgs.aR(8, this.EfZ);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = i + f.a.a.b.b.a.bA(3, this.sYs) + f.a.a.b.b.a.bA(4, this.Csl) + f.a.a.b.b.a.q(5, this.DTe) + f.a.a.b.b.a.bA(6, this.EfY);
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sYt);
      }
      i = f.a.a.b.b.a.bA(8, this.EfZ);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckt localckt = (ckt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
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
            localckt.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localckt.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localckt.sYs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localckt.Csl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localckt.DTe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localckt.EfY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localckt.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localckt.EfZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckt
 * JD-Core Version:    0.7.0.1
 */