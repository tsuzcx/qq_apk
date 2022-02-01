package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class boi
  extends dop
{
  public int LWx;
  public LinkedList<ade> LWy;
  public String sJI;
  public String sJJ;
  public int scene;
  public String version;
  
  public boi()
  {
    AppMethodBeat.i(220706);
    this.LWy = new LinkedList();
    AppMethodBeat.o(220706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sJI == null)
      {
        paramVarArgs = new b("Not all required fields were included: rversion");
        AppMethodBeat.o(220707);
        throw paramVarArgs;
      }
      if (this.sJJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: buildTag");
        AppMethodBeat.o(220707);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LWx);
      paramVarArgs.aM(3, this.scene);
      if (this.version != null) {
        paramVarArgs.e(4, this.version);
      }
      if (this.sJI != null) {
        paramVarArgs.e(5, this.sJI);
      }
      if (this.sJJ != null) {
        paramVarArgs.e(6, this.sJJ);
      }
      paramVarArgs.e(7, 8, this.LWy);
      AppMethodBeat.o(220707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LWx) + g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.version);
      }
      i = paramInt;
      if (this.sJI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.sJI);
      }
      paramInt = i;
      if (this.sJJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.sJJ);
      }
      i = g.a.a.a.c(7, 8, this.LWy);
      AppMethodBeat.o(220707);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LWy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.sJI == null)
        {
          paramVarArgs = new b("Not all required fields were included: rversion");
          AppMethodBeat.o(220707);
          throw paramVarArgs;
        }
        if (this.sJJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: buildTag");
          AppMethodBeat.o(220707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        boi localboi = (boi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220707);
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
            localboi.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220707);
          return 0;
        case 2: 
          localboi.LWx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220707);
          return 0;
        case 3: 
          localboi.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220707);
          return 0;
        case 4: 
          localboi.version = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220707);
          return 0;
        case 5: 
          localboi.sJI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220707);
          return 0;
        case 6: 
          localboi.sJJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220707);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ade();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ade)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localboi.LWy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(220707);
        return 0;
      }
      AppMethodBeat.o(220707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boi
 * JD-Core Version:    0.7.0.1
 */