package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dev
  extends com.tencent.mm.bw.a
{
  public int EBs;
  public String hjV;
  public String hjX;
  public String hjY;
  public String hjZ;
  public String hka;
  public String hkb;
  public String hkc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hjV != null) {
        paramVarArgs.d(1, this.hjV);
      }
      paramVarArgs.aR(2, this.EBs);
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
      AppMethodBeat.o(127178);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EBs);
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
      AppMethodBeat.o(127178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127178);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dev localdev = (dev)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127178);
          return -1;
        case 1: 
          localdev.hjV = locala.LVo.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 2: 
          localdev.EBs = locala.LVo.xF();
          AppMethodBeat.o(127178);
          return 0;
        case 3: 
          localdev.hjY = locala.LVo.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 4: 
          localdev.hjZ = locala.LVo.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 5: 
          localdev.hjX = locala.LVo.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 6: 
          localdev.hka = locala.LVo.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 7: 
          localdev.hkb = locala.LVo.readString();
          AppMethodBeat.o(127178);
          return 0;
        }
        localdev.hkc = locala.LVo.readString();
        AppMethodBeat.o(127178);
        return 0;
      }
      AppMethodBeat.o(127178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dev
 * JD-Core Version:    0.7.0.1
 */