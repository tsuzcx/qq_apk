package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dez
  extends dyy
{
  public String RQu;
  public dmr RQv;
  public dgm RQw;
  public String TME;
  public clz TMF;
  public String TMx;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.TMx != null) {
        paramVarArgs.f(4, this.TMx);
      }
      if (this.RQu != null) {
        paramVarArgs.f(5, this.RQu);
      }
      if (this.TME != null) {
        paramVarArgs.f(6, this.TME);
      }
      if (this.RQv != null)
      {
        paramVarArgs.oE(7, this.RQv.computeSize());
        this.RQv.writeFields(paramVarArgs);
      }
      if (this.RQw != null)
      {
        paramVarArgs.oE(8, this.RQw.computeSize());
        this.RQw.writeFields(paramVarArgs);
      }
      if (this.TMF != null)
      {
        paramVarArgs.oE(9, this.TMF.computeSize());
        this.TMF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TMx != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TMx);
      }
      paramInt = i;
      if (this.RQu != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RQu);
      }
      i = paramInt;
      if (this.TME != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TME);
      }
      paramInt = i;
      if (this.RQv != null) {
        paramInt = i + g.a.a.a.oD(7, this.RQv.computeSize());
      }
      i = paramInt;
      if (this.RQw != null) {
        i = paramInt + g.a.a.a.oD(8, this.RQw.computeSize());
      }
      paramInt = i;
      if (this.TMF != null) {
        paramInt = i + g.a.a.a.oD(9, this.TMF.computeSize());
      }
      AppMethodBeat.o(72531);
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
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dez localdez = (dez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localdez.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localdez.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localdez.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localdez.TMx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localdez.RQu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localdez.TME = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmr)localObject2).parseFrom((byte[])localObject1);
            }
            localdez.RQv = ((dmr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgm)localObject2).parseFrom((byte[])localObject1);
            }
            localdez.RQw = ((dgm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new clz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((clz)localObject2).parseFrom((byte[])localObject1);
          }
          localdez.TMF = ((clz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dez
 * JD-Core Version:    0.7.0.1
 */