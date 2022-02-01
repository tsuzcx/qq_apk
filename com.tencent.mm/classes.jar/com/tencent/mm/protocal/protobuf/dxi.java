package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dxi
  extends dyl
{
  public float UcQ;
  public b UcR;
  public boolean UcS;
  public boolean UcT;
  public String fUL;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.i(2, this.longitude);
      paramVarArgs.i(3, this.latitude);
      paramVarArgs.i(4, this.UcQ);
      if (this.UcR != null) {
        paramVarArgs.c(5, this.UcR);
      }
      if (this.fUL != null) {
        paramVarArgs.f(6, this.fUL);
      }
      paramVarArgs.co(7, this.UcS);
      paramVarArgs.co(8, this.UcT);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label633;
      }
    }
    label633:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 4) + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4);
      paramInt = i;
      if (this.UcR != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.UcR);
      }
      i = paramInt;
      if (this.fUL != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.fUL);
      }
      paramInt = g.a.a.b.b.a.gL(7);
      int j = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(114064);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dxi localdxi = (dxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localdxi.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localdxi.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localdxi.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localdxi.UcQ = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localdxi.UcR = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localdxi.fUL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localdxi.UcS = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(114064);
          return 0;
        }
        localdxi.UcT = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxi
 * JD-Core Version:    0.7.0.1
 */