package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyp
  extends com.tencent.mm.bw.a
{
  public String KDM;
  public int MDA;
  public LinkedList<tz> MDB;
  public String MDC;
  public String MDD;
  public String MDx;
  public String MDy;
  public String MDz;
  
  public cyp()
  {
    AppMethodBeat.i(114047);
    this.MDB = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KDM != null) {
        paramVarArgs.e(1, this.KDM);
      }
      if (this.MDx != null) {
        paramVarArgs.e(2, this.MDx);
      }
      if (this.MDy != null) {
        paramVarArgs.e(3, this.MDy);
      }
      if (this.MDz != null) {
        paramVarArgs.e(4, this.MDz);
      }
      paramVarArgs.aM(5, this.MDA);
      paramVarArgs.e(6, 8, this.MDB);
      if (this.MDC != null) {
        paramVarArgs.e(7, this.MDC);
      }
      if (this.MDD != null) {
        paramVarArgs.e(8, this.MDD);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KDM == null) {
        break label706;
      }
    }
    label706:
    for (int i = g.a.a.b.b.a.f(1, this.KDM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MDx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MDx);
      }
      i = paramInt;
      if (this.MDy != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MDy);
      }
      paramInt = i;
      if (this.MDz != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MDz);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MDA) + g.a.a.a.c(6, 8, this.MDB);
      paramInt = i;
      if (this.MDC != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MDC);
      }
      i = paramInt;
      if (this.MDD != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MDD);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MDB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyp localcyp = (cyp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localcyp.KDM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localcyp.MDx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localcyp.MDy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localcyp.MDz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localcyp.MDA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyp.MDB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localcyp.MDC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localcyp.MDD = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyp
 * JD-Core Version:    0.7.0.1
 */