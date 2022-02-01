package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ma
  extends dyy
{
  public int RFA;
  public int RFx;
  public eae RIH;
  public eae RLX;
  public eae RMd;
  public int RRA;
  public String RRB;
  public String RRC;
  public eai RRm;
  public String RRu;
  public eaf RRx;
  public eae RRy;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RRu != null) {
        paramVarArgs.f(2, this.RRu);
      }
      if (this.RIH != null)
      {
        paramVarArgs.oE(3, this.RIH.computeSize());
        this.RIH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.RFA);
      paramVarArgs.aY(5, this.RRA);
      if (this.RRB != null) {
        paramVarArgs.f(6, this.RRB);
      }
      paramVarArgs.aY(7, this.rVU);
      if (this.RRC != null) {
        paramVarArgs.f(8, this.RRC);
      }
      if (this.RRx != null)
      {
        paramVarArgs.oE(9, this.RRx.computeSize());
        this.RRx.writeFields(paramVarArgs);
      }
      if (this.RMd != null)
      {
        paramVarArgs.oE(10, this.RMd.computeSize());
        this.RMd.writeFields(paramVarArgs);
      }
      if (this.RRy != null)
      {
        paramVarArgs.oE(11, this.RRy.computeSize());
        this.RRy.writeFields(paramVarArgs);
      }
      if (this.RRm != null)
      {
        paramVarArgs.oE(12, this.RRm.computeSize());
        this.RRm.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.RFx);
      if (this.RLX != null)
      {
        paramVarArgs.oE(14, this.RLX.computeSize());
        this.RLX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1548;
      }
    }
    label1548:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRu != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RRu);
      }
      i = paramInt;
      if (this.RIH != null) {
        i = paramInt + g.a.a.a.oD(3, this.RIH.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(4, this.RFA) + g.a.a.b.b.a.bM(5, this.RRA);
      paramInt = i;
      if (this.RRB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RRB);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.rVU);
      paramInt = i;
      if (this.RRC != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RRC);
      }
      i = paramInt;
      if (this.RRx != null) {
        i = paramInt + g.a.a.a.oD(9, this.RRx.computeSize());
      }
      paramInt = i;
      if (this.RMd != null) {
        paramInt = i + g.a.a.a.oD(10, this.RMd.computeSize());
      }
      i = paramInt;
      if (this.RRy != null) {
        i = paramInt + g.a.a.a.oD(11, this.RRy.computeSize());
      }
      paramInt = i;
      if (this.RRm != null) {
        paramInt = i + g.a.a.a.oD(12, this.RRm.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.RFx);
      paramInt = i;
      if (this.RLX != null) {
        paramInt = i + g.a.a.a.oD(14, this.RLX.computeSize());
      }
      AppMethodBeat.o(155397);
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
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.RIH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ma localma = (ma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
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
            localma.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          localma.RRu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localma.RIH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          localma.RFA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          localma.RRA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          localma.RRB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          localma.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          localma.RRC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localma.RRx = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localma.RMd = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localma.RRy = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eai();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eai)localObject2).parseFrom((byte[])localObject1);
            }
            localma.RRm = ((eai)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          localma.RFx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155397);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localma.RLX = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ma
 * JD-Core Version:    0.7.0.1
 */