package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ii
  extends com.tencent.mm.bw.a
{
  public int KMw;
  public ddx KMx;
  public String dNI;
  public String token;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153260);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aM(2, this.KMw);
      if (this.KMx != null)
      {
        paramVarArgs.ni(3, this.KMx.computeSize());
        this.KMx.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.e(4, this.token);
      }
      if (this.dNI != null) {
        paramVarArgs.e(5, this.dNI);
      }
      AppMethodBeat.o(153260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KMw);
      paramInt = i;
      if (this.KMx != null) {
        paramInt = i + g.a.a.a.nh(3, this.KMx.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.token);
      }
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dNI);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ii localii = (ii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153260);
          return -1;
        case 1: 
          localii.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localii.KMw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ddx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localii.KMx = ((ddx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localii.token = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localii.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153260);
        return 0;
      }
      AppMethodBeat.o(153260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ii
 * JD-Core Version:    0.7.0.1
 */