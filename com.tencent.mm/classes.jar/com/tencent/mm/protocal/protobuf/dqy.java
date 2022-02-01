package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dqy
  extends dyy
{
  public long SqZ;
  public esi TdE;
  public dzl Trs;
  public long Trw;
  public String icon;
  public String llP;
  public int qJt;
  public String tpo;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
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
      if (this.llP != null) {
        paramVarArgs.f(4, this.llP);
      }
      paramVarArgs.bm(5, this.Trw);
      paramVarArgs.bm(6, this.SqZ);
      if (this.Trs != null)
      {
        paramVarArgs.oE(7, this.Trs.computeSize());
        this.Trs.writeFields(paramVarArgs);
      }
      if (this.TdE != null)
      {
        paramVarArgs.oE(8, this.TdE.computeSize());
        this.TdE.writeFields(paramVarArgs);
      }
      if (this.tpo != null) {
        paramVarArgs.f(9, this.tpo);
      }
      paramVarArgs.aY(10, this.qJt);
      if (this.icon != null) {
        paramVarArgs.f(11, this.icon);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1028;
      }
    }
    label1028:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.llP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.llP);
      }
      i = i + g.a.a.b.b.a.p(5, this.Trw) + g.a.a.b.b.a.p(6, this.SqZ);
      paramInt = i;
      if (this.Trs != null) {
        paramInt = i + g.a.a.a.oD(7, this.Trs.computeSize());
      }
      i = paramInt;
      if (this.TdE != null) {
        i = paramInt + g.a.a.a.oD(8, this.TdE.computeSize());
      }
      paramInt = i;
      if (this.tpo != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.tpo);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.qJt);
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.icon);
      }
      AppMethodBeat.o(72558);
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
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqy localdqy = (dqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localdqy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localdqy.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localdqy.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localdqy.llP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localdqy.Trw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localdqy.SqZ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzl)localObject2).parseFrom((byte[])localObject1);
            }
            localdqy.Trs = ((dzl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esi)localObject2).parseFrom((byte[])localObject1);
            }
            localdqy.TdE = ((esi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localdqy.tpo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localdqy.qJt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72558);
          return 0;
        }
        localdqy.icon = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqy
 * JD-Core Version:    0.7.0.1
 */