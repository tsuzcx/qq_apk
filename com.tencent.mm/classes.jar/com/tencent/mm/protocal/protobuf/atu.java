package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atu
  extends dyl
{
  public String RLN;
  public aqe SDi;
  public LinkedList<String> SGD;
  public int SGE;
  public LinkedList<arg> SGF;
  public LinkedList<are> SGG;
  public LinkedList<arc> SGH;
  
  public atu()
  {
    AppMethodBeat.i(198494);
    this.SGD = new LinkedList();
    this.SGF = new LinkedList();
    this.SGG = new LinkedList();
    this.SGH = new LinkedList();
    AppMethodBeat.o(198494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.SGD);
      paramVarArgs.aY(4, this.SGE);
      if (this.RLN != null) {
        paramVarArgs.f(5, this.RLN);
      }
      paramVarArgs.e(6, 8, this.SGF);
      paramVarArgs.e(7, 8, this.SGG);
      paramVarArgs.e(8, 8, this.SGH);
      AppMethodBeat.o(198521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label944;
      }
    }
    label944:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.a.c(3, 1, this.SGD) + g.a.a.b.b.a.bM(4, this.SGE);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RLN);
      }
      i = g.a.a.a.c(6, 8, this.SGF);
      int j = g.a.a.a.c(7, 8, this.SGG);
      int k = g.a.a.a.c(8, 8, this.SGH);
      AppMethodBeat.o(198521);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGD.clear();
        this.SGF.clear();
        this.SGG.clear();
        this.SGH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198521);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atu localatu = (atu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198521);
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
            localatu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198521);
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
            localatu.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198521);
          return 0;
        case 3: 
          localatu.SGD.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(198521);
          return 0;
        case 4: 
          localatu.SGE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(198521);
          return 0;
        case 5: 
          localatu.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(198521);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arg)localObject2).parseFrom((byte[])localObject1);
            }
            localatu.SGF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198521);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new are();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((are)localObject2).parseFrom((byte[])localObject1);
            }
            localatu.SGG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198521);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new arc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((arc)localObject2).parseFrom((byte[])localObject1);
          }
          localatu.SGH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198521);
        return 0;
      }
      AppMethodBeat.o(198521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atu
 * JD-Core Version:    0.7.0.1
 */