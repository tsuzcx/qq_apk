package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class auw
  extends dyl
{
  public aqe SDi;
  public b SHf;
  public boolean SHg;
  public String finderUsername;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229863);
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
      if (this.finderUsername != null) {
        paramVarArgs.f(5, this.finderUsername);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.f(6, this.object_nonce_id);
      }
      paramVarArgs.aY(7, this.scene);
      if (this.SHf != null) {
        paramVarArgs.c(8, this.SHf);
      }
      paramVarArgs.co(9, this.SHg);
      AppMethodBeat.o(229863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.liveId) + g.a.a.b.b.a.p(4, this.xbk);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.finderUsername);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.object_nonce_id);
      }
      i += g.a.a.b.b.a.bM(7, this.scene);
      paramInt = i;
      if (this.SHf != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.SHf);
      }
      i = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(229863);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auw localauw = (auw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229863);
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
            localauw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229863);
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
            localauw.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229863);
          return 0;
        case 3: 
          localauw.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229863);
          return 0;
        case 4: 
          localauw.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229863);
          return 0;
        case 5: 
          localauw.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229863);
          return 0;
        case 6: 
          localauw.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229863);
          return 0;
        case 7: 
          localauw.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229863);
          return 0;
        case 8: 
          localauw.SHf = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229863);
          return 0;
        }
        localauw.SHg = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(229863);
        return 0;
      }
      AppMethodBeat.o(229863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auw
 * JD-Core Version:    0.7.0.1
 */