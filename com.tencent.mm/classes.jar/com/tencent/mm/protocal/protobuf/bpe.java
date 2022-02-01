package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bpe
  extends com.tencent.mm.bx.a
{
  public LinkedList<FinderContact> ZXE;
  public int ZXF;
  
  public bpe()
  {
    AppMethodBeat.i(258081);
    this.ZXE = new LinkedList();
    AppMethodBeat.o(258081);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258086);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZXE);
      paramVarArgs.bS(2, this.ZXF);
      AppMethodBeat.o(258086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZXE);
      i = i.a.a.b.b.a.cJ(2, this.ZXF);
      AppMethodBeat.o(258086);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZXE.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bpe localbpe = (bpe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258086);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderContact localFinderContact = new FinderContact();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderContact.parseFrom((byte[])localObject);
          }
          localbpe.ZXE.add(localFinderContact);
          paramInt += 1;
        }
        AppMethodBeat.o(258086);
        return 0;
      }
      localbpe.ZXF = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258086);
      return 0;
    }
    AppMethodBeat.o(258086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpe
 * JD-Core Version:    0.7.0.1
 */