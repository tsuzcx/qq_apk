package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class np
  extends com.tencent.mm.bx.a
{
  public String Adf;
  public LinkedList<np> CLn;
  public int gXs;
  public int id;
  public String key;
  public String name;
  public int type;
  public String value;
  
  public np()
  {
    AppMethodBeat.i(124457);
    this.CLn = new LinkedList();
    AppMethodBeat.o(124457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      paramVarArgs.aR(2, this.type);
      if (this.name != null) {
        paramVarArgs.d(3, this.name);
      }
      if (this.key != null) {
        paramVarArgs.d(4, this.key);
      }
      if (this.value != null) {
        paramVarArgs.d(5, this.value);
      }
      paramVarArgs.e(6, 8, this.CLn);
      paramVarArgs.aR(7, this.gXs);
      if (this.Adf != null) {
        paramVarArgs.d(8, this.Adf);
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.id) + 0 + f.a.a.b.b.a.bA(2, this.type);
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
      i = paramInt + f.a.a.a.c(6, 8, this.CLn) + f.a.a.b.b.a.bA(7, this.gXs);
      paramInt = i;
      if (this.Adf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Adf);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CLn.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      np localnp = (np)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localnp.id = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localnp.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localnp.name = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localnp.key = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localnp.value = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new np();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((np)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnp.CLn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localnp.gXs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124458);
        return 0;
      }
      localnp.Adf = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.np
 * JD-Core Version:    0.7.0.1
 */