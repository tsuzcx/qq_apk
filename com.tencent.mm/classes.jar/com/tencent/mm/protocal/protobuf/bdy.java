package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdy
  extends dyl
{
  public aqe SDi;
  public LinkedList<cve> SPe;
  
  public bdy()
  {
    AppMethodBeat.i(184199);
    this.SPe = new LinkedList();
    AppMethodBeat.o(184199);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184200);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.SPe);
      AppMethodBeat.o(184200);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      paramInt = g.a.a.a.c(3, 8, this.SPe);
      AppMethodBeat.o(184200);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SPe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(184200);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdy localbdy = (bdy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(184200);
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
            localbdy.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(184200);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbdy.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(184200);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cve();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cve)localObject2).parseFrom((byte[])localObject1);
          }
          localbdy.SPe.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184200);
        return 0;
      }
      AppMethodBeat.o(184200);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdy
 * JD-Core Version:    0.7.0.1
 */