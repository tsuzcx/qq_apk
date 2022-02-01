package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqv
  extends dop
{
  public int Brl;
  public long Brn;
  public int BsF;
  public int BsG;
  public int BsH;
  public dqi KHl;
  public dqi KHm;
  public int LYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Brl);
      if (this.KHl != null)
      {
        paramVarArgs.ni(3, this.KHl.computeSize());
        this.KHl.writeFields(paramVarArgs);
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(4, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.BsF);
      paramVarArgs.aM(6, this.BsG);
      paramVarArgs.aM(7, this.BsH);
      paramVarArgs.aM(8, this.LYt);
      paramVarArgs.bb(9, this.Brn);
      AppMethodBeat.o(152572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Brl);
      paramInt = i;
      if (this.KHl != null) {
        paramInt = i + g.a.a.a.nh(3, this.KHl.computeSize());
      }
      i = paramInt;
      if (this.KHm != null) {
        i = paramInt + g.a.a.a.nh(4, this.KHm.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(5, this.BsF);
      int j = g.a.a.b.b.a.bu(6, this.BsG);
      int k = g.a.a.b.b.a.bu(7, this.BsH);
      int m = g.a.a.b.b.a.bu(8, this.LYt);
      int n = g.a.a.b.b.a.r(9, this.Brn);
      AppMethodBeat.o(152572);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHl == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        if (this.KHm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqv localbqv = (bqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152572);
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
            localbqv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 2: 
          localbqv.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152572);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqv.KHl = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqv.KHm = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 5: 
          localbqv.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152572);
          return 0;
        case 6: 
          localbqv.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152572);
          return 0;
        case 7: 
          localbqv.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152572);
          return 0;
        case 8: 
          localbqv.LYt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152572);
          return 0;
        }
        localbqv.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(152572);
        return 0;
      }
      AppMethodBeat.o(152572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqv
 * JD-Core Version:    0.7.0.1
 */