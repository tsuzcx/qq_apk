package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dze
  extends dyl
{
  public String UeM;
  public String UeN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138186);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UeM != null) {
        paramVarArgs.f(2, this.UeM);
      }
      if (this.UeN != null) {
        paramVarArgs.f(3, this.UeN);
      }
      AppMethodBeat.o(138186);
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
      if (this.UeM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UeM);
      }
      i = paramInt;
      if (this.UeN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UeN);
      }
      AppMethodBeat.o(138186);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(138186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dze localdze = (dze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(138186);
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
            localdze.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(138186);
          return 0;
        case 2: 
          localdze.UeM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(138186);
          return 0;
        }
        localdze.UeN = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(138186);
        return 0;
      }
      AppMethodBeat.o(138186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dze
 * JD-Core Version:    0.7.0.1
 */