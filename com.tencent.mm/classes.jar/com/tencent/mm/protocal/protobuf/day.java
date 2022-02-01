package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class day
  extends com.tencent.mm.bw.a
{
  public int GfX;
  public LinkedList<doj> HKb;
  public String gmb;
  public int hKI;
  public int ivG;
  public String md5;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  public String zHQ;
  
  public day()
  {
    AppMethodBeat.i(127174);
    this.HKb = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zHQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.HKb);
      if (this.zHQ != null) {
        paramVarArgs.d(2, this.zHQ);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      if (this.gmb != null) {
        paramVarArgs.d(4, this.gmb);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.hKI);
      paramVarArgs.aS(7, this.ivG);
      paramVarArgs.aS(8, this.GfX);
      paramVarArgs.aS(9, this.thumbHeight);
      paramVarArgs.aS(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.HKb) + 0;
      paramInt = i;
      if (this.zHQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.zHQ);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      paramInt = i;
      if (this.gmb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gmb);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.hKI);
      int j = f.a.a.b.b.a.bz(7, this.ivG);
      int k = f.a.a.b.b.a.bz(8, this.GfX);
      int m = f.a.a.b.b.a.bz(9, this.thumbHeight);
      int n = f.a.a.b.b.a.bz(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HKb.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.zHQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127175);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      day localday = (day)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((doj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localday.HKb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localday.zHQ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localday.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localday.gmb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localday.url = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localday.hKI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localday.ivG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localday.GfX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localday.thumbHeight = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127175);
        return 0;
      }
      localday.thumbWidth = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.day
 * JD-Core Version:    0.7.0.1
 */