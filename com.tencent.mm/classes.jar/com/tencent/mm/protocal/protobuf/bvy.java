package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvy
  extends dyy
{
  public int TfG;
  public int TfH;
  public LinkedList<cof> TfI;
  public String TfJ;
  
  public bvy()
  {
    AppMethodBeat.i(255613);
    this.TfI = new LinkedList();
    AppMethodBeat.o(255613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255620);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(255620);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TfG);
      paramVarArgs.aY(3, this.TfH);
      paramVarArgs.e(4, 8, this.TfI);
      if (this.TfJ != null) {
        paramVarArgs.f(5, this.TfJ);
      }
      AppMethodBeat.o(255620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TfG) + g.a.a.b.b.a.bM(3, this.TfH) + g.a.a.a.c(4, 8, this.TfI);
      paramInt = i;
      if (this.TfJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TfJ);
      }
      AppMethodBeat.o(255620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(255620);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255620);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvy localbvy = (bvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255620);
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
            localbvy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255620);
          return 0;
        case 2: 
          localbvy.TfG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255620);
          return 0;
        case 3: 
          localbvy.TfH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255620);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cof();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cof)localObject2).parseFrom((byte[])localObject1);
            }
            localbvy.TfI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255620);
          return 0;
        }
        localbvy.TfJ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(255620);
        return 0;
      }
      AppMethodBeat.o(255620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvy
 * JD-Core Version:    0.7.0.1
 */