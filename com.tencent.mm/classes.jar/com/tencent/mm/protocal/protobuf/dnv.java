package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnv
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> HUX;
  public int HUY;
  public LinkedList<cdr> Hzm;
  public String Hzn;
  public String dwb;
  public String dyI;
  public int version;
  
  public dnv()
  {
    AppMethodBeat.i(176151);
    this.HUX = new LinkedList();
    this.Hzm = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.HUX);
      paramVarArgs.e(2, 8, this.Hzm);
      if (this.dyI != null) {
        paramVarArgs.d(3, this.dyI);
      }
      paramVarArgs.aS(4, this.HUY);
      if (this.Hzn != null) {
        paramVarArgs.d(5, this.Hzn);
      }
      if (this.dwb != null) {
        paramVarArgs.d(6, this.dwb);
      }
      paramVarArgs.aS(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.HUX) + 0 + f.a.a.a.c(2, 8, this.Hzm);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dyI);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HUY);
      paramInt = i;
      if (this.Hzn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hzn);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dwb);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HUX.clear();
      this.Hzm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dnv localdnv = (dnv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localdnv.HUX.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdnv.Hzm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localdnv.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localdnv.HUY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localdnv.Hzn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localdnv.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localdnv.version = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnv
 * JD-Core Version:    0.7.0.1
 */