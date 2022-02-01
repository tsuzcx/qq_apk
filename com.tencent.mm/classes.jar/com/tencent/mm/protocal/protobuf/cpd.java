package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpd
  extends com.tencent.mm.bw.a
{
  public String Lir;
  public String Lis;
  public int Mvd;
  public int Mve;
  public String UserName;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public String keh;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.kdY);
      if (this.kea != null) {
        paramVarArgs.e(4, this.kea);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(5, this.kdZ);
      }
      if (this.keb != null) {
        paramVarArgs.e(6, this.keb);
      }
      paramVarArgs.aM(7, this.Mvd);
      paramVarArgs.aM(8, this.Mve);
      if (this.keh != null) {
        paramVarArgs.e(9, this.keh);
      }
      if (this.Lir != null) {
        paramVarArgs.e(10, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(11, this.Lis);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.kdY);
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.kea);
      }
      i = paramInt;
      if (this.kdZ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.kdZ);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.Mvd) + g.a.a.b.b.a.bu(8, this.Mve);
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.keh);
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Lis);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpd localcpd = (cpd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localcpd.UserName = locala.UbS.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localcpd.oUv = locala.UbS.zi();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localcpd.kdY = locala.UbS.zi();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localcpd.kea = locala.UbS.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localcpd.kdZ = locala.UbS.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localcpd.keb = locala.UbS.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localcpd.Mvd = locala.UbS.zi();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localcpd.Mve = locala.UbS.zi();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localcpd.keh = locala.UbS.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localcpd.Lir = locala.UbS.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localcpd.Lis = locala.UbS.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpd
 * JD-Core Version:    0.7.0.1
 */