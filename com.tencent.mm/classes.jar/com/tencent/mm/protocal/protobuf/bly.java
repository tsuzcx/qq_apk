package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bly
  extends dpc
{
  public long LUH;
  public boolean LUI;
  public long LUJ;
  public LinkedList<ue> LUK;
  public adu LUM;
  public adu LUN;
  public String pUa;
  public String title;
  
  public bly()
  {
    AppMethodBeat.i(201335);
    this.LUK = new LinkedList();
    AppMethodBeat.o(201335);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201336);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(201336);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LUH);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.cc(4, this.LUI);
      paramVarArgs.bb(5, this.LUJ);
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      paramVarArgs.e(7, 8, this.LUK);
      if (this.LUM != null)
      {
        paramVarArgs.ni(8, this.LUM.computeSize());
        this.LUM.writeFields(paramVarArgs);
      }
      if (this.LUN != null)
      {
        paramVarArgs.ni(9, this.LUN.computeSize());
        this.LUN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1062;
      }
    }
    label1062:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LUH);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.b.b.a.r(5, this.LUJ);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.title);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.LUK);
      paramInt = i;
      if (this.LUM != null) {
        paramInt = i + g.a.a.a.nh(8, this.LUM.computeSize());
      }
      i = paramInt;
      if (this.LUN != null) {
        i = paramInt + g.a.a.a.nh(9, this.LUN.computeSize());
      }
      AppMethodBeat.o(201336);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LUK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(201336);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bly localbly = (bly)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201336);
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
            localbly.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201336);
          return 0;
        case 2: 
          localbly.LUH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201336);
          return 0;
        case 3: 
          localbly.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201336);
          return 0;
        case 4: 
          localbly.LUI = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(201336);
          return 0;
        case 5: 
          localbly.LUJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201336);
          return 0;
        case 6: 
          localbly.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201336);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbly.LUK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201336);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbly.LUM = ((adu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201336);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbly.LUN = ((adu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201336);
        return 0;
      }
      AppMethodBeat.o(201336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bly
 * JD-Core Version:    0.7.0.1
 */