package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvk
  extends com.tencent.mm.cd.a
{
  public int RYL;
  public String TDk;
  public String TDl;
  public LinkedList<String> TDm;
  public String appid;
  public String desc;
  public String nickname;
  public float score;
  public String ufC;
  
  public cvk()
  {
    AppMethodBeat.i(275414);
    this.TDm = new LinkedList();
    AppMethodBeat.o(275414);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.ufC != null) {
        paramVarArgs.f(2, this.ufC);
      }
      if (this.TDk != null) {
        paramVarArgs.f(3, this.TDk);
      }
      if (this.desc != null) {
        paramVarArgs.f(4, this.desc);
      }
      paramVarArgs.e(5, 1, this.TDm);
      paramVarArgs.i(6, this.score);
      if (this.TDl != null) {
        paramVarArgs.f(7, this.TDl);
      }
      paramVarArgs.aY(8, this.RYL);
      if (this.nickname != null) {
        paramVarArgs.f(9, this.nickname);
      }
      AppMethodBeat.o(275415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label669;
      }
    }
    label669:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ufC);
      }
      i = paramInt;
      if (this.TDk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TDk);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.desc);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.TDm) + (g.a.a.b.b.a.gL(6) + 4);
      paramInt = i;
      if (this.TDl != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TDl);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.RYL);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.nickname);
      }
      AppMethodBeat.o(275415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TDm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(275415);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvk localcvk = (cvk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275415);
          return -1;
        case 1: 
          localcvk.appid = locala.abFh.readString();
          AppMethodBeat.o(275415);
          return 0;
        case 2: 
          localcvk.ufC = locala.abFh.readString();
          AppMethodBeat.o(275415);
          return 0;
        case 3: 
          localcvk.TDk = locala.abFh.readString();
          AppMethodBeat.o(275415);
          return 0;
        case 4: 
          localcvk.desc = locala.abFh.readString();
          AppMethodBeat.o(275415);
          return 0;
        case 5: 
          localcvk.TDm.add(locala.abFh.readString());
          AppMethodBeat.o(275415);
          return 0;
        case 6: 
          localcvk.score = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(275415);
          return 0;
        case 7: 
          localcvk.TDl = locala.abFh.readString();
          AppMethodBeat.o(275415);
          return 0;
        case 8: 
          localcvk.RYL = locala.abFh.AK();
          AppMethodBeat.o(275415);
          return 0;
        }
        localcvk.nickname = locala.abFh.readString();
        AppMethodBeat.o(275415);
        return 0;
      }
      AppMethodBeat.o(275415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvk
 * JD-Core Version:    0.7.0.1
 */