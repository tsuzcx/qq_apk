package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String CGS;
  public String CHA = "0";
  public int CHB = 0;
  public int CHC;
  public String CHD;
  public String CHx;
  public String CHy;
  public String CHz = "0";
  public String desc;
  public String hDs;
  public String id;
  public String name;
  public int status;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91303);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aS(4, this.status);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.type);
      if (this.CHx != null) {
        paramVarArgs.d(7, this.CHx);
      }
      if (this.CHy != null) {
        paramVarArgs.d(8, this.CHy);
      }
      if (this.CHz != null) {
        paramVarArgs.d(9, this.CHz);
      }
      if (this.CHA != null) {
        paramVarArgs.d(10, this.CHA);
      }
      paramVarArgs.aS(11, this.CHB);
      if (this.CGS != null) {
        paramVarArgs.d(12, this.CGS);
      }
      if (this.hDs != null) {
        paramVarArgs.d(13, this.hDs);
      }
      paramVarArgs.aS(14, this.CHC);
      if (this.CHD != null) {
        paramVarArgs.d(15, this.CHD);
      }
      AppMethodBeat.o(91303);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1010;
      }
    }
    label1010:
    for (int i = f.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      i += f.a.a.b.b.a.bz(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.CHx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CHx);
      }
      i = paramInt;
      if (this.CHy != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CHy);
      }
      paramInt = i;
      if (this.CHz != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CHz);
      }
      i = paramInt;
      if (this.CHA != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CHA);
      }
      i += f.a.a.b.b.a.bz(11, this.CHB);
      paramInt = i;
      if (this.CGS != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CGS);
      }
      i = paramInt;
      if (this.hDs != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hDs);
      }
      i += f.a.a.b.b.a.bz(14, this.CHC);
      paramInt = i;
      if (this.CHD != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CHD);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91303);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91303);
          return -1;
        case 1: 
          localq.id = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localq.name = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localq.desc = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localq.status = locala.NPN.zc();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localq.url = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localq.type = locala.NPN.zc();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localq.CHx = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localq.CHy = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localq.CHz = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localq.CHA = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localq.CHB = locala.NPN.zc();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localq.CGS = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localq.hDs = locala.NPN.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localq.CHC = locala.NPN.zc();
          AppMethodBeat.o(91303);
          return 0;
        }
        localq.CHD = locala.NPN.readString();
        AppMethodBeat.o(91303);
        return 0;
      }
      AppMethodBeat.o(91303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */