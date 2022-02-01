package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnf
  extends com.tencent.mm.bw.a
{
  public int Dqw;
  public int MQy;
  public int MQz;
  public String hid;
  public String hie;
  public String hif;
  public String hig;
  public String oUj;
  public String pLl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUj != null) {
        paramVarArgs.e(1, this.oUj);
      }
      paramVarArgs.aM(2, this.MQy);
      if (this.hid != null) {
        paramVarArgs.e(3, this.hid);
      }
      if (this.hie != null) {
        paramVarArgs.e(4, this.hie);
      }
      paramVarArgs.aM(5, this.Dqw);
      paramVarArgs.aM(6, this.MQz);
      if (this.hif != null) {
        paramVarArgs.e(7, this.hif);
      }
      if (this.hig != null) {
        paramVarArgs.e(8, this.hig);
      }
      if (this.pLl != null) {
        paramVarArgs.e(9, this.pLl);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUj == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.b.b.a.f(1, this.oUj) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MQy);
      paramInt = i;
      if (this.hid != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.hid);
      }
      i = paramInt;
      if (this.hie != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.hie);
      }
      i = i + g.a.a.b.b.a.bu(5, this.Dqw) + g.a.a.b.b.a.bu(6, this.MQz);
      paramInt = i;
      if (this.hif != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.hif);
      }
      i = paramInt;
      if (this.hig != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.hig);
      }
      paramInt = i;
      if (this.pLl != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.pLl);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dnf localdnf = (dnf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localdnf.oUj = locala.UbS.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localdnf.MQy = locala.UbS.zi();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localdnf.hid = locala.UbS.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localdnf.hie = locala.UbS.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localdnf.Dqw = locala.UbS.zi();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localdnf.MQz = locala.UbS.zi();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localdnf.hif = locala.UbS.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localdnf.hig = locala.UbS.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localdnf.pLl = locala.UbS.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnf
 * JD-Core Version:    0.7.0.1
 */