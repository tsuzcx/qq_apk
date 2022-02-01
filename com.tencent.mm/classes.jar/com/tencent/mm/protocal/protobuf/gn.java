package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gn
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> FyE;
  public long FyF;
  public String dpf;
  public String dvs;
  public String iia;
  
  public gn()
  {
    AppMethodBeat.i(138168);
    this.FyE = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvs == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.dvs != null) {
        paramVarArgs.d(1, this.dvs);
      }
      if (this.dpf != null) {
        paramVarArgs.d(2, this.dpf);
      }
      if (this.iia != null) {
        paramVarArgs.d(3, this.iia);
      }
      paramVarArgs.e(4, 1, this.FyE);
      paramVarArgs.aY(5, this.FyF);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvs == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.dvs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dpf);
      }
      i = paramInt;
      if (this.iia != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iia);
      }
      paramInt = f.a.a.a.c(4, 1, this.FyE);
      int j = f.a.a.b.b.a.p(5, this.FyF);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FyE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.dvs == null)
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
          localgn.dvs = locala.NPN.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localgn.dpf = locala.NPN.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localgn.iia = locala.NPN.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localgn.FyE.add(locala.NPN.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localgn.FyF = locala.NPN.zd();
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