package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azv
  extends dyl
{
  public aqe SDi;
  public String SLt;
  public long klE;
  public long object_id;
  public String object_nonce_id;
  public long zaO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231109);
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
      paramVarArgs.bm(3, this.object_id);
      paramVarArgs.bm(4, this.klE);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(5, this.object_nonce_id);
      }
      paramVarArgs.bm(6, this.zaO);
      if (this.SLt != null) {
        paramVarArgs.f(7, this.SLt);
      }
      AppMethodBeat.o(231109);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.object_id) + g.a.a.b.b.a.p(4, this.klE);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.object_nonce_id);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.zaO);
      paramInt = i;
      if (this.SLt != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SLt);
      }
      AppMethodBeat.o(231109);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231109);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azv localazv = (azv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231109);
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
            localazv.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231109);
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
            localazv.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231109);
          return 0;
        case 3: 
          localazv.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231109);
          return 0;
        case 4: 
          localazv.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231109);
          return 0;
        case 5: 
          localazv.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231109);
          return 0;
        case 6: 
          localazv.zaO = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231109);
          return 0;
        }
        localazv.SLt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(231109);
        return 0;
      }
      AppMethodBeat.o(231109);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azv
 * JD-Core Version:    0.7.0.1
 */