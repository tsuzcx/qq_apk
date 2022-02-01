package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbm
  extends dyl
{
  public aqe SDi;
  public int SNi;
  public String finderUsername;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  public long xbk;
  public long yiz;
  public long zaI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230708);
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
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      paramVarArgs.bm(4, this.liveId);
      paramVarArgs.bm(5, this.xbk);
      paramVarArgs.bm(6, this.yiz);
      paramVarArgs.aY(7, this.scene);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(8, this.object_nonce_id);
      }
      paramVarArgs.aY(9, this.SNi);
      paramVarArgs.bm(10, this.zaI);
      AppMethodBeat.o(230708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      i = i + g.a.a.b.b.a.p(4, this.liveId) + g.a.a.b.b.a.p(5, this.xbk) + g.a.a.b.b.a.p(6, this.yiz) + g.a.a.b.b.a.bM(7, this.scene);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.object_nonce_id);
      }
      i = g.a.a.b.b.a.bM(9, this.SNi);
      int j = g.a.a.b.b.a.p(10, this.zaI);
      AppMethodBeat.o(230708);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bbm localbbm = (bbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230708);
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
            localbbm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230708);
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
            localbbm.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230708);
          return 0;
        case 3: 
          localbbm.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230708);
          return 0;
        case 4: 
          localbbm.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230708);
          return 0;
        case 5: 
          localbbm.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230708);
          return 0;
        case 6: 
          localbbm.yiz = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230708);
          return 0;
        case 7: 
          localbbm.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230708);
          return 0;
        case 8: 
          localbbm.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230708);
          return 0;
        case 9: 
          localbbm.SNi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230708);
          return 0;
        }
        localbbm.zaI = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(230708);
        return 0;
      }
      AppMethodBeat.o(230708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbm
 * JD-Core Version:    0.7.0.1
 */