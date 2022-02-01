package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pd
  extends com.tencent.mm.bw.a
{
  public String Dnu;
  public LinkedList<pd> GcN;
  public int hTe;
  public int id;
  public String key;
  public String name;
  public int type;
  public String value;
  
  public pd()
  {
    AppMethodBeat.i(124457);
    this.GcN = new LinkedList();
    AppMethodBeat.o(124457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      paramVarArgs.aS(2, this.type);
      if (this.name != null) {
        paramVarArgs.d(3, this.name);
      }
      if (this.key != null) {
        paramVarArgs.d(4, this.key);
      }
      if (this.value != null) {
        paramVarArgs.d(5, this.value);
      }
      paramVarArgs.e(6, 8, this.GcN);
      paramVarArgs.aS(7, this.hTe);
      if (this.Dnu != null) {
        paramVarArgs.d(8, this.Dnu);
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.id) + 0 + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.name);
      }
      i = paramInt;
      if (this.key != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.key);
      }
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.value);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.GcN) + f.a.a.b.b.a.bz(7, this.hTe);
      paramInt = i;
      if (this.Dnu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dnu);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GcN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pd localpd = (pd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localpd.id = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localpd.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localpd.name = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localpd.key = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localpd.value = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpd.GcN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localpd.hTe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124458);
        return 0;
      }
      localpd.Dnu = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pd
 * JD-Core Version:    0.7.0.1
 */