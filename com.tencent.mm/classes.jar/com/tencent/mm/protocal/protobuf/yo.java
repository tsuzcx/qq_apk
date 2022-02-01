package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class yo
  extends dyy
{
  public fne SkF;
  public boolean SkG;
  public String SkH;
  public String SkI;
  public boolean SkJ;
  public String SkK;
  public String SkL;
  public String SkM;
  public String SkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SkF != null)
      {
        paramVarArgs.oE(2, this.SkF.computeSize());
        this.SkF.writeFields(paramVarArgs);
      }
      paramVarArgs.co(3, this.SkG);
      if (this.SkH != null) {
        paramVarArgs.f(4, this.SkH);
      }
      if (this.SkI != null) {
        paramVarArgs.f(5, this.SkI);
      }
      paramVarArgs.co(6, this.SkJ);
      if (this.SkK != null) {
        paramVarArgs.f(7, this.SkK);
      }
      if (this.SkL != null) {
        paramVarArgs.f(8, this.SkL);
      }
      if (this.SkM != null) {
        paramVarArgs.f(9, this.SkM);
      }
      if (this.SkN != null) {
        paramVarArgs.f(10, this.SkN);
      }
      AppMethodBeat.o(123562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SkF != null) {
        i = paramInt + g.a.a.a.oD(2, this.SkF.computeSize());
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.SkH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SkH);
      }
      i = paramInt;
      if (this.SkI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SkI);
      }
      i += g.a.a.b.b.a.gL(6) + 1;
      paramInt = i;
      if (this.SkK != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SkK);
      }
      i = paramInt;
      if (this.SkL != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.SkL);
      }
      paramInt = i;
      if (this.SkM != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SkM);
      }
      i = paramInt;
      if (this.SkN != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SkN);
      }
      AppMethodBeat.o(123562);
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
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yo localyo = (yo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
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
            localyo.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fne();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fne)localObject2).parseFrom((byte[])localObject1);
            }
            localyo.SkF = ((fne)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localyo.SkG = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localyo.SkH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localyo.SkI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localyo.SkJ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localyo.SkK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localyo.SkL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localyo.SkM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localyo.SkN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yo
 * JD-Core Version:    0.7.0.1
 */