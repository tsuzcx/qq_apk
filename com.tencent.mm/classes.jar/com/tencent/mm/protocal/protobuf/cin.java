package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cin
  extends dyl
{
  public String CPt;
  public String lVG;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.CPt != null) {
        paramVarArgs.f(3, this.CPt);
      }
      if (this.mVH != null) {
        paramVarArgs.f(4, this.mVH);
      }
      AppMethodBeat.o(89660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.CPt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CPt);
      }
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVH);
      }
      AppMethodBeat.o(89660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.lVG == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        if (this.CPt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cin localcin = (cin)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89660);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localcin.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(89660);
          return 0;
        case 2: 
          localcin.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(89660);
          return 0;
        case 3: 
          localcin.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(89660);
          return 0;
        }
        localcin.mVH = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(89660);
        return 0;
      }
      AppMethodBeat.o(89660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cin
 * JD-Core Version:    0.7.0.1
 */