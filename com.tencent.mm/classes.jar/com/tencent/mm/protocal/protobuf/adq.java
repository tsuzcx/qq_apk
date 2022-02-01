package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adq
  extends ckq
{
  public az CPi;
  public String Dei;
  public String hnC;
  public int vJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dei != null) {
        paramVarArgs.d(2, this.Dei);
      }
      if (this.hnC != null) {
        paramVarArgs.d(3, this.hnC);
      }
      paramVarArgs.aR(4, this.vJA);
      if (this.CPi != null)
      {
        paramVarArgs.kX(5, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dei != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dei);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hnC);
      }
      i += f.a.a.b.b.a.bA(4, this.vJA);
      paramInt = i;
      if (this.CPi != null) {
        paramInt = i + f.a.a.a.kW(5, this.CPi.computeSize());
      }
      AppMethodBeat.o(91441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adq localadq = (adq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91441);
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
            localadq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91441);
          return 0;
        case 2: 
          localadq.Dei = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91441);
          return 0;
        case 3: 
          localadq.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91441);
          return 0;
        case 4: 
          localadq.vJA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91441);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new az();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadq.CPi = ((az)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91441);
        return 0;
      }
      AppMethodBeat.o(91441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adq
 * JD-Core Version:    0.7.0.1
 */