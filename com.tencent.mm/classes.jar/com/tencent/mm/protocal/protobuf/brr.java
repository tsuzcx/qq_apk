package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brr
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GBQ;
  public int HeM;
  public int HeN;
  public String HeO;
  public String md5;
  public String name;
  public String url;
  
  public brr()
  {
    AppMethodBeat.i(82447);
    this.GBQ = new LinkedList();
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
      paramVarArgs.e(4, 1, this.GBQ);
      paramVarArgs.aS(5, this.HeM);
      paramVarArgs.aS(6, this.HeN);
      if (this.HeO != null) {
        paramVarArgs.d(7, this.HeO);
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
      i = i + f.a.a.a.c(4, 1, this.GBQ) + f.a.a.b.b.a.bz(5, this.HeM) + f.a.a.b.b.a.bz(6, this.HeN);
      paramInt = i;
      if (this.HeO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HeO);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GBQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        brr localbrr = (brr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localbrr.name = locala.OmT.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localbrr.url = locala.OmT.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localbrr.md5 = locala.OmT.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localbrr.GBQ.add(locala.OmT.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localbrr.HeM = locala.OmT.zc();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localbrr.HeN = locala.OmT.zc();
          AppMethodBeat.o(82448);
          return 0;
        }
        localbrr.HeO = locala.OmT.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brr
 * JD-Core Version:    0.7.0.1
 */