package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class djv
  extends dyy
{
  public int ORp;
  public djy TRj;
  public djk TRk;
  public LinkedList<djj> TRl;
  public int TRm;
  public LinkedList<eif> TRn;
  public int vht;
  public String vhu;
  
  public djv()
  {
    AppMethodBeat.i(91591);
    this.TRl = new LinkedList();
    this.TRn = new LinkedList();
    AppMethodBeat.o(91591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91592);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      if (this.TRj != null)
      {
        paramVarArgs.oE(4, this.TRj.computeSize());
        this.TRj.writeFields(paramVarArgs);
      }
      if (this.TRk != null)
      {
        paramVarArgs.oE(5, this.TRk.computeSize());
        this.TRk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.TRl);
      paramVarArgs.aY(7, this.TRm);
      paramVarArgs.e(8, 8, this.TRn);
      paramVarArgs.aY(9, this.ORp);
      AppMethodBeat.o(91592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1044;
      }
    }
    label1044:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = paramInt;
      if (this.TRj != null) {
        i = paramInt + g.a.a.a.oD(4, this.TRj.computeSize());
      }
      paramInt = i;
      if (this.TRk != null) {
        paramInt = i + g.a.a.a.oD(5, this.TRk.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.TRl);
      int j = g.a.a.b.b.a.bM(7, this.TRm);
      int k = g.a.a.a.c(8, 8, this.TRn);
      int m = g.a.a.b.b.a.bM(9, this.ORp);
      AppMethodBeat.o(91592);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TRl.clear();
        this.TRn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djv localdjv = (djv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91592);
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
            localdjv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 2: 
          localdjv.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91592);
          return 0;
        case 3: 
          localdjv.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91592);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djy)localObject2).parseFrom((byte[])localObject1);
            }
            localdjv.TRj = ((djy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djk)localObject2).parseFrom((byte[])localObject1);
            }
            localdjv.TRk = ((djk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djj)localObject2).parseFrom((byte[])localObject1);
            }
            localdjv.TRl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 7: 
          localdjv.TRm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91592);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eif();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eif)localObject2).parseFrom((byte[])localObject1);
            }
            localdjv.TRn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        }
        localdjv.ORp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91592);
        return 0;
      }
      AppMethodBeat.o(91592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djv
 * JD-Core Version:    0.7.0.1
 */