package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mo
  extends com.tencent.mm.bx.a
{
  public String CJA;
  public LinkedList<dpl> CJw;
  public LinkedList<String> CJy;
  public String CJz;
  
  public mo()
  {
    AppMethodBeat.i(191089);
    this.CJw = new LinkedList();
    this.CJy = new LinkedList();
    AppMethodBeat.o(191089);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191090);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.CJw);
      paramVarArgs.e(17, 1, this.CJy);
      if (this.CJz != null) {
        paramVarArgs.d(18, this.CJz);
      }
      if (this.CJA != null) {
        paramVarArgs.d(19, this.CJA);
      }
      AppMethodBeat.o(191090);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(15, 8, this.CJw) + 0 + f.a.a.a.c(17, 1, this.CJy);
      paramInt = i;
      if (this.CJz != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.CJz);
      }
      i = paramInt;
      if (this.CJA != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.CJA);
      }
      AppMethodBeat.o(191090);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CJw.clear();
      this.CJy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(191090);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mo localmo = (mo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(191090);
        return -1;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dpl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmo.CJw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(191090);
        return 0;
      case 17: 
        localmo.CJy.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(191090);
        return 0;
      case 18: 
        localmo.CJz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(191090);
        return 0;
      }
      localmo.CJA = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(191090);
      return 0;
    }
    AppMethodBeat.o(191090);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mo
 * JD-Core Version:    0.7.0.1
 */