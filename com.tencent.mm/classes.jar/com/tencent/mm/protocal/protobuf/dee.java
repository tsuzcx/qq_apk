package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dee
  extends dpc
{
  public int KOt;
  public String KOu;
  public int LXb;
  public String Lca;
  public LinkedList<akg> MJk;
  public LinkedList<bd> MJl;
  public int MJm;
  
  public dee()
  {
    AppMethodBeat.i(91628);
    this.MJk = new LinkedList();
    this.MJl = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LXb);
      paramVarArgs.e(3, 8, this.MJk);
      if (this.Lca != null) {
        paramVarArgs.e(4, this.Lca);
      }
      paramVarArgs.aM(5, this.KOt);
      if (this.KOu != null) {
        paramVarArgs.e(6, this.KOu);
      }
      paramVarArgs.e(7, 8, this.MJl);
      paramVarArgs.aM(8, this.MJm);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LXb) + g.a.a.a.c(3, 8, this.MJk);
      paramInt = i;
      if (this.Lca != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lca);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KOt);
      paramInt = i;
      if (this.KOu != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KOu);
      }
      i = g.a.a.a.c(7, 8, this.MJl);
      int j = g.a.a.b.b.a.bu(8, this.MJm);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MJk.clear();
        this.MJl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dee localdee = (dee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
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
            localdee.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localdee.LXb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdee.MJk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localdee.Lca = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localdee.KOt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localdee.KOu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdee.MJl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localdee.MJm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dee
 * JD-Core Version:    0.7.0.1
 */