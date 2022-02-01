package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dqw
  extends dyy
{
  public String GGC;
  public String TXt;
  public String TXu;
  public tk TXv;
  public String TXw;
  public String TXx;
  public etj TXy;
  public String fvP;
  public String llI;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
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
      if (this.TXt != null) {
        paramVarArgs.f(4, this.TXt);
      }
      if (this.llI != null) {
        paramVarArgs.f(5, this.llI);
      }
      if (this.TXu != null) {
        paramVarArgs.f(6, this.TXu);
      }
      if (this.TXv != null)
      {
        paramVarArgs.oE(7, this.TXv.computeSize());
        this.TXv.writeFields(paramVarArgs);
      }
      if (this.TXw != null) {
        paramVarArgs.f(8, this.TXw);
      }
      if (this.GGC != null) {
        paramVarArgs.f(9, this.GGC);
      }
      if (this.fvP != null) {
        paramVarArgs.f(10, this.fvP);
      }
      if (this.TXx != null) {
        paramVarArgs.f(11, this.TXx);
      }
      if (this.TXy != null)
      {
        paramVarArgs.oE(12, this.TXy.computeSize());
        this.TXy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1140;
      }
    }
    label1140:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TXt != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TXt);
      }
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.llI);
      }
      i = paramInt;
      if (this.TXu != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TXu);
      }
      paramInt = i;
      if (this.TXv != null) {
        paramInt = i + g.a.a.a.oD(7, this.TXv.computeSize());
      }
      i = paramInt;
      if (this.TXw != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TXw);
      }
      paramInt = i;
      if (this.GGC != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.GGC);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.fvP);
      }
      paramInt = i;
      if (this.TXx != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TXx);
      }
      i = paramInt;
      if (this.TXy != null) {
        i = paramInt + g.a.a.a.oD(12, this.TXy.computeSize());
      }
      AppMethodBeat.o(72556);
      return i;
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
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqw localdqw = (dqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localdqw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localdqw.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localdqw.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localdqw.TXt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localdqw.llI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localdqw.TXu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tk)localObject2).parseFrom((byte[])localObject1);
            }
            localdqw.TXv = ((tk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localdqw.TXw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localdqw.GGC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localdqw.fvP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localdqw.TXx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etj)localObject2).parseFrom((byte[])localObject1);
          }
          localdqw.TXy = ((etj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqw
 * JD-Core Version:    0.7.0.1
 */