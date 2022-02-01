package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwu
  extends dyl
{
  public cwc TEM;
  public cvz TFa;
  public String clientId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197526);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.clientId != null) {
        paramVarArgs.f(3, this.clientId);
      }
      if (this.TEM != null)
      {
        paramVarArgs.oE(4, this.TEM.computeSize());
        this.TEM.writeFields(paramVarArgs);
      }
      if (this.TFa != null)
      {
        paramVarArgs.oE(5, this.TFa.computeSize());
        this.TFa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label672;
      }
    }
    label672:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.clientId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.clientId);
      }
      paramInt = i;
      if (this.TEM != null) {
        paramInt = i + g.a.a.a.oD(4, this.TEM.computeSize());
      }
      i = paramInt;
      if (this.TFa != null) {
        i = paramInt + g.a.a.a.oD(5, this.TFa.computeSize());
      }
      AppMethodBeat.o(197526);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197526);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwu localcwu = (cwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197526);
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
            localcwu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197526);
          return 0;
        case 2: 
          localcwu.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(197526);
          return 0;
        case 3: 
          localcwu.clientId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(197526);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwc)localObject2).parseFrom((byte[])localObject1);
            }
            localcwu.TEM = ((cwc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197526);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cvz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cvz)localObject2).parseFrom((byte[])localObject1);
          }
          localcwu.TFa = ((cvz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197526);
        return 0;
      }
      AppMethodBeat.o(197526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwu
 * JD-Core Version:    0.7.0.1
 */