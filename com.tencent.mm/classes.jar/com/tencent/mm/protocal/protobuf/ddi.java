package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddi
  extends com.tencent.mm.bx.a
{
  public String Frp;
  public String Frq;
  public int Frr;
  public String FxH;
  public String dHX;
  public String dHY;
  public String oxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX != null) {
        paramVarArgs.d(1, this.dHX);
      }
      if (this.oxM != null) {
        paramVarArgs.d(2, this.oxM);
      }
      if (this.dHY != null) {
        paramVarArgs.d(3, this.dHY);
      }
      if (this.Frp != null) {
        paramVarArgs.d(4, this.Frp);
      }
      if (this.Frq != null) {
        paramVarArgs.d(5, this.Frq);
      }
      paramVarArgs.aS(6, this.Frr);
      if (this.FxH != null) {
        paramVarArgs.d(7, this.FxH);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHX == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.dHX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oxM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oxM);
      }
      i = paramInt;
      if (this.dHY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dHY);
      }
      paramInt = i;
      if (this.Frp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Frp);
      }
      i = paramInt;
      if (this.Frq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Frq);
      }
      i += f.a.a.b.b.a.bz(6, this.Frr);
      paramInt = i;
      if (this.FxH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FxH);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddi localddi = (ddi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localddi.dHX = locala.NPN.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localddi.oxM = locala.NPN.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localddi.dHY = locala.NPN.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localddi.Frp = locala.NPN.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localddi.Frq = locala.NPN.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localddi.Frr = locala.NPN.zc();
          AppMethodBeat.o(114073);
          return 0;
        }
        localddi.FxH = locala.NPN.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddi
 * JD-Core Version:    0.7.0.1
 */