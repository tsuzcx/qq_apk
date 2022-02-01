package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgp
  extends com.tencent.mm.bw.a
{
  public adw MLh;
  public coz MLj;
  public String dQx;
  public String pTL;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200223);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      paramVarArgs.aM(2, this.type);
      if (this.pTL != null) {
        paramVarArgs.e(3, this.pTL);
      }
      if (this.MLj != null)
      {
        paramVarArgs.ni(4, this.MLj.computeSize());
        this.MLj.writeFields(paramVarArgs);
      }
      if (this.MLh != null)
      {
        paramVarArgs.ni(5, this.MLh.computeSize());
        this.MLh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200223);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.b.b.a.f(1, this.dQx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.pTL != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pTL);
      }
      i = paramInt;
      if (this.MLj != null) {
        i = paramInt + g.a.a.a.nh(4, this.MLj.computeSize());
      }
      paramInt = i;
      if (this.MLh != null) {
        paramInt = i + g.a.a.a.nh(5, this.MLh.computeSize());
      }
      AppMethodBeat.o(200223);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200223);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgp localdgp = (dgp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200223);
          return -1;
        case 1: 
          localdgp.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200223);
          return 0;
        case 2: 
          localdgp.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200223);
          return 0;
        case 3: 
          localdgp.pTL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200223);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgp.MLj = ((coz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200223);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgp.MLh = ((adw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200223);
        return 0;
      }
      AppMethodBeat.o(200223);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgp
 * JD-Core Version:    0.7.0.1
 */