package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pe
  extends com.tencent.mm.bx.a
{
  public pg CNk;
  public coc CNn;
  public pn CNo;
  public String mBV;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBV == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.CNn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.mBV != null) {
        paramVarArgs.d(1, this.mBV);
      }
      if (this.CNk != null)
      {
        paramVarArgs.kX(2, this.CNk.computeSize());
        this.CNk.writeFields(paramVarArgs);
      }
      if (this.CNn != null)
      {
        paramVarArgs.kX(3, this.CNn.computeSize());
        this.CNn.writeFields(paramVarArgs);
      }
      if (this.CNo != null)
      {
        paramVarArgs.kX(4, this.CNo.computeSize());
        this.CNo.writeFields(paramVarArgs);
      }
      if (this.rZo != null) {
        paramVarArgs.d(5, this.rZo);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBV == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.mBV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNk != null) {
        paramInt = i + f.a.a.a.kW(2, this.CNk.computeSize());
      }
      i = paramInt;
      if (this.CNn != null) {
        i = paramInt + f.a.a.a.kW(3, this.CNn.computeSize());
      }
      paramInt = i;
      if (this.CNo != null) {
        paramInt = i + f.a.a.a.kW(4, this.CNo.computeSize());
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rZo);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mBV == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.CNn == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pe localpe = (pe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localpe.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpe.CNk = ((pg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpe.CNn = ((coc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpe.CNo = ((pn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localpe.rZo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pe
 * JD-Core Version:    0.7.0.1
 */