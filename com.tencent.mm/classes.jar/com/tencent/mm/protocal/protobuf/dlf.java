package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dlf
  extends com.tencent.mm.cd.a
{
  public String CNL;
  public fmb TSm;
  public fme TSn;
  public flx TSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNL == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.CNL != null) {
        paramVarArgs.f(1, this.CNL);
      }
      if (this.TSm != null)
      {
        paramVarArgs.oE(2, this.TSm.computeSize());
        this.TSm.writeFields(paramVarArgs);
      }
      if (this.TSn != null)
      {
        paramVarArgs.oE(3, this.TSn.computeSize());
        this.TSn.writeFields(paramVarArgs);
      }
      if (this.TSo != null)
      {
        paramVarArgs.oE(4, this.TSo.computeSize());
        this.TSo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNL == null) {
        break label660;
      }
    }
    label660:
    for (int i = g.a.a.b.b.a.g(1, this.CNL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TSm != null) {
        paramInt = i + g.a.a.a.oD(2, this.TSm.computeSize());
      }
      i = paramInt;
      if (this.TSn != null) {
        i = paramInt + g.a.a.a.oD(3, this.TSn.computeSize());
      }
      paramInt = i;
      if (this.TSo != null) {
        paramInt = i + g.a.a.a.oD(4, this.TSo.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CNL == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlf localdlf = (dlf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localdlf.CNL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmb)localObject2).parseFrom((byte[])localObject1);
            }
            localdlf.TSm = ((fmb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fme)localObject2).parseFrom((byte[])localObject1);
            }
            localdlf.TSn = ((fme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new flx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((flx)localObject2).parseFrom((byte[])localObject1);
          }
          localdlf.TSo = ((flx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlf
 * JD-Core Version:    0.7.0.1
 */