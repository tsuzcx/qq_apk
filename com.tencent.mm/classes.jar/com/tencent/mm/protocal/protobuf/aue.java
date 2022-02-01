package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aue
  extends dyl
{
  public aqe SDi;
  public b lastBuffer;
  public String objectNonceId;
  public long xbk;
  public String xcR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199113);
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
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.xcR != null) {
        paramVarArgs.f(4, this.xcR);
      }
      paramVarArgs.bm(5, this.xbk);
      if (this.objectNonceId != null) {
        paramVarArgs.f(6, this.objectNonceId);
      }
      AppMethodBeat.o(199113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      paramInt = i;
      if (this.xcR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.xcR);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.xbk);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.objectNonceId);
      }
      AppMethodBeat.o(199113);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aue localaue = (aue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199113);
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
            localaue.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199113);
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
            localaue.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199113);
          return 0;
        case 3: 
          localaue.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(199113);
          return 0;
        case 4: 
          localaue.xcR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199113);
          return 0;
        case 5: 
          localaue.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(199113);
          return 0;
        }
        localaue.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199113);
        return 0;
      }
      AppMethodBeat.o(199113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aue
 * JD-Core Version:    0.7.0.1
 */