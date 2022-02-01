package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xe
  extends dyl
{
  public String Inf;
  public String Sji;
  public String llO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223053);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.llO != null) {
        paramVarArgs.f(2, this.llO);
      }
      if (this.Sji != null) {
        paramVarArgs.f(3, this.Sji);
      }
      if (this.Inf != null) {
        paramVarArgs.f(4, this.Inf);
      }
      AppMethodBeat.o(223053);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.llO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.llO);
      }
      i = paramInt;
      if (this.Sji != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sji);
      }
      paramInt = i;
      if (this.Inf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Inf);
      }
      AppMethodBeat.o(223053);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(223053);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        xe localxe = (xe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(223053);
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
            localxe.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(223053);
          return 0;
        case 2: 
          localxe.llO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(223053);
          return 0;
        case 3: 
          localxe.Sji = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(223053);
          return 0;
        }
        localxe.Inf = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(223053);
        return 0;
      }
      AppMethodBeat.o(223053);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xe
 * JD-Core Version:    0.7.0.1
 */