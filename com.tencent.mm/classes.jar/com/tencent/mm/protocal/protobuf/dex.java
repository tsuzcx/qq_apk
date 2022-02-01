package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dex
  extends dyy
{
  public String RQt;
  public dmr RQv;
  public String TMx;
  public boolean TMy;
  public boolean TMz;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
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
      if (this.TMx != null) {
        paramVarArgs.f(4, this.TMx);
      }
      if (this.RQt != null) {
        paramVarArgs.f(7, this.RQt);
      }
      if (this.RQv != null)
      {
        paramVarArgs.oE(8, this.RQv.computeSize());
        this.RQv.writeFields(paramVarArgs);
      }
      paramVarArgs.co(9, this.TMy);
      paramVarArgs.co(10, this.TMz);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TMx != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TMx);
      }
      paramInt = i;
      if (this.RQt != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RQt);
      }
      i = paramInt;
      if (this.RQv != null) {
        i = paramInt + g.a.a.a.oD(8, this.RQv.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(9);
      int j = g.a.a.b.b.a.gL(10);
      AppMethodBeat.o(72529);
      return i + (paramInt + 1) + (j + 1);
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
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dex localdex = (dex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
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
            localdex.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localdex.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localdex.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localdex.TMx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localdex.RQt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmr)localObject2).parseFrom((byte[])localObject1);
            }
            localdex.RQv = ((dmr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localdex.TMy = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(72529);
          return 0;
        }
        localdex.TMz = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dex
 * JD-Core Version:    0.7.0.1
 */