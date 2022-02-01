package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eom
  extends com.tencent.mm.bw.a
{
  public int Mwa;
  public LinkedList<eon> Nmn;
  public String Nmo;
  public int Nmp;
  public int apptype;
  public String dNI;
  public String ixZ;
  public String pWf;
  
  public eom()
  {
    AppMethodBeat.i(74672);
    this.Nmn = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.ixZ != null) {
        paramVarArgs.e(2, this.ixZ);
      }
      paramVarArgs.aM(3, this.apptype);
      paramVarArgs.e(4, 8, this.Nmn);
      paramVarArgs.aM(5, this.Mwa);
      if (this.Nmo != null) {
        paramVarArgs.e(6, this.Nmo);
      }
      if (this.pWf != null) {
        paramVarArgs.e(7, this.pWf);
      }
      paramVarArgs.aM(8, this.Nmp);
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ixZ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.ixZ);
      }
      i = i + g.a.a.b.b.a.bu(3, this.apptype) + g.a.a.a.c(4, 8, this.Nmn) + g.a.a.b.b.a.bu(5, this.Mwa);
      paramInt = i;
      if (this.Nmo != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Nmo);
      }
      i = paramInt;
      if (this.pWf != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.pWf);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.Nmp);
      AppMethodBeat.o(74673);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nmn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eom localeom = (eom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localeom.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localeom.ixZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localeom.apptype = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eon();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eon)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeom.Nmn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localeom.Mwa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localeom.Nmo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localeom.pWf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localeom.Nmp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eom
 * JD-Core Version:    0.7.0.1
 */