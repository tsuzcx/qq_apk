package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hj
  extends com.tencent.mm.bw.a
{
  public String KKT;
  public eoq KKU;
  public String KKV;
  public drd KKW;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.KKT != null) {
        paramVarArgs.e(2, this.KKT);
      }
      paramVarArgs.aM(3, this.state);
      if (this.KKU != null)
      {
        paramVarArgs.ni(4, this.KKU.computeSize());
        this.KKU.writeFields(paramVarArgs);
      }
      if (this.KKV != null) {
        paramVarArgs.e(5, this.KKV);
      }
      if (this.KKW != null)
      {
        paramVarArgs.ni(6, this.KKW.computeSize());
        this.KKW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KKT != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KKT);
      }
      i += g.a.a.b.b.a.bu(3, this.state);
      paramInt = i;
      if (this.KKU != null) {
        paramInt = i + g.a.a.a.nh(4, this.KKU.computeSize());
      }
      i = paramInt;
      if (this.KKV != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KKV);
      }
      paramInt = i;
      if (this.KKW != null) {
        paramInt = i + g.a.a.a.nh(6, this.KKW.computeSize());
      }
      AppMethodBeat.o(147757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hj localhj = (hj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localhj.scope = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localhj.KKT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localhj.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eoq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eoq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhj.KKU = ((eoq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        case 5: 
          localhj.KKV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147757);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new drd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((drd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhj.KKW = ((drd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hj
 * JD-Core Version:    0.7.0.1
 */