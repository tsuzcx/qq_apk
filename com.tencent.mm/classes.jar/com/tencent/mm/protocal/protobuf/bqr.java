package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqr
  extends dyy
{
  public com.tencent.mm.cd.b TbL;
  public long TbM;
  public com.tencent.mm.cd.b TbN;
  public dcb TbO;
  public me TbP;
  public float TbQ = 0.5F;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104368);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104368);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.TbM);
      if (this.TbN != null) {
        paramVarArgs.c(3, this.TbN);
      }
      if (this.TbO != null)
      {
        paramVarArgs.oE(4, this.TbO.computeSize());
        this.TbO.writeFields(paramVarArgs);
      }
      if (this.TbP != null)
      {
        paramVarArgs.oE(5, this.TbP.computeSize());
        this.TbP.writeFields(paramVarArgs);
      }
      if (this.TbL != null) {
        paramVarArgs.c(6, this.TbL);
      }
      paramVarArgs.i(7, this.TbQ);
      AppMethodBeat.o(104368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label815;
      }
    }
    label815:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.TbM);
      paramInt = i;
      if (this.TbN != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.TbN);
      }
      i = paramInt;
      if (this.TbO != null) {
        i = paramInt + g.a.a.a.oD(4, this.TbO.computeSize());
      }
      paramInt = i;
      if (this.TbP != null) {
        paramInt = i + g.a.a.a.oD(5, this.TbP.computeSize());
      }
      i = paramInt;
      if (this.TbL != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.TbL);
      }
      paramInt = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(104368);
      return i + (paramInt + 4);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104368);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqr localbqr = (bqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104368);
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
            localbqr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 2: 
          localbqr.TbM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(104368);
          return 0;
        case 3: 
          localbqr.TbN = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(104368);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcb)localObject2).parseFrom((byte[])localObject1);
            }
            localbqr.TbO = ((dcb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new me();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((me)localObject2).parseFrom((byte[])localObject1);
            }
            localbqr.TbP = ((me)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 6: 
          localbqr.TbL = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(104368);
          return 0;
        }
        localbqr.TbQ = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
        AppMethodBeat.o(104368);
        return 0;
      }
      AppMethodBeat.o(104368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqr
 * JD-Core Version:    0.7.0.1
 */