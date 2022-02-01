package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pb
  extends com.tencent.mm.bx.a
{
  public String CVO;
  public LinkedList<pb> FKo;
  public int hQm;
  public int id;
  public String key;
  public String name;
  public int type;
  public String value;
  
  public pb()
  {
    AppMethodBeat.i(124457);
    this.FKo = new LinkedList();
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
      paramVarArgs.e(6, 8, this.FKo);
      paramVarArgs.aS(7, this.hQm);
      if (this.CVO != null) {
        paramVarArgs.d(8, this.CVO);
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
      i = paramInt + f.a.a.a.c(6, 8, this.FKo) + f.a.a.b.b.a.bz(7, this.hQm);
      paramInt = i;
      if (this.CVO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CVO);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FKo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pb localpb = (pb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localpb.id = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localpb.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localpb.name = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localpb.key = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localpb.value = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpb.FKo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localpb.hQm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124458);
        return 0;
      }
      localpb.CVO = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pb
 * JD-Core Version:    0.7.0.1
 */