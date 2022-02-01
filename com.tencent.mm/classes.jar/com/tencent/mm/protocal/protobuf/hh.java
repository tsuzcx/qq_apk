package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class hh
  extends com.tencent.mm.bx.a
{
  public long YIN;
  public String hFb;
  public String hMM;
  public LinkedList<String> msk;
  public String oPv;
  
  public hh()
  {
    AppMethodBeat.i(138168);
    this.msk = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMM == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.hMM != null) {
        paramVarArgs.g(1, this.hMM);
      }
      if (this.hFb != null) {
        paramVarArgs.g(2, this.hFb);
      }
      if (this.oPv != null) {
        paramVarArgs.g(3, this.oPv);
      }
      paramVarArgs.e(4, 1, this.msk);
      paramVarArgs.bv(5, this.YIN);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hMM == null) {
        break label486;
      }
    }
    label486:
    for (int i = i.a.a.b.b.a.h(1, this.hMM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hFb);
      }
      i = paramInt;
      if (this.oPv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oPv);
      }
      paramInt = i.a.a.a.c(4, 1, this.msk);
      int j = i.a.a.b.b.a.q(5, this.YIN);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.msk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hMM == null)
        {
          paramVarArgs = new b("Not all required fields were included: roomname");
          AppMethodBeat.o(138169);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138169);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        hh localhh = (hh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138169);
          return -1;
        case 1: 
          localhh.hMM = locala.ajGk.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localhh.hFb = locala.ajGk.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localhh.oPv = locala.ajGk.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localhh.msk.add(locala.ajGk.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localhh.YIN = locala.ajGk.aaw();
        AppMethodBeat.o(138169);
        return 0;
      }
      AppMethodBeat.o(138169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hh
 * JD-Core Version:    0.7.0.1
 */