package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bpd
  extends dop
{
  public int KMz;
  public String LPT;
  public SKBuiltinBuffer_t LXm;
  public int LXn;
  public int LXo;
  public LinkedList<dbm> LXp;
  public int LXq;
  public chk LpL;
  public int Scene;
  
  public bpd()
  {
    AppMethodBeat.i(32249);
    this.LXp = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LpL == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KMz);
      paramVarArgs.aM(3, this.Scene);
      if (this.LXm != null)
      {
        paramVarArgs.ni(4, this.LXm.computeSize());
        this.LXm.writeFields(paramVarArgs);
      }
      if (this.LpL != null)
      {
        paramVarArgs.ni(5, this.LpL.computeSize());
        this.LpL.writeFields(paramVarArgs);
      }
      if (this.LPT != null) {
        paramVarArgs.e(6, this.LPT);
      }
      paramVarArgs.aM(7, this.LXn);
      paramVarArgs.aM(8, this.LXo);
      paramVarArgs.e(11, 8, this.LXp);
      paramVarArgs.aM(12, this.LXq);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.LXm != null) {
        paramInt = i + g.a.a.a.nh(4, this.LXm.computeSize());
      }
      i = paramInt;
      if (this.LpL != null) {
        i = paramInt + g.a.a.a.nh(5, this.LpL.computeSize());
      }
      paramInt = i;
      if (this.LPT != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LPT);
      }
      i = g.a.a.b.b.a.bu(7, this.LXn);
      int j = g.a.a.b.b.a.bu(8, this.LXo);
      int k = g.a.a.a.c(11, 8, this.LXp);
      int m = g.a.a.b.b.a.bu(12, this.LXq);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LXp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LpL == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bpd localbpd = (bpd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
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
            localbpd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localbpd.KMz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localbpd.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32250);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpd.LXm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpd.LpL = ((chk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localbpd.LPT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localbpd.LXn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localbpd.LXo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpd.LXp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localbpd.LXq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpd
 * JD-Core Version:    0.7.0.1
 */