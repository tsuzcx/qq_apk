package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String gKJ;
  public String id;
  public String name;
  public int status;
  public int type;
  public String url;
  public String zOP;
  public String zOQ;
  public String zOR = "0";
  public String zOS = "0";
  public int zOT = 0;
  public int zOU;
  public String zOV;
  public String zOk;
  
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
      paramVarArgs.aR(4, this.status);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.type);
      if (this.zOP != null) {
        paramVarArgs.d(7, this.zOP);
      }
      if (this.zOQ != null) {
        paramVarArgs.d(8, this.zOQ);
      }
      if (this.zOR != null) {
        paramVarArgs.d(9, this.zOR);
      }
      if (this.zOS != null) {
        paramVarArgs.d(10, this.zOS);
      }
      paramVarArgs.aR(11, this.zOT);
      if (this.zOk != null) {
        paramVarArgs.d(12, this.zOk);
      }
      if (this.gKJ != null) {
        paramVarArgs.d(13, this.gKJ);
      }
      paramVarArgs.aR(14, this.zOU);
      if (this.zOV != null) {
        paramVarArgs.d(15, this.zOV);
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
      i += f.a.a.b.b.a.bA(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.type);
      paramInt = i;
      if (this.zOP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zOP);
      }
      i = paramInt;
      if (this.zOQ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.zOQ);
      }
      paramInt = i;
      if (this.zOR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.zOR);
      }
      i = paramInt;
      if (this.zOS != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.zOS);
      }
      i += f.a.a.b.b.a.bA(11, this.zOT);
      paramInt = i;
      if (this.zOk != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.zOk);
      }
      i = paramInt;
      if (this.gKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.gKJ);
      }
      i += f.a.a.b.b.a.bA(14, this.zOU);
      paramInt = i;
      if (this.zOV != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.zOV);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localq.id = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localq.name = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localq.desc = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localq.status = locala.KhF.xS();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localq.url = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localq.type = locala.KhF.xS();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localq.zOP = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localq.zOQ = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localq.zOR = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localq.zOS = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localq.zOT = locala.KhF.xS();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localq.zOk = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localq.gKJ = locala.KhF.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localq.zOU = locala.KhF.xS();
          AppMethodBeat.o(91303);
          return 0;
        }
        localq.zOV = locala.KhF.readString();
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