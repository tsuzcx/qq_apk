package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ewj
  extends dyl
{
  public String CMP;
  public String RMK;
  public String Sll;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Sll != null) {
        paramVarArgs.f(2, this.Sll);
      }
      if (this.CMP != null) {
        paramVarArgs.f(3, this.CMP);
      }
      if (this.RMK != null) {
        paramVarArgs.f(4, this.RMK);
      }
      AppMethodBeat.o(155472);
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
      if (this.Sll != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sll);
      }
      i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMP);
      }
      paramInt = i;
      if (this.RMK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RMK);
      }
      AppMethodBeat.o(155472);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ewj localewj = (ewj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155472);
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
            localewj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(155472);
          return 0;
        case 2: 
          localewj.Sll = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155472);
          return 0;
        case 3: 
          localewj.CMP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155472);
          return 0;
        }
        localewj.RMK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155472);
        return 0;
      }
      AppMethodBeat.o(155472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewj
 * JD-Core Version:    0.7.0.1
 */