package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gn
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> FRc;
  public long FRd;
  public String dqk;
  public String dwx;
  public String ikT;
  
  public gn()
  {
    AppMethodBeat.i(138168);
    this.FRc = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwx == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.dwx != null) {
        paramVarArgs.d(1, this.dwx);
      }
      if (this.dqk != null) {
        paramVarArgs.d(2, this.dqk);
      }
      if (this.ikT != null) {
        paramVarArgs.d(3, this.ikT);
      }
      paramVarArgs.e(4, 1, this.FRc);
      paramVarArgs.aZ(5, this.FRd);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwx == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.dwx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dqk);
      }
      i = paramInt;
      if (this.ikT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ikT);
      }
      paramInt = f.a.a.a.c(4, 1, this.FRc);
      int j = f.a.a.b.b.a.p(5, this.FRd);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.dwx == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gn localgn = (gn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138169);
          return -1;
        case 1: 
          localgn.dwx = locala.OmT.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localgn.dqk = locala.OmT.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localgn.ikT = locala.OmT.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localgn.FRc.add(locala.OmT.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localgn.FRd = locala.OmT.zd();
        AppMethodBeat.o(138169);
        return 0;
      }
      AppMethodBeat.o(138169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gn
 * JD-Core Version:    0.7.0.1
 */