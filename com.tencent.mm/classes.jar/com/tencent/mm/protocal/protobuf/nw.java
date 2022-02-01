package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nw
  extends com.tencent.mm.bw.a
{
  public String Bvz;
  public LinkedList<nw> EdP;
  public int hxR;
  public int id;
  public String key;
  public String name;
  public int type;
  public String value;
  
  public nw()
  {
    AppMethodBeat.i(124457);
    this.EdP = new LinkedList();
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
      paramVarArgs.e(6, 8, this.EdP);
      paramVarArgs.aR(7, this.hxR);
      if (this.Bvz != null) {
        paramVarArgs.d(8, this.Bvz);
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.id) + 0 + f.a.a.b.b.a.bx(2, this.type);
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
      i = paramInt + f.a.a.a.c(6, 8, this.EdP) + f.a.a.b.b.a.bx(7, this.hxR);
      paramInt = i;
      if (this.Bvz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Bvz);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EdP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nw localnw = (nw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localnw.id = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localnw.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localnw.name = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localnw.key = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localnw.value = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnw.EdP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localnw.hxR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124458);
        return 0;
      }
      localnw.Bvz = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nw
 * JD-Core Version:    0.7.0.1
 */