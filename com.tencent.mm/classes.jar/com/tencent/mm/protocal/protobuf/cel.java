package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cel
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LxM;
  public int MjU;
  public int MjV;
  public String MjW;
  public String md5;
  public String name;
  public String url;
  
  public cel()
  {
    AppMethodBeat.i(82447);
    this.LxM = new LinkedList();
    AppMethodBeat.o(82447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.e(3, this.md5);
      }
      paramVarArgs.e(4, 1, this.LxM);
      paramVarArgs.aM(5, this.MjU);
      paramVarArgs.aM(6, this.MjV);
      if (this.MjW != null) {
        paramVarArgs.e(7, this.MjW);
      }
      AppMethodBeat.o(82448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.md5);
      }
      i = i + g.a.a.a.c(4, 1, this.LxM) + g.a.a.b.b.a.bu(5, this.MjU) + g.a.a.b.b.a.bu(6, this.MjV);
      paramInt = i;
      if (this.MjW != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MjW);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LxM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cel localcel = (cel)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localcel.name = locala.UbS.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localcel.url = locala.UbS.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localcel.md5 = locala.UbS.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localcel.LxM.add(locala.UbS.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localcel.MjU = locala.UbS.zi();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localcel.MjV = locala.UbS.zi();
          AppMethodBeat.o(82448);
          return 0;
        }
        localcel.MjW = locala.UbS.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cel
 * JD-Core Version:    0.7.0.1
 */