package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfw
  extends com.tencent.mm.bw.a
{
  public float Eht;
  public float Ehu;
  public String Fai;
  public String Fud;
  public String Fue;
  public long Fuf;
  public String iJV;
  public String iKc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fud != null) {
        paramVarArgs.d(1, this.Fud);
      }
      if (this.iKc != null) {
        paramVarArgs.d(2, this.iKc);
      }
      if (this.iJV != null) {
        paramVarArgs.d(3, this.iJV);
      }
      if (this.Fai != null) {
        paramVarArgs.d(4, this.Fai);
      }
      paramVarArgs.x(5, this.Ehu);
      paramVarArgs.x(6, this.Eht);
      if (this.Fue != null) {
        paramVarArgs.d(7, this.Fue);
      }
      paramVarArgs.aO(8, this.Fuf);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fud == null) {
        break label592;
      }
    }
    label592:
    for (int i = f.a.a.b.b.a.e(1, this.Fud) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iKc);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iJV);
      }
      paramInt = i;
      if (this.Fai != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fai);
      }
      i = paramInt + (f.a.a.b.b.a.fK(5) + 4) + (f.a.a.b.b.a.fK(6) + 4);
      paramInt = i;
      if (this.Fue != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fue);
      }
      i = f.a.a.b.b.a.p(8, this.Fuf);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfw localcfw = (cfw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localcfw.Fud = locala.LVo.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localcfw.iKc = locala.LVo.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localcfw.iJV = locala.LVo.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localcfw.Fai = locala.LVo.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localcfw.Ehu = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localcfw.Eht = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localcfw.Fue = locala.LVo.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localcfw.Fuf = locala.LVo.xG();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfw
 * JD-Core Version:    0.7.0.1
 */