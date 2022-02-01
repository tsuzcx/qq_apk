package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bzs
  extends dyl
{
  public int CPw;
  public int RLe;
  public double RVy;
  public double RVz;
  public String SYn;
  public eae TgD;
  public int TgF;
  public double Tit;
  public double Tiu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TgD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CPw);
      paramVarArgs.aY(3, this.RLe);
      if (this.SYn != null) {
        paramVarArgs.f(4, this.SYn);
      }
      if (this.TgD != null)
      {
        paramVarArgs.oE(5, this.TgD.computeSize());
        this.TgD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, this.RVy);
      paramVarArgs.e(7, this.RVz);
      paramVarArgs.e(8, this.Tit);
      paramVarArgs.e(9, this.Tiu);
      paramVarArgs.aY(10, this.TgF);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CPw) + g.a.a.b.b.a.bM(3, this.RLe);
      paramInt = i;
      if (this.SYn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SYn);
      }
      i = paramInt;
      if (this.TgD != null) {
        i = paramInt + g.a.a.a.oD(5, this.TgD.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(6);
      int j = g.a.a.b.b.a.gL(7);
      int k = g.a.a.b.b.a.gL(8);
      int m = g.a.a.b.b.a.gL(9);
      int n = g.a.a.b.b.a.bM(10, this.TgF);
      AppMethodBeat.o(56249);
      return i + (paramInt + 8) + (j + 8) + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TgD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bzs localbzs = (bzs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
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
            localbzs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localbzs.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localbzs.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localbzs.SYn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56249);
          return 0;
        case 5: 
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
            localbzs.TgD = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localbzs.RVy = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localbzs.RVz = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localbzs.Tit = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localbzs.Tiu = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(56249);
          return 0;
        }
        localbzs.TgF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzs
 * JD-Core Version:    0.7.0.1
 */