package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class arz
  extends dyl
{
  public b SFq;
  public long refObjectId;
  public String username;
  public long xbT;
  public long xcD;
  public int xcE;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204884);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(2, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(3, this.username);
      }
      paramVarArgs.bm(4, this.xcD);
      if (this.SFq != null) {
        paramVarArgs.c(5, this.SFq);
      }
      paramVarArgs.bm(6, this.refObjectId);
      paramVarArgs.bm(7, this.xbT);
      paramVarArgs.aY(8, this.xcE);
      AppMethodBeat.o(204884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(2, this.yjp.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.username);
      }
      i += g.a.a.b.b.a.p(4, this.xcD);
      paramInt = i;
      if (this.SFq != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SFq);
      }
      i = g.a.a.b.b.a.p(6, this.refObjectId);
      int j = g.a.a.b.b.a.p(7, this.xbT);
      int k = g.a.a.b.b.a.bM(8, this.xcE);
      AppMethodBeat.o(204884);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arz localarz = (arz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204884);
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
            localarz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204884);
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
            localarz.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204884);
          return 0;
        case 3: 
          localarz.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204884);
          return 0;
        case 4: 
          localarz.xcD = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(204884);
          return 0;
        case 5: 
          localarz.SFq = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(204884);
          return 0;
        case 6: 
          localarz.refObjectId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(204884);
          return 0;
        case 7: 
          localarz.xbT = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(204884);
          return 0;
        }
        localarz.xcE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(204884);
        return 0;
      }
      AppMethodBeat.o(204884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arz
 * JD-Core Version:    0.7.0.1
 */