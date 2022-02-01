package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class hn
  extends com.tencent.mm.bx.a
{
  public String ProductID;
  public ciy YIT;
  public String YIU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104745);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.YIT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Price");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.g(1, this.ProductID);
      }
      if (this.YIT != null)
      {
        paramVarArgs.qD(2, this.YIT.computeSize());
        this.YIT.writeFields(paramVarArgs);
      }
      if (this.YIU != null) {
        paramVarArgs.g(3, this.YIU);
      }
      AppMethodBeat.o(104745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label500;
      }
    }
    label500:
    for (int i = i.a.a.b.b.a.h(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIT != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIT.computeSize());
      }
      i = paramInt;
      if (this.YIU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIU);
      }
      AppMethodBeat.o(104745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        if (this.YIT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Price");
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104745);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hn localhn = (hn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104745);
          return -1;
        case 1: 
          localhn.ProductID = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104745);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ciy localciy = new ciy();
            if ((localObject != null) && (localObject.length > 0)) {
              localciy.parseFrom((byte[])localObject);
            }
            localhn.YIT = localciy;
            paramInt += 1;
          }
          AppMethodBeat.o(104745);
          return 0;
        }
        localhn.YIU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104745);
        return 0;
      }
      AppMethodBeat.o(104745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hn
 * JD-Core Version:    0.7.0.1
 */