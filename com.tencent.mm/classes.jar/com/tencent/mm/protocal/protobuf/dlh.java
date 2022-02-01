package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dlh
  extends dyy
{
  public long OkS;
  public String OkT;
  public String OkV;
  public String OkW;
  public LinkedList<dli> TSp;
  public iw TSq;
  public int TSr;
  public int tqa;
  public String tqb;
  
  public dlh()
  {
    AppMethodBeat.i(91616);
    this.TSp = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.e(4, 8, this.TSp);
      paramVarArgs.bm(5, this.OkS);
      if (this.OkT != null) {
        paramVarArgs.f(6, this.OkT);
      }
      if (this.TSq != null)
      {
        paramVarArgs.oE(7, this.TSq.computeSize());
        this.TSq.writeFields(paramVarArgs);
      }
      if (this.OkV != null) {
        paramVarArgs.f(8, this.OkV);
      }
      if (this.OkW != null) {
        paramVarArgs.f(9, this.OkW);
      }
      paramVarArgs.aY(10, this.TSr);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label968;
      }
    }
    label968:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.TSp) + g.a.a.b.b.a.p(5, this.OkS);
      paramInt = i;
      if (this.OkT != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.OkT);
      }
      i = paramInt;
      if (this.TSq != null) {
        i = paramInt + g.a.a.a.oD(7, this.TSq.computeSize());
      }
      paramInt = i;
      if (this.OkV != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.OkV);
      }
      i = paramInt;
      if (this.OkW != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.OkW);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.TSr);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TSp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlh localdlh = (dlh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localdlh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localdlh.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localdlh.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dli();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dli)localObject2).parseFrom((byte[])localObject1);
            }
            localdlh.TSp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localdlh.OkS = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localdlh.OkT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new iw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((iw)localObject2).parseFrom((byte[])localObject1);
            }
            localdlh.TSq = ((iw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localdlh.OkV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localdlh.OkW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localdlh.TSr = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlh
 * JD-Core Version:    0.7.0.1
 */