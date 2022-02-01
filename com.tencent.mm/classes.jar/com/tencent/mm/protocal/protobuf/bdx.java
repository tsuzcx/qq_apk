package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdx
  extends dyy
{
  public int SPa;
  public int SPb;
  public int SPc;
  public int SPd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230592);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SPa);
      paramVarArgs.aY(3, this.SPb);
      paramVarArgs.aY(4, this.SPc);
      paramVarArgs.aY(5, this.SPd);
      AppMethodBeat.o(230592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.SPa);
      int j = g.a.a.b.b.a.bM(3, this.SPb);
      int k = g.a.a.b.b.a.bM(4, this.SPc);
      int m = g.a.a.b.b.a.bM(5, this.SPd);
      AppMethodBeat.o(230592);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bdx localbdx = (bdx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230592);
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
            localbdx.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(230592);
          return 0;
        case 2: 
          localbdx.SPa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(230592);
          return 0;
        case 3: 
          localbdx.SPb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(230592);
          return 0;
        case 4: 
          localbdx.SPc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(230592);
          return 0;
        }
        localbdx.SPd = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(230592);
        return 0;
      }
      AppMethodBeat.o(230592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdx
 * JD-Core Version:    0.7.0.1
 */