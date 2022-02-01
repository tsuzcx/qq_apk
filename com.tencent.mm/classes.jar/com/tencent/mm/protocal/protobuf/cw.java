package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cw
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int Fvp;
  public cwt Fvq;
  public int Fvr;
  public cwt Fvs;
  public int Fvt;
  public int ugm;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.Fvs == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.Fvq != null)
      {
        paramVarArgs.lC(1, this.Fvq.computeSize());
        this.Fvq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.xbt);
      paramVarArgs.aS(3, this.Fvp);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.Fvr);
      if (this.Fvs != null)
      {
        paramVarArgs.lC(6, this.Fvs.computeSize());
        this.Fvs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Fvt);
      paramVarArgs.aS(8, this.ugm);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fvq == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lB(1, this.Fvq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.xbt) + f.a.a.b.b.a.bz(3, this.Fvp) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.Fvr);
      paramInt = i;
      if (this.Fvs != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fvs.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.Fvt);
      int j = f.a.a.b.b.a.bz(8, this.ugm);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Fvq == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.Fvs == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcw.Fvq = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localcw.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localcw.Fvp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localcw.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localcw.Fvr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcw.Fvs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localcw.Fvt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133144);
          return 0;
        }
        localcw.ugm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */