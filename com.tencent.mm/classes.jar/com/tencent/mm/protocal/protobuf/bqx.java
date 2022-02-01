package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqx
  extends com.tencent.mm.bx.a
{
  public int GLl;
  public int GLm;
  public String GLn;
  public LinkedList<String> Gjh;
  public String md5;
  public String name;
  public String url;
  
  public bqx()
  {
    AppMethodBeat.i(82447);
    this.Gjh = new LinkedList();
    AppMethodBeat.o(82447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.e(4, 1, this.Gjh);
      paramVarArgs.aS(5, this.GLl);
      paramVarArgs.aS(6, this.GLm);
      if (this.GLn != null) {
        paramVarArgs.d(7, this.GLn);
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
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.a.c(4, 1, this.Gjh) + f.a.a.b.b.a.bz(5, this.GLl) + f.a.a.b.b.a.bz(6, this.GLm);
      paramInt = i;
      if (this.GLn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GLn);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gjh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqx localbqx = (bqx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localbqx.name = locala.NPN.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localbqx.url = locala.NPN.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localbqx.md5 = locala.NPN.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localbqx.Gjh.add(locala.NPN.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localbqx.GLl = locala.NPN.zc();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localbqx.GLm = locala.NPN.zc();
          AppMethodBeat.o(82448);
          return 0;
        }
        localbqx.GLn = locala.NPN.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqx
 * JD-Core Version:    0.7.0.1
 */