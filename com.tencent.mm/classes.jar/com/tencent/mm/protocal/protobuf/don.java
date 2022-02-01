package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class don
  extends com.tencent.mm.bw.a
{
  public int Category;
  public int HDj;
  public LinkedList<String> HDl;
  public long HVt;
  public int HVu;
  public String hFS;
  
  public don()
  {
    AppMethodBeat.i(152998);
    this.HDl = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hFS != null) {
        paramVarArgs.d(1, this.hFS);
      }
      paramVarArgs.aZ(2, this.HVt);
      paramVarArgs.aS(3, this.HDj);
      paramVarArgs.aS(4, this.HVu);
      paramVarArgs.aS(5, this.Category);
      paramVarArgs.e(6, 1, this.HDl);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hFS == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.hFS) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HVt);
      int j = f.a.a.b.b.a.bz(3, this.HDj);
      int k = f.a.a.b.b.a.bz(4, this.HVu);
      int m = f.a.a.b.b.a.bz(5, this.Category);
      int n = f.a.a.a.c(6, 1, this.HDl);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HDl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        don localdon = (don)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localdon.hFS = locala.OmT.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localdon.HVt = locala.OmT.zd();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localdon.HDj = locala.OmT.zc();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localdon.HVu = locala.OmT.zc();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localdon.Category = locala.OmT.zc();
          AppMethodBeat.o(152999);
          return 0;
        }
        localdon.HDl.add(locala.OmT.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.don
 * JD-Core Version:    0.7.0.1
 */