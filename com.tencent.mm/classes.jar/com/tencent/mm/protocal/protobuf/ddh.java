package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddh
  extends ckq
{
  public String Eos;
  public String Eot;
  public String Eou;
  public String dnk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eot != null) {
        paramVarArgs.d(2, this.Eot);
      }
      if (this.Eos != null) {
        paramVarArgs.d(3, this.Eos);
      }
      if (this.Eou != null) {
        paramVarArgs.d(4, this.Eou);
      }
      if (this.dnk != null) {
        paramVarArgs.d(5, this.dnk);
      }
      AppMethodBeat.o(129977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eot != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eot);
      }
      i = paramInt;
      if (this.Eos != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eos);
      }
      paramInt = i;
      if (this.Eou != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eou);
      }
      i = paramInt;
      if (this.dnk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dnk);
      }
      AppMethodBeat.o(129977);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(129977);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddh localddh = (ddh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129977);
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
            localddh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(129977);
          return 0;
        case 2: 
          localddh.Eot = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 3: 
          localddh.Eos = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 4: 
          localddh.Eou = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(129977);
          return 0;
        }
        localddh.dnk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(129977);
        return 0;
      }
      AppMethodBeat.o(129977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddh
 * JD-Core Version:    0.7.0.1
 */