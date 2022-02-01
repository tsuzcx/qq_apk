package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bgz
  extends dyl
{
  public String RLN;
  public aqe SDi;
  public String ilo;
  public long liveId;
  public String object_nonce_id;
  public b xak;
  public long xbk;
  public bbd yig;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230659);
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
      if (this.xak != null) {
        paramVarArgs.c(3, this.xak);
      }
      if (this.yig != null)
      {
        paramVarArgs.oE(4, this.yig.computeSize());
        this.yig.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.liveId);
      if (this.ilo != null) {
        paramVarArgs.f(6, this.ilo);
      }
      paramVarArgs.bm(7, this.xbk);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(8, this.object_nonce_id);
      }
      if (this.RLN != null) {
        paramVarArgs.f(9, this.RLN);
      }
      AppMethodBeat.o(230659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label888;
      }
    }
    label888:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.xak != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.xak);
      }
      paramInt = i;
      if (this.yig != null) {
        paramInt = i + g.a.a.a.oD(4, this.yig.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.liveId);
      paramInt = i;
      if (this.ilo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ilo);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.xbk);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.object_nonce_id);
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RLN);
      }
      AppMethodBeat.o(230659);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgz localbgz = (bgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230659);
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
            localbgz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230659);
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
            localbgz.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230659);
          return 0;
        case 3: 
          localbgz.xak = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230659);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbd)localObject2).parseFrom((byte[])localObject1);
            }
            localbgz.yig = ((bbd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230659);
          return 0;
        case 5: 
          localbgz.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230659);
          return 0;
        case 6: 
          localbgz.ilo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230659);
          return 0;
        case 7: 
          localbgz.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230659);
          return 0;
        case 8: 
          localbgz.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230659);
          return 0;
        }
        localbgz.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(230659);
        return 0;
      }
      AppMethodBeat.o(230659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgz
 * JD-Core Version:    0.7.0.1
 */