package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byk
  extends dyy
{
  public int Tdw;
  public ul ThB;
  public ui ThC;
  public String ThD;
  public ug Thy;
  public int tqa;
  public String tqb;
  public int ufi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(246476);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(246476);
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
      if (this.ThB != null)
      {
        paramVarArgs.oE(4, this.ThB.computeSize());
        this.ThB.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.ufi);
      paramVarArgs.aY(6, this.Tdw);
      if (this.ThC != null)
      {
        paramVarArgs.oE(7, this.ThC.computeSize());
        this.ThC.writeFields(paramVarArgs);
      }
      if (this.Thy != null)
      {
        paramVarArgs.oE(8, this.Thy.computeSize());
        this.Thy.writeFields(paramVarArgs);
      }
      if (this.ThD != null) {
        paramVarArgs.f(9, this.ThD);
      }
      AppMethodBeat.o(246476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.ThB != null) {
        i = paramInt + g.a.a.a.oD(4, this.ThB.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(5, this.ufi) + g.a.a.b.b.a.bM(6, this.Tdw);
      paramInt = i;
      if (this.ThC != null) {
        paramInt = i + g.a.a.a.oD(7, this.ThC.computeSize());
      }
      i = paramInt;
      if (this.Thy != null) {
        i = paramInt + g.a.a.a.oD(8, this.Thy.computeSize());
      }
      paramInt = i;
      if (this.ThD != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.ThD);
      }
      AppMethodBeat.o(246476);
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
          AppMethodBeat.o(246476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(246476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byk localbyk = (byk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(246476);
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
            localbyk.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246476);
          return 0;
        case 2: 
          localbyk.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246476);
          return 0;
        case 3: 
          localbyk.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246476);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ul();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ul)localObject2).parseFrom((byte[])localObject1);
            }
            localbyk.ThB = ((ul)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246476);
          return 0;
        case 5: 
          localbyk.ufi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246476);
          return 0;
        case 6: 
          localbyk.Tdw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(246476);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ui();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ui)localObject2).parseFrom((byte[])localObject1);
            }
            localbyk.ThC = ((ui)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246476);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ug();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ug)localObject2).parseFrom((byte[])localObject1);
            }
            localbyk.Thy = ((ug)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246476);
          return 0;
        }
        localbyk.ThD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(246476);
        return 0;
      }
      AppMethodBeat.o(246476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byk
 * JD-Core Version:    0.7.0.1
 */