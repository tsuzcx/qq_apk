package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpn
  extends com.tencent.mm.bx.a
{
  public LinkedList<dck> Eja;
  public int Ejb;
  public String fMw;
  public int gOY;
  public int hyP;
  public String md5;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  public String wNY;
  
  public cpn()
  {
    AppMethodBeat.i(127174);
    this.Eja = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wNY == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Eja);
      if (this.wNY != null) {
        paramVarArgs.d(2, this.wNY);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      if (this.fMw != null) {
        paramVarArgs.d(4, this.fMw);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.gOY);
      paramVarArgs.aR(7, this.hyP);
      paramVarArgs.aR(8, this.Ejb);
      paramVarArgs.aR(9, this.thumbHeight);
      paramVarArgs.aR(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Eja) + 0;
      paramInt = i;
      if (this.wNY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wNY);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      paramInt = i;
      if (this.fMw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fMw);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.gOY);
      int j = f.a.a.b.b.a.bA(7, this.hyP);
      int k = f.a.a.b.b.a.bA(8, this.Ejb);
      int m = f.a.a.b.b.a.bA(9, this.thumbHeight);
      int n = f.a.a.b.b.a.bA(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eja.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.wNY == null)
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
      cpn localcpn = (cpn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dck();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcpn.Eja.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localcpn.wNY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localcpn.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localcpn.fMw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localcpn.url = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localcpn.gOY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localcpn.hyP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localcpn.Ejb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localcpn.thumbHeight = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127175);
        return 0;
      }
      localcpn.thumbWidth = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpn
 * JD-Core Version:    0.7.0.1
 */