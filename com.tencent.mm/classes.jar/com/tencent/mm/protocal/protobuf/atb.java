package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atb
  extends dyl
{
  public String SFp;
  public String finderUsername;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String sessionBuffer;
  public int xbJ;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SFp != null) {
        paramVarArgs.f(2, this.SFp);
      }
      paramVarArgs.aY(3, this.opType);
      paramVarArgs.bm(4, this.refObjectId);
      if (this.finderUsername != null) {
        paramVarArgs.f(5, this.finderUsername);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.f(6, this.refObjectNonceId);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(7, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(8, this.sessionBuffer);
      }
      paramVarArgs.aY(9, this.xbJ);
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SFp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SFp);
      }
      i = i + g.a.a.b.b.a.bM(3, this.opType) + g.a.a.b.b.a.p(4, this.refObjectId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.finderUsername);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(7, this.yjp.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.sessionBuffer);
      }
      paramInt = g.a.a.b.b.a.bM(9, this.xbJ);
      AppMethodBeat.o(168964);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atb localatb = (atb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
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
            localatb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localatb.SFp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localatb.opType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localatb.refObjectId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localatb.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localatb.refObjectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
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
            localatb.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localatb.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168964);
          return 0;
        }
        localatb.xbJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atb
 * JD-Core Version:    0.7.0.1
 */