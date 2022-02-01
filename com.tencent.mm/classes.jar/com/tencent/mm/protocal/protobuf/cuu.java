package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cuu
  extends com.tencent.mm.bw.a
{
  public LinkedList<dhx> FFY;
  public int FFZ;
  public String fQi;
  public int hZq;
  public int hpy;
  public String md5;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  public String yaF;
  
  public cuu()
  {
    AppMethodBeat.i(127174);
    this.FFY = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.FFY);
      if (this.yaF != null) {
        paramVarArgs.d(2, this.yaF);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      if (this.fQi != null) {
        paramVarArgs.d(4, this.fQi);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.hpy);
      paramVarArgs.aR(7, this.hZq);
      paramVarArgs.aR(8, this.FFZ);
      paramVarArgs.aR(9, this.thumbHeight);
      paramVarArgs.aR(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FFY) + 0;
      paramInt = i;
      if (this.yaF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yaF);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      paramInt = i;
      if (this.fQi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fQi);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.hpy);
      int j = f.a.a.b.b.a.bx(7, this.hZq);
      int k = f.a.a.b.b.a.bx(8, this.FFZ);
      int m = f.a.a.b.b.a.bx(9, this.thumbHeight);
      int n = f.a.a.b.b.a.bx(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FFY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.yaF == null)
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
      cuu localcuu = (cuu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dhx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcuu.FFY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localcuu.yaF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localcuu.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localcuu.fQi = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localcuu.url = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localcuu.hpy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localcuu.hZq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localcuu.FFZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localcuu.thumbHeight = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127175);
        return 0;
      }
      localcuu.thumbWidth = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuu
 * JD-Core Version:    0.7.0.1
 */