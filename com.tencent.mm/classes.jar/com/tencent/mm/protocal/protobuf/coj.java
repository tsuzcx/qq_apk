package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coj
  extends ckq
{
  public String CLI;
  public long EfA;
  public long Efv;
  public int Eim;
  public long Ein;
  public boolean Eio;
  public dvs Eip;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CLI != null) {
        paramVarArgs.d(2, this.CLI);
      }
      paramVarArgs.aG(3, this.Efv);
      paramVarArgs.aR(4, this.Eim);
      paramVarArgs.aG(5, this.Ein);
      paramVarArgs.bg(6, this.Eio);
      if (this.Eip != null)
      {
        paramVarArgs.kX(7, this.Eip.computeSize());
        this.Eip.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(8, this.EfA);
      AppMethodBeat.o(117921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CLI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CLI);
      }
      i = i + f.a.a.b.b.a.q(3, this.Efv) + f.a.a.b.b.a.bA(4, this.Eim) + f.a.a.b.b.a.q(5, this.Ein) + (f.a.a.b.b.a.fY(6) + 1);
      paramInt = i;
      if (this.Eip != null) {
        paramInt = i + f.a.a.a.kW(7, this.Eip.computeSize());
      }
      i = f.a.a.b.b.a.q(8, this.EfA);
      AppMethodBeat.o(117921);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coj localcoj = (coj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117921);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        case 2: 
          localcoj.CLI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117921);
          return 0;
        case 3: 
          localcoj.Efv = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(117921);
          return 0;
        case 4: 
          localcoj.Eim = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117921);
          return 0;
        case 5: 
          localcoj.Ein = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(117921);
          return 0;
        case 6: 
          localcoj.Eio = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(117921);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoj.Eip = ((dvs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        }
        localcoj.EfA = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117921);
        return 0;
      }
      AppMethodBeat.o(117921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coj
 * JD-Core Version:    0.7.0.1
 */