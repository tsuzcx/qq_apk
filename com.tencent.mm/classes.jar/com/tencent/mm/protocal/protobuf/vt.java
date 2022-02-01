package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class vt
  extends dyy
{
  public String ShU;
  public String ShV;
  public String ShW;
  public String ShX;
  public String fMS;
  public int fwx;
  public String tVo;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251362);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(251362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      if (this.fMS != null) {
        paramVarArgs.f(5, this.fMS);
      }
      if (this.ShU != null) {
        paramVarArgs.f(6, this.ShU);
      }
      if (this.ShV != null) {
        paramVarArgs.f(7, this.ShV);
      }
      if (this.ShW != null) {
        paramVarArgs.f(8, this.ShW);
      }
      if (this.ShX != null) {
        paramVarArgs.f(9, this.ShX);
      }
      AppMethodBeat.o(251362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label808;
      }
    }
    label808:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.title);
      }
      paramInt = i;
      if (this.fMS != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fMS);
      }
      i = paramInt;
      if (this.ShU != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ShU);
      }
      paramInt = i;
      if (this.ShV != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ShV);
      }
      i = paramInt;
      if (this.ShW != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.ShW);
      }
      paramInt = i;
      if (this.ShX != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.ShX);
      }
      AppMethodBeat.o(251362);
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
          AppMethodBeat.o(251362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(251362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        vt localvt = (vt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(251362);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localvt.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(251362);
          return 0;
        case 2: 
          localvt.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(251362);
          return 0;
        case 3: 
          localvt.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251362);
          return 0;
        case 4: 
          localvt.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251362);
          return 0;
        case 5: 
          localvt.fMS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251362);
          return 0;
        case 6: 
          localvt.ShU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251362);
          return 0;
        case 7: 
          localvt.ShV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251362);
          return 0;
        case 8: 
          localvt.ShW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251362);
          return 0;
        }
        localvt.ShX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(251362);
        return 0;
      }
      AppMethodBeat.o(251362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vt
 * JD-Core Version:    0.7.0.1
 */