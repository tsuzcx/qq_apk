package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fch
  extends dpc
{
  public int MKJ;
  public int Nyf;
  public int Nyg;
  public String dPS;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123686);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123686);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.e(3, this.md5);
      }
      paramVarArgs.aM(4, this.version);
      paramVarArgs.aM(5, this.Nyf);
      paramVarArgs.aM(6, this.MKJ);
      paramVarArgs.aM(7, this.Nyg);
      if (this.dPS != null) {
        paramVarArgs.e(8, this.dPS);
      }
      AppMethodBeat.o(123686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.md5);
      }
      i = i + g.a.a.b.b.a.bu(4, this.version) + g.a.a.b.b.a.bu(5, this.Nyf) + g.a.a.b.b.a.bu(6, this.MKJ) + g.a.a.b.b.a.bu(7, this.Nyg);
      paramInt = i;
      if (this.dPS != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.dPS);
      }
      AppMethodBeat.o(123686);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123686);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fch localfch = (fch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfch.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localfch.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localfch.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localfch.version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localfch.Nyf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localfch.MKJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localfch.Nyg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123686);
          return 0;
        }
        localfch.dPS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fch
 * JD-Core Version:    0.7.0.1
 */