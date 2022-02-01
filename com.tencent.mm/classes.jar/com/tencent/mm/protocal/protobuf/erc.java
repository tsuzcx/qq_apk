package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erc
  extends com.tencent.mm.bw.a
{
  public LinkedList<Float> LOe;
  
  public erc()
  {
    AppMethodBeat.i(140932);
    this.LOe = new LinkedList();
    AppMethodBeat.o(140932);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140933);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 5, this.LOe);
      AppMethodBeat.o(140933);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 5, this.LOe);
      AppMethodBeat.o(140933);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LOe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(140933);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      erc localerc = (erc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(140933);
        return -1;
      }
      localerc.LOe.add(Float.valueOf(Float.intBitsToFloat(locala.UbS.zm())));
      AppMethodBeat.o(140933);
      return 0;
    }
    AppMethodBeat.o(140933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erc
 * JD-Core Version:    0.7.0.1
 */