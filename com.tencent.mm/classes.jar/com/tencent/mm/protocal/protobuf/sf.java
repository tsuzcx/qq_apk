package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sf
  extends com.tencent.mm.bw.a
{
  public String Ghs;
  public LinkedList<String> Ght;
  
  public sf()
  {
    AppMethodBeat.i(72427);
    this.Ght = new LinkedList();
    AppMethodBeat.o(72427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghs != null) {
        paramVarArgs.d(1, this.Ghs);
      }
      paramVarArgs.e(2, 1, this.Ght);
      AppMethodBeat.o(72428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghs == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ghs) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.Ght);
      AppMethodBeat.o(72428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ght.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72428);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sf localsf = (sf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72428);
          return -1;
        case 1: 
          localsf.Ghs = locala.OmT.readString();
          AppMethodBeat.o(72428);
          return 0;
        }
        localsf.Ght.add(locala.OmT.readString());
        AppMethodBeat.o(72428);
        return 0;
      }
      AppMethodBeat.o(72428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sf
 * JD-Core Version:    0.7.0.1
 */