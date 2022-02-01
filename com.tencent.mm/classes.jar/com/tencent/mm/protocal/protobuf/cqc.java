package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cqc
  extends dyy
{
  public fmh TxB;
  public fmj TxC;
  public fqc TxD;
  public yw Txv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123627);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123627);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TxB != null)
      {
        paramVarArgs.oE(2, this.TxB.computeSize());
        this.TxB.writeFields(paramVarArgs);
      }
      if (this.Txv != null)
      {
        paramVarArgs.oE(3, this.Txv.computeSize());
        this.Txv.writeFields(paramVarArgs);
      }
      if (this.TxC != null)
      {
        paramVarArgs.oE(4, this.TxC.computeSize());
        this.TxC.writeFields(paramVarArgs);
      }
      if (this.TxD != null)
      {
        paramVarArgs.oE(5, this.TxD.computeSize());
        this.TxD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label864;
      }
    }
    label864:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TxB != null) {
        paramInt = i + g.a.a.a.oD(2, this.TxB.computeSize());
      }
      i = paramInt;
      if (this.Txv != null) {
        i = paramInt + g.a.a.a.oD(3, this.Txv.computeSize());
      }
      paramInt = i;
      if (this.TxC != null) {
        paramInt = i + g.a.a.a.oD(4, this.TxC.computeSize());
      }
      i = paramInt;
      if (this.TxD != null) {
        i = paramInt + g.a.a.a.oD(5, this.TxD.computeSize());
      }
      AppMethodBeat.o(123627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123627);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123627);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqc localcqc = (cqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123627);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmh)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.TxB = ((fmh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new yw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((yw)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.Txv = ((yw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmj)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.TxC = ((fmj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqc)localObject2).parseFrom((byte[])localObject1);
          }
          localcqc.TxD = ((fqc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123627);
        return 0;
      }
      AppMethodBeat.o(123627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqc
 * JD-Core Version:    0.7.0.1
 */