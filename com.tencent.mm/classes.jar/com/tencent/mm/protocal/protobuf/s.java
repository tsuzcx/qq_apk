package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class s
  extends dyy
{
  public String ByI;
  public String Imv;
  public String RDD;
  public String RDk;
  public a RDv;
  public String fQR;
  public int fwx = 268513600;
  public String tVo = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91327);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91327);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.ByI != null) {
        paramVarArgs.f(4, this.ByI);
      }
      if (this.fQR != null) {
        paramVarArgs.f(5, this.fQR);
      }
      if (this.Imv != null) {
        paramVarArgs.f(7, this.Imv);
      }
      if (this.RDk != null) {
        paramVarArgs.f(8, this.RDk);
      }
      if (this.RDv != null)
      {
        paramVarArgs.oE(9, this.RDv.computeSize());
        this.RDv.writeFields(paramVarArgs);
      }
      if (this.RDD != null) {
        paramVarArgs.f(10, this.RDD);
      }
      AppMethodBeat.o(91327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label886;
      }
    }
    label886:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.ByI != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ByI);
      }
      paramInt = i;
      if (this.fQR != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fQR);
      }
      i = paramInt;
      if (this.Imv != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Imv);
      }
      paramInt = i;
      if (this.RDk != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RDk);
      }
      i = paramInt;
      if (this.RDv != null) {
        i = paramInt + g.a.a.a.oD(9, this.RDv.computeSize());
      }
      paramInt = i;
      if (this.RDD != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RDD);
      }
      AppMethodBeat.o(91327);
      return paramInt;
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
          AppMethodBeat.o(91327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        s locals = (s)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91327);
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
            locals.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        case 2: 
          locals.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91327);
          return 0;
        case 3: 
          locals.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 4: 
          locals.ByI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 5: 
          locals.fQR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 7: 
          locals.Imv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 8: 
          locals.RDk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            locals.RDv = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        }
        locals.RDD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91327);
        return 0;
      }
      AppMethodBeat.o(91327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.s
 * JD-Core Version:    0.7.0.1
 */