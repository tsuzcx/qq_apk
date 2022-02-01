package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dys
  extends com.tencent.mm.bw.a
{
  public String DbG;
  public String FRk;
  public int GeW = -1;
  public String GeX;
  public String GeY;
  public String GeZ;
  public String Gfa;
  public String Gfb;
  public int Gfc;
  public String cQO;
  public int dhE;
  public int duration = -1;
  public int idx;
  public long msgId;
  public int nLC;
  public long nzO;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189322);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.duration);
      paramVarArgs.aR(2, this.GeW);
      if (this.cQO != null) {
        paramVarArgs.d(3, this.cQO);
      }
      if (this.GeX != null) {
        paramVarArgs.d(4, this.GeX);
      }
      paramVarArgs.aR(5, this.dhE);
      if (this.FRk != null) {
        paramVarArgs.d(6, this.FRk);
      }
      paramVarArgs.aO(7, this.msgId);
      paramVarArgs.aR(8, this.idx);
      if (this.GeY != null) {
        paramVarArgs.d(9, this.GeY);
      }
      if (this.GeZ != null) {
        paramVarArgs.d(10, this.GeZ);
      }
      if (this.Gfa != null) {
        paramVarArgs.d(11, this.Gfa);
      }
      if (this.Gfb != null) {
        paramVarArgs.d(12, this.Gfb);
      }
      paramVarArgs.aO(13, this.nzO);
      paramVarArgs.aR(14, this.scene);
      paramVarArgs.aR(15, this.nLC);
      paramVarArgs.aR(16, this.Gfc);
      if (this.DbG != null) {
        paramVarArgs.d(17, this.DbG);
      }
      AppMethodBeat.o(189322);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.duration) + 0 + f.a.a.b.b.a.bx(2, this.GeW);
      paramInt = i;
      if (this.cQO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.cQO);
      }
      i = paramInt;
      if (this.GeX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GeX);
      }
      i += f.a.a.b.b.a.bx(5, this.dhE);
      paramInt = i;
      if (this.FRk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FRk);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.msgId) + f.a.a.b.b.a.bx(8, this.idx);
      paramInt = i;
      if (this.GeY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GeY);
      }
      i = paramInt;
      if (this.GeZ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GeZ);
      }
      paramInt = i;
      if (this.Gfa != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gfa);
      }
      i = paramInt;
      if (this.Gfb != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gfb);
      }
      i = i + f.a.a.b.b.a.p(13, this.nzO) + f.a.a.b.b.a.bx(14, this.scene) + f.a.a.b.b.a.bx(15, this.nLC) + f.a.a.b.b.a.bx(16, this.Gfc);
      paramInt = i;
      if (this.DbG != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DbG);
      }
      AppMethodBeat.o(189322);
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
      AppMethodBeat.o(189322);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dys localdys = (dys)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189322);
        return -1;
      case 1: 
        localdys.duration = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      case 2: 
        localdys.GeW = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      case 3: 
        localdys.cQO = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 4: 
        localdys.GeX = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 5: 
        localdys.dhE = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      case 6: 
        localdys.FRk = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 7: 
        localdys.msgId = locala.LVo.xG();
        AppMethodBeat.o(189322);
        return 0;
      case 8: 
        localdys.idx = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      case 9: 
        localdys.GeY = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 10: 
        localdys.GeZ = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 11: 
        localdys.Gfa = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 12: 
        localdys.Gfb = locala.LVo.readString();
        AppMethodBeat.o(189322);
        return 0;
      case 13: 
        localdys.nzO = locala.LVo.xG();
        AppMethodBeat.o(189322);
        return 0;
      case 14: 
        localdys.scene = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      case 15: 
        localdys.nLC = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      case 16: 
        localdys.Gfc = locala.LVo.xF();
        AppMethodBeat.o(189322);
        return 0;
      }
      localdys.DbG = locala.LVo.readString();
      AppMethodBeat.o(189322);
      return 0;
    }
    AppMethodBeat.o(189322);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dys
 * JD-Core Version:    0.7.0.1
 */