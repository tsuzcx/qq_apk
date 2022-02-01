package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgt
  extends dyy
{
  public int RTb;
  public int TcZ;
  public dhp TnK;
  public LinkedList<czs> TnQ;
  public String TnR;
  public String TnS;
  public String TnT;
  public String TnU;
  public String TnV;
  public LinkedList<fou> TnW;
  public String appid;
  public String fJj;
  public int ret;
  public String ufs;
  public String url;
  
  public cgt()
  {
    AppMethodBeat.i(123588);
    this.TnQ = new LinkedList();
    this.TnW = new LinkedList();
    AppMethodBeat.o(123588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.ret);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      paramVarArgs.aY(4, this.TcZ);
      if (this.fJj != null) {
        paramVarArgs.f(5, this.fJj);
      }
      if (this.TnK != null)
      {
        paramVarArgs.oE(6, this.TnK.computeSize());
        this.TnK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.TnQ);
      if (this.TnR != null) {
        paramVarArgs.f(8, this.TnR);
      }
      if (this.ufs != null) {
        paramVarArgs.f(9, this.ufs);
      }
      paramVarArgs.aY(10, this.RTb);
      if (this.appid != null) {
        paramVarArgs.f(11, this.appid);
      }
      if (this.TnS != null) {
        paramVarArgs.f(12, this.TnS);
      }
      if (this.TnT != null) {
        paramVarArgs.f(13, this.TnT);
      }
      if (this.TnU != null) {
        paramVarArgs.f(14, this.TnU);
      }
      if (this.TnV != null) {
        paramVarArgs.f(15, this.TnV);
      }
      paramVarArgs.e(16, 8, this.TnW);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1398;
      }
    }
    label1398:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TcZ);
      paramInt = i;
      if (this.fJj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fJj);
      }
      i = paramInt;
      if (this.TnK != null) {
        i = paramInt + g.a.a.a.oD(6, this.TnK.computeSize());
      }
      i += g.a.a.a.c(7, 8, this.TnQ);
      paramInt = i;
      if (this.TnR != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TnR);
      }
      i = paramInt;
      if (this.ufs != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ufs);
      }
      i += g.a.a.b.b.a.bM(10, this.RTb);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.appid);
      }
      i = paramInt;
      if (this.TnS != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TnS);
      }
      paramInt = i;
      if (this.TnT != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TnT);
      }
      i = paramInt;
      if (this.TnU != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TnU);
      }
      paramInt = i;
      if (this.TnV != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TnV);
      }
      i = g.a.a.a.c(16, 8, this.TnW);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TnQ.clear();
        this.TnW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgt localcgt = (cgt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcgt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localcgt.ret = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localcgt.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localcgt.TcZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localcgt.fJj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhp)localObject2).parseFrom((byte[])localObject1);
            }
            localcgt.TnK = ((dhp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czs)localObject2).parseFrom((byte[])localObject1);
            }
            localcgt.TnQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localcgt.TnR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localcgt.ufs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localcgt.RTb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localcgt.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localcgt.TnS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localcgt.TnT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localcgt.TnU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localcgt.TnV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fou();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fou)localObject2).parseFrom((byte[])localObject1);
          }
          localcgt.TnW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      AppMethodBeat.o(123589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgt
 * JD-Core Version:    0.7.0.1
 */