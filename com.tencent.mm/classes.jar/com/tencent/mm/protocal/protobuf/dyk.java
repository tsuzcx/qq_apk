package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyk
  extends ckq
{
  public aht DlF;
  public int Lxo;
  public String hKD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203833);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DlF != null)
      {
        paramVarArgs.kX(2, this.DlF.computeSize());
        this.DlF.writeFields(paramVarArgs);
      }
      if (this.hKD != null) {
        paramVarArgs.d(3, this.hKD);
      }
      paramVarArgs.aR(4, this.Lxo);
      AppMethodBeat.o(203833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DlF != null) {
        paramInt = i + f.a.a.a.kW(2, this.DlF.computeSize());
      }
      i = paramInt;
      if (this.hKD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hKD);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Lxo);
      AppMethodBeat.o(203833);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203833);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyk localdyk = (dyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203833);
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
            localdyk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203833);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyk.DlF = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203833);
          return 0;
        case 3: 
          localdyk.hKD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203833);
          return 0;
        }
        localdyk.Lxo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203833);
        return 0;
      }
      AppMethodBeat.o(203833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyk
 * JD-Core Version:    0.7.0.1
 */