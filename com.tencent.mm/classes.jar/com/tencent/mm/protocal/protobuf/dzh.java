package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dzh
  extends com.tencent.mm.bx.a
{
  public int EN;
  public b Gdx;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.EN);
      if (this.uuid != null) {
        paramVarArgs.d(2, this.uuid);
      }
      if (this.Gdx != null) {
        paramVarArgs.c(3, this.Gdx);
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.EN) + 0;
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuid);
      }
      i = paramInt;
      if (this.Gdx != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Gdx);
      }
      AppMethodBeat.o(147789);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzh localdzh = (dzh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147789);
        return -1;
      case 1: 
        localdzh.EN = locala.NPN.zc();
        AppMethodBeat.o(147789);
        return 0;
      case 2: 
        localdzh.uuid = locala.NPN.readString();
        AppMethodBeat.o(147789);
        return 0;
      }
      localdzh.Gdx = locala.NPN.gxI();
      AppMethodBeat.o(147789);
      return 0;
    }
    AppMethodBeat.o(147789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzh
 * JD-Core Version:    0.7.0.1
 */