package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwl
  extends com.tencent.mm.bw.a
{
  public LinkedList<dwm> GmO;
  public int HUY;
  public String Hzn;
  public String dwb;
  public String dyI;
  public int version;
  
  public dwl()
  {
    AppMethodBeat.i(176154);
    this.GmO = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GmO);
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      paramVarArgs.aS(3, this.HUY);
      if (this.Hzn != null) {
        paramVarArgs.d(4, this.Hzn);
      }
      if (this.dwb != null) {
        paramVarArgs.d(5, this.dwb);
      }
      paramVarArgs.aS(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GmO) + 0;
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.HUY);
      paramInt = i;
      if (this.Hzn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hzn);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dwb);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GmO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwl localdwl = (dwl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dwm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwl.GmO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localdwl.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localdwl.HUY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localdwl.Hzn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localdwl.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localdwl.version = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwl
 * JD-Core Version:    0.7.0.1
 */