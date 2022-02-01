package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class u
  extends dyl
{
  public String MEN;
  public b MFp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MEN != null) {
        paramVarArgs.f(2, this.MEN);
      }
      if (this.MFp != null) {
        paramVarArgs.c(3, this.MFp);
      }
      AppMethodBeat.o(243789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label408;
      }
    }
    label408:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MEN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MEN);
      }
      i = paramInt;
      if (this.MFp != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.MFp);
      }
      AppMethodBeat.o(243789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243789);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243789);
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
            localu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(243789);
          return 0;
        case 2: 
          localu.MEN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243789);
          return 0;
        }
        localu.MFp = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(243789);
        return 0;
      }
      AppMethodBeat.o(243789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.u
 * JD-Core Version:    0.7.0.1
 */