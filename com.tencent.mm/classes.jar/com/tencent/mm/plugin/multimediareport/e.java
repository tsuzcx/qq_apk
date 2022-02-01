package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class e
  extends dop
{
  public int scene;
  public long timestamp;
  public LinkedList<a> zGV;
  public long zGW;
  public d zGX;
  
  public e()
  {
    AppMethodBeat.i(194276);
    this.zGV = new LinkedList();
    AppMethodBeat.o(194276);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194277);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.zGW);
      paramVarArgs.bb(3, this.timestamp);
      paramVarArgs.aM(4, this.scene);
      if (this.zGX != null)
      {
        paramVarArgs.ni(5, this.zGX.computeSize());
        this.zGX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.zGV);
      AppMethodBeat.o(194277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.zGW) + g.a.a.b.b.a.r(3, this.timestamp) + g.a.a.b.b.a.bu(4, this.scene);
      paramInt = i;
      if (this.zGX != null) {
        paramInt = i + g.a.a.a.nh(5, this.zGX.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.zGV);
      AppMethodBeat.o(194277);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.zGV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194277);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194277);
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
            locale.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194277);
          return 0;
        case 2: 
          locale.zGW = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(194277);
          return 0;
        case 3: 
          locale.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(194277);
          return 0;
        case 4: 
          locale.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(194277);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locale.zGX = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194277);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.zGV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194277);
        return 0;
      }
      AppMethodBeat.o(194277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.e
 * JD-Core Version:    0.7.0.1
 */