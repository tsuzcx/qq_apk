package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class mt
  extends dyy
{
  public int ROx;
  public int RSM;
  public String RSN;
  public long RSk;
  public int RSt;
  public GoodsObject RSw;
  public String fHb;
  public String zaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RSt);
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
      paramVarArgs.bm(11, this.RSk);
      paramVarArgs.aY(14, this.RSM);
      paramVarArgs.aY(15, this.ROx);
      if (this.RSN != null) {
        paramVarArgs.f(21, this.RSN);
      }
      AppMethodBeat.o(206470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RSt);
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
      i = paramInt + g.a.a.b.b.a.p(11, this.RSk) + g.a.a.b.b.a.bM(14, this.RSM) + g.a.a.b.b.a.bM(15, this.ROx);
      paramInt = i;
      if (this.RSN != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.RSN);
      }
      AppMethodBeat.o(206470);
      return paramInt;
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
          AppMethodBeat.o(206470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mt localmt = (mt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 12: 
        case 13: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(206470);
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
            localmt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206470);
          return 0;
        case 2: 
          localmt.RSt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206470);
          return 0;
        case 7: 
          localmt.fHb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206470);
          return 0;
        case 8: 
          localmt.zaK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206470);
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
            localmt.RSw = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206470);
          return 0;
        case 11: 
          localmt.RSk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(206470);
          return 0;
        case 14: 
          localmt.RSM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206470);
          return 0;
        case 15: 
          localmt.ROx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206470);
          return 0;
        }
        localmt.RSN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(206470);
        return 0;
      }
      AppMethodBeat.o(206470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mt
 * JD-Core Version:    0.7.0.1
 */