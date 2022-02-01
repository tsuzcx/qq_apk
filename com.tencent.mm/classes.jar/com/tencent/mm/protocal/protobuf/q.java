package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends dop
{
  public long KBK;
  public String KBL;
  public String KBs;
  public String KBt;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91326);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KBs != null) {
        paramVarArgs.e(2, this.KBs);
      }
      paramVarArgs.bb(3, this.KBK);
      paramVarArgs.aM(4, this.scene);
      if (this.KBt != null) {
        paramVarArgs.e(5, this.KBt);
      }
      if (this.KBL != null) {
        paramVarArgs.e(6, this.KBL);
      }
      AppMethodBeat.o(91326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KBs != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KBs);
      }
      i = i + g.a.a.b.b.a.r(3, this.KBK) + g.a.a.b.b.a.bu(4, this.scene);
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KBt);
      }
      i = paramInt;
      if (this.KBL != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KBL);
      }
      AppMethodBeat.o(91326);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91326);
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
            localq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91326);
          return 0;
        case 2: 
          localq.KBs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91326);
          return 0;
        case 3: 
          localq.KBK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91326);
          return 0;
        case 4: 
          localq.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91326);
          return 0;
        case 5: 
          localq.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91326);
          return 0;
        }
        localq.KBL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91326);
        return 0;
      }
      AppMethodBeat.o(91326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.q
 * JD-Core Version:    0.7.0.1
 */