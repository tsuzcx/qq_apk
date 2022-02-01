package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejn
  extends esc
{
  public String abof;
  public LinkedList<edu> abog;
  public String wuA;
  public int wuz;
  
  public ejn()
  {
    AppMethodBeat.i(91639);
    this.abog = new LinkedList();
    AppMethodBeat.o(91639);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91640);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91640);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.abof != null) {
        paramVarArgs.g(4, this.abof);
      }
      paramVarArgs.e(5, 8, this.abog);
      AppMethodBeat.o(91640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abof != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abof);
      }
      paramInt = i.a.a.a.c(5, 8, this.abog);
      AppMethodBeat.o(91640);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abog.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91640);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91640);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejn localejn = (ejn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91640);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localejn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91640);
          return 0;
        case 2: 
          localejn.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91640);
          return 0;
        case 3: 
          localejn.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91640);
          return 0;
        case 4: 
          localejn.abof = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91640);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new edu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((edu)localObject2).parseFrom((byte[])localObject1);
          }
          localejn.abog.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91640);
        return 0;
      }
      AppMethodBeat.o(91640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejn
 * JD-Core Version:    0.7.0.1
 */