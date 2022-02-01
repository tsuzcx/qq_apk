package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqa
  extends dyl
{
  public aqe SDi;
  public String SDo;
  public boolean enable;
  public long liveId;
  public int scene;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231366);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(3, this.liveId);
      paramVarArgs.bm(4, this.xbk);
      if (this.SDo != null) {
        paramVarArgs.f(5, this.SDo);
      }
      paramVarArgs.aY(6, this.scene);
      paramVarArgs.co(7, this.enable);
      AppMethodBeat.o(231366);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.liveId) + g.a.a.b.b.a.p(4, this.xbk);
      paramInt = i;
      if (this.SDo != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SDo);
      }
      i = g.a.a.b.b.a.bM(6, this.scene);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(231366);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231366);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqa localaqa = (aqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231366);
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
            localaqa.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231366);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localaqa.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231366);
          return 0;
        case 3: 
          localaqa.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231366);
          return 0;
        case 4: 
          localaqa.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231366);
          return 0;
        case 5: 
          localaqa.SDo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231366);
          return 0;
        case 6: 
          localaqa.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231366);
          return 0;
        }
        localaqa.enable = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(231366);
        return 0;
      }
      AppMethodBeat.o(231366);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqa
 * JD-Core Version:    0.7.0.1
 */