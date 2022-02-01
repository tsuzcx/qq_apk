package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkw
  extends dyy
{
  public int bPt;
  public boolean jIH;
  public int lAW;
  public String xei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169069);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.lAW);
      paramVarArgs.aY(3, this.bPt);
      if (this.xei != null) {
        paramVarArgs.f(4, this.xei);
      }
      paramVarArgs.co(5, this.jIH);
      AppMethodBeat.o(169069);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label476;
      }
    }
    label476:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lAW) + g.a.a.b.b.a.bM(3, this.bPt);
      paramInt = i;
      if (this.xei != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.xei);
      }
      i = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(169069);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169069);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bkw localbkw = (bkw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169069);
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
            localbkw.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(169069);
          return 0;
        case 2: 
          localbkw.lAW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169069);
          return 0;
        case 3: 
          localbkw.bPt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169069);
          return 0;
        case 4: 
          localbkw.xei = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169069);
          return 0;
        }
        localbkw.jIH = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(169069);
        return 0;
      }
      AppMethodBeat.o(169069);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkw
 * JD-Core Version:    0.7.0.1
 */