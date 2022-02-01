package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cim
  extends dpc
{
  public String Bri;
  public LinkedList<cik> MnA;
  public int Mnv;
  public int Mnx;
  public LinkedList<cik> Mnz;
  
  public cim()
  {
    AppMethodBeat.i(155436);
    this.Mnz = new LinkedList();
    this.MnA = new LinkedList();
    AppMethodBeat.o(155436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Bri != null) {
        paramVarArgs.e(2, this.Bri);
      }
      paramVarArgs.aM(3, this.Mnv);
      paramVarArgs.e(4, 8, this.Mnz);
      paramVarArgs.aM(5, this.Mnx);
      paramVarArgs.e(6, 8, this.MnA);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Bri != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Bri);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Mnv);
      int j = g.a.a.a.c(4, 8, this.Mnz);
      int k = g.a.a.b.b.a.bu(5, this.Mnx);
      int m = g.a.a.a.c(6, 8, this.MnA);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mnz.clear();
        this.MnA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cim localcim = (cim)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcim.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localcim.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localcim.Mnv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cik();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cik)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcim.Mnz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localcim.Mnx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cik();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cik)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcim.MnA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      AppMethodBeat.o(155437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cim
 * JD-Core Version:    0.7.0.1
 */