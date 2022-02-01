package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class drn
  extends com.tencent.mm.bw.a
{
  public String KQY;
  public String MUb;
  public String MUc;
  public b MUd;
  public b MUe;
  public b MUf;
  public int MmK;
  public String Username;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public String keh;
  public int kem;
  public String oUJ;
  public String xJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.MUb != null) {
        paramVarArgs.e(3, this.MUb);
      }
      if (this.MUc != null) {
        paramVarArgs.e(4, this.MUc);
      }
      if (this.keh != null) {
        paramVarArgs.e(5, this.keh);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(6, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(7, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(8, this.keb);
      }
      paramVarArgs.aM(9, this.kdY);
      paramVarArgs.aM(10, this.MmK);
      if (this.MUd != null) {
        paramVarArgs.c(11, this.MUd);
      }
      if (this.KQY != null) {
        paramVarArgs.e(12, this.KQY);
      }
      if (this.MUe != null) {
        paramVarArgs.c(13, this.MUe);
      }
      if (this.MUf != null) {
        paramVarArgs.c(14, this.MUf);
      }
      paramVarArgs.aM(15, this.kem);
      if (this.xJE != null) {
        paramVarArgs.e(16, this.xJE);
      }
      AppMethodBeat.o(187877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1086;
      }
    }
    label1086:
    for (int i = g.a.a.b.b.a.f(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.MUb != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MUb);
      }
      paramInt = i;
      if (this.MUc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MUc);
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.keh);
      }
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.kdY) + g.a.a.b.b.a.bu(10, this.MmK);
      paramInt = i;
      if (this.MUd != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.MUd);
      }
      i = paramInt;
      if (this.KQY != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KQY);
      }
      paramInt = i;
      if (this.MUe != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.MUe);
      }
      i = paramInt;
      if (this.MUf != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.MUf);
      }
      i += g.a.a.b.b.a.bu(15, this.kem);
      paramInt = i;
      if (this.xJE != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.xJE);
      }
      AppMethodBeat.o(187877);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187877);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        drn localdrn = (drn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187877);
          return -1;
        case 1: 
          localdrn.Username = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 2: 
          localdrn.oUJ = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 3: 
          localdrn.MUb = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 4: 
          localdrn.MUc = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 5: 
          localdrn.keh = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 6: 
          localdrn.kdZ = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 7: 
          localdrn.kea = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 8: 
          localdrn.keb = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 9: 
          localdrn.kdY = locala.UbS.zi();
          AppMethodBeat.o(187877);
          return 0;
        case 10: 
          localdrn.MmK = locala.UbS.zi();
          AppMethodBeat.o(187877);
          return 0;
        case 11: 
          localdrn.MUd = locala.UbS.hPo();
          AppMethodBeat.o(187877);
          return 0;
        case 12: 
          localdrn.KQY = locala.UbS.readString();
          AppMethodBeat.o(187877);
          return 0;
        case 13: 
          localdrn.MUe = locala.UbS.hPo();
          AppMethodBeat.o(187877);
          return 0;
        case 14: 
          localdrn.MUf = locala.UbS.hPo();
          AppMethodBeat.o(187877);
          return 0;
        case 15: 
          localdrn.kem = locala.UbS.zi();
          AppMethodBeat.o(187877);
          return 0;
        }
        localdrn.xJE = locala.UbS.readString();
        AppMethodBeat.o(187877);
        return 0;
      }
      AppMethodBeat.o(187877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drn
 * JD-Core Version:    0.7.0.1
 */