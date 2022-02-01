package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class xb
  extends dyy
{
  public fic Ilg;
  public int Inc;
  public String Iuv;
  public String Ivz;
  public String Sjj;
  public boolean Sjk;
  public int fwx;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
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
      if (this.Sjj != null) {
        paramVarArgs.f(4, this.Sjj);
      }
      if (this.Ivz != null) {
        paramVarArgs.f(5, this.Ivz);
      }
      paramVarArgs.co(6, this.Sjk);
      if (this.Iuv != null) {
        paramVarArgs.f(7, this.Iuv);
      }
      paramVarArgs.aY(8, this.Inc);
      if (this.Ilg != null)
      {
        paramVarArgs.oE(9, this.Ilg.computeSize());
        this.Ilg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.Sjj != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Sjj);
      }
      paramInt = i;
      if (this.Ivz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Ivz);
      }
      i = paramInt + (g.a.a.b.b.a.gL(6) + 1);
      paramInt = i;
      if (this.Iuv != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Iuv);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.Inc);
      paramInt = i;
      if (this.Ilg != null) {
        paramInt = i + g.a.a.a.oD(9, this.Ilg.computeSize());
      }
      AppMethodBeat.o(72449);
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
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        xb localxb = (xb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
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
            localxb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localxb.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localxb.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localxb.Sjj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localxb.Ivz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localxb.Sjk = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localxb.Iuv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 8: 
          localxb.Inc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72449);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fic();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fic)localObject2).parseFrom((byte[])localObject1);
          }
          localxb.Ilg = ((fic)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xb
 * JD-Core Version:    0.7.0.1
 */