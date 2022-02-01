package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ie
  extends dyl
{
  public int CPw;
  public String RNA;
  public int RNw;
  public LinkedList<adp> RNx;
  public String RNy;
  public String RNz;
  public long rVQ;
  
  public ie()
  {
    AppMethodBeat.i(32133);
    this.RNx = new LinkedList();
    AppMethodBeat.o(32133);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32134);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RNw);
      paramVarArgs.e(3, 8, this.RNx);
      if (this.RNy != null) {
        paramVarArgs.f(4, this.RNy);
      }
      if (this.RNz != null) {
        paramVarArgs.f(5, this.RNz);
      }
      paramVarArgs.aY(6, this.CPw);
      paramVarArgs.bm(7, this.rVQ);
      if (this.RNA != null) {
        paramVarArgs.f(8, this.RNA);
      }
      AppMethodBeat.o(32134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNw) + g.a.a.a.c(3, 8, this.RNx);
      paramInt = i;
      if (this.RNy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RNy);
      }
      i = paramInt;
      if (this.RNz != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RNz);
      }
      i = i + g.a.a.b.b.a.bM(6, this.CPw) + g.a.a.b.b.a.p(7, this.rVQ);
      paramInt = i;
      if (this.RNA != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RNA);
      }
      AppMethodBeat.o(32134);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ie localie = (ie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32134);
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
            localie.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 2: 
          localie.RNw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32134);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adp)localObject2).parseFrom((byte[])localObject1);
            }
            localie.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 4: 
          localie.RNy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 5: 
          localie.RNz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 6: 
          localie.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32134);
          return 0;
        case 7: 
          localie.rVQ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32134);
          return 0;
        }
        localie.RNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32134);
        return 0;
      }
      AppMethodBeat.o(32134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ie
 * JD-Core Version:    0.7.0.1
 */