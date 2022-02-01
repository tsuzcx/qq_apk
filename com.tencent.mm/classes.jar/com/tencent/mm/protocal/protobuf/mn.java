package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class mn
  extends dyy
{
  public int RSA;
  public int RSi;
  public int RSj;
  public long RSk;
  public int RSt;
  public String RSu;
  public String RSv;
  public GoodsObject RSw;
  public boolean RSx = false;
  public int RSy;
  public boolean RSz;
  public String fHb;
  public String zaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RSt);
      if (this.RSu != null) {
        paramVarArgs.f(3, this.RSu);
      }
      if (this.RSv != null) {
        paramVarArgs.f(4, this.RSv);
      }
      if (this.fHb != null) {
        paramVarArgs.f(7, this.fHb);
      }
      if (this.zaK != null) {
        paramVarArgs.f(8, this.zaK);
      }
      if (this.RSw != null)
      {
        paramVarArgs.oE(9, this.RSw.computeSize());
        this.RSw.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.RSi);
      paramVarArgs.bm(11, this.RSk);
      paramVarArgs.aY(12, this.RSj);
      paramVarArgs.co(13, this.RSx);
      paramVarArgs.aY(16, this.RSy);
      paramVarArgs.co(17, this.RSz);
      paramVarArgs.aY(50, this.RSA);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RSt);
      paramInt = i;
      if (this.RSu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RSu);
      }
      i = paramInt;
      if (this.RSv != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RSv);
      }
      paramInt = i;
      if (this.fHb != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.fHb);
      }
      i = paramInt;
      if (this.zaK != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.zaK);
      }
      paramInt = i;
      if (this.RSw != null) {
        paramInt = i + g.a.a.a.oD(9, this.RSw.computeSize());
      }
      i = g.a.a.b.b.a.bM(10, this.RSi);
      int j = g.a.a.b.b.a.p(11, this.RSk);
      int k = g.a.a.b.b.a.bM(12, this.RSj);
      int m = g.a.a.b.b.a.gL(13);
      int n = g.a.a.b.b.a.bM(16, this.RSy);
      int i1 = g.a.a.b.b.a.gL(17);
      int i2 = g.a.a.b.b.a.bM(50, this.RSA);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + (m + 1) + n + (i1 + 1) + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mn localmn = (mn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
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
            localmn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localmn.RSt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localmn.RSu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localmn.RSv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localmn.fHb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localmn.zaK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localmn.RSw = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localmn.RSi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localmn.RSk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localmn.RSj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localmn.RSx = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124395);
          return 0;
        case 16: 
          localmn.RSy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124395);
          return 0;
        case 17: 
          localmn.RSz = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124395);
          return 0;
        }
        localmn.RSA = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mn
 * JD-Core Version:    0.7.0.1
 */