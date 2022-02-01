package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btp
  extends dyy
{
  public eae TdH;
  public LinkedList<aji> TdL;
  public LinkedList<ajl> TdM;
  
  public btp()
  {
    AppMethodBeat.i(104785);
    this.TdL = new LinkedList();
    this.TdM = new LinkedList();
    AppMethodBeat.o(104785);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104786);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104786);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TdL);
      if (this.TdH != null)
      {
        paramVarArgs.oE(3, this.TdH.computeSize());
        this.TdH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.TdM);
      AppMethodBeat.o(104786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.TdL);
      paramInt = i;
      if (this.TdH != null) {
        paramInt = i + g.a.a.a.oD(3, this.TdH.computeSize());
      }
      i = g.a.a.a.c(4, 8, this.TdM);
      AppMethodBeat.o(104786);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TdL.clear();
        this.TdM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104786);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104786);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btp localbtp = (btp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104786);
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
            localbtp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104786);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aji)localObject2).parseFrom((byte[])localObject1);
            }
            localbtp.TdL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104786);
          return 0;
        case 3: 
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
            localbtp.TdH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104786);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajl)localObject2).parseFrom((byte[])localObject1);
          }
          localbtp.TdM.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104786);
        return 0;
      }
      AppMethodBeat.o(104786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btp
 * JD-Core Version:    0.7.0.1
 */