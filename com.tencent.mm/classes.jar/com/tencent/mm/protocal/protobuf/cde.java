package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cde
  extends dpc
{
  public String KTt;
  public dis KTz;
  public String Lph;
  public String Lpi;
  public int Lpj;
  public bfs Lpk;
  public oa Lpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124518);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.KTz == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KTz != null)
      {
        paramVarArgs.ni(2, this.KTz.computeSize());
        this.KTz.writeFields(paramVarArgs);
      }
      if (this.KTt != null) {
        paramVarArgs.e(3, this.KTt);
      }
      paramVarArgs.aM(4, this.Lpj);
      if (this.Lpk != null)
      {
        paramVarArgs.ni(5, this.Lpk.computeSize());
        this.Lpk.writeFields(paramVarArgs);
      }
      if (this.Lpl != null)
      {
        paramVarArgs.ni(6, this.Lpl.computeSize());
        this.Lpl.writeFields(paramVarArgs);
      }
      if (this.Lph != null) {
        paramVarArgs.e(7, this.Lph);
      }
      if (this.Lpi != null) {
        paramVarArgs.e(8, this.Lpi);
      }
      AppMethodBeat.o(124518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1098;
      }
    }
    label1098:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KTz != null) {
        paramInt = i + g.a.a.a.nh(2, this.KTz.computeSize());
      }
      i = paramInt;
      if (this.KTt != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KTt);
      }
      i += g.a.a.b.b.a.bu(4, this.Lpj);
      paramInt = i;
      if (this.Lpk != null) {
        paramInt = i + g.a.a.a.nh(5, this.Lpk.computeSize());
      }
      i = paramInt;
      if (this.Lpl != null) {
        i = paramInt + g.a.a.a.nh(6, this.Lpl.computeSize());
      }
      paramInt = i;
      if (this.Lph != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lph);
      }
      i = paramInt;
      if (this.Lpi != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Lpi);
      }
      AppMethodBeat.o(124518);
      return i;
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
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        if (this.KTz == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cde localcde = (cde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124518);
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
            localcde.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dis();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dis)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcde.KTz = ((dis)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 3: 
          localcde.KTt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124518);
          return 0;
        case 4: 
          localcde.Lpj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124518);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcde.Lpk = ((bfs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcde.Lpl = ((oa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 7: 
          localcde.Lph = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124518);
          return 0;
        }
        localcde.Lpi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124518);
        return 0;
      }
      AppMethodBeat.o(124518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cde
 * JD-Core Version:    0.7.0.1
 */