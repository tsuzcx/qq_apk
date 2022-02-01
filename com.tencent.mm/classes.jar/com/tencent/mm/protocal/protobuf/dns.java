package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dns
  extends com.tencent.mm.bx.a
{
  public String EEl;
  public String EEm;
  public LinkedList<String> EEn;
  public int EEo;
  
  public dns()
  {
    AppMethodBeat.i(147784);
    this.EEn = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEl != null) {
        paramVarArgs.d(1, this.EEl);
      }
      if (this.EEm != null) {
        paramVarArgs.d(2, this.EEm);
      }
      paramVarArgs.e(3, 1, this.EEn);
      paramVarArgs.aR(4, this.EEo);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEl == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.EEl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EEm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EEm);
      }
      paramInt = f.a.a.a.c(3, 1, this.EEn);
      int j = f.a.a.b.b.a.bA(4, this.EEo);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EEn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dns localdns = (dns)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localdns.EEl = locala.KhF.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localdns.EEm = locala.KhF.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localdns.EEn.add(locala.KhF.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localdns.EEo = locala.KhF.xS();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dns
 * JD-Core Version:    0.7.0.1
 */