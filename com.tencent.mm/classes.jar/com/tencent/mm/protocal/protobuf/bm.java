package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bm
  extends com.tencent.mm.bw.a
{
  public int DOr;
  public int DOs;
  public b DOt;
  public int DOu;
  public int DOv;
  public String DOw;
  public String DOx;
  public String imei;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.DOr);
      paramVarArgs.aR(3, this.DOs);
      if (this.DOt != null) {
        paramVarArgs.c(4, this.DOt);
      }
      paramVarArgs.aR(5, this.DOu);
      paramVarArgs.aR(6, this.DOv);
      if (this.DOw != null) {
        paramVarArgs.d(7, this.DOw);
      }
      if (this.imei != null) {
        paramVarArgs.d(8, this.imei);
      }
      if (this.DOx != null) {
        paramVarArgs.d(9, this.DOx);
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.uin) + 0 + f.a.a.b.b.a.bx(2, this.DOr) + f.a.a.b.b.a.bx(3, this.DOs);
      paramInt = i;
      if (this.DOt != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.DOt);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DOu) + f.a.a.b.b.a.bx(6, this.DOv);
      paramInt = i;
      if (this.DOw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DOw);
      }
      i = paramInt;
      if (this.imei != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.imei);
      }
      paramInt = i;
      if (this.DOx != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DOx);
      }
      AppMethodBeat.o(125690);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bm localbm = (bm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localbm.uin = locala.LVo.xF();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localbm.DOr = locala.LVo.xF();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localbm.DOs = locala.LVo.xF();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localbm.DOt = locala.LVo.gfk();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localbm.DOu = locala.LVo.xF();
        AppMethodBeat.o(125690);
        return 0;
      case 6: 
        localbm.DOv = locala.LVo.xF();
        AppMethodBeat.o(125690);
        return 0;
      case 7: 
        localbm.DOw = locala.LVo.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 8: 
        localbm.imei = locala.LVo.readString();
        AppMethodBeat.o(125690);
        return 0;
      }
      localbm.DOx = locala.LVo.readString();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */