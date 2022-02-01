package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cjx
  extends dyy
{
  public LinkedList<cjy> Trq;
  public dkx Trr;
  public dzl Trs;
  public boolean Trt;
  public iw Tru;
  public int tqa;
  public String tqb;
  
  public cjx()
  {
    AppMethodBeat.i(72502);
    this.Trq = new LinkedList();
    AppMethodBeat.o(72502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72503);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72503);
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
      paramVarArgs.e(4, 8, this.Trq);
      if (this.Trr != null)
      {
        paramVarArgs.oE(5, this.Trr.computeSize());
        this.Trr.writeFields(paramVarArgs);
      }
      if (this.Trs != null)
      {
        paramVarArgs.oE(6, this.Trs.computeSize());
        this.Trs.writeFields(paramVarArgs);
      }
      paramVarArgs.co(7, this.Trt);
      if (this.Tru != null)
      {
        paramVarArgs.oE(8, this.Tru.computeSize());
        this.Tru.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1004;
      }
    }
    label1004:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.Trq);
      paramInt = i;
      if (this.Trr != null) {
        paramInt = i + g.a.a.a.oD(5, this.Trr.computeSize());
      }
      i = paramInt;
      if (this.Trs != null) {
        i = paramInt + g.a.a.a.oD(6, this.Trs.computeSize());
      }
      i += g.a.a.b.b.a.gL(7) + 1;
      paramInt = i;
      if (this.Tru != null) {
        paramInt = i + g.a.a.a.oD(8, this.Tru.computeSize());
      }
      AppMethodBeat.o(72503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Trq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjx localcjx = (cjx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72503);
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
            localcjx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 2: 
          localcjx.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72503);
          return 0;
        case 3: 
          localcjx.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72503);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjy)localObject2).parseFrom((byte[])localObject1);
            }
            localcjx.Trq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkx)localObject2).parseFrom((byte[])localObject1);
            }
            localcjx.Trr = ((dkx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzl)localObject2).parseFrom((byte[])localObject1);
            }
            localcjx.Trs = ((dzl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 7: 
          localcjx.Trt = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(72503);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new iw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((iw)localObject2).parseFrom((byte[])localObject1);
          }
          localcjx.Tru = ((iw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      AppMethodBeat.o(72503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjx
 * JD-Core Version:    0.7.0.1
 */