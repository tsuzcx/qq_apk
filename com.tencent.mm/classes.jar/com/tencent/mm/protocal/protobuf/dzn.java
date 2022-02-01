package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dzn
  extends dpc
{
  public String KHk;
  public LinkedList<SnsObject> KOH;
  public String MZg;
  public int MZk;
  public eat MZl;
  public int MvM;
  public int xuw;
  
  public dzn()
  {
    AppMethodBeat.i(125776);
    this.KOH = new LinkedList();
    AppMethodBeat.o(125776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.MZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MZg != null) {
        paramVarArgs.e(2, this.MZg);
      }
      paramVarArgs.aM(3, this.MvM);
      paramVarArgs.e(4, 8, this.KOH);
      paramVarArgs.aM(5, this.MZk);
      if (this.KHk != null) {
        paramVarArgs.e(6, this.KHk);
      }
      paramVarArgs.aM(7, this.xuw);
      if (this.MZl != null)
      {
        paramVarArgs.ni(8, this.MZl.computeSize());
        this.MZl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MZg);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MvM) + g.a.a.a.c(4, 8, this.KOH) + g.a.a.b.b.a.bu(5, this.MZk);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHk);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.xuw);
      paramInt = i;
      if (this.MZl != null) {
        paramInt = i + g.a.a.a.nh(8, this.MZl.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KOH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.MZl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ServerConfig");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzn localdzn = (dzn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
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
            localdzn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localdzn.MZg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localdzn.MvM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzn.KOH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localdzn.MZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localdzn.KHk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localdzn.xuw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eat();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdzn.MZl = ((eat)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      AppMethodBeat.o(125777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzn
 * JD-Core Version:    0.7.0.1
 */