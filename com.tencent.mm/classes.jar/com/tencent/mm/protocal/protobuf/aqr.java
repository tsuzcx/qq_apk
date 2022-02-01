package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqr
  extends dyl
{
  public String SDS;
  public String finderUsername;
  public long liveId;
  public int scene;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.liveId);
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      paramVarArgs.bm(4, this.xbk);
      if (this.SDS != null) {
        paramVarArgs.f(5, this.SDS);
      }
      paramVarArgs.aY(6, this.scene);
      AppMethodBeat.o(229714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label544;
      }
    }
    label544:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.liveId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.xbk);
      paramInt = i;
      if (this.SDS != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SDS);
      }
      i = g.a.a.b.b.a.bM(6, this.scene);
      AppMethodBeat.o(229714);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aqr localaqr = (aqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229714);
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
            localaqr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(229714);
          return 0;
        case 2: 
          localaqr.liveId = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(229714);
          return 0;
        case 3: 
          localaqr.finderUsername = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229714);
          return 0;
        case 4: 
          localaqr.xbk = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(229714);
          return 0;
        case 5: 
          localaqr.SDS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229714);
          return 0;
        }
        localaqr.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(229714);
        return 0;
      }
      AppMethodBeat.o(229714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqr
 * JD-Core Version:    0.7.0.1
 */