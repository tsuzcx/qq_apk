package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csp
  extends com.tencent.mm.bw.a
{
  public LinkedList<FinderObject> LDi;
  public FinderObject MxE;
  public String MxF;
  public axw MxG;
  public long localId;
  public int scene;
  
  public csp()
  {
    AppMethodBeat.i(209771);
    this.LDi = new LinkedList();
    AppMethodBeat.o(209771);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209772);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MxE != null)
      {
        paramVarArgs.ni(1, this.MxE.computeSize());
        this.MxE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LDi);
      if (this.MxF != null) {
        paramVarArgs.e(3, this.MxF);
      }
      paramVarArgs.aM(4, this.scene);
      paramVarArgs.bb(5, this.localId);
      if (this.MxG != null)
      {
        paramVarArgs.ni(6, this.MxG.computeSize());
        this.MxG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MxE == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.nh(1, this.MxE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LDi);
      paramInt = i;
      if (this.MxF != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MxF);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.scene) + g.a.a.b.b.a.r(5, this.localId);
      paramInt = i;
      if (this.MxG != null) {
        paramInt = i + g.a.a.a.nh(6, this.MxG.computeSize());
      }
      AppMethodBeat.o(209772);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209772);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csp localcsp = (csp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209772);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsp.MxE = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209772);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsp.LDi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209772);
          return 0;
        case 3: 
          localcsp.MxF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209772);
          return 0;
        case 4: 
          localcsp.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209772);
          return 0;
        case 5: 
          localcsp.localId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209772);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((axw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsp.MxG = ((axw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209772);
        return 0;
      }
      AppMethodBeat.o(209772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csp
 * JD-Core Version:    0.7.0.1
 */