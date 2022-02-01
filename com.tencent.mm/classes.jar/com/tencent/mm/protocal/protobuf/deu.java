package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deu
  extends com.tencent.mm.bw.a
{
  public String hjV;
  public int hjW;
  public String hjX;
  public String hjY;
  public String hjZ;
  public String hka;
  public String hkb;
  public String hkc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hjV != null) {
        paramVarArgs.d(1, this.hjV);
      }
      paramVarArgs.aR(2, this.hjW);
      if (this.hjY != null) {
        paramVarArgs.d(3, this.hjY);
      }
      if (this.hjZ != null) {
        paramVarArgs.d(4, this.hjZ);
      }
      if (this.hjX != null) {
        paramVarArgs.d(5, this.hjX);
      }
      if (this.hka != null) {
        paramVarArgs.d(6, this.hka);
      }
      if (this.hkb != null) {
        paramVarArgs.d(7, this.hkb);
      }
      if (this.hkc != null) {
        paramVarArgs.d(8, this.hkc);
      }
      AppMethodBeat.o(125846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hjV == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.hjV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.hjW);
      paramInt = i;
      if (this.hjY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hjY);
      }
      i = paramInt;
      if (this.hjZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hjZ);
      }
      paramInt = i;
      if (this.hjX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hjX);
      }
      i = paramInt;
      if (this.hka != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hka);
      }
      paramInt = i;
      if (this.hkb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hkb);
      }
      i = paramInt;
      if (this.hkc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.hkc);
      }
      AppMethodBeat.o(125846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125846);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        deu localdeu = (deu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125846);
          return -1;
        case 1: 
          localdeu.hjV = locala.LVo.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 2: 
          localdeu.hjW = locala.LVo.xF();
          AppMethodBeat.o(125846);
          return 0;
        case 3: 
          localdeu.hjY = locala.LVo.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 4: 
          localdeu.hjZ = locala.LVo.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 5: 
          localdeu.hjX = locala.LVo.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 6: 
          localdeu.hka = locala.LVo.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 7: 
          localdeu.hkb = locala.LVo.readString();
          AppMethodBeat.o(125846);
          return 0;
        }
        localdeu.hkc = locala.LVo.readString();
        AppMethodBeat.o(125846);
        return 0;
      }
      AppMethodBeat.o(125846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deu
 * JD-Core Version:    0.7.0.1
 */