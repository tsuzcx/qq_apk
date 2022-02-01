package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class etd
  extends com.tencent.mm.bx.a
{
  public String IcT;
  public String Username;
  public String abws;
  public String abwt;
  public b abwu;
  public long abwv;
  public String abww;
  public String abwx;
  public String abwy;
  public int crm;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abwt != null) {
        paramVarArgs.g(1, this.abwt);
      }
      if (this.Username != null) {
        paramVarArgs.g(2, this.Username);
      }
      if (this.IcT != null) {
        paramVarArgs.g(3, this.IcT);
      }
      paramVarArgs.bS(4, this.crm);
      if (this.abwu != null) {
        paramVarArgs.d(5, this.abwu);
      }
      if (this.hAP != null) {
        paramVarArgs.g(6, this.hAP);
      }
      if (this.abws != null) {
        paramVarArgs.g(7, this.abws);
      }
      paramVarArgs.bv(8, this.abwv);
      if (this.abww != null) {
        paramVarArgs.g(9, this.abww);
      }
      if (this.abwx != null) {
        paramVarArgs.g(10, this.abwx);
      }
      if (this.abwy != null) {
        paramVarArgs.g(11, this.abwy);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abwt == null) {
        break label790;
      }
    }
    label790:
    for (int i = i.a.a.b.b.a.h(1, this.abwt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Username);
      }
      i = paramInt;
      if (this.IcT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IcT);
      }
      i += i.a.a.b.b.a.cJ(4, this.crm);
      paramInt = i;
      if (this.abwu != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.abwu);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.hAP);
      }
      paramInt = i;
      if (this.abws != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abws);
      }
      i = paramInt + i.a.a.b.b.a.q(8, this.abwv);
      paramInt = i;
      if (this.abww != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abww);
      }
      i = paramInt;
      if (this.abwx != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abwx);
      }
      paramInt = i;
      if (this.abwy != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abwy);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        etd localetd = (etd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localetd.abwt = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localetd.Username = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localetd.IcT = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localetd.crm = locala.ajGk.aar();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localetd.abwu = locala.ajGk.kFX();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localetd.hAP = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localetd.abws = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localetd.abwv = locala.ajGk.aaw();
          AppMethodBeat.o(181512);
          return 0;
        case 9: 
          localetd.abww = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 10: 
          localetd.abwx = locala.ajGk.readString();
          AppMethodBeat.o(181512);
          return 0;
        }
        localetd.abwy = locala.ajGk.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etd
 * JD-Core Version:    0.7.0.1
 */