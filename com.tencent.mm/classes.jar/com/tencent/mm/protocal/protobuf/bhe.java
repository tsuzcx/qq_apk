package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bhe
  extends com.tencent.mm.bw.a
{
  public int LQQ;
  public int LQY;
  public String LQZ;
  public String LRa;
  public String LRb;
  public String LRc;
  public int Scene;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LQY);
      if (this.LQZ != null) {
        paramVarArgs.e(2, this.LQZ);
      }
      if (this.jfi != null) {
        paramVarArgs.e(3, this.jfi);
      }
      if (this.LRa != null) {
        paramVarArgs.e(4, this.LRa);
      }
      if (this.LRb != null) {
        paramVarArgs.e(5, this.LRb);
      }
      if (this.LRc != null) {
        paramVarArgs.e(7, this.LRc);
      }
      paramVarArgs.aM(8, this.LQQ);
      paramVarArgs.aM(9, this.Scene);
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LQY) + 0;
      paramInt = i;
      if (this.LQZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LQZ);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jfi);
      }
      paramInt = i;
      if (this.LRa != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LRa);
      }
      i = paramInt;
      if (this.LRb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LRb);
      }
      paramInt = i;
      if (this.LRc != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LRc);
      }
      i = g.a.a.b.b.a.bu(8, this.LQQ);
      int j = g.a.a.b.b.a.bu(9, this.Scene);
      AppMethodBeat.o(152546);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bhe localbhe = (bhe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localbhe.LQY = locala.UbS.zi();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localbhe.LQZ = locala.UbS.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localbhe.jfi = locala.UbS.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localbhe.LRa = locala.UbS.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localbhe.LRb = locala.UbS.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localbhe.LRc = locala.UbS.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localbhe.LQQ = locala.UbS.zi();
        AppMethodBeat.o(152546);
        return 0;
      }
      localbhe.Scene = locala.UbS.zi();
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhe
 * JD-Core Version:    0.7.0.1
 */