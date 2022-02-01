package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqp
  extends erp
{
  public int Height;
  public String URL;
  public int Width;
  public String aaxa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.URL == null)
      {
        paramVarArgs = new b("Not all required fields were included: URL");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.aaxa == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserAgent");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.g(2, this.URL);
      }
      if (this.aaxa != null) {
        paramVarArgs.g(3, this.aaxa);
      }
      paramVarArgs.bS(4, this.Width);
      paramVarArgs.bS(5, this.Height);
      AppMethodBeat.o(82416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.URL);
      }
      i = paramInt;
      if (this.aaxa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaxa);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.Width);
      int j = i.a.a.b.b.a.cJ(5, this.Height);
      AppMethodBeat.o(82416);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.URL == null)
        {
          paramVarArgs = new b("Not all required fields were included: URL");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        if (this.aaxa == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserAgent");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cqp localcqp = (cqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82416);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localcqp.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82416);
          return 0;
        case 2: 
          localcqp.URL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 3: 
          localcqp.aaxa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 4: 
          localcqp.Width = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82416);
          return 0;
        }
        localcqp.Height = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82416);
        return 0;
      }
      AppMethodBeat.o(82416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqp
 * JD-Core Version:    0.7.0.1
 */