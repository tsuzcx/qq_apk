package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ecu
  extends dyl
{
  public ciu RQB;
  public String Uhl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQB == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32423);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RQB != null)
      {
        paramVarArgs.oE(2, this.RQB.computeSize());
        this.RQB.writeFields(paramVarArgs);
      }
      if (this.Uhl != null) {
        paramVarArgs.f(3, this.Uhl);
      }
      AppMethodBeat.o(32423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label539;
      }
    }
    label539:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RQB != null) {
        paramInt = i + g.a.a.a.oD(2, this.RQB.computeSize());
      }
      i = paramInt;
      if (this.Uhl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uhl);
      }
      AppMethodBeat.o(32423);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQB == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32423);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecu localecu = (ecu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32423);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localecu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32423);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ciu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ciu)localObject2).parseFrom((byte[])localObject1);
            }
            localecu.RQB = ((ciu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32423);
          return 0;
        }
        localecu.Uhl = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32423);
        return 0;
      }
      AppMethodBeat.o(32423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecu
 * JD-Core Version:    0.7.0.1
 */