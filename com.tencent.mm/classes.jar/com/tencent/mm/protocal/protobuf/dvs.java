package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvs
  extends dyl
{
  public String SvI;
  public ezh UbH;
  public eti UbI;
  public int jUj;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UbH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SvI != null) {
        paramVarArgs.f(2, this.SvI);
      }
      paramVarArgs.aY(3, this.rWu);
      if (this.UbH != null)
      {
        paramVarArgs.oE(4, this.UbH.computeSize());
        this.UbH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.jUj);
      if (this.UbI != null)
      {
        paramVarArgs.oE(6, this.UbI.computeSize());
        this.UbI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label752;
      }
    }
    label752:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SvI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SvI);
      }
      i += g.a.a.b.b.a.bM(3, this.rWu);
      paramInt = i;
      if (this.UbH != null) {
        paramInt = i + g.a.a.a.oD(4, this.UbH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.jUj);
      paramInt = i;
      if (this.UbI != null) {
        paramInt = i + g.a.a.a.oD(6, this.UbI.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UbH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(56259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvs localdvs = (dvs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
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
            localdvs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localdvs.SvI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localdvs.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezh)localObject2).parseFrom((byte[])localObject1);
            }
            localdvs.UbH = ((ezh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localdvs.jUj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eti();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eti)localObject2).parseFrom((byte[])localObject1);
          }
          localdvs.UbI = ((eti)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      AppMethodBeat.o(56259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvs
 * JD-Core Version:    0.7.0.1
 */