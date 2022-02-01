package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dnj
  extends esc
{
  public dne ZXx;
  public FinderContact contact;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258523);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258523);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZXx != null)
      {
        paramVarArgs.qD(2, this.ZXx.computeSize());
        this.ZXx.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(3, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZXx != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZXx.computeSize());
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + i.a.a.a.qC(3, this.contact.computeSize());
      }
      AppMethodBeat.o(258523);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258523);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dnj localdnj = (dnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258523);
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
            localdnj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258523);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dne();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dne)localObject2).parseFrom((byte[])localObject1);
            }
            localdnj.ZXx = ((dne)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258523);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderContact();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderContact)localObject2).parseFrom((byte[])localObject1);
          }
          localdnj.contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258523);
        return 0;
      }
      AppMethodBeat.o(258523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnj
 * JD-Core Version:    0.7.0.1
 */