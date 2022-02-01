package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dyn
  extends dyy
{
  public String ByI;
  public String DNV;
  public String Ign;
  public String Igo;
  public String Saj;
  public dx Ueb;
  public int fwx;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
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
      if (this.Saj != null) {
        paramVarArgs.f(5, this.Saj);
      }
      if (this.Ign != null) {
        paramVarArgs.f(6, this.Ign);
      }
      if (this.Igo != null) {
        paramVarArgs.f(7, this.Igo);
      }
      if (this.DNV != null) {
        paramVarArgs.f(8, this.DNV);
      }
      if (this.Ueb != null)
      {
        paramVarArgs.oE(9, this.Ueb.computeSize());
        this.Ueb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
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
      if (this.Saj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Saj);
      }
      i = paramInt;
      if (this.Ign != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Ign);
      }
      paramInt = i;
      if (this.Igo != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Igo);
      }
      i = paramInt;
      if (this.DNV != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.DNV);
      }
      paramInt = i;
      if (this.Ueb != null) {
        paramInt = i + g.a.a.a.oD(9, this.Ueb.computeSize());
      }
      AppMethodBeat.o(72582);
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
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dyn localdyn = (dyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
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
            localdyn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localdyn.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localdyn.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localdyn.ByI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localdyn.Saj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localdyn.Ign = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localdyn.Igo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localdyn.DNV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dx)localObject2).parseFrom((byte[])localObject1);
          }
          localdyn.Ueb = ((dx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyn
 * JD-Core Version:    0.7.0.1
 */