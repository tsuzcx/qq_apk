package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erm
  extends dyl
{
  public String RVi;
  public long RXN;
  public int RXS;
  public String RXT;
  public String UtC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207229);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.RXN);
      paramVarArgs.aY(3, this.RXS);
      if (this.RVi != null) {
        paramVarArgs.f(4, this.RVi);
      }
      if (this.RXT != null) {
        paramVarArgs.f(5, this.RXT);
      }
      if (this.UtC != null) {
        paramVarArgs.f(6, this.UtC);
      }
      AppMethodBeat.o(207229);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RXN) + g.a.a.b.b.a.bM(3, this.RXS);
      paramInt = i;
      if (this.RVi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RVi);
      }
      i = paramInt;
      if (this.RXT != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RXT);
      }
      paramInt = i;
      if (this.UtC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UtC);
      }
      AppMethodBeat.o(207229);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207229);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        erm localerm = (erm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207229);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localerm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(207229);
          return 0;
        case 2: 
          localerm.RXN = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(207229);
          return 0;
        case 3: 
          localerm.RXS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(207229);
          return 0;
        case 4: 
          localerm.RVi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207229);
          return 0;
        case 5: 
          localerm.RXT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207229);
          return 0;
        }
        localerm.UtC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(207229);
        return 0;
      }
      AppMethodBeat.o(207229);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erm
 * JD-Core Version:    0.7.0.1
 */