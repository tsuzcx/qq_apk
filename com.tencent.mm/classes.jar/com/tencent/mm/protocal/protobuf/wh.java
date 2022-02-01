package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wh
  extends dop
{
  public String KHM;
  public String KHN;
  public String Lhy;
  public String Lhz;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHM == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.KHN == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.Lhz == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KHM != null) {
        paramVarArgs.e(2, this.KHM);
      }
      if (this.KHN != null) {
        paramVarArgs.e(3, this.KHN);
      }
      if (this.Lhy != null) {
        paramVarArgs.e(4, this.Lhy);
      }
      if (this.Lhz != null) {
        paramVarArgs.e(5, this.Lhz);
      }
      paramVarArgs.aM(6, this.yRL);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KHM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KHM);
      }
      i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHN);
      }
      paramInt = i;
      if (this.Lhy != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lhy);
      }
      i = paramInt;
      if (this.Lhz != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lhz);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.yRL);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHM == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.KHN == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.Lhz == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wh localwh = (wh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localwh.KHM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localwh.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localwh.Lhy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localwh.Lhz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localwh.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wh
 * JD-Core Version:    0.7.0.1
 */