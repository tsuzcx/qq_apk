package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class om
  extends com.tencent.mm.bw.a
{
  public int Een;
  public int Eeo;
  public int Eep;
  public String Eeq;
  public int Eer;
  public int Ees;
  public int Eet;
  public String Eeu;
  public String djj;
  public String oHB;
  public int xEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      paramVarArgs.aR(2, this.Een);
      paramVarArgs.aR(3, this.Eeo);
      if (this.oHB != null) {
        paramVarArgs.d(4, this.oHB);
      }
      paramVarArgs.aR(5, this.Eep);
      if (this.Eeq != null) {
        paramVarArgs.d(6, this.Eeq);
      }
      paramVarArgs.aR(7, this.Eer);
      paramVarArgs.aR(8, this.Ees);
      paramVarArgs.aR(9, this.Eet);
      if (this.Eeu != null) {
        paramVarArgs.d(10, this.Eeu);
      }
      paramVarArgs.aR(15, this.xEp);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.b.b.a.e(1, this.djj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Een) + f.a.a.b.b.a.bx(3, this.Eeo);
      paramInt = i;
      if (this.oHB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oHB);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Eep);
      paramInt = i;
      if (this.Eeq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eeq);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Eer) + f.a.a.b.b.a.bx(8, this.Ees) + f.a.a.b.b.a.bx(9, this.Eet);
      paramInt = i;
      if (this.Eeu != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Eeu);
      }
      i = f.a.a.b.b.a.bx(15, this.xEp);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        om localom = (om)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(117838);
          return -1;
        case 1: 
          localom.djj = locala.LVo.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localom.Een = locala.LVo.xF();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localom.Eeo = locala.LVo.xF();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localom.oHB = locala.LVo.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localom.Eep = locala.LVo.xF();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localom.Eeq = locala.LVo.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localom.Eer = locala.LVo.xF();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localom.Ees = locala.LVo.xF();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localom.Eet = locala.LVo.xF();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localom.Eeu = locala.LVo.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localom.xEp = locala.LVo.xF();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */