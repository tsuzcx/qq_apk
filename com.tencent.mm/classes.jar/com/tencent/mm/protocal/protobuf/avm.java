package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avm
  extends ckq
{
  public String Ddo;
  public String Dnj;
  public String Dnk;
  public String Dnl;
  public String DuQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dnj != null) {
        paramVarArgs.d(2, this.Dnj);
      }
      if (this.DuQ != null) {
        paramVarArgs.d(3, this.DuQ);
      }
      if (this.Dnk != null) {
        paramVarArgs.d(4, this.Dnk);
      }
      if (this.Dnl != null) {
        paramVarArgs.d(5, this.Dnl);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(6, this.Ddo);
      }
      AppMethodBeat.o(91489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dnj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dnj);
      }
      i = paramInt;
      if (this.DuQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DuQ);
      }
      paramInt = i;
      if (this.Dnk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dnk);
      }
      i = paramInt;
      if (this.Dnl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dnl);
      }
      paramInt = i;
      if (this.Ddo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ddo);
      }
      AppMethodBeat.o(91489);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avm localavm = (avm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91489);
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
            localavm.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91489);
          return 0;
        case 2: 
          localavm.Dnj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 3: 
          localavm.DuQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 4: 
          localavm.Dnk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 5: 
          localavm.Dnl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91489);
          return 0;
        }
        localavm.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91489);
        return 0;
      }
      AppMethodBeat.o(91489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avm
 * JD-Core Version:    0.7.0.1
 */