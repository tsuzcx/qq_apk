package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boj
  extends dyl
{
  public double RVy;
  public double RVz;
  public int SZq;
  public String SZr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.RVy);
      paramVarArgs.e(3, this.RVz);
      paramVarArgs.aY(4, this.SZq);
      if (this.SZr != null) {
        paramVarArgs.f(5, this.SZr);
      }
      AppMethodBeat.o(188405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label482;
      }
    }
    label482:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 8) + (g.a.a.b.b.a.gL(3) + 8) + g.a.a.b.b.a.bM(4, this.SZq);
      paramInt = i;
      if (this.SZr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SZr);
      }
      AppMethodBeat.o(188405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(188405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        boj localboj = (boj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188405);
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
            localboj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(188405);
          return 0;
        case 2: 
          localboj.RVy = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(188405);
          return 0;
        case 3: 
          localboj.RVz = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(188405);
          return 0;
        case 4: 
          localboj.SZq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(188405);
          return 0;
        }
        localboj.SZr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(188405);
        return 0;
      }
      AppMethodBeat.o(188405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boj
 * JD-Core Version:    0.7.0.1
 */