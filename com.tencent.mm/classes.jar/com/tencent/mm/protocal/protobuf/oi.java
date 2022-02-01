package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class oi
  extends dyy
{
  public String ProductID;
  public String RVB;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124432);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWu);
      if (this.RVB != null) {
        paramVarArgs.f(3, this.RVB);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(4, this.ProductID);
      }
      AppMethodBeat.o(124432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.RVB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RVB);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ProductID);
      }
      AppMethodBeat.o(124432);
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
          AppMethodBeat.o(124432);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        oi localoi = (oi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124432);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localoi.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(124432);
          return 0;
        case 2: 
          localoi.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124432);
          return 0;
        case 3: 
          localoi.RVB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124432);
          return 0;
        }
        localoi.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124432);
        return 0;
      }
      AppMethodBeat.o(124432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oi
 * JD-Core Version:    0.7.0.1
 */