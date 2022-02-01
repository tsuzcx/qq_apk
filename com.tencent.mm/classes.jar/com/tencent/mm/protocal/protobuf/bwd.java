package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwd
  extends dyl
{
  public int TfQ;
  public int TfR;
  public String TfS;
  public boolean TfT;
  public duw TfU;
  public boolean TfV;
  public LinkedList<clq> TfW;
  public LinkedList<abc> TfX;
  
  public bwd()
  {
    AppMethodBeat.i(217002);
    this.TfW = new LinkedList();
    this.TfX = new LinkedList();
    AppMethodBeat.o(217002);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217005);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TfQ);
      paramVarArgs.aY(3, this.TfR);
      if (this.TfS != null) {
        paramVarArgs.f(4, this.TfS);
      }
      paramVarArgs.co(5, this.TfT);
      if (this.TfU != null)
      {
        paramVarArgs.oE(6, this.TfU.computeSize());
        this.TfU.writeFields(paramVarArgs);
      }
      paramVarArgs.co(7, this.TfV);
      paramVarArgs.e(8, 8, this.TfW);
      paramVarArgs.e(9, 8, this.TfX);
      AppMethodBeat.o(217005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TfQ) + g.a.a.b.b.a.bM(3, this.TfR);
      paramInt = i;
      if (this.TfS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TfS);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.TfU != null) {
        paramInt = i + g.a.a.a.oD(6, this.TfU.computeSize());
      }
      i = g.a.a.b.b.a.gL(7);
      int j = g.a.a.a.c(8, 8, this.TfW);
      int k = g.a.a.a.c(9, 8, this.TfX);
      AppMethodBeat.o(217005);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfW.clear();
        this.TfX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(217005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwd localbwd = (bwd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(217005);
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
            localbwd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(217005);
          return 0;
        case 2: 
          localbwd.TfQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(217005);
          return 0;
        case 3: 
          localbwd.TfR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(217005);
          return 0;
        case 4: 
          localbwd.TfS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(217005);
          return 0;
        case 5: 
          localbwd.TfT = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(217005);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duw)localObject2).parseFrom((byte[])localObject1);
            }
            localbwd.TfU = ((duw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(217005);
          return 0;
        case 7: 
          localbwd.TfV = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(217005);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clq)localObject2).parseFrom((byte[])localObject1);
            }
            localbwd.TfW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(217005);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new abc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((abc)localObject2).parseFrom((byte[])localObject1);
          }
          localbwd.TfX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(217005);
        return 0;
      }
      AppMethodBeat.o(217005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwd
 * JD-Core Version:    0.7.0.1
 */