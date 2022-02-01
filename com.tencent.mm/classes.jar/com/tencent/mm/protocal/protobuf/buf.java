package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class buf
  extends dyy
{
  public eae RJB;
  public int Teg;
  public LinkedList<akc> Teh;
  
  public buf()
  {
    AppMethodBeat.i(104797);
    this.Teh = new LinkedList();
    AppMethodBeat.o(104797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104798);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Teg);
      paramVarArgs.e(3, 8, this.Teh);
      if (this.RJB != null)
      {
        paramVarArgs.oE(4, this.RJB.computeSize());
        this.RJB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Teg) + g.a.a.a.c(3, 8, this.Teh);
      paramInt = i;
      if (this.RJB != null) {
        paramInt = i + g.a.a.a.oD(4, this.RJB.computeSize());
      }
      AppMethodBeat.o(104798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Teh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buf localbuf = (buf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104798);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbuf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104798);
          return 0;
        case 2: 
          localbuf.Teg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104798);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akc)localObject2).parseFrom((byte[])localObject1);
            }
            localbuf.Teh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104798);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localbuf.RJB = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104798);
        return 0;
      }
      AppMethodBeat.o(104798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buf
 * JD-Core Version:    0.7.0.1
 */