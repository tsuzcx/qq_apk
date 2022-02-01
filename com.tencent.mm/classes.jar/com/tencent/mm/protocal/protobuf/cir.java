package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cir
  extends com.tencent.mm.bw.a
{
  public int FQT;
  public int FileSize;
  public String Hvd;
  public int Hve;
  public String Hvf;
  public String Hvg;
  public String Hvh;
  public String Hvi;
  public String Hvj;
  public int Hvk;
  public String Hvl;
  public int Scene;
  public String jfY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218930);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hvd == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(218930);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Scene);
      paramVarArgs.aS(2, this.FQT);
      paramVarArgs.aS(3, this.FileSize);
      if (this.Hvd != null) {
        paramVarArgs.d(4, this.Hvd);
      }
      paramVarArgs.aS(5, this.Hve);
      if (this.Hvf != null) {
        paramVarArgs.d(6, this.Hvf);
      }
      if (this.Hvg != null) {
        paramVarArgs.d(7, this.Hvg);
      }
      if (this.Hvh != null) {
        paramVarArgs.d(8, this.Hvh);
      }
      if (this.Hvi != null) {
        paramVarArgs.d(10, this.Hvi);
      }
      if (this.Hvj != null) {
        paramVarArgs.d(11, this.Hvj);
      }
      paramVarArgs.aS(12, this.Hvk);
      if (this.jfY != null) {
        paramVarArgs.d(13, this.jfY);
      }
      if (this.Hvl != null) {
        paramVarArgs.d(14, this.Hvl);
      }
      AppMethodBeat.o(218930);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0 + f.a.a.b.b.a.bz(2, this.FQT) + f.a.a.b.b.a.bz(3, this.FileSize);
      paramInt = i;
      if (this.Hvd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hvd);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Hve);
      paramInt = i;
      if (this.Hvf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hvf);
      }
      i = paramInt;
      if (this.Hvg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hvg);
      }
      paramInt = i;
      if (this.Hvh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hvh);
      }
      i = paramInt;
      if (this.Hvi != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Hvi);
      }
      paramInt = i;
      if (this.Hvj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hvj);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Hvk);
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jfY);
      }
      i = paramInt;
      if (this.Hvl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Hvl);
      }
      AppMethodBeat.o(218930);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Hvd == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(218930);
        throw paramVarArgs;
      }
      AppMethodBeat.o(218930);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cir localcir = (cir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 9: 
      default: 
        AppMethodBeat.o(218930);
        return -1;
      case 1: 
        localcir.Scene = locala.OmT.zc();
        AppMethodBeat.o(218930);
        return 0;
      case 2: 
        localcir.FQT = locala.OmT.zc();
        AppMethodBeat.o(218930);
        return 0;
      case 3: 
        localcir.FileSize = locala.OmT.zc();
        AppMethodBeat.o(218930);
        return 0;
      case 4: 
        localcir.Hvd = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      case 5: 
        localcir.Hve = locala.OmT.zc();
        AppMethodBeat.o(218930);
        return 0;
      case 6: 
        localcir.Hvf = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      case 7: 
        localcir.Hvg = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      case 8: 
        localcir.Hvh = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      case 10: 
        localcir.Hvi = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      case 11: 
        localcir.Hvj = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      case 12: 
        localcir.Hvk = locala.OmT.zc();
        AppMethodBeat.o(218930);
        return 0;
      case 13: 
        localcir.jfY = locala.OmT.readString();
        AppMethodBeat.o(218930);
        return 0;
      }
      localcir.Hvl = locala.OmT.readString();
      AppMethodBeat.o(218930);
      return 0;
    }
    AppMethodBeat.o(218930);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cir
 * JD-Core Version:    0.7.0.1
 */