package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djx
  extends dyy
{
  public String TRp;
  public int TRq;
  public long TRr;
  public int fHV;
  public String fHW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255287);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fHV);
      if (this.fHW != null) {
        paramVarArgs.f(3, this.fHW);
      }
      if (this.TRp != null) {
        paramVarArgs.f(4, this.TRp);
      }
      paramVarArgs.aY(5, this.TRq);
      paramVarArgs.bm(100, this.TRr);
      AppMethodBeat.o(255287);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fHV);
      paramInt = i;
      if (this.fHW != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fHW);
      }
      i = paramInt;
      if (this.TRp != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TRp);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.TRq);
      int j = g.a.a.b.b.a.p(100, this.TRr);
      AppMethodBeat.o(255287);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255287);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        djx localdjx = (djx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255287);
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
            localdjx.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(255287);
          return 0;
        case 2: 
          localdjx.fHV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(255287);
          return 0;
        case 3: 
          localdjx.fHW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(255287);
          return 0;
        case 4: 
          localdjx.TRp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(255287);
          return 0;
        case 5: 
          localdjx.TRq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(255287);
          return 0;
        }
        localdjx.TRr = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(255287);
        return 0;
      }
      AppMethodBeat.o(255287);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djx
 * JD-Core Version:    0.7.0.1
 */