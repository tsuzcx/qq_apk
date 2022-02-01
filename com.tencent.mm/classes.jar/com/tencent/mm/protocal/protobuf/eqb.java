package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqb
  extends com.tencent.mm.cd.a
{
  public String RXL;
  public LinkedList<eqc> RXM;
  public long RXN;
  public String SwE;
  public String SwF;
  public eqd Usy;
  public eqf Usz;
  
  public eqb()
  {
    AppMethodBeat.i(124556);
    this.RXM = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SwE != null) {
        paramVarArgs.f(1, this.SwE);
      }
      if (this.Usy != null)
      {
        paramVarArgs.oE(2, this.Usy.computeSize());
        this.Usy.writeFields(paramVarArgs);
      }
      if (this.RXL != null) {
        paramVarArgs.f(3, this.RXL);
      }
      paramVarArgs.e(4, 8, this.RXM);
      if (this.SwF != null) {
        paramVarArgs.f(5, this.SwF);
      }
      paramVarArgs.bm(6, this.RXN);
      if (this.Usz != null)
      {
        paramVarArgs.oE(7, this.Usz.computeSize());
        this.Usz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SwE == null) {
        break label768;
      }
    }
    label768:
    for (int i = g.a.a.b.b.a.g(1, this.SwE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Usy != null) {
        paramInt = i + g.a.a.a.oD(2, this.Usy.computeSize());
      }
      i = paramInt;
      if (this.RXL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RXL);
      }
      i += g.a.a.a.c(4, 8, this.RXM);
      paramInt = i;
      if (this.SwF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SwF);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.RXN);
      paramInt = i;
      if (this.Usz != null) {
        paramInt = i + g.a.a.a.oD(7, this.Usz.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RXM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqb localeqb = (eqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localeqb.SwE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqd)localObject2).parseFrom((byte[])localObject1);
            }
            localeqb.Usy = ((eqd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localeqb.RXL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqc)localObject2).parseFrom((byte[])localObject1);
            }
            localeqb.RXM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localeqb.SwF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localeqb.RXN = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eqf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eqf)localObject2).parseFrom((byte[])localObject1);
          }
          localeqb.Usz = ((eqf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqb
 * JD-Core Version:    0.7.0.1
 */