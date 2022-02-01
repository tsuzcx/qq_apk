package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bna
  extends dop
{
  public int LVB;
  public ahd LVC;
  public LinkedList<akh> LVD;
  public int LVE;
  public String LVF;
  public int Scene;
  
  public bna()
  {
    AppMethodBeat.i(220702);
    this.LVD = new LinkedList();
    AppMethodBeat.o(220702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(220703);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LVB);
      paramVarArgs.aM(3, this.Scene);
      if (this.LVC != null)
      {
        paramVarArgs.ni(4, this.LVC.computeSize());
        this.LVC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.LVD);
      paramVarArgs.aM(6, this.LVE);
      if (this.LVF != null) {
        paramVarArgs.e(7, this.LVF);
      }
      AppMethodBeat.o(220703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LVB) + g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.LVC != null) {
        paramInt = i + g.a.a.a.nh(4, this.LVC.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.LVD) + g.a.a.b.b.a.bu(6, this.LVE);
      paramInt = i;
      if (this.LVF != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LVF);
      }
      AppMethodBeat.o(220703);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LVD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LVC == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(220703);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bna localbna = (bna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220703);
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
            localbna.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220703);
          return 0;
        case 2: 
          localbna.LVB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220703);
          return 0;
        case 3: 
          localbna.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220703);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbna.LVC = ((ahd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220703);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbna.LVD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220703);
          return 0;
        case 6: 
          localbna.LVE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220703);
          return 0;
        }
        localbna.LVF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(220703);
        return 0;
      }
      AppMethodBeat.o(220703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bna
 * JD-Core Version:    0.7.0.1
 */