package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amq
  extends dyl
{
  public int GVj;
  public int SwS;
  public int gbo;
  public double latitude;
  public double longitude;
  public int tVd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tVd);
      paramVarArgs.aY(3, this.GVj);
      paramVarArgs.aY(4, this.gbo);
      paramVarArgs.aY(5, this.SwS);
      paramVarArgs.e(6, this.latitude);
      paramVarArgs.e(7, this.longitude);
      AppMethodBeat.o(91456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.tVd);
      int j = g.a.a.b.b.a.bM(3, this.GVj);
      int k = g.a.a.b.b.a.bM(4, this.gbo);
      int m = g.a.a.b.b.a.bM(5, this.SwS);
      int n = g.a.a.b.b.a.gL(6);
      int i1 = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(91456);
      return paramInt + i + j + k + m + (n + 8) + (i1 + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amq localamq = (amq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91456);
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
            localamq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91456);
          return 0;
        case 2: 
          localamq.tVd = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91456);
          return 0;
        case 3: 
          localamq.GVj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91456);
          return 0;
        case 4: 
          localamq.gbo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91456);
          return 0;
        case 5: 
          localamq.SwS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91456);
          return 0;
        case 6: 
          localamq.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(91456);
          return 0;
        }
        localamq.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(91456);
        return 0;
      }
      AppMethodBeat.o(91456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amq
 * JD-Core Version:    0.7.0.1
 */