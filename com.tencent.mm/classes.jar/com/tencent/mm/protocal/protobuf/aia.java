package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aia
  extends cvp
{
  public aid Gfo;
  public ahx Gfp;
  public ahy Gfq;
  public String Gfr;
  public int Gfs;
  public int Gft;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gfo != null)
      {
        paramVarArgs.lC(2, this.Gfo.computeSize());
        this.Gfo.writeFields(paramVarArgs);
      }
      if (this.Gfp != null)
      {
        paramVarArgs.lC(3, this.Gfp.computeSize());
        this.Gfp.writeFields(paramVarArgs);
      }
      if (this.Gfq != null)
      {
        paramVarArgs.lC(4, this.Gfq.computeSize());
        this.Gfq.writeFields(paramVarArgs);
      }
      if (this.Gfr != null) {
        paramVarArgs.d(5, this.Gfr);
      }
      paramVarArgs.aS(6, this.Gfs);
      paramVarArgs.aS(7, this.Gft);
      AppMethodBeat.o(32202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label991;
      }
    }
    label991:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gfo != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gfo.computeSize());
      }
      i = paramInt;
      if (this.Gfp != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gfp.computeSize());
      }
      paramInt = i;
      if (this.Gfq != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gfq.computeSize());
      }
      i = paramInt;
      if (this.Gfr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gfr);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gfs);
      int j = f.a.a.b.b.a.bz(7, this.Gft);
      AppMethodBeat.o(32202);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aia localaia = (aia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32202);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaia.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aid();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaia.Gfo = ((aid)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaia.Gfp = ((ahx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaia.Gfq = ((ahy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 5: 
          localaia.Gfr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32202);
          return 0;
        case 6: 
          localaia.Gfs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32202);
          return 0;
        }
        localaia.Gft = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32202);
        return 0;
      }
      AppMethodBeat.o(32202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aia
 * JD-Core Version:    0.7.0.1
 */