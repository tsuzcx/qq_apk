package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class no
  extends com.tencent.mm.bw.a
{
  public LinkedList<ecn> Gag;
  public LinkedList<String> Gai;
  public String Gaj;
  public String Gak;
  
  public no()
  {
    AppMethodBeat.i(188924);
    this.Gag = new LinkedList();
    this.Gai = new LinkedList();
    AppMethodBeat.o(188924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.Gag);
      paramVarArgs.e(17, 1, this.Gai);
      if (this.Gaj != null) {
        paramVarArgs.d(18, this.Gaj);
      }
      if (this.Gak != null) {
        paramVarArgs.d(19, this.Gak);
      }
      AppMethodBeat.o(188925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(15, 8, this.Gag) + 0 + f.a.a.a.c(17, 1, this.Gai);
      paramInt = i;
      if (this.Gaj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Gaj);
      }
      i = paramInt;
      if (this.Gak != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Gak);
      }
      AppMethodBeat.o(188925);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gag.clear();
      this.Gai.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      no localno = (no)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(188925);
        return -1;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ecn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localno.Gag.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188925);
        return 0;
      case 17: 
        localno.Gai.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(188925);
        return 0;
      case 18: 
        localno.Gaj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188925);
        return 0;
      }
      localno.Gak = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(188925);
      return 0;
    }
    AppMethodBeat.o(188925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */