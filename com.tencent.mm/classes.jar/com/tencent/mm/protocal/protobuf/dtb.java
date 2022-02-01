package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dtb
  extends dyy
{
  public int TZA;
  public int TZB;
  public String TZC;
  public dsy TZl;
  public String vpp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.TZl != null)
      {
        paramVarArgs.oE(1, this.TZl.computeSize());
        this.TZl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TZA);
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.vpp != null) {
        paramVarArgs.f(4, this.vpp);
      }
      paramVarArgs.aY(5, this.TZB);
      if (this.TZC != null) {
        paramVarArgs.f(6, this.TZC);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TZl == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = g.a.a.a.oD(1, this.TZl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TZA);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.oD(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.vpp != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.vpp);
      }
      i += g.a.a.b.b.a.bM(5, this.TZB);
      paramInt = i;
      if (this.TZC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TZC);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TZl == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dtb localdtb = (dtb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dsy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dsy)localObject2).parseFrom((byte[])localObject1);
            }
            localdtb.TZl = ((dsy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localdtb.TZA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
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
            localdtb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localdtb.vpp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localdtb.TZB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32404);
          return 0;
        }
        localdtb.TZC = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtb
 * JD-Core Version:    0.7.0.1
 */