package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aer
  extends dyy
{
  public LinkedList<dfe> RIQ;
  public String Srd;
  public String Sre;
  public String mye;
  
  public aer()
  {
    AppMethodBeat.i(152524);
    this.RIQ = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.mye != null) {
        paramVarArgs.f(2, this.mye);
      }
      paramVarArgs.e(3, 8, this.RIQ);
      if (this.Srd != null) {
        paramVarArgs.f(4, this.Srd);
      }
      if (this.Sre != null) {
        paramVarArgs.f(5, this.Sre);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mye != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.mye);
      }
      i += g.a.a.a.c(3, 8, this.RIQ);
      paramInt = i;
      if (this.Srd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Srd);
      }
      i = paramInt;
      if (this.Sre != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sre);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aer localaer = (aer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
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
            localaer.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localaer.mye = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfe)localObject2).parseFrom((byte[])localObject1);
            }
            localaer.RIQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localaer.Srd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localaer.Sre = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aer
 * JD-Core Version:    0.7.0.1
 */