package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fcv
  extends com.tencent.mm.cd.a
{
  public String RYD;
  public int UCw;
  public eae Uyb;
  public int lVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148667);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uyb == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(148667);
        throw paramVarArgs;
      }
      if (this.Uyb != null)
      {
        paramVarArgs.oE(1, this.Uyb.computeSize());
        this.Uyb.writeFields(paramVarArgs);
      }
      if (this.RYD != null) {
        paramVarArgs.f(2, this.RYD);
      }
      paramVarArgs.aY(3, this.lVs);
      paramVarArgs.aY(4, this.UCw);
      AppMethodBeat.o(148667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uyb == null) {
        break label488;
      }
    }
    label488:
    for (paramInt = g.a.a.a.oD(1, this.Uyb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RYD != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RYD);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.lVs);
      int j = g.a.a.b.b.a.bM(4, this.UCw);
      AppMethodBeat.o(148667);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uyb == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(148667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fcv localfcv = (fcv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148667);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eae localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localfcv.Uyb = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(148667);
          return 0;
        case 2: 
          localfcv.RYD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(148667);
          return 0;
        case 3: 
          localfcv.lVs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148667);
          return 0;
        }
        localfcv.UCw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(148667);
        return 0;
      }
      AppMethodBeat.o(148667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcv
 * JD-Core Version:    0.7.0.1
 */