package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqe
  extends dop
{
  public b LCh;
  public app LCi;
  public int LCj;
  public int LCk;
  public app LCl;
  public int LCm;
  public String iAR;
  public String nickname;
  public String signature;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.LCh != null) {
        paramVarArgs.c(3, this.LCh);
      }
      if (this.iAR != null) {
        paramVarArgs.e(4, this.iAR);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(5, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.e(6, this.signature);
      }
      if (this.LCi != null)
      {
        paramVarArgs.ni(7, this.LCi.computeSize());
        this.LCi.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.LCj);
      paramVarArgs.aM(9, this.LCk);
      if (this.LCl != null)
      {
        paramVarArgs.ni(10, this.LCl.computeSize());
        this.LCl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.LCm);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1154;
      }
    }
    label1154:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.LCh != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LCh);
      }
      paramInt = i;
      if (this.iAR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iAR);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(5, this.uli.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.signature);
      }
      i = paramInt;
      if (this.LCi != null) {
        i = paramInt + g.a.a.a.nh(7, this.LCi.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(8, this.LCj) + g.a.a.b.b.a.bu(9, this.LCk);
      paramInt = i;
      if (this.LCl != null) {
        paramInt = i + g.a.a.a.nh(10, this.LCl.computeSize());
      }
      i = g.a.a.b.b.a.bu(11, this.LCm);
      AppMethodBeat.o(168948);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqe localaqe = (aqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqe.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localaqe.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localaqe.LCh = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localaqe.iAR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqe.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localaqe.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new app();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((app)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqe.LCi = ((app)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localaqe.LCj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168948);
          return 0;
        case 9: 
          localaqe.LCk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168948);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new app();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((app)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqe.LCl = ((app)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        }
        localaqe.LCm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqe
 * JD-Core Version:    0.7.0.1
 */