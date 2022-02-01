package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class adz
  extends dyy
{
  public String RUp;
  public dsk RUv;
  public int SqF;
  public bms SqG;
  public nq SqH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124480);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124480);
        throw paramVarArgs;
      }
      if (this.RUv == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124480);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RUv != null)
      {
        paramVarArgs.oE(2, this.RUv.computeSize());
        this.RUv.writeFields(paramVarArgs);
      }
      if (this.RUp != null) {
        paramVarArgs.f(3, this.RUp);
      }
      paramVarArgs.aY(4, this.SqF);
      if (this.SqG != null)
      {
        paramVarArgs.oE(5, this.SqG.computeSize());
        this.SqG.writeFields(paramVarArgs);
      }
      if (this.SqH != null)
      {
        paramVarArgs.oE(6, this.SqH.computeSize());
        this.SqH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label886;
      }
    }
    label886:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RUv != null) {
        paramInt = i + g.a.a.a.oD(2, this.RUv.computeSize());
      }
      i = paramInt;
      if (this.RUp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RUp);
      }
      i += g.a.a.b.b.a.bM(4, this.SqF);
      paramInt = i;
      if (this.SqG != null) {
        paramInt = i + g.a.a.a.oD(5, this.SqG.computeSize());
      }
      i = paramInt;
      if (this.SqH != null) {
        i = paramInt + g.a.a.a.oD(6, this.SqH.computeSize());
      }
      AppMethodBeat.o(124480);
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
          AppMethodBeat.o(124480);
          throw paramVarArgs;
        }
        if (this.RUv == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124480);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adz localadz = (adz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124480);
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
            localadz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dsk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dsk)localObject2).parseFrom((byte[])localObject1);
            }
            localadz.RUv = ((dsk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        case 3: 
          localadz.RUp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124480);
          return 0;
        case 4: 
          localadz.SqF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124480);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bms();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bms)localObject2).parseFrom((byte[])localObject1);
            }
            localadz.SqG = ((bms)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new nq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((nq)localObject2).parseFrom((byte[])localObject1);
          }
          localadz.SqH = ((nq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124480);
        return 0;
      }
      AppMethodBeat.o(124480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adz
 * JD-Core Version:    0.7.0.1
 */