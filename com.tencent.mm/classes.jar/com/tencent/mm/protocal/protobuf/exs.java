package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exs
  extends dop
{
  public int IEj;
  public double NuX;
  public double NuY;
  public String NuZ;
  public LinkedList<epb> Nva;
  public int scene;
  public String sessionId;
  
  public exs()
  {
    AppMethodBeat.i(121112);
    this.Nva = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.NuX);
      paramVarArgs.e(3, this.NuY);
      if (this.NuZ != null) {
        paramVarArgs.e(4, this.NuZ);
      }
      paramVarArgs.aM(5, this.IEj);
      if (this.sessionId != null) {
        paramVarArgs.e(6, this.sessionId);
      }
      paramVarArgs.aM(7, this.scene);
      paramVarArgs.e(8, 8, this.Nva);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 8) + (g.a.a.b.b.a.fS(3) + 8);
      paramInt = i;
      if (this.NuZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NuZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.IEj);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.sessionId);
      }
      i = g.a.a.b.b.a.bu(7, this.scene);
      int j = g.a.a.a.c(8, 8, this.Nva);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nva.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exs localexs = (exs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
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
            localexs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localexs.NuX = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localexs.NuY = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localexs.NuZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localexs.IEj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localexs.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localexs.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new epb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((epb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localexs.Nva.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exs
 * JD-Core Version:    0.7.0.1
 */