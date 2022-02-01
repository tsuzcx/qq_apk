package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwh
  extends dyl
{
  public long HLs;
  public String SWw;
  public cvz TFa;
  public int fSo;
  public long wGo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TFa != null)
      {
        paramVarArgs.oE(2, this.TFa.computeSize());
        this.TFa.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(3, this.HLs);
      paramVarArgs.aY(4, this.fSo);
      paramVarArgs.bm(5, this.wGo);
      if (this.SWw != null) {
        paramVarArgs.f(6, this.SWw);
      }
      AppMethodBeat.o(205611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TFa != null) {
        i = paramInt + g.a.a.a.oD(2, this.TFa.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.HLs) + g.a.a.b.b.a.bM(4, this.fSo) + g.a.a.b.b.a.p(5, this.wGo);
      paramInt = i;
      if (this.SWw != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SWw);
      }
      AppMethodBeat.o(205611);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwh localcwh = (cwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205611);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcwh.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205611);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvz)localObject2).parseFrom((byte[])localObject1);
            }
            localcwh.TFa = ((cvz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205611);
          return 0;
        case 3: 
          localcwh.HLs = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(205611);
          return 0;
        case 4: 
          localcwh.fSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205611);
          return 0;
        case 5: 
          localcwh.wGo = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(205611);
          return 0;
        }
        localcwh.SWw = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(205611);
        return 0;
      }
      AppMethodBeat.o(205611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwh
 * JD-Core Version:    0.7.0.1
 */