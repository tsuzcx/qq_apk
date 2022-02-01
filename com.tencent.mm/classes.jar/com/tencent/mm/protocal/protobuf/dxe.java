package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxe
  extends com.tencent.mm.bw.a
{
  public String FDc;
  public int FGG;
  public boolean GdO;
  public boolean GdP;
  public boolean GdQ;
  public com.tencent.mm.bw.b Gdx;
  public String Title;
  public String hkR;
  public int tlI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hkR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.tlI);
      if (this.FDc != null) {
        paramVarArgs.d(2, this.FDc);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.hkR != null) {
        paramVarArgs.d(4, this.hkR);
      }
      paramVarArgs.aR(5, this.FGG);
      if (this.Gdx != null) {
        paramVarArgs.c(6, this.Gdx);
      }
      paramVarArgs.bl(7, this.GdO);
      paramVarArgs.bl(8, this.GdP);
      paramVarArgs.bl(9, this.GdQ);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tlI) + 0;
      paramInt = i;
      if (this.FDc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FDc);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hkR);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FGG);
      paramInt = i;
      if (this.Gdx != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.Gdx);
      }
      i = f.a.a.b.b.a.fK(7);
      int j = f.a.a.b.b.a.fK(8);
      int k = f.a.a.b.b.a.fK(9);
      AppMethodBeat.o(32545);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hkR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxe localdxe = (dxe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localdxe.tlI = locala.LVo.xF();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localdxe.FDc = locala.LVo.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localdxe.Title = locala.LVo.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localdxe.hkR = locala.LVo.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localdxe.FGG = locala.LVo.xF();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localdxe.Gdx = locala.LVo.gfk();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localdxe.GdO = locala.LVo.fZX();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localdxe.GdP = locala.LVo.fZX();
        AppMethodBeat.o(32545);
        return 0;
      }
      localdxe.GdQ = locala.LVo.fZX();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxe
 * JD-Core Version:    0.7.0.1
 */